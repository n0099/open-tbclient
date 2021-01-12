package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    private static int agC = 0;

    public static int eY(Context context) {
        return C(context, 0);
    }

    public static int C(Context context, int i) {
        if (context == null) {
            return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (agC <= 0) {
            agC = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(context) * 0.11d);
        }
        return agC;
    }
}
