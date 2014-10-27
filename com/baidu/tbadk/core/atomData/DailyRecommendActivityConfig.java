package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class DailyRecommendActivityConfig extends a {
    public static String ST_TYPE = "st_type";

    public DailyRecommendActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(ST_TYPE, str);
    }
}
