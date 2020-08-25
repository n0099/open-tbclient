package com.baidu.fsg.base.utils;
/* loaded from: classes10.dex */
public class ExceptionUtils {
    public static String createStackTrackMessage(Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        if (exc != null) {
            stringBuffer.append(exc.getClass()).append(": ").append(exc.getMessage()).append("\n");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                stringBuffer.append("\t").append(stackTraceElement.toString()).append("\n");
            }
        }
        return stringBuffer.toString();
    }
}
