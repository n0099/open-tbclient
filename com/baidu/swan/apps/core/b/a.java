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
    public static class C0295a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting aF(String str, @NonNull String str2) {
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
                C0295a UZ = b.UZ();
                codeCacheSetting.maxCount = UZ.maxCount;
                codeCacheSetting.sizeLimit = UZ.sizeLimit;
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

    public static int j(boolean z, boolean z2) {
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
        private static int bLq = -1;
        private static int bLr = -1;
        private static int bLs = -1;
        private static int bLt = -1;

        public static String UW() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean ew(int i) {
            switch (i) {
                case 0:
                    return UX();
                case 1:
                    return UY();
                default:
                    return UX();
            }
        }

        private static boolean UX() {
            boolean ait = com.baidu.swan.apps.ah.a.a.ait();
            if (ait) {
                bLq = 1;
            }
            if (bLq < 0) {
                bLq = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bLq + (ait ? " forceAb" : ""));
            }
            return bLq == 1;
        }

        private static boolean UY() {
            boolean ait = com.baidu.swan.apps.ah.a.a.ait();
            if (ait) {
                bLr = 1;
            }
            if (bLr < 0) {
                bLr = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bLr + (ait ? " forceAb" : ""));
            }
            return bLr == 1;
        }

        public static boolean dY(int i) {
            if (DEBUG) {
                String UW = UW();
                char c = 65535;
                switch (UW.hashCode()) {
                    case 3105:
                        if (UW.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (UW.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (UW.equals("disable_code_cache")) {
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
                        return ew(i);
                }
            }
            return ew(i);
        }

        public static C0295a UZ() {
            C0295a c0295a = new C0295a();
            c0295a.maxCount = Va();
            c0295a.sizeLimit = Vb();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0295a.maxCount + " ,sizeLimit: " + c0295a.sizeLimit);
            }
            return c0295a;
        }

        private static int Va() {
            if (bLs < 0) {
                bLs = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_code_cache_max_count", 5);
            }
            return bLs;
        }

        private static int Vb() {
            if (bLt < 0) {
                bLt = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bLt * 1024;
        }
    }
}
