package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0417a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting br(String str, @NonNull String str2) {
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
                C0417a amT = b.amT();
                codeCacheSetting.maxCount = amT.maxCount;
                codeCacheSetting.sizeLimit = amT.sizeLimit;
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

    /* loaded from: classes7.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cHp = -1;
        private static int cHq = -1;
        private static int cHr = -1;
        private static int cHs = -1;

        public static String amQ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean hP(int i) {
            switch (i) {
                case 0:
                    return amR();
                case 1:
                    return amS();
                default:
                    return amR();
            }
        }

        private static boolean amR() {
            boolean aDS = com.baidu.swan.apps.ad.a.a.aDS();
            if (aDS) {
                cHp = 1;
            }
            if (cHp < 0) {
                cHp = com.baidu.swan.apps.t.a.avV().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cHp + (aDS ? " forceAb" : ""));
            }
            return cHp == 1;
        }

        private static boolean amS() {
            boolean aDS = com.baidu.swan.apps.ad.a.a.aDS();
            if (aDS) {
                cHq = 1;
            }
            if (cHq < 0) {
                cHq = com.baidu.swan.apps.t.a.avV().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cHq + (aDS ? " forceAb" : ""));
            }
            return cHq == 1;
        }

        public static boolean ho(int i) {
            if (DEBUG) {
                String amQ = amQ();
                char c = 65535;
                switch (amQ.hashCode()) {
                    case 3105:
                        if (amQ.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (amQ.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (amQ.equals("disable_code_cache")) {
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
                        return hP(i);
                }
            }
            return hP(i);
        }

        public static C0417a amT() {
            C0417a c0417a = new C0417a();
            c0417a.maxCount = amU();
            c0417a.sizeLimit = amV();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0417a.maxCount + " ,sizeLimit: " + c0417a.sizeLimit);
            }
            return c0417a;
        }

        private static int amU() {
            if (cHr < 0) {
                cHr = com.baidu.swan.apps.t.a.avV().getSwitch("swan_code_cache_max_count", 5);
            }
            return cHr;
        }

        private static int amV() {
            if (cHs < 0) {
                cHs = com.baidu.swan.apps.t.a.avV().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cHs * 1024;
        }
    }
}
