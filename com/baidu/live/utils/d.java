package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes4.dex */
public class d {
    private static int btD = 0;
    private static boolean btE = false;
    private static boolean btF = false;

    public static boolean ax(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }
}
