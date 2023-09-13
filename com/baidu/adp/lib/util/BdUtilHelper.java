package com.baidu.adp.lib.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.ext.widget.toast.ToastUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.fi;
import com.baidu.tieba.ni;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BdUtilHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double EARTH_RADIUS = 6378.137d;
    public static final int TOAST_LONG = 3500;
    public static final int TOAST_SHORT = 2000;
    public static boolean deviceDataInited = false;
    public static float displayMetricsDensity = 0.0f;
    public static int displayMetricsHeightPixels = 0;
    public static int displayMetricsWidthPixels = 0;
    public static int lastOrientation = -1;
    public static Handler mHandler;
    public static String mOldMsg;
    public static Runnable mRunnable;
    public static Toast mToast;
    public static d mToastView;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface d {
        void createToastView(boolean z);

        View getToastContentView();

        void setToastString(String str);
    }

    public static double rad(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{Double.valueOf(d2)})) == null) ? (d2 * 3.141592653589793d) / 180.0d : invokeCommon.doubleValue;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && BdUtilHelper.mToast != null) {
                BdUtilHelper.mToast.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ View f;

        public c(View view2, int i, int i2, int i3, int i4, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.getHitRect(rect);
                rect.right += this.b;
                rect.left -= this.c;
                rect.bottom += this.d;
                rect.top -= this.e;
                this.f.setTouchDelegate(new TouchDelegate(rect, this.a));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1079669718, "Lcom/baidu/adp/lib/util/BdUtilHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1079669718, "Lcom/baidu/adp/lib/util/BdUtilHelper;");
                return;
            }
        }
        mHandler = new Handler(Looper.getMainLooper());
        mRunnable = new a();
    }

    public BdUtilHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getLastOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return lastOrientation;
        }
        return invokeV.intValue;
    }

    public static d getToastView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return mToastView;
        }
        return (d) invokeV.objValue;
    }

    public static boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (Looper.getMainLooper() != Looper.myLooper() || Looper.getMainLooper().getThread() != Thread.currentThread()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            TbadkCore tbadkCore = (TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE);
            if (tbadkCore != null && tbadkCore.isNetWorkAvailable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void addToParentArea(Context context, View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int dip2px = dip2px(context, i);
            int dip2px2 = dip2px(context, i2);
            int dip2px3 = dip2px(context, i3);
            int dip2px4 = dip2px(context, i4);
            View view3 = (View) view2.getParent();
            view3.post(new c(view2, dip2px3, dip2px, dip2px4, dip2px2, view3));
        }
    }

    public static void checkMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && BdBaseApplication.getInst().isDebugMode()) {
            if (!isMainThread()) {
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

    public static void closeLoadingDialog(ProgressDialog progressDialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, progressDialog) == null) && progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static float getEquipmentDensity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (!deviceDataInited) {
                initDeviceData(context);
            }
            return displayMetricsDensity;
        }
        return invokeL.floatValue;
    }

    public static int getEquipmentHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (!deviceDataInited) {
                initDeviceData(context);
            }
            return displayMetricsHeightPixels;
        }
        return invokeL.intValue;
    }

    public static int getEquipmentWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (!deviceDataInited) {
                initDeviceData(context);
            }
            return displayMetricsWidthPixels;
        }
        return invokeL.intValue;
    }

    public static String getNumFromStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static int getScreenBrightness(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, activity)) == null) {
            try {
                return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean isGif(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, bArr)) == null) {
            if (bArr == null || bArr.length < 3 || bArr[0] != 71 || bArr[1] != 73 || bArr[2] != 70) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void setToastView(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, dVar) == null) {
            mToastView = dVar;
        }
    }

    public static int dip2px(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65542, null, context, f)) == null) {
            if (!deviceDataInited) {
                initDeviceData(context);
            }
            return (int) ((f * displayMetricsDensity) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int getColorResourceId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context != null && context.getResources() != null && !TextUtils.isEmpty(str)) {
                return context.getResources().getIdentifier(str, "color", context.getPackageName());
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static Field getDeclaredField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static int getDimens(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            return context.getResources().getDimensionPixelSize(i);
        }
        return invokeLI.intValue;
    }

    public static int getEquipmentHeight(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, context, z)) == null) {
            if (!deviceDataInited || z) {
                initDeviceData(context);
            }
            return displayMetricsHeightPixels;
        }
        return invokeLZ.intValue;
    }

    public static int getEquipmentWidth(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, context, z)) == null) {
            if (!deviceDataInited || z) {
                initDeviceData(context);
            }
            return displayMetricsWidthPixels;
        }
        return invokeLZ.intValue;
    }

    public static Rect measureText(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, paint, str)) == null) {
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    public static float measureTextWidth(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, paint, str)) == null) {
            if (paint != null && str != null) {
                return paint.measureText(str);
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    public static void showLongToast(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65582, null, context, i) == null) {
            showLongToast(context, context.getResources().getString(i));
        }
    }

    public static void showSoftKeyPad(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, context, view2) == null) {
            try {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void showToast(Context context, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65585, null, context, i) == null) && context != null) {
            showToast(context, context.getResources().getString(i));
        }
    }

    public static void showToastByTextCenter(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65588, null, context, i) == null) {
            showToast(context.getResources().getString(i), 2000, true);
        }
    }

    public static double getDistance(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double rad = rad(d2);
            double rad2 = rad(d4);
            return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((rad - rad2) / 2.0d), 2.0d) + ((Math.cos(rad) * Math.cos(rad2)) * Math.pow(Math.sin((rad(d3) - rad(d5)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d;
        }
        return invokeCommon.doubleValue;
    }

    public static void share(Context context, String str, String str2, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65579, null, context, str, str2, file) == null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.addCategory("android.intent.category.DEFAULT");
                if (str2.length() > 140) {
                    str2 = str2.substring(0, Cea708Decoder.COMMAND_DLW);
                }
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setType("text/plain");
                if (file != null && file.exists()) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                }
                context.startActivity(Intent.createChooser(intent, context.getString(R.string.obfuscated_res_0x7f0f13dc)));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static int[] getImageResize(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65552, null, i, i2, i3, i4)) == null) {
            if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
                int[] iArr = new int[2];
                if (i2 > i4) {
                    i = (i * i4) / i2;
                    i2 = i4;
                }
                if (i > i3) {
                    i2 = (i2 * i3) / i;
                } else {
                    i3 = i;
                }
                iArr[0] = i3;
                iArr[1] = i2;
                return iArr;
            }
            return null;
        }
        return (int[]) invokeIIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String getLocalDns() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65554;
            InterceptResult invokeV = interceptable.invokeV(65554, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    fi.g(bufferedReader);
                    return readLine;
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    fi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fi.g(r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            fi.g(r2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String getLocalDnsBak() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65555;
            InterceptResult invokeV = interceptable.invokeV(65555, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    fi.g(bufferedReader);
                    return readLine;
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    fi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fi.g(r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            fi.g(r2);
            throw th;
        }
    }

    public static int getNumActivities() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                            return runningTaskInfo.numActivities;
                        }
                    }
                    return 0;
                }
                return 0;
            } catch (Exception e) {
                BdLog.e(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String getTopActivityName() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                            return runningTaskInfo.topActivity.getClassName();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean isFlymeOsAbove35() {
        InterceptResult invokeV;
        String numFromStr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains(ToastUtils.MEIZU_ROM) && (numFromStr = getNumFromStr(str)) != null && numFromStr.length() >= 3) {
                int i = JavaTypesHelper.toInt(getNumFromStr(numFromStr.substring(0, 1)), 0);
                int i2 = JavaTypesHelper.toInt(getNumFromStr(numFromStr.substring(1, 2)), 0);
                if (i > 3 || (i == 3 && i2 >= 5)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int[] getScreenDimensions(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            int[] iArr = new int[2];
            if (context == null) {
                return iArr;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static DisplayMetrics getScreenSize(Activity activity) {
        InterceptResult invokeL;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, activity)) == null) {
            DisplayMetrics displayMetrics2 = null;
            try {
                displayMetrics = new DisplayMetrics();
            } catch (Exception e) {
                e = e;
            }
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Exception e2) {
                e = e2;
                displayMetrics2 = displayMetrics;
                BdLog.e(e.toString());
                return displayMetrics2;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static boolean isDataWebpFormat(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            try {
                String str = new String(bArr, 0, 16, "UTF-8");
                if (str.indexOf("RIFF") != 0) {
                    return false;
                }
                if (8 != str.indexOf("WEBPVP8 ")) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int getStatusBarHeight(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, activity)) == null) {
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
        return invokeL.intValue;
    }

    public static String getTextOmit(TextPaint textPaint, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65562, null, textPaint, str, i)) == null) {
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString();
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    public static int getTextWidth(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += (int) Math.ceil(fArr[i2]);
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static void hideSoftKeyPad(Context context, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65566, null, context, view2) != null) || view2 == null) {
            return;
        }
        try {
            if (view2.getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static ProgressDialog showLoadingDialog(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, null, context, str)) == null) {
            b bVar = new b();
            if (str != null) {
                return ProgressDialog.show(context, "", str, true, false, bVar);
            }
            return ProgressDialog.show(context, "", context.getResources().getString(R.string.obfuscated_res_0x7f0f003a), true, false, bVar);
        }
        return (ProgressDialog) invokeLL.objValue;
    }

    public static void initDeviceData(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            lastOrientation = orientation;
            if (orientation != 1 && orientation != 3) {
                displayMetricsWidthPixels = displayMetrics.widthPixels;
                displayMetricsHeightPixels = displayMetrics.heightPixels;
            } else {
                displayMetricsWidthPixels = displayMetrics.heightPixels;
                displayMetricsHeightPixels = displayMetrics.widthPixels;
            }
            displayMetricsDensity = displayMetrics.density;
            deviceDataInited = true;
        }
    }

    public static void restartApp(Context context) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, context) == null) {
            try {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName())) != null) {
                        launchIntentForPackage.addFlags(67108864);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 950731, launchIntentForPackage, LaunchTaskConstants.OTHER_PROCESS));
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } finally {
                System.exit(0);
            }
        }
    }

    public static TextPaint setTextSize(Context context, TextPaint textPaint, float f) {
        InterceptResult invokeCommon;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{context, textPaint, Float.valueOf(f)})) == null) {
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
        return (TextPaint) invokeCommon.objValue;
    }

    public static ProgressDialog showLoadingDialog(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65581, null, context, str, onCancelListener)) == null) {
            if (str != null) {
                return ProgressDialog.show(context, "", str, true, true, onCancelListener);
            }
            return ProgressDialog.show(context, "", context.getResources().getString(R.string.obfuscated_res_0x7f0f003a), true, true, onCancelListener);
        }
        return (ProgressDialog) invokeLLL.objValue;
    }

    public static void showLongToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, context, str) == null) {
            showToast(str, 3500, false);
        }
    }

    public static void showToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, context, str) == null) {
            showToast(str, 2000, false);
        }
    }

    public static void showToast(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            mHandler.removeCallbacks(mRunnable);
            if (mToast != null && Build.VERSION.SDK_INT < 28) {
                d dVar = mToastView;
                if (dVar != null) {
                    dVar.createToastView(z);
                }
                if (!str.equals(mOldMsg)) {
                    d dVar2 = mToastView;
                    if (dVar2 != null && dVar2.getToastContentView() != null) {
                        mToastView.setToastString(str);
                        mToast.setView(mToastView.getToastContentView());
                    } else {
                        mToast.setText(str);
                    }
                }
                dip2px(BdBaseApplication.getInst().getApp(), 100.0f);
                int i2 = BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation;
                if (i == 3500) {
                    mToast.setDuration(1);
                } else {
                    mToast.setDuration(0);
                }
                mToast.setGravity(17, 0, 0);
            } else {
                Toast toast = mToast;
                if (toast != null) {
                    toast.cancel();
                }
                d dVar3 = mToastView;
                if (dVar3 != null) {
                    dVar3.createToastView(z);
                }
                d dVar4 = mToastView;
                if (dVar4 != null && dVar4.getToastContentView() != null) {
                    Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                    mToast = toast2;
                    ni.a(toast2);
                    if (i == 3500) {
                        mToast.setDuration(1);
                    } else {
                        mToast.setDuration(0);
                    }
                    mToastView.setToastString(str);
                    mToast.setView(mToastView.getToastContentView());
                } else {
                    if (i == 3500) {
                        Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 1);
                        mToast = makeText;
                        ni.a(makeText);
                    } else {
                        Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                        mToast = makeText2;
                        ni.a(makeText2);
                    }
                    mToast.setText(str);
                }
                dip2px(BdBaseApplication.getInst().getApp(), 100.0f);
                mToast.setGravity(17, 0, 0);
            }
            mOldMsg = str;
            mHandler.postDelayed(mRunnable, i);
            mToast.show();
        }
    }

    public static String urlAddParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                if (str.indexOf("?") < 0) {
                    str = str + "?";
                } else if (!str.endsWith("?") && !str.endsWith("&")) {
                    if ((URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) && str.contains("#")) {
                        String[] split = str.split("#");
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < split.length; i++) {
                            if (i == 0) {
                                sb = new StringBuilder(split[0] + "&" + str2);
                            } else {
                                sb.append("#");
                                sb.append(split[i]);
                            }
                        }
                        return sb.toString();
                    }
                    str = str + "&";
                }
                return str + str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}
