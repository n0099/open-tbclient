package com.baidu.mobads.container;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.config.AppCommonConfig;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.gray.CloudControlConfig;
import com.baidu.mobads.container.preload.XAdMaterialsLoader;
import com.baidu.mobads.container.util.APKInstallReceiver;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AllInOneXAdContainerFactory implements IXAdContainerFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AllInOneXAdContainerFactory";
    public static final String TASK_MODULE_PERMISSION = "permission_module";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppCxt;

    public AllInOneXAdContainerFactory(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppCxt = context.getApplicationContext();
        try {
            AppConfigImp.getInstance().setAppContext(this.mAppCxt);
            registerPackageChangeReciver(this.mAppCxt);
            XAdMaterialsLoader.getInstance().startLoadRemoteSetting(this.mAppCxt);
        } catch (Throwable unused) {
        }
    }

    private void registerPackageChangeReciver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            context.getApplicationContext().registerReceiver(new APKInstallReceiver(), intentFilter);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public Object getRemoteParam(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, objArr)) == null) {
            try {
                if ("encodedSn".equals(str)) {
                    return DeviceUtils.getInstance().getEncodedSN((Context) objArr[0]);
                }
                if ("encodedCUID".equals(str)) {
                    return DeviceUtils.getInstance().getEncodedCUID((Context) objArr[0]);
                }
                if ("appsid".equals(str)) {
                    return DeviceUtils.getInstance().getAppId(this.mAppCxt);
                }
                if ("appContext".equals(str)) {
                    return AppConfigImp.getInstance().getAppContext();
                }
                if ("baidu_cloudConfig".equals(str)) {
                    return CloudControlConfig.getInstance(this.mAppCxt).getValueForKey((String) objArr[0]);
                }
                if ("appCommonConfig".equals(str)) {
                    return AppCommonConfig.getInstance().getValueForKey((String) objArr[0]);
                }
                return null;
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(TAG, th);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public double getRemoteVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? XAdSDKRemoteVersion.getVersion() : invokeV.doubleValue;
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initCommonModuleObj(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            AppConfigImp.getInstance().setModuleObj((ICommonModuleObj) obj);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initConfig(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            AppConfigImp.getInstance().initSDK(jSONObject);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void onTaskDistribute(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) && "permission_module".equals(str)) {
            PermissionUtils.setPermissionInfo(jSONObject);
        }
    }
}
