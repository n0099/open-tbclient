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
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bPI;
    private Context mContext;
    private volatile boolean bPJ = false;
    private boolean bPK = false;
    private boolean bPL = false;
    private final Object bPM = new Object();
    private final Object bPN = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void OU();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bz(Context context) {
        b bVar;
        synchronized (b.class) {
            if (bPI == null) {
                bPI = new b(context);
            }
            bVar = bPI;
        }
        return bVar;
    }

    public void onTerminate() {
        if (XT()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void dv(boolean z) {
        k(false, z);
    }

    public void OS() {
        k(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void k(boolean z, final boolean z2) {
        if (!this.bPJ) {
            synchronized (this.bPM) {
                if (!this.bPK) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.dw(z2);
                            b.this.bPJ = true;
                            synchronized (b.this.bPN) {
                                b.this.bPL = true;
                                b.this.bPN.notifyAll();
                                b.this.XU();
                            }
                        }
                    });
                    this.bPK = true;
                }
            }
            if (z) {
                synchronized (this.bPN) {
                    while (!this.bPL) {
                        try {
                            this.bPN.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
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

    public boolean XT() {
        return this.bPJ;
    }

    public void a(a aVar) {
        synchronized (this.bPN) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.bPL) {
                XU();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.bPN) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void XU() {
        synchronized (this.bPN) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().OU();
            }
            this.mListeners.clear();
        }
    }
}
