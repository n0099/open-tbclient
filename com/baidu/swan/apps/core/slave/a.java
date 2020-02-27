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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService brr = Executors.newSingleThreadExecutor();
    private volatile String brq;
    private CopyOnWriteArrayList<InterfaceC0254a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0254a {
        void hr(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a Qc() {
        return c.bru;
    }

    public void a(@NonNull final String str, InterfaceC0254a interfaceC0254a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.brq)) {
                a(interfaceC0254a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                brr.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.brq = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.Qd();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0254a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0254a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0254a interfaceC0254a) {
        if (interfaceC0254a != null) {
            interfaceC0254a.hr(this.brq);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.brq = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a bru = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int bqT = -1;

        public static String Qe() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean Qf() {
            boolean aak = com.baidu.swan.apps.ah.a.a.aak();
            if (aak) {
                bqT = 1;
            }
            if (bqT < 0) {
                bqT = com.baidu.swan.apps.w.a.TX().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + bqT + (aak ? " forceAb" : ""));
            }
            return bqT == 1;
        }

        public static boolean Qg() {
            if (a.DEBUG) {
                String Qe = Qe();
                char c = 65535;
                switch (Qe.hashCode()) {
                    case -307690011:
                        if (Qe.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (Qe.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (Qe.equals("disable_slave_preload")) {
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
                        return Qf();
                }
            }
            return Qf();
        }
    }
}
