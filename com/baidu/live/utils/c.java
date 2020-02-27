package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes3.dex */
public class c {
    private static int UK = 0;
    private static boolean UL = false;
    private static boolean UM = false;

    public static boolean aJ(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
