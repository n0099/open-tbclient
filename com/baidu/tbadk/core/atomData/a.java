package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.frameworkData.a {
    public a(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, str2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, str3);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str4);
        getIntent().putExtra("is_user_client_lower", z);
    }
}
