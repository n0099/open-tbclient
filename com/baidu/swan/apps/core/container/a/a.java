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
/* loaded from: classes8.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile boolean cOB;
    private volatile boolean cOC;
    private int cOD;
    private InterfaceC0405a cOE;
    private WebKitFactory.IForceInitZeusListener cOF;
    private ArrayList<com.baidu.swan.apps.core.container.a.b> mListeners;
    private final Lock mLock;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0405a {
        void agb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        public static final a cOH = new a();
    }

    private a() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.cOB = false;
        this.cOC = false;
        this.cOD = -1;
        this.cOE = new InterfaceC0405a() { // from class: com.baidu.swan.apps.core.container.a.a.1
            @Override // com.baidu.swan.apps.core.container.a.a.InterfaceC0405a
            public void agb() {
                try {
                    a.this.mLock.lock();
                    a.this.cOC = true;
                    a.this.anz();
                    a.this.anC();
                } finally {
                    a.this.mLock.unlock();
                }
            }
        };
        this.cOF = new WebKitFactory.IForceInitZeusListener() { // from class: com.baidu.swan.apps.core.container.a.a.2
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
                    a.this.cOB = true;
                    a.this.anC();
                    a.this.mLock.unlock();
                    BdSailor.getInstance().removeForceInitListener(a.this.cOF);
                } catch (Throwable th) {
                    a.this.mLock.unlock();
                    throw th;
                }
            }
        };
        BdSailor.addForceInitListener(this.cOF);
        com.baidu.swan.apps.t.a.awV().a(this.cOE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anz() {
        if (this.cOD == -1) {
            this.cOD = com.baidu.swan.apps.t.a.awB().getSwitch("swan_enable_file_in_io", 0);
        }
        if (!ProcessUtils.isMainProcess() && this.cOD == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public static a anA() {
        return b.cOH;
    }

    public void anB() {
        fd(false);
    }

    public void fd(boolean z) {
        com.baidu.swan.apps.t.a.awV().eF(z);
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
                    anC();
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
    public void anC() {
        try {
            this.mLock.lock();
            if (isLoaded()) {
                Iterator<com.baidu.swan.apps.core.container.a.b> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.core.container.a.b next = it.next();
                    if (next != null) {
                        next.agb();
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
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.cOC);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.cOB + " ,isZeusForceInited: " + isZeusForceInited());
            }
            if (this.cOC) {
                if (!this.cOB) {
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
