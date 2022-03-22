package com.baidu.adp.plugin.packageManager.status;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PluginStatus extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_INSTALL_ERROR_ROMSIZE = 2;
    public static final int STATUS_INSTALL_FSYNC_FAILED = 5;
    public static final int STATUS_INSTALL_ONLYREAD_FILESYSTEM = 3;
    public static final int STATUS_INSTALL_PERMISSION_DENIED = 4;
    public static final int STATUS_INSTALL_RETRY_TIMEOUT = 6;
    public static final int STATUS_INSTALL_UNKNOWN = 1;
    public static final int STATUS_LOAD_UNKNOWN = 100;
    public static final int STATUS_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public PluginPackageManager.PluginStatus f23879b;

    /* renamed from: c  reason: collision with root package name */
    public int f23880c;

    /* renamed from: d  reason: collision with root package name */
    public String f23881d;

    /* renamed from: e  reason: collision with root package name */
    public String f23882e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23883f;

    public PluginStatus() {
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

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23880c : invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23881d : (String) invokeV.objValue;
    }

    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23882e : (String) invokeV.objValue;
    }
}
