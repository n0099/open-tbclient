package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class o {
    public static int aI(Context context) {
        return context.getResources().getDimensionPixelOffset(a.d.sdk_ds248);
    }

    public static int v(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int w(Activity activity) {
        return (v(activity) * 9) / 16;
    }

    public static int x(Activity activity) {
        return aI(activity) + w(activity);
    }
}
