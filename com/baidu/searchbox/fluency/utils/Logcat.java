package com.baidu.searchbox.fluency.utils;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\u0006R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/Logcat;", "", "tag", "logStr", "", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "i", "w", "", "isDebug", "Z", "()Z", "setDebug", "(Z)V", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class Logcat {
    public static final Logcat INSTANCE = new Logcat();
    public static boolean isDebug = AppConfig.isDebug();

    public final boolean isDebug() {
        return isDebug;
    }

    public final void d(String tag, String logStr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logStr, "logStr");
        if (isDebug) {
            Log.d(tag, logStr);
        }
    }

    public final void e(String tag, String logStr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logStr, "logStr");
        if (isDebug) {
            Log.e(tag, logStr);
        }
    }

    public final void i(String tag, String logStr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logStr, "logStr");
        if (isDebug) {
            Log.i(tag, logStr);
        }
    }

    public final void w(String tag, String logStr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logStr, "logStr");
        if (isDebug) {
            Log.w(tag, logStr);
        }
    }

    public final void setDebug(boolean z) {
        isDebug = z;
    }
}
