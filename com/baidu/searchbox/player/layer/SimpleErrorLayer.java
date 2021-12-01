package com.baidu.searchbox.player.layer;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.component.KernelErrorComponent;
import com.baidu.searchbox.player.component.NetErrorComponent;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.videoplayer.framework.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SimpleErrorLayer extends ComponentLayer<FrameLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KernelErrorComponent mKernelErrorComponent;
    public NetErrorComponent mNetErrorComponent;

    public SimpleErrorLayer() {
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

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{4, 5, 2, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer
    public void initContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mContainer = new FrameLayout(this.mContext);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.bt_retry || view.getId() == R.id.play_error_layout_retry) {
                onRetryClick();
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            super.onControlEventNotify(videoEvent);
            if (ControlEvent.ACTION_RESUME.equals(videoEvent.getAction()) || ControlEvent.ACTION_SHOW_TIP.equals(videoEvent.getAction()) || ControlEvent.ACTION_START.equals(videoEvent.getAction())) {
                toggleVisible(false);
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoEvent) == null) {
            super.onLayerEventNotify(videoEvent);
            String action = videoEvent.getAction();
            if (((action.hashCode() == 1409909918 && action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) ? (char) 0 : (char) 65535) != 0) {
                return;
            }
            toggleVisible(false);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoEvent) == null) {
            super.onPlayerEventNotify(videoEvent);
            boolean isFloatingMode = getBindPlayer() instanceof UniversalPlayer ? ((UniversalPlayer) getBindPlayer()).isFloatingMode() : false;
            if (!PlayerEvent.ACTION_ON_ERROR.equals(videoEvent.getAction()) || isFloatingMode) {
                return;
            }
            if (NetUtils.isNetDown()) {
                detachComponentView(this.mKernelErrorComponent);
                attachComponentView(this.mNetErrorComponent);
            } else {
                detachComponentView(this.mNetErrorComponent);
                attachComponentView(this.mKernelErrorComponent);
            }
            toggleVisible(true);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
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

    @Override // com.baidu.searchbox.player.layer.ComponentLayer
    public void setupComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NetErrorComponent netErrorComponent = new NetErrorComponent();
            this.mNetErrorComponent = netErrorComponent;
            addComponent(netErrorComponent);
            KernelErrorComponent kernelErrorComponent = new KernelErrorComponent();
            this.mKernelErrorComponent = kernelErrorComponent;
            addComponent(kernelErrorComponent);
        }
    }
}
