package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class ForumRankActivityConfig extends c {
    public static final String ID = "id";
    public static final String ST_TYPE = "st_type";

    public ForumRankActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra("st_type", str2);
    }
}
