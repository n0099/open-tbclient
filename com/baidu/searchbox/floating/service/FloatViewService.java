package com.baidu.searchbox.floating.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.ViewManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import kotlin.e;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes15.dex */
public final class FloatViewService extends Service {
    public static final Companion Companion = new Companion(null);
    private static final String FLOAT_ACTION = "com.baidu.searchbox.floating.action.FLOATING";
    private static final String FLOAT_DISMISS = "float_dismiss";
    private static final String FLOAT_DISMISS_IMMEDIATELY = "float_dismiss_immediately";
    private static final String FLOAT_INVALIDATE = "float_invalidate";
    private static final String FLOAT_VISIBLE = "float_visible";
    private static final String TAG = "FloatViewService";
    @SuppressLint({"StaticFieldLeak"})
    private static Config config;
    private final FloatViewService$receiver$1 receiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.floating.service.FloatViewService$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ViewManager viewManager;
            ViewManager viewManager2;
            ViewManager viewManager3;
            ViewManager viewManager4;
            ViewManager viewManager5;
            ViewManager viewManager6;
            p.o(context, "context");
            p.o(intent, "intent");
            if (!(!p.l(intent.getAction(), "com.baidu.searchbox.floating.action.FLOATING"))) {
                viewManager = FloatViewService.this.viewManager;
                if (viewManager != null) {
                    if (intent.getBooleanExtra("float_dismiss", false)) {
                        if (intent.getBooleanExtra("float_dismiss_immediately", false)) {
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
                    } else if (intent.getBooleanExtra("float_invalidate", false)) {
                        viewManager4 = FloatViewService.this.viewManager;
                        if (viewManager4 != null) {
                            viewManager4.updateLayoutParams();
                        }
                    } else if (intent.getBooleanExtra("float_visible", true)) {
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
    private ViewManager viewManager;

    @e
    /* loaded from: classes15.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final Config getConfig() {
            return FloatViewService.config;
        }

        public final void setConfig(Config config) {
            FloatViewService.config = config;
        }

        public final void startService(Context context, Config config) {
            p.o(context, "context");
            p.o(config, "cfg");
            setConfig(config);
            context.startService(new Intent(context, FloatViewService.class));
        }

        public final void stopService$lib_player_floating_release(Context context) {
            p.o(context, "context");
            context.stopService(new Intent(context, FloatViewService.class));
        }

        public final void setVisible(Context context, boolean z) {
            p.o(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_VISIBLE, z);
            UtilsKt.sendLocalBroadcast(context, intent);
        }

        public final void invalidate(Context context) {
            p.o(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_INVALIDATE, true);
            UtilsKt.sendLocalBroadcast(context, intent);
        }

        public static /* synthetic */ void dismiss$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.dismiss(context, z);
        }

        public final void dismiss(Context context, boolean z) {
            p.o(context, "context");
            Intent intent = new Intent(FloatViewService.FLOAT_ACTION);
            intent.putExtra(FloatViewService.FLOAT_DISMISS, true);
            intent.putExtra(FloatViewService.FLOAT_DISMISS_IMMEDIATELY, z);
            UtilsKt.sendLocalBroadcast(context, intent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        UtilsKt.registerLocalReceiver(this, this.receiver, new IntentFilter(FLOAT_ACTION));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        IFloating floatingContext;
        if (Companion.getConfig() != null) {
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
            p.n(applicationContext, "applicationContext");
            Config config3 = Companion.getConfig();
            if (config3 == null) {
                p.eMi();
            }
            ViewManager viewManager2 = new ViewManager(applicationContext, config3);
            viewManager2.createView();
            this.viewManager = viewManager2;
            Config config4 = Companion.getConfig();
            if (config4 == null) {
                p.eMi();
            }
            if (config4.isForeground()) {
                Config config5 = Companion.getConfig();
                if (config5 == null) {
                    p.eMi();
                }
                startForeground(1, config5.getNotification());
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        UtilsKt.unregisterLocalReceiver(this, this.receiver);
        ViewManager viewManager = this.viewManager;
        if (viewManager != null) {
            viewManager.release();
        }
        this.viewManager = null;
        super.onDestroy();
    }
}
