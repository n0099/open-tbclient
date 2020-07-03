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
    private static ExecutorService cet = Executors.newSingleThreadExecutor();
    private volatile String ces;
    private CopyOnWriteArrayList<InterfaceC0351a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0351a {
        void jS(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a abW() {
        return c.cew;
    }

    public void a(@NonNull final String str, InterfaceC0351a interfaceC0351a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.ces)) {
                a(interfaceC0351a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                cet.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.ces = d.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.abX();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0351a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abX() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0351a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0351a interfaceC0351a) {
        if (interfaceC0351a != null) {
            interfaceC0351a.jS(this.ces);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.ces = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a cew = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int cdO = -1;

        public static String abY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean abZ() {
            boolean ang = com.baidu.swan.apps.af.a.a.ang();
            if (ang) {
                cdO = 1;
            }
            if (cdO < 0) {
                cdO = com.baidu.swan.apps.u.a.aga().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + cdO + (ang ? " forceAb" : ""));
            }
            return cdO == 1;
        }

        public static boolean aca() {
            if (a.DEBUG) {
                String abY = abY();
                char c = 65535;
                switch (abY.hashCode()) {
                    case -307690011:
                        if (abY.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (abY.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (abY.equals("disable_slave_preload")) {
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
                        return abZ();
                }
            }
            return abZ();
        }
    }
}
