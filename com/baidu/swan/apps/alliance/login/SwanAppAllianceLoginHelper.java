package com.baidu.swan.apps.alliance.login;

import android.os.Bundle;
import com.baidu.tieba.dd3;
import com.baidu.tieba.j63;
import com.baidu.tieba.kw2;
import com.baidu.tieba.md3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.rq2;
import com.baidu.tieba.sm4;
import com.baidu.tieba.vt1;
import com.baidu.tieba.wt1;
import com.baidu.tieba.x23;
import com.baidu.tieba.xm1;
import com.baidu.tieba.xr1;
import com.baidu.tieba.y52;
import com.baidu.tieba.yt1;
import com.baidu.tieba.zm1;
import com.baidu.tieba.zt1;
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
    public static xm1 a;
    public static final Lazy b;
    public static boolean c;
    public static final SwanAppAllianceLoginHelper d;

    public final List<zm1> e() {
        return (List) b.getValue();
    }

    static {
        SwanAppAllianceLoginHelper swanAppAllianceLoginHelper = new SwanAppAllianceLoginHelper();
        d = swanAppAllianceLoginHelper;
        Intrinsics.checkNotNullExpressionValue(swanAppAllianceLoginHelper.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
        b = LazyKt__LazyJVMKt.lazy(new Function0<List<zm1>>() { // from class: com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final List<zm1> invoke() {
                return new ArrayList();
            }
        });
    }

    public final void b() {
        wt1.a.b();
        zt1.b.d();
        j(false);
    }

    public final boolean c() {
        return c;
    }

    public final xm1 d() {
        return a;
    }

    public final boolean f() {
        if (yt1.i() == null) {
            k();
        }
        Boolean i = yt1.i();
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
        yt1.j(bool);
    }

    public final void a(String value, String ceresId) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(ceresId, "ceresId");
        md3 md3Var = new md3();
        md3Var.b = yt1.h();
        md3Var.e = value;
        j63 K = j63.K();
        Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
        md3Var.a("appkey", K.getAppId());
        dd3.y(yt1.g(), ceresId, md3Var);
    }

    public final boolean g() {
        boolean z;
        boolean z2;
        if (yt1.i() == null) {
            k();
        }
        if (!Intrinsics.areEqual(yt1.i(), Boolean.FALSE)) {
            String a2 = wt1.a.a();
            if (a2 != null && !StringsKt__StringsJVMKt.isBlank(a2)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String a3 = zt1.b.a();
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

    public final void i(xm1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (yt1.i() == null) {
            k();
        }
        Intrinsics.areEqual(yt1.i(), Boolean.FALSE);
        if (g()) {
            listener.onResult(0);
            return;
        }
        xr1 n = rp2.n();
        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
        String a2 = sm4.a("https://ossapi.baidu.com/oss/static/open_source_login_v3.html", "hostName", n.a());
        rq2 G0 = rp2.G0();
        Intrinsics.checkNotNull(G0);
        String a3 = sm4.a(a2, "zid", G0.a(rp2.c()));
        xr1 n2 = rp2.n();
        Intrinsics.checkNotNullExpressionValue(n2, "SwanAppRuntime.getConfig()");
        String a4 = sm4.a(a3, "appKey", n2.b());
        y52.k3("allianceLogin", kw2.d(a4, a4));
        a = listener;
        c = false;
        a(yt1.e(), yt1.b());
    }

    public final void j(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        x23.b(vt1.class, bundle);
    }

    public final void l(boolean z) {
        c = z;
    }
}
