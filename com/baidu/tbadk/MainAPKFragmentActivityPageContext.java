package com.baidu.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.bb;
import com.baidu.tieba.kn4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MainAPKFragmentActivityPageContext implements TbPageContext<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity activity;

    public MainAPKFragmentActivityPageContext(BaseFragmentActivity baseFragmentActivity) {
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
        this.activity = baseFragmentActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activity.getActivity() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public kn4 getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.activity.getLayoutMode() : (kn4) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public Activity getPageActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.activity.getActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.activity.getResources() : (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? getResources().getString(i) : (String) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.activity.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(bb bbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bbVar) == null) {
            this.activity.registerListener(bbVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, message) == null) {
            this.activity.sendMessage(message);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.activity.showToast(i);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animatable) == null) {
            this.activity.startAnimatable(animatable);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, view2, animation, animationListener) == null) {
            this.activity.startAnimation(view2, animation, animationListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public BaseFragmentActivity getOrignalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.activity : (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, bb bbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, bbVar) == null) {
            this.activity.registerListener(i, bbVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, netMessage) == null) {
            this.activity.sendMessage(netMessage);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            this.activity.showToast(str, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.d9
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, messageListener) == null) {
            this.activity.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.activity.showToast(i, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, messageListener) == null) {
            this.activity.registerListener(i, messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.activity.showToast(str);
        }
    }
}
