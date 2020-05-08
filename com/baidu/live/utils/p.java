package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class p {
    public static int ao(Context context) {
        return context.getResources().getDimensionPixelOffset(a.e.sdk_ds176);
    }

    public static int r(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int s(Activity activity) {
        return (r(activity) * 9) / 16;
    }

    public static int t(Activity activity) {
        return ao(activity) + s(activity);
    }
}
