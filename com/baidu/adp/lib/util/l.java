package com.baidu.adp.lib.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
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
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l {
    private static float Gs;
    static int Gt;
    static int Gu;
    private static String Gx;
    static boolean Gr = false;
    private static Toast Gv = null;
    private static a Gw = null;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Runnable mRunnable = new Runnable() { // from class: com.baidu.adp.lib.util.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.Gv != null) {
                l.Gv.cancel();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bB(String str);

        View lq();
    }

    public static void aP(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            Gt = displayMetrics.heightPixels;
            Gu = displayMetrics.widthPixels;
        } else {
            Gt = displayMetrics.widthPixels;
            Gu = displayMetrics.heightPixels;
        }
        Gs = displayMetrics.density;
        Gr = true;
    }

    public static int aO(Context context) {
        if (!Gr) {
            aP(context);
        }
        return Gt;
    }

    public static int aQ(Context context) {
        if (!Gr) {
            aP(context);
        }
        return Gu;
    }

    public static int dip2px(Context context, float f) {
        if (!Gr) {
            aP(context);
        }
        return (int) ((Gs * f) + 0.5f);
    }

    public static float aR(Context context) {
        if (!Gr) {
            aP(context);
        }
        return Gs;
    }

    public static void e(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mHandler.removeCallbacks(mRunnable);
            if (Gv == null) {
                if (Gw == null || Gw.lq() == null) {
                    Gv = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                } else {
                    Gv = new Toast(BdBaseApplication.getInst().getApp());
                    Gv.setDuration(0);
                    Gw.bB(str);
                    Gv.setView(Gw.lq());
                }
                Gv.setGravity(17, 0, dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
            } else {
                if (!str.equals(Gx)) {
                    if (Gw == null || Gw.lq() == null) {
                        Gv.setText(str);
                    } else {
                        Gw.bB(str);
                    }
                }
                int dip2px = dip2px(BdBaseApplication.getInst().getApp(), 100.0f);
                if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                    dip2px = 0;
                }
                Gv.setGravity(17, 0, dip2px);
            }
            Gx = str;
            mHandler.postDelayed(mRunnable, i);
            Gv.show();
        }
    }

    public static void showToast(Context context, String str) {
        e(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void S(Context context, String str) {
        e(context, str, 3500);
    }

    public static void g(Context context, int i) {
        S(context, context.getResources().getString(i));
    }

    public static void b(Context context, View view) {
        if (view != null) {
            try {
                if (view.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void c(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static int r(Activity activity) {
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

    public static int[] aS(Context context) {
        int[] iArr = new int[2];
        if (context == null) {
            return iArr;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
        iArr[0] = defaultDisplay.getWidth();
        iArr[1] = defaultDisplay.getHeight();
        return iArr;
    }

    public static Field getDeclaredField(Object obj, String str) {
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

    public static boolean r(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean s(byte[] bArr) {
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

    public static DisplayMetrics s(Activity activity) {
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

    public static int c(Paint paint, String str) {
        float[] fArr;
        int i = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            paint.getTextWidths(str, new float[length]);
            int i2 = 0;
            while (i2 < length) {
                int ceil = ((int) Math.ceil(fArr[i2])) + i;
                i2++;
                i = ceil;
            }
        }
        return i;
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

    public static int h(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static boolean T(Context context, String str) {
        List<PackageInfo> installedPackages;
        if (str == null || str.length() == 0 || (installedPackages = context.getPackageManager().getInstalledPackages(0)) == null) {
            return false;
        }
        for (int i = 0; i < installedPackages.size(); i++) {
            if (installedPackages.get(i).packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void lk() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            if (ll() ? false : true) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i = 1; i < stackTrace.length; i++) {
                    sb.append(stackTrace[i].getClassName());
                    sb.append(".");
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

    public static boolean ll() {
        return Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean lm() {
        return j.kV();
    }

    public static void b(Context context, final View view, int i, int i2, int i3, int i4) {
        final int dip2px = dip2px(context, i);
        final int dip2px2 = dip2px(context, i2);
        final int dip2px3 = dip2px(context, i3);
        final int dip2px4 = dip2px(context, i4);
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() { // from class: com.baidu.adp.lib.util.l.2
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.right += dip2px3;
                rect.left -= dip2px;
                rect.bottom += dip2px4;
                rect.top -= dip2px2;
                view2.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    public static String getLocalDns() {
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

    public static String ln() {
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

    public static boolean lo() {
        String bA;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (bA = bA(str)) != null && bA.length() >= 3) {
            int l = com.baidu.adp.lib.g.b.l(bA(bA.substring(0, 1)), 0);
            int l2 = com.baidu.adp.lib.g.b.l(bA(bA.substring(1, 2)), 0);
            if (l > 3) {
                return true;
            }
            if (l == 3 && l2 >= 5) {
                return true;
            }
        }
        return false;
    }

    public static String bA(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    public static a lp() {
        return Gw;
    }

    public static void a(a aVar) {
        Gw = aVar;
    }
}
