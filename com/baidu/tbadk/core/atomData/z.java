package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.frameworkData.a {
    public z(Context context) {
        super(context);
    }

    public z a(String str) {
        getIntent().putExtra("from_page", str);
        return this;
    }
}
