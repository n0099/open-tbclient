package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class h {
    public static final int bxt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds32);

    public static int aB(Context context) {
        int aG = aG(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aG + UtilHelper.getStatusBarHeight();
        }
        return aG;
    }

    public static int aC(Context context) {
        int aD = aD(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aD + UtilHelper.getStatusBarHeight();
        }
        return aD;
    }

    public static int aD(Context context) {
        return aG(context) + bxt;
    }

    public static int aE(Context context) {
        return fP(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int aF(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int fP(int i) {
        return (i * 16) / 10;
    }

    public static int j(Context context, boolean z) {
        return aE(context) + aC(context);
    }

    private static int aG(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds220);
    }
}
