package com.baidu.swan.apps.core.slave;

import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bmt = Executors.newSingleThreadExecutor();
    private volatile String bms;
    private CopyOnWriteArrayList<InterfaceC0242a> bmu;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0242a {
        void gZ(String str);
    }

    private a() {
        this.bmu = new CopyOnWriteArrayList<>();
    }

    public static a Ns() {
        return c.bmx;
    }

    public void a(@NonNull final String str, InterfaceC0242a interfaceC0242a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.bms)) {
                a(interfaceC0242a);
                return;
            }
            if (this.bmu.isEmpty()) {
                bmt.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.bms = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.Nt();
                        }
                    }
                });
            }
            this.bmu.add(interfaceC0242a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nt() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0242a> it = this.bmu.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.bmu.clear();
    }

    private void a(InterfaceC0242a interfaceC0242a) {
        if (interfaceC0242a != null) {
            interfaceC0242a.gZ(this.bms);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.bms = "";
            this.bmu.clear();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        private static final a bmx = new a();
    }

    /* loaded from: classes9.dex */
    public static class b {
        private static int blU = -1;

        public static String Nu() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean Nv() {
            boolean Xz = com.baidu.swan.apps.ah.a.a.Xz();
            if (Xz) {
                blU = 1;
            }
            if (blU < 0) {
                blU = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + blU + (Xz ? " forceAb" : ""));
            }
            return blU == 1;
        }

        public static boolean Nw() {
            if (a.DEBUG) {
                String Nu = Nu();
                char c = 65535;
                switch (Nu.hashCode()) {
                    case -307690011:
                        if (Nu.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (Nu.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (Nu.equals("disable_slave_preload")) {
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
                        return Nv();
                }
            }
            return Nv();
        }
    }
}
