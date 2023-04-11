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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.bq0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.jq0;
import com.baidu.tieba.kg0;
import com.baidu.tieba.kn0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.nl0;
import com.baidu.tieba.op0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.rl0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.zn0;
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
/* loaded from: classes2.dex */
public final class NadRewardTaskHelper {
    public Context a;
    public Handler b;
    public sp0 c;
    public kn0 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Runnable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            lq0 h;
            sp0 sp0Var = NadRewardTaskHelper.this.c;
            if (sp0Var != null && (h = sp0Var.h()) != null && h.a()) {
                return;
            }
            NadRewardTaskHelper.this.i = true;
            NadRewardTaskHelper.this.D();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardTaskHelper.this.f = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NadRewardTaskHelper.this.j = true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends rl0<ul0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rl0
        public void onEvent(ul0 event) {
            sp0 sp0Var;
            bq0 c;
            Long k;
            op0 op0Var;
            sp0 sp0Var2;
            bq0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (sp0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = sp0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                sp0 sp0Var3 = nadRewardTaskHelper2.c;
                if (sp0Var3 != null && (op0Var = sp0Var3.f) != null) {
                    str = op0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (sp0Var = NadRewardTaskHelper.this.c) != null && (c = sp0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = ii0.b();
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
        nl0.a().b(this, new d(ul0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        nl0.a().unregister(this);
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
        bq0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        sp0 sp0Var = this.c;
        if (sp0Var != null && (c2 = sp0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(sp0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        oq0 oq0Var;
        jq0 g;
        jq0 g2;
        bq0 c2;
        op0 op0Var;
        op0 op0Var2;
        jq0 g3;
        oq0 q;
        sp0 sp0Var = this.c;
        if (sp0Var != null && (g3 = sp0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        cq0 cq0Var = null;
        r2 = null;
        String str2 = null;
        cq0Var = null;
        if (i <= 0) {
            sp0 sp0Var2 = this.c;
            if (sp0Var2 != null && (op0Var2 = sp0Var2.f) != null) {
                str2 = op0Var2.d;
            }
            zn0.e(str2, "18", "18002");
            return false;
        }
        sp0 sp0Var3 = this.c;
        if (sp0Var3 != null && (op0Var = sp0Var3.f) != null) {
            str = op0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        sp0 sp0Var4 = this.c;
        if (sp0Var4 != null && (c2 = sp0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        sp0 sp0Var5 = this.c;
        if (sp0Var5 != null && (g2 = sp0Var5.g()) != null) {
            oq0Var = g2.q();
        } else {
            oq0Var = null;
        }
        if (oq0Var != null) {
            sp0 sp0Var6 = this.c;
            if (sp0Var6 != null && (g = sp0Var6.g()) != null) {
                cq0Var = g.f();
            }
            if (cq0Var != null) {
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
        op0 op0Var;
        kp0 kp0Var;
        kp0 kp0Var2;
        kp0 kp0Var3;
        kp0 kp0Var4;
        jq0 g;
        oq0 q;
        kg0 kg0Var = new kg0();
        kg0Var.a = "4";
        sp0 sp0Var = this.c;
        String str5 = null;
        if (sp0Var != null && (g = sp0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        kg0Var.c = String.valueOf(num);
        sp0 sp0Var2 = this.c;
        if (sp0Var2 != null && (kp0Var4 = sp0Var2.m) != null) {
            str = kp0Var4.k;
        } else {
            str = null;
        }
        kg0Var.d = str;
        sp0 sp0Var3 = this.c;
        if (sp0Var3 != null && (kp0Var3 = sp0Var3.m) != null) {
            str2 = kp0Var3.l;
        } else {
            str2 = null;
        }
        kg0Var.e = str2;
        sp0 sp0Var4 = this.c;
        if (sp0Var4 != null && (kp0Var2 = sp0Var4.m) != null) {
            str3 = kp0Var2.m;
        } else {
            str3 = null;
        }
        kg0Var.f = str3;
        sp0 sp0Var5 = this.c;
        if (sp0Var5 != null && (kp0Var = sp0Var5.m) != null) {
            str4 = kp0Var.n;
        } else {
            str4 = null;
        }
        kg0Var.g = str4;
        kg0Var.h = this.j;
        sp0 sp0Var6 = this.c;
        if (sp0Var6 != null && (op0Var = sp0Var6.f) != null) {
            str5 = op0Var.d;
        }
        kg0Var.i = str5;
        nl0.a().a(kg0Var);
    }

    public final void v() {
        jq0 jq0Var;
        jq0 g;
        if (this.g) {
            return;
        }
        kn0 kn0Var = this.d;
        if (!this.e || kn0Var == null || !kn0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            xn0 xn0Var = xn0.a;
            sp0 sp0Var = this.c;
            if (sp0Var != null) {
                jq0Var = sp0Var.g();
            } else {
                jq0Var = null;
            }
            jq0 jq0Var2 = jq0Var;
            String g2 = kn0Var.g();
            sp0 sp0Var2 = this.c;
            xn0Var.c(jq0Var2, g2, (sp0Var2 == null || (g = sp0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    op0 op0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    sp0 sp0Var3 = NadRewardTaskHelper.this.c;
                    if (sp0Var3 != null && (op0Var = sp0Var3.f) != null) {
                        str2 = op0Var.d;
                    } else {
                        str2 = null;
                    }
                    zn0.g(str2, "2", coin);
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
                    op0 op0Var;
                    op0 op0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        sp0 sp0Var3 = NadRewardTaskHelper.this.c;
                        if (sp0Var3 != null && (op0Var2 = sp0Var3.f) != null) {
                            str2 = op0Var2.d;
                        }
                        zn0.n(str2, "2");
                        return;
                    }
                    sp0 sp0Var4 = NadRewardTaskHelper.this.c;
                    if (sp0Var4 != null && (op0Var = sp0Var4.f) != null) {
                        str = op0Var.d;
                    } else {
                        str = null;
                    }
                    zn0.m(str, "2", null, 4, null);
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
        kp0 kp0Var;
        String str;
        kp0 kp0Var2;
        bq0 c2;
        kg0 kg0Var = new kg0();
        kg0Var.a = "2";
        sp0 sp0Var = this.c;
        String str2 = null;
        if (sp0Var != null && (c2 = sp0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        kg0Var.b = String.valueOf(num);
        kn0 kn0Var = this.d;
        if (kn0Var != null) {
            str2 = kn0Var.h();
        }
        kg0Var.c = str2;
        sp0 sp0Var2 = this.c;
        String str3 = "";
        kg0Var.d = (sp0Var2 == null || (kp0Var2 = sp0Var2.m) == null || (r1 = kp0Var2.i) == null) ? "" : "";
        sp0 sp0Var3 = this.c;
        if (sp0Var3 != null && (kp0Var = sp0Var3.m) != null && (str = kp0Var.j) != null) {
            str3 = str;
        }
        kg0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        kg0Var.h = this.f;
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
                sp0 sp0Var4;
                bq0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (sp0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = sp0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        nl0.a().a(kg0Var);
    }

    public final void t(kn0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        op0 op0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            zn0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        sp0 sp0Var = this.c;
        if (sp0Var != null && (op0Var = sp0Var.f) != null) {
            str = op0Var.d;
        } else {
            str = null;
        }
        zn0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        jq0 g;
        oq0 oq0Var;
        cq0 cq0Var;
        jq0 jq0Var;
        oq0 oq0Var2;
        cq0 cq0Var2;
        jq0 g2;
        jq0 g3;
        jq0 g4;
        jq0 g5;
        jq0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            sp0 sp0Var = this.c;
            if (sp0Var != null && (g6 = sp0Var.g()) != null) {
                oq0Var = g6.q();
            } else {
                oq0Var = null;
            }
            if (oq0Var != null) {
                sp0 sp0Var2 = this.c;
                if (sp0Var2 != null && (g5 = sp0Var2.g()) != null) {
                    cq0Var = g5.f();
                } else {
                    cq0Var = null;
                }
                if (cq0Var != null) {
                    xn0 xn0Var = xn0.a;
                    sp0 sp0Var3 = this.c;
                    if (sp0Var3 != null) {
                        jq0Var = sp0Var3.g();
                    } else {
                        jq0Var = null;
                    }
                    sp0 sp0Var4 = this.c;
                    if (sp0Var4 != null && (g4 = sp0Var4.g()) != null) {
                        oq0Var2 = g4.q();
                    } else {
                        oq0Var2 = null;
                    }
                    Intrinsics.checkNotNull(oq0Var2);
                    String a2 = oq0Var2.a();
                    sp0 sp0Var5 = this.c;
                    if (sp0Var5 != null && (g3 = sp0Var5.g()) != null) {
                        cq0Var2 = g3.f();
                    } else {
                        cq0Var2 = null;
                    }
                    Intrinsics.checkNotNull(cq0Var2);
                    xn0Var.c(jq0Var, a2, cq0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            jq0 g7;
                            op0 op0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            sp0 sp0Var6 = NadRewardTaskHelper.this.c;
                            if (sp0Var6 != null && (op0Var = sp0Var6.f) != null) {
                                str2 = op0Var.d;
                            } else {
                                str2 = null;
                            }
                            zn0.g(str2, "4", coin);
                            sp0 sp0Var7 = NadRewardTaskHelper.this.c;
                            if (sp0Var7 != null && (g7 = sp0Var7.g()) != null) {
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
                            op0 op0Var;
                            op0 op0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                sp0 sp0Var6 = NadRewardTaskHelper.this.c;
                                if (sp0Var6 != null && (op0Var2 = sp0Var6.f) != null) {
                                    str3 = op0Var2.d;
                                }
                                zn0.n(str3, "4");
                                return;
                            }
                            sp0 sp0Var7 = NadRewardTaskHelper.this.c;
                            if (sp0Var7 != null && (op0Var = sp0Var7.f) != null) {
                                str2 = op0Var.d;
                            } else {
                                str2 = null;
                            }
                            zn0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    sp0 sp0Var6 = this.c;
                    if (sp0Var6 != null && (g2 = sp0Var6.g()) != null) {
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
        sp0 sp0Var7 = this.c;
        if (sp0Var7 != null && (g = sp0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        kp0 kp0Var;
        gp0 gp0Var;
        kp0 kp0Var2;
        gp0 gp0Var2;
        sp0 sp0Var = this.c;
        PackageInfo packageInfo = null;
        if (sp0Var != null && (kp0Var2 = sp0Var.m) != null && (gp0Var2 = kp0Var2.p) != null) {
            str = gp0Var2.a;
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
            sp0 sp0Var2 = this.c;
            if (sp0Var2 != null && (kp0Var = sp0Var2.m) != null && (gp0Var = kp0Var.p) != null) {
                str2 = gp0Var.a;
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
        Object m770constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new wh0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m770constructorimpl = Result.m770constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m770constructorimpl = Result.m770constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776isFailureimpl(m770constructorimpl)) {
            m770constructorimpl = null;
        }
        String str3 = (String) m770constructorimpl;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean z(Context context) {
        bq0 bq0Var;
        bq0 bq0Var2;
        String str;
        boolean z;
        boolean z2;
        jq0 g;
        jq0 g2;
        sp0 sp0Var = this.c;
        if ((sp0Var != null && !sp0Var.m()) || x(context)) {
            return false;
        }
        sp0 sp0Var2 = this.c;
        String str2 = null;
        if (sp0Var2 != null) {
            bq0Var = sp0Var2.c();
        } else {
            bq0Var = null;
        }
        if (bq0Var == null) {
            return false;
        }
        sp0 sp0Var3 = this.c;
        if (sp0Var3 != null) {
            bq0Var2 = sp0Var3.c();
        } else {
            bq0Var2 = null;
        }
        Intrinsics.checkNotNull(bq0Var2);
        if (bq0Var2.h() <= 0) {
            return false;
        }
        sp0 sp0Var4 = this.c;
        if (sp0Var4 != null && (g2 = sp0Var4.g()) != null) {
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
        sp0 sp0Var5 = this.c;
        if (sp0Var5 != null && (g = sp0Var5.g()) != null) {
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
