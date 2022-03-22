package com.baidu.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import c.a.d.c.g.a;
import c.a.o0.r.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class KuangAPKFragmentActivityPageContext implements TbPageContext<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity orginal;

    public KuangAPKFragmentActivityPageContext(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.orginal = baseFragmentActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.orginal.getActivity() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.orginal.getLayoutMode() : (c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public Activity getPageActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.orginal.getActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TbadkCoreApplication.getInst().getResources() : (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? getResources().getString(i) : (String) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.orginal.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.orginal.registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, message) == null) {
            this.orginal.sendMessage(message);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.orginal.showToast(i);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animatable) == null) {
            this.orginal.startAnimatable(animatable);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, view, animation, animationListener) == null) {
            this.orginal.startAnimation(view, animation, animationListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public BaseFragmentActivity getOrignalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.orginal : (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, aVar) == null) {
            this.orginal.registerListener(i, aVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, netMessage) == null) {
            this.orginal.sendMessage(netMessage);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            this.orginal.showToast(str, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, c.a.d.a.f
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, messageListener) == null) {
            this.orginal.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.orginal.showToast(i, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, messageListener) == null) {
            this.orginal.registerListener(i, messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.orginal.showToast(str);
        }
    }
}
