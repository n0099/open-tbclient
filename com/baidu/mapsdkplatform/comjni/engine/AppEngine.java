package com.baidu.mapsdkplatform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class AppEngine {
    public static void InitClass() {
        JNIEngine.initClass(new Bundle(), 0);
    }

    public static boolean InitEngine(Context context) {
        return JNIEngine.InitEngine(context);
    }

    public static void SetProxyInfo(String str, int i2) {
        JNIEngine.SetProxyInfo(str, i2);
    }

    public static boolean StartSocketProc() {
        return JNIEngine.StartSocketProc();
    }

    public static boolean UnInitEngine() {
        return JNIEngine.UnInitEngine();
    }

    public static void despatchMessage(int i2, int i3, int i4, long j) {
        a.a(i2, i3, i4, j);
    }
}
