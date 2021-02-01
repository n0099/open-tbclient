package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0401a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting bq(String str, @NonNull String str2) {
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
                C0401a anR = b.anR();
                codeCacheSetting.maxCount = anR.maxCount;
                codeCacheSetting.sizeLimit = anR.sizeLimit;
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

    public static int m(boolean z, boolean z2) {
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
        private static int cQF = -1;
        private static int cQG = -1;
        private static int cQH = -1;
        private static int cQI = -1;

        public static String anO() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean gE(int i) {
            switch (i) {
                case 0:
                    return anP();
                case 1:
                    return anQ();
                default:
                    return anP();
            }
        }

        private static boolean anP() {
            boolean aEV = com.baidu.swan.apps.ad.a.a.aEV();
            if (aEV) {
                cQF = 1;
            }
            if (cQF < 0) {
                cQF = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cQF + (aEV ? " forceAb" : ""));
            }
            return cQF == 1;
        }

        private static boolean anQ() {
            boolean aEV = com.baidu.swan.apps.ad.a.a.aEV();
            if (aEV) {
                cQG = 1;
            }
            if (cQG < 0) {
                cQG = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cQG + (aEV ? " forceAb" : ""));
            }
            return cQG == 1;
        }

        public static boolean gc(int i) {
            if (DEBUG) {
                String anO = anO();
                char c = 65535;
                switch (anO.hashCode()) {
                    case 3105:
                        if (anO.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (anO.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (anO.equals("disable_code_cache")) {
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
                        return gE(i);
                }
            }
            return gE(i);
        }

        public static C0401a anR() {
            C0401a c0401a = new C0401a();
            c0401a.maxCount = anS();
            c0401a.sizeLimit = anT();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0401a.maxCount + " ,sizeLimit: " + c0401a.sizeLimit);
            }
            return c0401a;
        }

        private static int anS() {
            if (cQH < 0) {
                cQH = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_code_cache_max_count", 5);
            }
            return cQH;
        }

        private static int anT() {
            if (cQI < 0) {
                cQI = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cQI * 1024;
        }
    }
}
