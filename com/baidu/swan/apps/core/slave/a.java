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
    private static ExecutorService bPM = Executors.newSingleThreadExecutor();
    private volatile String bPL;
    private CopyOnWriteArrayList<InterfaceC0284a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0284a {
        void iE(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a XW() {
        return c.bPP;
    }

    public void a(@NonNull final String str, InterfaceC0284a interfaceC0284a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.bPL)) {
                a(interfaceC0284a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                bPM.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.bPL = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.XX();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0284a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0284a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0284a interfaceC0284a) {
        if (interfaceC0284a != null) {
            interfaceC0284a.iE(this.bPL);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.bPL = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a bPP = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int bPo = -1;

        public static String XY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean XZ() {
            boolean aiu = com.baidu.swan.apps.ah.a.a.aiu();
            if (aiu) {
                bPo = 1;
            }
            if (bPo < 0) {
                bPo = com.baidu.swan.apps.w.a.abR().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + bPo + (aiu ? " forceAb" : ""));
            }
            return bPo == 1;
        }

        public static boolean Ya() {
            if (a.DEBUG) {
                String XY = XY();
                char c = 65535;
                switch (XY.hashCode()) {
                    case -307690011:
                        if (XY.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (XY.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (XY.equals("disable_slave_preload")) {
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
                        return XZ();
                }
            }
            return XZ();
        }
    }
}
