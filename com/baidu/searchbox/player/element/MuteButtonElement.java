package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0014J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/player/element/MuteButtonElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View$OnClickListener;", "()V", "acceptVolumeChange", "", "getAcceptVolumeChange", "()Z", "setAcceptVolumeChange", "(Z)V", "isPanelShowing", "muteButton", "Landroid/widget/ImageView;", "getMuteButton", "()Landroid/widget/ImageView;", "setMuteButton", "(Landroid/widget/ImageView;)V", "getContentView", "Landroid/view/View;", "initElement", "", "isMute", "onClick", "v", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onParentVisibleChanged", "visibility", "", "setMuteIcon", "setMuteVisibility", "shouldShowMute", "switchVolumeMode", "sycVideoMute", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class MuteButtonElement extends AbsElement implements View.OnClickListener {
    public boolean acceptVolumeChange = true;
    public boolean isPanelShowing;
    public ImageView muteButton;

    public final boolean getAcceptVolumeChange() {
        return this.acceptVolumeChange;
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        return getMuteButton();
    }

    public final ImageView getMuteButton() {
        ImageView imageView = this.muteButton;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        return null;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        setMuteButton(new ImageView(getContext()));
        ImageView muteButton = getMuteButton();
        int dp2px = BdPlayerUtils.dp2px(muteButton, 16.0f);
        muteButton.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        muteButton.setOnClickListener(this);
        sycVideoMute();
    }

    public boolean isMute() {
        return BDVideoPlayer.isGlobalMute();
    }

    public boolean shouldShowMute() {
        if (!getVideoPlayer().isComplete() && !getVideoPlayer().isError() && !getVideoPlayer().isStop()) {
            return true;
        }
        return false;
    }

    public void sycVideoMute() {
        boolean z;
        int volume = BdPlayerUtils.getVolume(getContext());
        if (!getVideoPlayer().isPlayerMute() && volume > 0) {
            z = false;
        } else {
            z = true;
        }
        getVideoPlayer().setMuteMode(z);
        setMuteIcon(z);
        setMuteVisibility();
    }

    private final void setMuteIcon(boolean z) {
        if (z) {
            getMuteButton().setImageResource(R.drawable.obfuscated_res_0x7f080283);
        } else {
            getMuteButton().setImageResource(R.drawable.obfuscated_res_0x7f080282);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (Intrinsics.areEqual(view2, getMuteButton())) {
            switchVolumeMode();
            setMuteVisibility();
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        this.isPanelShowing = z;
        setMuteVisibility();
    }

    public final void setAcceptVolumeChange(boolean z) {
        this.acceptVolumeChange = z;
    }

    public final void setMuteButton(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.muteButton = imageView;
    }

    public static /* synthetic */ void setMuteIcon$default(MuteButtonElement muteButtonElement, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            muteButtonElement.setMuteIcon(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMuteIcon");
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 723345051) {
            if (hashCode == 1822725860 && action.equals(SystemEvent.ACTION_VOLUME_CHANGED) && !getVideoPlayer().isStop() && !getVideoPlayer().isComplete() && this.acceptVolumeChange) {
                int intExtra = event.getIntExtra(4);
                if (intExtra > 0) {
                    setMuteIcon(false);
                } else {
                    setMuteIcon(true);
                }
                boolean isMute = isMute();
                if ((isMute && intExtra > 0) || (!isMute && intExtra == 0)) {
                    switchVolumeMode();
                    setMuteVisibility();
                }
            }
        } else if (action.equals(ControlEvent.ACTION_START)) {
            this.isPanelShowing = false;
            setMuteVisibility();
        }
    }

    public void setMuteVisibility() {
        if (isMute()) {
            if (shouldShowMute()) {
                getMuteButton().setVisibility(0);
            } else {
                getMuteButton().setVisibility(8);
            }
        } else if (this.isPanelShowing) {
            getMuteButton().setVisibility(0);
        } else {
            getMuteButton().setVisibility(8);
        }
    }

    public void switchVolumeMode() {
        boolean isMute = isMute();
        if (isMute && BdPlayerUtils.getVolume(getContext()) == 0) {
            BdPlayerUtils.setVolume(getContext(), (int) (BdPlayerUtils.getMaxVolume(getContext()) * 0.35d));
        }
        boolean z = !isMute;
        setMuteIcon(z);
        getVideoPlayer().setGlobalMuteMode(z);
        VideoSessionManager.getInstance().sendEventToAll(LayerEvent.obtainEvent(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
    }
}
