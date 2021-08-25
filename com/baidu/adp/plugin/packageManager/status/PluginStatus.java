package com.baidu.adp.plugin.packageManager.status;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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

    /* renamed from: e  reason: collision with root package name */
    public String f36236e;

    /* renamed from: f  reason: collision with root package name */
    public int f36237f;

    /* renamed from: g  reason: collision with root package name */
    public PluginPackageManager.PluginStatus f36238g;

    /* renamed from: h  reason: collision with root package name */
    public int f36239h;

    /* renamed from: i  reason: collision with root package name */
    public String f36240i;

    /* renamed from: j  reason: collision with root package name */
    public String f36241j;
    public boolean k;

    public PluginStatus() {
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

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36239h : invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36240i : (String) invokeV.objValue;
    }

    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36236e : (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36237f : invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36241j : (String) invokeV.objValue;
    }
}
