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
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.swancore.d.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.d.h;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void ku(int i) {
        b(i, (com.baidu.swan.apps.ap.e.b<Exception>) null);
    }

    public static void b(int i, com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        a(b.a.aIH().gD(true).tD("openSwanApp").aII(), i, bVar);
    }

    private static void a(com.baidu.swan.apps.swancore.d.b bVar, int i, com.baidu.swan.apps.ap.e.b<Exception> bVar2) {
        h hVar = new h(i);
        if (i == 0) {
            c.a(hVar, new i(bVar2));
        } else {
            c.a(hVar, new i(null), new com.baidu.swan.games.k.b.a(bVar2));
        }
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.swancore.d.a.kO(0);
            com.baidu.swan.apps.swancore.c.a.kE(0);
            com.baidu.swan.apps.swancore.c.a.l(true, 0);
            com.baidu.swan.apps.swancore.c.a.l(true, 1);
        }
    }

    public static String kv(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = kx(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.swanCoreVersion);
        }
        if (swanCoreVersion.swanCoreVersion > 0) {
            return bW(swanCoreVersion.swanCoreVersion);
        }
        String aIE = com.baidu.swan.apps.swancore.c.a.kF(i).aIE();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + aIE);
        }
        return TextUtils.isEmpty(aIE) ? "0" : aIE;
    }

    @Nullable
    public static SwanCoreVersion kw(int i) {
        if (ProcessUtils.isMainProcess()) {
            return kx(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion kx(int i) {
        long kD = com.baidu.swan.apps.swancore.c.a.kD(i);
        long kN = com.baidu.swan.apps.swancore.d.a.kN(i);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + kD + " ,remoteVer: " + kN);
        }
        boolean z = i == 0;
        if (aIv() && z) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = com.baidu.swan.apps.swancore.b.a.arE().getPath();
            swanCoreVersion.swanCoreType = 2;
            swanCoreVersion.swanCoreVersion = com.baidu.swan.apps.swancore.b.a.aIA();
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
                return swanCoreVersion;
            }
            return swanCoreVersion;
        } else if (kD >= kN) {
            return com.baidu.swan.apps.swancore.c.a.j(i, kD);
        } else {
            SwanCoreVersion k = com.baidu.swan.apps.swancore.d.a.k(i, kN);
            if (!k.isAvailable()) {
                return com.baidu.swan.apps.swancore.c.a.j(i, kD);
            }
            return k;
        }
    }

    public static File ky(int i) {
        return i == 1 ? new File(com.baidu.swan.games.l.a.atQ(), "game_core") : new File(d.atQ(), "swan_core");
    }

    public static String bW(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append((j >> (i * 16)) & 65535);
            if (i > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == tB(sb2)));
        }
        return sb2;
    }

    public static long tB(String str) {
        String[] od = od(str);
        if (od == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < od.length ? Integer.parseInt(od[i]) : 0L);
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

    private static String[] od(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length == 3) {
            return split;
        }
        return null;
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        if (file != null) {
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
            }
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (DEBUG) {
                        Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
                    }
                    if (!a(file2, list)) {
                        if (DEBUG) {
                            Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                        }
                        com.baidu.swan.c.d.deleteFile(file2);
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
            bundle2.putParcelable("aiapps_swan_core", kz(0));
            bundle2.putParcelable("aiapps_game_core", kz(1));
            return bundle2;
        }

        public SwanCoreVersion kz(int i) {
            SwanCoreVersion kx = b.kx(i);
            if (!kx.isAvailable()) {
                com.baidu.swan.apps.swancore.c.b.aIF().kM(i);
                return b.kx(i);
            }
            return kx;
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

    public static boolean aIv() {
        return com.baidu.swan.apps.storage.c.h.aIs().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void gC(boolean z) {
        com.baidu.swan.apps.storage.c.h.aIs().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }

    public static boolean aIw() {
        return com.baidu.swan.apps.swancore.b.a.aIB();
    }
}
