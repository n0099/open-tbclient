package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes7.dex */
public class c {
    private static int bqt = 0;
    private static boolean bqu = false;
    private static boolean bqv = false;

    public static boolean ax(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
