package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/player/element/PlayButtonElement;", "android/view/View$OnClickListener", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "initElement", "()V", "v", "onClick", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "status", "old", "onPlayerStatusChanged", "(Lcom/baidu/searchbox/player/constants/PlayerStatus;Lcom/baidu/searchbox/player/constants/PlayerStatus;)V", "", "isPlaying", "setPlayIcon", "(Z)V", "Landroid/widget/ImageView;", "playBtn", "Landroid/widget/ImageView;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class PlayButtonElement extends AbsElement implements View.OnClickListener {
    public ImageView playBtn;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            $EnumSwitchMapping$0[PlayerStatus.PREPARED.ordinal()] = 2;
            $EnumSwitchMapping$0[PlayerStatus.PREPARING.ordinal()] = 3;
        }
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        ImageView imageView = this.playBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
        }
        return imageView;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        this.playBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
        }
        int dp2px = BdPlayerUtils.dp2px(imageView, 42.0f);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        imageView.setOnClickListener(this);
    }

    private final void setPlayIcon(boolean z) {
        if (z) {
            ImageView imageView = this.playBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            }
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08021f);
            return;
        }
        ImageView imageView2 = this.playBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
        }
        imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080220);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        BDVideoPlayer videoPlayer = getVideoPlayer();
        if (videoPlayer.isPlaying()) {
            videoPlayer.pause(1);
        } else if (videoPlayer.isPause()) {
            videoPlayer.resume();
        } else {
            videoPlayer.start();
        }
    }

    public static /* synthetic */ void setPlayIcon$default(PlayButtonElement playButtonElement, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            playButtonElement.setPlayIcon(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPlayIcon");
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 14382657:
                if (action.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                    BDVideoPlayer videoPlayer = getVideoPlayer();
                    Intrinsics.checkNotNullExpressionValue(videoPlayer, "videoPlayer");
                    setPlayIcon(!videoPlayer.isPause());
                    return;
                }
                return;
            case 720027695:
                if (action.equals(ControlEvent.ACTION_PAUSE)) {
                    setPlayIcon(false);
                    return;
                }
                return;
            case 906917140:
                if (action.equals(ControlEvent.ACTION_RESUME)) {
                    setPlayIcon(true);
                    return;
                }
                return;
            case 1370689931:
                if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                    int intExtra = event.getIntExtra(1);
                    if (intExtra != 904 && intExtra != 956) {
                        if (702 == intExtra) {
                            BDVideoPlayer videoPlayer2 = getVideoPlayer();
                            Intrinsics.checkNotNullExpressionValue(videoPlayer2, "videoPlayer");
                            if (videoPlayer2.isPlaying()) {
                                setPlayIcon(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    setPlayIcon(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        if (playerStatus == null || ((i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()]) != 1 && i != 2 && i != 3)) {
            setPlayIcon(false);
        } else {
            setPlayIcon(true);
        }
    }
}
