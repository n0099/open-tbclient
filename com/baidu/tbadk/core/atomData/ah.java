package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ah extends com.baidu.tbadk.core.frameworkData.a {
    public ah(Context context, String str, String str2, int i, int i2, String str3) {
        super(context);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.REPLAY_URL, str2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID, i2);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME, str3);
    }
}
