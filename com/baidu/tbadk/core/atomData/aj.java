package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class aj extends com.baidu.tbadk.core.frameworkData.a {
    public aj(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
    }
}
