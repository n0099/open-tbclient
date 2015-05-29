package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PraiseListActivityConfig extends c {
    public PraiseListActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra("post_id", str2);
        getIntent().putExtra(c.POST_DESC, str3);
        getIntent().putExtra(c.IS_FROM_PB, z);
    }
}
