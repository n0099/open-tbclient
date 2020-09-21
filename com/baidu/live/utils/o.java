package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class o {
    public static int aE(Context context) {
        return context.getResources().getDimensionPixelOffset(a.e.sdk_ds176);
    }

    public static int t(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int u(Activity activity) {
        return (t(activity) * 9) / 16;
    }

    public static int v(Activity activity) {
        return aE(activity) + u(activity);
    }
}
