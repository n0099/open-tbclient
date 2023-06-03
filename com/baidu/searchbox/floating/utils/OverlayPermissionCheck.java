package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/floating/utils/OverlayPermissionCheck;", "", "()V", "hasPermission", "", "context", "Landroid/content/Context;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
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
