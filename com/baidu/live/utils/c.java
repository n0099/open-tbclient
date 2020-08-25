package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes7.dex */
public class c {
    private static int bqq = 0;
    private static boolean bqr = false;
    private static boolean bqs = false;

    public static boolean ax(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
