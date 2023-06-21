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
import com.baidu.tieba.aq0;
import com.baidu.tieba.cq0;
import com.baidu.tieba.es0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.ni0;
import com.baidu.tieba.np0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.os0;
import com.baidu.tieba.qn0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.rs0;
import com.baidu.tieba.un0;
import com.baidu.tieba.vr0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.zj0;
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
    public vr0 c;
    public np0 d;
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
            os0 h;
            vr0 vr0Var = NadRewardTaskHelper.this.c;
            if (vr0Var != null && (h = vr0Var.h()) != null && h.a()) {
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
    public static final class d extends un0<xn0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.un0
        public void onEvent(xn0 event) {
            vr0 vr0Var;
            es0 c;
            Long k;
            rr0 rr0Var;
            vr0 vr0Var2;
            es0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (vr0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = vr0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                vr0 vr0Var3 = nadRewardTaskHelper2.c;
                if (vr0Var3 != null && (rr0Var = vr0Var3.f) != null) {
                    str = rr0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (vr0Var = NadRewardTaskHelper.this.c) != null && (c = vr0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = lk0.b();
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
        qn0.a().b(this, new d(xn0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        qn0.a().unregister(this);
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
        es0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        vr0 vr0Var = this.c;
        if (vr0Var != null && (c2 = vr0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(vr0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        rs0 rs0Var;
        ms0 g;
        ms0 g2;
        es0 c2;
        rr0 rr0Var;
        rr0 rr0Var2;
        ms0 g3;
        rs0 q;
        vr0 vr0Var = this.c;
        if (vr0Var != null && (g3 = vr0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        fs0 fs0Var = null;
        r2 = null;
        String str2 = null;
        fs0Var = null;
        if (i <= 0) {
            vr0 vr0Var2 = this.c;
            if (vr0Var2 != null && (rr0Var2 = vr0Var2.f) != null) {
                str2 = rr0Var2.d;
            }
            cq0.e(str2, "18", "18002");
            return false;
        }
        vr0 vr0Var3 = this.c;
        if (vr0Var3 != null && (rr0Var = vr0Var3.f) != null) {
            str = rr0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        vr0 vr0Var4 = this.c;
        if (vr0Var4 != null && (c2 = vr0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        vr0 vr0Var5 = this.c;
        if (vr0Var5 != null && (g2 = vr0Var5.g()) != null) {
            rs0Var = g2.q();
        } else {
            rs0Var = null;
        }
        if (rs0Var != null) {
            vr0 vr0Var6 = this.c;
            if (vr0Var6 != null && (g = vr0Var6.g()) != null) {
                fs0Var = g.f();
            }
            if (fs0Var != null) {
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
        rr0 rr0Var;
        nr0 nr0Var;
        nr0 nr0Var2;
        nr0 nr0Var3;
        nr0 nr0Var4;
        ms0 g;
        rs0 q;
        ni0 ni0Var = new ni0();
        ni0Var.a = "4";
        vr0 vr0Var = this.c;
        String str5 = null;
        if (vr0Var != null && (g = vr0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        ni0Var.c = String.valueOf(num);
        vr0 vr0Var2 = this.c;
        if (vr0Var2 != null && (nr0Var4 = vr0Var2.m) != null) {
            str = nr0Var4.k;
        } else {
            str = null;
        }
        ni0Var.d = str;
        vr0 vr0Var3 = this.c;
        if (vr0Var3 != null && (nr0Var3 = vr0Var3.m) != null) {
            str2 = nr0Var3.l;
        } else {
            str2 = null;
        }
        ni0Var.e = str2;
        vr0 vr0Var4 = this.c;
        if (vr0Var4 != null && (nr0Var2 = vr0Var4.m) != null) {
            str3 = nr0Var2.m;
        } else {
            str3 = null;
        }
        ni0Var.f = str3;
        vr0 vr0Var5 = this.c;
        if (vr0Var5 != null && (nr0Var = vr0Var5.m) != null) {
            str4 = nr0Var.n;
        } else {
            str4 = null;
        }
        ni0Var.g = str4;
        ni0Var.h = this.j;
        vr0 vr0Var6 = this.c;
        if (vr0Var6 != null && (rr0Var = vr0Var6.f) != null) {
            str5 = rr0Var.d;
        }
        ni0Var.i = str5;
        qn0.a().a(ni0Var);
    }

    public final void v() {
        ms0 ms0Var;
        ms0 g;
        if (this.g) {
            return;
        }
        np0 np0Var = this.d;
        if (!this.e || np0Var == null || !np0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            aq0 aq0Var = aq0.a;
            vr0 vr0Var = this.c;
            if (vr0Var != null) {
                ms0Var = vr0Var.g();
            } else {
                ms0Var = null;
            }
            ms0 ms0Var2 = ms0Var;
            String g2 = np0Var.g();
            vr0 vr0Var2 = this.c;
            aq0Var.c(ms0Var2, g2, (vr0Var2 == null || (g = vr0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    rr0 rr0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    vr0 vr0Var3 = NadRewardTaskHelper.this.c;
                    if (vr0Var3 != null && (rr0Var = vr0Var3.f) != null) {
                        str2 = rr0Var.d;
                    } else {
                        str2 = null;
                    }
                    cq0.g(str2, "2", coin);
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
                    rr0 rr0Var;
                    rr0 rr0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        vr0 vr0Var3 = NadRewardTaskHelper.this.c;
                        if (vr0Var3 != null && (rr0Var2 = vr0Var3.f) != null) {
                            str2 = rr0Var2.d;
                        }
                        cq0.n(str2, "2");
                        return;
                    }
                    vr0 vr0Var4 = NadRewardTaskHelper.this.c;
                    if (vr0Var4 != null && (rr0Var = vr0Var4.f) != null) {
                        str = rr0Var.d;
                    } else {
                        str = null;
                    }
                    cq0.m(str, "2", null, 4, null);
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
        nr0 nr0Var;
        String str;
        nr0 nr0Var2;
        es0 c2;
        ni0 ni0Var = new ni0();
        ni0Var.a = "2";
        vr0 vr0Var = this.c;
        String str2 = null;
        if (vr0Var != null && (c2 = vr0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        ni0Var.b = String.valueOf(num);
        np0 np0Var = this.d;
        if (np0Var != null) {
            str2 = np0Var.h();
        }
        ni0Var.c = str2;
        vr0 vr0Var2 = this.c;
        String str3 = "";
        ni0Var.d = (vr0Var2 == null || (nr0Var2 = vr0Var2.m) == null || (r1 = nr0Var2.i) == null) ? "" : "";
        vr0 vr0Var3 = this.c;
        if (vr0Var3 != null && (nr0Var = vr0Var3.m) != null && (str = nr0Var.j) != null) {
            str3 = str;
        }
        ni0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        ni0Var.h = this.f;
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
                vr0 vr0Var4;
                es0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (vr0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = vr0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        qn0.a().a(ni0Var);
    }

    public final void t(np0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        rr0 rr0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cq0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        vr0 vr0Var = this.c;
        if (vr0Var != null && (rr0Var = vr0Var.f) != null) {
            str = rr0Var.d;
        } else {
            str = null;
        }
        cq0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        ms0 g;
        rs0 rs0Var;
        fs0 fs0Var;
        ms0 ms0Var;
        rs0 rs0Var2;
        fs0 fs0Var2;
        ms0 g2;
        ms0 g3;
        ms0 g4;
        ms0 g5;
        ms0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            vr0 vr0Var = this.c;
            if (vr0Var != null && (g6 = vr0Var.g()) != null) {
                rs0Var = g6.q();
            } else {
                rs0Var = null;
            }
            if (rs0Var != null) {
                vr0 vr0Var2 = this.c;
                if (vr0Var2 != null && (g5 = vr0Var2.g()) != null) {
                    fs0Var = g5.f();
                } else {
                    fs0Var = null;
                }
                if (fs0Var != null) {
                    aq0 aq0Var = aq0.a;
                    vr0 vr0Var3 = this.c;
                    if (vr0Var3 != null) {
                        ms0Var = vr0Var3.g();
                    } else {
                        ms0Var = null;
                    }
                    vr0 vr0Var4 = this.c;
                    if (vr0Var4 != null && (g4 = vr0Var4.g()) != null) {
                        rs0Var2 = g4.q();
                    } else {
                        rs0Var2 = null;
                    }
                    Intrinsics.checkNotNull(rs0Var2);
                    String a2 = rs0Var2.a();
                    vr0 vr0Var5 = this.c;
                    if (vr0Var5 != null && (g3 = vr0Var5.g()) != null) {
                        fs0Var2 = g3.f();
                    } else {
                        fs0Var2 = null;
                    }
                    Intrinsics.checkNotNull(fs0Var2);
                    aq0Var.c(ms0Var, a2, fs0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            ms0 g7;
                            rr0 rr0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            vr0 vr0Var6 = NadRewardTaskHelper.this.c;
                            if (vr0Var6 != null && (rr0Var = vr0Var6.f) != null) {
                                str2 = rr0Var.d;
                            } else {
                                str2 = null;
                            }
                            cq0.g(str2, "4", coin);
                            vr0 vr0Var7 = NadRewardTaskHelper.this.c;
                            if (vr0Var7 != null && (g7 = vr0Var7.g()) != null) {
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
                            rr0 rr0Var;
                            rr0 rr0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                vr0 vr0Var6 = NadRewardTaskHelper.this.c;
                                if (vr0Var6 != null && (rr0Var2 = vr0Var6.f) != null) {
                                    str3 = rr0Var2.d;
                                }
                                cq0.n(str3, "4");
                                return;
                            }
                            vr0 vr0Var7 = NadRewardTaskHelper.this.c;
                            if (vr0Var7 != null && (rr0Var = vr0Var7.f) != null) {
                                str2 = rr0Var.d;
                            } else {
                                str2 = null;
                            }
                            cq0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    vr0 vr0Var6 = this.c;
                    if (vr0Var6 != null && (g2 = vr0Var6.g()) != null) {
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
        vr0 vr0Var7 = this.c;
        if (vr0Var7 != null && (g = vr0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        nr0 nr0Var;
        jr0 jr0Var;
        nr0 nr0Var2;
        jr0 jr0Var2;
        vr0 vr0Var = this.c;
        PackageInfo packageInfo = null;
        if (vr0Var != null && (nr0Var2 = vr0Var.m) != null && (jr0Var2 = nr0Var2.p) != null) {
            str = jr0Var2.a;
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
            vr0 vr0Var2 = this.c;
            if (vr0Var2 != null && (nr0Var = vr0Var2.m) != null && (jr0Var = nr0Var.p) != null) {
                str2 = jr0Var.a;
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
        Object m844constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new zj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m844constructorimpl = Result.m844constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m844constructorimpl = Result.m844constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m850isFailureimpl(m844constructorimpl)) {
            m844constructorimpl = null;
        }
        String str3 = (String) m844constructorimpl;
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
        es0 es0Var;
        es0 es0Var2;
        String str;
        boolean z;
        boolean z2;
        ms0 g;
        ms0 g2;
        vr0 vr0Var = this.c;
        if ((vr0Var != null && !vr0Var.m()) || x(context)) {
            return false;
        }
        vr0 vr0Var2 = this.c;
        String str2 = null;
        if (vr0Var2 != null) {
            es0Var = vr0Var2.c();
        } else {
            es0Var = null;
        }
        if (es0Var == null) {
            return false;
        }
        vr0 vr0Var3 = this.c;
        if (vr0Var3 != null) {
            es0Var2 = vr0Var3.c();
        } else {
            es0Var2 = null;
        }
        Intrinsics.checkNotNull(es0Var2);
        if (es0Var2.h() <= 0) {
            return false;
        }
        vr0 vr0Var4 = this.c;
        if (vr0Var4 != null && (g2 = vr0Var4.g()) != null) {
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
        vr0 vr0Var5 = this.c;
        if (vr0Var5 != null && (g = vr0Var5.g()) != null) {
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
