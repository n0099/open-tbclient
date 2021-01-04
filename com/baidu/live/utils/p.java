package com.baidu.live.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes11.dex */
public class p {
    public static int bs(Context context) {
        return context.getResources().getDimensionPixelOffset(a.d.sdk_ds248);
    }

    public static int t(Activity activity) {
        return ScreenHelper.getRealScreenWidth(activity);
    }

    public static int u(Activity activity) {
        return (t(activity) * 9) / 16;
    }

    public static int v(Activity activity) {
        return bs(activity) + u(activity);
    }
}
