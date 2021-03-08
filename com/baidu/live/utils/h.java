package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class h {
    public static final int bPp = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds32);

    public static int bk(Context context) {
        int bp = bp(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bp + UtilHelper.getStatusBarHeight();
        }
        return bp;
    }

    public static int bl(Context context) {
        int bm = bm(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return bm + UtilHelper.getStatusBarHeight();
        }
        return bm;
    }

    public static int bm(Context context) {
        return bp(context) + bPp;
    }

    public static int bn(Context context) {
        return fb(BdUtilHelper.getScreenDimensions(context)[0] / 2);
    }

    public static int bo(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }

    public static int fb(int i) {
        return (i * 16) / 10;
    }

    public static int p(Context context, boolean z) {
        return bn(context) + bl(context);
    }

    private static int bp(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.d.sdk_ds220);
    }
}
