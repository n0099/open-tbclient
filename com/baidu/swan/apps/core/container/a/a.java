package com.baidu.swan.apps.core.container.a;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile boolean cJj;
    private volatile boolean cJk;
    private int cJl;
    private InterfaceC0420a cJm;
    private WebKitFactory.IForceInitZeusListener cJn;
    private ArrayList<com.baidu.swan.apps.core.container.a.b> mListeners;
    private final Lock mLock;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0420a {
        void agm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        public static final a cJp = new a();
    }

    private a() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.cJj = false;
        this.cJk = false;
        this.cJl = -1;
        this.cJm = new InterfaceC0420a() { // from class: com.baidu.swan.apps.core.container.a.a.1
            @Override // com.baidu.swan.apps.core.container.a.a.InterfaceC0420a
            public void agm() {
                try {
                    a.this.mLock.lock();
                    a.this.cJk = true;
                    a.this.anH();
                    a.this.anK();
                } finally {
                    a.this.mLock.unlock();
                }
            }
        };
        this.cJn = new WebKitFactory.IForceInitZeusListener() { // from class: com.baidu.swan.apps.core.container.a.a.2
            @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
            public void onForceInitZeusStart() {
                if (a.DEBUG) {
                    Log.d("NgWebViewInitHelper", "onForceInitZeusStart");
                }
            }

            @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
            public void onForceInitZeusFinish(boolean z) {
                try {
                    a.this.mLock.lock();
                    a.this.cJj = true;
                    a.this.anK();
                    a.this.mLock.unlock();
                    BdSailor.getInstance().removeForceInitListener(a.this.cJn);
                } catch (Throwable th) {
                    a.this.mLock.unlock();
                    throw th;
                }
            }
        };
        BdSailor.addForceInitListener(this.cJn);
        com.baidu.swan.apps.t.a.awX().a(this.cJm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anH() {
        if (this.cJl == -1) {
            this.cJl = com.baidu.swan.apps.t.a.awD().getSwitch("swan_enable_file_in_io", 0);
        }
        if (!ProcessUtils.isMainProcess() && this.cJl == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public static a anI() {
        return b.cJp;
    }

    public void anJ() {
        eG(false);
    }

    public void eG(boolean z) {
        com.baidu.swan.apps.t.a.awX().ej(z);
    }

    @Override // com.baidu.swan.apps.adaptation.b.i
    public void a(com.baidu.swan.apps.core.container.a.b bVar) {
        try {
            this.mLock.lock();
            if (bVar != null) {
                if (!this.mListeners.contains(bVar)) {
                    this.mListeners.add(bVar);
                }
                if (isLoaded()) {
                    anK();
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.i
    public void b(com.baidu.swan.apps.core.container.a.b bVar) {
        try {
            this.mLock.lock();
            if (bVar != null && this.mListeners.contains(bVar)) {
                this.mListeners.remove(bVar);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anK() {
        try {
            this.mLock.lock();
            if (isLoaded()) {
                Iterator<com.baidu.swan.apps.core.container.a.b> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.core.container.a.b next = it.next();
                    if (next != null) {
                        next.agm();
                    }
                }
                this.mListeners.clear();
            }
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
        if (isZeusForceInited() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isLoaded() {
        boolean z;
        try {
            this.mLock.lock();
            if (DEBUG) {
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.cJk);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.cJj + " ,isZeusForceInited: " + isZeusForceInited());
            }
            if (this.cJk) {
                if (!this.cJj) {
                }
                z = true;
                return z;
            }
            z = false;
            return z;
        } finally {
            this.mLock.unlock();
        }
    }

    private boolean isZeusForceInited() {
        if (DEBUG) {
            Log.d("NgWebViewInitHelper", "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit());
            Log.d("NgWebViewInitHelper", "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited());
        }
        return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
    }
}
