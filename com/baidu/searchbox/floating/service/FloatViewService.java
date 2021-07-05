package com.baidu.searchbox.floating.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.ViewManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\tJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ)\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/floating/service/FloatViewService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", MissionEvent.MESSAGE_CREATE, "()V", MissionEvent.MESSAGE_DESTROY, "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "com/baidu/searchbox/floating/service/FloatViewService$receiver$1", SocialConstants.PARAM_RECEIVER, "Lcom/baidu/searchbox/floating/service/FloatViewService$receiver$1;", "Lcom/baidu/searchbox/floating/widget/ViewManager;", "viewManager", "Lcom/baidu/searchbox/floating/widget/ViewManager;", "<init>", "Companion", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FloatViewService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String FLOAT_ACTION = "com.baidu.searchbox.floating.action.FLOATING";
    public static final String FLOAT_DISMISS = "float_dismiss";
    public static final String FLOAT_DISMISS_IMMEDIATELY = "float_dismiss_immediately";
    public static final String FLOAT_INVALIDATE = "float_invalidate";
    public static final String FLOAT_VISIBLE = "float_visible";
    public static final String TAG = "FloatViewService";
    @SuppressLint({"StaticFieldLeak"})
    public static Config config;
    public transient /* synthetic */ FieldHolder $fh;
    public final FloatViewService$receiver$1 receiver;
    public ViewManager viewManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/floating/service/FloatViewService$Companion;", "Landroid/content/Context;", "context", "", "immediately", "", "dismiss", "(Landroid/content/Context;Z)V", "invalidate", "(Landroid/content/Context;)V", "visible", "setVisible", "Lcom/baidu/searchbox/floating/config/Config;", "cfg", "startService", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "stopService$lib_player_floating_release", "stopService", "", "FLOAT_ACTION", "Ljava/lang/String;", "FLOAT_DISMISS", "FLOAT_DISMISS_IMMEDIATELY", "FLOAT_INVALIDATE", "FLOAT_VISIBLE", "TAG", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "setConfig", "(Lcom/baidu/searchbox/floating/config/Config;)V", "<init>", "()V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static /* bridge */ /* synthetic */ void dismiss$default(Companion companion, Context context, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            companion.dismiss(context, z);
        }

        public final void dismiss(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
                Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
                intent.putExtra(FloatViewService.FLOAT_DISMISS, true);
                intent.putExtra(FloatViewService.FLOAT_DISMISS_IMMEDIATELY, z);
                UtilsKt.sendLocalBroadcast(context, intent);
            }
        }

        public final Config getConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? FloatViewService.config : (Config) invokeV.objValue;
        }

        public final void invalidate(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
                Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
                intent.putExtra(FloatViewService.FLOAT_INVALIDATE, true);
                UtilsKt.sendLocalBroadcast(context, intent);
            }
        }

        public final void setConfig(Config config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, config) == null) {
                FloatViewService.config = config;
            }
        }

        public final void setVisible(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
                Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
                intent.putExtra(FloatViewService.FLOAT_VISIBLE, z);
                UtilsKt.sendLocalBroadcast(context, intent);
            }
        }

        public final void startService(Context context, Config config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, config) == null) {
                setConfig(config);
                context.startService(new Intent(context, FloatViewService.class));
            }
        }

        public final void stopService$lib_player_floating_release(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
                context.stopService(new Intent(context, FloatViewService.class));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(164181278, "Lcom/baidu/searchbox/floating/service/FloatViewService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(164181278, "Lcom/baidu/searchbox/floating/service/FloatViewService;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.searchbox.floating.service.FloatViewService$receiver$1] */
    public FloatViewService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.receiver = new BroadcastReceiver(this) { // from class: com.baidu.searchbox.floating.service.FloatViewService$receiver$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FloatViewService this$0;

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ViewManager viewManager;
                ViewManager viewManager2;
                ViewManager viewManager3;
                ViewManager viewManager4;
                ViewManager viewManager5;
                ViewManager viewManager6;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) || (!Intrinsics.areEqual(intent.getAction(), FloatViewService.FLOAT_ACTION))) {
                    return;
                }
                viewManager = this.this$0.viewManager;
                if (viewManager == null) {
                    return;
                }
                if (intent.getBooleanExtra(FloatViewService.FLOAT_DISMISS, false)) {
                    if (intent.getBooleanExtra(FloatViewService.FLOAT_DISMISS_IMMEDIATELY, false)) {
                        viewManager6 = this.this$0.viewManager;
                        if (viewManager6 != null) {
                            viewManager6.destroy();
                            return;
                        }
                        return;
                    }
                    viewManager5 = this.this$0.viewManager;
                    if (viewManager5 != null) {
                        viewManager5.exitAnim();
                    }
                } else if (intent.getBooleanExtra(FloatViewService.FLOAT_INVALIDATE, false)) {
                    viewManager4 = this.this$0.viewManager;
                    if (viewManager4 != null) {
                        viewManager4.updateLayoutParams();
                    }
                } else if (intent.getBooleanExtra(FloatViewService.FLOAT_VISIBLE, true)) {
                    viewManager3 = this.this$0.viewManager;
                    if (viewManager3 != null) {
                        viewManager3.setVisible(0);
                    }
                } else {
                    viewManager2 = this.this$0.viewManager;
                    if (viewManager2 != null) {
                        viewManager2.setVisible(8);
                    }
                }
            }
        };
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            UtilsKt.registerLocalReceiver(this, this.receiver, new IntentFilter(FLOAT_ACTION));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            UtilsKt.unregisterLocalReceiver(this, this.receiver);
            ViewManager viewManager = this.viewManager;
            if (viewManager != null) {
                viewManager.release();
            }
            this.viewManager = null;
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        IFloating floatingContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (Companion.getConfig() == null) {
                return 2;
            }
            if (this.viewManager != null) {
                BdVideoLog.w(TAG, "该次添加悬浮窗覆盖了之前的悬浮窗");
                ViewManager viewManager = this.viewManager;
                if (viewManager != null) {
                    viewManager.release();
                }
            }
            Config config2 = Companion.getConfig();
            if (config2 != null && (floatingContext = config2.getFloatingContext()) != null) {
                floatingContext.onCreate();
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
            Config config3 = Companion.getConfig();
            if (config3 == null) {
                Intrinsics.throwNpe();
            }
            ViewManager viewManager2 = new ViewManager(applicationContext, config3);
            viewManager2.createView();
            this.viewManager = viewManager2;
            Config config4 = Companion.getConfig();
            if (config4 == null) {
                Intrinsics.throwNpe();
            }
            if (config4.isForeground()) {
                Config config5 = Companion.getConfig();
                if (config5 == null) {
                    Intrinsics.throwNpe();
                }
                startForeground(1, config5.getNotification());
            }
            return 2;
        }
        return invokeLII.intValue;
    }
}
