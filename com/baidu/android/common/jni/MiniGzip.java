package com.baidu.android.common.jni;

import android.os.SystemClock;
import com.baidu.util.LogUtil;
import d.a.a.a.a;
import java.io.File;
/* loaded from: classes.dex */
public final class MiniGzip {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2545a = "MiniGzip";

    static {
        System.loadLibrary("minigzip_v1");
    }

    public static void unGzipFile(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (str == null || str2 == null || str.equals("") || str2.equals("")) {
            String str3 = f2545a;
            LogUtil.logD(str3, "parameters invalid : srcFile=" + str + "//destFile=" + str2);
        } else if (!new File(str).exists()) {
            String str4 = f2545a;
            LogUtil.logD(str4, str + "  not exists.");
        } else if (new a(new File(str)).a()) {
            uncompressFile(str, str2);
            String str5 = f2545a;
            LogUtil.logD(str5, "native ungzip use time : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public static native void uncompressFile(String str, String str2);
}
