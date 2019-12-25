package com.baidu.live.adp.lib.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class BdUtilHelper {
    private static final double EARTH_RADIUS = 6378.137d;
    private static final int TOAST_LONG = 3500;
    private static final int TOAST_SHORT = 2000;
    private static float displayMetricsDensity;
    static int displayMetricsHeightPixels;
    static int displayMetricsWidthPixels;
    static boolean deviceDataInited = false;
    private static ICustomToast mToast = null;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public interface ICustomToastView {
        View getToastContentView();

        void setToastString(String str);
    }

    public static void initDeviceData(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation == 1 || orientation == 3) {
            displayMetricsWidthPixels = displayMetrics.heightPixels;
            displayMetricsHeightPixels = displayMetrics.widthPixels;
        } else {
            displayMetricsWidthPixels = displayMetrics.widthPixels;
            displayMetricsHeightPixels = displayMetrics.heightPixels;
        }
        displayMetricsDensity = displayMetrics.density;
        deviceDataInited = true;
    }

    public static int getEquipmentWidth(Context context) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }
        return displayMetricsWidthPixels;
    }

    public static int getEquipmentHeight(Context context) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }
        return displayMetricsHeightPixels;
    }

    public static int dip2px(Context context, float f) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }
        return (int) ((displayMetricsDensity * f) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }
        return (int) ((f / displayMetricsDensity) + 0.5f);
    }

    public static float getEquipmentDensity(Context context) {
        if (!deviceDataInited) {
            initDeviceData(context);
        }
        return displayMetricsDensity;
    }

    public static void clearToast() {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = null;
    }

    public static void showToast(Context context, String str, int i) {
        if (mToast != null && !TextUtils.isEmpty(str)) {
            mToast.showToast(str, i);
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 2000);
    }

    public static void showToast(Context context, int i) {
        showToast(context, context.getResources().getString(i));
    }

    public static void showLongToast(Context context, String str) {
        showToast(context, str, TOAST_LONG);
    }

    public static void showLongToast(Context context, int i) {
        showLongToast(context, context.getResources().getString(i));
    }

    public static ProgressDialog showLoadingDialog(Context context, String str) {
        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.live.adp.lib.util.BdUtilHelper.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        };
        if (str != null) {
            return ProgressDialog.show(context, "", str, true, false, onCancelListener);
        }
        return ProgressDialog.show(context, "", context.getResources().getString(R.string.sdk_Waiting), true, false, onCancelListener);
    }

    public static ProgressDialog showLoadingDialog(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            return ProgressDialog.show(context, "", str, true, true, onCancelListener);
        }
        return ProgressDialog.show(context, "", context.getResources().getString(R.string.sdk_Waiting), true, true, onCancelListener);
    }

    public static void closeLoadingDialog(ProgressDialog progressDialog) {
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

    public static void hideSoftKeyPad(Context context, View view) {
        if (view != null) {
            try {
                if (view.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void showSoftKeyPad(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static int getStatusBarHeight(Activity activity) {
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

    public static int[] getScreenDimensions(Context context) {
        int[] iArr = new int[2];
        if (context == null) {
            return iArr;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        iArr[0] = defaultDisplay.getWidth();
        iArr[1] = defaultDisplay.getHeight();
        return iArr;
    }

    public static int[] getScreenDimenWithoutVirtualBar(Activity activity) {
        View findViewById;
        int[] iArr = new int[2];
        if (activity != null) {
            iArr = getScreenDimensions(activity.getApplicationContext());
            if (Build.VERSION.SDK_INT > 21 && (findViewById = activity.findViewById(16908336)) != null) {
                iArr[1] = findViewById.getHeight() + iArr[1];
            }
        }
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

    public static boolean isGif(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean isDataWebpFormat(byte[] bArr) {
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

    public static DisplayMetrics getScreenSize(Activity activity) {
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

    public static float measureTextWidth(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static Rect measureText(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static int getTextWidth(Paint paint, String str) {
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

    public static String getTextOmit(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static TextPaint setTextSize(Context context, TextPaint textPaint, float f) {
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

    public static int getFontHeight(Context context, float f) {
        TextPaint textPaint = new TextPaint();
        setTextSize(context, textPaint, f);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static void setWindowAlpha(Activity activity, float f) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f;
        activity.getWindow().setAttributes(attributes);
    }

    public static int getScreenBrightness(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    public static String urlAddParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.indexOf("?") < 0) {
                str = str + "?";
            } else if (!str.endsWith("?") && !str.endsWith(ETAG.ITEM_SEPARATOR)) {
                str = str + ETAG.ITEM_SEPARATOR;
            }
            return str + str2;
        }
        return str;
    }

    public static void share(Context context, String str, String str2, File file) {
        try {
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.addCategory("android.intent.category.DEFAULT");
            if (str2.length() > 140) {
                str2 = str2.substring(0, 140);
            }
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setFlags(268435456);
            intent.setType("text/plain");
            if (file != null && file.exists()) {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                intent.setType("image/*");
            }
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.sdk_share_to)));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static int[] getImageResize(int i, int i2, int i3, int i4) {
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

    private static double rad(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static int getCurrentDay() {
        return Calendar.getInstance(Locale.CHINA).get(6);
    }

    public static int getDimens(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static double GetDistance(double d, double d2, double d3, double d4) {
        double rad = rad(d);
        double rad2 = rad(d3);
        return Math.round(((Math.asin(Math.sqrt(((Math.cos(rad) * Math.cos(rad2)) * Math.pow(Math.sin((rad(d2) - rad(d4)) / 2.0d), 2.0d)) + Math.pow(Math.sin((rad - rad2) / 2.0d), 2.0d))) * 2.0d) * EARTH_RADIUS) * 10000.0d) / 10000.0d;
    }

    public static boolean hasInstallApp(Context context, String str) {
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

    public static boolean checkShortCut(Context context, String str) {
        String str2;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str2 = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str2 = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str2), new String[]{"title", "iconResource"}, "title=?", new String[]{str}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    public static void addShortcut(Context context, String str, String str2, String str3, int i) {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setComponent(new ComponentName(str2, str3));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(context, i));
        context.sendBroadcast(intent2);
    }

    public static void checkMainThread() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            if (isMainThread() ? false : true) {
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

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isNetOk() {
        return BdNetTypeUtil.isNetWorkAvailable();
    }

    public static void addToParentArea(Context context, final View view, int i, int i2, int i3, int i4) {
        final int dip2px = dip2px(context, i);
        final int dip2px2 = dip2px(context, i2);
        final int dip2px3 = dip2px(context, i3);
        final int dip2px4 = dip2px(context, i4);
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() { // from class: com.baidu.live.adp.lib.util.BdUtilHelper.2
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
                    CloseUtil.close((Reader) bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    CloseUtil.close((Reader) bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                CloseUtil.close((Reader) bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            CloseUtil.close((Reader) bufferedReader);
            throw th;
        }
        return str;
    }

    public static String getLocalDnsBak() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    str = bufferedReader.readLine();
                    CloseUtil.close((Reader) bufferedReader);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    CloseUtil.close((Reader) bufferedReader);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                CloseUtil.close((Reader) bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            CloseUtil.close((Reader) bufferedReader);
            throw th;
        }
        return str;
    }

    public static boolean isSDKVersionUp23() {
        return Build.VERSION.SDK_INT > 9;
    }

    public static boolean isFlymeOsAbove35() {
        String numFromStr;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (numFromStr = getNumFromStr(str)) != null && numFromStr.length() >= 3) {
            int i = JavaTypesHelper.toInt(getNumFromStr(numFromStr.substring(0, 1)), 0);
            int i2 = JavaTypesHelper.toInt(getNumFromStr(numFromStr.substring(1, 2)), 0);
            if (i > 3) {
                return true;
            }
            if (i == 3 && i2 >= 5) {
                return true;
            }
        }
        return false;
    }

    public static String getNumFromStr(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    private static List<String> getHeaderValueList(Map<String, List<String>> map, String str) {
        if (map == null || str == null) {
            return null;
        }
        return Collections.unmodifiableList(map.get(str));
    }

    public static String getHeaderValueString(Map<String, List<String>> map, String str) {
        if (map == null || str == null) {
            return "";
        }
        List<String> headerValueList = getHeaderValueList(map, str);
        StringBuilder sb = new StringBuilder();
        if (headerValueList != null) {
            for (String str2 : headerValueList) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static ICustomToast getCustomToast() {
        return mToast;
    }

    public static void setCustomToast(ICustomToast iCustomToast) {
        mToast = iCustomToast;
    }

    public static void clearFocus(Context context) {
        View currentFocus;
        if ((context instanceof Activity) && (currentFocus = ((Activity) context).getCurrentFocus()) != null) {
            currentFocus.clearFocus();
        }
    }
}
