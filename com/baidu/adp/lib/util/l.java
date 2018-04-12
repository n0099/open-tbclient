package com.baidu.adp.lib.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.ar.util.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l {
    private static float xh;
    static int xi;
    static int xj;
    private static String xm;
    static boolean xg = false;
    private static Toast xk = null;
    private static a xl = null;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Runnable mRunnable = new Runnable() { // from class: com.baidu.adp.lib.util.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.xk != null) {
                l.xk.cancel();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aW(String str);

        View hm();
    }

    public static void ag(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            xi = displayMetrics.heightPixels;
            xj = displayMetrics.widthPixels;
        } else {
            xi = displayMetrics.widthPixels;
            xj = displayMetrics.heightPixels;
        }
        xh = displayMetrics.density;
        xg = true;
    }

    public static int af(Context context) {
        if (!xg) {
            ag(context);
        }
        return xi;
    }

    public static int ah(Context context) {
        if (!xg) {
            ag(context);
        }
        return xj;
    }

    public static int dip2px(Context context, float f) {
        if (!xg) {
            ag(context);
        }
        return (int) ((xh * f) + 0.5f);
    }

    public static float ai(Context context) {
        if (!xg) {
            ag(context);
        }
        return xh;
    }

    public static void showToast(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mHandler.removeCallbacks(mRunnable);
            if (xk == null) {
                if (xl == null || xl.hm() == null) {
                    xk = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                } else {
                    xk = new Toast(BdBaseApplication.getInst().getApp());
                    xk.setDuration(0);
                    xl.aW(str);
                    xk.setView(xl.hm());
                }
                xk.setGravity(17, 0, dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
            } else {
                if (!str.equals(xm)) {
                    if (xl == null || xl.hm() == null) {
                        xk.setText(str);
                    } else {
                        xl.aW(str);
                    }
                }
                int dip2px = dip2px(BdBaseApplication.getInst().getApp(), 100.0f);
                if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                    dip2px = 0;
                }
                xk.setGravity(17, 0, dip2px);
            }
            xm = str;
            mHandler.postDelayed(mRunnable, i);
            xk.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void showLongToast(Context context, String str) {
        showToast(context, str, 3500);
    }

    public static void showLongToast(Context context, int i) {
        showLongToast(context, context.getResources().getString(i));
    }

    public static void b(Context context, View view2) {
        if (view2 != null) {
            try {
                if (view2.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 2);
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void c(Context context, View view2) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static int p(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return i;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return i;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return i;
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                return i;
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
                return i;
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
                return i;
            } catch (SecurityException e7) {
                e7.printStackTrace();
                return i;
            }
        }
        return i;
    }

    public static int[] aj(Context context) {
        int[] iArr = new int[2];
        if (context == null) {
            return iArr;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        iArr[0] = defaultDisplay.getWidth();
        iArr[1] = defaultDisplay.getHeight();
        return iArr;
    }

    public static Field d(Object obj, String str) {
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

    public static boolean l(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean m(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            String str = new String(bArr, 0, 16, "UTF-8");
            if (str == null || str.indexOf("RIFF") != 0) {
                return false;
            }
            return 8 == str.indexOf("WEBPVP8 ");
        } catch (Exception e) {
            return false;
        }
    }

    public static DisplayMetrics q(Activity activity) {
        DisplayMetrics displayMetrics;
        Exception e;
        try {
            displayMetrics = new DisplayMetrics();
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.toString());
                return displayMetrics;
            }
        } catch (Exception e3) {
            displayMetrics = null;
            e = e3;
        }
        return displayMetrics;
    }

    public static float a(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static Rect b(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static int[] c(int i, int i2, int i3, int i4) {
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

    public static int e(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static void he() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            if (hf() ? false : true) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i = 1; i < stackTrace.length; i++) {
                    sb.append(stackTrace[i].getClassName());
                    sb.append(Constants.DOT);
                    sb.append(stackTrace[i].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i].getLineNumber());
                    sb.append("\n");
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static boolean hf() {
        return Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean hg() {
        return j.gP();
    }

    public static void a(Context context, final View view2, int i, int i2, int i3, int i4) {
        final int dip2px = dip2px(context, i);
        final int dip2px2 = dip2px(context, i2);
        final int dip2px3 = dip2px(context, i3);
        final int dip2px4 = dip2px(context, i4);
        final View view3 = (View) view2.getParent();
        view3.post(new Runnable() { // from class: com.baidu.adp.lib.util.l.2
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view2.getHitRect(rect);
                rect.right += dip2px3;
                rect.left -= dip2px;
                rect.bottom += dip2px4;
                rect.top -= dip2px2;
                view3.setTouchDelegate(new TouchDelegate(rect, view2));
            }
        });
    }

    public static String hh() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    n.b((Reader) bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    n.b((Reader) bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                n.b((Reader) bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            n.b((Reader) bufferedReader);
            throw th;
        }
        return str;
    }

    public static String hi() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    n.b((Reader) bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    n.b((Reader) bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                n.b((Reader) bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            n.b((Reader) bufferedReader);
            throw th;
        }
        return str;
    }

    public static boolean hj() {
        String aV;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (aV = aV(str)) != null && aV.length() >= 3) {
            int g = com.baidu.adp.lib.g.b.g(aV(aV.substring(0, 1)), 0);
            int g2 = com.baidu.adp.lib.g.b.g(aV(aV.substring(1, 2)), 0);
            if (g > 3) {
                return true;
            }
            if (g == 3 && g2 >= 5) {
                return true;
            }
        }
        return false;
    }

    public static String aV(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    public static a hk() {
        return xl;
    }

    public static void a(a aVar) {
        xl = aVar;
    }
}
