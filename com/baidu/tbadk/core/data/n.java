package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.webkit.URLUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class n {
    public static String a = "http://c.tieba.baidu.com/";
    private static boolean f = false;
    private static String g = "贴吧客户端反馈";
    private static String h = "2631903";
    private static String i = "";
    private static String j = "";
    private static String k = null;
    private static int l = 640;
    private static int m = 80;
    private static int n = 3;
    public static final Bitmap.Config b = Bitmap.Config.RGB_565;
    private static String o = null;
    private static int p = 1024;
    private static int q = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
    private static String r = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String s = "http://tb.himg.baidu.com/sys/portraitn/item/";
    public static String c = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String d = String.valueOf(a) + "c/p/img?";
    public static String e = "http://c.tieba.baidu.com/c/s/uploadPicture";

    public static boolean a() {
        return com.baidu.adp.a.b.a().d();
    }

    public static final String b() {
        return "com.baidu.tieba.broadcast.changeSharedPref";
    }

    public static String c() {
        return i;
    }

    public static void a(String str) {
        i = str;
    }

    public static String d() {
        return j;
    }

    public static void b(String str) {
        j = str;
    }

    public static int e() {
        return n;
    }

    public static void a(int i2) {
        n = i2;
    }

    public static final String f() {
        return "tieba";
    }

    public static int g() {
        return p;
    }

    public static int h() {
        return p;
    }

    public static void a(Context context) {
        int a2 = com.baidu.adp.lib.util.i.a(context, 427.0f);
        int i2 = a2 <= 640 ? a2 : 640;
        p = (int) (i2 * i2 * 1.6f * 2.0f);
        com.baidu.adp.lib.util.f.e("BIG_IMAGE_SIZE = " + p);
        int i3 = p * 13;
        q = i3;
        if (i3 < UtilHelper.e(context) * 0.28d) {
            q = (int) (UtilHelper.e(context) * 0.28d);
        }
        com.baidu.adp.lib.util.f.e("BIG_IMAGE_MAX_USED_MEMORY = " + q);
    }

    public static int i() {
        return q;
    }

    public static String j() {
        return k;
    }

    public static void c(String str) {
        k = str;
    }

    public static String k() {
        return o;
    }

    public static void d(String str) {
        o = str;
    }

    public static void b(Context context) {
        if (context != null && context.getResources() != null) {
            if (context.getResources().getDisplayMetrics().density < 1.0f) {
                s = r;
                m = 80;
                return;
            }
            s = c;
            m = 110;
        }
    }

    public static String l() {
        return s;
    }

    public static int m() {
        return m;
    }

    public static String n() {
        return r;
    }

    public static void e(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            r = str;
        }
    }

    public static void f(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            c = str;
        }
    }

    public static int o() {
        switch (TbadkApplication.j().L()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static int p() {
        switch (TbadkApplication.j().L()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int q() {
        return p() + 1;
    }

    public static int r() {
        return 14;
    }

    public static final String s() {
        return "com.baidu.tieba.broadcast.imagepb.pagechanged";
    }

    public static final String t() {
        return "com.baidu.tieba.broadcast.image.resized";
    }

    public static int u() {
        return l;
    }

    public static void c(Context context) {
        int sqrt = (int) Math.sqrt(com.baidu.adp.lib.util.i.b(context) * com.baidu.adp.lib.util.i.c(context));
        if (sqrt > l) {
            l = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            l = (int) (l * 0.8d);
        }
    }

    public static final int v() {
        return 230400;
    }

    public static int w() {
        return 22050;
    }

    public static String x() {
        return g;
    }

    public static String y() {
        return h;
    }

    public static final String z() {
        return "com.baidu.tieba.broadcast.newversion";
    }
}
