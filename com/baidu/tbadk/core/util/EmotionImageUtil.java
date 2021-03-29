package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class EmotionImageUtil {
    public static int topMargin;

    public static int getEmotionTopMargin(Context context) {
        return getEmotionTopMargin(context, 0);
    }

    public static int getEmotionTopMargin(Context context, int i) {
        if (context == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
        }
        if (topMargin <= 0) {
            topMargin = (int) (l.i(context) * 0.11d);
        }
        return topMargin;
    }
}
