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
import com.baidu.tieba.hv4;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MainAPKActivityPageContext<T> implements TbPageContext<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<T> activity;

    public MainAPKActivityPageContext(BaseActivity<T> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.activity = baseActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return getResources().getString(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, messageListener) == null) {
            this.activity.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
            this.activity.sendMessage(message);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.activity.showToast(i);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, animatable) == null) {
            this.activity.startAnimatable(animatable);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.activity.getActivity();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public hv4 getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.activity.getLayoutMode();
        }
        return (hv4) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.baidu.tbadk.BaseActivity<T>] */
    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public T getOrignalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.activity;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public Activity getPageActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.activity.getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.activity.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext, com.baidu.tieba.a9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.activity.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, messageListener) == null) {
            this.activity.registerListener(i, messageListener);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.activity.showToast(i, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, zaVar) == null) {
            this.activity.registerListener(i, zaVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) {
            this.activity.showToast(str, z);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zaVar) == null) {
            this.activity.registerListener(zaVar);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, netMessage) == null) {
            this.activity.sendMessage(netMessage);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.activity.showToast(str);
        }
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, view2, animation, animationListener) == null) {
            this.activity.startAnimation(view2, animation, animationListener);
        }
    }
}
