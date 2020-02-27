package com.baidu.fsg.base.restnet.beans.business.core.utils;
/* loaded from: classes4.dex */
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
