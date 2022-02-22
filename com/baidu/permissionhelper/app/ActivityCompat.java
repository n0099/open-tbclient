package com.baidu.permissionhelper.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ActivityCompat extends ContextCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public ActivityCompat() {
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

    public static void requestPermissions(Activity activity, String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, activity, strArr, i2) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                ActivityCompatApi23.requestPermissions(activity, strArr, i2);
            } else if (activity instanceof OnRequestPermissionsResultCallback) {
                requestPermissions(activity, strArr, i2, (OnRequestPermissionsResultCallback) activity);
            }
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, str)) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, strArr)) == null) {
            if (!ApiUtil.shouldCheckPermission() || strArr == null || strArr.length == 0) {
                return false;
            }
            for (int length = strArr.length - 1; length >= 0; length--) {
                if (!shouldShowRequestPermissionRationale(activity, strArr[length])) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i2, OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65538, null, activity, strArr, i2, onRequestPermissionsResultCallback) == null) {
            if (ApiUtil.shouldCheckPermission()) {
                ActivityCompatApi23.requestPermissions(activity, strArr, i2);
            } else if (activity.isFinishing() || onRequestPermissionsResultCallback == null) {
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(strArr, activity, onRequestPermissionsResultCallback, i2) { // from class: com.baidu.permissionhelper.app.ActivityCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity val$activity;
                    public final /* synthetic */ OnRequestPermissionsResultCallback val$callback;
                    public final /* synthetic */ String[] val$permissions;
                    public final /* synthetic */ int val$requestCode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {strArr, activity, onRequestPermissionsResultCallback, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$permissions = strArr;
                        this.val$activity = activity;
                        this.val$callback = onRequestPermissionsResultCallback;
                        this.val$requestCode = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int[] iArr = new int[this.val$permissions.length];
                            PackageManager packageManager = this.val$activity.getPackageManager();
                            String packageName = this.val$activity.getPackageName();
                            int length = this.val$permissions.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                iArr[i3] = packageManager.checkPermission(this.val$permissions[i3], packageName);
                            }
                            this.val$callback.onRequestPermissionsResult(this.val$requestCode, this.val$permissions, iArr);
                        }
                    }
                });
            }
        }
    }
}
