package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes4.dex */
public class d {
    private static int bKb = 0;
    private static boolean bKc = false;
    private static boolean bKd = false;

    public static boolean bf(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
