package com.baidu.fsg.base.utils;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes2.dex */
public final class RimAnimUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f5579a;

    /* renamed from: b  reason: collision with root package name */
    public static int f5580b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5581c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5582d;

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f5581c == 0 || f5582d == 0) {
            f5581c = ResUtils.anim(context, "rim_base_slide_from_left");
            f5582d = ResUtils.anim(context, "rim_base_slide_to_right");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5581c, f5582d);
        }
        LogUtil.v("xyz", "Rim-finishActivityAnim-context:" + context + ", mCloseEnter:" + f5581c + ", mCloseExit:" + f5582d);
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
        if (f5579a == 0 || f5580b == 0) {
            f5579a = ResUtils.anim(context, "rim_base_slide_from_right");
            f5580b = ResUtils.anim(context, "rim_base_slide_to_left");
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(f5579a, f5580b);
        }
    }
}
