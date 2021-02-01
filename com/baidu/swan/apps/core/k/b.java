package com.baidu.swan.apps.core.k;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cWC;
    private Context mContext;
    private volatile boolean cWD = false;
    private boolean cWE = false;
    private boolean cWF = false;
    private final Object cWG = new Object();
    private final Object cWH = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface a {
        void agz();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b cK(Context context) {
        b bVar;
        synchronized (b.class) {
            if (cWC == null) {
                cWC = new b(context);
            }
            bVar = cWC;
        }
        return bVar;
    }

    public void onTerminate() {
        if (arI()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void ft(boolean z) {
        o(false, z);
    }

    public void arH() {
        o(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void o(boolean z, final boolean z2) {
        if (!this.cWD) {
            synchronized (this.cWG) {
                if (!this.cWE) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.fu(z2);
                            b.this.cWD = true;
                            synchronized (b.this.cWH) {
                                b.this.cWF = true;
                                b.this.cWH.notifyAll();
                                b.this.arJ();
                            }
                        }
                    });
                    this.cWE = true;
                }
            }
            if (z) {
                synchronized (this.cWH) {
                    while (!this.cWF) {
                        try {
                            this.cWH.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(boolean z) {
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
        BdSailor.getInstance().initWebkit(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, false);
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

    public boolean arI() {
        return this.cWD;
    }

    public void a(a aVar) {
        synchronized (this.cWH) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.cWF) {
                arJ();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.cWH) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void arJ() {
        synchronized (this.cWH) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().agz();
            }
            this.mListeners.clear();
        }
    }
}
