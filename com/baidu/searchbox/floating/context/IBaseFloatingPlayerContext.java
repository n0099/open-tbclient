package com.baidu.searchbox.floating.context;

import android.app.Notification;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.player.interfaces.IFloatingPlayerContext;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/floating/context/IBaseFloatingPlayerContext;", "Lcom/baidu/searchbox/floating/IFloating;", "Lcom/baidu/searchbox/player/interfaces/IFloatingPlayerContext;", "getConfig", "Lcom/baidu/searchbox/floating/config/Config;", "switchToNormal", "", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IBaseFloatingPlayerContext extends IFloating, IFloatingPlayerContext {
    Config getConfig();

    void switchToNormal();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Config getConfig(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            return null;
        }

        public static void switchToNormal(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
        }

        public static void addFloatListener(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, FloatViewListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IFloating.DefaultImpls.addFloatListener(iBaseFloatingPlayerContext, listener);
        }

        public static void dismiss(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, boolean z) {
            IFloating.DefaultImpls.dismiss(iBaseFloatingPlayerContext, z);
        }

        public static void reverse(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, boolean z) {
            IFloating.DefaultImpls.reverse(iBaseFloatingPlayerContext, z);
        }

        public static void setAnimator(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, FloatViewAnimator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            IFloating.DefaultImpls.setAnimator(iBaseFloatingPlayerContext, animator);
        }

        public static void setDragEnable(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, boolean z) {
            IFloating.DefaultImpls.setDragEnable(iBaseFloatingPlayerContext, z);
        }

        public static void setScaleMode(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, Pair<? extends ScaleMode, ? extends ScaleMode> mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            IFloating.DefaultImpls.setScaleMode(iBaseFloatingPlayerContext, mode);
        }

        public static void startForeground(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, Notification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            IFloating.DefaultImpls.startForeground(iBaseFloatingPlayerContext, notification);
        }

        public static boolean hasFloatingView(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            return IFloating.DefaultImpls.hasFloatingView(iBaseFloatingPlayerContext);
        }

        public static boolean nextScale(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            return IFloating.DefaultImpls.nextScale(iBaseFloatingPlayerContext);
        }

        public static void onCreate(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            IFloating.DefaultImpls.onCreate(iBaseFloatingPlayerContext);
        }

        public static void onDestroy(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            IFloating.DefaultImpls.onDestroy(iBaseFloatingPlayerContext);
        }

        public static void switchToFloating(IBaseFloatingPlayerContext iBaseFloatingPlayerContext) {
            IFloatingPlayerContext.DefaultImpls.switchToFloating(iBaseFloatingPlayerContext);
        }

        public static void setBlockOffset(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, int i, int i2, int i3, int i4) {
            IFloating.DefaultImpls.setBlockOffset(iBaseFloatingPlayerContext, i, i2, i3, i4);
        }

        public static void setDefaultSize(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, int i, int i2) {
            IFloating.DefaultImpls.setDefaultSize(iBaseFloatingPlayerContext, i, i2);
        }

        public static void setLocation(IBaseFloatingPlayerContext iBaseFloatingPlayerContext, int i, int i2) {
            IFloating.DefaultImpls.setLocation(iBaseFloatingPlayerContext, i, i2);
        }
    }
}
