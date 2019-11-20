package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    private static int Fb = 0;

    public static int cr(Context context) {
        return n(context, 0);
    }

    public static int n(Context context, int i) {
        if (context == null) {
            return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (Fb <= 0) {
            Fb = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(context) * 0.11d);
        }
        return Fb;
    }
}
