package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class h {
    public static final int bKf = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds32);

    public static int bl(Context context) {
        int bq = bq(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bq + UtilHelper.getStatusBarHeight();
        }
        return bq;
    }

    public static int bm(Context context) {
        int bn = bn(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bn + UtilHelper.getStatusBarHeight();
        }
        return bn;
    }

    public static int bn(Context context) {
        return bq(context) + bKf;
    }

    public static int bo(Context context) {
        return eW(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int bp(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int eW(int i) {
        return (i * 16) / 10;
    }

    public static int o(Context context, boolean z) {
        return bo(context) + bm(context);
    }

    private static int bq(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.d.sdk_ds220);
    }
}
