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

    public static void dU(int i) {
        a(c.a.Ok().cA(true).hR("openSwanApp").Ol(), i);
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
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.EH().Ff());
        com.baidu.b.a.c.a.b(arrayList, true);
    }

    public static void C(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.c(true, 0);
            com.baidu.swan.apps.swancore.d.a.c(true, 1);
        }
    }

    public static String dV(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = dX(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.aWG);
        }
        if (swanCoreVersion.aWG > 0) {
            return W(swanCoreVersion.aWG);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + com.baidu.swan.apps.swancore.d.a.ee(i).aWM);
        }
        return com.baidu.swan.apps.swancore.d.a.ee(i).aWM;
    }

    public static SwanCoreVersion dW(int i) {
        if (ProcessUtils.isMainProcess()) {
            return dX(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion dX(int i) {
        long ed = com.baidu.swan.apps.swancore.d.a.ed(i);
        long en = com.baidu.swan.apps.swancore.e.a.en(i);
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + ed + " ,remoteVer: " + en);
        }
        boolean z = i == 0;
        if (DEBUG && Oa() && z) {
            swanCoreVersion.aWJ = z ? com.baidu.swan.apps.swancore.c.a.Da().getPath() : com.baidu.swan.games.h.a.b.Da().getPath();
            swanCoreVersion.aWI = 2;
            swanCoreVersion.aWG = com.baidu.swan.apps.swancore.c.a.Oe();
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            return swanCoreVersion;
        }
        if (ed >= en) {
            swanCoreVersion.aWJ = com.baidu.swan.apps.swancore.d.a.d(ed, i).getPath();
            swanCoreVersion.aWI = 0;
            swanCoreVersion.aWG = ed;
        } else {
            swanCoreVersion.aWJ = com.baidu.swan.apps.swancore.e.a.f(en, i).getPath();
            swanCoreVersion.aWI = 1;
            swanCoreVersion.aWG = en;
        }
        return swanCoreVersion;
    }

    public static File dY(int i) {
        return i == 1 ? new File(com.baidu.swan.games.i.a.DZ(), "game_core") : new File(e.DZ(), "swan_core");
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
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == hO(sb.toString())));
        }
        return sb.toString();
    }

    public static long hO(String str) {
        String[] eC = eC(str);
        if (eC == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < eC.length ? Integer.valueOf(eC[i]).intValue() : 0L);
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

    private static String[] eC(String str) {
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
            bundle2.putParcelable("aiapps_swan_core", dZ(0));
            bundle2.putParcelable("aiapps_game_core", dZ(1));
            return bundle2;
        }

        public SwanCoreVersion dZ(int i) {
            SwanCoreVersion dX = b.dX(i);
            if (dX == null || !dX.isAvailable()) {
                com.baidu.swan.apps.swancore.d.b.Oi().el(i);
                return b.dX(i);
            }
            return dX;
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

    public static boolean Oa() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void cz(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z).apply();
    }
}
