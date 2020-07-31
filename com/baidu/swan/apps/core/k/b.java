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
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cfT;
    private Context mContext;
    private volatile boolean cfU = false;
    private boolean cfV = false;
    private boolean cfW = false;
    private final Object cfX = new Object();
    private final Object cfY = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface a {
        void SC();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bM(Context context) {
        b bVar;
        synchronized (b.class) {
            if (cfT == null) {
                cfT = new b(context);
            }
            bVar = cfT;
        }
        return bVar;
    }

    public void onTerminate() {
        if (acY()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void dT(boolean z) {
        l(false, z);
    }

    public void acX() {
        l(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void l(boolean z, final boolean z2) {
        if (!this.cfU) {
            synchronized (this.cfX) {
                if (!this.cfV) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.dU(z2);
                            b.this.cfU = true;
                            synchronized (b.this.cfY) {
                                b.this.cfW = true;
                                b.this.cfY.notifyAll();
                                b.this.acZ();
                            }
                        }
                    });
                    this.cfV = true;
                }
            }
            if (z) {
                synchronized (this.cfY) {
                    while (!this.cfW) {
                        try {
                            this.cfY.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(boolean z) {
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

    public boolean acY() {
        return this.cfU;
    }

    public void a(a aVar) {
        synchronized (this.cfY) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.cfW) {
                acZ();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.cfY) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void acZ() {
        synchronized (this.cfY) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().SC();
            }
            this.mListeners.clear();
        }
    }
}
