package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bd extends com.baidu.tbadk.core.frameworkData.a {
    public bd(Context context, String str) {
        super(context);
        getIntent().putExtra("name", str);
    }
}
