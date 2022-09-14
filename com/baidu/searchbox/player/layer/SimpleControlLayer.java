package com.baidu.searchbox.player.layer;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.element.BackButtonElement;
import com.baidu.searchbox.player.element.LandscapeButtonElement;
import com.baidu.searchbox.player.element.MuteButtonElement;
import com.baidu.searchbox.player.element.PlayButtonElement;
import com.baidu.searchbox.player.element.SeekBarElement;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import java.util.AbstractCollection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0013J\u0019\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b(\u0010&J\u000f\u0010)\u001a\u00020\u0007H\u0014¢\u0006\u0004\b)\u0010\u0013J#\u0010,\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/player/layer/SimpleControlLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "", "enableControlLayerTouchEvent", "()Z", "", "visibility", "", "handleElementVisible", "(I)V", "Landroid/os/Message;", "msg", "handleLayerMessage", "(Landroid/os/Message;)V", "", DelayTB.DELAY, "hidePanelDelay", "(J)V", "initContainer", "()V", "layoutBackElement", "Landroid/widget/RelativeLayout;", "root", "layoutElement", "(Landroid/widget/RelativeLayout;)V", "layoutLandButtonElement", "layoutMuteElement", "layoutPlayElement", "half", "layoutSeekBarElement", "(Z)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "onControlEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "onLayerEventNotify", "onPlayerEventNotify", "setupElement", "isVisible", "needHideLayer", "togglePanelVisible", "(ZZ)V", "Lcom/baidu/searchbox/player/element/BackButtonElement;", "backButtonElement", "Lcom/baidu/searchbox/player/element/BackButtonElement;", "isShowing", "Z", "Lcom/baidu/searchbox/player/element/LandscapeButtonElement;", "landscapeButtonElement", "Lcom/baidu/searchbox/player/element/LandscapeButtonElement;", "Lcom/baidu/searchbox/player/element/MuteButtonElement;", "muteButtonElement", "Lcom/baidu/searchbox/player/element/MuteButtonElement;", "Lcom/baidu/searchbox/player/element/PlayButtonElement;", "playButtonElement", "Lcom/baidu/searchbox/player/element/PlayButtonElement;", "Lcom/baidu/searchbox/player/element/SeekBarElement;", "seekBarElement", "Lcom/baidu/searchbox/player/element/SeekBarElement;", "<init>", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class SimpleControlLayer extends ElementLayer<RelativeLayout, AbsElement> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackButtonElement backButtonElement;
    public boolean isShowing;
    public LandscapeButtonElement landscapeButtonElement;
    public MuteButtonElement muteButtonElement;
    public PlayButtonElement playButtonElement;
    public SeekBarElement seekBarElement;

    public SimpleControlLayer() {
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

    private final void handleElementVisible(int i) {
        View it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.isShowing = i == 0;
            AbstractCollection<AbsElement> mElements = this.mElements;
            Intrinsics.checkNotNullExpressionValue(mElements, "mElements");
            for (AbsElement absElement : mElements) {
                if (absElement != null && (it = absElement.getContentView()) != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!(it.getParent() != null)) {
                        it = null;
                    }
                    if (it != null) {
                        absElement.onParentVisibleChanged(i);
                    }
                }
            }
        }
    }

    private final void hidePanelDelay(long j) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.removeMessages(100);
            }
            Handler handler3 = this.mHandler;
            Message obtainMessage = handler3 != null ? handler3.obtainMessage(100) : null;
            if (obtainMessage == null || (handler = this.mHandler) == null) {
                return;
            }
            handler.sendMessageDelayed(obtainMessage, j);
        }
    }

    public static /* synthetic */ void hidePanelDelay$default(SimpleControlLayer simpleControlLayer, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 5000;
            }
            simpleControlLayer.hidePanelDelay(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hidePanelDelay");
    }

    public static /* synthetic */ void layoutSeekBarElement$default(SimpleControlLayer simpleControlLayer, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            simpleControlLayer.layoutSeekBarElement(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layoutSeekBarElement");
    }

    public static /* synthetic */ void togglePanelVisible$default(SimpleControlLayer simpleControlLayer, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            simpleControlLayer.togglePanelVisible(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: togglePanelVisible");
    }

    public boolean enableControlLayerTouchEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            if (message != null && message.what == 100) {
                handleElementVisible(4);
            }
            super.handleLayerMessage(message);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void initContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RelativeLayout mContainer = new RelativeLayout(this.mContext);
            if (enableControlLayerTouchEvent()) {
                mContainer.setOnClickListener(this);
            }
            Unit unit = Unit.INSTANCE;
            this.mContainer = mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            mContainer.setLayoutParams(layoutParams);
        }
    }

    public void layoutBackElement() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BackButtonElement backButtonElement = this.backButtonElement;
            ViewGroup.LayoutParams layoutParams = (backButtonElement == null || (contentView = backButtonElement.getContentView()) == null) ? null : contentView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(9);
                layoutParams2.addRule(10);
                layoutParams2.leftMargin = BdPlayerUtils.dp2px(this.mContainer, 5.0f);
                layoutParams2.topMargin = BdPlayerUtils.dp2px(this.mContainer, 12.0f);
            }
        }
    }

    public void layoutLandButtonElement() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LandscapeButtonElement landscapeButtonElement = this.landscapeButtonElement;
            ViewGroup.LayoutParams layoutParams = (landscapeButtonElement == null || (contentView = landscapeButtonElement.getContentView()) == null) ? null : contentView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(11);
                layoutParams2.addRule(6, R.id.obfuscated_res_0x7f09036c);
                layoutParams2.addRule(8, R.id.obfuscated_res_0x7f09036c);
                layoutParams2.rightMargin = BdPlayerUtils.dp2px(this.mContainer, 15.0f);
            }
        }
    }

    public void layoutMuteElement() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MuteButtonElement muteButtonElement = this.muteButtonElement;
            ViewGroup.LayoutParams layoutParams = (muteButtonElement == null || (contentView = muteButtonElement.getContentView()) == null) ? null : contentView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(9);
                layoutParams2.addRule(6, R.id.obfuscated_res_0x7f09036c);
                layoutParams2.addRule(8, R.id.obfuscated_res_0x7f09036c);
                layoutParams2.leftMargin = BdPlayerUtils.dp2px(this.mContainer, 15.0f);
            }
        }
    }

    public void layoutPlayElement() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PlayButtonElement playButtonElement = this.playButtonElement;
            ViewGroup.LayoutParams layoutParams = (playButtonElement == null || (contentView = playButtonElement.getContentView()) == null) ? null : contentView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(13);
            }
        }
    }

    public void layoutSeekBarElement(boolean z) {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            SeekBarElement seekBarElement = this.seekBarElement;
            ViewGroup.LayoutParams layoutParams = (seekBarElement == null || (contentView = seekBarElement.getContentView()) == null) ? null : contentView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(12);
                layoutParams2.addRule(14);
                int dp2px = BdPlayerUtils.dp2px(this.mContainer, 36.0f);
                layoutParams2.leftMargin = dp2px;
                if (!z) {
                    dp2px = BdPlayerUtils.dp2px(this.mContainer, 15.0f);
                }
                layoutParams2.rightMargin = dp2px;
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && Intrinsics.areEqual(view2, (RelativeLayout) this.mContainer)) {
            togglePanelVisible$default(this, !this.isShowing, false, 2, null);
            sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_TOUCH_DOWN));
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            int hashCode = action.hashCode();
            if (hashCode != 723345051) {
                if (hashCode == 906917140 && action.equals(ControlEvent.ACTION_RESUME)) {
                    ((RelativeLayout) this.mContainer).setOnClickListener(this);
                }
            } else if (action.equals(ControlEvent.ACTION_START)) {
                handleElementVisible(4);
                ((RelativeLayout) this.mContainer).setOnClickListener(this);
            }
            super.onControlEventNotify(event);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent event) {
        BackButtonElement backButtonElement;
        BackButtonElement backButtonElement2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            switch (action.hashCode()) {
                case -552621273:
                    if (action.equals(LayerEvent.ACTION_SWITCH_FULL) && (backButtonElement = this.backButtonElement) != null) {
                        attachElementView(backButtonElement);
                        layoutBackElement();
                        layoutSeekBarElement(false);
                        togglePanelVisible$default(this, true, false, 2, null);
                        break;
                    }
                    break;
                case -552580917:
                    if (action.equals(LayerEvent.ACTION_SWITCH_HALF) && (backButtonElement2 = this.backButtonElement) != null) {
                        detachElementView(backButtonElement2);
                        handleElementVisible(4);
                        break;
                    }
                    break;
                case -21461611:
                    if (action.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        togglePanelVisible(!this.isShowing, true);
                        break;
                    }
                    break;
                case 250537257:
                    if (action.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        handleElementVisible(4);
                        break;
                    }
                    break;
            }
            super.onLayerEventNotify(event);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            int hashCode = action.hashCode();
            if (hashCode == -461848373 ? action.equals(PlayerEvent.ACTION_ON_ERROR) : !(hashCode != 154871702 || !action.equals(PlayerEvent.ACTION_ON_COMPLETE))) {
                handleElementVisible(4);
                ((RelativeLayout) this.mContainer).setOnClickListener(null);
            }
            super.onPlayerEventNotify(event);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void setupElement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PlayButtonElement playButtonElement = new PlayButtonElement();
            this.playButtonElement = playButtonElement;
            Intrinsics.checkNotNull(playButtonElement);
            addElement(playButtonElement);
            SeekBarElement seekBarElement = new SeekBarElement();
            this.seekBarElement = seekBarElement;
            Intrinsics.checkNotNull(seekBarElement);
            addElement(seekBarElement);
            MuteButtonElement muteButtonElement = new MuteButtonElement();
            this.muteButtonElement = muteButtonElement;
            Intrinsics.checkNotNull(muteButtonElement);
            addElement(muteButtonElement);
            LandscapeButtonElement landscapeButtonElement = new LandscapeButtonElement();
            this.landscapeButtonElement = landscapeButtonElement;
            Intrinsics.checkNotNull(landscapeButtonElement);
            addElement(landscapeButtonElement);
            BackButtonElement backButtonElement = new BackButtonElement();
            this.backButtonElement = backButtonElement;
            Intrinsics.checkNotNull(backButtonElement);
            addElement(backButtonElement);
        }
    }

    public void togglePanelVisible(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                T mContainer = this.mContainer;
                Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
                ((RelativeLayout) mContainer).setVisibility(z ? 0 : 8);
            }
            if (z) {
                BDVideoPlayer bindPlayer = getBindPlayer();
                Intrinsics.checkNotNullExpressionValue(bindPlayer, "bindPlayer");
                bindPlayer.getPlayerCallbackManager().onLayerShow(this);
                handleElementVisible(0);
                hidePanelDelay$default(this, 0L, 1, null);
            } else {
                BDVideoPlayer bindPlayer2 = getBindPlayer();
                Intrinsics.checkNotNullExpressionValue(bindPlayer2, "bindPlayer");
                bindPlayer2.getPlayerCallbackManager().onLayerDismiss(this);
                handleElementVisible(4);
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeMessages(100);
                }
            }
            VideoEvent obtainEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
            Intrinsics.checkNotNullExpressionValue(obtainEvent, "LayerEvent.obtainEvent(L…ON_PANEL_VISIBLE_CHANGED)");
            obtainEvent.putExtra(9, Boolean.valueOf(z));
            dispatchEvent(obtainEvent);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void layoutElement(RelativeLayout root) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, root) == null) {
            Intrinsics.checkNotNullParameter(root, "root");
            layoutPlayElement();
            layoutSeekBarElement$default(this, false, 1, null);
            layoutMuteElement();
            layoutLandButtonElement();
        }
    }
}
