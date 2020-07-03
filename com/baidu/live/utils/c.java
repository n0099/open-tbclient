package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes3.dex */
public class c {
    private static int bkr = 0;
    private static boolean bks = false;
    private static boolean bkt = false;

    public static boolean au(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
