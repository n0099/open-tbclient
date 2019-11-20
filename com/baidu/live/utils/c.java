package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes6.dex */
public class c {
    private static int aqV = 0;
    private static boolean aqW = false;
    private static boolean aqX = false;

    public static boolean at(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
