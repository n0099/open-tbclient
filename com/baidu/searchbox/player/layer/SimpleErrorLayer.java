package com.baidu.searchbox.player.layer;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes4.dex */
public class SimpleErrorLayer extends ElementLayer<FrameLayout, AbsElement> {
    public KernelErrorElement mKernelErrorElement;
    public NetErrorElement mNetErrorElement;

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 2, 3};
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void initContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
    }

    public void onRetryClick() {
        toggleVisible(false);
        getBindPlayer().resumeFromError();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_RETRY));
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void setupElement() {
        NetErrorElement netErrorElement = new NetErrorElement();
        this.mNetErrorElement = netErrorElement;
        addElement(netErrorElement);
        KernelErrorElement kernelErrorElement = new KernelErrorElement();
        this.mKernelErrorElement = kernelErrorElement;
        addElement(kernelErrorElement);
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

    @Override // com.baidu.searchbox.player.layer.ElementLayer, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.obfuscated_res_0x7f09048a || view2.getId() == R.id.obfuscated_res_0x7f091c13) {
            onRetryClick();
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        super.onControlEventNotify(videoEvent);
        if (ControlEvent.ACTION_RESUME.equals(videoEvent.getAction()) || ControlEvent.ACTION_SHOW_TIP.equals(videoEvent.getAction()) || ControlEvent.ACTION_START.equals(videoEvent.getAction())) {
            toggleVisible(false);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onLayerEventNotify(videoEvent);
        if (LayerEvent.ACTION_SWITCH_FLOATING.equals(videoEvent.getAction())) {
            toggleVisible(false);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        boolean z;
        super.onPlayerEventNotify(videoEvent);
        if (getBindPlayer() instanceof UniversalPlayer) {
            z = ((UniversalPlayer) getBindPlayer()).isFloatingMode();
        } else {
            z = false;
        }
        if (PlayerEvent.ACTION_ON_ERROR.equals(videoEvent.getAction()) && !z) {
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
        super.onPlayerStatusChanged(playerStatus, playerStatus2);
        if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
            toggleVisible(false);
        }
    }
}
