package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.core.frameworkData.a {
    public l(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("id", str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
    }
}
