package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes6.dex */
public class n {
    public static int ay(Context context) {
        return context.getResources().getDimensionPixelOffset(a.e.sdk_ds176);
    }

    public static int r(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int s(Activity activity) {
        return (r(activity) * 9) / 16;
    }

    public static int t(Activity activity) {
        return ay(activity) + s(activity);
    }
}
