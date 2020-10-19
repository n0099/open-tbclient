package com.baidu.searchbox.player.layer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
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
/* loaded from: classes7.dex */
public class SimpleErrorLayer extends ComponentLayer<FrameLayout> {
    protected KernelErrorComponent mKernelErrorComponent;
    protected NetErrorComponent mNetErrorComponent;

    @Override // com.baidu.searchbox.player.layer.ComponentLayer
    protected void initContainer() {
        this.mContainer = new FrameLayout(this.mContext);
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer
    protected void setupComponent() {
        this.mNetErrorComponent = new NetErrorComponent();
        addComponent(this.mNetErrorComponent);
        this.mKernelErrorComponent = new KernelErrorComponent();
        addComponent(this.mKernelErrorComponent);
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 2, 3};
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onPlayerEventNotify(videoEvent);
        boolean z = false;
        if (getBindPlayer() instanceof UniversalPlayer) {
            z = ((UniversalPlayer) getBindPlayer()).isFloatingMode();
        }
        if (PlayerEvent.ACTION_ON_ERROR.equals(videoEvent.getAction()) && !z) {
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
        super.onPlayerStatusChanged(playerStatus, playerStatus2);
        if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
            toggleVisible(false);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        super.onControlEventNotify(videoEvent);
        if (ControlEvent.ACTION_RESUME.equals(videoEvent.getAction()) || ControlEvent.ACTION_SHOW_TIP.equals(videoEvent.getAction()) || ControlEvent.ACTION_START.equals(videoEvent.getAction())) {
            toggleVisible(false);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onLayerEventNotify(videoEvent);
        String action = videoEvent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case 1409909918:
                if (action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                toggleVisible(false);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.layer.ComponentLayer, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bt_retry || view.getId() == R.id.play_error_layout_retry) {
            onRetryClick();
        }
    }

    private void toggleVisible(boolean z) {
        if (z) {
            ((FrameLayout) this.mContainer).setVisibility(0);
            getBindPlayer().getPlayerCallbackManager().onLayerShow(this);
            return;
        }
        ((FrameLayout) this.mContainer).setVisibility(8);
        getBindPlayer().getPlayerCallbackManager().onLayerDismiss(this);
    }

    protected void onRetryClick() {
        toggleVisible(false);
        getBindPlayer().resumeFromError();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_RETRY));
    }
}
