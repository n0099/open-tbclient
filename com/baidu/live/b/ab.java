package com.baidu.live.b;

import android.content.Context;
/* loaded from: classes4.dex */
public class ab extends k {
    public static String aEa = "PASS_ALAWHEAT_INFO";

    public ab(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, boolean z, int i2, int i3, int i4, boolean z2, int i5, String str8, String str9, boolean z3, int i6) {
        super(context, str2, str3, str4, str5, i, str6, str7, z, i2, i3, i4, z2, i5, str8, str9, z3, i6);
        getIntent().putExtra(aEa, str);
    }

    public ab(Context context) {
        super(context);
    }
}
