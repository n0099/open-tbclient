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
    private static volatile b brj;
    private Context mContext;
    private volatile boolean brk = false;
    private boolean brl = false;
    private boolean brm = false;
    private final Object brn = new Object();
    private final Object bro = new Object();
    private ArrayList<a> mListeners = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Hd();
    }

    private b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized b bY(Context context) {
        b bVar;
        synchronized (b.class) {
            if (brj == null) {
                brj = new b(context);
            }
            bVar = brj;
        }
        return bVar;
    }

    public void onTerminate() {
        if (Qc()) {
            BdSailor.getInstance().destroy();
        }
    }

    public void cy(boolean z) {
        k(false, z);
    }

    public void Hb() {
        k(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    private void k(boolean z, final boolean z2) {
        if (!this.brk) {
            synchronized (this.brn) {
                if (!this.brl) {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            b.this.cz(z2);
                            b.this.brk = true;
                            synchronized (b.this.bro) {
                                b.this.brm = true;
                                b.this.bro.notifyAll();
                                b.this.Qd();
                            }
                        }
                    });
                    this.brl = true;
                }
            }
            if (z) {
                synchronized (this.bro) {
                    while (!this.brm) {
                        try {
                            this.bro.wait(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(boolean z) {
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

    public boolean Qc() {
        return this.brk;
    }

    public void a(a aVar) {
        synchronized (this.bro) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.mListeners.contains(aVar)) {
                this.mListeners.add(aVar);
            }
            if (this.brm) {
                Qd();
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.bro) {
            boolean remove = this.mListeners.remove(aVar);
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + aVar + " ,isRemoved: " + remove);
            }
        }
    }

    public void Qd() {
        synchronized (this.bro) {
            if (DEBUG) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().Hd();
            }
            this.mListeners.clear();
        }
    }
}
