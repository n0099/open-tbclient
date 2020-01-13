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
    public static class C0234a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting an(String str, @NonNull String str2) {
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
                C0234a KT = b.KT();
                codeCacheSetting.maxCount = KT.maxCount;
                codeCacheSetting.sizeLimit = KT.sizeLimit;
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

    public static int h(boolean z, boolean z2) {
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
        private static int biF = -1;
        private static int biG = -1;
        private static int biH = -1;
        private static int biI = -1;

        public static String KQ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean eb(int i) {
            switch (i) {
                case 0:
                    return KR();
                case 1:
                    return KS();
                default:
                    return KR();
            }
        }

        private static boolean KR() {
            boolean XW = com.baidu.swan.apps.ah.a.a.XW();
            if (XW) {
                biF = 1;
            }
            if (biF < 0) {
                biF = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + biF + (XW ? " forceAb" : ""));
            }
            return biF == 1;
        }

        private static boolean KS() {
            boolean XW = com.baidu.swan.apps.ah.a.a.XW();
            if (XW) {
                biG = 1;
            }
            if (biG < 0) {
                biG = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + biG + (XW ? " forceAb" : ""));
            }
            return biG == 1;
        }

        public static boolean dD(int i) {
            if (DEBUG) {
                String KQ = KQ();
                char c = 65535;
                switch (KQ.hashCode()) {
                    case 3105:
                        if (KQ.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (KQ.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (KQ.equals("disable_code_cache")) {
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
                        return eb(i);
                }
            }
            return eb(i);
        }

        public static C0234a KT() {
            C0234a c0234a = new C0234a();
            c0234a.maxCount = KU();
            c0234a.sizeLimit = KV();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0234a.maxCount + " ,sizeLimit: " + c0234a.sizeLimit);
            }
            return c0234a;
        }

        private static int KU() {
            if (biH < 0) {
                biH = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_code_cache_max_count", 5);
            }
            return biH;
        }

        private static int KV() {
            if (biI < 0) {
                biI = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_code_cache_size_limit", 100);
            }
            return biI * 1024;
        }
    }
}
