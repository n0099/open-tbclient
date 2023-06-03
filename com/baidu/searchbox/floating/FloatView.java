package com.baidu.searchbox.floating;

import android.app.Notification;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.OverlayPermissionCheck;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/floating/FloatView;", "", "()V", "Builder", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatView {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FloatView";
    public static List<String> defaultFilters;
    public static boolean isClickCloseButton;
    public static boolean isRegisterLifecycle;

    @JvmStatic
    public static final void dismissAppFloatView(Context context, boolean z) {
        Companion.dismissAppFloatView(context, z);
    }

    @JvmStatic
    public static final boolean hasFloatView() {
        return Companion.hasFloatView();
    }

    @JvmStatic
    public static final void setDefaultBlockFilter(List<String> list) {
        Companion.setDefaultBlockFilter(list);
    }

    @JvmStatic
    public static final Builder with(Context context) {
        return Companion.with(context);
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u000fH\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/floating/FloatView$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mConfig", "Lcom/baidu/searchbox/floating/config/Config;", "addFloatListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/floating/listener/FloatViewListener;", "bindContext", "Lcom/baidu/searchbox/floating/IFloating;", "createFloatView", "", "filters", "", "", "setAnimator", ShaderParams.VALUE_TYPE_ANIMATOR, "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "setConfig", "config", "setDragEnable", "enable", "", "setFloatingView", "floatingView", "Landroid/view/View;", "setLocation", "x", "", "y", "show", "startForeground", "notification", "Landroid/app/Notification;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        public final Context context;
        public Config mConfig;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.mConfig = new Config();
        }

        public final Builder addFloatListener(FloatViewListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mConfig.getFloatViewListeners().add(listener);
            return this;
        }

        public final Builder bindContext(IFloating context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mConfig.setFloatingContext(context);
            return this;
        }

        public final Builder filters(List<String> filters) {
            List list;
            Intrinsics.checkNotNullParameter(filters, "filters");
            if (this.mConfig.getFilter().size() == 0 && (list = FloatView.defaultFilters) != null) {
                this.mConfig.getFilter().addAll(list);
            }
            this.mConfig.getFilter().addAll(filters);
            return this;
        }

        public final Builder setAnimator(FloatViewAnimator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.mConfig.setAnimator(animator);
            return this;
        }

        public final Builder setConfig(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.mConfig = config;
            return this;
        }

        public final Builder setDragEnable(boolean z) {
            this.mConfig.setCanDrag(z);
            return this;
        }

        public final Builder setFloatingView(View view2) {
            this.mConfig.setFloatingView(view2);
            return this;
        }

        public final Builder startForeground(Notification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            this.mConfig.setNotification(notification);
            this.mConfig.setForeground(true);
            return this;
        }

        private final void createFloatView() {
            FloatViewService.Companion.startService(this.context, this.mConfig);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Builder setLocation(int i, int i2) {
            this.mConfig.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            return this;
        }

        public final void show() {
            if (this.mConfig.getFloatingView() != null) {
                if (OverlayPermissionCheck.INSTANCE.hasPermission(this.context)) {
                    createFloatView();
                    return;
                }
                for (FloatViewListener floatViewListener : this.mConfig.getFloatViewListeners()) {
                    floatViewListener.onPermissionResult(false);
                }
                BdVideoLog.w("没有在其它应用上显示的权限");
                return;
            }
            for (FloatViewListener floatViewListener2 : this.mConfig.getFloatViewListeners()) {
                floatViewListener2.onViewCreate(false, null);
            }
            BdVideoLog.w("悬浮窗为空，请确保调用过`Builder.setFloatingView(view)");
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u000e2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u001f\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/floating/FloatView$Companion;", "", "()V", "TAG", "", "defaultFilters", "", "isClickCloseButton", "", "()Z", "setClickCloseButton", "(Z)V", "isRegisterLifecycle", "dismissAppFloatView", "", "context", "Landroid/content/Context;", "immediately", "getAppContentView", "Landroid/view/View;", "getAppPlayerContext", "Lcom/baidu/searchbox/floating/IFloating;", "hasFloatView", "hideAppFloatView", "invalidate", "registerLifeCycle", "lifeCycle", "Lkotlin/Function0;", "setDefaultBlockFilter", "filters", "showAppFloatView", "unregisterLifecycle", "with", "Lcom/baidu/searchbox/floating/FloatView$Builder;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final View getAppContentView() {
            Config config = FloatViewService.Companion.getConfig();
            if (config != null) {
                return config.getFloatingView();
            }
            return null;
        }

        public final IFloating getAppPlayerContext() {
            Config config = FloatViewService.Companion.getConfig();
            if (config != null) {
                return config.getFloatingContext();
            }
            return null;
        }

        @JvmStatic
        public final boolean hasFloatView() {
            ViewParent viewParent;
            if (getAppContentView() != null) {
                View appContentView = getAppContentView();
                if (appContentView != null) {
                    viewParent = appContentView.getParent();
                } else {
                    viewParent = null;
                }
                if (viewParent != null) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isClickCloseButton() {
            return FloatView.isClickCloseButton;
        }

        public static /* synthetic */ void dismissAppFloatView$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.dismissAppFloatView(context, z);
        }

        @JvmStatic
        public final void dismissAppFloatView(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            FloatViewService.Companion.dismiss(context, z);
        }

        public final void hideAppFloatView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            FloatViewService.Companion.setVisible(context, false);
        }

        public final void invalidate(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            FloatViewService.Companion.invalidate(context);
        }

        public final void registerLifeCycle(Function0<Unit> lifeCycle) {
            Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
            if (!FloatView.isRegisterLifecycle) {
                FloatView.isRegisterLifecycle = true;
                lifeCycle.invoke();
            }
        }

        public final void setClickCloseButton(boolean z) {
            FloatView.isClickCloseButton = z;
        }

        @JvmStatic
        public final void setDefaultBlockFilter(List<String> list) {
            FloatView.defaultFilters = list;
        }

        public final void showAppFloatView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            FloatViewService.Companion.setVisible(context, true);
        }

        public final void unregisterLifecycle(Function0<Unit> lifeCycle) {
            Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
            if (FloatView.isRegisterLifecycle) {
                FloatView.isRegisterLifecycle = false;
                lifeCycle.invoke();
            }
        }

        @JvmStatic
        public final Builder with(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context);
        }
    }
}
