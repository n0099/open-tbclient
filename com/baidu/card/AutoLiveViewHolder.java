package com.baidu.card;

import android.view.View;
import b.a.q0.c1.r0;
import b.a.r0.q2.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AutoLiveViewHolder extends TypeAdapter.ViewHolder implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbLiveContainer tbLiveContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoLiveViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.r0.q2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.q2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.getPlayUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.getVideoContainer();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.isPlayStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbLiveContainer tbLiveContainer = this.tbLiveContainer;
            if (tbLiveContainer != null) {
                return tbLiveContainer.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public void startPlay() {
        TbLiveContainer tbLiveContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (tbLiveContainer = this.tbLiveContainer) != null && r0.d(tbLiveContainer.getContext())) {
            this.tbLiveContainer.startPlay();
        }
    }

    @Override // b.a.r0.q2.e
    public void stopPlay() {
        TbLiveContainer tbLiveContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbLiveContainer = this.tbLiveContainer) == null) {
            return;
        }
        tbLiveContainer.stopPlay();
    }
}
