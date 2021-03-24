package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class Sp {
    public static int isMainProcess(Context context) {
        return b.a(context);
    }

    public static Bundle mainProcessCallGetPluginStatus(int i, String str) {
        return b.a(i, str);
    }

    public static Set<Integer> mainProcessGetSubProcessPids() {
        return b.a();
    }

    public static Bundle mainProcessRequestCallPlugin(int i, Bundle bundle) {
        return b.a(i, bundle);
    }

    public static Map<Integer, Integer> mainProcessStartAllPlugin(String str) {
        return b.a(str);
    }

    public static int mainProcessStartOrStopPlugin(int i, String str, boolean z) {
        return b.a(i, str, z);
    }

    public static void registerNeedNotifySubProcess(String str, boolean z) {
        b.a(str, z);
    }

    public static Bundle subProcessRequestCallPlugin(Bundle bundle) {
        return b.a(bundle);
    }
}
