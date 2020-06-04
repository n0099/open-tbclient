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
    public static class C0332a {
        public int maxCount;
        public int sizeLimit;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting aV(String str, @NonNull String str2) {
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
                C0332a XF = b.XF();
                codeCacheSetting.maxCount = XF.maxCount;
                codeCacheSetting.sizeLimit = XF.sizeLimit;
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

    public static int k(boolean z, boolean z2) {
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
        private static int bUn = -1;
        private static int bUo = -1;
        private static int bUp = -1;
        private static int bUq = -1;

        public static String XC() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        private static boolean eH(int i) {
            switch (i) {
                case 0:
                    return XD();
                case 1:
                    return XE();
                default:
                    return XD();
            }
        }

        private static boolean XD() {
            boolean ama = com.baidu.swan.apps.af.a.a.ama();
            if (ama) {
                bUn = 1;
            }
            if (bUn < 0) {
                bUn = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_app_v8_code_cache", 1);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanAppCodeCacheAbSwitch() switcher: " + bUn + (ama ? " forceAb" : ""));
            }
            return bUn == 1;
        }

        private static boolean XE() {
            boolean ama = com.baidu.swan.apps.af.a.a.ama();
            if (ama) {
                bUo = 1;
            }
            if (bUo < 0) {
                bUo = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_game_v8_code_cache", 2);
            }
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getSwanGameCodeCacheAbSwitch() switcher: " + bUo + (ama ? " forceAb" : ""));
            }
            return bUo == 1;
        }

        public static boolean eg(int i) {
            if (DEBUG) {
                String XC = XC();
                char c = 65535;
                switch (XC.hashCode()) {
                    case 3105:
                        if (XC.equals("ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 143821548:
                        if (XC.equals("enable_code_cache")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2081401959:
                        if (XC.equals("disable_code_cache")) {
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
                        return eH(i);
                }
            }
            return eH(i);
        }

        public static C0332a XF() {
            C0332a c0332a = new C0332a();
            c0332a.maxCount = XG();
            c0332a.sizeLimit = XH();
            if (DEBUG) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0332a.maxCount + " ,sizeLimit: " + c0332a.sizeLimit);
            }
            return c0332a;
        }

        private static int XG() {
            if (bUp < 0) {
                bUp = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_code_cache_max_count", 5);
            }
            return bUp;
        }

        private static int XH() {
            if (bUq < 0) {
                bUq = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_code_cache_size_limit", 100);
            }
            return bUq * 1024;
        }
    }
}
