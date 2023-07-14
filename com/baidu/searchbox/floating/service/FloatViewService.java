package com.baidu.searchbox.floating.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.ViewManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/floating/service/FloatViewService;", "Landroid/app/Service;", "()V", SocialConstants.PARAM_RECEIVER, "com/baidu/searchbox/floating/service/FloatViewService$receiver$1", "Lcom/baidu/searchbox/floating/service/FloatViewService$receiver$1;", "viewManager", "Lcom/baidu/searchbox/floating/widget/ViewManager;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", MissionEvent.MESSAGE_DESTROY, "onStartCommand", "", "flags", "startId", "startForegroundWithNotification", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatViewService extends Service {
    public static final String FLOAT_ACTION = "com.baidu.searchbox.floating.action.FLOATING";
    public static final String FLOAT_DISMISS = "float_dismiss";
    public static final String FLOAT_DISMISS_IMMEDIATELY = "float_dismiss_immediately";
    public static final String FLOAT_INVALIDATE = "float_invalidate";
    public static final String FLOAT_VISIBLE = "float_visible";
    public static final String TAG = "FloatViewService";
    @SuppressLint({"StaticFieldLeak"})
    public static Config config;
    public final FloatViewService$receiver$1 receiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.floating.service.FloatViewService$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewManager viewManager;
            ViewManager viewManager2;
            ViewManager viewManager3;
            ViewManager viewManager4;
            ViewManager viewManager5;
            ViewManager viewManager6;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), FloatViewService.FLOAT_ACTION)) {
                viewManager = FloatViewService.this.viewManager;
                if (viewManager != null) {
                    if (intent.getBooleanExtra(FloatViewService.FLOAT_DISMISS, false)) {
                        if (intent.getBooleanExtra(FloatViewService.FLOAT_DISMISS_IMMEDIATELY, false)) {
                            viewManager6 = FloatViewService.this.viewManager;
                            if (viewManager6 != null) {
                                viewManager6.destroy();
                                return;
                            }
                            return;
                        }
                        viewManager5 = FloatViewService.this.viewManager;
                        if (viewManager5 != null) {
                            viewManager5.exitAnim();
                        }
                    } else if (intent.getBooleanExtra(FloatViewService.FLOAT_INVALIDATE, false)) {
                        viewManager4 = FloatViewService.this.viewManager;
                        if (viewManager4 != null) {
                            viewManager4.updateLayoutParams();
                        }
                    } else if (intent.getBooleanExtra(FloatViewService.FLOAT_VISIBLE, true)) {
                        viewManager3 = FloatViewService.this.viewManager;
                        if (viewManager3 != null) {
                            viewManager3.setVisible(0);
                        }
                    } else {
                        viewManager2 = FloatViewService.this.viewManager;
                        if (viewManager2 != null) {
                            viewManager2.setVisible(8);
                        }
                    }
                }
            }
        }
    };
    public ViewManager viewManager;
    public static final Companion Companion = new Companion(null);
    public static final Lazy<Handler> innerHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.searchbox.floating.service.FloatViewService$Companion$innerHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/floating/service/FloatViewService$Companion;", "", "()V", "FLOAT_ACTION", "", "FLOAT_DISMISS", "FLOAT_DISMISS_IMMEDIATELY", "FLOAT_INVALIDATE", "FLOAT_VISIBLE", "TAG", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "setConfig", "(Lcom/baidu/searchbox/floating/config/Config;)V", "innerHandler", "Landroid/os/Handler;", "getInnerHandler", "()Landroid/os/Handler;", "innerHandler$delegate", "Lkotlin/Lazy;", "checkNotification", "", "context", "Landroid/content/Context;", "dismiss", "immediately", "", "invalidate", "setVisible", MapBundleKey.MapObjKey.OBJ_SL_VISI, "startService", "cfg", "stopService", "stopService$floating_view_release", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        private final Handler getInnerHandler() {
            return (Handler) FloatViewService.innerHandler$delegate.getValue();
        }

        public final Config getConfig() {
            return FloatViewService.config;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkNotification(Context context, Config config) {
            if (config.getNotification() == null) {
                config.setNotification(UtilsKt.getDefaultNotification$default(context, 0, null, null, null, null, 62, null));
            }
        }

        public final void dismiss(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_DISMISS, true);
            intent.putExtra(FloatViewService.FLOAT_DISMISS_IMMEDIATELY, z);
            if (Build.VERSION.SDK_INT <= 30) {
                UtilsKt.sendLocalBroadcast(context, intent);
            } else {
                UtilsKt.sendLocalBroadcastSync(context, intent);
            }
        }

        public final void setVisible(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_VISIBLE, z);
            UtilsKt.sendLocalBroadcast(context, intent);
        }

        public static /* synthetic */ void dismiss$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.dismiss(context, z);
        }

        /* renamed from: startService$lambda-0  reason: not valid java name */
        public static final void m91startService$lambda0(Context context) {
            Intrinsics.checkNotNullParameter(context, "$context");
            context.startForegroundService(new Intent(context, FloatViewService.class));
        }

        public final void invalidate(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_INVALIDATE, true);
            UtilsKt.sendLocalBroadcast(context, intent);
        }

        public final void setConfig(Config config) {
            FloatViewService.config = config;
        }

        public final void stopService$floating_view_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdVideoLog.d(FloatViewService.TAG, "stopService");
            context.stopService(new Intent(context, FloatViewService.class));
        }

        public final void startService(final Context context, Config cfg) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cfg, "cfg");
            setConfig(cfg);
            if (cfg.isForeground() && Build.VERSION.SDK_INT >= 26) {
                checkNotification(context, cfg);
                getInnerHandler().post(new Runnable() { // from class: com.baidu.tieba.lo1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            FloatViewService.Companion.m91startService$lambda0(context);
                        }
                    }
                });
                return;
            }
            context.startService(new Intent(context, FloatViewService.class));
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForegroundWithNotification();
        UtilsKt.registerLocalReceiver(this, this.receiver, new IntentFilter(FLOAT_ACTION));
        BdVideoLog.d(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        UtilsKt.unregisterLocalReceiver(this, this.receiver);
        ViewManager viewManager = this.viewManager;
        if (viewManager != null) {
            viewManager.release();
        }
        this.viewManager = null;
        config = null;
        BdVideoLog.d(TAG, MissionEvent.MESSAGE_DESTROY);
        super.onDestroy();
    }

    private final void startForegroundWithNotification() {
        Unit unit;
        Config config2 = config;
        if (config2 != null) {
            if (config2.isForeground()) {
                if (config2.getNotification() == null) {
                    Companion companion = Companion;
                    Context applicationContext = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    companion.checkNotification(applicationContext, config2);
                }
                startForeground(1, config2.getNotification());
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
            Notification defaultNotification$default = UtilsKt.getDefaultNotification$default(applicationContext2, 0, null, null, null, null, 62, null);
            if (defaultNotification$default != null) {
                startForeground(1, defaultNotification$default);
            }
        }
        BdVideoLog.d(TAG, "startForegroundWithNotification config=" + config);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        IFloating floatingContext;
        BdVideoLog.d(TAG, "onStartCommand config=" + config);
        startForegroundWithNotification();
        if (config == null) {
            return 2;
        }
        if (this.viewManager != null) {
            BdVideoLog.w(TAG, "该次添加悬浮窗覆盖了之前的悬浮窗");
            ViewManager viewManager = this.viewManager;
            if (viewManager != null) {
                viewManager.release();
            }
        }
        Config config2 = config;
        if (config2 != null && (floatingContext = config2.getFloatingContext()) != null) {
            floatingContext.onCreate();
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Config config3 = config;
        Intrinsics.checkNotNull(config3);
        ViewManager viewManager2 = new ViewManager(applicationContext, config3);
        viewManager2.createView();
        this.viewManager = viewManager2;
        return 2;
    }
}
