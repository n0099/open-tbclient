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
import com.baidu.tieba.bj0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.dh0;
import com.baidu.tieba.do0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.er0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.km0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.nm0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.so0;
import com.baidu.tieba.uq0;
import com.baidu.tieba.vq0;
import com.baidu.tieba.zp0;
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
    public lq0 c;
    public do0 d;
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
            er0 h;
            lq0 lq0Var = NadRewardTaskHelper.this.c;
            if (lq0Var != null && (h = lq0Var.h()) != null && h.a()) {
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
    public static final class d extends km0<nm0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.km0
        public void onEvent(nm0 event) {
            lq0 lq0Var;
            uq0 c;
            Long k;
            hq0 hq0Var;
            lq0 lq0Var2;
            uq0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (lq0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = lq0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                lq0 lq0Var3 = nadRewardTaskHelper2.c;
                if (lq0Var3 != null && (hq0Var = lq0Var3.f) != null) {
                    str = hq0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (lq0Var = NadRewardTaskHelper.this.c) != null && (c = lq0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = bj0.b();
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
        gm0.a().b(this, new d(nm0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        gm0.a().unregister(this);
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
        uq0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        lq0 lq0Var = this.c;
        if (lq0Var != null && (c2 = lq0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(lq0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        hr0 hr0Var;
        cr0 g;
        cr0 g2;
        uq0 c2;
        hq0 hq0Var;
        hq0 hq0Var2;
        cr0 g3;
        hr0 q;
        lq0 lq0Var = this.c;
        if (lq0Var != null && (g3 = lq0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        vq0 vq0Var = null;
        r2 = null;
        String str2 = null;
        vq0Var = null;
        if (i <= 0) {
            lq0 lq0Var2 = this.c;
            if (lq0Var2 != null && (hq0Var2 = lq0Var2.f) != null) {
                str2 = hq0Var2.d;
            }
            so0.e(str2, "18", "18002");
            return false;
        }
        lq0 lq0Var3 = this.c;
        if (lq0Var3 != null && (hq0Var = lq0Var3.f) != null) {
            str = hq0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        lq0 lq0Var4 = this.c;
        if (lq0Var4 != null && (c2 = lq0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        lq0 lq0Var5 = this.c;
        if (lq0Var5 != null && (g2 = lq0Var5.g()) != null) {
            hr0Var = g2.q();
        } else {
            hr0Var = null;
        }
        if (hr0Var != null) {
            lq0 lq0Var6 = this.c;
            if (lq0Var6 != null && (g = lq0Var6.g()) != null) {
                vq0Var = g.f();
            }
            if (vq0Var != null) {
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
        hq0 hq0Var;
        dq0 dq0Var;
        dq0 dq0Var2;
        dq0 dq0Var3;
        dq0 dq0Var4;
        cr0 g;
        hr0 q;
        dh0 dh0Var = new dh0();
        dh0Var.a = "4";
        lq0 lq0Var = this.c;
        String str5 = null;
        if (lq0Var != null && (g = lq0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        dh0Var.c = String.valueOf(num);
        lq0 lq0Var2 = this.c;
        if (lq0Var2 != null && (dq0Var4 = lq0Var2.m) != null) {
            str = dq0Var4.k;
        } else {
            str = null;
        }
        dh0Var.d = str;
        lq0 lq0Var3 = this.c;
        if (lq0Var3 != null && (dq0Var3 = lq0Var3.m) != null) {
            str2 = dq0Var3.l;
        } else {
            str2 = null;
        }
        dh0Var.e = str2;
        lq0 lq0Var4 = this.c;
        if (lq0Var4 != null && (dq0Var2 = lq0Var4.m) != null) {
            str3 = dq0Var2.m;
        } else {
            str3 = null;
        }
        dh0Var.f = str3;
        lq0 lq0Var5 = this.c;
        if (lq0Var5 != null && (dq0Var = lq0Var5.m) != null) {
            str4 = dq0Var.n;
        } else {
            str4 = null;
        }
        dh0Var.g = str4;
        dh0Var.h = this.j;
        lq0 lq0Var6 = this.c;
        if (lq0Var6 != null && (hq0Var = lq0Var6.f) != null) {
            str5 = hq0Var.d;
        }
        dh0Var.i = str5;
        gm0.a().a(dh0Var);
    }

    public final void v() {
        cr0 cr0Var;
        cr0 g;
        if (this.g) {
            return;
        }
        do0 do0Var = this.d;
        if (!this.e || do0Var == null || !do0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            qo0 qo0Var = qo0.a;
            lq0 lq0Var = this.c;
            if (lq0Var != null) {
                cr0Var = lq0Var.g();
            } else {
                cr0Var = null;
            }
            cr0 cr0Var2 = cr0Var;
            String g2 = do0Var.g();
            lq0 lq0Var2 = this.c;
            qo0Var.c(cr0Var2, g2, (lq0Var2 == null || (g = lq0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    hq0 hq0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    lq0 lq0Var3 = NadRewardTaskHelper.this.c;
                    if (lq0Var3 != null && (hq0Var = lq0Var3.f) != null) {
                        str2 = hq0Var.d;
                    } else {
                        str2 = null;
                    }
                    so0.g(str2, "2", coin);
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
                    hq0 hq0Var;
                    hq0 hq0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        lq0 lq0Var3 = NadRewardTaskHelper.this.c;
                        if (lq0Var3 != null && (hq0Var2 = lq0Var3.f) != null) {
                            str2 = hq0Var2.d;
                        }
                        so0.n(str2, "2");
                        return;
                    }
                    lq0 lq0Var4 = NadRewardTaskHelper.this.c;
                    if (lq0Var4 != null && (hq0Var = lq0Var4.f) != null) {
                        str = hq0Var.d;
                    } else {
                        str = null;
                    }
                    so0.m(str, "2", null, 4, null);
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
        dq0 dq0Var;
        String str;
        dq0 dq0Var2;
        uq0 c2;
        dh0 dh0Var = new dh0();
        dh0Var.a = "2";
        lq0 lq0Var = this.c;
        String str2 = null;
        if (lq0Var != null && (c2 = lq0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        dh0Var.b = String.valueOf(num);
        do0 do0Var = this.d;
        if (do0Var != null) {
            str2 = do0Var.h();
        }
        dh0Var.c = str2;
        lq0 lq0Var2 = this.c;
        String str3 = "";
        dh0Var.d = (lq0Var2 == null || (dq0Var2 = lq0Var2.m) == null || (r1 = dq0Var2.i) == null) ? "" : "";
        lq0 lq0Var3 = this.c;
        if (lq0Var3 != null && (dq0Var = lq0Var3.m) != null && (str = dq0Var.j) != null) {
            str3 = str;
        }
        dh0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        dh0Var.h = this.f;
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
                lq0 lq0Var4;
                uq0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (lq0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = lq0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        gm0.a().a(dh0Var);
    }

    public final void t(do0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        hq0 hq0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            so0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        lq0 lq0Var = this.c;
        if (lq0Var != null && (hq0Var = lq0Var.f) != null) {
            str = hq0Var.d;
        } else {
            str = null;
        }
        so0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        cr0 g;
        hr0 hr0Var;
        vq0 vq0Var;
        cr0 cr0Var;
        hr0 hr0Var2;
        vq0 vq0Var2;
        cr0 g2;
        cr0 g3;
        cr0 g4;
        cr0 g5;
        cr0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            lq0 lq0Var = this.c;
            if (lq0Var != null && (g6 = lq0Var.g()) != null) {
                hr0Var = g6.q();
            } else {
                hr0Var = null;
            }
            if (hr0Var != null) {
                lq0 lq0Var2 = this.c;
                if (lq0Var2 != null && (g5 = lq0Var2.g()) != null) {
                    vq0Var = g5.f();
                } else {
                    vq0Var = null;
                }
                if (vq0Var != null) {
                    qo0 qo0Var = qo0.a;
                    lq0 lq0Var3 = this.c;
                    if (lq0Var3 != null) {
                        cr0Var = lq0Var3.g();
                    } else {
                        cr0Var = null;
                    }
                    lq0 lq0Var4 = this.c;
                    if (lq0Var4 != null && (g4 = lq0Var4.g()) != null) {
                        hr0Var2 = g4.q();
                    } else {
                        hr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(hr0Var2);
                    String a2 = hr0Var2.a();
                    lq0 lq0Var5 = this.c;
                    if (lq0Var5 != null && (g3 = lq0Var5.g()) != null) {
                        vq0Var2 = g3.f();
                    } else {
                        vq0Var2 = null;
                    }
                    Intrinsics.checkNotNull(vq0Var2);
                    qo0Var.c(cr0Var, a2, vq0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            cr0 g7;
                            hq0 hq0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            lq0 lq0Var6 = NadRewardTaskHelper.this.c;
                            if (lq0Var6 != null && (hq0Var = lq0Var6.f) != null) {
                                str2 = hq0Var.d;
                            } else {
                                str2 = null;
                            }
                            so0.g(str2, "4", coin);
                            lq0 lq0Var7 = NadRewardTaskHelper.this.c;
                            if (lq0Var7 != null && (g7 = lq0Var7.g()) != null) {
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
                            hq0 hq0Var;
                            hq0 hq0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                lq0 lq0Var6 = NadRewardTaskHelper.this.c;
                                if (lq0Var6 != null && (hq0Var2 = lq0Var6.f) != null) {
                                    str3 = hq0Var2.d;
                                }
                                so0.n(str3, "4");
                                return;
                            }
                            lq0 lq0Var7 = NadRewardTaskHelper.this.c;
                            if (lq0Var7 != null && (hq0Var = lq0Var7.f) != null) {
                                str2 = hq0Var.d;
                            } else {
                                str2 = null;
                            }
                            so0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    lq0 lq0Var6 = this.c;
                    if (lq0Var6 != null && (g2 = lq0Var6.g()) != null) {
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
        lq0 lq0Var7 = this.c;
        if (lq0Var7 != null && (g = lq0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        dq0 dq0Var;
        zp0 zp0Var;
        dq0 dq0Var2;
        zp0 zp0Var2;
        lq0 lq0Var = this.c;
        PackageInfo packageInfo = null;
        if (lq0Var != null && (dq0Var2 = lq0Var.m) != null && (zp0Var2 = dq0Var2.p) != null) {
            str = zp0Var2.a;
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
            lq0 lq0Var2 = this.c;
            if (lq0Var2 != null && (dq0Var = lq0Var2.m) != null && (zp0Var = dq0Var.p) != null) {
                str2 = zp0Var.a;
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
        Object m789constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new pi0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m789constructorimpl = Result.m789constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m789constructorimpl = Result.m789constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m795isFailureimpl(m789constructorimpl)) {
            m789constructorimpl = null;
        }
        String str3 = (String) m789constructorimpl;
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
        uq0 uq0Var;
        uq0 uq0Var2;
        String str;
        boolean z;
        boolean z2;
        cr0 g;
        cr0 g2;
        lq0 lq0Var = this.c;
        if ((lq0Var != null && !lq0Var.m()) || x(context)) {
            return false;
        }
        lq0 lq0Var2 = this.c;
        String str2 = null;
        if (lq0Var2 != null) {
            uq0Var = lq0Var2.c();
        } else {
            uq0Var = null;
        }
        if (uq0Var == null) {
            return false;
        }
        lq0 lq0Var3 = this.c;
        if (lq0Var3 != null) {
            uq0Var2 = lq0Var3.c();
        } else {
            uq0Var2 = null;
        }
        Intrinsics.checkNotNull(uq0Var2);
        if (uq0Var2.h() <= 0) {
            return false;
        }
        lq0 lq0Var4 = this.c;
        if (lq0Var4 != null && (g2 = lq0Var4.g()) != null) {
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
        lq0 lq0Var5 = this.c;
        if (lq0Var5 != null && (g = lq0Var5.g()) != null) {
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
