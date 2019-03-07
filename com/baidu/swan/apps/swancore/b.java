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
import com.baidu.swan.apps.c;
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
    private static final boolean DEBUG = c.DEBUG;

    public static void dH(int i) {
        if (i == 0) {
            a(c.a.KY().ci(true).KZ(), i);
        } else {
            a((com.baidu.swan.apps.swancore.e.c) null, i);
        }
    }

    public static void a(com.baidu.swan.apps.swancore.e.c cVar, int i) {
        if (i == 0 && com.baidu.swan.apps.core.pms.a.vq()) {
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
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CV().Dt());
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

    public static String dI(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = dK(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.aTc);
        }
        if (swanCoreVersion.aTc > 0) {
            return J(swanCoreVersion.aTc);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.dR(i).aTi);
        }
        return com.baidu.swan.apps.swancore.d.a.dR(i).aTi;
    }

    public static SwanCoreVersion dJ(int i) {
        if (ProcessUtils.isMainProcess()) {
            return dK(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion dK(int i) {
        long dQ = com.baidu.swan.apps.swancore.d.a.dQ(i);
        long ea = com.baidu.swan.apps.swancore.e.a.ea(i);
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + dQ + " ,remoteVer: " + ea);
        }
        boolean z = i == 0;
        if (DEBUG && KO() && z) {
            swanCoreVersion.aTf = z ? com.baidu.swan.apps.swancore.c.a.Bq().getPath() : com.baidu.swan.games.h.a.b.Bq().getPath();
            swanCoreVersion.aTe = 2;
            swanCoreVersion.aTc = com.baidu.swan.apps.swancore.c.a.KS();
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            return swanCoreVersion;
        }
        if (dQ >= ea) {
            swanCoreVersion.aTf = com.baidu.swan.apps.swancore.d.a.f(dQ, i).getPath();
            swanCoreVersion.aTe = 0;
            swanCoreVersion.aTc = dQ;
        } else {
            swanCoreVersion.aTf = com.baidu.swan.apps.swancore.e.a.h(ea, i).getPath();
            swanCoreVersion.aTe = 1;
            swanCoreVersion.aTc = ea;
        }
        return swanCoreVersion;
    }

    public static File dL(int i) {
        return i == 1 ? new File(com.baidu.swan.games.i.a.Cq(), "game_core") : new File(com.baidu.swan.apps.install.c.Cq(), "swan_core");
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
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == hg(sb.toString())));
        }
        return sb.toString();
    }

    public static long hg(String str) {
        String[] eI = eI(str);
        if (eI == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < eI.length ? Integer.valueOf(eI[i]).intValue() : 0L);
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

    private static String[] eI(String str) {
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
            bundle2.putParcelable("aiapps_swan_core", dM(0));
            bundle2.putParcelable("aiapps_game_core", dM(1));
            return bundle2;
        }

        public SwanCoreVersion dM(int i) {
            SwanCoreVersion dK = b.dK(i);
            if (dK == null || !dK.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.KW().dY(i);
                return b.dK(i);
            }
            return dK;
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

    public static boolean KO() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void ch(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z).apply();
    }
}
