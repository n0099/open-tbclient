package com.baidu.live.utils;

import android.content.Context;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class f {
    public static int au(Context context) {
        int av = av(context);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return av + UtilHelper.getStatusBarHeight();
        }
        return av;
    }

    public static int av(Context context) {
        return context.getResources().getDimensionPixelSize(a.e.sdk_ds142) * 2;
    }

    public static int aw(Context context) {
        return ((BdUtilHelper.getScreenDimensions(context)[0] / 2) * 4) / 3;
    }

    public static int ax(Context context) {
        return BdUtilHelper.getScreenDimensions(context)[0] / 2;
    }
}
