package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0419a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting bs(String str, @NonNull String str2) {
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
                C0419a anB = b.anB();
                codeCacheSetting.maxCount = anB.maxCount;
                codeCacheSetting.sizeLimit = anB.sizeLimit;
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

    /* loaded from: classes10.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cIZ = -1;
        private static int cJa = -1;
        private static int cJb = -1;
        private static int cJc = -1;

        public static String any() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean hT(int i) {
            switch (i) {
                case 0:
                    return anz();
                case 1:
                    return anA();
                default:
                    return anz();
            }
        }

        private static boolean anz() {
            boolean aEA = com.baidu.swan.apps.ad.a.a.aEA();
            if (aEA) {
                cIZ = 1;
            }
            if (cIZ < 0) {
                cIZ = com.baidu.swan.apps.t.a.awD().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cIZ + (aEA ? " forceAb" : ""));
            }
            return cIZ == 1;
        }

        private static boolean anA() {
            boolean aEA = com.baidu.swan.apps.ad.a.a.aEA();
            if (aEA) {
                cJa = 1;
            }
            if (cJa < 0) {
                cJa = com.baidu.swan.apps.t.a.awD().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cJa + (aEA ? " forceAb" : ""));
            }
            return cJa == 1;
        }

        public static boolean hs(int i) {
            if (DEBUG) {
                String any = any();
                char c = 65535;
                switch (any.hashCode()) {
                    case 3105:
                        if (any.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (any.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (any.equals("disable_code_cache")) {
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
                        return hT(i);
                }
            }
            return hT(i);
        }

        public static C0419a anB() {
            C0419a c0419a = new C0419a();
            c0419a.maxCount = anC();
            c0419a.sizeLimit = anD();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0419a.maxCount + " ,sizeLimit: " + c0419a.sizeLimit);
            }
            return c0419a;
        }

        private static int anC() {
            if (cJb < 0) {
                cJb = com.baidu.swan.apps.t.a.awD().getSwitch("swan_code_cache_max_count", 5);
            }
            return cJb;
        }

        private static int anD() {
            if (cJc < 0) {
                cJc = com.baidu.swan.apps.t.a.awD().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cJc * 1024;
        }
    }
}
