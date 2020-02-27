package com.baidu.swan.apps.process;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppActivity1;
import com.baidu.swan.apps.SwanAppActivity2;
import com.baidu.swan.apps.SwanAppActivity3;
import com.baidu.swan.apps.SwanAppActivity4;
import com.baidu.swan.apps.SwanAppActivity5;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService1;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService2;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService3;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService4;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService5;
/* loaded from: classes11.dex */
public enum SwanAppProcessInfo {
    UNKNOWN(-1, null, null),
    P0(0, SwanAppActivity.class, SwanAppLocalService.class),
    P1(1, SwanAppActivity1.class, SwanAppLocalService1.class),
    P2(2, SwanAppActivity2.class, SwanAppLocalService2.class),
    P3(3, SwanAppActivity3.class, SwanAppLocalService3.class),
    P4(4, SwanAppActivity4.class, SwanAppLocalService4.class),
    P5(5, SwanAppActivity5.class, SwanAppLocalService5.class);
    
    public static final int PROCESS_ID_END = 5;
    public static final int PROCESS_ID_START = 0;
    private static final String SWAN_APP_PROCESS_SUFFIX = ":swan";
    private static SwanAppProcessInfo sCurrent = UNKNOWN;
    private static SwanAppProcessInfo[] sIndices;
    public final Class<? extends SwanAppActivity> activity;
    public final int index;
    public final Class<? extends SwanAppLocalService> service;

    public static SwanAppProcessInfo indexOf(int i) {
        return indices()[i];
    }

    public static SwanAppProcessInfo[] indices() {
        if (sIndices == null) {
            SwanAppProcessInfo[] values = values();
            sIndices = new SwanAppProcessInfo[values.length];
            for (SwanAppProcessInfo swanAppProcessInfo : values) {
                if (swanAppProcessInfo != null && swanAppProcessInfo.index >= 0 && swanAppProcessInfo.index < sIndices.length && sIndices[swanAppProcessInfo.index] == null) {
                    sIndices[swanAppProcessInfo.index] = swanAppProcessInfo;
                }
            }
            for (int i = 0; i < sIndices.length; i++) {
                if (sIndices[i] == null) {
                    sIndices[i] = UNKNOWN;
                }
            }
        }
        return sIndices;
    }

    public static void init(SwanAppProcessInfo swanAppProcessInfo) {
        if (!sCurrent.isSwanAppProcess() && swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
            sCurrent = swanAppProcessInfo;
        }
    }

    public static boolean isInited() {
        return UNKNOWN != sCurrent;
    }

    public static SwanAppProcessInfo current() {
        return sCurrent;
    }

    SwanAppProcessInfo(int i, Class cls, Class cls2) {
        this.index = i;
        this.activity = cls;
        this.service = cls2;
    }

    public boolean isSwanAppProcess() {
        return checkProcessId(this.index);
    }

    public static boolean isSwanAppProcess(String str) {
        return !TextUtils.isEmpty(str) && str.contains(SWAN_APP_PROCESS_SUFFIX);
    }

    public static boolean checkProcessId(int i) {
        return i >= 0 && i <= 5;
    }
}
