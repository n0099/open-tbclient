package com.baidu.searchbox.ng.ai.apps.process;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class AiAppsProcessInfo {
    private static final String AI_APPS_PROCESS_SUFFIX = ":aiapps";
    public static final int PROCESS_ID_END = 5;
    public static final int PROCESS_ID_START = 0;

    public static boolean isAiAppsProcess(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(AI_APPS_PROCESS_SUFFIX);
    }

    public static boolean checkProcessId(int i) {
        return i >= 0 && i <= 5;
    }
}
