package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5333a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5334b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5335c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5336d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5335c == 0 || f5336d == 0) {
            f5335c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5336d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5335c, f5336d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5335c + ", mCloseExit:" + f5336d);
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
        if (f5333a == 0 || f5334b == 0) {
            f5333a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5334b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5333a, f5334b);
        }
    }
}
