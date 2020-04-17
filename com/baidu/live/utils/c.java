package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes3.dex */
public class c {
    private static int aXH = 0;
    private static boolean aXI = false;
    private static boolean aXJ = false;

    public static boolean av(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
