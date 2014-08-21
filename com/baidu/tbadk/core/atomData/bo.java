package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bo extends com.baidu.tbadk.core.frameworkData.a {
    public bo(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.POST_DESC, str3);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, z);
    }
}
