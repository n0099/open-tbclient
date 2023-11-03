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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/player/element/PlayButtonElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View$OnClickListener;", "()V", "playBtn", "Landroid/widget/ImageView;", "getPlayBtn", "()Landroid/widget/ImageView;", "setPlayBtn", "(Landroid/widget/ImageView;)V", "getContentView", "Landroid/view/View;", "initElement", "", "onClick", "v", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "setPlayIcon", "isPlaying", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class PlayButtonElement extends AbsElement implements View.OnClickListener {
    public ImageView playBtn;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            iArr[PlayerStatus.PREPARED.ordinal()] = 2;
            iArr[PlayerStatus.PREPARING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        return getPlayBtn();
    }

    public final ImageView getPlayBtn() {
        ImageView imageView = this.playBtn;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playBtn");
        return null;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        int dp2px = BdPlayerUtils.dp2px(imageView, 42.0f);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
        imageView.setOnClickListener(this);
        setPlayBtn(imageView);
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

    public final void setPlayBtn(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.playBtn = imageView;
    }

    public void setPlayIcon(boolean z) {
        if (z) {
            getPlayBtn().setImageResource(R.drawable.obfuscated_res_0x7f080283);
        } else {
            getPlayBtn().setImageResource(R.drawable.obfuscated_res_0x7f080284);
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 14382657:
                if (action.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                    setPlayIcon(!getVideoPlayer().isPause());
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
                        if (702 == intExtra && getVideoPlayer().isPlaying()) {
                            setPlayIcon(true);
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
        if (playerStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()];
        }
        if (i != 1 && i != 2 && i != 3) {
            setPlayIcon(false);
        } else {
            setPlayIcon(true);
        }
    }
}
