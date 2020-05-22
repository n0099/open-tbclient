package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class g {
    public static int au(Context context) {
        int av = av(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return av + UtilHelper.getStatusBarHeight();
        }
        return av;
    }

    public static int av(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds220);
    }

    public static int aw(Context context) {
        return ((BdUtilHelper.getScreenDimensions(context)[0] / 2) * 4) / 3;
    }

    public static int ax(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }
}
