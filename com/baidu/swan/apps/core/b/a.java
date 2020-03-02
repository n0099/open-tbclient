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
    public static class C0244a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting ax(String str, @NonNull String str2) {
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
                C0244a Nk = b.Nk();
                codeCacheSetting.maxCount = Nk.maxCount;
                codeCacheSetting.sizeLimit = Nk.sizeLimit;
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
        private static int bmQ = -1;
        private static int bmR = -1;
        private static int bmS = -1;
        private static int bmT = -1;

        public static String Nh() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean er(int i) {
            switch (i) {
                case 0:
                    return Ni();
                case 1:
                    return Nj();
                default:
                    return Ni();
            }
        }

        private static boolean Ni() {
            boolean aam = com.baidu.swan.apps.ah.a.a.aam();
            if (aam) {
                bmQ = 1;
            }
            if (bmQ < 0) {
                bmQ = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bmQ + (aam ? " forceAb" : ""));
            }
            return bmQ == 1;
        }

        private static boolean Nj() {
            boolean aam = com.baidu.swan.apps.ah.a.a.aam();
            if (aam) {
                bmR = 1;
            }
            if (bmR < 0) {
                bmR = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bmR + (aam ? " forceAb" : ""));
            }
            return bmR == 1;
        }

        public static boolean dT(int i) {
            if (DEBUG) {
                String Nh = Nh();
                char c = 65535;
                switch (Nh.hashCode()) {
                    case 3105:
                        if (Nh.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (Nh.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (Nh.equals("disable_code_cache")) {
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
                        return er(i);
                }
            }
            return er(i);
        }

        public static C0244a Nk() {
            C0244a c0244a = new C0244a();
            c0244a.maxCount = Nl();
            c0244a.sizeLimit = Nm();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0244a.maxCount + " ,sizeLimit: " + c0244a.sizeLimit);
            }
            return c0244a;
        }

        private static int Nl() {
            if (bmS < 0) {
                bmS = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_code_cache_max_count", 5);
            }
            return bmS;
        }

        private static int Nm() {
            if (bmT < 0) {
                bmT = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bmT * 1024;
        }
    }
}
