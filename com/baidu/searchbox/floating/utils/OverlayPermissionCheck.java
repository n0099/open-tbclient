package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/floating/utils/OverlayPermissionCheck;", "Landroid/content/Context;", "context", "", "hasPermission", "(Landroid/content/Context;)Z", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class OverlayPermissionCheck {
    public static final OverlayPermissionCheck INSTANCE = new OverlayPermissionCheck();

    public final boolean hasPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return Settings.canDrawOverlays(context);
    }
}
