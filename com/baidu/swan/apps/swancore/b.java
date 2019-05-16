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

    public static void dR(int i) {
        a(c.a.Nv().cx(true).hL("openSwanApp").Nw(), i);
    }

    public static void a(c cVar, int i) {
        if (com.baidu.swan.apps.core.pms.a.co(i)) {
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
        com.baidu.b.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.DY().Ew());
        com.baidu.b.a.c.a.b(arrayList, true);
    }

    public static void z(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.c(true, 0);
            com.baidu.swan.apps.swancore.d.a.c(true, 1);
        }
    }

    public static String dS(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = dU(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.aVW);
        }
        if (swanCoreVersion.aVW > 0) {
            return W(swanCoreVersion.aVW);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.eb(i).aWc);
        }
        return com.baidu.swan.apps.swancore.d.a.eb(i).aWc;
    }

    public static SwanCoreVersion dT(int i) {
        if (ProcessUtils.isMainProcess()) {
            return dU(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion dU(int i) {
        long ea = com.baidu.swan.apps.swancore.d.a.ea(i);
        long ek = com.baidu.swan.apps.swancore.e.a.ek(i);
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + ea + " ,remoteVer: " + ek);
        }
        boolean z = i == 0;
        if (DEBUG && Nl() && z) {
            swanCoreVersion.aVZ = z ? com.baidu.swan.apps.swancore.c.a.Cr().getPath() : com.baidu.swan.games.h.a.b.Cr().getPath();
            swanCoreVersion.aVY = 2;
            swanCoreVersion.aVW = com.baidu.swan.apps.swancore.c.a.Np();
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            return swanCoreVersion;
        }
        if (ea >= ek) {
            swanCoreVersion.aVZ = com.baidu.swan.apps.swancore.d.a.d(ea, i).getPath();
            swanCoreVersion.aVY = 0;
            swanCoreVersion.aVW = ea;
        } else {
            swanCoreVersion.aVZ = com.baidu.swan.apps.swancore.e.a.f(ek, i).getPath();
            swanCoreVersion.aVY = 1;
            swanCoreVersion.aVW = ek;
        }
        return swanCoreVersion;
    }

    public static File dV(int i) {
        return i == 1 ? new File(com.baidu.swan.games.i.a.Dq(), "game_core") : new File(e.Dq(), "swan_core");
    }

    public static String W(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == hI(sb.toString())));
        }
        return sb.toString();
    }

    public static long hI(String str) {
        String[] ey = ey(str);
        if (ey == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < ey.length ? Integer.valueOf(ey[i]).intValue() : 0L);
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

    private static String[] ey(String str) {
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
            bundle2.putParcelable("aiapps_swan_core", dW(0));
            bundle2.putParcelable("aiapps_game_core", dW(1));
            return bundle2;
        }

        public SwanCoreVersion dW(int i) {
            SwanCoreVersion dU = b.dU(i);
            if (dU == null || !dU.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.Nt().ei(i);
                return b.dU(i);
            }
            return dU;
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

    public static boolean Nl() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void cw(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z).apply();
    }
}
