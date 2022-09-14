package com.baidu.searchbox.player.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/player/element/PlayButtonElement;", "android/view/View$OnClickListener", "Lcom/baidu/searchbox/player/element/AbsElement;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "", "initElement", "()V", "v", "onClick", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "status", "old", "onPlayerStatusChanged", "(Lcom/baidu/searchbox/player/constants/PlayerStatus;Lcom/baidu/searchbox/player/constants/PlayerStatus;)V", "", "isPlaying", "setPlayIcon", "(Z)V", "Landroid/widget/ImageView;", "playBtn", "Landroid/widget/ImageView;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class PlayButtonElement extends AbsElement implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView playBtn;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            $EnumSwitchMapping$0[PlayerStatus.PREPARED.ordinal()] = 2;
            $EnumSwitchMapping$0[PlayerStatus.PREPARING.ordinal()] = 3;
        }
    }

    public PlayButtonElement() {
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

    private final void setPlayIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (z) {
                ImageView imageView = this.playBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playBtn");
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080214);
                return;
            }
            ImageView imageView2 = this.playBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            }
            imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080215);
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

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageView imageView = this.playBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            }
            return imageView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.playBtn = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            }
            int dp2px = BdPlayerUtils.dp2px(imageView, 42.0f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(dp2px, dp2px));
            imageView.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            BDVideoPlayer videoPlayer = getVideoPlayer();
            if (videoPlayer.isPlaying()) {
                videoPlayer.pause(1);
            } else if (videoPlayer.isPause()) {
                videoPlayer.resume();
            } else {
                videoPlayer.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
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
                        if (intExtra == 904 || intExtra == 956) {
                            setPlayIcon(true);
                            return;
                        } else if (702 == intExtra) {
                            BDVideoPlayer videoPlayer2 = getVideoPlayer();
                            Intrinsics.checkNotNullExpressionValue(videoPlayer2, "videoPlayer");
                            if (videoPlayer2.isPlaying()) {
                                setPlayIcon(true);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, playerStatus, playerStatus2) == null) {
            if (playerStatus == null || ((i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()]) != 1 && i != 2 && i != 3)) {
                setPlayIcon(false);
            } else {
                setPlayIcon(true);
            }
        }
    }
}
