package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivityConfig extends c {
    public OfficialBarHistoryActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("forum_id", i);
    }
}
