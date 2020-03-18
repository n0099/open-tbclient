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
    private static volatile b brw;
    private Context mContext;
    private volatile boolean brx = false;
    private boolean bry = false;
    private boolean brz = false;
    private final Object brA = new Object();
    private final Object brB = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Hi();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bX(Context context) {
        b bVar;
        synchronized (b.class) {
            if (brw == null) {
                brw = new b(context);
            }
            bVar = brw;
        }
        return bVar;
    }

    public void onTerminate() {
        if (Qf()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void cz(boolean z) {
        l(false, z);
    }

    public void Hg() {
        l(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void l(boolean z, final boolean z2) {
        if (!this.brx) {
            synchronized (this.brA) {
                if (!this.bry) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.cA(z2);
                            b.this.brx = true;
                            synchronized (b.this.brB) {
                                b.this.brz = true;
                                b.this.brB.notifyAll();
                                b.this.Qg();
                            }
                        }
                    });
                    this.bry = true;
                }
            }
            if (z) {
                synchronized (this.brB) {
                    while (!this.brz) {
                        try {
                            this.brB.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(boolean z) {
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

    public boolean Qf() {
        return this.brx;
    }

    public void a(a aVar) {
        synchronized (this.brB) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.brz) {
                Qg();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.brB) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void Qg() {
        synchronized (this.brB) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().Hi();
            }
            this.mListeners.clear();
        }
    }
}
