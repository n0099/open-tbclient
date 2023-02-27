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
import com.baidu.tieba.an0;
import com.baidu.tieba.br0;
import com.baidu.tieba.dn0;
import com.baidu.tieba.fj0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.ip0;
import com.baidu.tieba.kr0;
import com.baidu.tieba.lr0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.rj0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.th0;
import com.baidu.tieba.to0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.xr0;
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
    public br0 c;
    public to0 d;
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
            ur0 h;
            br0 br0Var = NadRewardTaskHelper.this.c;
            if (br0Var != null && (h = br0Var.h()) != null && h.a()) {
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
    public static final class d extends an0<dn0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.an0
        public void onEvent(dn0 event) {
            br0 br0Var;
            kr0 c;
            Long k;
            xq0 xq0Var;
            br0 br0Var2;
            kr0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (br0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = br0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                br0 br0Var3 = nadRewardTaskHelper2.c;
                if (br0Var3 != null && (xq0Var = br0Var3.f) != null) {
                    str = xq0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (br0Var = NadRewardTaskHelper.this.c) != null && (c = br0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = rj0.b();
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
        wm0.a().b(this, new d(dn0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        wm0.a().unregister(this);
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
        kr0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        br0 br0Var = this.c;
        if (br0Var != null && (c2 = br0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(br0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        xr0 xr0Var;
        sr0 g;
        sr0 g2;
        kr0 c2;
        xq0 xq0Var;
        xq0 xq0Var2;
        sr0 g3;
        xr0 q;
        br0 br0Var = this.c;
        if (br0Var != null && (g3 = br0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        lr0 lr0Var = null;
        r2 = null;
        String str2 = null;
        lr0Var = null;
        if (i <= 0) {
            br0 br0Var2 = this.c;
            if (br0Var2 != null && (xq0Var2 = br0Var2.f) != null) {
                str2 = xq0Var2.d;
            }
            ip0.e(str2, "18", "18002");
            return false;
        }
        br0 br0Var3 = this.c;
        if (br0Var3 != null && (xq0Var = br0Var3.f) != null) {
            str = xq0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        br0 br0Var4 = this.c;
        if (br0Var4 != null && (c2 = br0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        br0 br0Var5 = this.c;
        if (br0Var5 != null && (g2 = br0Var5.g()) != null) {
            xr0Var = g2.q();
        } else {
            xr0Var = null;
        }
        if (xr0Var != null) {
            br0 br0Var6 = this.c;
            if (br0Var6 != null && (g = br0Var6.g()) != null) {
                lr0Var = g.f();
            }
            if (lr0Var != null) {
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
        xq0 xq0Var;
        tq0 tq0Var;
        tq0 tq0Var2;
        tq0 tq0Var3;
        tq0 tq0Var4;
        sr0 g;
        xr0 q;
        th0 th0Var = new th0();
        th0Var.a = "4";
        br0 br0Var = this.c;
        String str5 = null;
        if (br0Var != null && (g = br0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        th0Var.c = String.valueOf(num);
        br0 br0Var2 = this.c;
        if (br0Var2 != null && (tq0Var4 = br0Var2.m) != null) {
            str = tq0Var4.k;
        } else {
            str = null;
        }
        th0Var.d = str;
        br0 br0Var3 = this.c;
        if (br0Var3 != null && (tq0Var3 = br0Var3.m) != null) {
            str2 = tq0Var3.l;
        } else {
            str2 = null;
        }
        th0Var.e = str2;
        br0 br0Var4 = this.c;
        if (br0Var4 != null && (tq0Var2 = br0Var4.m) != null) {
            str3 = tq0Var2.m;
        } else {
            str3 = null;
        }
        th0Var.f = str3;
        br0 br0Var5 = this.c;
        if (br0Var5 != null && (tq0Var = br0Var5.m) != null) {
            str4 = tq0Var.n;
        } else {
            str4 = null;
        }
        th0Var.g = str4;
        th0Var.h = this.j;
        br0 br0Var6 = this.c;
        if (br0Var6 != null && (xq0Var = br0Var6.f) != null) {
            str5 = xq0Var.d;
        }
        th0Var.i = str5;
        wm0.a().a(th0Var);
    }

    public final void v() {
        sr0 sr0Var;
        sr0 g;
        if (this.g) {
            return;
        }
        to0 to0Var = this.d;
        if (!this.e || to0Var == null || !to0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            gp0 gp0Var = gp0.a;
            br0 br0Var = this.c;
            if (br0Var != null) {
                sr0Var = br0Var.g();
            } else {
                sr0Var = null;
            }
            sr0 sr0Var2 = sr0Var;
            String g2 = to0Var.g();
            br0 br0Var2 = this.c;
            gp0Var.c(sr0Var2, g2, (br0Var2 == null || (g = br0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    xq0 xq0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    br0 br0Var3 = NadRewardTaskHelper.this.c;
                    if (br0Var3 != null && (xq0Var = br0Var3.f) != null) {
                        str2 = xq0Var.d;
                    } else {
                        str2 = null;
                    }
                    ip0.g(str2, "2", coin);
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
                    xq0 xq0Var;
                    xq0 xq0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        br0 br0Var3 = NadRewardTaskHelper.this.c;
                        if (br0Var3 != null && (xq0Var2 = br0Var3.f) != null) {
                            str2 = xq0Var2.d;
                        }
                        ip0.n(str2, "2");
                        return;
                    }
                    br0 br0Var4 = NadRewardTaskHelper.this.c;
                    if (br0Var4 != null && (xq0Var = br0Var4.f) != null) {
                        str = xq0Var.d;
                    } else {
                        str = null;
                    }
                    ip0.m(str, "2", null, 4, null);
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
        tq0 tq0Var;
        String str;
        tq0 tq0Var2;
        kr0 c2;
        th0 th0Var = new th0();
        th0Var.a = "2";
        br0 br0Var = this.c;
        String str2 = null;
        if (br0Var != null && (c2 = br0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        th0Var.b = String.valueOf(num);
        to0 to0Var = this.d;
        if (to0Var != null) {
            str2 = to0Var.h();
        }
        th0Var.c = str2;
        br0 br0Var2 = this.c;
        String str3 = "";
        th0Var.d = (br0Var2 == null || (tq0Var2 = br0Var2.m) == null || (r1 = tq0Var2.i) == null) ? "" : "";
        br0 br0Var3 = this.c;
        if (br0Var3 != null && (tq0Var = br0Var3.m) != null && (str = tq0Var.j) != null) {
            str3 = str;
        }
        th0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        th0Var.h = this.f;
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
                br0 br0Var4;
                kr0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (br0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = br0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        wm0.a().a(th0Var);
    }

    public final void t(to0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        xq0 xq0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ip0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        br0 br0Var = this.c;
        if (br0Var != null && (xq0Var = br0Var.f) != null) {
            str = xq0Var.d;
        } else {
            str = null;
        }
        ip0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        sr0 g;
        xr0 xr0Var;
        lr0 lr0Var;
        sr0 sr0Var;
        xr0 xr0Var2;
        lr0 lr0Var2;
        sr0 g2;
        sr0 g3;
        sr0 g4;
        sr0 g5;
        sr0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            br0 br0Var = this.c;
            if (br0Var != null && (g6 = br0Var.g()) != null) {
                xr0Var = g6.q();
            } else {
                xr0Var = null;
            }
            if (xr0Var != null) {
                br0 br0Var2 = this.c;
                if (br0Var2 != null && (g5 = br0Var2.g()) != null) {
                    lr0Var = g5.f();
                } else {
                    lr0Var = null;
                }
                if (lr0Var != null) {
                    gp0 gp0Var = gp0.a;
                    br0 br0Var3 = this.c;
                    if (br0Var3 != null) {
                        sr0Var = br0Var3.g();
                    } else {
                        sr0Var = null;
                    }
                    br0 br0Var4 = this.c;
                    if (br0Var4 != null && (g4 = br0Var4.g()) != null) {
                        xr0Var2 = g4.q();
                    } else {
                        xr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(xr0Var2);
                    String a2 = xr0Var2.a();
                    br0 br0Var5 = this.c;
                    if (br0Var5 != null && (g3 = br0Var5.g()) != null) {
                        lr0Var2 = g3.f();
                    } else {
                        lr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(lr0Var2);
                    gp0Var.c(sr0Var, a2, lr0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            sr0 g7;
                            xq0 xq0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            br0 br0Var6 = NadRewardTaskHelper.this.c;
                            if (br0Var6 != null && (xq0Var = br0Var6.f) != null) {
                                str2 = xq0Var.d;
                            } else {
                                str2 = null;
                            }
                            ip0.g(str2, "4", coin);
                            br0 br0Var7 = NadRewardTaskHelper.this.c;
                            if (br0Var7 != null && (g7 = br0Var7.g()) != null) {
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
                            xq0 xq0Var;
                            xq0 xq0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                br0 br0Var6 = NadRewardTaskHelper.this.c;
                                if (br0Var6 != null && (xq0Var2 = br0Var6.f) != null) {
                                    str3 = xq0Var2.d;
                                }
                                ip0.n(str3, "4");
                                return;
                            }
                            br0 br0Var7 = NadRewardTaskHelper.this.c;
                            if (br0Var7 != null && (xq0Var = br0Var7.f) != null) {
                                str2 = xq0Var.d;
                            } else {
                                str2 = null;
                            }
                            ip0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    br0 br0Var6 = this.c;
                    if (br0Var6 != null && (g2 = br0Var6.g()) != null) {
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
        br0 br0Var7 = this.c;
        if (br0Var7 != null && (g = br0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        tq0 tq0Var;
        pq0 pq0Var;
        tq0 tq0Var2;
        pq0 pq0Var2;
        br0 br0Var = this.c;
        PackageInfo packageInfo = null;
        if (br0Var != null && (tq0Var2 = br0Var.m) != null && (pq0Var2 = tq0Var2.p) != null) {
            str = pq0Var2.a;
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
            br0 br0Var2 = this.c;
            if (br0Var2 != null && (tq0Var = br0Var2.m) != null && (pq0Var = tq0Var.p) != null) {
                str2 = pq0Var.a;
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
        Object m766constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new fj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m766constructorimpl = Result.m766constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m766constructorimpl = Result.m766constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m772isFailureimpl(m766constructorimpl)) {
            m766constructorimpl = null;
        }
        String str3 = (String) m766constructorimpl;
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
        kr0 kr0Var;
        kr0 kr0Var2;
        String str;
        boolean z;
        boolean z2;
        sr0 g;
        sr0 g2;
        br0 br0Var = this.c;
        if ((br0Var != null && !br0Var.m()) || x(context)) {
            return false;
        }
        br0 br0Var2 = this.c;
        String str2 = null;
        if (br0Var2 != null) {
            kr0Var = br0Var2.c();
        } else {
            kr0Var = null;
        }
        if (kr0Var == null) {
            return false;
        }
        br0 br0Var3 = this.c;
        if (br0Var3 != null) {
            kr0Var2 = br0Var3.c();
        } else {
            kr0Var2 = null;
        }
        Intrinsics.checkNotNull(kr0Var2);
        if (kr0Var2.h() <= 0) {
            return false;
        }
        br0 br0Var4 = this.c;
        if (br0Var4 != null && (g2 = br0Var4.g()) != null) {
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
        br0 br0Var5 = this.c;
        if (br0Var5 != null && (g = br0Var5.g()) != null) {
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
