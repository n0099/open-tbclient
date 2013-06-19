package com.baidu.cyberplayer.sdk.internal;

import android.os.Build;
/* loaded from: classes.dex */
public final class VersionUtils {
    public static final int BASE = 1;
    public static final int BASE_1_1 = 2;
    public static final int CUPCAKE = 3;
    public static final int CUR_DEVELOPMENT = 10000;
    public static final int DONUT = 4;
    public static final int ECLAIR = 5;
    public static final int ECLAIR_0_1 = 6;
    public static final int ECLAIR_MR1 = 7;
    public static final int FROYO = 8;
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;

    public static int getCurrentVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static void reportlassNotSupport() {
        a(ClassNotFoundException.class);
    }

    public static void reportConstructorNotSupport() {
        a(InstantiationError.class);
    }

    public static void reportMethodNotSupport() {
        a(NoSuchMethodError.class);
    }

    public static void reportFieldNotSupport() {
        a(NoSuchFieldError.class);
    }

    private static void a(Class cls) {
        if (LogUtils.canOutput(5)) {
            StringBuilder sb = new StringBuilder(256);
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 4) {
                sb.append(cls.getName());
                sb.append(": ");
                String stackTraceElement = stackTrace[3].toString();
                sb.append(stackTraceElement.subSequence(0, stackTraceElement.indexOf(40)));
                sb.append(" (on Android ");
                sb.append(getCurrentVersion());
                sb.append(")\n");
                for (int i = 4; i < stackTrace.length; i++) {
                    sb.append("\t");
                    sb.append(stackTrace[i].toString());
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
