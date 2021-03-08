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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cYc;
    private Context mContext;
    private volatile boolean cYd = false;
    private boolean cYe = false;
    private boolean cYf = false;
    private final Object cYg = new Object();
    private final Object cYh = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes8.dex */
    public interface a {
        void agC();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b cJ(Context context) {
        b bVar;
        synchronized (b.class) {
            if (cYc == null) {
                cYc = new b(context);
            }
            bVar = cYc;
        }
        return bVar;
    }

    public void onTerminate() {
        if (arL()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void ft(boolean z) {
        o(false, z);
    }

    public void arK() {
        o(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void o(boolean z, final boolean z2) {
        if (!this.cYd) {
            synchronized (this.cYg) {
                if (!this.cYe) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.fu(z2);
                            b.this.cYd = true;
                            synchronized (b.this.cYh) {
                                b.this.cYf = true;
                                b.this.cYh.notifyAll();
                                b.this.arM();
                            }
                        }
                    });
                    this.cYe = true;
                }
            }
            if (z) {
                synchronized (this.cYh) {
                    while (!this.cYf) {
                        try {
                            this.cYh.wait(1000L);
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

    public boolean arL() {
        return this.cYd;
    }

    public void a(a aVar) {
        synchronized (this.cYh) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.cYf) {
                arM();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.cYh) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void arM() {
        synchronized (this.cYh) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().agC();
            }
            this.mListeners.clear();
        }
    }
}
