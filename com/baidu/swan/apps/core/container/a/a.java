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
/* loaded from: classes3.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile boolean ciB;
    private volatile boolean ciC;
    private int ciD;
    private InterfaceC0377a ciE;
    private WebKitFactory.IForceInitZeusListener ciF;
    private ArrayList<com.baidu.swan.apps.core.container.a.b> mListeners;
    private final Lock mLock;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0377a {
        void Zg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        public static final a ciH = new a();
    }

    private a() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.ciB = false;
        this.ciC = false;
        this.ciD = -1;
        this.ciE = new InterfaceC0377a() { // from class: com.baidu.swan.apps.core.container.a.a.1
            @Override // com.baidu.swan.apps.core.container.a.a.InterfaceC0377a
            public void Zg() {
                try {
                    a.this.mLock.lock();
                    a.this.ciC = true;
                    a.this.agC();
                    a.this.agF();
                } finally {
                    a.this.mLock.unlock();
                }
            }
        };
        this.ciF = new WebKitFactory.IForceInitZeusListener() { // from class: com.baidu.swan.apps.core.container.a.a.2
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
                    a.this.ciB = true;
                    a.this.agF();
                    a.this.mLock.unlock();
                    BdSailor.getInstance().removeForceInitListener(a.this.ciF);
                } catch (Throwable th) {
                    a.this.mLock.unlock();
                    throw th;
                }
            }
        };
        BdSailor.addForceInitListener(this.ciF);
        com.baidu.swan.apps.t.a.apR().a(this.ciE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void agC() {
        if (this.ciD == -1) {
            this.ciD = com.baidu.swan.apps.t.a.apx().getSwitch("swan_enable_file_in_io", 0);
        }
        if (!ProcessUtils.isMainProcess() && this.ciD == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public static a agD() {
        return b.ciH;
    }

    public void agE() {
        dO(false);
    }

    public void dO(boolean z) {
        com.baidu.swan.apps.t.a.apR().dr(z);
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
                    agF();
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
    public void agF() {
        try {
            this.mLock.lock();
            if (isLoaded()) {
                Iterator<com.baidu.swan.apps.core.container.a.b> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.core.container.a.b next = it.next();
                    if (next != null) {
                        next.Zg();
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
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.ciC);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.ciB + " ,isZeusForceInited: " + isZeusForceInited());
            }
            if (this.ciC) {
                if (!this.ciB) {
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
