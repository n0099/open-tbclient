package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivityConfig extends a {
    public OfficialBarHistoryActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("forum_id", i);
    }
}
