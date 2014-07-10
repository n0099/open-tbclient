package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.core.frameworkData.a {
    public ak(Context context, int i, int i2, String str) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID, i2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME, str);
    }
}
