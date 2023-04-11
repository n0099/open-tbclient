package com.baidu.searchbox.live.list.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.live.mix.interfaces.MixLiveSingletonManagerInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.interfaces.context.PluginContextUtil;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/list/plugin/YYActivityLifeCyclePlugin;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "onStart", MissionEvent.MESSAGE_STOP, "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "mixLiveImpl", "Lcom/baidu/live/mix/interfaces/MixLiveSingletonManagerInterface;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "<init>", "(Landroid/content/Context;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYActivityLifeCyclePlugin implements LifecycleObserver {
    public final Context context;
    public MixLiveSingletonManagerInterface mixLiveImpl;
    public final PluginInvokeService pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());

    public YYActivityLifeCyclePlugin(Context context) {
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Object obj;
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityCreate " + this.context.hashCode());
        try {
            PluginInvokeService pluginInvokeService = this.pluginInvokeService;
            Object obj2 = null;
            if (pluginInvokeService != null) {
                obj = pluginInvokeService.createYYMixLiveSingletonManagerImpl();
            } else {
                obj = null;
            }
            if (obj instanceof MixLiveSingletonManagerInterface) {
                obj2 = obj;
            }
            this.mixLiveImpl = (MixLiveSingletonManagerInterface) obj2;
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityCreate(activity);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th2);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityDestroy " + this.context.hashCode());
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityDestroy(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityPause " + this.context.hashCode());
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityPause(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityResume " + this.context.hashCode());
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityResume(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityStart " + this.context.hashCode());
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityStart(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "onActivityStop " + this.context.hashCode());
        try {
            MixLiveSingletonManagerInterface mixLiveSingletonManagerInterface = this.mixLiveImpl;
            if (mixLiveSingletonManagerInterface != null) {
                Activity activity = PluginContextUtil.INSTANCE.getActivity(this.context);
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                mixLiveSingletonManagerInterface.onActivityStop(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ListLogKt.log(MixTagConstants.MIX_YY_LIVE, "crash throwable th" + th);
        }
    }
}
