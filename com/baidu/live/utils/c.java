package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes3.dex */
public class c {
    private static int aXM = 0;
    private static boolean aXN = false;
    private static boolean aXO = false;

    public static boolean aj(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
