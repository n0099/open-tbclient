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
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void jM(int i) {
        b(i, (com.baidu.swan.apps.ap.e.b<Exception>) null);
    }

    public static void b(int i, com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        a(b.a.aEe().fU(true).sy("openSwanApp").aEf(), i, bVar);
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
            com.baidu.swan.apps.swancore.d.a.kg(0);
            com.baidu.swan.apps.swancore.c.a.jW(0);
            com.baidu.swan.apps.swancore.c.a.k(true, 0);
            com.baidu.swan.apps.swancore.c.a.k(true, 1);
        }
    }

    public static String jN(int i) {
        return a((SwanCoreVersion) null, i);
    }

    public static String a(SwanCoreVersion swanCoreVersion, int i) {
        if (swanCoreVersion == null) {
            swanCoreVersion = jP(i);
        }
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.swanCoreVersion);
        }
        if (swanCoreVersion.swanCoreVersion > 0) {
            return bM(swanCoreVersion.swanCoreVersion);
        }
        String aEb = com.baidu.swan.apps.swancore.c.a.jX(i).aEb();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + aEb);
        }
        return TextUtils.isEmpty(aEb) ? "0" : aEb;
    }

    @Nullable
    public static SwanCoreVersion jO(int i) {
        if (ProcessUtils.isMainProcess()) {
            return jP(i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i));
        }
        return a.b(callOnMainWithContentProvider.mResult, i);
    }

    public static SwanCoreVersion jP(int i) {
        long jV = com.baidu.swan.apps.swancore.c.a.jV(i);
        long kf = com.baidu.swan.apps.swancore.d.a.kf(i);
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + jV + " ,remoteVer: " + kf);
        }
        boolean z = i == 0;
        if (aDS() && z) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = com.baidu.swan.apps.swancore.b.a.amY().getPath();
            swanCoreVersion.swanCoreType = 2;
            swanCoreVersion.swanCoreVersion = com.baidu.swan.apps.swancore.b.a.aDX();
            if (DEBUG) {
                Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
                return swanCoreVersion;
            }
            return swanCoreVersion;
        } else if (jV >= kf) {
            return com.baidu.swan.apps.swancore.c.a.i(i, jV);
        } else {
            SwanCoreVersion j = com.baidu.swan.apps.swancore.d.a.j(i, kf);
            if (!j.isAvailable()) {
                return com.baidu.swan.apps.swancore.c.a.i(i, jV);
            }
            return j;
        }
    }

    public static File jQ(int i) {
        return i == 1 ? new File(com.baidu.swan.games.l.a.apk(), "game_core") : new File(d.apk(), "swan_core");
    }

    public static String bM(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append((j >> (i * 16)) & 65535);
            if (i > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (DEBUG) {
            Log.d("SwanAppSwanCoreManager", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == sw(sb2)));
        }
        return sb2;
    }

    public static long sw(String str) {
        String[] mY = mY(str);
        if (mY == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < mY.length ? Integer.parseInt(mY[i]) : 0L);
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

    private static String[] mY(String str) {
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

    /* loaded from: classes3.dex */
    public static class a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", jR(0));
            bundle2.putParcelable("aiapps_game_core", jR(1));
            return bundle2;
        }

        public SwanCoreVersion jR(int i) {
            SwanCoreVersion jP = b.jP(i);
            if (!jP.isAvailable()) {
                com.baidu.swan.apps.swancore.c.b.aEc().ke(i);
                return b.jP(i);
            }
            return jP;
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

    public static boolean aDS() {
        return com.baidu.swan.apps.storage.c.h.aDP().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static void fT(boolean z) {
        com.baidu.swan.apps.storage.c.h.aDP().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }

    public static boolean aDT() {
        return com.baidu.swan.apps.swancore.b.a.aDY();
    }
}
