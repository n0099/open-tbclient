package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    private static int topMargin = 0;

    public static int dP(Context context) {
        return r(context, 0);
    }

    public static int r(Context context, int i) {
        if (context == null) {
            return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (topMargin <= 0) {
            topMargin = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(context) * 0.11d);
        }
        return topMargin;
    }
}
