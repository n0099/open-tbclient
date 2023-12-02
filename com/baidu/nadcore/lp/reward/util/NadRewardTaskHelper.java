package com.baidu.nadcore.lp.reward.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.aj0;
import com.baidu.tieba.cn0;
import com.baidu.tieba.do0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.hd0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.il0;
import com.baidu.tieba.in0;
import com.baidu.tieba.io0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ve0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xm0;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000B\u0007¢\u0006\u0004\b5\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u000bJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\"R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010&R\u0016\u0010.\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010(R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010(R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010(R\u0018\u00103\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/baidu/nadcore/lp/reward/util/NadRewardTaskHelper;", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "response", "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;", "downloadStatus", "", "ext", "", "activateDownloadTask", "(Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;Lcom/baidu/nadcore/download/consts/AdDownloadStatus;Ljava/lang/String;)V", "activateInvokeTask", "()V", "checkDownloadTaskComplete", "checkInvokeTaskComplete", "Landroid/content/Context;", "context", "", "isAppInstalled", "(Landroid/content/Context;)Z", "scheme", "(Ljava/lang/String;Landroid/content/Context;)Z", "isDownloadAvailable", "isDownloadTaskActivated", "()Z", "isInvokeAvailable", "postDownloadTaskEvent", "postInvokeTaskEvent", "registerBackForegroundEvent", "removeTask", "resetRewardTaskStatus", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/content/Context;", "Ljava/lang/Runnable;", "downloadTask", "Ljava/lang/Runnable;", "downloadTaskActivated", "Z", "downloadTaskComplete", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "invokeActiveTask", "invokeTask", "invokeTaskActivated", "invokeTaskComplete", "receivedDownloadReward", "receivedInvokeReward", "taskRewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardTaskHelper {
    public Context a;
    public Handler b;
    public in0 c;
    public qk0 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Runnable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            fo0 j;
            in0 in0Var = NadRewardTaskHelper.this.c;
            if (in0Var != null && (j = in0Var.j()) != null && j.a()) {
                return;
            }
            NadRewardTaskHelper.this.i = true;
            NadRewardTaskHelper.this.D();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardTaskHelper.this.f = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardTaskHelper.this.j = true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends xi0<aj0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(aj0 event) {
            in0 in0Var;
            sn0 c;
            Long p;
            cn0 cn0Var;
            in0 in0Var2;
            sn0 c2;
            Long g;
            Intrinsics.checkNotNullParameter(event, "event");
            String str = null;
            if (event.a) {
                NadRewardTaskHelper.this.b.removeCallbacksAndMessages(null);
                NadRewardTaskHelper.this.v();
                NadRewardTaskHelper.this.w();
                return;
            }
            if (!NadRewardTaskHelper.this.g && NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f) {
                NadRewardTaskHelper nadRewardTaskHelper = NadRewardTaskHelper.this;
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (in0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = in0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                in0 in0Var3 = nadRewardTaskHelper2.c;
                if (in0Var3 != null && (cn0Var = in0Var3.f) != null) {
                    str = cn0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (in0Var = NadRewardTaskHelper.this.c) != null && (c = in0Var.c()) != null && (p = c.p()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, p.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = hf0.b();
        Intrinsics.checkNotNullExpressionValue(b2, "AdRuntime.applicationContext()");
        this.a = b2;
        this.b = new Handler(this.a.getMainLooper());
        this.h = new b();
        this.l = new c();
    }

    public final boolean A() {
        if (this.e && !this.f) {
            return true;
        }
        return false;
    }

    public final void E() {
        ti0.a().c(this, new d(aj0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        ti0.a().a(this);
    }

    public final void G() {
        this.e = false;
        this.f = false;
        this.g = false;
        this.d = null;
        this.i = false;
        this.j = false;
        this.k = false;
        this.b.removeCallbacksAndMessages(null);
    }

    public final void u() {
        sn0 c2;
        Long p;
        if (!B()) {
            return;
        }
        this.m = new a();
        in0 in0Var = this.c;
        if (in0Var != null && (c2 = in0Var.c()) != null && (p = c2.p()) != null) {
            long longValue = p.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(in0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        io0 io0Var;
        do0 h;
        do0 h2;
        sn0 c2;
        cn0 cn0Var;
        cn0 cn0Var2;
        do0 h3;
        io0 q;
        in0 in0Var = this.c;
        if (in0Var != null && (h3 = in0Var.h()) != null && (q = h3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        tn0 tn0Var = null;
        r2 = null;
        String str2 = null;
        tn0Var = null;
        if (i <= 0) {
            in0 in0Var2 = this.c;
            if (in0Var2 != null && (cn0Var2 = in0Var2.f) != null) {
                str2 = cn0Var2.d;
            }
            ll0.e(str2, "18", "18002");
            return false;
        }
        in0 in0Var3 = this.c;
        if (in0Var3 != null && (cn0Var = in0Var3.f) != null) {
            str = cn0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        in0 in0Var4 = this.c;
        if (in0Var4 != null && (c2 = in0Var4.c()) != null && c2.q() == 0) {
            return false;
        }
        in0 in0Var5 = this.c;
        if (in0Var5 != null && (h2 = in0Var5.h()) != null) {
            io0Var = h2.q();
        } else {
            io0Var = null;
        }
        if (io0Var != null) {
            in0 in0Var6 = this.c;
            if (in0Var6 != null && (h = in0Var6.h()) != null) {
                tn0Var = h.f();
            }
            if (tn0Var != null) {
                return true;
            }
        }
        return false;
    }

    public final void D() {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        cn0 cn0Var;
        xm0 xm0Var;
        xm0 xm0Var2;
        xm0 xm0Var3;
        xm0 xm0Var4;
        do0 h;
        io0 q;
        hd0 hd0Var = new hd0();
        hd0Var.a = "4";
        in0 in0Var = this.c;
        String str5 = null;
        if (in0Var != null && (h = in0Var.h()) != null && (q = h.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        hd0Var.c = String.valueOf(num);
        in0 in0Var2 = this.c;
        if (in0Var2 != null && (xm0Var4 = in0Var2.m) != null) {
            str = xm0Var4.k;
        } else {
            str = null;
        }
        hd0Var.d = str;
        in0 in0Var3 = this.c;
        if (in0Var3 != null && (xm0Var3 = in0Var3.m) != null) {
            str2 = xm0Var3.l;
        } else {
            str2 = null;
        }
        hd0Var.e = str2;
        in0 in0Var4 = this.c;
        if (in0Var4 != null && (xm0Var2 = in0Var4.m) != null) {
            str3 = xm0Var2.m;
        } else {
            str3 = null;
        }
        hd0Var.f = str3;
        in0 in0Var5 = this.c;
        if (in0Var5 != null && (xm0Var = in0Var5.m) != null) {
            str4 = xm0Var.n;
        } else {
            str4 = null;
        }
        hd0Var.g = str4;
        hd0Var.h = this.j;
        in0 in0Var6 = this.c;
        if (in0Var6 != null && (cn0Var = in0Var6.f) != null) {
            str5 = cn0Var.d;
        }
        hd0Var.i = str5;
        ti0.a().b(hd0Var);
    }

    public final void v() {
        do0 do0Var;
        do0 h;
        if (this.g) {
            return;
        }
        qk0 qk0Var = this.d;
        if (!this.e || qk0Var == null || !qk0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            il0 il0Var = il0.a;
            in0 in0Var = this.c;
            if (in0Var != null) {
                do0Var = in0Var.h();
            } else {
                do0Var = null;
            }
            do0 do0Var2 = do0Var;
            String g = qk0Var.g();
            in0 in0Var2 = this.c;
            il0Var.c(do0Var2, g, (in0Var2 == null || (h = in0Var2.h()) == null || (r0 = h.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
                {
                    super(2);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String coin, String str) {
                    String str2;
                    cn0 cn0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    in0 in0Var3 = NadRewardTaskHelper.this.c;
                    if (in0Var3 != null && (cn0Var = in0Var3.f) != null) {
                        str2 = cn0Var.d;
                    } else {
                        str2 = null;
                    }
                    ll0.h(str2, "2", coin, null, 8, null);
                }
            }, new Function2<Throwable, Integer, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$2
                {
                    super(2);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Integer num) {
                    invoke(th, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th, int i) {
                    String str;
                    cn0 cn0Var;
                    cn0 cn0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        in0 in0Var3 = NadRewardTaskHelper.this.c;
                        if (in0Var3 != null && (cn0Var2 = in0Var3.f) != null) {
                            str2 = cn0Var2.d;
                        }
                        ll0.r(str2, "2");
                        return;
                    }
                    in0 in0Var4 = NadRewardTaskHelper.this.c;
                    if (in0Var4 != null && (cn0Var = in0Var4.f) != null) {
                        str = cn0Var.d;
                    } else {
                        str = null;
                    }
                    ll0.q(str, "2", null, 4, null);
                }
            });
            this.g = true;
            C();
            return;
        }
        Toast.makeText(this.a, "哎呀！差一点就成功啦，再试一次", 0).show();
    }

    public final void C() {
        Integer num;
        xm0 xm0Var;
        String str;
        xm0 xm0Var2;
        sn0 c2;
        hd0 hd0Var = new hd0();
        hd0Var.a = "2";
        in0 in0Var = this.c;
        String str2 = null;
        if (in0Var != null && (c2 = in0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        hd0Var.b = String.valueOf(num);
        qk0 qk0Var = this.d;
        if (qk0Var != null) {
            str2 = qk0Var.h();
        }
        hd0Var.c = str2;
        in0 in0Var2 = this.c;
        String str3 = "";
        hd0Var.d = (in0Var2 == null || (xm0Var2 = in0Var2.m) == null || (r1 = xm0Var2.i) == null) ? "" : "";
        in0 in0Var3 = this.c;
        if (in0Var3 != null && (xm0Var = in0Var3.m) != null && (str = xm0Var.j) != null) {
            str3 = str;
        }
        hd0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        hd0Var.h = this.f;
        new Function0<Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$postDownloadTaskEvent$1
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                in0 in0Var4;
                sn0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (in0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = in0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        ti0.a().b(hd0Var);
    }

    public final void t(qk0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        cn0 cn0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ll0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        in0 in0Var = this.c;
        if (in0Var != null && (cn0Var = in0Var.f) != null) {
            str = cn0Var.d;
        } else {
            str = null;
        }
        ll0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        do0 h;
        io0 io0Var;
        tn0 tn0Var;
        do0 do0Var;
        io0 io0Var2;
        tn0 tn0Var2;
        do0 h2;
        do0 h3;
        do0 h4;
        do0 h5;
        do0 h6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            in0 in0Var = this.c;
            if (in0Var != null && (h6 = in0Var.h()) != null) {
                io0Var = h6.q();
            } else {
                io0Var = null;
            }
            if (io0Var != null) {
                in0 in0Var2 = this.c;
                if (in0Var2 != null && (h5 = in0Var2.h()) != null) {
                    tn0Var = h5.f();
                } else {
                    tn0Var = null;
                }
                if (tn0Var != null) {
                    il0 il0Var = il0.a;
                    in0 in0Var3 = this.c;
                    if (in0Var3 != null) {
                        do0Var = in0Var3.h();
                    } else {
                        do0Var = null;
                    }
                    in0 in0Var4 = this.c;
                    if (in0Var4 != null && (h4 = in0Var4.h()) != null) {
                        io0Var2 = h4.q();
                    } else {
                        io0Var2 = null;
                    }
                    Intrinsics.checkNotNull(io0Var2);
                    String a2 = io0Var2.a();
                    in0 in0Var5 = this.c;
                    if (in0Var5 != null && (h3 = in0Var5.h()) != null) {
                        tn0Var2 = h3.f();
                    } else {
                        tn0Var2 = null;
                    }
                    Intrinsics.checkNotNull(tn0Var2);
                    il0Var.c(do0Var, a2, tn0Var2.e(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
                        {
                            super(2);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                            invoke2(str2, str3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String coin, String nextCoin) {
                            String str2;
                            do0 h7;
                            cn0 cn0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            in0 in0Var6 = NadRewardTaskHelper.this.c;
                            if (in0Var6 != null && (cn0Var = in0Var6.f) != null) {
                                str2 = cn0Var.d;
                            } else {
                                str2 = null;
                            }
                            ll0.h(str2, "4", coin, null, 8, null);
                            in0 in0Var7 = NadRewardTaskHelper.this.c;
                            if (in0Var7 != null && (h7 = in0Var7.h()) != null) {
                                h7.D(nextCoin);
                            }
                        }
                    }, new Function2<Throwable, Integer, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$2
                        {
                            super(2);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Integer num) {
                            invoke(th, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable th, int i) {
                            String str2;
                            cn0 cn0Var;
                            cn0 cn0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                in0 in0Var6 = NadRewardTaskHelper.this.c;
                                if (in0Var6 != null && (cn0Var2 = in0Var6.f) != null) {
                                    str3 = cn0Var2.d;
                                }
                                ll0.r(str3, "4");
                                return;
                            }
                            in0 in0Var7 = NadRewardTaskHelper.this.c;
                            if (in0Var7 != null && (cn0Var = in0Var7.f) != null) {
                                str2 = cn0Var.d;
                            } else {
                                str2 = null;
                            }
                            ll0.q(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    in0 in0Var6 = this.c;
                    if (in0Var6 != null && (h2 = in0Var6.h()) != null) {
                        str = h2.g();
                    }
                    Toast.makeText(context, String.valueOf(str), 0).show();
                    this.k = true;
                    D();
                    return;
                }
                return;
            }
            return;
        }
        Context context2 = this.a;
        in0 in0Var7 = this.c;
        if (in0Var7 != null && (h = in0Var7.h()) != null) {
            str = h.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        xm0 xm0Var;
        tm0 tm0Var;
        xm0 xm0Var2;
        tm0 tm0Var2;
        in0 in0Var = this.c;
        PackageInfo packageInfo = null;
        if (in0Var != null && (xm0Var2 = in0Var.m) != null && (tm0Var2 = xm0Var2.p) != null) {
            str = tm0Var2.a;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            in0 in0Var2 = this.c;
            if (in0Var2 != null && (xm0Var = in0Var2.m) != null && (tm0Var = xm0Var.p) != null) {
                str2 = tm0Var.a;
            } else {
                str2 = null;
            }
            Intrinsics.checkNotNull(str2);
            packageInfo = packageManager.getPackageInfo(str2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public final boolean y(String str, Context context) {
        Object m859constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new ve0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m859constructorimpl = Result.m859constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m859constructorimpl = Result.m859constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m865isFailureimpl(m859constructorimpl)) {
            m859constructorimpl = null;
        }
        String str3 = (String) m859constructorimpl;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str3));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean z(Context context) {
        sn0 sn0Var;
        sn0 sn0Var2;
        String str;
        boolean z;
        boolean z2;
        do0 h;
        do0 h2;
        in0 in0Var = this.c;
        if ((in0Var != null && !in0Var.q()) || x(context)) {
            return false;
        }
        in0 in0Var2 = this.c;
        String str2 = null;
        if (in0Var2 != null) {
            sn0Var = in0Var2.c();
        } else {
            sn0Var = null;
        }
        if (sn0Var == null) {
            return false;
        }
        in0 in0Var3 = this.c;
        if (in0Var3 != null) {
            sn0Var2 = in0Var3.c();
        } else {
            sn0Var2 = null;
        }
        Intrinsics.checkNotNull(sn0Var2);
        if (sn0Var2.h() <= 0) {
            return false;
        }
        in0 in0Var4 = this.c;
        if (in0Var4 != null && (h2 = in0Var4.h()) != null) {
            str = h2.d();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        in0 in0Var5 = this.c;
        if (in0Var5 != null && (h = in0Var5.h()) != null) {
            str2 = h.e();
        }
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return false;
        }
        return true;
    }
}
