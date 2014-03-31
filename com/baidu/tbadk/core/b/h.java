package com.baidu.tbadk.core.b;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.frameworkData.a {
    public h(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        super(context);
        Intent d = d();
        d.addFlags(268435456);
        d.putExtra("pid", str);
        d.putExtra("panme", str2);
        d.putExtra("iconUrl", str3);
        d.putExtra("gifUrl", str5);
        d.putExtra("staticUrl", str4);
        d.putExtra("sharpText", str6);
        d.putExtra("from", i);
        d.putExtra("width", i2);
        d.putExtra("height", i3);
    }
}
