package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0421a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting bx(String str, @NonNull String str2) {
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
                C0421a aro = b.aro();
                codeCacheSetting.maxCount = aro.maxCount;
                codeCacheSetting.sizeLimit = aro.sizeLimit;
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

    /* loaded from: classes9.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cTd = -1;
        private static int cTe = -1;
        private static int cTf = -1;
        private static int cTg = -1;

        public static String arl() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean ih(int i) {
            switch (i) {
                case 0:
                    return arm();
                case 1:
                    return arn();
                default:
                    return arm();
            }
        }

        private static boolean arm() {
            boolean aIu = com.baidu.swan.apps.ad.a.a.aIu();
            if (aIu) {
                cTd = 1;
            }
            if (cTd < 0) {
                cTd = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cTd + (aIu ? " forceAb" : ""));
            }
            return cTd == 1;
        }

        private static boolean arn() {
            boolean aIu = com.baidu.swan.apps.ad.a.a.aIu();
            if (aIu) {
                cTe = 1;
            }
            if (cTe < 0) {
                cTe = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cTe + (aIu ? " forceAb" : ""));
            }
            return cTe == 1;
        }

        public static boolean hG(int i) {
            if (DEBUG) {
                String arl = arl();
                char c = 65535;
                switch (arl.hashCode()) {
                    case 3105:
                        if (arl.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (arl.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (arl.equals("disable_code_cache")) {
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
                        return ih(i);
                }
            }
            return ih(i);
        }

        public static C0421a aro() {
            C0421a c0421a = new C0421a();
            c0421a.maxCount = arp();
            c0421a.sizeLimit = arq();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0421a.maxCount + " ,sizeLimit: " + c0421a.sizeLimit);
            }
            return c0421a;
        }

        private static int arp() {
            if (cTf < 0) {
                cTf = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_code_cache_max_count", 5);
            }
            return cTf;
        }

        private static int arq() {
            if (cTg < 0) {
                cTg = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_code_cache_size_limit", 100);
            }
            return cTg * 1024;
        }
    }
}
