package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class as extends com.baidu.tbadk.core.frameworkData.a {
    public as(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str2);
    }
}
