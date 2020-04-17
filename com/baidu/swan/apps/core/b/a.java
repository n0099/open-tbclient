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
    public static class C0274a {
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
                C0274a Va = b.Va();
                codeCacheSetting.maxCount = Va.maxCount;
                codeCacheSetting.sizeLimit = Va.sizeLimit;
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
        private static int bLl = -1;
        private static int bLm = -1;
        private static int bLn = -1;
        private static int bLo = -1;

        public static String UX() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean ew(int i) {
            switch (i) {
                case 0:
                    return UY();
                case 1:
                    return UZ();
                default:
                    return UY();
            }
        }

        private static boolean UY() {
            boolean aiu = com.baidu.swan.apps.ah.a.a.aiu();
            if (aiu) {
                bLl = 1;
            }
            if (bLl < 0) {
                bLl = com.baidu.swan.apps.w.a.abR().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bLl + (aiu ? " forceAb" : ""));
            }
            return bLl == 1;
        }

        private static boolean UZ() {
            boolean aiu = com.baidu.swan.apps.ah.a.a.aiu();
            if (aiu) {
                bLm = 1;
            }
            if (bLm < 0) {
                bLm = com.baidu.swan.apps.w.a.abR().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bLm + (aiu ? " forceAb" : ""));
            }
            return bLm == 1;
        }

        public static boolean dY(int i) {
            if (DEBUG) {
                String UX = UX();
                char c = 65535;
                switch (UX.hashCode()) {
                    case 3105:
                        if (UX.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (UX.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (UX.equals("disable_code_cache")) {
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

        public static C0274a Va() {
            C0274a c0274a = new C0274a();
            c0274a.maxCount = Vb();
            c0274a.sizeLimit = Vc();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0274a.maxCount + " ,sizeLimit: " + c0274a.sizeLimit);
            }
            return c0274a;
        }

        private static int Vb() {
            if (bLn < 0) {
                bLn = com.baidu.swan.apps.w.a.abR().getSwitch("swan_code_cache_max_count", 5);
            }
            return bLn;
        }

        private static int Vc() {
            if (bLo < 0) {
                bLo = com.baidu.swan.apps.w.a.abR().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bLo * 1024;
        }
    }
}
