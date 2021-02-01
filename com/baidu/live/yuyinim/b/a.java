package com.baidu.live.yuyinim.b;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    @SuppressLint({"UseSparseArrays"})
    private static Map<Long, Long> cdq = new HashMap();

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static void bz(Context context) {
        if (context != null) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName())));
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
