package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0429a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting by(String str, @NonNull String str2) {
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
                C0429a aqb = b.aqb();
                codeCacheSetting.maxCount = aqb.maxCount;
                codeCacheSetting.sizeLimit = aqb.sizeLimit;
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

    public static int l(boolean z, boolean z2) {
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

    /* loaded from: classes25.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cOi = -1;
        private static int cOj = -1;
        private static int cOk = -1;
        private static int cOl = -1;

        public static String apY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean in(int i) {
            switch (i) {
                case 0:
                    return apZ();
                case 1:
                    return aqa();
                default:
                    return apZ();
            }
        }

        private static boolean apZ() {
            boolean aHa = com.baidu.swan.apps.ad.a.a.aHa();
            if (aHa) {
                cOi = 1;
            }
            if (cOi < 0) {
                cOi = com.baidu.swan.apps.t.a.azd().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cOi + (aHa ? " forceAb" : ""));
            }
            return cOi == 1;
        }

        private static boolean aqa() {
            boolean aHa = com.baidu.swan.apps.ad.a.a.aHa();
            if (aHa) {
                cOj = 1;
            }
            if (cOj < 0) {
                cOj = com.baidu.swan.apps.t.a.azd().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cOj + (aHa ? " forceAb" : ""));
            }
            return cOj == 1;
        }

        public static boolean hM(int i) {
            if (DEBUG) {
                String apY = apY();
                char c = 65535;
                switch (apY.hashCode()) {
                    case 3105:
                        if (apY.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (apY.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (apY.equals("disable_code_cache")) {
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
                        return in(i);
                }
            }
            return in(i);
        }

        public static C0429a aqb() {
            C0429a c0429a = new C0429a();
            c0429a.maxCount = aqc();
            c0429a.sizeLimit = aqd();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0429a.maxCount + " ,sizeLimit: " + c0429a.sizeLimit);
            }
            return c0429a;
        }

        private static int aqc() {
            if (cOk < 0) {
                cOk = com.baidu.swan.apps.t.a.azd().getSwitch("swan_code_cache_max_count", 5);
            }
            return cOk;
        }

        private static int aqd() {
            if (cOl < 0) {
                cOl = com.baidu.swan.apps.t.a.azd().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cOl * 1024;
        }
    }
}
