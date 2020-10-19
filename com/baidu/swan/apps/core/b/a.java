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
    public static class C0393a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting bl(String str, @NonNull String str2) {
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
                C0393a ajh = b.ajh();
                codeCacheSetting.maxCount = ajh.maxCount;
                codeCacheSetting.sizeLimit = ajh.sizeLimit;
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
        private static int cuK = -1;
        private static int cuL = -1;
        private static int cuM = -1;
        private static int cuN = -1;

        public static String aje() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean hy(int i) {
            switch (i) {
                case 0:
                    return ajf();
                case 1:
                    return ajg();
                default:
                    return ajf();
            }
        }

        private static boolean ajf() {
            boolean aAg = com.baidu.swan.apps.ad.a.a.aAg();
            if (aAg) {
                cuK = 1;
            }
            if (cuK < 0) {
                cuK = com.baidu.swan.apps.t.a.asi().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cuK + (aAg ? " forceAb" : ""));
            }
            return cuK == 1;
        }

        private static boolean ajg() {
            boolean aAg = com.baidu.swan.apps.ad.a.a.aAg();
            if (aAg) {
                cuL = 1;
            }
            if (cuL < 0) {
                cuL = com.baidu.swan.apps.t.a.asi().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cuL + (aAg ? " forceAb" : ""));
            }
            return cuL == 1;
        }

        public static boolean gX(int i) {
            if (DEBUG) {
                String aje = aje();
                char c = 65535;
                switch (aje.hashCode()) {
                    case 3105:
                        if (aje.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (aje.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (aje.equals("disable_code_cache")) {
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
                        return hy(i);
                }
            }
            return hy(i);
        }

        public static C0393a ajh() {
            C0393a c0393a = new C0393a();
            c0393a.maxCount = aji();
            c0393a.sizeLimit = ajj();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0393a.maxCount + " ,sizeLimit: " + c0393a.sizeLimit);
            }
            return c0393a;
        }

        private static int aji() {
            if (cuM < 0) {
                cuM = com.baidu.swan.apps.t.a.asi().getSwitch("swan_code_cache_max_count", 5);
            }
            return cuM;
        }

        private static int ajj() {
            if (cuN < 0) {
                cuN = com.baidu.swan.apps.t.a.asi().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cuN * 1024;
        }
    }
}
