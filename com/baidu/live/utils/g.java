package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class g {
    public static int aJ(Context context) {
        int aK = aK(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aK + UtilHelper.getStatusBarHeight();
        }
        return aK;
    }

    public static int aK(Context context) {
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds220);
    }

    public static int aL(Context context) {
        return ((BdUtilHelper.getScreenDimensions(context)[0] / 2) * 4) / 3;
    }

    public static int aM(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }
}
