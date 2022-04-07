package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;
/* loaded from: classes.dex */
public class Logger {
    public static LottieLogger INSTANCE = new LogcatLogger();

    public static void debug(String str) {
        INSTANCE.debug(str);
    }

    public static void error(String str, Throwable th) {
        INSTANCE.error(str, th);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void warning(String str) {
        INSTANCE.warning(str);
    }

    public static void debug(String str, Throwable th) {
        INSTANCE.debug(str, th);
    }

    public static void warning(String str, Throwable th) {
        INSTANCE.warning(str, th);
    }
}
