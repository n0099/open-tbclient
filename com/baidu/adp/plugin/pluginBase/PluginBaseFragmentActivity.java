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
import com.repackage.ul;
import com.repackage.vl;
/* loaded from: classes.dex */
public class PluginBaseFragmentActivity extends PluginBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vl mProxyActivity;

    public PluginBaseFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            vl vlVar = this.mProxyActivity;
            if (vlVar == null) {
                return null;
            }
            return vlVar.proxyGetSupportFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    public void onAttachFragment(Fragment fragment) {
        vl vlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) || (vlVar = this.mProxyActivity) == null) {
            return;
        }
        vlVar.proxyOnAttachFragment(fragment);
    }

    public void setActivityProxy(vl vlVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vlVar) == null) {
            super.setActivityProxy((ul) vlVar);
            this.mProxyActivity = vlVar;
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        vl vlVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, fragment, intent, i) == null) || (vlVar = this.mProxyActivity) == null) {
            return;
        }
        vlVar.proxyStartActivityFromFragment(fragment, intent, i);
    }
}
