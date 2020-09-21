package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class h {
    public static final int btG = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds32);

    public static int ay(Context context) {
        int aD = aD(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aD + UtilHelper.getStatusBarHeight();
        }
        return aD;
    }

    public static int az(Context context) {
        int aA = aA(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aA + UtilHelper.getStatusBarHeight();
        }
        return aA;
    }

    public static int aA(Context context) {
        return aD(context) + btG;
    }

    public static int aB(Context context) {
        return fG(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int aC(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int fG(int i) {
        return (i * 16) / 10;
    }

    public static int j(Context context, boolean z) {
        return aB(context) + az(context);
    }

    private static int aD(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds220);
    }
}
