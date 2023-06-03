package com.baidu.searchbox.floating.layer;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.searchbox.floating.element.SimpleFloatingBackElement;
import com.baidu.searchbox.floating.element.SimpleFloatingBackgroundElement;
import com.baidu.searchbox.floating.element.SimpleFloatingCloseElement;
import com.baidu.searchbox.floating.element.SimpleFloatingErrorElement;
import com.baidu.searchbox.floating.element.SimpleFloatingPlayButtonElement;
import com.baidu.searchbox.floating.element.SimpleFloatingRePlayElement;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.floating.layer.SimpleFloatingControlLayer;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ElementLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.gslbsdk.db.DelayTB;
import java.util.AbstractCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020+H\u0014J\b\u0010-\u001a\u00020+H\u0014J\b\u0010.\u001a\u00020+H\u0014J\b\u0010/\u001a\u00020+H\u0014J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0014J\u0012\u00106\u001a\u00020+2\b\b\u0002\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020+H\u0014J\u001f\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0002H\u0014J\u001f\u0010A\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0002\u0010>J\u001f\u0010B\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\b\u0010C\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0002\u0010>J\u001f\u0010D\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0002\u0010>J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010J\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010K\u001a\u00020+H\u0014J\u0012\u0010L\u001a\u00020+2\b\b\u0002\u0010M\u001a\u00020\u0018H\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006N"}, d2 = {"Lcom/baidu/searchbox/floating/layer/SimpleFloatingControlLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "backElement", "Lcom/baidu/searchbox/floating/element/SimpleFloatingBackElement;", "getBackElement", "()Lcom/baidu/searchbox/floating/element/SimpleFloatingBackElement;", "setBackElement", "(Lcom/baidu/searchbox/floating/element/SimpleFloatingBackElement;)V", "closeElement", "Lcom/baidu/searchbox/floating/element/SimpleFloatingCloseElement;", "getCloseElement", "()Lcom/baidu/searchbox/floating/element/SimpleFloatingCloseElement;", "setCloseElement", "(Lcom/baidu/searchbox/floating/element/SimpleFloatingCloseElement;)V", "errorElement", "Lcom/baidu/searchbox/floating/element/SimpleFloatingErrorElement;", "getErrorElement", "()Lcom/baidu/searchbox/floating/element/SimpleFloatingErrorElement;", "setErrorElement", "(Lcom/baidu/searchbox/floating/element/SimpleFloatingErrorElement;)V", "isShowing", "", "()Z", "setShowing", "(Z)V", "isSingleTapConfirmed", "isSingleTapUp", "playElement", "Lcom/baidu/searchbox/floating/element/SimpleFloatingPlayButtonElement;", "getPlayElement", "()Lcom/baidu/searchbox/floating/element/SimpleFloatingPlayButtonElement;", "setPlayElement", "(Lcom/baidu/searchbox/floating/element/SimpleFloatingPlayButtonElement;)V", "rePlayElement", "Lcom/baidu/searchbox/floating/element/SimpleFloatingRePlayElement;", "getRePlayElement", "()Lcom/baidu/searchbox/floating/element/SimpleFloatingRePlayElement;", "setRePlayElement", "(Lcom/baidu/searchbox/floating/element/SimpleFloatingRePlayElement;)V", "addBackElement", "", "addCloseElement", "addErrorElement", "addPlayElement", "addRePlayElement", "handleElementVisible", "visibility", "", "handleLayerMessage", "msg", "Landroid/os/Message;", "hidePanelDelay", DelayTB.DELAY, "", "initContainer", "layoutCenter", "containerSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "id", "(Landroidx/constraintlayout/widget/ConstraintSet;Ljava/lang/Integer;)V", "layoutElement", "root", "layoutLeftTop", "layoutPlayButton", "playId", "layoutRightTop", "onControlEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onLayerEventNotify", "onPlayerEventNotify", "onSystemEventNotify", "setupElement", "togglePanelVisible", "isVisible", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatingControlLayer extends ElementLayer<ConstraintLayout, AbsElement> {
    public SimpleFloatingBackElement backElement;
    public SimpleFloatingCloseElement closeElement;
    public SimpleFloatingErrorElement errorElement;
    public boolean isShowing;
    public boolean isSingleTapConfirmed;
    public boolean isSingleTapUp;
    public SimpleFloatingPlayButtonElement playElement;
    public SimpleFloatingRePlayElement rePlayElement;

    public void addBackElement() {
        SimpleFloatingBackElement simpleFloatingBackElement = new SimpleFloatingBackElement();
        addElement(simpleFloatingBackElement);
        this.backElement = simpleFloatingBackElement;
    }

    public void addCloseElement() {
        SimpleFloatingCloseElement simpleFloatingCloseElement = new SimpleFloatingCloseElement();
        addElement(simpleFloatingCloseElement);
        this.closeElement = simpleFloatingCloseElement;
    }

    public void addErrorElement() {
        SimpleFloatingErrorElement simpleFloatingErrorElement = new SimpleFloatingErrorElement();
        addElement(simpleFloatingErrorElement);
        this.errorElement = simpleFloatingErrorElement;
    }

    public void addPlayElement() {
        SimpleFloatingPlayButtonElement simpleFloatingPlayButtonElement = new SimpleFloatingPlayButtonElement();
        addElement(simpleFloatingPlayButtonElement);
        this.playElement = simpleFloatingPlayButtonElement;
    }

    public void addRePlayElement() {
        SimpleFloatingRePlayElement simpleFloatingRePlayElement = new SimpleFloatingRePlayElement();
        addElement(simpleFloatingRePlayElement);
        this.rePlayElement = simpleFloatingRePlayElement;
    }

    public final SimpleFloatingBackElement getBackElement() {
        return this.backElement;
    }

    public final SimpleFloatingCloseElement getCloseElement() {
        return this.closeElement;
    }

    public final SimpleFloatingErrorElement getErrorElement() {
        return this.errorElement;
    }

    public final SimpleFloatingPlayButtonElement getPlayElement() {
        return this.playElement;
    }

    public final SimpleFloatingRePlayElement getRePlayElement() {
        return this.rePlayElement;
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void initContainer() {
        ConstraintLayout constraintLayout = new ConstraintLayout(this.mContext);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.no1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    SimpleFloatingControlLayer.m90initContainer$lambda1$lambda0(SimpleFloatingControlLayer.this, view2);
                }
            }
        });
        this.mContainer = constraintLayout;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void setupElement() {
        addElement(new SimpleFloatingBackgroundElement());
        addPlayElement();
        addCloseElement();
        addBackElement();
        addRePlayElement();
        addErrorElement();
    }

    private final void hidePanelDelay(long j) {
        Message obtainMessage;
        Handler handler;
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeMessages(100);
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null && (obtainMessage = handler3.obtainMessage(100)) != null && (handler = this.mHandler) != null) {
            handler.sendMessageDelayed(obtainMessage, j);
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer
    public void handleLayerMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 100) {
            BDVideoPlayer bindPlayer = getBindPlayer();
            boolean z = false;
            if (bindPlayer != null && !bindPlayer.isPause()) {
                z = true;
            }
            if (z) {
                handleElementVisible(4);
            }
        }
        super.handleLayerMessage(msg);
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onControlEventNotify(event);
        if (Intrinsics.areEqual(event.getAction(), ControlEvent.ACTION_RESUME)) {
            hidePanelDelay$default(this, 0L, 1, null);
        }
    }

    public final void setBackElement(SimpleFloatingBackElement simpleFloatingBackElement) {
        this.backElement = simpleFloatingBackElement;
    }

    public final void setCloseElement(SimpleFloatingCloseElement simpleFloatingCloseElement) {
        this.closeElement = simpleFloatingCloseElement;
    }

    public final void setErrorElement(SimpleFloatingErrorElement simpleFloatingErrorElement) {
        this.errorElement = simpleFloatingErrorElement;
    }

    public final void setPlayElement(SimpleFloatingPlayButtonElement simpleFloatingPlayButtonElement) {
        this.playElement = simpleFloatingPlayButtonElement;
    }

    public final void setRePlayElement(SimpleFloatingRePlayElement simpleFloatingRePlayElement) {
        this.rePlayElement = simpleFloatingRePlayElement;
    }

    public final void setShowing(boolean z) {
        this.isShowing = z;
    }

    public void togglePanelVisible(boolean z) {
        if (z) {
            handleElementVisible(0);
            hidePanelDelay$default(this, 0L, 1, null);
            return;
        }
        handleElementVisible(4);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    public static /* synthetic */ void hidePanelDelay$default(SimpleFloatingControlLayer simpleFloatingControlLayer, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 3000;
            }
            simpleFloatingControlLayer.hidePanelDelay(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hidePanelDelay");
    }

    public static /* synthetic */ void togglePanelVisible$default(SimpleFloatingControlLayer simpleFloatingControlLayer, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            simpleFloatingControlLayer.togglePanelVisible(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: togglePanelVisible");
    }

    /* renamed from: initContainer$lambda-1$lambda-0  reason: not valid java name */
    public static final void m90initContainer$lambda1$lambda0(SimpleFloatingControlLayer this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSingleTapConfirmed && this$0.isSingleTapUp) {
            this$0.togglePanelVisible(!this$0.isShowing);
            this$0.isSingleTapConfirmed = false;
            this$0.isSingleTapUp = false;
            return;
        }
        this$0.isSingleTapUp = true;
    }

    private final void layoutCenter(ConstraintSet constraintSet, Integer num) {
        if (num != null) {
            num.intValue();
            constraintSet.centerHorizontally(num.intValue(), 0);
            constraintSet.centerVertically(num.intValue(), 0);
        }
    }

    public void layoutPlayButton(ConstraintSet containerSet, Integer num) {
        Intrinsics.checkNotNullParameter(containerSet, "containerSet");
        if (num != null) {
            num.intValue();
            int intValue = num.intValue();
            T mContainer = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            containerSet.connect(intValue, 4, 0, 4, UtilsKt.buttonBottomMargin(mContainer));
            containerSet.centerHorizontally(num.intValue(), 0);
        }
    }

    public void handleElementVisible(int i) {
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

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode == -461848373 ? action.equals(PlayerEvent.ACTION_ON_ERROR) : hashCode == 154871702 && action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
            handleElementVisible(4);
        }
        super.onPlayerEventNotify(event);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.layer.ElementLayer
    public void layoutElement(ConstraintLayout root) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        View contentView;
        View contentView2;
        View contentView3;
        LinearLayout contentView4;
        LinearLayout contentView5;
        Intrinsics.checkNotNullParameter(root, "root");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this.mContainer);
        SimpleFloatingCloseElement simpleFloatingCloseElement = this.closeElement;
        Integer num5 = null;
        if (simpleFloatingCloseElement != null && (contentView5 = simpleFloatingCloseElement.getContentView()) != null) {
            num = Integer.valueOf(contentView5.getId());
        } else {
            num = null;
        }
        layoutLeftTop(constraintSet, num);
        SimpleFloatingBackElement simpleFloatingBackElement = this.backElement;
        if (simpleFloatingBackElement != null && (contentView4 = simpleFloatingBackElement.getContentView()) != null) {
            num2 = Integer.valueOf(contentView4.getId());
        } else {
            num2 = null;
        }
        layoutRightTop(constraintSet, num2);
        SimpleFloatingPlayButtonElement simpleFloatingPlayButtonElement = this.playElement;
        if (simpleFloatingPlayButtonElement != null && (contentView3 = simpleFloatingPlayButtonElement.getContentView()) != null) {
            num3 = Integer.valueOf(contentView3.getId());
        } else {
            num3 = null;
        }
        layoutPlayButton(constraintSet, num3);
        SimpleFloatingRePlayElement simpleFloatingRePlayElement = this.rePlayElement;
        if (simpleFloatingRePlayElement != null && (contentView2 = simpleFloatingRePlayElement.getContentView()) != null) {
            num4 = Integer.valueOf(contentView2.getId());
        } else {
            num4 = null;
        }
        layoutCenter(constraintSet, num4);
        SimpleFloatingErrorElement simpleFloatingErrorElement = this.errorElement;
        if (simpleFloatingErrorElement != null && (contentView = simpleFloatingErrorElement.getContentView()) != null) {
            num5 = Integer.valueOf(contentView.getId());
        }
        layoutCenter(constraintSet, num5);
        constraintSet.applyTo((ConstraintLayout) this.mContainer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.LayerEvent.ACTION_FLOATING_PLAY_CLICK) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        r4.isSingleTapUp = false;
        hidePanelDelay$default(r4, 0, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.LayerEvent.ACTION_FLOATING_PLAY_NEXT) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.LayerEvent.ACTION_FLOATING_PLAY_LAST) == false) goto L16;
     */
    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -737078269:
                break;
            case -601386696:
                if (action.equals(FloatingLayerEvent.ACTION_FLOATING_SINGLE_TAP_CONFIRMED)) {
                    this.isSingleTapConfirmed = true;
                    ((ConstraintLayout) this.mContainer).performClick();
                    break;
                }
                break;
            case 1409909918:
                if (action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    togglePanelVisible(true);
                    break;
                }
                break;
            case 1916143803:
                break;
            case 1916207384:
                break;
        }
        super.onLayerEventNotify(event);
    }

    public void layoutLeftTop(ConstraintSet containerSet, Integer num) {
        Intrinsics.checkNotNullParameter(containerSet, "containerSet");
        if (num != null) {
            num.intValue();
            int intValue = num.intValue();
            T mContainer = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            containerSet.connect(intValue, 3, 0, 3, UtilsKt.buttonVerticalMargin(mContainer));
            int intValue2 = num.intValue();
            T mContainer2 = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer2, "mContainer");
            containerSet.connect(intValue2, 6, 0, 6, UtilsKt.buttonHorizontalMargin(mContainer2));
        }
    }

    public void layoutRightTop(ConstraintSet containerSet, Integer num) {
        Intrinsics.checkNotNullParameter(containerSet, "containerSet");
        if (num != null) {
            num.intValue();
            int intValue = num.intValue();
            T mContainer = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            containerSet.connect(intValue, 3, 0, 3, UtilsKt.buttonVerticalMargin(mContainer));
            int intValue2 = num.intValue();
            T mContainer2 = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer2, "mContainer");
            containerSet.connect(intValue2, 7, 0, 7, UtilsKt.buttonHorizontalMargin(mContainer2));
        }
    }

    @Override // com.baidu.searchbox.player.layer.ElementLayer, com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(VideoEvent event) {
        BDVideoPlayer bindPlayer;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onSystemEventNotify(event);
        String action = event.getAction();
        int hashCode = action.hashCode();
        boolean z = true;
        if (hashCode != -203007503) {
            if (hashCode == 1517472029 && action.equals(SystemEvent.ACTION_SCREEN_ON)) {
                BDVideoPlayer bindPlayer2 = getBindPlayer();
                if ((bindPlayer2 == null || !bindPlayer2.isPause()) ? false : false) {
                    handleElementVisible(0);
                }
            }
        } else if (action.equals(SystemEvent.ACTION_SCREEN_OFF)) {
            BDVideoPlayer bindPlayer3 = getBindPlayer();
            if (((bindPlayer3 == null || !bindPlayer3.isPlaying()) ? false : false) && (bindPlayer = getBindPlayer()) != null) {
                bindPlayer.pause();
            }
        }
    }
}
