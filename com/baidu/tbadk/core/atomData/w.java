package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.core.frameworkData.a {
    public w(Context context) {
        super(context);
    }

    public w a(String str) {
        getIntent().putExtra("from_page", str);
        return this;
    }
}
