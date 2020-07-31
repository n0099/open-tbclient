package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes4.dex */
public class c {
    private static int bkL = 0;
    private static boolean bkM = false;
    private static boolean bkN = false;

    public static boolean au(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
