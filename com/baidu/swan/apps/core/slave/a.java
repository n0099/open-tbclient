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
    private static ExecutorService bPR = Executors.newSingleThreadExecutor();
    private volatile String bPQ;
    private CopyOnWriteArrayList<InterfaceC0305a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0305a {
        void iE(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a XV() {
        return c.bPU;
    }

    public void a(@NonNull final String str, InterfaceC0305a interfaceC0305a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.bPQ)) {
                a(interfaceC0305a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                bPR.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.bPQ = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.XW();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0305a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0305a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0305a interfaceC0305a) {
        if (interfaceC0305a != null) {
            interfaceC0305a.iE(this.bPQ);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.bPQ = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a bPU = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int bPt = -1;

        public static String XX() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean XY() {
            boolean ait = com.baidu.swan.apps.ah.a.a.ait();
            if (ait) {
                bPt = 1;
            }
            if (bPt < 0) {
                bPt = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + bPt + (ait ? " forceAb" : ""));
            }
            return bPt == 1;
        }

        public static boolean XZ() {
            if (a.DEBUG) {
                String XX = XX();
                char c = 65535;
                switch (XX.hashCode()) {
                    case -307690011:
                        if (XX.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (XX.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (XX.equals("disable_slave_preload")) {
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
                        return XY();
                }
            }
            return XY();
        }
    }
}
