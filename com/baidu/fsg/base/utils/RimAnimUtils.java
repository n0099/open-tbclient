package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5403a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5404b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5405c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5406d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5405c == 0 || f5406d == 0) {
            f5405c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5406d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5405c, f5406d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5405c + ", mCloseExit:" + f5406d);
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
        if (f5403a == 0 || f5404b == 0) {
            f5403a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5404b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5403a, f5404b);
        }
    }
}
