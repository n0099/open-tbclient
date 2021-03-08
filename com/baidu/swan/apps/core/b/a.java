package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0407a {
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
                C0407a anU = b.anU();
                codeCacheSetting.maxCount = anU.maxCount;
                codeCacheSetting.sizeLimit = anU.sizeLimit;
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

    /* loaded from: classes8.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cSf = -1;
        private static int cSg = -1;
        private static int cSh = -1;
        private static int cSi = -1;

        public static String anR() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean gF(int i) {
            switch (i) {
                case 0:
                    return anS();
                case 1:
                    return anT();
                default:
                    return anS();
            }
        }

        private static boolean anS() {
            boolean aEY = com.baidu.swan.apps.ad.a.a.aEY();
            if (aEY) {
                cSf = 1;
            }
            if (cSf < 0) {
                cSf = com.baidu.swan.apps.t.a.axc().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cSf + (aEY ? " forceAb" : ""));
            }
            return cSf == 1;
        }

        private static boolean anT() {
            boolean aEY = com.baidu.swan.apps.ad.a.a.aEY();
            if (aEY) {
                cSg = 1;
            }
            if (cSg < 0) {
                cSg = com.baidu.swan.apps.t.a.axc().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cSg + (aEY ? " forceAb" : ""));
            }
            return cSg == 1;
        }

        public static boolean gd(int i) {
            if (DEBUG) {
                String anR = anR();
                char c = 65535;
                switch (anR.hashCode()) {
                    case 3105:
                        if (anR.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (anR.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (anR.equals("disable_code_cache")) {
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
                        return gF(i);
                }
            }
            return gF(i);
        }

        public static C0407a anU() {
            C0407a c0407a = new C0407a();
            c0407a.maxCount = anV();
            c0407a.sizeLimit = anW();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0407a.maxCount + " ,sizeLimit: " + c0407a.sizeLimit);
            }
            return c0407a;
        }

        private static int anV() {
            if (cSh < 0) {
                cSh = com.baidu.swan.apps.t.a.axc().getSwitch("swan_code_cache_max_count", 5);
            }
            return cSh;
        }

        private static int anW() {
            if (cSi < 0) {
                cSi = com.baidu.swan.apps.t.a.axc().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cSi * 1024;
        }
    }
}
