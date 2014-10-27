package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class FrsGroupActivityConfig extends a {
    public FrsGroupActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra(a.SHOW_RECOMMEND, z);
    }
}
