package com.baidu.nps.stub.component;

import android.app.Service;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class NPSService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources mNPSResources;

    public NPSService() {
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

    private String getBundlePackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(getBundlePackageName())) {
                return super.getClassLoader();
            }
            return NPSManager.getInstance().getBundle(getBundlePackageName()).getClassloader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(getBundlePackageName())) {
                return super.getResources();
            }
            Resources resources = NPSManager.getInstance().getBundle(getBundlePackageName()).getResources(super.getResources());
            this.mNPSResources = resources;
            return resources;
        }
        return (Resources) invokeV.objValue;
    }
}
