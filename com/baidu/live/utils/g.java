package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class g {
    public static int av(Context context) {
        int aw = aw(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return aw + UtilHelper.getStatusBarHeight();
        }
        return aw;
    }

    public static int aw(Context context) {
        if (context == null) {
            context = TbadkCoreApplication.getInst().getContext();
        }
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds220);
    }

    public static int ax(Context context) {
        return ((BdUtilHelper.getScreenDimensions(context)[0] / 2) * 4) / 3;
    }

    public static int ay(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }
}
