package com.baidu.nps.stub.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class NPSActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    public transient /* synthetic */ FieldHolder $fh;
    public Resources mNPSResources;

    public NPSActivity() {
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

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
            if (!TextUtils.isEmpty(getBundlePackageName())) {
                return NPSManager.getInstance().getBundle(getBundlePackageName()).getClassloader();
            }
            return super.getClassLoader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Intent intent = super.getIntent();
            if (intent != null) {
                intent.setExtrasClassLoader(getClassLoader());
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(getBundlePackageName())) {
                return super.getResources();
            }
            Resources resources = NPSManager.getInstance().getBundle(getBundlePackageName()).getResources(super.getResources());
            this.mNPSResources = resources;
            return resources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            Bundle bundle2 = bundle.getBundle(WINDOW_HIERARCHY_TAG);
            if (bundle2 != null) {
                bundle2.setClassLoader(getClassLoader());
            }
            super.onRestoreInstanceState(bundle);
        }
    }
}
