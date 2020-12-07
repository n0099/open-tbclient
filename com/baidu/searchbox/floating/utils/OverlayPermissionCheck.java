package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes16.dex */
public final class OverlayPermissionCheck {
    public static final OverlayPermissionCheck INSTANCE = new OverlayPermissionCheck();

    private OverlayPermissionCheck() {
    }

    public final boolean hasPermission(Context context) {
        p.o(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return Settings.canDrawOverlays(context);
    }
}
