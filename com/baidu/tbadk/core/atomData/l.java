package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.core.frameworkData.a {
    public l(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.addFlags(268435456);
        intent.putExtra("pid", str);
        intent.putExtra("panme", str2);
        intent.putExtra("iconUrl", str3);
        intent.putExtra("gifUrl", str5);
        intent.putExtra("staticUrl", str4);
        intent.putExtra("sharpText", str6);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, i);
        intent.putExtra("width", i2);
        intent.putExtra("height", i3);
    }
}
