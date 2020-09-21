package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public final class OverlayPermissionCheck {
    public static final OverlayPermissionCheck INSTANCE = new OverlayPermissionCheck();

    private OverlayPermissionCheck() {
    }

    public final boolean hasPermission(Context context) {
        q.m(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return Settings.canDrawOverlays(context);
    }
}
