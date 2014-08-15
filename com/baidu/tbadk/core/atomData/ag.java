package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ag extends com.baidu.tbadk.core.frameworkData.a {
    private boolean a;

    public ag(Context context, boolean z) {
        super(context);
        this.a = z;
        getIntent().putExtra("isfrominvitechat", this.a);
    }
}
