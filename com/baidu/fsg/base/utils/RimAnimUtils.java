package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes5.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    private static int f1996a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1997b;
    private static int c;
    private static int d;

    private RimAnimUtils() {
    }

    public static void startActivityAnim(Context context) {
        if (context != null) {
            if (f1996a == 0 || f1997b == 0) {
                f1996a = ResUtils.anim(context, "rim_base_slide_from_right");
                f1997b = ResUtils.anim(context, "rim_base_slide_to_left");
            }
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(f1996a, f1997b);
            }
        }
    }

    public static void finishActivityAnim(Context context) {
        if (context != null) {
            if (c == 0 || d == 0) {
                c = ResUtils.anim(context, "rim_base_slide_from_left");
                d = ResUtils.anim(context, "rim_base_slide_to_right");
            }
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(c, d);
            }
            LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + c + ", mCloseExit:" + d);
        }
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }
}
