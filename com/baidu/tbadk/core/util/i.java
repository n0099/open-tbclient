package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    private static int VM = 0;

    public static int cv(Context context) {
        return p(context, 0);
    }

    public static int p(Context context, int i) {
        if (context == null) {
            return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (VM <= 0) {
            VM = (int) (com.baidu.adp.lib.util.l.ah(context) * 0.11d);
        }
        return VM;
    }
}
