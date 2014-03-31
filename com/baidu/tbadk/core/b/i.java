package com.baidu.tbadk.core.b;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.core.frameworkData.a {
    public i(Context context, String str, boolean z, String str2) {
        super(context);
        Intent d = d();
        d.putExtra("st_type", str2);
        d.putExtra("pkg_id", str);
        d.putExtra("is_downloading", z);
    }
}
