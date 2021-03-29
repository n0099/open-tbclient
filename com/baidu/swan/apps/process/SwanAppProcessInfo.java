package com.baidu.swan.apps.process;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
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
    UNKNOWN(-2, false, false, null, null),
    SERVICE(-1, true, false, null, null),
    P0(0, false, true, SwanAppActivity.class, SwanAppLocalService.class),
    P1(1, false, true, SwanAppActivity1.class, SwanAppLocalService1.class),
    P2(2, false, true, SwanAppActivity2.class, SwanAppLocalService2.class),
    P3(3, false, true, SwanAppActivity3.class, SwanAppLocalService3.class),
    P4(4, false, true, SwanAppActivity4.class, SwanAppLocalService4.class),
    P5(5, false, true, SwanAppActivity5.class, SwanAppLocalService5.class);
    
    public static final int PROCESS_ID_END = 5;
    public static final int PROCESS_ID_START = 0;
    public static final String SWAN_APP_PROCESS_SUFFIX = ":swan";
    @NonNull
    public static SwanAppProcessInfo sCurrent = UNKNOWN;
    public static SwanAppProcessInfo[] sIndices;
    public final Class<? extends SwanAppActivity> activity;
    public final int index;
    public final boolean isSwanClient;
    public final boolean isSwanService;
    public final Class<? extends SwanAppLocalService> service;

    SwanAppProcessInfo(int i, boolean z, boolean z2, Class cls, Class cls2) {
        this.index = i;
        this.activity = cls;
        this.service = cls2;
        this.isSwanService = z;
        this.isSwanClient = z2;
    }

    public static boolean checkProcessId(int i) {
        return i >= 0 && i <= 5;
    }

    @NonNull
    public static SwanAppProcessInfo current() {
        return (isInited() || !ProcessUtils.isMainProcess()) ? sCurrent : init(SERVICE);
    }

    public static SwanAppProcessInfo indexOf(int i) {
        return indices()[i];
    }

    public static SwanAppProcessInfo[] indices() {
        int i;
        if (sIndices == null) {
            SwanAppProcessInfo[] values = values();
            sIndices = new SwanAppProcessInfo[values.length];
            int i2 = 0;
            for (SwanAppProcessInfo swanAppProcessInfo : values) {
                if (swanAppProcessInfo != null && (i = swanAppProcessInfo.index) >= 0) {
                    SwanAppProcessInfo[] swanAppProcessInfoArr = sIndices;
                    if (i < swanAppProcessInfoArr.length && swanAppProcessInfoArr[i] == null) {
                        swanAppProcessInfoArr[i] = swanAppProcessInfo;
                    }
                }
            }
            while (true) {
                SwanAppProcessInfo[] swanAppProcessInfoArr2 = sIndices;
                if (i2 >= swanAppProcessInfoArr2.length) {
                    break;
                }
                if (swanAppProcessInfoArr2[i2] == null) {
                    swanAppProcessInfoArr2[i2] = UNKNOWN;
                }
                i2++;
            }
        }
        return sIndices;
    }

    @NonNull
    public static SwanAppProcessInfo init(SwanAppProcessInfo swanAppProcessInfo) {
        if (!isInited() && swanAppProcessInfo != null && !sCurrent.equals(swanAppProcessInfo) && !UNKNOWN.equals(swanAppProcessInfo)) {
            sCurrent = swanAppProcessInfo;
        }
        return sCurrent;
    }

    public static boolean isInited() {
        return sCurrent.isSwanClient;
    }

    public boolean isSwanAppProcess() {
        return checkProcessId(this.index);
    }

    public static boolean isSwanAppProcess(String str) {
        return !TextUtils.isEmpty(str) && str.contains(":swan");
    }
}
