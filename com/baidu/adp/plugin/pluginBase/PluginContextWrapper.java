package com.baidu.adp.plugin.pluginBase;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.lm;
/* loaded from: classes.dex */
public class PluginContextWrapper extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mPackageName;
    public Resources.Theme mTheme;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginContextWrapper(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPackageName = null;
        this.mTheme = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PluginSetting g = lm.h().g(this.mPackageName);
            if (g != null && g.isThird) {
                Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
                if (plugin2 != null && plugin2.isLoaded()) {
                    return plugin2.getApplication();
                }
                throw new RuntimeException("third plugin is not loaded");
            } else if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
                return PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication();
            } else {
                throw new RuntimeException("plugin is not loaded");
            }
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
                return PluginCenter.getInstance().getPlugin(this.mPackageName).getDexClassLoader();
            }
            throw new RuntimeException("plugin is not loaded");
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ContentResolverProxy.getContentResolver() : (ContentResolver) invokeV.objValue;
    }

    public String getPluginPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PluginSetting g = lm.h().g(this.mPackageName);
            if (g != null && g.isThird) {
                Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
                if (plugin2 != null && plugin2.isLoaded()) {
                    return plugin2.getPluginResources();
                }
                throw new RuntimeException("third plugin is not loaded");
            }
            Resources resources = d9.a().getResources();
            return resources != null ? resources : super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mTheme == null) {
                Resources.Theme newTheme = getResources().newTheme();
                this.mTheme = newTheme;
                newTheme.setTo(BdBaseApplication.getInst().getTheme());
            }
            return this.mTheme;
        }
        return (Resources.Theme) invokeV.objValue;
    }

    public void setPluginPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mPackageName = str;
            if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
                attachBaseContext(PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication().getBaseContext());
                return;
            }
            throw new RuntimeException("plugin is not loaded");
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            getTheme().applyStyle(i, true);
        }
    }
}
