package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0232a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting am(String str, @NonNull String str2) {
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
                C0232a Kx = b.Kx();
                codeCacheSetting.maxCount = Kx.maxCount;
                codeCacheSetting.sizeLimit = Kx.sizeLimit;
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

    public static int i(boolean z, boolean z2) {
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

    /* loaded from: classes9.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int bhN = -1;
        private static int bhO = -1;
        private static int bhP = -1;
        private static int bhQ = -1;

        public static String Ku() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean ea(int i) {
            switch (i) {
                case 0:
                    return Kv();
                case 1:
                    return Kw();
                default:
                    return Kv();
            }
        }

        private static boolean Kv() {
            boolean Xz = com.baidu.swan.apps.ah.a.a.Xz();
            if (Xz) {
                bhN = 1;
            }
            if (bhN < 0) {
                bhN = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bhN + (Xz ? " forceAb" : ""));
            }
            return bhN == 1;
        }

        private static boolean Kw() {
            boolean Xz = com.baidu.swan.apps.ah.a.a.Xz();
            if (Xz) {
                bhO = 1;
            }
            if (bhO < 0) {
                bhO = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bhO + (Xz ? " forceAb" : ""));
            }
            return bhO == 1;
        }

        public static boolean dC(int i) {
            if (DEBUG) {
                String Ku = Ku();
                char c = 65535;
                switch (Ku.hashCode()) {
                    case 3105:
                        if (Ku.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (Ku.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (Ku.equals("disable_code_cache")) {
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
                        return ea(i);
                }
            }
            return ea(i);
        }

        public static C0232a Kx() {
            C0232a c0232a = new C0232a();
            c0232a.maxCount = Ky();
            c0232a.sizeLimit = Kz();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0232a.maxCount + " ,sizeLimit: " + c0232a.sizeLimit);
            }
            return c0232a;
        }

        private static int Ky() {
            if (bhP < 0) {
                bhP = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_code_cache_max_count", 5);
            }
            return bhP;
        }

        private static int Kz() {
            if (bhQ < 0) {
                bhQ = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bhQ * 1024;
        }
    }
}
