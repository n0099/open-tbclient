package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean mIsHideInstallComplete = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class ApkInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String appName;
        public PackageInfo mPackageInfo;
        public final String packageName;
        public final int versionCode;
        public final String versionName;

        public ApkInfo(Context context, PackageInfo packageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, packageInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.appName = "";
            this.mPackageInfo = packageInfo;
            this.packageName = packageInfo.packageName;
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
        }

        public JSONObject toJSONObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p", this.packageName);
                    jSONObject.put("v", this.versionName);
                    jSONObject.put("c", this.versionCode);
                    jSONObject.put("s", new File(this.mPackageInfo.applicationInfo.sourceDir).lastModified());
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public JSONObject toRecentJSONObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p", this.packageName);
                    jSONObject.put("v", this.versionName);
                    jSONObject.put("c", this.versionCode);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(608526141, "Lcom/baidu/mobads/container/util/AppUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(608526141, "Lcom/baidu/mobads/container/util/AppUtils;");
        }
    }

    public AppUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Class<?> getActivityClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Object obj = null;
            try {
                obj = ReflectionUtils.invoke(Class.forName(IReflectionInfo.APP_ACTIVITY), null, "getActivityClass", null, null);
            } catch (Exception unused) {
                RemoteXAdLogger.getInstance().d("TAG", "getActivityClass exception.");
            }
            if (obj == null) {
                try {
                    return Class.forName(IReflectionInfo.APP_ACTIVITY);
                } catch (ClassNotFoundException unused2) {
                    RemoteXAdLogger.getInstance().d("TAG", "getActivityClass ClassNotFoundException.");
                }
            }
            return (Class) obj;
        }
        return (Class) invokeV.objValue;
    }

    public static String getAppPackage(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context == null ? "" : context.getPackageName() : (String) invokeL.objValue;
    }

    public static int getAppVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static Intent getInstallIntent(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            try {
                return getInstallIntent(context, new File(str));
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static ApkInfo getLocalApkFileInfo(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
                if (packageArchiveInfo != null) {
                    return new ApkInfo(context, packageArchiveInfo);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ApkInfo) invokeLL.objValue;
    }

    public static Class<?> getShellActivityClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            Object obj = null;
            try {
                obj = ReflectionUtils.invoke(Class.forName(IReflectionInfo.BD_SHELL_ACTIVITY), null, "getActivityClass", null, null);
            } catch (Exception unused) {
                RemoteXAdLogger.getInstance().d("TAG", "getShellActivityClass exception.");
            }
            if (obj == null) {
                try {
                    return Class.forName(IReflectionInfo.BD_SHELL_ACTIVITY);
                } catch (ClassNotFoundException unused2) {
                    RemoteXAdLogger.getInstance().d("TAG", "getShellActivityClass ClassNotFoundException.");
                }
            }
            return (Class) obj;
        }
        return (Class) invokeV.objValue;
    }

    public static int getTargetSdkVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Class<? super Object> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, file)) == null) {
            Object obj = null;
            try {
                try {
                    cls = Class.forName(IReflectionInfo.DOWNLOAD_FILEPROVIDER).getSuperclass();
                } catch (Throwable unused) {
                    RemoteXAdLogger.getInstance().d("TAG", "getUriForFile exception.");
                }
            } catch (ClassNotFoundException unused2) {
                cls = null;
            }
            obj = ReflectionUtils.invoke(cls, null, "getUriForFile", new Class[]{Context.class, String.class, File.class}, new Object[]{context, str, file});
            return (Uri) obj;
        }
        return (Uri) invokeLLL.objValue;
    }

    public static Uri getUriForFileByProvider(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, file)) == null) {
            try {
                return getUriForFile(context, context.getPackageName() + ".bd.provider", file);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Uri) invokeLL.objValue;
    }

    public static void installApp(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, file) == null) {
            try {
                context.startActivity(getInstallIntent(context, file));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001b A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:5:0x0005, B:6:0x0015, B:8:0x001b, B:10:0x002d, B:12:0x0031), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isForeground(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65550, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
        try {
        } catch (Exception unused) {
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            String str2 = runningAppProcessInfo.processName;
            int myPid = Process.myPid();
            if (str2.equals(str) || runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
            while (r4.hasNext()) {
            }
        }
    }

    public static boolean isHideInstallComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? mIsHideInstallComplete : invokeV.booleanValue;
    }

    public static boolean isSystemPackage(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, packageInfo)) == null) ? (packageInfo.applicationInfo.flags & 1) != 0 : invokeL.booleanValue;
    }

    public static boolean needProviderForDl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? Build.VERSION.SDK_INT >= 24 && getTargetSdkVersion(context) >= 24 : invokeL.booleanValue;
    }

    public static void openApp(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                context.startActivity(launchIntentForPackage);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean supportDl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (needProviderForDl(context) && !supportInstallApkFromPublicSdPath(context)) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    if (supportInstallApk(context, SdcardUtils.getApkDlPath(externalFilesDir.getPath()))) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean supportInstallApk(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            if (needProviderForDl(context)) {
                try {
                    File file = new File(str + "t");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    return getUriForFileByProvider(context, file) != null;
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().e(e2);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean supportInstallApkFromPublicSdPath(Context context) {
        InterceptResult invokeL;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) ? Build.VERSION.SDK_INT <= 28 && PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && PermissionUtils.hasPermission("permission_storage") && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && supportInstallApk(context, SdcardUtils.getApkDlPath(externalStorageDirectory.getPath())) : invokeL.booleanValue;
    }

    public static Intent getInstallIntent(Context context, File file) {
        InterceptResult invokeLL;
        Uri uriForFileByProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.DEFAULT");
                        if (!needProviderForDl(context)) {
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            uriForFileByProvider = Uri.fromFile(file);
                        } else {
                            intent.addFlags(RouterCallback.CODE_ERROR);
                            uriForFileByProvider = getUriForFileByProvider(context, file);
                        }
                        if (uriForFileByProvider == null) {
                            return null;
                        }
                        intent.setDataAndType(uriForFileByProvider, "application/vnd.android.package-archive");
                        if (isHideInstallComplete()) {
                            intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                        }
                        return intent;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static void installApp(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            try {
                context.startActivity(getInstallIntent(context, str));
            } catch (Exception unused) {
            }
        }
    }
}
