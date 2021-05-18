package com.baidu.swan.apps.lifecycle.process;

import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes3.dex */
public enum LifecycleProcessType {
    MAIN,
    SWAN,
    OTHER;

    public static LifecycleProcessType getCurrent() {
        String curProcessName = ProcessUtils.getCurProcessName();
        if (ProcessUtils.checkIsMainProcess(curProcessName)) {
            return MAIN;
        }
        if (SwanAppProcessInfo.isSwanAppProcess(curProcessName)) {
            return SWAN;
        }
        return OTHER;
    }
}
