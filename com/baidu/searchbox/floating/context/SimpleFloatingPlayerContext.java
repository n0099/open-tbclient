package com.baidu.searchbox.floating.context;

import android.app.Notification;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.floating.FloatView;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.config.FloatingState;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.context.IBaseFloatingPlayerContext;
import com.baidu.searchbox.floating.context.SimpleFloatingPlayerContext;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.listener.SimpleFloatListener;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016J(\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020\u001fH\u0014J\u0018\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020/H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020$H\u0016J\u0018\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/H\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u001fH\u0016J\b\u0010B\u001a\u00020\u001fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/floating/context/SimpleFloatingPlayerContext;", "Lcom/baidu/searchbox/floating/context/IBaseFloatingPlayerContext;", "()V", "defaultConfig", "Lcom/baidu/searchbox/floating/config/Config;", "getDefaultConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "floatingListener", "Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "getFloatingListener", "()Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "floatingListener$delegate", "Lkotlin/Lazy;", "playerOldMode", "", "getPlayerOldMode", "()Ljava/lang/String;", "setPlayerOldMode", "(Ljava/lang/String;)V", "state", "Lcom/baidu/searchbox/floating/config/FloatingState;", "getState", "()Lcom/baidu/searchbox/floating/config/FloatingState;", "state$delegate", "videoPlayer", "Lcom/baidu/searchbox/player/UniversalPlayer;", "getVideoPlayer", "()Lcom/baidu/searchbox/player/UniversalPlayer;", "setVideoPlayer", "(Lcom/baidu/searchbox/player/UniversalPlayer;)V", "addFloatListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "dismiss", "immediately", "", "getConfig", "hasFloatingView", "onCreate", MissionEvent.MESSAGE_DESTROY, MediaAEffect.AE_ANIM_REVERSE, "setAnimator", ShaderParams.VALUE_TYPE_ANIMATOR, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "setBlockOffset", "left", "", "top", "right", "bottom", "setDefaultNotification", "setDefaultSize", "with", "height", "setDragEnable", "enable", "setLocation", "x", "y", "setPlayer", DI.LIVE_PLAYER, "startForeground", "notification", "Landroid/app/Notification;", "switchToFloating", "switchToNormal", "BaseCommonFloatListener", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatingPlayerContext implements IBaseFloatingPlayerContext {
    public String playerOldMode;
    public UniversalPlayer videoPlayer;
    public final Config defaultConfig = new Config();
    public final Lazy state$delegate = BdPlayerUtils.lazyNone(new Function0<FloatingState>() { // from class: com.baidu.searchbox.floating.context.SimpleFloatingPlayerContext$state$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FloatingState invoke() {
            return new FloatingState(null, 1, null);
        }
    });
    public final Lazy floatingListener$delegate = BdPlayerUtils.lazyNone(new Function0<BaseCommonFloatListener>() { // from class: com.baidu.searchbox.floating.context.SimpleFloatingPlayerContext$floatingListener$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SimpleFloatingPlayerContext.BaseCommonFloatListener invoke() {
            return new SimpleFloatingPlayerContext.BaseCommonFloatListener();
        }
    });

    @Override // com.baidu.searchbox.floating.IFloating
    public void onCreate() {
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void onDestroy() {
    }

    @Override // com.baidu.searchbox.floating.context.IBaseFloatingPlayerContext
    public void switchToNormal() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/floating/context/SimpleFloatingPlayerContext$BaseCommonFloatListener;", "Lcom/baidu/searchbox/floating/listener/SimpleFloatListener;", "(Lcom/baidu/searchbox/floating/context/SimpleFloatingPlayerContext;)V", "onGestureSingleTapConfirmed", "", "onScaleGestureCallback", "isInProgress", "", "onViewCreate", "isCreate", "view", "Landroid/view/View;", "scaleLevel", "Lcom/baidu/searchbox/floating/config/ScaleMode;", CriusAttrConstants.POSITION, "Landroid/graphics/Point;", "onViewHide", "onViewShow", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public class BaseCommonFloatListener extends SimpleFloatListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public BaseCommonFloatListener() {
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener
        public void onScaleGestureCallback(boolean z) {
            UniversalPlayer videoPlayer = SimpleFloatingPlayerContext.this.getVideoPlayer();
            if (videoPlayer != null) {
                VideoEvent obtainEvent = LayerEvent.obtainEvent(FloatingLayerEvent.ACTION_FLOATING_GESTURE);
                obtainEvent.putExtra(1, Boolean.valueOf(z));
                videoPlayer.sendEvent(obtainEvent);
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewHide(View view2) {
            UniversalPlayer videoPlayer;
            Intrinsics.checkNotNullParameter(view2, "view");
            UniversalPlayer videoPlayer2 = SimpleFloatingPlayerContext.this.getVideoPlayer();
            boolean z = true;
            if (((videoPlayer2 == null || !videoPlayer2.isFloatingMode()) ? false : false) && (videoPlayer = SimpleFloatingPlayerContext.this.getVideoPlayer()) != null) {
                videoPlayer.pause();
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewShow(View view2) {
            UniversalPlayer videoPlayer;
            Intrinsics.checkNotNullParameter(view2, "view");
            UniversalPlayer videoPlayer2 = SimpleFloatingPlayerContext.this.getVideoPlayer();
            boolean z = true;
            if (((videoPlayer2 == null || !videoPlayer2.isFloatingMode()) ? false : false) && !BdVolumeUtils.isMusicActive(view2.getContext()) && (videoPlayer = SimpleFloatingPlayerContext.this.getVideoPlayer()) != null) {
                videoPlayer.resume();
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener
        public void onGestureSingleTapConfirmed() {
            UniversalPlayer videoPlayer = SimpleFloatingPlayerContext.this.getVideoPlayer();
            if (videoPlayer != null) {
                videoPlayer.sendEvent(LayerEvent.obtainEvent(FloatingLayerEvent.ACTION_FLOATING_SINGLE_TAP_CONFIRMED));
            }
        }

        @Override // com.baidu.searchbox.floating.listener.SimpleFloatListener, com.baidu.searchbox.floating.listener.FloatViewListener
        public void onViewCreate(boolean z, View view2, ScaleMode scaleLevel, Point position) {
            UniversalPlayer videoPlayer;
            Intrinsics.checkNotNullParameter(scaleLevel, "scaleLevel");
            Intrinsics.checkNotNullParameter(position, "position");
            if (z && view2 != null && (videoPlayer = SimpleFloatingPlayerContext.this.getVideoPlayer()) != null) {
                videoPlayer.attachToContainer((ViewGroup) view2);
            }
        }
    }

    public SimpleFloatingPlayerContext() {
        this.defaultConfig.setSize(new Pair<>(187, 105));
        this.defaultConfig.setLocation(new Pair<>(15, 80));
        this.defaultConfig.setCornerRadius(9.0f);
    }

    @Override // com.baidu.searchbox.player.interfaces.IFloatingPlayerContext
    public void switchToFloating() {
        LayerContainer layerContainer;
        UniversalPlayer universalPlayer = this.videoPlayer;
        if (universalPlayer != null && (layerContainer = universalPlayer.getLayerContainer()) != null) {
            FloatView.Companion companion = FloatView.Companion;
            Context context = layerContainer.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FloatView.Builder config = companion.with(context).setConfig(this.defaultConfig);
            if (this.defaultConfig.getNotification() == null) {
                setDefaultNotification();
            }
            config.bindContext(this).setFloatingView(new FrameLayout(layerContainer.getContext())).addFloatListener(getFloatingListener()).show();
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void addFloatListener(FloatViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.defaultConfig.getFloatViewListeners().add(listener);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void dismiss(boolean z) {
        View floatingView;
        Context context;
        if (hasFloatingView() && (floatingView = this.defaultConfig.getFloatingView()) != null && (context = floatingView.getContext()) != null) {
            FloatView.Companion.dismissAppFloatView(context, z);
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void reverse(boolean z) {
        this.defaultConfig.setReverse(z);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setAnimator(FloatViewAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.defaultConfig.setAnimator(animator);
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDragEnable(boolean z) {
        this.defaultConfig.setCanDrag(z);
    }

    @Override // com.baidu.searchbox.player.context.IPlayerContext
    public void setPlayer(UniversalPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.videoPlayer = player;
    }

    public final void setPlayerOldMode(String str) {
        this.playerOldMode = str;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
        IBaseFloatingPlayerContext.DefaultImpls.setScaleMode(this, pair);
    }

    public final void setVideoPlayer(UniversalPlayer universalPlayer) {
        this.videoPlayer = universalPlayer;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void startForeground(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.defaultConfig.setForeground(true);
        this.defaultConfig.setNotification(notification);
    }

    @Override // com.baidu.searchbox.floating.context.IBaseFloatingPlayerContext
    public Config getConfig() {
        return this.defaultConfig;
    }

    public final Config getDefaultConfig() {
        return this.defaultConfig;
    }

    public SimpleFloatListener getFloatingListener() {
        return (SimpleFloatListener) this.floatingListener$delegate.getValue();
    }

    public final String getPlayerOldMode() {
        return this.playerOldMode;
    }

    public final FloatingState getState() {
        return (FloatingState) this.state$delegate.getValue();
    }

    public final UniversalPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public boolean hasFloatingView() {
        return FloatView.Companion.hasFloatView();
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public boolean nextScale() {
        return IBaseFloatingPlayerContext.DefaultImpls.nextScale(this);
    }

    public void setDefaultNotification() {
        Context appContext;
        UniversalPlayer universalPlayer = this.videoPlayer;
        if (universalPlayer != null && (appContext = universalPlayer.getAppContext()) != null) {
            this.defaultConfig.setNotification(UtilsKt.getDefaultNotification$default(appContext, 0, null, null, null, null, 62, null));
            if (this.defaultConfig.getNotification() != null) {
                this.defaultConfig.setForeground(true);
            }
        }
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setBlockOffset(int i, int i2, int i3, int i4) {
        this.defaultConfig.setBlockOffset(new Rect(i, i2, i3, i4));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setDefaultSize(int i, int i2) {
        this.defaultConfig.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.baidu.searchbox.floating.IFloating
    public void setLocation(int i, int i2) {
        this.defaultConfig.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
