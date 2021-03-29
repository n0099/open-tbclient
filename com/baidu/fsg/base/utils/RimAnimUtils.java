package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5404a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5405b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5406c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5407d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5406c == 0 || f5407d == 0) {
            f5406c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5407d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5406c, f5407d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5406c + ", mCloseExit:" + f5407d);
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
        if (f5404a == 0 || f5405b == 0) {
            f5404a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5405b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5404a, f5405b);
        }
    }
}
