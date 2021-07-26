package com.baidu.adp.plugin.pluginBase;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.h.f.a;
import d.a.d.h.f.b;
/* loaded from: classes.dex */
public class PluginBaseFragmentActivity extends PluginBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b mProxyActivity;

    public PluginBaseFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProxyActivity = null;
    }

    public FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = this.mProxyActivity;
            if (bVar == null) {
                return null;
            }
            return bVar.proxyGetSupportFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    public void onAttachFragment(Fragment fragment) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) || (bVar = this.mProxyActivity) == null) {
            return;
        }
        bVar.proxyOnAttachFragment(fragment);
    }

    public void setActivityProxy(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            super.setActivityProxy((a) bVar);
            this.mProxyActivity = bVar;
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, fragment, intent, i2) == null) || (bVar = this.mProxyActivity) == null) {
            return;
        }
        bVar.proxyStartActivityFromFragment(fragment, intent, i2);
    }
}
