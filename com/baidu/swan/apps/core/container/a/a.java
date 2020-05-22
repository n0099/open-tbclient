package com.baidu.swan.apps.core.container.a;

import android.util.Log;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WebKitFactory.IForceInitZeusListener bUA;
    private volatile boolean bUx;
    private volatile boolean bUy;
    private InterfaceC0333a bUz;
    private ArrayList<com.baidu.swan.apps.core.container.a.b> mListeners;
    private final Lock mLock;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0333a {
        void Rf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        public static final a bUC = new a();
    }

    private a() {
        this.mListeners = new ArrayList<>();
        this.mLock = new ReentrantLock();
        this.bUx = false;
        this.bUy = false;
        this.bUz = new InterfaceC0333a() { // from class: com.baidu.swan.apps.core.container.a.a.1
            @Override // com.baidu.swan.apps.core.container.a.a.InterfaceC0333a
            public void Rf() {
                try {
                    a.this.mLock.lock();
                    a.this.bUy = true;
                    a.this.XN();
                } finally {
                    a.this.mLock.unlock();
                }
            }
        };
        this.bUA = new WebKitFactory.IForceInitZeusListener() { // from class: com.baidu.swan.apps.core.container.a.a.2
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
                    a.this.bUx = true;
                    a.this.XN();
                    a.this.mLock.unlock();
                    BdSailor.getInstance().removeForceInitListener(a.this.bUA);
                } catch (Throwable th) {
                    a.this.mLock.unlock();
                    throw th;
                }
            }
        };
        BdSailor.addForceInitListener(this.bUA);
        com.baidu.swan.apps.u.a.afn().a(this.bUz);
    }

    public static a XL() {
        return b.bUC;
    }

    public void XM() {
        dx(false);
    }

    public void dx(boolean z) {
        com.baidu.swan.apps.u.a.afn().dc(z);
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
                    XN();
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
    public void XN() {
        try {
            this.mLock.lock();
            if (isLoaded()) {
                Iterator<com.baidu.swan.apps.core.container.a.b> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.core.container.a.b next = it.next();
                    if (next != null) {
                        next.Rf();
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
                Log.d("NgWebViewInitHelper", "isLoaded() mIsBlinkInited: " + this.bUy);
                Log.d("NgWebViewInitHelper", "isLoaded() mIsZeusForceInited: " + this.bUx + " ,isZeusForceInited: " + isZeusForceInited());
            }
            if (this.bUy) {
                if (!this.bUx) {
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
