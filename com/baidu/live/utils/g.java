package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class g {
    public static int aG(Context context) {
        int aH = aH(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aH + UtilHelper.getStatusBarHeight();
        }
        return aH;
    }

    public static int aH(Context context) {
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds142) * 2;
    }

    public static int aI(Context context) {
        return ((BdUtilHelper.getScreenDimensions(context)[0] / 2) * 4) / 3;
    }

    public static int aJ(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }
}
