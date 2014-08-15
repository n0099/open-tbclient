package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.core.frameworkData.a {
    public t(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, z);
    }
}
