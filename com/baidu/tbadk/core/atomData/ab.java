package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.core.frameworkData.a {
    public ab(Context context, String str, int i, int i2) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, i);
        getIntent().putExtra("likers", i2);
    }
}
