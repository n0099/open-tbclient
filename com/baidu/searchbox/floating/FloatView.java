package com.baidu.searchbox.floating;

import android.app.Notification;
import android.content.Context;
import android.view.View;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.OverlayPermissionCheck;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.List;
import kotlin.Pair;
import kotlin.e;
import kotlin.h;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes16.dex */
public final class FloatView {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FloatView";
    private static boolean isClickCloseButton;
    private static boolean isRegisterLifecycle;

    public static final void dismissAppFloatView(Context context, boolean z) {
        Companion.dismissAppFloatView(context, z);
    }

    public static final boolean hasFloatView() {
        return Companion.hasFloatView();
    }

    public static final Builder with(Context context) {
        return Companion.with(context);
    }

    @e
    /* loaded from: classes16.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        private final boolean isRegisterLifecycle() {
            return FloatView.isRegisterLifecycle;
        }

        private final void setRegisterLifecycle(boolean z) {
            FloatView.isRegisterLifecycle = z;
        }

        public final boolean isClickCloseButton() {
            return FloatView.isClickCloseButton;
        }

        public final void setClickCloseButton(boolean z) {
            FloatView.isClickCloseButton = z;
        }

        public final Builder with(Context context) {
            p.o(context, "context");
            return new Builder(context);
        }

        public final void showAppFloatView(Context context) {
            p.o(context, "context");
            FloatViewService.Companion.setVisible(context, true);
        }

        public static /* synthetic */ void dismissAppFloatView$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.dismissAppFloatView(context, z);
        }

        public final void dismissAppFloatView(Context context, boolean z) {
            p.o(context, "context");
            FloatViewService.Companion.dismiss(context, z);
        }

        public final void hideAppFloatView(Context context) {
            p.o(context, "context");
            FloatViewService.Companion.setVisible(context, false);
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

        public final void invalidate(Context context) {
            p.o(context, "context");
            FloatViewService.Companion.invalidate(context);
        }

        public final boolean hasFloatView() {
            if (getAppContentView() != null) {
                View appContentView = getAppContentView();
                if ((appContentView != null ? appContentView.getParent() : null) != null) {
                    return true;
                }
            }
            return false;
        }

        public final void registerLifeCycle(a<h> aVar) {
            p.o(aVar, "lifeCycle");
            if (!isRegisterLifecycle()) {
                setRegisterLifecycle(true);
                aVar.invoke();
            }
        }

        public final void unregisterLifecycle(a<h> aVar) {
            p.o(aVar, "lifeCycle");
            if (isRegisterLifecycle()) {
                setRegisterLifecycle(false);
                aVar.invoke();
            }
        }
    }

    @e
    /* loaded from: classes16.dex */
    public static final class Builder {
        private final Context context;
        private Config mConfig;

        public Builder(Context context) {
            p.o(context, "context");
            this.context = context;
            this.mConfig = new Config();
        }

        public final Context getContext() {
            return this.context;
        }

        public final Builder setConfig(Config config) {
            p.o(config, "config");
            this.mConfig = config;
            return this;
        }

        public final Builder setLocation(int i, int i2) {
            this.mConfig.setLocation(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            return this;
        }

        public final Builder setFloatingView(View view) {
            this.mConfig.setFloatingView(view);
            return this;
        }

        public final Builder setDragEnable(boolean z) {
            this.mConfig.setCanDrag(z);
            return this;
        }

        public final Builder setAnimator(FloatViewAnimator floatViewAnimator) {
            p.o(floatViewAnimator, "animator");
            this.mConfig.setAnimator(floatViewAnimator);
            return this;
        }

        public final Builder startForeground(Notification notification) {
            p.o(notification, ActionJsonData.TAG_NOTIFICATION);
            this.mConfig.setNotification(notification);
            this.mConfig.setForeground(true);
            return this;
        }

        public final Builder addFloatListener(FloatViewListener floatViewListener) {
            p.o(floatViewListener, "listener");
            this.mConfig.getFloatViewListeners().add(floatViewListener);
            return this;
        }

        public final Builder bindContext(IFloating iFloating) {
            p.o(iFloating, "context");
            this.mConfig.setFloatingContext(iFloating);
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

        private final void createFloatView() {
            FloatViewService.Companion.startService(this.context, this.mConfig);
        }

        public final Builder filters(List<String> list) {
            p.o(list, "filters");
            this.mConfig.getFilter().clear();
            this.mConfig.getFilter().addAll(list);
            return this;
        }
    }
}
