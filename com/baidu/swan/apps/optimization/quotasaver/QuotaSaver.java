package com.baidu.swan.apps.optimization.quotasaver;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.b;
import c.a.p0.a.d2.i;
import c.a.p0.a.d2.j;
import c.a.p0.a.f1.e.f.c;
import c.a.p0.a.y1.b.d;
import c.a.p0.a.z2.g1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b>\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u001e\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020$8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0017R\u001d\u0010.\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0017R\u001d\u00101\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0017R\u001d\u00104\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0017R\u001d\u00107\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0017R\u001d\u0010:\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0017R\u001d\u0010=\u001a\u00020$8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010'¨\u0006?"}, d2 = {"Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver;", "Lc/a/p0/a/z2/g1/c;", "Lcom/baidu/swan/apps/runtime/SwanEvent$Impl;", "msg", "", "handleKillMsgOnSwanProcess", "(Lcom/baidu/swan/apps/runtime/SwanEvent$Impl;)V", "killAllSwanProcess", "()V", "onCallback", "Lcom/baidu/swan/apps/runtime/SwanImpl;", "swanImpl", "regEventSubscriberOn", "(Lcom/baidu/swan/apps/runtime/SwanImpl;)V", "Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", "config$delegate", "Lkotlin/Lazy;", "getConfig", "()Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "", "enableSuspend$delegate", "getEnableSuspend", "()Z", "enableSuspend", "Lcom/baidu/swan/apps/runtime/EventSubscriber;", "kotlin.jvm.PlatformType", "eventSubscriber$delegate", "getEventSubscriber", "()Lcom/baidu/swan/apps/runtime/EventSubscriber;", "eventSubscriber", "Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "optSwitcher$delegate", "getOptSwitcher", "()Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "optSwitcher", "", "rescueRefractoryPeriod$delegate", "getRescueRefractoryPeriod", "()J", "rescueRefractoryPeriod", "shouldSuspendAll$delegate", "getShouldSuspendAll", "shouldSuspendAll", "shouldSuspendAnything$delegate", "getShouldSuspendAnything", "shouldSuspendAnything", "shouldSuspendMasterTimer$delegate", "getShouldSuspendMasterTimer", "shouldSuspendMasterTimer", "shouldSuspendSlaveTimer$delegate", "getShouldSuspendSlaveTimer", "shouldSuspendSlaveTimer", "shouldSuspendV8Timer$delegate", "getShouldSuspendV8Timer", "shouldSuspendV8Timer", "shouldSuspendWebViewTimer$delegate", "getShouldSuspendWebViewTimer", "shouldSuspendWebViewTimer", "suspendDelayTime$delegate", "getSuspendDelayTime", "suspendDelayTime", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class QuotaSaver implements c<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Lazy f39647e;

    /* renamed from: f  reason: collision with root package name */
    public static final Lazy f39648f;

    /* renamed from: g  reason: collision with root package name */
    public static final Lazy f39649g;

    /* renamed from: h  reason: collision with root package name */
    public static final Lazy f39650h;

    /* renamed from: i  reason: collision with root package name */
    public static final Lazy f39651i;

    /* renamed from: j  reason: collision with root package name */
    public static final Lazy f39652j;

    /* renamed from: k  reason: collision with root package name */
    public static final Lazy f39653k;
    public static final Lazy l;
    public static final Lazy m;
    public static final Lazy n;
    public static final Lazy o;
    public static final QuotaSaver p;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2079141631, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2079141631, "Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver;");
                return;
            }
        }
        p = new QuotaSaver();
        f39647e = LazyKt__LazyJVMKt.lazy(QuotaSaver$config$2.INSTANCE);
        LazyKt__LazyJVMKt.lazy(QuotaSaver$rescueRefractoryPeriod$2.INSTANCE);
        f39648f = LazyKt__LazyJVMKt.lazy(QuotaSaver$suspendDelayTime$2.INSTANCE);
        f39649g = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendAll$2.INSTANCE);
        f39650h = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendV8Timer$2.INSTANCE);
        f39651i = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendWebViewTimer$2.INSTANCE);
        f39652j = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendMasterTimer$2.INSTANCE);
        f39653k = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendSlaveTimer$2.INSTANCE);
        l = LazyKt__LazyJVMKt.lazy(QuotaSaver$shouldSuspendAnything$2.INSTANCE);
        m = LazyKt__LazyJVMKt.lazy(QuotaSaver$enableSuspend$2.INSTANCE);
        n = LazyKt__LazyJVMKt.lazy(QuotaSaver$optSwitcher$2.INSTANCE);
        o = LazyKt__LazyJVMKt.lazy(QuotaSaver$eventSubscriber$2.INSTANCE);
    }

    public QuotaSaver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (c.a) f39647e.getValue() : (c.a) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((Boolean) m.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (b) o.getValue() : (b) invokeV.objValue;
    }

    public final c.a.p0.a.g1.j.f.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (c.a.p0.a.g1.j.f.b) n.getValue() : (c.a.p0.a.g1.j.f.b) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((Boolean) f39649g.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ((Boolean) l.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ((Boolean) f39652j.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((Boolean) f39653k.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((Boolean) f39650h.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ((Boolean) f39651i.getValue()).booleanValue() : invokeV.booleanValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((Number) f39648f.getValue()).longValue() : invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (c.a.p0.a.z2.n0.F(true) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            boolean z = true;
            if (d.I(aVar.D(), "quota_saver_killing") && !ProcessUtils.isMainProcess()) {
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                Intrinsics.checkNotNullExpressionValue(current, "SwanAppProcessInfo.current()");
                if (current.isSwanAppProcess()) {
                }
            }
            z = false;
            i.a aVar2 = z ? aVar : null;
            if (aVar2 != null) {
                String n2 = aVar2.n("quota_saver_action");
                c.a.p0.a.e0.d.i("QuotaSaver", "handleKillMsgOnSwanProcess: on action=" + n2);
                if (n2 == null) {
                    return;
                }
                int hashCode = n2.hashCode();
                if (hashCode != -1120856297) {
                    if (hashCode == -527012810 && n2.equals("quota_saver_action_bye")) {
                        c.a.p0.a.e0.d.i("QuotaSaver", "handleKillMsgOnSwanProcess: kill do by bye");
                        c.a.p0.a.d2.d.J().F();
                    }
                } else if (n2.equals("quota_saver_action_will_done")) {
                    c.a.p0.a.e0.d.i("QuotaSaver", "handleKillMsgOnSwanProcess: callback bye by WILL_DONE");
                    c.a.p0.a.d2.d.J().o("flag_finish_activity", "flag_remove_task");
                    d.Y(aVar.D()).z("quota_saver_action", "quota_saver_action_bye").call();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.z2.g1.c
    /* renamed from: m */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        p.l(aVar);
    }

    public final void n(j swanImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanImpl) == null) {
            Intrinsics.checkNotNullParameter(swanImpl, "swanImpl");
            swanImpl.v(c());
        }
    }
}
