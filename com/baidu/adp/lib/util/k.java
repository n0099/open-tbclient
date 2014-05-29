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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class k {
    static int b;
    static int c;
    private static float d;
    private static String f;
    static boolean a = false;
    private static Toast e = null;
    private static Handler g = new Handler();
    private static Runnable h = new l();

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

    public static void a(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            g.removeCallbacks(h);
            if (e == null) {
                e = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
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
        a(context, str, (int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
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
                BdLog.e("UtilHelper", "hideSoftKeyPad", "error = " + th.getMessage());
            }
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            BdLog.e("UtilHelper", "showSoftKeyPad", "error = " + th.getMessage());
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
            if (str == null || str.indexOf("RIFF") != 0) {
                return false;
            }
            return 8 == str.indexOf("WEBPVP8 ");
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

    public static TextPaint a(Context context, TextPaint textPaint, float f2) {
        Resources resources;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        if (resources != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, f2, resources.getDisplayMetrics()));
        }
        return textPaint;
    }

    public static int b(Context context, float f2) {
        TextPaint textPaint = new TextPaint();
        a(context, textPaint, f2);
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
        if (BdBaseApplication.getInst().isDebugMode()) {
            boolean z = false;
            if ((Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) ? true : true) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i = 1; i < stackTrace.length; i++) {
                    sb.append(stackTrace[i].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i].getLineNumber());
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
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
        int a2 = a(context, i);
        int a3 = a(context, i2);
        int a4 = a(context, i3);
        int a5 = a(context, i4);
        View view2 = (View) view.getParent();
        view2.post(new m(view, a4, a2, a5, a3, view2));
    }

    public static String e() {
        try {
            return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream())).readLine();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static String f() {
        try {
            return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream())).readLine();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
