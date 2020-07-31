package com.baidu.swan.apps.core.slave;

import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.d.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cgc = Executors.newSingleThreadExecutor();
    private volatile String cgb;
    private CopyOnWriteArrayList<InterfaceC0352a> mCallbacks;

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0352a {
        void kl(String str);
    }

    private a() {
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public static a ada() {
        return c.cgf;
    }

    public void a(@NonNull final String str, InterfaceC0352a interfaceC0352a) {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SlavePreloadManager", "getHtmlContentAsync");
            }
            if (!TextUtils.isEmpty(this.cgb)) {
                a(interfaceC0352a);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                cgc.execute(new Runnable() { // from class: com.baidu.swan.apps.core.slave.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (a.class) {
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read start.");
                            }
                            a.this.cgb = d.readFileData(new File(Uri.parse(str).getPath()));
                            if (a.DEBUG) {
                                Log.d("SlavePreloadManager", "getHtmlContentAsync read end.");
                            }
                            a.this.adb();
                        }
                    }
                });
            }
            this.mCallbacks.add(interfaceC0352a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adb() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "notifyAllCallbacks");
        }
        Iterator<InterfaceC0352a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.mCallbacks.clear();
    }

    private void a(InterfaceC0352a interfaceC0352a) {
        if (interfaceC0352a != null) {
            interfaceC0352a.kl(this.cgb);
        }
    }

    public void clear() {
        if (DEBUG) {
            Log.d("SlavePreloadManager", "clear");
        }
        synchronized (a.class) {
            this.cgb = "";
            this.mCallbacks.clear();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        private static final a cgf = new a();
    }

    /* loaded from: classes7.dex */
    public static class b {
        private static int cfv = -1;

        public static String adc() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_slave_preload_opt", "ab");
        }

        private static boolean add() {
            boolean aoP = com.baidu.swan.apps.ae.a.a.aoP();
            if (aoP) {
                cfv = 1;
            }
            if (cfv < 0) {
                cfv = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_slave_preload_opt", 2);
            }
            if (a.DEBUG) {
                Log.d("OptSwitcher", "getSlavePreloadAbSwitch() switcher: " + cfv + (aoP ? " forceAb" : ""));
            }
            return cfv == 1;
        }

        public static boolean ade() {
            if (a.DEBUG) {
                String adc = adc();
                char c = 65535;
                switch (adc.hashCode()) {
                    case -307690011:
                        if (adc.equals("enable_slave_preload")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3105:
                        if (adc.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2084843146:
                        if (adc.equals("disable_slave_preload")) {
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
                        return add();
                }
            }
            return add();
        }
    }
}
