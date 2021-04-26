package com.baidu.platform.comapi.walknavi.d.a.g;

import android.util.Log;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f9918a = 5;

    public static void a(String str) {
        if (f9918a > 3) {
            return;
        }
        Log.d("ARLOG", a() + " " + str);
    }

    public static String a() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(stackTraceElement.getFileName());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
