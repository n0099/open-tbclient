package com.baidu.swan.apps.core.b;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0376a {
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
                C0376a agw = b.agw();
                codeCacheSetting.maxCount = agw.maxCount;
                codeCacheSetting.sizeLimit = agw.sizeLimit;
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

    /* loaded from: classes3.dex */
    public static class b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static int cir = -1;
        private static int cis = -1;
        private static int cit = -1;
        private static int ciu = -1;

        public static String agt() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean hb(int i) {
            switch (i) {
                case 0:
                    return agu();
                case 1:
                    return agv();
                default:
                    return agu();
            }
        }

        private static boolean agu() {
            boolean axv = com.baidu.swan.apps.ad.a.a.axv();
            if (axv) {
                cir = 1;
            }
            if (cir < 0) {
                cir = com.baidu.swan.apps.t.a.apx().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + cir + (axv ? " forceAb" : ""));
            }
            return cir == 1;
        }

        private static boolean agv() {
            boolean axv = com.baidu.swan.apps.ad.a.a.axv();
            if (axv) {
                cis = 1;
            }
            if (cis < 0) {
                cis = com.baidu.swan.apps.t.a.apx().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + cis + (axv ? " forceAb" : ""));
            }
            return cis == 1;
        }

        public static boolean gA(int i) {
            if (DEBUG) {
                String agt = agt();
                char c = 65535;
                switch (agt.hashCode()) {
                    case 3105:
                        if (agt.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (agt.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (agt.equals("disable_code_cache")) {
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
                        return hb(i);
                }
            }
            return hb(i);
        }

        public static C0376a agw() {
            C0376a c0376a = new C0376a();
            c0376a.maxCount = agx();
            c0376a.sizeLimit = agy();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0376a.maxCount + " ,sizeLimit: " + c0376a.sizeLimit);
            }
            return c0376a;
        }

        private static int agx() {
            if (cit < 0) {
                cit = com.baidu.swan.apps.t.a.apx().getSwitch("swan_code_cache_max_count", 5);
            }
            return cit;
        }

        private static int agy() {
            if (ciu < 0) {
                ciu = com.baidu.swan.apps.t.a.apx().getSwitch("swan_code_cache_size_limit", 100);
            }
            return ciu * 1024;
        }
    }
}
