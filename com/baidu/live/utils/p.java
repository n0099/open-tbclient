package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes11.dex */
public class p {
    public static int br(Context context) {
        return context.getResources().getDimensionPixelOffset(a.d.sdk_ds248);
    }

    public static int bs(Context context) {
        return ScreenHelper.getRealScreenWidth(context);
    }

    public static int bt(Context context) {
        return (bs(context) * 9) / 16;
    }

    public static int bu(Context context) {
        return br(context) + bt(context);
    }
}
