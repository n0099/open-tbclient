package com.baidu.swan.apps.swancore;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.swancore.e.c;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.b.d.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void eQ(int i) {
        a(c.a.Te().cR(true).ix("openSwanApp").Tf(), i);
    }

    public static void a(c cVar, int i) {
        if (com.baidu.swan.apps.core.pms.a.dl(i)) {
            com.baidu.swan.pms.c.a(new f(i), i == 0 ? new com.baidu.swan.apps.core.pms.f() : new com.baidu.swan.games.h.b.b());
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(new com.baidu.swan.apps.swancore.e.b(cVar));
        } else {
            arrayList.add(new com.baidu.swan.games.h.b.a(cVar));
        }
        com.baidu.a.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.a.a.c.a.a(appContext, com.baidu.swan.apps.u.a.JF().Kd());
        com.baidu.a.a.c.a.b((List<Object>) arrayList, true);
    }

    public static void I(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.d(true, 0);
            com.baidu.swan.apps.swancore.d.a.d(true, 1);
        }
    }

    public static String eR(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = eT(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.bqi);
        }
        if (swanCoreVersion.bqi > 0) {
            return ap(swanCoreVersion.bqi);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.fa(i).bqo);
        }
        return com.baidu.swan.apps.swancore.d.a.fa(i).bqo;
    }

    public static SwanCoreVersion eS(int i) {
        if (ProcessUtils.isMainProcess()) {
            return eT(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion eT(int i) {
        long eZ = com.baidu.swan.apps.swancore.d.a.eZ(i);
        long fj = com.baidu.swan.apps.swancore.e.a.fj(i);
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + eZ + " ,remoteVer: " + fj);
        }
        boolean z = i == 0;
        if (DEBUG && SU() && z) {
            swanCoreVersion.bql = z ? com.baidu.swan.apps.swancore.c.a.HY().getPath() : com.baidu.swan.games.h.a.b.HY().getPath();
            swanCoreVersion.bqk = 2;
            swanCoreVersion.bqi = com.baidu.swan.apps.swancore.c.a.SY();
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            return swanCoreVersion;
        }
        if (eZ >= fj) {
            swanCoreVersion.bql = com.baidu.swan.apps.swancore.d.a.e(eZ, i).getPath();
            swanCoreVersion.bqk = 0;
            swanCoreVersion.bqi = eZ;
        } else {
            swanCoreVersion.bql = com.baidu.swan.apps.swancore.e.a.g(fj, i).getPath();
            swanCoreVersion.bqk = 1;
            swanCoreVersion.bqi = fj;
        }
        return swanCoreVersion;
    }

    public static File eU(int i) {
        return i == 1 ? new File(com.baidu.swan.games.i.a.IX(), "game_core") : new File(e.IX(), "swan_core");
    }

    public static String ap(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(DefaultConfig.TOKEN_SEPARATOR);
            }
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == iu(sb.toString())));
        }
        return sb.toString();
    }

    public static long iu(String str) {
        String[] fl = fl(str);
        if (fl == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < fl.length ? Integer.valueOf(fl[i]).intValue() : 0L);
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

    private static String[] fl(String str) {
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
                        com.baidu.swan.c.a.deleteFile(file2);
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
            bundle2.putParcelable("aiapps_swan_core", eV(0));
            bundle2.putParcelable("aiapps_game_core", eV(1));
            return bundle2;
        }

        public SwanCoreVersion eV(int i) {
            SwanCoreVersion eT = b.eT(i);
            if (eT == null || !eT.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.Tc().fh(i);
                return b.eT(i);
            }
            return eT;
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

    public static boolean SU() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void cQ(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z).apply();
    }
}
