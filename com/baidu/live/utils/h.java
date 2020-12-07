package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class h {
    public static final int bKe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds32);

    public static int bg(Context context) {
        int bl = bl(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bl + UtilHelper.getStatusBarHeight();
        }
        return bl;
    }

    public static int bh(Context context) {
        int bi = bi(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bi + UtilHelper.getStatusBarHeight();
        }
        return bi;
    }

    public static int bi(Context context) {
        return bl(context) + bKe;
    }

    public static int bj(Context context) {
        return gC(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int bk(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int gC(int i) {
        return (i * 16) / 10;
    }

    public static int o(Context context, boolean z) {
        return bj(context) + bh(context);
    }

    private static int bl(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.d.sdk_ds220);
    }
}
