package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class h {
    public static final int bEV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds32);

    public static int aC(Context context) {
        int aH = aH(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aH + UtilHelper.getStatusBarHeight();
        }
        return aH;
    }

    public static int aD(Context context) {
        int aE = aE(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aE + UtilHelper.getStatusBarHeight();
        }
        return aE;
    }

    public static int aE(Context context) {
        return aH(context) + bEV;
    }

    public static int aF(Context context) {
        return gd(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int aG(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int gd(int i) {
        return (i * 16) / 10;
    }

    public static int j(Context context, boolean z) {
        return aF(context) + aD(context);
    }

    private static int aH(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.d.sdk_ds220);
    }
}
