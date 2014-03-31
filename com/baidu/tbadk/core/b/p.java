package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public final class p extends com.baidu.tbadk.core.frameworkData.a {
    public p(Context context) {
        super(context);
    }

    public final p a(String str) {
        d().putExtra("from_page", str);
        return this;
    }
}
