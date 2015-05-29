package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class FrsGroupActivityConfig extends c {
    public FrsGroupActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra(c.SHOW_RECOMMEND, z);
    }
}
