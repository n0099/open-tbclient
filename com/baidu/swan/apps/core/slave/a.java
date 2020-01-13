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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bni = Executors.newSingleThreadExecutor();
    private volatile String bnh;
    private CopyOnWriteArrayList<InterfaceC0244a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0244a {
        void hc(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a NO() {
        return c.bnl;
    }

    public void a(@NonNull final String str, InterfaceC0244a interfaceC0244a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.bnh)) {
                a(interfaceC0244a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                bni.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.bnh = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.NP();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0244a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NP() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0244a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0244a interfaceC0244a) {
        if (interfaceC0244a != null) {
            interfaceC0244a.hc(this.bnh);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.bnh = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        private static final a bnl = new a();
    }

    /* loaded from: classes10.dex */
    public static class b {
        private static int bmK = -1;

        public static String NQ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean NR() {
            boolean XW = com.baidu.swan.apps.ah.a.a.XW();
            if (XW) {
                bmK = 1;
            }
            if (bmK < 0) {
                bmK = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + bmK + (XW ? " forceAb" : ""));
            }
            return bmK == 1;
        }

        public static boolean NS() {
            if (a.DEBUG) {
                String NQ = NQ();
                char c = 65535;
                switch (NQ.hashCode()) {
                    case -307690011:
                        if (NQ.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (NQ.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (NQ.equals("disable_slave_preload")) {
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
                        return NR();
                }
            }
            return NR();
        }
    }
}
