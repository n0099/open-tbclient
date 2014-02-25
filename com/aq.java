package com;

import android.content.Context;
import com.baidu.cloudsdk.social.share.SocialShare;
/* loaded from: classes.dex */
public class aq {
    public static int a(Context context, String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "layout", context.getApplicationContext().getPackageName());
    }

    public static String a(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#3c3c3c" : "#B4B4B4";
    }

    public static int b(Context context, String str) {
        if (SocialShare.getInstance(context).getTheme() != SocialShare.Theme.LIGHT) {
            str = str + "_black";
        }
        return c(context, str);
    }

    public static String b(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#F2F5F5F5" : "#C7000000";
    }

    public static int c(Context context, String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "drawable", context.getApplicationContext().getPackageName());
    }

    public static String c(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#3c3c3c" : "#a3a3a3";
    }

    public static int d(Context context, String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "id", context.getApplicationContext().getPackageName());
    }

    public static String d(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#F6F6F6" : "#202020";
    }

    public static int e(Context context, String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "style", context.getApplicationContext().getPackageName());
    }

    public static String e(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#323232" : "#C8C8C8";
    }

    public static String f(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#323232" : "#787878";
    }

    public static String g(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#333333" : "#B3B3B3";
    }

    public static String h(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#a9a9a9" : "#B3B3B3";
    }

    public static String i(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#a3a3a3" : "#787878";
    }
}
