package com.baidu.lbsapi.auth;

import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes4.dex */
class BLog {
    public static boolean a = false;
    private static String b = "BaiduApiAuth";

    BLog() {
    }

    public static void d() {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(b, getFileName() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + getMethodName());
    }

    public static void d(String str) {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(b, getFileName() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
    }

    public static void e(String str) {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(b, getFileName() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
    }

    public static String getFileName() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static String getLineInfo() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getLineNumber();
    }

    public static String getMethodName() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    public static String getShortTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append("[method: ").append(stackTrace[2].getMethodName()).append("; line: ").append(stackTrace[2].getLineNumber()).append("; class: ").append(stackTrace[2].getFileName()).append("]");
        return stringBuffer.toString();
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append("method: ").append(stackTrace[2].getMethodName()).append("; line: ").append(stackTrace[2].getLineNumber()).append("; class: ").append(stackTrace[2].getClassName());
        return stringBuffer.toString();
    }

    public static void i(String str) {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, getFileName() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
    }

    public static void n(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, str);
    }
}
