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
import com.baidu.tieba.bn0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.dj0;
import com.baidu.tieba.fn0;
import com.baidu.tieba.gr0;
import com.baidu.tieba.gs0;
import com.baidu.tieba.in0;
import com.baidu.tieba.is0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.ph0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.rp0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.wr0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.yq0;
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
    public mr0 c;
    public yo0 d;
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
            is0 j;
            mr0 mr0Var = NadRewardTaskHelper.this.c;
            if (mr0Var != null && (j = mr0Var.j()) != null && j.a()) {
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
    public static final class d extends fn0<in0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fn0
        public void onEvent(in0 event) {
            mr0 mr0Var;
            vr0 c;
            Long n;
            gr0 gr0Var;
            mr0 mr0Var2;
            vr0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (mr0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = mr0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                mr0 mr0Var3 = nadRewardTaskHelper2.c;
                if (mr0Var3 != null && (gr0Var = mr0Var3.f) != null) {
                    str = gr0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (mr0Var = NadRewardTaskHelper.this.c) != null && (c = mr0Var.c()) != null && (n = c.n()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, n.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = pj0.b();
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
        bn0.a().b(this, new d(in0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        bn0.a().unregister(this);
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
        vr0 c2;
        Long n;
        if (!B()) {
            return;
        }
        this.m = new a();
        mr0 mr0Var = this.c;
        if (mr0Var != null && (c2 = mr0Var.c()) != null && (n = c2.n()) != null) {
            long longValue = n.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(mr0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        ls0 ls0Var;
        gs0 h;
        gs0 h2;
        vr0 c2;
        gr0 gr0Var;
        gr0 gr0Var2;
        gs0 h3;
        ls0 q;
        mr0 mr0Var = this.c;
        if (mr0Var != null && (h3 = mr0Var.h()) != null && (q = h3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        wr0 wr0Var = null;
        r2 = null;
        String str2 = null;
        wr0Var = null;
        if (i <= 0) {
            mr0 mr0Var2 = this.c;
            if (mr0Var2 != null && (gr0Var2 = mr0Var2.f) != null) {
                str2 = gr0Var2.d;
            }
            rp0.e(str2, "18", "18002");
            return false;
        }
        mr0 mr0Var3 = this.c;
        if (mr0Var3 != null && (gr0Var = mr0Var3.f) != null) {
            str = gr0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        mr0 mr0Var4 = this.c;
        if (mr0Var4 != null && (c2 = mr0Var4.c()) != null && c2.o() == 0) {
            return false;
        }
        mr0 mr0Var5 = this.c;
        if (mr0Var5 != null && (h2 = mr0Var5.h()) != null) {
            ls0Var = h2.q();
        } else {
            ls0Var = null;
        }
        if (ls0Var != null) {
            mr0 mr0Var6 = this.c;
            if (mr0Var6 != null && (h = mr0Var6.h()) != null) {
                wr0Var = h.f();
            }
            if (wr0Var != null) {
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
        gr0 gr0Var;
        cr0 cr0Var;
        cr0 cr0Var2;
        cr0 cr0Var3;
        cr0 cr0Var4;
        gs0 h;
        ls0 q;
        ph0 ph0Var = new ph0();
        ph0Var.a = "4";
        mr0 mr0Var = this.c;
        String str5 = null;
        if (mr0Var != null && (h = mr0Var.h()) != null && (q = h.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        ph0Var.c = String.valueOf(num);
        mr0 mr0Var2 = this.c;
        if (mr0Var2 != null && (cr0Var4 = mr0Var2.m) != null) {
            str = cr0Var4.k;
        } else {
            str = null;
        }
        ph0Var.d = str;
        mr0 mr0Var3 = this.c;
        if (mr0Var3 != null && (cr0Var3 = mr0Var3.m) != null) {
            str2 = cr0Var3.l;
        } else {
            str2 = null;
        }
        ph0Var.e = str2;
        mr0 mr0Var4 = this.c;
        if (mr0Var4 != null && (cr0Var2 = mr0Var4.m) != null) {
            str3 = cr0Var2.m;
        } else {
            str3 = null;
        }
        ph0Var.f = str3;
        mr0 mr0Var5 = this.c;
        if (mr0Var5 != null && (cr0Var = mr0Var5.m) != null) {
            str4 = cr0Var.n;
        } else {
            str4 = null;
        }
        ph0Var.g = str4;
        ph0Var.h = this.j;
        mr0 mr0Var6 = this.c;
        if (mr0Var6 != null && (gr0Var = mr0Var6.f) != null) {
            str5 = gr0Var.d;
        }
        ph0Var.i = str5;
        bn0.a().a(ph0Var);
    }

    public final void v() {
        gs0 gs0Var;
        gs0 h;
        if (this.g) {
            return;
        }
        yo0 yo0Var = this.d;
        if (!this.e || yo0Var == null || !yo0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            pp0 pp0Var = pp0.a;
            mr0 mr0Var = this.c;
            if (mr0Var != null) {
                gs0Var = mr0Var.h();
            } else {
                gs0Var = null;
            }
            gs0 gs0Var2 = gs0Var;
            String g = yo0Var.g();
            mr0 mr0Var2 = this.c;
            pp0Var.c(gs0Var2, g, (mr0Var2 == null || (h = mr0Var2.h()) == null || (r0 = h.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    gr0 gr0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    mr0 mr0Var3 = NadRewardTaskHelper.this.c;
                    if (mr0Var3 != null && (gr0Var = mr0Var3.f) != null) {
                        str2 = gr0Var.d;
                    } else {
                        str2 = null;
                    }
                    rp0.h(str2, "2", coin, null, 8, null);
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
                    gr0 gr0Var;
                    gr0 gr0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        mr0 mr0Var3 = NadRewardTaskHelper.this.c;
                        if (mr0Var3 != null && (gr0Var2 = mr0Var3.f) != null) {
                            str2 = gr0Var2.d;
                        }
                        rp0.q(str2, "2");
                        return;
                    }
                    mr0 mr0Var4 = NadRewardTaskHelper.this.c;
                    if (mr0Var4 != null && (gr0Var = mr0Var4.f) != null) {
                        str = gr0Var.d;
                    } else {
                        str = null;
                    }
                    rp0.p(str, "2", null, 4, null);
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
        cr0 cr0Var;
        String str;
        cr0 cr0Var2;
        vr0 c2;
        ph0 ph0Var = new ph0();
        ph0Var.a = "2";
        mr0 mr0Var = this.c;
        String str2 = null;
        if (mr0Var != null && (c2 = mr0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        ph0Var.b = String.valueOf(num);
        yo0 yo0Var = this.d;
        if (yo0Var != null) {
            str2 = yo0Var.h();
        }
        ph0Var.c = str2;
        mr0 mr0Var2 = this.c;
        String str3 = "";
        ph0Var.d = (mr0Var2 == null || (cr0Var2 = mr0Var2.m) == null || (r1 = cr0Var2.i) == null) ? "" : "";
        mr0 mr0Var3 = this.c;
        if (mr0Var3 != null && (cr0Var = mr0Var3.m) != null && (str = cr0Var.j) != null) {
            str3 = str;
        }
        ph0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        ph0Var.h = this.f;
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
                mr0 mr0Var4;
                vr0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (mr0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = mr0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        bn0.a().a(ph0Var);
    }

    public final void t(yo0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        gr0 gr0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            rp0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        mr0 mr0Var = this.c;
        if (mr0Var != null && (gr0Var = mr0Var.f) != null) {
            str = gr0Var.d;
        } else {
            str = null;
        }
        rp0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        gs0 h;
        ls0 ls0Var;
        wr0 wr0Var;
        gs0 gs0Var;
        ls0 ls0Var2;
        wr0 wr0Var2;
        gs0 h2;
        gs0 h3;
        gs0 h4;
        gs0 h5;
        gs0 h6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            mr0 mr0Var = this.c;
            if (mr0Var != null && (h6 = mr0Var.h()) != null) {
                ls0Var = h6.q();
            } else {
                ls0Var = null;
            }
            if (ls0Var != null) {
                mr0 mr0Var2 = this.c;
                if (mr0Var2 != null && (h5 = mr0Var2.h()) != null) {
                    wr0Var = h5.f();
                } else {
                    wr0Var = null;
                }
                if (wr0Var != null) {
                    pp0 pp0Var = pp0.a;
                    mr0 mr0Var3 = this.c;
                    if (mr0Var3 != null) {
                        gs0Var = mr0Var3.h();
                    } else {
                        gs0Var = null;
                    }
                    mr0 mr0Var4 = this.c;
                    if (mr0Var4 != null && (h4 = mr0Var4.h()) != null) {
                        ls0Var2 = h4.q();
                    } else {
                        ls0Var2 = null;
                    }
                    Intrinsics.checkNotNull(ls0Var2);
                    String a2 = ls0Var2.a();
                    mr0 mr0Var5 = this.c;
                    if (mr0Var5 != null && (h3 = mr0Var5.h()) != null) {
                        wr0Var2 = h3.f();
                    } else {
                        wr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(wr0Var2);
                    pp0Var.c(gs0Var, a2, wr0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            gs0 h7;
                            gr0 gr0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            mr0 mr0Var6 = NadRewardTaskHelper.this.c;
                            if (mr0Var6 != null && (gr0Var = mr0Var6.f) != null) {
                                str2 = gr0Var.d;
                            } else {
                                str2 = null;
                            }
                            rp0.h(str2, "4", coin, null, 8, null);
                            mr0 mr0Var7 = NadRewardTaskHelper.this.c;
                            if (mr0Var7 != null && (h7 = mr0Var7.h()) != null) {
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
                            gr0 gr0Var;
                            gr0 gr0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                mr0 mr0Var6 = NadRewardTaskHelper.this.c;
                                if (mr0Var6 != null && (gr0Var2 = mr0Var6.f) != null) {
                                    str3 = gr0Var2.d;
                                }
                                rp0.q(str3, "4");
                                return;
                            }
                            mr0 mr0Var7 = NadRewardTaskHelper.this.c;
                            if (mr0Var7 != null && (gr0Var = mr0Var7.f) != null) {
                                str2 = gr0Var.d;
                            } else {
                                str2 = null;
                            }
                            rp0.p(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    mr0 mr0Var6 = this.c;
                    if (mr0Var6 != null && (h2 = mr0Var6.h()) != null) {
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
        mr0 mr0Var7 = this.c;
        if (mr0Var7 != null && (h = mr0Var7.h()) != null) {
            str = h.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        cr0 cr0Var;
        yq0 yq0Var;
        cr0 cr0Var2;
        yq0 yq0Var2;
        mr0 mr0Var = this.c;
        PackageInfo packageInfo = null;
        if (mr0Var != null && (cr0Var2 = mr0Var.m) != null && (yq0Var2 = cr0Var2.p) != null) {
            str = yq0Var2.a;
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
            mr0 mr0Var2 = this.c;
            if (mr0Var2 != null && (cr0Var = mr0Var2.m) != null && (yq0Var = cr0Var.p) != null) {
                str2 = yq0Var.a;
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
        Object m847constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new dj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m847constructorimpl = Result.m847constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m847constructorimpl = Result.m847constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m853isFailureimpl(m847constructorimpl)) {
            m847constructorimpl = null;
        }
        String str3 = (String) m847constructorimpl;
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
        vr0 vr0Var;
        vr0 vr0Var2;
        String str;
        boolean z;
        boolean z2;
        gs0 h;
        gs0 h2;
        mr0 mr0Var = this.c;
        if ((mr0Var != null && !mr0Var.p()) || x(context)) {
            return false;
        }
        mr0 mr0Var2 = this.c;
        String str2 = null;
        if (mr0Var2 != null) {
            vr0Var = mr0Var2.c();
        } else {
            vr0Var = null;
        }
        if (vr0Var == null) {
            return false;
        }
        mr0 mr0Var3 = this.c;
        if (mr0Var3 != null) {
            vr0Var2 = mr0Var3.c();
        } else {
            vr0Var2 = null;
        }
        Intrinsics.checkNotNull(vr0Var2);
        if (vr0Var2.h() <= 0) {
            return false;
        }
        mr0 mr0Var4 = this.c;
        if (mr0Var4 != null && (h2 = mr0Var4.h()) != null) {
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
        mr0 mr0Var5 = this.c;
        if (mr0Var5 != null && (h = mr0Var5.h()) != null) {
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
