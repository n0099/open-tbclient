package com.baidu.swan.apps.swancore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.swancore.d.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.d.h;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void hu(int i) {
        b(i, (com.baidu.swan.apps.aq.e.b<Exception>) null);
    }

    public static void b(int i, com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        a(b.a.avl().fC(true).qd("openSwanApp").avm(), i, bVar);
    }

    public static void a(com.baidu.swan.apps.swancore.d.b bVar, int i, com.baidu.swan.apps.aq.e.b<Exception> bVar2) {
        h hVar = new h(i);
        if (i == 0) {
            c.a(hVar, new i(bVar2));
        } else {
            c.a(hVar, new i(null), new com.baidu.swan.games.k.b.a(bVar2));
        }
    }

    public static void ah(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.c.a.k(true, 0);
            com.baidu.swan.apps.swancore.c.a.k(true, 1);
        }
    }

    public static String hv(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = hx(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.swanCoreVersion);
        }
        if (swanCoreVersion.swanCoreVersion > 0) {
            return bE(swanCoreVersion.swanCoreVersion);
        }
        String avi = com.baidu.swan.apps.swancore.c.a.hE(i).avi();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + avi);
        }
        return TextUtils.isEmpty(avi) ? "0" : avi;
    }

    @Nullable
    public static SwanCoreVersion hw(int i) {
        if (ProcessUtils.isMainProcess()) {
            return hx(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion hx(int i) {
        long hD = com.baidu.swan.apps.swancore.c.a.hD(i);
        long hM = com.baidu.swan.apps.swancore.d.a.hM(i);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + hD + " ,remoteVer: " + hM);
        }
        boolean z = i == 0;
        if (auZ() && z) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = z ? com.baidu.swan.apps.swancore.b.a.afh().getPath() : com.baidu.swan.games.k.a.b.afh().getPath();
            swanCoreVersion.swanCoreType = 2;
            swanCoreVersion.swanCoreVersion = com.baidu.swan.apps.swancore.b.a.ave();
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
            }
            return swanCoreVersion;
        } else if (hD >= hM) {
            return com.baidu.swan.apps.swancore.c.a.i(i, hD);
        } else {
            SwanCoreVersion j = com.baidu.swan.apps.swancore.d.a.j(i, hM);
            if (j == null || !j.isAvailable()) {
                return com.baidu.swan.apps.swancore.c.a.i(i, hD);
            }
            return j;
        }
    }

    public static File hy(int i) {
        return i == 1 ? new File(com.baidu.swan.games.l.a.agZ(), "game_core") : new File(d.agZ(), "swan_core");
    }

    public static String bE(long j) {
        return com.baidu.swan.apps.performance.b.b.aoo() ? bG(j) : bF(j);
    }

    public static String bF(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version: " + j + " ,version string: " + ((Object) sb) + " equals: " + (j == qb(sb2)));
        }
        return sb2;
    }

    public static String bG(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append((j >> (i * 16)) & 65535);
            if (i > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == qb(sb2)));
        }
        return sb2;
    }

    public static long qb(String str) {
        String[] kP = kP(str);
        if (kP == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < kP.length ? Integer.valueOf(kP[i]).intValue() : 0L);
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

    private static String[] kP(String str) {
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
                        com.baidu.swan.d.d.deleteFile(file2);
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

    /* loaded from: classes7.dex */
    public static class a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", hz(0));
            bundle2.putParcelable("aiapps_game_core", hz(1));
            return bundle2;
        }

        public SwanCoreVersion hz(int i) {
            SwanCoreVersion hx = b.hx(i);
            if (hx == null || !hx.isAvailable()) {
                com.baidu.swan.apps.swancore.c.b.avj().hL(i);
                return b.hx(i);
            }
            return hx;
        }

        @Nullable
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

    public static boolean auZ() {
        return com.baidu.swan.apps.storage.c.h.auW().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void fB(boolean z) {
        com.baidu.swan.apps.storage.c.h.auW().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }

    public static boolean ava() {
        if (com.baidu.swan.apps.swancore.b.a.avf()) {
            return true;
        }
        com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_debug_no_swan_core).showToast();
        return false;
    }
}
