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
    public static class C0407a {
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
                C0407a alb = b.alb();
                codeCacheSetting.maxCount = alb.maxCount;
                codeCacheSetting.sizeLimit = alb.sizeLimit;
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
        private static int cDg = -1;
        private static int cDh = -1;
        private static int cDi = -1;
        private static int cDj = -1;

        public static String akY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean hJ(int i) {
            switch (i) {
                case 0:
                    return akZ();
                case 1:
                    return ala();
                default:
                    return akZ();
            }
        }

        private static boolean akZ() {
            boolean aCa = com.baidu.swan.apps.ad.a.a.aCa();
            if (aCa) {
                cDg = 1;
            }
            if (cDg < 0) {
                cDg = com.baidu.swan.apps.t.a.aud().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cDg + (aCa ? " forceAb" : ""));
            }
            return cDg == 1;
        }

        private static boolean ala() {
            boolean aCa = com.baidu.swan.apps.ad.a.a.aCa();
            if (aCa) {
                cDh = 1;
            }
            if (cDh < 0) {
                cDh = com.baidu.swan.apps.t.a.aud().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cDh + (aCa ? " forceAb" : ""));
            }
            return cDh == 1;
        }

        public static boolean hi(int i) {
            if (DEBUG) {
                String akY = akY();
                char c = 65535;
                switch (akY.hashCode()) {
                    case 3105:
                        if (akY.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (akY.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (akY.equals("disable_code_cache")) {
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
                        return hJ(i);
                }
            }
            return hJ(i);
        }

        public static C0407a alb() {
            C0407a c0407a = new C0407a();
            c0407a.maxCount = alc();
            c0407a.sizeLimit = ald();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0407a.maxCount + " ,sizeLimit: " + c0407a.sizeLimit);
            }
            return c0407a;
        }

        private static int alc() {
            if (cDi < 0) {
                cDi = com.baidu.swan.apps.t.a.aud().getSwitch("swan_code_cache_max_count", 5);
            }
            return cDi;
        }

        private static int ald() {
            if (cDj < 0) {
                cDj = com.baidu.swan.apps.t.a.aud().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cDj * 1024;
        }
    }
}
