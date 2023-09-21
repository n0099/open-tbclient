package com.baidu.searchbox.player.layer;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
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
import com.yy.gslbsdk.db.DelayTB;
import java.util.AbstractCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0002H\u0014J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0012\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\bH\u0016J\u0012\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0013H\u0014J\u001c\u0010.\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u00020\b2\b\b\u0002\u00100\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/searchbox/player/layer/SimpleControlLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "backButtonElement", "Lcom/baidu/searchbox/player/element/BackButtonElement;", "isShowing", "", "landscapeButtonElement", "Lcom/baidu/searchbox/player/element/LandscapeButtonElement;", "muteButtonElement", "Lcom/baidu/searchbox/player/element/MuteButtonElement;", "playButtonElement", "Lcom/baidu/searchbox/player/element/PlayButtonElement;", "seekBarElement", "Lcom/baidu/searchbox/player/element/SeekBarElement;", "enableControlLayerTouchEvent", "handleElementVisible", "", "visibility", "", "handleLayerMessage", "msg", "Landroid/os/Message;", "hidePanelDelay", DelayTB.DELAY, "", "initContainer", "layoutBackElement", "layoutElement", "root", "layoutLandButtonElement", "layoutMuteElement", "layoutPlayElement", "layoutSeekBarElement", "half", "onClick", "v", "Landroid/view/View;", "onControlEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onLayerEventNotify", "onPlayerEventNotify", "setupElement", "togglePanelVisible", "isVisible", "needHideLayer", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SimpleControlLayer extends ElementLayer<RelativeLayout, AbsElement> {
    public BackButtonElement backButtonElement;
    public boolean isShowing;
    public LandscapeButtonElement landscapeButtonElement;
    public MuteButtonElement muteButtonElement;
    public PlayButtonElement playButtonElement;
    public SeekBarElement seekBarElement;

    public boolean enableControlLayerTouchEvent() {
        return true;
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void initContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        if (enableControlLayerTouchEvent()) {
            relativeLayout.setOnClickListener(this);
        }
        this.mContainer = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void layoutPlayElement() {
        ViewGroup.LayoutParams layoutParams;
        View contentView;
        PlayButtonElement playButtonElement = this.playButtonElement;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (playButtonElement != null && (contentView = playButtonElement.getContentView()) != null) {
            layoutParams = contentView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(13);
        }
    }

    private final void handleElementVisible(int i) {
        boolean z;
        View contentView;
        boolean z2;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        this.isShowing = z;
        AbstractCollection<AbsElement> mElements = this.mElements;
        Intrinsics.checkNotNullExpressionValue(mElements, "mElements");
        for (AbsElement absElement : mElements) {
            if (absElement != null && (contentView = absElement.getContentView()) != null) {
                if (contentView.getParent() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    contentView = null;
                }
                if (contentView != null) {
                    absElement.onParentVisibleChanged(i);
                }
            }
        }
    }

    public void layoutSeekBarElement(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        View contentView;
        SeekBarElement seekBarElement = this.seekBarElement;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (seekBarElement != null && (contentView = seekBarElement.getContentView()) != null) {
            layoutParams = contentView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
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

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent event) {
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

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -461848373 ? action.equals(PlayerEvent.ACTION_ON_ERROR) : hashCode == 154871702 && action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
            handleElementVisible(4);
            ((RelativeLayout) this.mContainer).setOnClickListener(null);
        }
        super.onPlayerEventNotify(event);
    }

    private final void hidePanelDelay(long j) {
        Message message;
        Handler handler;
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeMessages(100);
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null) {
            message = handler3.obtainMessage(100);
        } else {
            message = null;
        }
        if (message != null && (handler = this.mHandler) != null) {
            handler.sendMessageDelayed(message, j);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message message) {
        boolean z = false;
        if (message != null && message.what == 100) {
            z = true;
        }
        if (z) {
            handleElementVisible(4);
        }
        super.handleLayerMessage(message);
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (Intrinsics.areEqual(view2, this.mContainer)) {
            togglePanelVisible$default(this, !this.isShowing, false, 2, null);
            sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_TOUCH_DOWN));
        }
    }

    public static /* synthetic */ void hidePanelDelay$default(SimpleControlLayer simpleControlLayer, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 3000;
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

    public void layoutBackElement() {
        ViewGroup.LayoutParams layoutParams;
        View contentView;
        BackButtonElement backButtonElement = this.backButtonElement;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (backButtonElement != null && (contentView = backButtonElement.getContentView()) != null) {
            layoutParams = contentView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            layoutParams2.leftMargin = BdPlayerUtils.dp2px(this.mContainer, 5.0f);
            layoutParams2.topMargin = BdPlayerUtils.dp2px(this.mContainer, 12.0f);
        }
    }

    public void layoutLandButtonElement() {
        ViewGroup.LayoutParams layoutParams;
        View contentView;
        LandscapeButtonElement landscapeButtonElement = this.landscapeButtonElement;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (landscapeButtonElement != null && (contentView = landscapeButtonElement.getContentView()) != null) {
            layoutParams = contentView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.addRule(6, R.id.obfuscated_res_0x7f0903c4);
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f0903c4);
            layoutParams2.rightMargin = BdPlayerUtils.dp2px(this.mContainer, 15.0f);
        }
    }

    public void layoutMuteElement() {
        ViewGroup.LayoutParams layoutParams;
        View contentView;
        MuteButtonElement muteButtonElement = this.muteButtonElement;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (muteButtonElement != null && (contentView = muteButtonElement.getContentView()) != null) {
            layoutParams = contentView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(6, R.id.obfuscated_res_0x7f0903c4);
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f0903c4);
            layoutParams2.leftMargin = BdPlayerUtils.dp2px(this.mContainer, 15.0f);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void setupElement() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void layoutElement(RelativeLayout root) {
        Intrinsics.checkNotNullParameter(root, "root");
        layoutPlayElement();
        layoutSeekBarElement$default(this, false, 1, null);
        layoutMuteElement();
        layoutLandButtonElement();
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent event) {
        BackButtonElement backButtonElement;
        BackButtonElement backButtonElement2;
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

    public void togglePanelVisible(boolean z, boolean z2) {
        VideoPlayerCallbackBaseManager playerCallbackManager;
        VideoPlayerCallbackBaseManager playerCallbackManager2;
        int i;
        if (z2) {
            RelativeLayout relativeLayout = (RelativeLayout) this.mContainer;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
        if (z) {
            BDVideoPlayer bindPlayer = getBindPlayer();
            if (bindPlayer != null && (playerCallbackManager2 = bindPlayer.getPlayerCallbackManager()) != null) {
                playerCallbackManager2.onLayerShow(this);
            }
            handleElementVisible(0);
            hidePanelDelay$default(this, 0L, 1, null);
        } else {
            BDVideoPlayer bindPlayer2 = getBindPlayer();
            if (bindPlayer2 != null && (playerCallbackManager = bindPlayer2.getPlayerCallbackManager()) != null) {
                playerCallbackManager.onLayerDismiss(this);
            }
            handleElementVisible(4);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(100);
            }
        }
        VideoEvent obtainEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
        Intrinsics.checkNotNullExpressionValue(obtainEvent, "obtainEvent(LayerEvent.A…ON_PANEL_VISIBLE_CHANGED)");
        obtainEvent.putExtra(9, Boolean.valueOf(z));
        dispatchEvent(obtainEvent);
    }
}
