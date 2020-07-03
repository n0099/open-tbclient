package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0338a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting aX(String str, @NonNull String str2) {
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
                C0338a YL = b.YL();
                codeCacheSetting.maxCount = YL.maxCount;
                codeCacheSetting.sizeLimit = YL.sizeLimit;
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

    /* loaded from: classes11.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int bZb = -1;
        private static int bZc = -1;
        private static int bZd = -1;
        private static int bZe = -1;

        public static String YI() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean eS(int i) {
            switch (i) {
                case 0:
                    return YJ();
                case 1:
                    return YK();
                default:
                    return YJ();
            }
        }

        private static boolean YJ() {
            boolean ang = com.baidu.swan.apps.af.a.a.ang();
            if (ang) {
                bZb = 1;
            }
            if (bZb < 0) {
                bZb = com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bZb + (ang ? " forceAb" : ""));
            }
            return bZb == 1;
        }

        private static boolean YK() {
            boolean ang = com.baidu.swan.apps.af.a.a.ang();
            if (ang) {
                bZc = 1;
            }
            if (bZc < 0) {
                bZc = com.baidu.swan.apps.u.a.aga().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bZc + (ang ? " forceAb" : ""));
            }
            return bZc == 1;
        }

        public static boolean er(int i) {
            if (DEBUG) {
                String YI = YI();
                char c = 65535;
                switch (YI.hashCode()) {
                    case 3105:
                        if (YI.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (YI.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (YI.equals("disable_code_cache")) {
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
                        return eS(i);
                }
            }
            return eS(i);
        }

        public static C0338a YL() {
            C0338a c0338a = new C0338a();
            c0338a.maxCount = YM();
            c0338a.sizeLimit = YN();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0338a.maxCount + " ,sizeLimit: " + c0338a.sizeLimit);
            }
            return c0338a;
        }

        private static int YM() {
            if (bZd < 0) {
                bZd = com.baidu.swan.apps.u.a.aga().getSwitch("swan_code_cache_max_count", 5);
            }
            return bZd;
        }

        private static int YN() {
            if (bZe < 0) {
                bZe = com.baidu.swan.apps.u.a.aga().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bZe * 1024;
        }
    }
}
