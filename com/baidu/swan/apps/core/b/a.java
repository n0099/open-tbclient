package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0340a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting aZ(String str, @NonNull String str2) {
        V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
        codeCacheSetting.id = str;
        codeCacheSetting.pathList = new ArrayList<>();
        codeCacheSetting.pathList.add(str2);
        char c = 65535;
        switch (str.hashCode()) {
            case 93029162:
                if (str.equals("appjs")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C0340a ZD = b.ZD();
                codeCacheSetting.maxCount = ZD.maxCount;
                codeCacheSetting.sizeLimit = ZD.sizeLimit;
                break;
            default:
                codeCacheSetting.maxCount = 5;
                codeCacheSetting.sizeLimit = BdStatsConstant.MAX_WRITE_LOG_SIZE;
                break;
        }
        if (DEBUG) {
            Log.d("V8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
            Log.d("V8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
            Log.d("V8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
        }
        return codeCacheSetting;
    }

    public static int k(boolean z, boolean z2) {
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 1;
        }
        if (z2) {
            return 2;
        }
        return 0;
    }

    /* loaded from: classes7.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cas = -1;
        private static int cat = -1;
        private static int cau = -1;
        private static int cav = -1;

        public static String ZA() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean eW(int i) {
            switch (i) {
                case 0:
                    return ZB();
                case 1:
                    return ZC();
                default:
                    return ZB();
            }
        }

        private static boolean ZB() {
            boolean aoP = com.baidu.swan.apps.ae.a.a.aoP();
            if (aoP) {
                cas = 1;
            }
            if (cas < 0) {
                cas = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cas + (aoP ? " forceAb" : ""));
            }
            return cas == 1;
        }

        private static boolean ZC() {
            boolean aoP = com.baidu.swan.apps.ae.a.a.aoP();
            if (aoP) {
                cat = 1;
            }
            if (cat < 0) {
                cat = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cat + (aoP ? " forceAb" : ""));
            }
            return cat == 1;
        }

        public static boolean et(int i) {
            if (DEBUG) {
                String ZA = ZA();
                char c = 65535;
                switch (ZA.hashCode()) {
                    case 3105:
                        if (ZA.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (ZA.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (ZA.equals("disable_code_cache")) {
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
                        return eW(i);
                }
            }
            return eW(i);
        }

        public static C0340a ZD() {
            C0340a c0340a = new C0340a();
            c0340a.maxCount = ZE();
            c0340a.sizeLimit = ZF();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0340a.maxCount + " ,sizeLimit: " + c0340a.sizeLimit);
            }
            return c0340a;
        }

        private static int ZE() {
            if (cau < 0) {
                cau = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_code_cache_max_count", 5);
            }
            return cau;
        }

        private static int ZF() {
            if (cav < 0) {
                cav = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cav * 1024;
        }
    }
}
