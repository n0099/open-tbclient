package com.baidu.nadcore.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.d0.g.a.a;
import c.a.d0.g.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.api.IComponentPlugin;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bE\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\t\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"¢\u0006\u0004\b#\u0010$J)\u0010)\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010&*\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0017¢\u0006\u0004\b,\u0010\u0004J\u001f\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u001e¢\u0006\u0004\b.\u0010/J%\u00101\u001a\u00020\u00022\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0'2\u0006\u00100\u001a\u00020%¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u0004\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0'¢\u0006\u0004\b3\u0010*J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u0010\u0004J\u0015\u00105\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b5\u0010\fR\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0019\u00109\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010>\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR*\u0010C\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020%0'\u0012\u0004\u0012\u00020%0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/baidu/nadcore/component/ComponentArchManager;", "Landroidx/lifecycle/LifecycleObserver;", "", "bindLifecycle", "()V", "Landroid/view/ViewGroup;", "parentView", "createView", "(Landroid/view/ViewGroup;)V", "dispatchAttachToManager", "Lcom/baidu/nadcore/component/api/IComponentPlugin;", "componentPlugin", "(Lcom/baidu/nadcore/component/api/IComponentPlugin;)V", "Landroid/content/res/Configuration;", "newConfig", "dispatchConfigurationChanged", "(Landroid/content/res/Configuration;)V", "dispatchDetachFromManager", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "event", "dispatchEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "dispatchInit", "Landroid/content/Intent;", "intent", "dispatchIntent", "(Landroid/content/Intent;)V", "", "keyCode", "Landroid/view/KeyEvent;", "", "dispatchKeyDown", "(ILandroid/view/KeyEvent;)Z", "dispatchRelease", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getComponents", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/nadcore/component/api/IComponentService;", "T", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getService", "(Ljava/lang/Class;)Lcom/baidu/nadcore/component/api/IComponentService;", "initInternal", MissionEvent.MESSAGE_DESTROY, "component", "registerComponent", "(Lcom/baidu/nadcore/component/api/IComponentPlugin;Z)V", "componentService", "registerServices", "(Ljava/lang/Class;Lcom/baidu/nadcore/component/api/IComponentService;)V", "unRegisterServices", "unbindLifecycle", "unregisterComponent", "components", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Landroidx/collection/SimpleArrayMap;", "services", "Landroidx/collection/SimpleArrayMap;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "lib-core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class ComponentArchManager implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArrayList<IComponentPlugin> f37210e;

    /* renamed from: f  reason: collision with root package name */
    public final SimpleArrayMap<Class<? extends b>, b> f37211f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f37212g;

    /* renamed from: h  reason: collision with root package name */
    public final Lifecycle f37213h;

    public ComponentArchManager(Context context, Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lifecycle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.f37212g = context;
        this.f37213h = lifecycle;
        this.f37210e = new CopyOnWriteArrayList<>();
        this.f37211f = new SimpleArrayMap<>();
    }

    public static /* synthetic */ void registerComponent$default(ComponentArchManager componentArchManager, IComponentPlugin iComponentPlugin, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            componentArchManager.registerComponent(iComponentPlugin, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerComponent");
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Lifecycle lifecycle = this.f37213h;
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                lifecycle.addObserver(iComponentPlugin);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (IComponentPlugin uiComponent : this.f37210e) {
                Intrinsics.checkNotNullExpressionValue(uiComponent, "uiComponent");
                c(uiComponent);
            }
        }
    }

    public final void c(IComponentPlugin iComponentPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iComponentPlugin) == null) {
            Context context = this.f37212g;
            if (context != null) {
                iComponentPlugin.injectActivity((Activity) context);
                iComponentPlugin.injectContext(this.f37212g);
                iComponentPlugin.injectManager(this);
                iComponentPlugin.injectService();
                iComponentPlugin.onAttachToManager();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public void createView(ViewGroup parentView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, parentView) == null) {
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                iComponentPlugin.onCreateView(parentView);
            }
        }
    }

    public final void d(IComponentPlugin iComponentPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iComponentPlugin) == null) {
            this.f37213h.removeObserver(iComponentPlugin);
            iComponentPlugin.onDetachFromManager();
        }
    }

    public final void dispatchConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                iComponentPlugin.onConfigurationChanged(newConfig);
            }
        }
    }

    public final void dispatchEvent(a event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                iComponentPlugin.receiveEvent(event);
            }
        }
    }

    public final void dispatchIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                iComponentPlugin.onNewIntent(intent);
            }
        }
    }

    public final boolean dispatchKeyDown(int i2, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Iterator<IComponentPlugin> it = this.f37210e.iterator();
            while (it.hasNext()) {
                if (it.next().onKeyDown(i2, event)) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void e(IComponentPlugin iComponentPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iComponentPlugin) == null) {
            iComponentPlugin.onInit();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                iComponentPlugin.onRelease();
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Lifecycle lifecycle = this.f37213h;
            for (IComponentPlugin iComponentPlugin : this.f37210e) {
                lifecycle.removeObserver(iComponentPlugin);
            }
        }
    }

    public final CopyOnWriteArrayList<IComponentPlugin> getComponents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37210e : (CopyOnWriteArrayList) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f37212g : (Context) invokeV.objValue;
    }

    public final Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37213h : (Lifecycle) invokeV.objValue;
    }

    public <T extends b> T getService(Class<T> clazz) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            b bVar = this.f37211f.get(clazz);
            if (!(bVar instanceof b)) {
                bVar = null;
            }
            return (T) bVar;
        }
        return (T) invokeL.objValue;
    }

    public void initInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b();
            a();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            f();
            g();
            this.f37211f.clear();
            this.f37210e.clear();
        }
    }

    public final void registerComponent(IComponentPlugin component, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, component, z) == null) {
            Intrinsics.checkNotNullParameter(component, "component");
            e(component);
            c(component);
            if (z) {
                this.f37213h.addObserver(component);
            }
            this.f37210e.add(component);
        }
    }

    public final void registerServices(Class<? extends b> clazz, b componentService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, clazz, componentService) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(componentService, "componentService");
            this.f37211f.put(clazz, componentService);
        }
    }

    public final b unRegisterServices(Class<? extends b> clazz) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return this.f37211f.remove(clazz);
        }
        return (b) invokeL.objValue;
    }

    public final void unregisterComponent(IComponentPlugin componentPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, componentPlugin) == null) {
            Intrinsics.checkNotNullParameter(componentPlugin, "componentPlugin");
            d(componentPlugin);
            this.f37210e.remove(componentPlugin);
        }
    }
}
