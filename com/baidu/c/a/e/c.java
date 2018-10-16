package com.baidu.c.a.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c {
    public static void ab(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }
}
