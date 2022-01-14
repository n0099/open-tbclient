package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PassPermissions implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PassPermissions";
    public static PassPermissions a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public PermissionsDTO f37666b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsCallback f37667c;

    public PassPermissions() {
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

    public static boolean checkRequestPermission(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, context)) == null) {
            if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
                if (Build.VERSION.SDK_INT < 23) {
                    if (context.checkCallingOrSelfPermission(str) == 0) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized PassPermissions getInstance() {
        InterceptResult invokeV;
        PassPermissions passPermissions;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (PassPermissions.class) {
                if (a == null) {
                    a = new PassPermissions();
                }
                passPermissions = a;
            }
            return passPermissions;
        }
        return (PassPermissions) invokeV.objValue;
    }

    public PermissionsCallback getPermissionsCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37667c : (PermissionsCallback) invokeV.objValue;
    }

    public PermissionsDTO getPermissionsDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37666b : (PermissionsDTO) invokeV.objValue;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, PermissionsCallback permissionsCallback) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, permissionsDTO, permissionsCallback) == null) {
            if (permissionsDTO != null && permissionsDTO.context != null && (strArr = permissionsDTO.permissions) != null && strArr.length != 0 && permissionsCallback != null) {
                this.f37666b = permissionsDTO;
                this.f37667c = new PermissionsCallback(this, permissionsCallback) { // from class: com.baidu.pass.permissions.PassPermissions.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PermissionsCallback a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PassPermissions f37668b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, permissionsCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37668b = this;
                        this.a = permissionsCallback;
                    }

                    @Override // com.baidu.pass.permissions.PermissionsCallback
                    public void onFailure(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f37668b.a();
                            this.a.onFailure(i2);
                        }
                    }

                    @Override // com.baidu.pass.permissions.PermissionsCallback
                    public void onSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f37668b.a();
                            this.a.onSuccess();
                        }
                    }
                };
                if (a(permissionsDTO.permissions)) {
                    this.f37667c.onSuccess();
                    return;
                } else if (Build.VERSION.SDK_INT < 23) {
                    this.f37667c.onFailure(-1);
                    return;
                } else {
                    Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
                    Context context = permissionsDTO.context;
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.setFlags(268435456);
                    permissionsDTO.context.startActivity(intent);
                    return;
                }
            }
            throw new IllegalArgumentException("params is error");
        }
    }

    public boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            for (String str : strArr) {
                if (!checkRequestPermission(str, this.f37666b.context)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f37666b = null;
            this.f37667c = null;
            a = null;
        }
    }
}
