package com.baidu.swan.apps.alliance.login;

import android.os.Bundle;
import com.baidu.tieba.at1;
import com.baidu.tieba.bt1;
import com.baidu.tieba.c23;
import com.baidu.tieba.cm1;
import com.baidu.tieba.cr1;
import com.baidu.tieba.d52;
import com.baidu.tieba.dt1;
import com.baidu.tieba.em1;
import com.baidu.tieba.et1;
import com.baidu.tieba.ic3;
import com.baidu.tieba.o53;
import com.baidu.tieba.pv2;
import com.baidu.tieba.rc3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.wp2;
import com.baidu.tieba.xl4;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b)\u0010\bJ\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bR\u0019\u0010\u0015\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0011R#\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper;", "", "value", "ceresId", "", "allianceLoginStatisticEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "allianceLogout", "()V", "", "isAllianceLogin", "()Z", "isLogin", "isUseSapiLogin", "Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "login", "(Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;)V", "onLoginStatusChanged", "(Z)V", "readAllianceLoginStatus", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "callBacked", "Z", "getCallBacked", "setCallBacked", "loginResultCallback", "Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", "getLoginResultCallback", "()Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", "setLoginResultCallback", "", "Lcom/baidu/swan/apps/account/SwanAppAccountStatusChangedListener;", "loginStatusChangeCallbacks$delegate", "Lkotlin/Lazy;", "getLoginStatusChangeCallbacks", "()Ljava/util/List;", "loginStatusChangeCallbacks", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class SwanAppAllianceLoginHelper {
    public static cm1 a;
    public static final Lazy b;
    public static boolean c;
    public static final SwanAppAllianceLoginHelper d;

    public final List<em1> e() {
        return (List) b.getValue();
    }

    static {
        SwanAppAllianceLoginHelper swanAppAllianceLoginHelper = new SwanAppAllianceLoginHelper();
        d = swanAppAllianceLoginHelper;
        Intrinsics.checkNotNullExpressionValue(swanAppAllianceLoginHelper.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
        b = LazyKt__LazyJVMKt.lazy(new Function0<List<em1>>() { // from class: com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final List<em1> invoke() {
                return new ArrayList();
            }
        });
    }

    public final void b() {
        bt1.a.b();
        et1.b.d();
        j(false);
    }

    public final boolean c() {
        return c;
    }

    public final cm1 d() {
        return a;
    }

    public final boolean f() {
        if (dt1.i() == null) {
            k();
        }
        Boolean i = dt1.i();
        Intrinsics.checkNotNull(i);
        return i.booleanValue();
    }

    public final boolean h() {
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void k() {
        Boolean bool;
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            bool = Boolean.FALSE;
        } catch (ClassNotFoundException unused) {
            bool = Boolean.TRUE;
        }
        dt1.j(bool);
    }

    public final void a(String value, String ceresId) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(ceresId, "ceresId");
        rc3 rc3Var = new rc3();
        rc3Var.b = dt1.h();
        rc3Var.e = value;
        o53 K = o53.K();
        Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
        rc3Var.a("appkey", K.getAppId());
        ic3.y(dt1.g(), ceresId, rc3Var);
    }

    public final boolean g() {
        boolean z;
        boolean z2;
        if (dt1.i() == null) {
            k();
        }
        if (!Intrinsics.areEqual(dt1.i(), Boolean.FALSE)) {
            String a2 = bt1.a.a();
            if (a2 != null && !StringsKt__StringsJVMKt.isBlank(a2)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String a3 = et1.b.a();
                if (a3 != null && !StringsKt__StringsJVMKt.isBlank(a3)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(cm1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (dt1.i() == null) {
            k();
        }
        Intrinsics.areEqual(dt1.i(), Boolean.FALSE);
        if (g()) {
            listener.onResult(0);
            return;
        }
        cr1 n = wo2.n();
        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
        String a2 = xl4.a("https://ossapi.baidu.com/oss/static/open_source_login_v3.html", "hostName", n.a());
        wp2 G0 = wo2.G0();
        Intrinsics.checkNotNull(G0);
        String a3 = xl4.a(a2, "zid", G0.a(wo2.c()));
        cr1 n2 = wo2.n();
        Intrinsics.checkNotNullExpressionValue(n2, "SwanAppRuntime.getConfig()");
        String a4 = xl4.a(a3, "appKey", n2.b());
        d52.k3("allianceLogin", pv2.d(a4, a4));
        a = listener;
        c = false;
        a(dt1.e(), dt1.b());
    }

    public final void j(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        c23.b(at1.class, bundle);
    }

    public final void l(boolean z) {
        c = z;
    }
}
