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
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cOW;
    private Context mContext;
    private volatile boolean cOX = false;
    private boolean cOY = false;
    private boolean cOZ = false;
    private final Object cPa = new Object();
    private final Object cPb = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void agm();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bY(Context context) {
        b bVar;
        synchronized (b.class) {
            if (cOW == null) {
                cOW = new b(context);
            }
            bVar = cOW;
        }
        return bVar;
    }

    public void onTerminate() {
        if (arn()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void eU(boolean z) {
        n(false, z);
    }

    public void arm() {
        n(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void n(boolean z, final boolean z2) {
        if (!this.cOX) {
            synchronized (this.cPa) {
                if (!this.cOY) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.k.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.eV(z2);
                            b.this.cOX = true;
                            synchronized (b.this.cPb) {
                                b.this.cOZ = true;
                                b.this.cPb.notifyAll();
                                b.this.aro();
                            }
                        }
                    });
                    this.cOY = true;
                }
            }
            if (z) {
                synchronized (this.cPb) {
                    while (!this.cOZ) {
                        try {
                            this.cPb.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(boolean z) {
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

    public boolean arn() {
        return this.cOX;
    }

    public void a(a aVar) {
        synchronized (this.cPb) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.cOZ) {
                aro();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.cPb) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void aro() {
        synchronized (this.cPb) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().agm();
            }
            this.mListeners.clear();
        }
    }
}
