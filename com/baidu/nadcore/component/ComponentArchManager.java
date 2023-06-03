package com.baidu.nadcore.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.nadcore.component.api.IComponentPlugin;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ik0;
import com.baidu.tieba.jk0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bE\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\t\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"¢\u0006\u0004\b#\u0010$J)\u0010)\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010&*\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0017¢\u0006\u0004\b,\u0010\u0004J\u001f\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u001e¢\u0006\u0004\b.\u0010/J%\u00101\u001a\u00020\u00022\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0'2\u0006\u00100\u001a\u00020%¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u0004\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0'¢\u0006\u0004\b3\u0010*J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u0010\u0004J\u0015\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b5\u0010\fR\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0019\u00109\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010>\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR*\u0010C\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020%0'\u0012\u0004\u0012\u00020%0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/baidu/nadcore/component/ComponentArchManager;", "Landroidx/lifecycle/LifecycleObserver;", "", "bindLifecycle", "()V", "Landroid/view/ViewGroup;", "parentView", "createView", "(Landroid/view/ViewGroup;)V", "dispatchAttachToManager", "Lcom/baidu/nadcore/component/api/IComponentPlugin;", "componentPlugin", "(Lcom/baidu/nadcore/component/api/IComponentPlugin;)V", "Landroid/content/res/Configuration;", "newConfig", "dispatchConfigurationChanged", "(Landroid/content/res/Configuration;)V", "dispatchDetachFromManager", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "event", "dispatchEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "dispatchInit", "Landroid/content/Intent;", "intent", "dispatchIntent", "(Landroid/content/Intent;)V", "", "keyCode", "Landroid/view/KeyEvent;", "", "dispatchKeyDown", "(ILandroid/view/KeyEvent;)Z", "dispatchRelease", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getComponents", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/nadcore/component/api/IComponentService;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getService", "(Ljava/lang/Class;)Lcom/baidu/nadcore/component/api/IComponentService;", "initInternal", MissionEvent.MESSAGE_DESTROY, "component", "registerComponent", "(Lcom/baidu/nadcore/component/api/IComponentPlugin;Z)V", "componentService", "registerServices", "(Ljava/lang/Class;Lcom/baidu/nadcore/component/api/IComponentService;)V", "unRegisterServices", "unbindLifecycle", "unregisterComponent", "components", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Landroidx/collection/SimpleArrayMap;", "services", "Landroidx/collection/SimpleArrayMap;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "nadcore-lib-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class ComponentArchManager implements LifecycleObserver {
    public final CopyOnWriteArrayList<IComponentPlugin> a;
    public final SimpleArrayMap<Class<? extends jk0>, jk0> b;
    public final Context c;
    public final Lifecycle d;

    public ComponentArchManager(Context context, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.c = context;
        this.d = lifecycle;
        this.a = new CopyOnWriteArrayList<>();
        this.b = new SimpleArrayMap<>();
    }

    public final boolean m(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<IComponentPlugin> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().onKeyDown(i, event)) {
                return true;
            }
        }
        return false;
    }

    public final void r(IComponentPlugin component, boolean z) {
        Intrinsics.checkNotNullParameter(component, "component");
        j(component);
        d(component);
        if (z) {
            this.d.addObserver(component);
        }
        this.a.add(component);
    }

    public final void t(Class<? extends jk0> clazz, jk0 componentService) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(componentService, "componentService");
        this.b.put(clazz, componentService);
    }

    public static /* synthetic */ void s(ComponentArchManager componentArchManager, IComponentPlugin iComponentPlugin, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            componentArchManager.r(iComponentPlugin, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerComponent");
    }

    public void b(ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        for (IComponentPlugin iComponentPlugin : this.a) {
            iComponentPlugin.P(parentView);
        }
    }

    public final void d(IComponentPlugin iComponentPlugin) {
        Context context = this.c;
        if (context != null) {
            iComponentPlugin.y((Activity) context);
            iComponentPlugin.injectContext(this.c);
            iComponentPlugin.B(this);
            iComponentPlugin.A();
            iComponentPlugin.F();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void f(IComponentPlugin iComponentPlugin) {
        this.d.removeObserver(iComponentPlugin);
        iComponentPlugin.o();
    }

    public final void g(ik0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        for (IComponentPlugin iComponentPlugin : this.a) {
            iComponentPlugin.w(event);
        }
    }

    public final void j(IComponentPlugin iComponentPlugin) {
        iComponentPlugin.onInit();
    }

    public final void l(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        for (IComponentPlugin iComponentPlugin : this.a) {
            iComponentPlugin.onNewIntent(intent);
        }
    }

    public <T extends jk0> T q(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        jk0 jk0Var = this.b.get(clazz);
        if (!(jk0Var instanceof jk0)) {
            jk0Var = null;
        }
        return (T) jk0Var;
    }

    public final void v(IComponentPlugin componentPlugin) {
        Intrinsics.checkNotNullParameter(componentPlugin, "componentPlugin");
        f(componentPlugin);
        this.a.remove(componentPlugin);
    }

    public final Context getContext() {
        return this.c;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        p();
        u();
        this.b.clear();
        this.a.clear();
    }

    public final void p() {
        for (IComponentPlugin iComponentPlugin : this.a) {
            iComponentPlugin.onRelease();
        }
    }

    public final void u() {
        Lifecycle lifecycle = this.d;
        for (IComponentPlugin iComponentPlugin : this.a) {
            lifecycle.removeObserver(iComponentPlugin);
        }
    }
}
