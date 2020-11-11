package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes4.dex */
public class d {
    private static int bGD = 0;
    private static boolean bGE = false;
    private static boolean bGF = false;

    public static boolean aB(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
