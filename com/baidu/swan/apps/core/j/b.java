package com.baidu.swan.apps.core.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bmZ;
    private Context mContext;
    private volatile boolean bna = false;
    private boolean bnb = false;
    private boolean bnc = false;
    private final Object bnd = new Object();
    private final Object bne = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void EM();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bU(Context context) {
        b bVar;
        synchronized (b.class) {
            if (bmZ == null) {
                bmZ = new b(context);
            }
            bVar = bmZ;
        }
        return bVar;
    }

    public void onTerminate() {
        if (NM()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void cr(boolean z) {
        i(false, z);
    }

    public void EK() {
        i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void i(boolean z, final boolean z2) {
        if (!this.bna) {
            synchronized (this.bnd) {
                if (!this.bnb) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.cs(z2);
                            b.this.bna = true;
                            synchronized (b.this.bne) {
                                b.this.bnc = true;
                                b.this.bne.notifyAll();
                                b.this.NN();
                            }
                        }
                    });
                    this.bnb = true;
                }
            }
            if (z) {
                synchronized (this.bne) {
                    while (!this.bnc) {
                        try {
                            this.bne.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.mContext, null, null);
        if (DEBUG) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.2
                @Override // java.lang.Runnable
                public void run() {
                    android.webkit.WebView.setWebContentsDebuggingEnabled(true);
                    Log.setMinLogLevel(3, true);
                }
            });
        }
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().setWebkitEnable(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (DEBUG) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.mContext);
        BdSailor.initCookieSyncManager(this.mContext);
    }

    public boolean NM() {
        return this.bna;
    }

    public void a(a aVar) {
        synchronized (this.bne) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.bnc) {
                NN();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.bne) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void NN() {
        synchronized (this.bne) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().EM();
            }
            this.mListeners.clear();
        }
    }
}
