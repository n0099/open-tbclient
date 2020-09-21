package com.baidu.android.util.media;
/* loaded from: classes18.dex */
public class LogUtil {
    private static final String TAG = "Media@MediaQuery";
    private static final boolean isDebug = false;

    public static void d(Object... objArr) {
    }

    public static void e(Object... objArr) {
    }

    private static String appendStr(Object... objArr) {
        if (objArr == null || objArr.length < 1) {
            return "LogUtil empty log";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            stringBuffer.append(" = ");
            stringBuffer.append(objArr[i]);
        }
        return stringBuffer.toString();
    }
}
