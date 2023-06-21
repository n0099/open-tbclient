package com.baidu.swan.apps.optimization.quotasaver;

import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$optSwitcher$2;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.cx2;
import com.baidu.tieba.dc3;
import com.baidu.tieba.ec3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.l83;
import com.baidu.tieba.sq3;
import com.baidu.tieba.wb3;
import com.baidu.tieba.wx2;
import com.baidu.tieba.yb3;
import com.baidu.tieba.z82;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b>\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u001e\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020$8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0017R\u001d\u0010.\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0017R\u001d\u00101\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0017R\u001d\u00104\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0017R\u001d\u00107\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0017R\u001d\u0010:\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0017R\u001d\u0010=\u001a\u00020$8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010'¨\u0006?"}, d2 = {"Lcom/baidu/swan/apps/optimization/quotasaver/QuotaSaver;", "Lcom/baidu/tieba/sq3;", "Lcom/baidu/swan/apps/runtime/SwanEvent$Impl;", "msg", "", "handleKillMsgOnSwanProcess", "(Lcom/baidu/swan/apps/runtime/SwanEvent$Impl;)V", "killAllSwanProcess", "()V", "onCallback", "Lcom/baidu/swan/apps/runtime/SwanImpl;", "swanImpl", "regEventSubscriberOn", "(Lcom/baidu/swan/apps/runtime/SwanImpl;)V", "Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", "config$delegate", "Lkotlin/Lazy;", "getConfig", "()Lcom/baidu/swan/apps/launch/model/property/Properties$Impl;", "config", "", "enableSuspend$delegate", "getEnableSuspend", "()Z", "enableSuspend", "Lcom/baidu/swan/apps/runtime/EventSubscriber;", "kotlin.jvm.PlatformType", "eventSubscriber$delegate", "getEventSubscriber", "()Lcom/baidu/swan/apps/runtime/EventSubscriber;", "eventSubscriber", "Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "optSwitcher$delegate", "getOptSwitcher", "()Lcom/baidu/swan/apps/lifecycle/backstage/switcher/IOptSwitcher;", "optSwitcher", "", "rescueRefractoryPeriod$delegate", "getRescueRefractoryPeriod", "()J", "rescueRefractoryPeriod", "shouldSuspendAll$delegate", "getShouldSuspendAll", "shouldSuspendAll", "shouldSuspendAnything$delegate", "getShouldSuspendAnything", "shouldSuspendAnything", "shouldSuspendMasterTimer$delegate", "getShouldSuspendMasterTimer", "shouldSuspendMasterTimer", "shouldSuspendSlaveTimer$delegate", "getShouldSuspendSlaveTimer", "shouldSuspendSlaveTimer", "shouldSuspendV8Timer$delegate", "getShouldSuspendV8Timer", "shouldSuspendV8Timer", "shouldSuspendWebViewTimer$delegate", "getShouldSuspendWebViewTimer", "shouldSuspendWebViewTimer", "suspendDelayTime$delegate", "getSuspendDelayTime", "suspendDelayTime", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class QuotaSaver implements sq3<dc3.a> {
    public static final Lazy b;
    public static final Lazy c;
    public static final Lazy d;
    public static final Lazy e;
    public static final Lazy f;
    public static final Lazy g;
    public static final Lazy h;
    public static final Lazy i;
    public static final Lazy j;
    public static final Lazy k;
    public static final QuotaSaver l = new QuotaSaver();
    public static final Lazy a = LazyKt__LazyJVMKt.lazy(new Function0<cx2.a>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$config$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final cx2.a invoke() {
            cx2.a aVar = new cx2.a();
            gv2.H0().a(aVar);
            return new cx2.a(aVar.D());
        }
    });

    public final cx2.a b() {
        return (cx2.a) a.getValue();
    }

    public final boolean c() {
        return ((Boolean) i.getValue()).booleanValue();
    }

    public final wb3 d() {
        return (wb3) k.getValue();
    }

    public final wx2 e() {
        return (wx2) j.getValue();
    }

    public final boolean f() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) h.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) g.getValue()).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public final long l() {
        return ((Number) b.getValue()).longValue();
    }

    static {
        LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$rescueRefractoryPeriod$2
            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return QuotaSaver.l.b().l("rescue_refractory_period", 0L);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }
        });
        b = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$suspendDelayTime$2
            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return QuotaSaver.l.b().l("suspend_delay_time", -1L);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }
        });
        c = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendAll$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return QuotaSaver.l.b().d("should_suspend_all", false);
            }
        });
        d = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendV8Timer$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (!QuotaSaver.l.f() && !QuotaSaver.l.b().d("should_suspend_v8_timer", false)) {
                    return false;
                }
                return true;
            }
        });
        e = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendWebViewTimer$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (!QuotaSaver.l.f() && !QuotaSaver.l.b().d("should_suspend_web_view_timer", false)) {
                    return false;
                }
                return true;
            }
        });
        f = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendMasterTimer$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (!QuotaSaver.l.f() && !QuotaSaver.l.b().d("should_suspend_master_timer", false)) {
                    return false;
                }
                return true;
            }
        });
        g = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendSlaveTimer$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (!QuotaSaver.l.f() && !QuotaSaver.l.b().d("should_suspend_slave_timer", false)) {
                    return false;
                }
                return true;
            }
        });
        h = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$shouldSuspendAnything$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (!QuotaSaver.l.f() && !QuotaSaver.l.j() && !QuotaSaver.l.k() && !QuotaSaver.l.h() && !QuotaSaver.l.i()) {
                    return false;
                }
                return true;
            }
        });
        i = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$enableSuspend$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                if (QuotaSaver.l.l() >= 0 && QuotaSaver.l.g()) {
                    return true;
                }
                return false;
            }
        });
        j = LazyKt__LazyJVMKt.lazy(new Function0<QuotaSaver$optSwitcher$2.a>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$optSwitcher$2

            /* loaded from: classes4.dex */
            public static final class a implements wx2 {
                @Override // com.baidu.tieba.wx2
                public int a() {
                    if (QuotaSaver.l.l() > 0) {
                        return (int) TimeUnit.MILLISECONDS.toSeconds(QuotaSaver.l.l());
                    }
                    return -1;
                }

                @Override // com.baidu.tieba.wx2
                public boolean b() {
                    if (QuotaSaver.l.c() && QuotaSaver.l.h() && QuotaSaver.l.k()) {
                        return true;
                    }
                    return false;
                }

                @Override // com.baidu.tieba.wx2
                public boolean c() {
                    if (QuotaSaver.l.c() && QuotaSaver.l.i()) {
                        return true;
                    }
                    return false;
                }

                @Override // com.baidu.tieba.wx2
                public boolean d() {
                    if (QuotaSaver.l.c() && QuotaSaver.l.j()) {
                        return true;
                    }
                    return false;
                }

                @Override // com.baidu.tieba.wx2
                public boolean e() {
                    if (QuotaSaver.l.c() && QuotaSaver.l.k()) {
                        return true;
                    }
                    return false;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        k = LazyKt__LazyJVMKt.lazy(new Function0<wb3>() { // from class: com.baidu.swan.apps.optimization.quotasaver.QuotaSaver$eventSubscriber$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final wb3 invoke() {
                wb3 wb3Var = new wb3();
                wb3Var.f(QuotaSaver.l, "event_messenger_call");
                return wb3Var;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sq3
    /* renamed from: n */
    public void a(dc3.a aVar) {
        if (aVar != null) {
            l.m(aVar);
        }
    }

    public final void o(ec3 swanImpl) {
        Intrinsics.checkNotNullParameter(swanImpl, "swanImpl");
        swanImpl.u(d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (com.baidu.tieba.qp3.E(true) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(dc3.a aVar) {
        dc3.a aVar2;
        boolean z = true;
        if (l83.J(aVar.D(), "quota_saver_killing") && !ProcessUtils.isMainProcess()) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Intrinsics.checkNotNullExpressionValue(current, "SwanAppProcessInfo.current()");
            if (current.isSwanAppProcess()) {
            }
        }
        z = false;
        if (z) {
            aVar2 = aVar;
        } else {
            aVar2 = null;
        }
        if (aVar2 != null) {
            String n = aVar2.n("quota_saver_action");
            z82.i("QuotaSaver", "handleKillMsgOnSwanProcess: on action=" + n);
            if (n != null) {
                int hashCode = n.hashCode();
                if (hashCode != -1120856297) {
                    if (hashCode == -527012810 && n.equals("quota_saver_action_bye")) {
                        z82.i("QuotaSaver", "handleKillMsgOnSwanProcess: kill do by bye");
                        yb3.K().G();
                    }
                } else if (n.equals("quota_saver_action_will_done")) {
                    z82.i("QuotaSaver", "handleKillMsgOnSwanProcess: callback bye by WILL_DONE");
                    yb3.K().n("flag_finish_activity", "flag_remove_task");
                    l83.Z(aVar.D()).z("quota_saver_action", "quota_saver_action_bye").call();
                }
            }
        }
    }
}
