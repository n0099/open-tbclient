package com.baidu.live.d;

import android.content.Context;
/* loaded from: classes4.dex */
public class ac extends k {
    public static String aFL = "PASS_ALAWHEAT_INFO";

    public ac(Context context, String[] strArr, String str, String str2, String str3, String str4, int i, String str5, String str6, boolean z, int i2, int i3, int i4, boolean z2, int i5, String str7, String str8, boolean z3, int i6) {
        super(context, str, str2, str3, str4, i, str5, str6, z, i2, i3, i4, z2, i5, str7, str8, z3, i6);
        getIntent().putExtra(aFL, strArr);
    }

    public ac(Context context) {
        super(context);
    }
}
