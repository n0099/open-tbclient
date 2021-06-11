package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5376a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5377b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5378c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5379d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5378c == 0 || f5379d == 0) {
            f5378c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5379d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5378c, f5379d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5378c + ", mCloseExit:" + f5379d);
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
        if (f5376a == 0 || f5377b == 0) {
            f5376a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5377b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5376a, f5377b);
        }
    }
}
