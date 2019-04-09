package com.baidu.swan.apps.swancore;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.swancore.e.c;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.b.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void dG(int i) {
        if (i == 0) {
            a(c.a.KW().ci(true).KX(), i);
        } else {
            a((c) null, i);
        }
    }

    public static void a(c cVar, int i) {
        if (i == 0 && com.baidu.swan.apps.core.pms.a.vp()) {
            com.baidu.swan.pms.c.a(new d(0), new f());
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(new com.baidu.swan.apps.swancore.e.b(cVar));
        } else {
            arrayList.add(new com.baidu.swan.games.h.b.a(true));
        }
        com.baidu.b.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CT().Dr());
        com.baidu.b.a.c.a.c(arrayList, true);
    }

    public static void B(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.c(true, 0);
            com.baidu.swan.apps.swancore.d.a.c(true, 1);
        }
    }

    public static String dH(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = dJ(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.aTh);
        }
        if (swanCoreVersion.aTh > 0) {
            return J(swanCoreVersion.aTh);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.dQ(i).aTn);
        }
        return com.baidu.swan.apps.swancore.d.a.dQ(i).aTn;
    }

    public static SwanCoreVersion dI(int i) {
        if (ProcessUtils.isMainProcess()) {
            return dJ(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion dJ(int i) {
        long dP = com.baidu.swan.apps.swancore.d.a.dP(i);
        long dZ = com.baidu.swan.apps.swancore.e.a.dZ(i);
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + dP + " ,remoteVer: " + dZ);
        }
        boolean z = i == 0;
        if (DEBUG && KM() && z) {
            swanCoreVersion.aTk = z ? com.baidu.swan.apps.swancore.c.a.Bo().getPath() : com.baidu.swan.games.h.a.b.Bo().getPath();
            swanCoreVersion.aTj = 2;
            swanCoreVersion.aTh = com.baidu.swan.apps.swancore.c.a.KQ();
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            return swanCoreVersion;
        }
        if (dP >= dZ) {
            swanCoreVersion.aTk = com.baidu.swan.apps.swancore.d.a.f(dP, i).getPath();
            swanCoreVersion.aTj = 0;
            swanCoreVersion.aTh = dP;
        } else {
            swanCoreVersion.aTk = com.baidu.swan.apps.swancore.e.a.h(dZ, i).getPath();
            swanCoreVersion.aTj = 1;
            swanCoreVersion.aTh = dZ;
        }
        return swanCoreVersion;
    }

    public static File dK(int i) {
        return i == 1 ? new File(com.baidu.swan.games.i.a.Co(), "game_core") : new File(com.baidu.swan.apps.install.c.Co(), "swan_core");
    }

    public static String J(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == hh(sb.toString())));
        }
        return sb.toString();
    }

    public static long hh(String str) {
        String[] eJ = eJ(str);
        if (eJ == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < eJ.length ? Integer.valueOf(eJ[i]).intValue() : 0L);
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

    private static String[] eJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length == 0 || split.length != 3) {
            return null;
        }
        return split;
    }

    public static void c(File file, List<Long> list) {
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
                    if (!b(file2, list)) {
                        if (DEBUG) {
                            Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                        }
                        com.baidu.swan.c.b.deleteFile(file2);
                    }
                }
            }
        }
    }

    private static boolean b(File file, List<Long> list) {
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

    /* loaded from: classes2.dex */
    public static class a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", dL(0));
            bundle2.putParcelable("aiapps_game_core", dL(1));
            return bundle2;
        }

        public SwanCoreVersion dL(int i) {
            SwanCoreVersion dJ = b.dJ(i);
            if (dJ == null || !dJ.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.KU().dX(i);
                return b.dJ(i);
            }
            return dJ;
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

    public static boolean KM() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void ch(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z).apply();
    }
}
