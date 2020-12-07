package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    private static int agU = 0;

    public static int eH(Context context) {
        return B(context, 0);
    }

    public static int B(Context context, int i) {
        if (context == null) {
            return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (agU <= 0) {
            agU = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(context) * 0.11d);
        }
        return agU;
    }
}
