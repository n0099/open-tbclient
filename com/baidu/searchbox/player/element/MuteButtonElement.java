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
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\u0018R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001eR\"\u0010#\u001a\u00020\"8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/player/element/MuteButtonElement;", "android/view/View$OnClickListener", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "initElement", "()V", "", "isMute", "()Z", "v", "onClick", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "", RemoteMessageConst.Notification.VISIBILITY, "onParentVisibleChanged", "(I)V", "setMuteIcon", "(Z)V", "setMuteVisibility", "shouldShowMute", "switchVolumeMode", "sycVideoMute", "acceptVolumeChange", "Z", "getAcceptVolumeChange", "setAcceptVolumeChange", "isPanelShowing", "Landroid/widget/ImageView;", "muteButton", "Landroid/widget/ImageView;", "getMuteButton", "()Landroid/widget/ImageView;", "setMuteButton", "(Landroid/widget/ImageView;)V", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class MuteButtonElement extends AbsElement implements View.OnClickListener {
    public boolean acceptVolumeChange = true;
    public boolean isPanelShowing;
    public ImageView muteButton;

    public final boolean getAcceptVolumeChange() {
        return this.acceptVolumeChange;
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        ImageView imageView = this.muteButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        }
        return imageView;
    }

    public final ImageView getMuteButton() {
        ImageView imageView = this.muteButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        }
        return imageView;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        this.muteButton = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        }
        int dp2px = BdPlayerUtils.dp2px(imageView, 16.0f);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        imageView.setOnClickListener(this);
        sycVideoMute();
    }

    public boolean isMute() {
        return BDVideoPlayer.isGlobalMute();
    }

    public boolean shouldShowMute() {
        BDVideoPlayer videoPlayer = getVideoPlayer();
        Intrinsics.checkNotNullExpressionValue(videoPlayer, "videoPlayer");
        if (!videoPlayer.isComplete()) {
            BDVideoPlayer videoPlayer2 = getVideoPlayer();
            Intrinsics.checkNotNullExpressionValue(videoPlayer2, "videoPlayer");
            if (!videoPlayer2.isError()) {
                BDVideoPlayer videoPlayer3 = getVideoPlayer();
                Intrinsics.checkNotNullExpressionValue(videoPlayer3, "videoPlayer");
                if (!videoPlayer3.isStop()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sycVideoMute() {
        boolean z;
        int volume = BdPlayerUtils.getVolume(getContext());
        BDVideoPlayer videoPlayer = getVideoPlayer();
        Intrinsics.checkNotNullExpressionValue(videoPlayer, "videoPlayer");
        if (!videoPlayer.isPlayerMute() && volume > 0) {
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
            ImageView imageView = this.muteButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteButton");
            }
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08021d);
            return;
        }
        ImageView imageView2 = this.muteButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        }
        imageView2.setImageResource(R.drawable.obfuscated_res_0x7f08021c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ImageView imageView = this.muteButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteButton");
        }
        if (Intrinsics.areEqual(view2, imageView)) {
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
            if (hashCode == 1822725860 && action.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                BDVideoPlayer videoPlayer = getVideoPlayer();
                Intrinsics.checkNotNullExpressionValue(videoPlayer, "videoPlayer");
                if (!videoPlayer.isStop()) {
                    BDVideoPlayer videoPlayer2 = getVideoPlayer();
                    Intrinsics.checkNotNullExpressionValue(videoPlayer2, "videoPlayer");
                    if (!videoPlayer2.isComplete() && this.acceptVolumeChange) {
                        int intExtra = event.getIntExtra(5);
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
                ImageView imageView = this.muteButton;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("muteButton");
                }
                imageView.setVisibility(0);
                return;
            }
            ImageView imageView2 = this.muteButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteButton");
            }
            imageView2.setVisibility(8);
        } else if (this.isPanelShowing) {
            ImageView imageView3 = this.muteButton;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteButton");
            }
            imageView3.setVisibility(0);
        } else {
            ImageView imageView4 = this.muteButton;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteButton");
            }
            imageView4.setVisibility(8);
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
