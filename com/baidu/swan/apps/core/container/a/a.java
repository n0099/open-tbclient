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
    private volatile boolean cgv;
    private volatile boolean cgw;
    private int cgx;
    private InterfaceC0382a cgy;
    private WebKitFactory.IForceInitZeusListener cgz;
    private ArrayList<com.baidu.swan.apps.core.container.a.b> mListeners;
    private final Lock mLock;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0382a {
        void Yx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        public static final a cgB = new a();
    }

    private a() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.cgv = false;
        this.cgw = false;
        this.cgx = -1;
        this.cgy = new InterfaceC0382a() { // from class: com.baidu.swan.apps.core.container.a.a.1
            @Override // com.baidu.swan.apps.core.container.a.a.InterfaceC0382a
            public void Yx() {
                try {
                    a.this.mLock.lock();
                    a.this.cgw = true;
                    a.this.afS();
                    a.this.afV();
                } finally {
                    a.this.mLock.unlock();
                }
            }
        };
        this.cgz = new WebKitFactory.IForceInitZeusListener() { // from class: com.baidu.swan.apps.core.container.a.a.2
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
                    a.this.cgv = true;
                    a.this.afV();
                    a.this.mLock.unlock();
                    BdSailor.getInstance().removeForceInitListener(a.this.cgz);
                } catch (Throwable th) {
                    a.this.mLock.unlock();
                    throw th;
                }
            }
        };
        BdSailor.addForceInitListener(this.cgz);
        com.baidu.swan.apps.t.a.apg().a(this.cgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afS() {
        if (this.cgx == -1) {
            this.cgx = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_enable_file_in_io", 0);
        }
        if (!ProcessUtils.isMainProcess() && this.cgx == 1) {
            WebSettingsGlobalBlink.setFileInIOEnabled(true);
        }
    }

    public static a afT() {
        return b.cgB;
    }

    public void afU() {
        dP(false);
    }

    public void dP(boolean z) {
        com.baidu.swan.apps.t.a.apg().ds(z);
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
                    afV();
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
    public void afV() {
        try {
            this.mLock.lock();
            if (isLoaded()) {
                Iterator<com.baidu.swan.apps.core.container.a.b> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.core.container.a.b next = it.next();
                    if (next != null) {
                        next.Yx();
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
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.cgw);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.cgv + " ,isZeusForceInited: " + isZeusForceInited());
            }
            if (this.cgw) {
                if (!this.cgv) {
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
