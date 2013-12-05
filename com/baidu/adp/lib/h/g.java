package com.baidu.adp.lib.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f506a = false;
    private static float b;
    private static int c;
    private static int d;

    public static void a(Context context) {
        DisplayMetrics displayMetrics;
        if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            b = displayMetrics.density;
            c = displayMetrics.widthPixels;
            d = displayMetrics.heightPixels;
        }
        f506a = true;
    }

    public static int a(Context context, float f) {
        if (!f506a) {
            a(context);
        }
        return (int) ((b * f) + 0.5f);
    }

    public static int b(Context context) {
        if (!f506a) {
            a(context);
        }
        return c;
    }

    public static int c(Context context) {
        if (!f506a) {
            a(context);
        }
        return d;
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(com.baidu.adp.a.b.a(), str, 0);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }

    public static void b(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(com.baidu.adp.a.b.a(), str, 1);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static void b(Context context, int i) {
        b(context, context.getResources().getString(i));
    }

    public static void a(Context context, View view) {
        if (view != null) {
            try {
                if (view.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            } catch (Throwable th) {
                e.b("UtilHelper", "hideSoftKeyPad", "error = " + th.getMessage());
            }
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            e.b("UtilHelper", "showSoftKeyPad", "error = " + th.getMessage());
        }
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static boolean a(byte[] bArr) {
        try {
            if (bArr[0] == 71 && bArr[1] == 73) {
                if (bArr[2] == 70) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static float a(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static TextPaint a(Context context, TextPaint textPaint, float f) {
        Resources resources;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        if (resources != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, f, resources.getDisplayMetrics()));
        }
        return textPaint;
    }

    public static int b(Context context, float f) {
        TextPaint textPaint = new TextPaint();
        a(context, textPaint, f);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
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
