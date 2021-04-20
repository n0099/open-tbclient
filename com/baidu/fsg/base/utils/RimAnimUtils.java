package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5439a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5440b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5441c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5442d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5441c == 0 || f5442d == 0) {
            f5441c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5442d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5441c, f5442d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5441c + ", mCloseExit:" + f5442d);
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static void startActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5439a == 0 || f5440b == 0) {
            f5439a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5440b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5439a, f5440b);
        }
    }
}
