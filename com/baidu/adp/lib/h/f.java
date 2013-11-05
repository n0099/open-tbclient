package com.baidu.adp.lib.h;

import android.content.Context;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.Toast;
/* loaded from: classes.dex */
public class f {
    public static int a(Context context, float f) {
        if (context == null) {
            context = com.baidu.adp.a.b.a();
        }
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Context context) {
        if (context == null) {
            context = com.baidu.adp.a.b.a();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        if (context == null) {
            context = com.baidu.adp.a.b.a();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void a(Context context, String str) {
        if (context == null) {
            context = com.baidu.adp.a.b.a();
        }
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(context, str, 0);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static int[] a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            return null;
        }
        int[] iArr = new int[2];
        if (i2 > i4) {
            i6 = (i * i4) / i2;
            i5 = i4;
        } else {
            i5 = i2;
            i6 = i;
        }
        if (i6 > i3) {
            i5 = (i5 * i3) / i6;
        } else {
            i3 = i6;
        }
        iArr[0] = i3;
        iArr[1] = i5;
        return iArr;
    }

    public static void a() {
        if (com.baidu.adp.a.b.a().b()) {
            boolean z = false;
            if ((Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) ? true : true) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i = 1; i < stackTrace.length; i++) {
                    sb.append(stackTrace[i].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i].getMethodName());
                    sb.append("<-");
                }
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }
}
