package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bg extends com.baidu.tbadk.core.frameworkData.a {
    public bg(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str2);
    }

    public bg(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str3);
    }

    public bg(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str3);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str4);
    }
}
