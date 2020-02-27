package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class p {
    public static int aO(Context context) {
        return context.getResources().getDimensionPixelOffset(a.e.sdk_ds176);
    }

    public static int v(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int w(Activity activity) {
        return (v(activity) * 9) / 16;
    }

    public static int x(Activity activity) {
        return aO(activity) + w(activity);
    }
}
