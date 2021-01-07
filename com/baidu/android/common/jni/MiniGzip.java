package com.baidu.android.common.jni;

import android.os.SystemClock;
import com.baidu.a.a.a;
import com.baidu.util.LogUtil;
import java.io.File;
/* loaded from: classes5.dex */
public final class MiniGzip {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1135a = MiniGzip.class.getSimpleName();

    static {
        System.loadLibrary("minigzip_v1");
    }

    private MiniGzip() {
    }

    public static void unGzipFile(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (str == null || str2 == null || str.equals("") || str2.equals("")) {
            LogUtil.logD(f1135a, "parameters invalid : srcFile=" + str + "//destFile=" + str2);
        } else if (!new File(str).exists()) {
            LogUtil.logD(f1135a, str + "  not exists.");
        } else if (new a(new File(str)).a()) {
            uncompressFile(str, str2);
            LogUtil.logD(f1135a, "native ungzip use time : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private static native void uncompressFile(String str, String str2);
}
