package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class h {
    public static final int bOR = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds32);

    public static int bm(Context context) {
        int br = br(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return br + UtilHelper.getStatusBarHeight();
        }
        return br;
    }

    public static int bn(Context context) {
        int bo = bo(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bo + UtilHelper.getStatusBarHeight();
        }
        return bo;
    }

    public static int bo(Context context) {
        return br(context) + bOR;
    }

    public static int bp(Context context) {
        return gD(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int bq(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int gD(int i) {
        return (i * 16) / 10;
    }

    public static int o(Context context, boolean z) {
        return bp(context) + bn(context);
    }

    private static int br(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.d.sdk_ds220);
    }
}
