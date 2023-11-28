package com.baidu.nadcore.lp.reward.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.aj0;
import com.baidu.tieba.bn0;
import com.baidu.tieba.bo0;
import com.baidu.tieba.do0;
import com.baidu.tieba.go0;
import com.baidu.tieba.hd0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.hn0;
import com.baidu.tieba.il0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rn0;
import com.baidu.tieba.ti0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.ve0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xm0;
import java.util.HashMap;
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
    public hn0 c;
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
            do0 i;
            hn0 hn0Var = NadRewardTaskHelper.this.c;
            if (hn0Var != null && (i = hn0Var.i()) != null && i.a()) {
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
            hn0 hn0Var;
            qn0 c;
            Long n;
            bn0 bn0Var;
            hn0 hn0Var2;
            qn0 c2;
            Long f;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (hn0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = hn0Var2.c()) != null && (f = c2.f()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, f.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                hn0 hn0Var3 = nadRewardTaskHelper2.c;
                if (hn0Var3 != null && (bn0Var = hn0Var3.f) != null) {
                    str = bn0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (hn0Var = NadRewardTaskHelper.this.c) != null && (c = hn0Var.c()) != null && (n = c.n()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, n.longValue());
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
        qn0 c2;
        Long n;
        if (!B()) {
            return;
        }
        this.m = new a();
        hn0 hn0Var = this.c;
        if (hn0Var != null && (c2 = hn0Var.c()) != null && (n = c2.n()) != null) {
            long longValue = n.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(hn0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        go0 go0Var;
        bo0 g;
        bo0 g2;
        qn0 c2;
        bn0 bn0Var;
        bn0 bn0Var2;
        bo0 g3;
        go0 q;
        hn0 hn0Var = this.c;
        if (hn0Var != null && (g3 = hn0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        rn0 rn0Var = null;
        r2 = null;
        String str2 = null;
        rn0Var = null;
        if (i <= 0) {
            hn0 hn0Var2 = this.c;
            if (hn0Var2 != null && (bn0Var2 = hn0Var2.f) != null) {
                str2 = bn0Var2.d;
            }
            ll0.e(str2, "18", "18002");
            return false;
        }
        hn0 hn0Var3 = this.c;
        if (hn0Var3 != null && (bn0Var = hn0Var3.f) != null) {
            str = bn0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        hn0 hn0Var4 = this.c;
        if (hn0Var4 != null && (c2 = hn0Var4.c()) != null && c2.o() == 0) {
            return false;
        }
        hn0 hn0Var5 = this.c;
        if (hn0Var5 != null && (g2 = hn0Var5.g()) != null) {
            go0Var = g2.q();
        } else {
            go0Var = null;
        }
        if (go0Var != null) {
            hn0 hn0Var6 = this.c;
            if (hn0Var6 != null && (g = hn0Var6.g()) != null) {
                rn0Var = g.f();
            }
            if (rn0Var != null) {
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
        bn0 bn0Var;
        xm0 xm0Var;
        xm0 xm0Var2;
        xm0 xm0Var3;
        xm0 xm0Var4;
        bo0 g;
        go0 q;
        hd0 hd0Var = new hd0();
        hd0Var.a = "4";
        hn0 hn0Var = this.c;
        String str5 = null;
        if (hn0Var != null && (g = hn0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        hd0Var.c = String.valueOf(num);
        hn0 hn0Var2 = this.c;
        if (hn0Var2 != null && (xm0Var4 = hn0Var2.m) != null) {
            str = xm0Var4.k;
        } else {
            str = null;
        }
        hd0Var.d = str;
        hn0 hn0Var3 = this.c;
        if (hn0Var3 != null && (xm0Var3 = hn0Var3.m) != null) {
            str2 = xm0Var3.l;
        } else {
            str2 = null;
        }
        hd0Var.e = str2;
        hn0 hn0Var4 = this.c;
        if (hn0Var4 != null && (xm0Var2 = hn0Var4.m) != null) {
            str3 = xm0Var2.m;
        } else {
            str3 = null;
        }
        hd0Var.f = str3;
        hn0 hn0Var5 = this.c;
        if (hn0Var5 != null && (xm0Var = hn0Var5.m) != null) {
            str4 = xm0Var.n;
        } else {
            str4 = null;
        }
        hd0Var.g = str4;
        hd0Var.h = this.j;
        hn0 hn0Var6 = this.c;
        if (hn0Var6 != null && (bn0Var = hn0Var6.f) != null) {
            str5 = bn0Var.d;
        }
        hd0Var.i = str5;
        ti0.a().b(hd0Var);
    }

    public final void v() {
        bo0 bo0Var;
        bo0 g;
        if (this.g) {
            return;
        }
        qk0 qk0Var = this.d;
        if (!this.e || qk0Var == null || !qk0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            il0 il0Var = il0.a;
            hn0 hn0Var = this.c;
            if (hn0Var != null) {
                bo0Var = hn0Var.g();
            } else {
                bo0Var = null;
            }
            bo0 bo0Var2 = bo0Var;
            String g2 = qk0Var.g();
            hn0 hn0Var2 = this.c;
            il0Var.c(bo0Var2, g2, (hn0Var2 == null || (g = hn0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    bn0 bn0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    hn0 hn0Var3 = NadRewardTaskHelper.this.c;
                    if (hn0Var3 != null && (bn0Var = hn0Var3.f) != null) {
                        str2 = bn0Var.d;
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
                    bn0 bn0Var;
                    bn0 bn0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        hn0 hn0Var3 = NadRewardTaskHelper.this.c;
                        if (hn0Var3 != null && (bn0Var2 = hn0Var3.f) != null) {
                            str2 = bn0Var2.d;
                        }
                        ll0.r(str2, "2");
                        return;
                    }
                    hn0 hn0Var4 = NadRewardTaskHelper.this.c;
                    if (hn0Var4 != null && (bn0Var = hn0Var4.f) != null) {
                        str = bn0Var.d;
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
        qn0 c2;
        hd0 hd0Var = new hd0();
        hd0Var.a = "2";
        hn0 hn0Var = this.c;
        String str2 = null;
        if (hn0Var != null && (c2 = hn0Var.c()) != null) {
            num = Integer.valueOf(c2.g());
        } else {
            num = null;
        }
        hd0Var.b = String.valueOf(num);
        qk0 qk0Var = this.d;
        if (qk0Var != null) {
            str2 = qk0Var.h();
        }
        hd0Var.c = str2;
        hn0 hn0Var2 = this.c;
        String str3 = "";
        hd0Var.d = (hn0Var2 == null || (xm0Var2 = hn0Var2.m) == null || (r1 = xm0Var2.i) == null) ? "" : "";
        hn0 hn0Var3 = this.c;
        if (hn0Var3 != null && (xm0Var = hn0Var3.m) != null && (str = xm0Var.j) != null) {
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
                hn0 hn0Var4;
                qn0 c3;
                Long f;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (hn0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = hn0Var4.c()) != null && (f = c3.f()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, f.longValue());
                }
            }
        };
        ti0.a().b(hd0Var);
    }

    public final void t(qk0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        bn0 bn0Var;
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
        hn0 hn0Var = this.c;
        if (hn0Var != null && (bn0Var = hn0Var.f) != null) {
            str = bn0Var.d;
        } else {
            str = null;
        }
        ll0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        bo0 g;
        go0 go0Var;
        rn0 rn0Var;
        bo0 bo0Var;
        go0 go0Var2;
        rn0 rn0Var2;
        bo0 g2;
        bo0 g3;
        bo0 g4;
        bo0 g5;
        bo0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            hn0 hn0Var = this.c;
            if (hn0Var != null && (g6 = hn0Var.g()) != null) {
                go0Var = g6.q();
            } else {
                go0Var = null;
            }
            if (go0Var != null) {
                hn0 hn0Var2 = this.c;
                if (hn0Var2 != null && (g5 = hn0Var2.g()) != null) {
                    rn0Var = g5.f();
                } else {
                    rn0Var = null;
                }
                if (rn0Var != null) {
                    il0 il0Var = il0.a;
                    hn0 hn0Var3 = this.c;
                    if (hn0Var3 != null) {
                        bo0Var = hn0Var3.g();
                    } else {
                        bo0Var = null;
                    }
                    hn0 hn0Var4 = this.c;
                    if (hn0Var4 != null && (g4 = hn0Var4.g()) != null) {
                        go0Var2 = g4.q();
                    } else {
                        go0Var2 = null;
                    }
                    Intrinsics.checkNotNull(go0Var2);
                    String a2 = go0Var2.a();
                    hn0 hn0Var5 = this.c;
                    if (hn0Var5 != null && (g3 = hn0Var5.g()) != null) {
                        rn0Var2 = g3.f();
                    } else {
                        rn0Var2 = null;
                    }
                    Intrinsics.checkNotNull(rn0Var2);
                    il0Var.c(bo0Var, a2, rn0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            bo0 g7;
                            bn0 bn0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            hn0 hn0Var6 = NadRewardTaskHelper.this.c;
                            if (hn0Var6 != null && (bn0Var = hn0Var6.f) != null) {
                                str2 = bn0Var.d;
                            } else {
                                str2 = null;
                            }
                            ll0.h(str2, "4", coin, null, 8, null);
                            hn0 hn0Var7 = NadRewardTaskHelper.this.c;
                            if (hn0Var7 != null && (g7 = hn0Var7.g()) != null) {
                                g7.D(nextCoin);
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
                            bn0 bn0Var;
                            bn0 bn0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                hn0 hn0Var6 = NadRewardTaskHelper.this.c;
                                if (hn0Var6 != null && (bn0Var2 = hn0Var6.f) != null) {
                                    str3 = bn0Var2.d;
                                }
                                ll0.r(str3, "4");
                                return;
                            }
                            hn0 hn0Var7 = NadRewardTaskHelper.this.c;
                            if (hn0Var7 != null && (bn0Var = hn0Var7.f) != null) {
                                str2 = bn0Var.d;
                            } else {
                                str2 = null;
                            }
                            ll0.q(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    hn0 hn0Var6 = this.c;
                    if (hn0Var6 != null && (g2 = hn0Var6.g()) != null) {
                        str = g2.g();
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
        hn0 hn0Var7 = this.c;
        if (hn0Var7 != null && (g = hn0Var7.g()) != null) {
            str = g.h();
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
        hn0 hn0Var = this.c;
        PackageInfo packageInfo = null;
        if (hn0Var != null && (xm0Var2 = hn0Var.m) != null && (tm0Var2 = xm0Var2.p) != null) {
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
            hn0 hn0Var2 = this.c;
            if (hn0Var2 != null && (xm0Var = hn0Var2.m) != null && (tm0Var = xm0Var.p) != null) {
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
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean z(Context context) {
        qn0 qn0Var;
        qn0 qn0Var2;
        String str;
        boolean z;
        boolean z2;
        bo0 g;
        bo0 g2;
        hn0 hn0Var = this.c;
        if ((hn0Var != null && !hn0Var.p()) || x(context)) {
            return false;
        }
        hn0 hn0Var2 = this.c;
        String str2 = null;
        if (hn0Var2 != null) {
            qn0Var = hn0Var2.c();
        } else {
            qn0Var = null;
        }
        if (qn0Var == null) {
            return false;
        }
        hn0 hn0Var3 = this.c;
        if (hn0Var3 != null) {
            qn0Var2 = hn0Var3.c();
        } else {
            qn0Var2 = null;
        }
        Intrinsics.checkNotNull(qn0Var2);
        if (qn0Var2.g() <= 0) {
            return false;
        }
        hn0 hn0Var4 = this.c;
        if (hn0Var4 != null && (g2 = hn0Var4.g()) != null) {
            str = g2.d();
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
        hn0 hn0Var5 = this.c;
        if (hn0Var5 != null && (g = hn0Var5.g()) != null) {
            str2 = g.e();
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
