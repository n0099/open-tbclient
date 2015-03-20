package com.baidu.adp.lib.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n {
    private static float yN;
    static int yO;
    static int yP;
    private static String yR;
    static boolean yM = false;
    private static Toast yQ = null;
    private static Handler mHandler = new Handler();
    private static Runnable mRunnable = new o();

    public static void L(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            yO = displayMetrics.heightPixels;
            yP = displayMetrics.widthPixels;
        } else {
            yO = displayMetrics.widthPixels;
            yP = displayMetrics.heightPixels;
        }
        yN = displayMetrics.density;
        yM = true;
    }

    public static int M(Context context) {
        if (!yM) {
            L(context);
        }
        return yO;
    }

    public static int N(Context context) {
        if (!yM) {
            L(context);
        }
        return yP;
    }

    public static int dip2px(Context context, float f) {
        if (!yM) {
            L(context);
        }
        return (int) ((yN * f) + 0.5f);
    }

    public static float O(Context context) {
        if (!yM) {
            L(context);
        }
        return yN;
    }

    public static void iU() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
        yQ = null;
    }

    public static void showToast(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mHandler.removeCallbacks(mRunnable);
            if (yQ == null) {
                yQ = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                yQ.setGravity(17, 0, dip2px(context, 100.0f));
            } else if (!str.equals(yR)) {
                yQ.setText(str);
            }
            yR = str;
            mHandler.postDelayed(mRunnable, i);
            yQ.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void t(Context context, String str) {
        showToast(context, str, 3500);
    }

    public static void c(Context context, int i) {
        t(context, context.getResources().getString(i));
    }

    public static ProgressDialog a(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            return ProgressDialog.show(context, "", str, true, true, onCancelListener);
        }
        return ProgressDialog.show(context, "", context.getResources().getString(R.string.Waiting), true, true, onCancelListener);
    }

    public static void a(ProgressDialog progressDialog) {
        if (progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void c(Context context, View view) {
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

    public static void d(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static int l(Activity activity) {
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

    public static int[] P(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return new int[]{defaultDisplay.getWidth(), defaultDisplay.getHeight()};
    }

    public static Field c(Object obj, String str) {
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

    public static boolean n(byte[] bArr) {
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

    public static boolean o(byte[] bArr) {
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

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static int[] b(int i, int i2, int i3, int i4) {
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

    public static int d(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static boolean u(Context context, String str) {
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

    public static void iV() {
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
                    sb.append("\n");
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static boolean iW() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isNetOk() {
        return k.iH();
    }

    public static void a(Context context, View view, int i, int i2, int i3, int i4) {
        int dip2px = dip2px(context, i);
        int dip2px2 = dip2px(context, i2);
        int dip2px3 = dip2px(context, i3);
        int dip2px4 = dip2px(context, i4);
        View view2 = (View) view.getParent();
        view2.post(new p(view, dip2px3, dip2px, dip2px4, dip2px2, view2));
    }

    public static String iX() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    v.a(bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    v.a(bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                v.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            v.a(bufferedReader);
            throw th;
        }
        return str;
    }

    public static String iY() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    v.a(bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    v.a(bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                v.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            v.a(bufferedReader);
            throw th;
        }
        return str;
    }

    public static boolean iZ() {
        return Build.VERSION.SDK_INT > 9;
    }

    public static boolean ja() {
        String aO;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (aO = aO(str)) != null && aO.length() >= 3) {
            int i = com.baidu.adp.lib.g.c.toInt(aO(aO.substring(0, 1)), 0);
            int i2 = com.baidu.adp.lib.g.c.toInt(aO(aO.substring(1, 2)), 0);
            if (i > 3) {
                return true;
            }
            if (i == 3 && i2 >= 5) {
                return true;
            }
        }
        return false;
    }

    public static String aO(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    private static List<String> b(Map<String, List<String>> map, String str) {
        if (map == null || str == null) {
            return null;
        }
        return Collections.unmodifiableList(map.get(str));
    }

    public static String c(Map<String, List<String>> map, String str) {
        if (map != null && str != null) {
            List<String> b = b(map, str);
            String str2 = "";
            if (b == null) {
                return "";
            }
            Iterator<String> it = b.iterator();
            while (true) {
                String str3 = str2;
                if (it.hasNext()) {
                    str2 = String.valueOf(str3) + it.next();
                } else {
                    return str3;
                }
            }
        } else {
            return null;
        }
    }
}
