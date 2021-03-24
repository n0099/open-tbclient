package com.baidu.apollon.statistics;

import android.content.Context;
/* loaded from: classes2.dex */
public class BasicStoreToolsWrapper {
    public static String getStatisticsStrategy(Context context) {
        return BasicStoreTools.getInstance().getStrategy(context);
    }
}
