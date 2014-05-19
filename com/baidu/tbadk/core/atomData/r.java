package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.core.frameworkData.a {
    public r(Context context) {
        super(context);
    }

    public r a(String str) {
        getIntent().putExtra("from_page", str);
        return this;
    }
}
