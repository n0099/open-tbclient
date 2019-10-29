package com.baidu.swan.apps.process;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
/* loaded from: classes2.dex */
public enum SwanAppProcessInfo {
    UNKNOWN(-1, null, null),
    P0(0, SwanAppActivity.class, SwanAppLocalService.class),
    P1(1, SwanAppActivity1.class, SwanAppLocalService1.class),
    P2(2, SwanAppActivity2.class, SwanAppLocalService2.class),
    P3(3, SwanAppActivity3.class, SwanAppLocalService3.class),
    P4(4, SwanAppActivity4.class, SwanAppLocalService4.class),
    P5(5, SwanAppActivity5.class, SwanAppLocalService5.class);
    
    public static final int MAX_PROCESS = 5;
    public static final int PROCESS_ID_START = 0;
    private static final String SWAN_APP_PROCESS_SUFFIX = ":swan";
    private static SwanAppProcessInfo[] sIndexById;
    public final Class<? extends SwanAppActivity> activity;
    public final int id;
    public final Class<? extends SwanAppLocalService> service;
    private static SwanAppProcessInfo sCurrent = UNKNOWN;
    public static final int PROCESS_ID_END = (int) (((b.bq(AppRuntime.getAppContext()) * 5.0f) + 0.0f) + 0.5d);

    public static SwanAppProcessInfo getById(int i) {
        return (i <= UNKNOWN.id || i >= indexById().length || indexById()[i] == null) ? UNKNOWN : indexById()[i];
    }

    public static SwanAppProcessInfo[] indexById() {
        if (sIndexById == null) {
            SwanAppProcessInfo[] values = values();
            sIndexById = new SwanAppProcessInfo[values.length];
            for (SwanAppProcessInfo swanAppProcessInfo : values) {
                if (swanAppProcessInfo != null && swanAppProcessInfo.id >= 0 && swanAppProcessInfo.id < sIndexById.length && sIndexById[swanAppProcessInfo.id] == null) {
                    sIndexById[swanAppProcessInfo.id] = swanAppProcessInfo;
                }
            }
            for (int i = 0; i < sIndexById.length; i++) {
                if (sIndexById[i] == null) {
                    sIndexById[i] = UNKNOWN;
                }
            }
        }
        return sIndexById;
    }

    public static void init(SwanAppProcessInfo swanAppProcessInfo) {
        if (!sCurrent.isSwanAppProcess() && swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
            sCurrent = swanAppProcessInfo;
        }
    }

    public static SwanAppProcessInfo current() {
        return sCurrent;
    }

    SwanAppProcessInfo(int i, Class cls, Class cls2) {
        this.id = i;
        this.activity = cls;
        this.service = cls2;
    }

    public boolean isSwanAppProcess() {
        return checkProcessId(this.id);
    }

    public static boolean isSwanAppProcess(String str) {
        return !TextUtils.isEmpty(str) && str.contains(SWAN_APP_PROCESS_SUFFIX);
    }

    public static boolean checkProcessId(int i) {
        return i >= 0 && i <= PROCESS_ID_END;
    }
}
