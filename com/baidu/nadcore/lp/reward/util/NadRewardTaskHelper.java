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
import com.baidu.tieba.ao0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.kq0;
import com.baidu.tieba.lg0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.mq0;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.xh0;
import com.baidu.tieba.yn0;
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
    public tp0 c;
    public ln0 d;
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
            mq0 h;
            tp0 tp0Var = NadRewardTaskHelper.this.c;
            if (tp0Var != null && (h = tp0Var.h()) != null && h.a()) {
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
    public static final class d extends sl0<vl0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sl0
        public void onEvent(vl0 event) {
            tp0 tp0Var;
            cq0 c;
            Long k;
            pp0 pp0Var;
            tp0 tp0Var2;
            cq0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (tp0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = tp0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                tp0 tp0Var3 = nadRewardTaskHelper2.c;
                if (tp0Var3 != null && (pp0Var = tp0Var3.f) != null) {
                    str = pp0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (tp0Var = NadRewardTaskHelper.this.c) != null && (c = tp0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = ji0.b();
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
        ol0.a().b(this, new d(vl0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        ol0.a().unregister(this);
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
        cq0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        tp0 tp0Var = this.c;
        if (tp0Var != null && (c2 = tp0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(tp0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        pq0 pq0Var;
        kq0 g;
        kq0 g2;
        cq0 c2;
        pp0 pp0Var;
        pp0 pp0Var2;
        kq0 g3;
        pq0 q;
        tp0 tp0Var = this.c;
        if (tp0Var != null && (g3 = tp0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        dq0 dq0Var = null;
        r2 = null;
        String str2 = null;
        dq0Var = null;
        if (i <= 0) {
            tp0 tp0Var2 = this.c;
            if (tp0Var2 != null && (pp0Var2 = tp0Var2.f) != null) {
                str2 = pp0Var2.d;
            }
            ao0.e(str2, "18", "18002");
            return false;
        }
        tp0 tp0Var3 = this.c;
        if (tp0Var3 != null && (pp0Var = tp0Var3.f) != null) {
            str = pp0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        tp0 tp0Var4 = this.c;
        if (tp0Var4 != null && (c2 = tp0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        tp0 tp0Var5 = this.c;
        if (tp0Var5 != null && (g2 = tp0Var5.g()) != null) {
            pq0Var = g2.q();
        } else {
            pq0Var = null;
        }
        if (pq0Var != null) {
            tp0 tp0Var6 = this.c;
            if (tp0Var6 != null && (g = tp0Var6.g()) != null) {
                dq0Var = g.f();
            }
            if (dq0Var != null) {
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
        pp0 pp0Var;
        lp0 lp0Var;
        lp0 lp0Var2;
        lp0 lp0Var3;
        lp0 lp0Var4;
        kq0 g;
        pq0 q;
        lg0 lg0Var = new lg0();
        lg0Var.a = "4";
        tp0 tp0Var = this.c;
        String str5 = null;
        if (tp0Var != null && (g = tp0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        lg0Var.c = String.valueOf(num);
        tp0 tp0Var2 = this.c;
        if (tp0Var2 != null && (lp0Var4 = tp0Var2.m) != null) {
            str = lp0Var4.k;
        } else {
            str = null;
        }
        lg0Var.d = str;
        tp0 tp0Var3 = this.c;
        if (tp0Var3 != null && (lp0Var3 = tp0Var3.m) != null) {
            str2 = lp0Var3.l;
        } else {
            str2 = null;
        }
        lg0Var.e = str2;
        tp0 tp0Var4 = this.c;
        if (tp0Var4 != null && (lp0Var2 = tp0Var4.m) != null) {
            str3 = lp0Var2.m;
        } else {
            str3 = null;
        }
        lg0Var.f = str3;
        tp0 tp0Var5 = this.c;
        if (tp0Var5 != null && (lp0Var = tp0Var5.m) != null) {
            str4 = lp0Var.n;
        } else {
            str4 = null;
        }
        lg0Var.g = str4;
        lg0Var.h = this.j;
        tp0 tp0Var6 = this.c;
        if (tp0Var6 != null && (pp0Var = tp0Var6.f) != null) {
            str5 = pp0Var.d;
        }
        lg0Var.i = str5;
        ol0.a().a(lg0Var);
    }

    public final void v() {
        kq0 kq0Var;
        kq0 g;
        if (this.g) {
            return;
        }
        ln0 ln0Var = this.d;
        if (!this.e || ln0Var == null || !ln0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            yn0 yn0Var = yn0.a;
            tp0 tp0Var = this.c;
            if (tp0Var != null) {
                kq0Var = tp0Var.g();
            } else {
                kq0Var = null;
            }
            kq0 kq0Var2 = kq0Var;
            String g2 = ln0Var.g();
            tp0 tp0Var2 = this.c;
            yn0Var.c(kq0Var2, g2, (tp0Var2 == null || (g = tp0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    pp0 pp0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    tp0 tp0Var3 = NadRewardTaskHelper.this.c;
                    if (tp0Var3 != null && (pp0Var = tp0Var3.f) != null) {
                        str2 = pp0Var.d;
                    } else {
                        str2 = null;
                    }
                    ao0.g(str2, "2", coin);
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
                    pp0 pp0Var;
                    pp0 pp0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        tp0 tp0Var3 = NadRewardTaskHelper.this.c;
                        if (tp0Var3 != null && (pp0Var2 = tp0Var3.f) != null) {
                            str2 = pp0Var2.d;
                        }
                        ao0.n(str2, "2");
                        return;
                    }
                    tp0 tp0Var4 = NadRewardTaskHelper.this.c;
                    if (tp0Var4 != null && (pp0Var = tp0Var4.f) != null) {
                        str = pp0Var.d;
                    } else {
                        str = null;
                    }
                    ao0.m(str, "2", null, 4, null);
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
        lp0 lp0Var;
        String str;
        lp0 lp0Var2;
        cq0 c2;
        lg0 lg0Var = new lg0();
        lg0Var.a = "2";
        tp0 tp0Var = this.c;
        String str2 = null;
        if (tp0Var != null && (c2 = tp0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        lg0Var.b = String.valueOf(num);
        ln0 ln0Var = this.d;
        if (ln0Var != null) {
            str2 = ln0Var.h();
        }
        lg0Var.c = str2;
        tp0 tp0Var2 = this.c;
        String str3 = "";
        lg0Var.d = (tp0Var2 == null || (lp0Var2 = tp0Var2.m) == null || (r1 = lp0Var2.i) == null) ? "" : "";
        tp0 tp0Var3 = this.c;
        if (tp0Var3 != null && (lp0Var = tp0Var3.m) != null && (str = lp0Var.j) != null) {
            str3 = str;
        }
        lg0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        lg0Var.h = this.f;
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
                tp0 tp0Var4;
                cq0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (tp0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = tp0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        ol0.a().a(lg0Var);
    }

    public final void t(ln0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        pp0 pp0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ao0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        tp0 tp0Var = this.c;
        if (tp0Var != null && (pp0Var = tp0Var.f) != null) {
            str = pp0Var.d;
        } else {
            str = null;
        }
        ao0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        kq0 g;
        pq0 pq0Var;
        dq0 dq0Var;
        kq0 kq0Var;
        pq0 pq0Var2;
        dq0 dq0Var2;
        kq0 g2;
        kq0 g3;
        kq0 g4;
        kq0 g5;
        kq0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            tp0 tp0Var = this.c;
            if (tp0Var != null && (g6 = tp0Var.g()) != null) {
                pq0Var = g6.q();
            } else {
                pq0Var = null;
            }
            if (pq0Var != null) {
                tp0 tp0Var2 = this.c;
                if (tp0Var2 != null && (g5 = tp0Var2.g()) != null) {
                    dq0Var = g5.f();
                } else {
                    dq0Var = null;
                }
                if (dq0Var != null) {
                    yn0 yn0Var = yn0.a;
                    tp0 tp0Var3 = this.c;
                    if (tp0Var3 != null) {
                        kq0Var = tp0Var3.g();
                    } else {
                        kq0Var = null;
                    }
                    tp0 tp0Var4 = this.c;
                    if (tp0Var4 != null && (g4 = tp0Var4.g()) != null) {
                        pq0Var2 = g4.q();
                    } else {
                        pq0Var2 = null;
                    }
                    Intrinsics.checkNotNull(pq0Var2);
                    String a2 = pq0Var2.a();
                    tp0 tp0Var5 = this.c;
                    if (tp0Var5 != null && (g3 = tp0Var5.g()) != null) {
                        dq0Var2 = g3.f();
                    } else {
                        dq0Var2 = null;
                    }
                    Intrinsics.checkNotNull(dq0Var2);
                    yn0Var.c(kq0Var, a2, dq0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            kq0 g7;
                            pp0 pp0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            tp0 tp0Var6 = NadRewardTaskHelper.this.c;
                            if (tp0Var6 != null && (pp0Var = tp0Var6.f) != null) {
                                str2 = pp0Var.d;
                            } else {
                                str2 = null;
                            }
                            ao0.g(str2, "4", coin);
                            tp0 tp0Var7 = NadRewardTaskHelper.this.c;
                            if (tp0Var7 != null && (g7 = tp0Var7.g()) != null) {
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
                            pp0 pp0Var;
                            pp0 pp0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                tp0 tp0Var6 = NadRewardTaskHelper.this.c;
                                if (tp0Var6 != null && (pp0Var2 = tp0Var6.f) != null) {
                                    str3 = pp0Var2.d;
                                }
                                ao0.n(str3, "4");
                                return;
                            }
                            tp0 tp0Var7 = NadRewardTaskHelper.this.c;
                            if (tp0Var7 != null && (pp0Var = tp0Var7.f) != null) {
                                str2 = pp0Var.d;
                            } else {
                                str2 = null;
                            }
                            ao0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    tp0 tp0Var6 = this.c;
                    if (tp0Var6 != null && (g2 = tp0Var6.g()) != null) {
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
        tp0 tp0Var7 = this.c;
        if (tp0Var7 != null && (g = tp0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        lp0 lp0Var;
        hp0 hp0Var;
        lp0 lp0Var2;
        hp0 hp0Var2;
        tp0 tp0Var = this.c;
        PackageInfo packageInfo = null;
        if (tp0Var != null && (lp0Var2 = tp0Var.m) != null && (hp0Var2 = lp0Var2.p) != null) {
            str = hp0Var2.a;
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
            tp0 tp0Var2 = this.c;
            if (tp0Var2 != null && (lp0Var = tp0Var2.m) != null && (hp0Var = lp0Var.p) != null) {
                str2 = hp0Var.a;
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
        HashMap<String, String> d2 = new xh0(str).d();
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
        cq0 cq0Var;
        cq0 cq0Var2;
        String str;
        boolean z;
        boolean z2;
        kq0 g;
        kq0 g2;
        tp0 tp0Var = this.c;
        if ((tp0Var != null && !tp0Var.m()) || x(context)) {
            return false;
        }
        tp0 tp0Var2 = this.c;
        String str2 = null;
        if (tp0Var2 != null) {
            cq0Var = tp0Var2.c();
        } else {
            cq0Var = null;
        }
        if (cq0Var == null) {
            return false;
        }
        tp0 tp0Var3 = this.c;
        if (tp0Var3 != null) {
            cq0Var2 = tp0Var3.c();
        } else {
            cq0Var2 = null;
        }
        Intrinsics.checkNotNull(cq0Var2);
        if (cq0Var2.h() <= 0) {
            return false;
        }
        tp0 tp0Var4 = this.c;
        if (tp0Var4 != null && (g2 = tp0Var4.g()) != null) {
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
        tp0 tp0Var5 = this.c;
        if (tp0Var5 != null && (g = tp0Var5.g()) != null) {
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
