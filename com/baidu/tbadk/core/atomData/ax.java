package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.core.frameworkData.a {
    public ax(Context context, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra("is_new_user", z);
        getIntent().putExtra("has_like_bar", z2);
    }
}
