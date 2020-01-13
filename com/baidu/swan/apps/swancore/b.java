package com.baidu.swan.apps.swancore;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.e.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.d.g;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void gg(int i) {
        a(b.a.adp().dQ(true).mc("openSwanApp").adq(), i);
    }

    public static void a(com.baidu.swan.apps.swancore.e.b bVar, int i) {
        c.a(new g(i), i == 0 ? new i() : new com.baidu.swan.games.j.b.a());
    }

    public static void Z(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.g(true, 0);
            com.baidu.swan.apps.swancore.d.a.g(true, 1);
        }
    }

    public static String gh(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = gj(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.swanCoreVersion);
        }
        if (swanCoreVersion.swanCoreVersion > 0) {
            return aB(swanCoreVersion.swanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.gq(i).bRZ);
        }
        return com.baidu.swan.apps.swancore.d.a.gq(i).bRZ;
    }

    public static SwanCoreVersion gi(int i) {
        if (ProcessUtils.isMainProcess()) {
            return gj(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion gj(int i) {
        long gp = com.baidu.swan.apps.swancore.d.a.gp(i);
        long gz = com.baidu.swan.apps.swancore.e.a.gz(i);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + gp + " ,remoteVer: " + gz);
        }
        boolean z = i == 0;
        if (ade() && z) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = z ? com.baidu.swan.apps.swancore.c.a.PD().getPath() : com.baidu.swan.games.j.a.b.PD().getPath();
            swanCoreVersion.swanCoreType = 2;
            swanCoreVersion.swanCoreVersion = com.baidu.swan.apps.swancore.c.a.adj();
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            }
            return swanCoreVersion;
        } else if (gp >= gz) {
            return com.baidu.swan.apps.swancore.d.a.h(i, gp);
        } else {
            SwanCoreVersion i2 = com.baidu.swan.apps.swancore.e.a.i(i, gz);
            if (i2 == null || !i2.isAvailable()) {
                return com.baidu.swan.apps.swancore.d.a.h(i, gp);
            }
            return i2;
        }
    }

    public static File gk(int i) {
        return i == 1 ? new File(com.baidu.swan.games.k.a.Rx(), "game_core") : new File(e.Rx(), "swan_core");
    }

    public static String aB(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == ma(sb.toString())));
        }
        return sb.toString();
    }

    public static long ma(String str) {
        String[] hC = hC(str);
        if (hC == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < hC.length ? Integer.valueOf(hC[i]).intValue() : 0L);
                i++;
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    throw e;
                }
                return 0L;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getVersion version: " + str + " ,versionCode: " + j);
        }
        return j;
    }

    private static String[] hC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length == 0 || split.length != 3) {
            return null;
        }
        return split;
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        if (file != null) {
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
            }
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (DEBUG) {
                        Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
                    }
                    if (!a(file2, list)) {
                        if (DEBUG) {
                            Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                        }
                        com.baidu.swan.d.c.deleteFile(file2);
                    }
                }
            }
        }
    }

    private static boolean a(File file, List<Long> list) {
        if (list == null) {
            return false;
        }
        String name = file.getName();
        for (Long l : list) {
            if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes10.dex */
    public static class a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", gl(0));
            bundle2.putParcelable("aiapps_game_core", gl(1));
            return bundle2;
        }

        public SwanCoreVersion gl(int i) {
            SwanCoreVersion gj = b.gj(i);
            if (gj == null || !gj.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.adn().gx(i);
                return b.gj(i);
            }
            return gj;
        }

        public static SwanCoreVersion b(Bundle bundle, int i) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            if (i == 1) {
                return (SwanCoreVersion) bundle.getParcelable("aiapps_game_core");
            }
            return (SwanCoreVersion) bundle.getParcelable("aiapps_swan_core");
        }
    }

    public static boolean ade() {
        return h.adb().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void dP(boolean z) {
        h.adb().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }

    public static boolean adf() {
        if (com.baidu.swan.apps.swancore.c.a.adk()) {
            return true;
        }
        d.q(AppRuntime.getAppContext(), a.h.aiapps_debug_no_swan_core).showToast();
        return false;
    }
}
