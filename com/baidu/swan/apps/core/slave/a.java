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
    private static ExecutorService brF = Executors.newSingleThreadExecutor();
    private volatile String brE;
    private CopyOnWriteArrayList<InterfaceC0254a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0254a {
        void hq(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a Qh() {
        return c.brI;
    }

    public void a(@NonNull final String str, InterfaceC0254a interfaceC0254a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.brE)) {
                a(interfaceC0254a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                brF.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.brE = com.baidu.swan.d.c.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.Qi();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0254a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
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
            interfaceC0254a.hq(this.brE);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.brE = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final a brI = new a();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static int brh = -1;

        public static String Qj() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean Qk() {
            boolean aap = com.baidu.swan.apps.ah.a.a.aap();
            if (aap) {
                brh = 1;
            }
            if (brh < 0) {
                brh = com.baidu.swan.apps.w.a.Uc().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + brh + (aap ? " forceAb" : ""));
            }
            return brh == 1;
        }

        public static boolean Ql() {
            if (a.DEBUG) {
                String Qj = Qj();
                char c = 65535;
                switch (Qj.hashCode()) {
                    case -307690011:
                        if (Qj.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (Qj.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (Qj.equals("disable_slave_preload")) {
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
                        return Qk();
                }
            }
            return Qk();
        }
    }
}
