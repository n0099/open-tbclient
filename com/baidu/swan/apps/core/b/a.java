package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0381a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting bg(String str, @NonNull String str2) {
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
                C0381a afM = b.afM();
                codeCacheSetting.maxCount = afM.maxCount;
                codeCacheSetting.sizeLimit = afM.sizeLimit;
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

    /* loaded from: classes8.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cgp = -1;
        private static int cgq = -1;
        private static int cgr = -1;
        private static int cgs = -1;

        public static String afJ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean gS(int i) {
            switch (i) {
                case 0:
                    return afK();
                case 1:
                    return afL();
                default:
                    return afK();
            }
        }

        private static boolean afK() {
            boolean awM = com.baidu.swan.apps.ad.a.a.awM();
            if (awM) {
                cgp = 1;
            }
            if (cgp < 0) {
                cgp = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cgp + (awM ? " forceAb" : ""));
            }
            return cgp == 1;
        }

        private static boolean afL() {
            boolean awM = com.baidu.swan.apps.ad.a.a.awM();
            if (awM) {
                cgq = 1;
            }
            if (cgq < 0) {
                cgq = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cgq + (awM ? " forceAb" : ""));
            }
            return cgq == 1;
        }

        public static boolean gr(int i) {
            if (DEBUG) {
                String afJ = afJ();
                char c = 65535;
                switch (afJ.hashCode()) {
                    case 3105:
                        if (afJ.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (afJ.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (afJ.equals("disable_code_cache")) {
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
                        return gS(i);
                }
            }
            return gS(i);
        }

        public static C0381a afM() {
            C0381a c0381a = new C0381a();
            c0381a.maxCount = afN();
            c0381a.sizeLimit = afO();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0381a.maxCount + " ,sizeLimit: " + c0381a.sizeLimit);
            }
            return c0381a;
        }

        private static int afN() {
            if (cgr < 0) {
                cgr = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_code_cache_max_count", 5);
            }
            return cgr;
        }

        private static int afO() {
            if (cgs < 0) {
                cgs = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cgs * 1024;
        }
    }
}
