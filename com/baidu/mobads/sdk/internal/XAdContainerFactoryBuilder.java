package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.AllInOneXAdContainerFactory;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XAdContainerFactoryBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ContainerFactoryBuilder";
    public static IXAdContainerFactory mAdContainerFactoryInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public XAdLogger mAdLogger;
    public double mApkVersion;
    public Context mContext;

    public XAdContainerFactoryBuilder(Context context) {
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
        this.mApkVersion = 0.1d;
        this.mAdLogger = XAdLogger.getInstance();
        this.mContext = context;
    }

    public IXAdContainerFactory getXAdContainerFactoryInstance() throws IllegalAccessException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (mAdContainerFactoryInstance == null) {
                try {
                    mAdContainerFactoryInstance = new AllInOneXAdContainerFactory(this.mContext);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("p_ver", "9.042");
                    mAdContainerFactoryInstance.initConfig(jSONObject);
                    this.mApkVersion = mAdContainerFactoryInstance.getRemoteVersion();
                    mAdContainerFactoryInstance.onTaskDistribute("permission_module", MobadsPermissionSettings.getPermissionInfo());
                    mAdContainerFactoryInstance.initCommonModuleObj(FoundationFacadeUtils.getInstance());
                } catch (Throwable th) {
                    this.mAdLogger.w(TAG, th.getMessage());
                    throw new IllegalAccessException("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
                }
            }
            return mAdContainerFactoryInstance;
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public void resetXAdContainerFactoryInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mAdContainerFactoryInstance = null;
        }
    }
}
