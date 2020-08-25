package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes7.dex */
public class o {
    public static int aE(Context context) {
        return context.getResources().getDimensionPixelOffset(a.e.sdk_ds176);
    }

    public static int s(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int t(Activity activity) {
        return (s(activity) * 9) / 16;
    }

    public static int u(Activity activity) {
        return aE(activity) + t(activity);
    }
}
