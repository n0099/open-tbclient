package com.baidu.platform.comapi.walknavi.d.a.g;

import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
/* loaded from: classes5.dex */
public final class a {
    private static int a = 5;

    public static void a(String str) {
        if (a <= 3) {
            Log.d("ARLOG", a() + HanziToPinyin.Token.SEPARATOR + str);
        }
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
