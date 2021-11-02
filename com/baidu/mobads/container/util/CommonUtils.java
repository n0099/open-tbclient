package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOG_MESSAGE = "当前是移动网络,是否继续下载?";
    public static final String DIALOG_NEG_TEXT = "连入wifi后下载";
    public static final String DIALOG_POS_TEXT = "继续下载";
    public static final String DIALOG_TITLE = "温馨提示";
    public static final String FILE_TYPE_APK = ".apk";
    public static final String MIMETYPE_APPLICATION_APK = "application/vnd.android.package-archive";
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static final String TAG = "CommonUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface DialogOperation {
        void onClickButton(boolean z);
    }

    public CommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean canDownloadLPApk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return Uri.parse(str).getPath().endsWith(".apk");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean checkRewardVideoExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Class.forName("com.baidu.mobads.interfaces.IXRewardVideoAdContainer") != null;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String convertArrayToString(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str : strArr) {
                sb.append(str);
                sb.append(",");
            }
            String sb2 = sb.toString();
            return sb2.endsWith(",") ? sb2.substring(0, sb2.length() - 1) : sb2;
        }
        return (String) invokeL.objValue;
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static Bitmap getBitmapFromURL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getCookieBaiduId(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("BAIDUID=");
            if (split.length != 2 || (str2 = split[1]) == null) {
                return "";
            }
            if (str2.contains(";")) {
                String[] split2 = str2.split(";");
                return split2.length >= 2 ? split2[0] : "";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(17)
    public static DisplayMetrics getDisplayMetrics(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static boolean getInstallPermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            boolean checkPermission = PermissionUtils.checkPermission(context, "android.permission.REQUEST_INSTALL_PACKAGES");
            if (Build.VERSION.SDK_INT < 26 || !checkPermission) {
                return false;
            }
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return invokeL.booleanValue;
    }

    public static String getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type != -1) {
                    if (type != 0) {
                        return type != 1 ? "other type" : activeNetworkInfo.getTypeName();
                    }
                    return activeNetworkInfo.getSubtypeName();
                }
                return activeNetworkInfo.getTypeName();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, bitmap, i2, i3)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i3 / width, i2 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static String getSPBaiduId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getSharedPreferences("cookiebaiduidsp", 0).getString("cookiebaiduid", "") : (String) invokeL.objValue;
    }

    public static int getScreenHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? getScreenRect(context).height() : invokeL.intValue;
    }

    @TargetApi(17)
    public static Rect getScreenRect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            try {
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    return new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
                }
                return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Rect) invokeL.objValue;
    }

    public static int getScreenWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? getScreenRect(context).width() : invokeL.intValue;
    }

    public static int getTargetVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, cls, str, clsArr)) == null) {
            try {
                return cls.getMethod(str, clsArr) != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isUrlForDownloadApk(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                RemoteXAdLogger.getInstance().d("CommonUtils", "download url is empty");
                return false;
            } else if (!"application/vnd.android.package-archive".equals(str2) && ((!"application/octet-stream".equals(str2) || TextUtils.isEmpty(str3) || !str3.contains(".apk")) && !canDownloadLPApk(str))) {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                remoteXAdLogger.d("CommonUtils", "Other Type :" + str2);
                return false;
            } else {
                RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
                remoteXAdLogger2.d("CommonUtils", "download apk: mimeType = " + str2 + ", Disposition" + str3);
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isWifi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getType() == 1;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int px2dp(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65555, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static boolean renameFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, str2)) == null) {
            try {
                File file = new File(str);
                File file2 = new File(str2);
                if (file.exists()) {
                    return file.renameTo(file2);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void setSPBaiduId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("cookiebaiduidsp", 0).edit();
            edit.putString("cookiebaiduid", str);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public static void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{activity, str, str2, str3, str4, Boolean.valueOf(z), onClickListener, onClickListener2}) == null) || activity == null) {
            return;
        }
        try {
            new AlertDialog.Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
        } catch (Throwable unused) {
        }
    }

    public static void showDownloadConfirmDialog(Context context, DialogOperation dialogOperation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65559, null, context, dialogOperation) == null) || dialogOperation == null) {
            return;
        }
        if (context == null || !(context instanceof Activity)) {
            dialogOperation.onClickButton(true);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(DIALOG_TITLE).setMessage(DIALOG_MESSAGE).setPositiveButton(DIALOG_POS_TEXT, new DialogInterface.OnClickListener(dialogOperation) { // from class: com.baidu.mobads.container.util.CommonUtils.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogOperation val$operation;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogOperation};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$operation = dialogOperation;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.val$operation.onClickButton(true);
                }
            }
        }).setNegativeButton(DIALOG_NEG_TEXT, new DialogInterface.OnClickListener(dialogOperation) { // from class: com.baidu.mobads.container.util.CommonUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogOperation val$operation;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogOperation};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$operation = dialogOperation;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    this.val$operation.onClickButton(false);
                }
            }
        }).setCancelable(false).create();
        builder.show();
    }

    public static int sp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65560, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }
}
