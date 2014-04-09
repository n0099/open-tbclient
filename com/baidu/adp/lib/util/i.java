package com.baidu.adp.lib.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdNetUtil;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
public final class i {
    static int b;
    static int c;
    private static float d;
    private static String f;
    static boolean a = false;
    private static Toast e = null;
    private static Handler g = new Handler();
    private static Runnable h = new j();

    public static void a(Context context) {
        DisplayMetrics displayMetrics;
        if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            d = displayMetrics.density;
            b = displayMetrics.widthPixels;
            c = displayMetrics.heightPixels;
        }
        a = true;
    }

    public static int b(Context context) {
        if (!a) {
            a(context);
        }
        return b;
    }

    public static int c(Context context) {
        if (!a) {
            a(context);
        }
        return c;
    }

    public static int a(Context context, float f2) {
        if (!a) {
            a(context);
        }
        return (int) ((d * f2) + 0.5f);
    }

    public static float d(Context context) {
        if (!a) {
            a(context);
        }
        return d;
    }

    private static void a(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            g.removeCallbacks(h);
            if (e == null) {
                e = Toast.makeText(com.baidu.adp.a.b.a().b(), str, 0);
                e.setGravity(17, 0, a(context, 100.0f));
            } else if (!str.equals(f)) {
                e.setText(str);
            }
            f = str;
            g.postDelayed(h, i);
            e.show();
        }
    }

    public static void a(Context context, String str) {
        a(context, str, 2000);
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }

    public static void b(Context context, String str) {
        a(context, str, 3500);
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
                f.b("UtilHelper", "hideSoftKeyPad", "error = " + th.getMessage());
            }
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            f.b("UtilHelper", "showSoftKeyPad", "error = " + th.getMessage());
        }
    }

    public static int a(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return i;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return i;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return i;
            } catch (InstantiationException e5) {
                e5.printStackTrace();
                return i;
            } catch (NoSuchFieldException e6) {
                e6.printStackTrace();
                return i;
            } catch (NumberFormatException e7) {
                e7.printStackTrace();
                return i;
            } catch (SecurityException e8) {
                e8.printStackTrace();
                return i;
            }
        }
        return i;
    }

    public static int[] e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return new int[]{defaultDisplay.getWidth(), defaultDisplay.getHeight()};
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e2) {
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
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            String str = new String(bArr, 0, 16, "UTF-8");
            if (str.indexOf("RIFF") == 0) {
                return 8 == str.indexOf("WEBPVP8 ");
            }
            return false;
        } catch (Exception e2) {
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

    public static int b(Context context, float f2) {
        TextPaint textPaint = new TextPaint();
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        if (system != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, 15.0f, system.getDisplayMetrics()));
        }
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

    public static int a() {
        return Calendar.getInstance(Locale.CHINA).get(6);
    }

    public static int c(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static void b() {
        if (com.baidu.adp.a.b.a().d()) {
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

    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean d() {
        return BdNetUtil.a() != BdNetUtil.NetworkStateInfo.UNAVAIL;
    }

    public static void a(Context context, View view, int i, int i2, int i3, int i4) {
        int a2 = a(context, 0.0f);
        int a3 = a(context, 10.0f);
        int a4 = a(context, 0.0f);
        int a5 = a(context, 20.0f);
        View view2 = (View) view.getParent();
        view2.post(new k(view, a4, a2, a5, a3, view2));
    }
}
