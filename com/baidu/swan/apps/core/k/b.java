package com.baidu.swan.apps.core.k;

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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cml;
    private Context mContext;
    private volatile boolean cmm = false;
    private boolean cmn = false;
    private boolean cmo = false;
    private final Object cmp = new Object();
    private final Object cmq = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes8.dex */
    public interface a {
        void Yx();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bT(Context context) {
        b bVar;
        synchronized (b.class) {
            if (cml == null) {
                cml = new b(context);
            }
            bVar = cml;
        }
        return bVar;
    }

    public void onTerminate() {
        if (ajx()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void ed(boolean z) {
        n(false, z);
    }

    public void ajw() {
        n(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void n(boolean z, final boolean z2) {
        if (!this.cmm) {
            synchronized (this.cmp) {
                if (!this.cmn) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.ee(z2);
                            b.this.cmm = true;
                            synchronized (b.this.cmq) {
                                b.this.cmo = true;
                                b.this.cmq.notifyAll();
                                b.this.ajy();
                            }
                        }
                    });
                    this.cmn = true;
                }
            }
            if (z) {
                synchronized (this.cmq) {
                    while (!this.cmo) {
                        try {
                            this.cmq.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.mContext, null, null);
        if (DEBUG) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.2
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

    public boolean ajx() {
        return this.cmm;
    }

    public void a(a aVar) {
        synchronized (this.cmq) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.cmo) {
                ajy();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.cmq) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void ajy() {
        synchronized (this.cmq) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().Yx();
            }
            this.mListeners.clear();
        }
    }
}
