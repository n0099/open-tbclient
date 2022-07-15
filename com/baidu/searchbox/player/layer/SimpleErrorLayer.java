package com.baidu.searchbox.player.layer;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.element.KernelErrorElement;
import com.baidu.searchbox.player.element.NetErrorElement;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SimpleErrorLayer extends ElementLayer<FrameLayout, AbsElement> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KernelErrorElement mKernelErrorElement;
    public NetErrorElement mNetErrorElement;

    public SimpleErrorLayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void toggleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (z) {
                ((FrameLayout) this.mContainer).setVisibility(0);
                getBindPlayer().getPlayerCallbackManager().onLayerShow(this);
                return;
            }
            ((FrameLayout) this.mContainer).setVisibility(8);
            getBindPlayer().getPlayerCallbackManager().onLayerDismiss(this);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{4, 5, 2, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void initContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            this.mContainer = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0903f2 || view2.getId() == R.id.obfuscated_res_0x7f091903) {
                onRetryClick();
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            super.onControlEventNotify(videoEvent);
            if (ControlEvent.ACTION_RESUME.equals(videoEvent.getAction()) || ControlEvent.ACTION_SHOW_TIP.equals(videoEvent.getAction()) || ControlEvent.ACTION_START.equals(videoEvent.getAction())) {
                toggleVisible(false);
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoEvent) == null) {
            super.onLayerEventNotify(videoEvent);
            if (LayerEvent.ACTION_SWITCH_FLOATING.equals(videoEvent.getAction())) {
                toggleVisible(false);
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoEvent) == null) {
            super.onPlayerEventNotify(videoEvent);
            boolean isFloatingMode = getBindPlayer() instanceof UniversalPlayer ? ((UniversalPlayer) getBindPlayer()).isFloatingMode() : false;
            if (!PlayerEvent.ACTION_ON_ERROR.equals(videoEvent.getAction()) || isFloatingMode) {
                return;
            }
            if (NetUtils.isNetDown()) {
                detachElementView(this.mKernelErrorElement);
                attachElementView(this.mNetErrorElement);
            } else {
                detachElementView(this.mNetErrorElement);
                attachElementView(this.mKernelErrorElement);
            }
            toggleVisible(true);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, playerStatus, playerStatus2) == null) {
            super.onPlayerStatusChanged(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
                toggleVisible(false);
            }
        }
    }

    public void onRetryClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            toggleVisible(false);
            getBindPlayer().resumeFromError();
            sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_RETRY));
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void setupElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NetErrorElement netErrorElement = new NetErrorElement();
            this.mNetErrorElement = netErrorElement;
            addElement(netErrorElement);
            KernelErrorElement kernelErrorElement = new KernelErrorElement();
            this.mKernelErrorElement = kernelErrorElement;
            addElement(kernelErrorElement);
        }
    }
}
