package com.baidu.swan.apps.core.slave;

import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.e.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bZD = Executors.newSingleThreadExecutor();
    private volatile String bZC;
    private CopyOnWriteArrayList<InterfaceC0345a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0345a {
        void jK(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a aaQ() {
        return c.bZG;
    }

    public void a(@NonNull final String str, InterfaceC0345a interfaceC0345a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.bZC)) {
                a(interfaceC0345a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                bZD.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.bZC = d.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.aaR();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0345a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaR() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0345a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0345a interfaceC0345a) {
        if (interfaceC0345a != null) {
            interfaceC0345a.jK(this.bZC);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.bZC = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a bZG = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int bYY = -1;

        public static String aaS() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean aaT() {
            boolean ama = com.baidu.swan.apps.af.a.a.ama();
            if (ama) {
                bYY = 1;
            }
            if (bYY < 0) {
                bYY = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + bYY + (ama ? " forceAb" : ""));
            }
            return bYY == 1;
        }

        public static boolean aaU() {
            if (a.DEBUG) {
                String aaS = aaS();
                char c = 65535;
                switch (aaS.hashCode()) {
                    case -307690011:
                        if (aaS.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (aaS.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (aaS.equals("disable_slave_preload")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    case 2:
                        return aaT();
                }
            }
            return aaT();
        }
    }
}
