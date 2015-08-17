package com.baidu.adp.lib.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class k {
    private static float yB;
    static int yC;
    static int yD;
    private static String yG;
    static boolean yA = false;
    private static Toast yE = null;
    private static a yF = null;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Runnable mRunnable = new l();

    /* loaded from: classes.dex */
    public interface a {
        void aU(String str);

        View jm();
    }

    public static void J(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            yC = displayMetrics.heightPixels;
            yD = displayMetrics.widthPixels;
        } else {
            yC = displayMetrics.widthPixels;
            yD = displayMetrics.heightPixels;
        }
        yB = displayMetrics.density;
        yA = true;
    }

    public static int K(Context context) {
        if (!yA) {
            J(context);
        }
        return yC;
    }

    public static int L(Context context) {
        if (!yA) {
            J(context);
        }
        return yD;
    }

    public static int dip2px(Context context, float f) {
        if (!yA) {
            J(context);
        }
        return (int) ((yB * f) + 0.5f);
    }

    public static float M(Context context) {
        if (!yA) {
            J(context);
        }
        return yB;
    }

    public static void showToast(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mHandler.removeCallbacks(mRunnable);
            if (yE == null) {
                if (yF == null || yF.jm() == null) {
                    yE = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                } else {
                    yE = new Toast(BdBaseApplication.getInst().getApp());
                    yE.setDuration(0);
                    yF.aU(str);
                    yE.setView(yF.jm());
                }
                yE.setGravity(17, 0, dip2px(BdBaseApplication.getInst().getApp(), 100.0f));
            } else if (!str.equals(yG)) {
                if (yF == null || yF.jm() == null) {
                    yE.setText(str);
                } else {
                    yF.aU(str);
                }
            }
            yG = str;
            mHandler.postDelayed(mRunnable, i);
            yE.show();
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void u(Context context, String str) {
        showToast(context, str, 3500);
    }

    public static void c(Context context, int i) {
        u(context, context.getResources().getString(i));
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

    public static int[] N(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return new int[]{defaultDisplay.getWidth(), defaultDisplay.getHeight()};
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

    public static boolean z(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean A(byte[] bArr) {
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

    public static int a(Paint paint, String str) {
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

    public static boolean v(Context context, String str) {
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

    public static void jd() {
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

    public static boolean je() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean jf() {
        return i.iO();
    }

    public static void a(Context context, View view, int i, int i2, int i3, int i4) {
        int dip2px = dip2px(context, i);
        int dip2px2 = dip2px(context, i2);
        int dip2px3 = dip2px(context, i3);
        int dip2px4 = dip2px(context, i4);
        View view2 = (View) view.getParent();
        view2.post(new m(view, dip2px3, dip2px, dip2px4, dip2px2, view2));
    }

    public static String jg() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    o.a(bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    o.a(bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                o.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            o.a(bufferedReader);
            throw th;
        }
        return str;
    }

    public static String jh() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    o.a(bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    o.a(bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                o.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            o.a(bufferedReader);
            throw th;
        }
        return str;
    }

    public static boolean ji() {
        return Build.VERSION.SDK_INT > 9;
    }

    public static boolean jj() {
        String aT;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (aT = aT(str)) != null && aT.length() >= 3) {
            int g = com.baidu.adp.lib.g.b.g(aT(aT.substring(0, 1)), 0);
            int g2 = com.baidu.adp.lib.g.b.g(aT(aT.substring(1, 2)), 0);
            if (g > 3) {
                return true;
            }
            if (g == 3 && g2 >= 5) {
                return true;
            }
        }
        return false;
    }

    public static String aT(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    public static a jk() {
        return yF;
    }

    public static void a(a aVar) {
        yF = aVar;
    }
}
