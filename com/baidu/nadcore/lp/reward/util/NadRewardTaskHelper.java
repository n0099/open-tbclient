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
import com.baidu.tieba.bp0;
import com.baidu.tieba.br0;
import com.baidu.tieba.en0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gj0;
import com.baidu.tieba.in0;
import com.baidu.tieba.jr0;
import com.baidu.tieba.js0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.os0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.sj0;
import com.baidu.tieba.sp0;
import com.baidu.tieba.up0;
import com.baidu.tieba.yr0;
import com.baidu.tieba.zr0;
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
    public pr0 c;
    public bp0 d;
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
            ls0 j;
            pr0 pr0Var = NadRewardTaskHelper.this.c;
            if (pr0Var != null && (j = pr0Var.j()) != null && j.a()) {
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
    public static final class d extends in0<ln0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.in0
        public void onEvent(ln0 event) {
            pr0 pr0Var;
            yr0 c;
            Long n;
            jr0 jr0Var;
            pr0 pr0Var2;
            yr0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (pr0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = pr0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                pr0 pr0Var3 = nadRewardTaskHelper2.c;
                if (pr0Var3 != null && (jr0Var = pr0Var3.f) != null) {
                    str = jr0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (pr0Var = NadRewardTaskHelper.this.c) != null && (c = pr0Var.c()) != null && (n = c.n()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, n.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = sj0.b();
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
        en0.a().b(this, new d(ln0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        en0.a().unregister(this);
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
        yr0 c2;
        Long n;
        if (!B()) {
            return;
        }
        this.m = new a();
        pr0 pr0Var = this.c;
        if (pr0Var != null && (c2 = pr0Var.c()) != null && (n = c2.n()) != null) {
            long longValue = n.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(pr0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        os0 os0Var;
        js0 h;
        js0 h2;
        yr0 c2;
        jr0 jr0Var;
        jr0 jr0Var2;
        js0 h3;
        os0 q;
        pr0 pr0Var = this.c;
        if (pr0Var != null && (h3 = pr0Var.h()) != null && (q = h3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        zr0 zr0Var = null;
        r2 = null;
        String str2 = null;
        zr0Var = null;
        if (i <= 0) {
            pr0 pr0Var2 = this.c;
            if (pr0Var2 != null && (jr0Var2 = pr0Var2.f) != null) {
                str2 = jr0Var2.d;
            }
            up0.e(str2, "18", "18002");
            return false;
        }
        pr0 pr0Var3 = this.c;
        if (pr0Var3 != null && (jr0Var = pr0Var3.f) != null) {
            str = jr0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        pr0 pr0Var4 = this.c;
        if (pr0Var4 != null && (c2 = pr0Var4.c()) != null && c2.o() == 0) {
            return false;
        }
        pr0 pr0Var5 = this.c;
        if (pr0Var5 != null && (h2 = pr0Var5.h()) != null) {
            os0Var = h2.q();
        } else {
            os0Var = null;
        }
        if (os0Var != null) {
            pr0 pr0Var6 = this.c;
            if (pr0Var6 != null && (h = pr0Var6.h()) != null) {
                zr0Var = h.f();
            }
            if (zr0Var != null) {
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
        jr0 jr0Var;
        fr0 fr0Var;
        fr0 fr0Var2;
        fr0 fr0Var3;
        fr0 fr0Var4;
        js0 h;
        os0 q;
        sh0 sh0Var = new sh0();
        sh0Var.a = "4";
        pr0 pr0Var = this.c;
        String str5 = null;
        if (pr0Var != null && (h = pr0Var.h()) != null && (q = h.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        sh0Var.c = String.valueOf(num);
        pr0 pr0Var2 = this.c;
        if (pr0Var2 != null && (fr0Var4 = pr0Var2.m) != null) {
            str = fr0Var4.k;
        } else {
            str = null;
        }
        sh0Var.d = str;
        pr0 pr0Var3 = this.c;
        if (pr0Var3 != null && (fr0Var3 = pr0Var3.m) != null) {
            str2 = fr0Var3.l;
        } else {
            str2 = null;
        }
        sh0Var.e = str2;
        pr0 pr0Var4 = this.c;
        if (pr0Var4 != null && (fr0Var2 = pr0Var4.m) != null) {
            str3 = fr0Var2.m;
        } else {
            str3 = null;
        }
        sh0Var.f = str3;
        pr0 pr0Var5 = this.c;
        if (pr0Var5 != null && (fr0Var = pr0Var5.m) != null) {
            str4 = fr0Var.n;
        } else {
            str4 = null;
        }
        sh0Var.g = str4;
        sh0Var.h = this.j;
        pr0 pr0Var6 = this.c;
        if (pr0Var6 != null && (jr0Var = pr0Var6.f) != null) {
            str5 = jr0Var.d;
        }
        sh0Var.i = str5;
        en0.a().a(sh0Var);
    }

    public final void v() {
        js0 js0Var;
        js0 h;
        if (this.g) {
            return;
        }
        bp0 bp0Var = this.d;
        if (!this.e || bp0Var == null || !bp0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            sp0 sp0Var = sp0.a;
            pr0 pr0Var = this.c;
            if (pr0Var != null) {
                js0Var = pr0Var.h();
            } else {
                js0Var = null;
            }
            js0 js0Var2 = js0Var;
            String g = bp0Var.g();
            pr0 pr0Var2 = this.c;
            sp0Var.c(js0Var2, g, (pr0Var2 == null || (h = pr0Var2.h()) == null || (r0 = h.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    jr0 jr0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    pr0 pr0Var3 = NadRewardTaskHelper.this.c;
                    if (pr0Var3 != null && (jr0Var = pr0Var3.f) != null) {
                        str2 = jr0Var.d;
                    } else {
                        str2 = null;
                    }
                    up0.h(str2, "2", coin, null, 8, null);
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
                    jr0 jr0Var;
                    jr0 jr0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        pr0 pr0Var3 = NadRewardTaskHelper.this.c;
                        if (pr0Var3 != null && (jr0Var2 = pr0Var3.f) != null) {
                            str2 = jr0Var2.d;
                        }
                        up0.q(str2, "2");
                        return;
                    }
                    pr0 pr0Var4 = NadRewardTaskHelper.this.c;
                    if (pr0Var4 != null && (jr0Var = pr0Var4.f) != null) {
                        str = jr0Var.d;
                    } else {
                        str = null;
                    }
                    up0.p(str, "2", null, 4, null);
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
        fr0 fr0Var;
        String str;
        fr0 fr0Var2;
        yr0 c2;
        sh0 sh0Var = new sh0();
        sh0Var.a = "2";
        pr0 pr0Var = this.c;
        String str2 = null;
        if (pr0Var != null && (c2 = pr0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        sh0Var.b = String.valueOf(num);
        bp0 bp0Var = this.d;
        if (bp0Var != null) {
            str2 = bp0Var.h();
        }
        sh0Var.c = str2;
        pr0 pr0Var2 = this.c;
        String str3 = "";
        sh0Var.d = (pr0Var2 == null || (fr0Var2 = pr0Var2.m) == null || (r1 = fr0Var2.i) == null) ? "" : "";
        pr0 pr0Var3 = this.c;
        if (pr0Var3 != null && (fr0Var = pr0Var3.m) != null && (str = fr0Var.j) != null) {
            str3 = str;
        }
        sh0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        sh0Var.h = this.f;
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
                pr0 pr0Var4;
                yr0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (pr0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = pr0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        en0.a().a(sh0Var);
    }

    public final void t(bp0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        jr0 jr0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            up0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        pr0 pr0Var = this.c;
        if (pr0Var != null && (jr0Var = pr0Var.f) != null) {
            str = jr0Var.d;
        } else {
            str = null;
        }
        up0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        js0 h;
        os0 os0Var;
        zr0 zr0Var;
        js0 js0Var;
        os0 os0Var2;
        zr0 zr0Var2;
        js0 h2;
        js0 h3;
        js0 h4;
        js0 h5;
        js0 h6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            pr0 pr0Var = this.c;
            if (pr0Var != null && (h6 = pr0Var.h()) != null) {
                os0Var = h6.q();
            } else {
                os0Var = null;
            }
            if (os0Var != null) {
                pr0 pr0Var2 = this.c;
                if (pr0Var2 != null && (h5 = pr0Var2.h()) != null) {
                    zr0Var = h5.f();
                } else {
                    zr0Var = null;
                }
                if (zr0Var != null) {
                    sp0 sp0Var = sp0.a;
                    pr0 pr0Var3 = this.c;
                    if (pr0Var3 != null) {
                        js0Var = pr0Var3.h();
                    } else {
                        js0Var = null;
                    }
                    pr0 pr0Var4 = this.c;
                    if (pr0Var4 != null && (h4 = pr0Var4.h()) != null) {
                        os0Var2 = h4.q();
                    } else {
                        os0Var2 = null;
                    }
                    Intrinsics.checkNotNull(os0Var2);
                    String a2 = os0Var2.a();
                    pr0 pr0Var5 = this.c;
                    if (pr0Var5 != null && (h3 = pr0Var5.h()) != null) {
                        zr0Var2 = h3.f();
                    } else {
                        zr0Var2 = null;
                    }
                    Intrinsics.checkNotNull(zr0Var2);
                    sp0Var.c(js0Var, a2, zr0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            js0 h7;
                            jr0 jr0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            pr0 pr0Var6 = NadRewardTaskHelper.this.c;
                            if (pr0Var6 != null && (jr0Var = pr0Var6.f) != null) {
                                str2 = jr0Var.d;
                            } else {
                                str2 = null;
                            }
                            up0.h(str2, "4", coin, null, 8, null);
                            pr0 pr0Var7 = NadRewardTaskHelper.this.c;
                            if (pr0Var7 != null && (h7 = pr0Var7.h()) != null) {
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
                            jr0 jr0Var;
                            jr0 jr0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                pr0 pr0Var6 = NadRewardTaskHelper.this.c;
                                if (pr0Var6 != null && (jr0Var2 = pr0Var6.f) != null) {
                                    str3 = jr0Var2.d;
                                }
                                up0.q(str3, "4");
                                return;
                            }
                            pr0 pr0Var7 = NadRewardTaskHelper.this.c;
                            if (pr0Var7 != null && (jr0Var = pr0Var7.f) != null) {
                                str2 = jr0Var.d;
                            } else {
                                str2 = null;
                            }
                            up0.p(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    pr0 pr0Var6 = this.c;
                    if (pr0Var6 != null && (h2 = pr0Var6.h()) != null) {
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
        pr0 pr0Var7 = this.c;
        if (pr0Var7 != null && (h = pr0Var7.h()) != null) {
            str = h.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        fr0 fr0Var;
        br0 br0Var;
        fr0 fr0Var2;
        br0 br0Var2;
        pr0 pr0Var = this.c;
        PackageInfo packageInfo = null;
        if (pr0Var != null && (fr0Var2 = pr0Var.m) != null && (br0Var2 = fr0Var2.p) != null) {
            str = br0Var2.a;
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
            pr0 pr0Var2 = this.c;
            if (pr0Var2 != null && (fr0Var = pr0Var2.m) != null && (br0Var = fr0Var.p) != null) {
                str2 = br0Var.a;
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
        Object m849constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new gj0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m849constructorimpl = Result.m849constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m849constructorimpl = Result.m849constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m855isFailureimpl(m849constructorimpl)) {
            m849constructorimpl = null;
        }
        String str3 = (String) m849constructorimpl;
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
        yr0 yr0Var;
        yr0 yr0Var2;
        String str;
        boolean z;
        boolean z2;
        js0 h;
        js0 h2;
        pr0 pr0Var = this.c;
        if ((pr0Var != null && !pr0Var.p()) || x(context)) {
            return false;
        }
        pr0 pr0Var2 = this.c;
        String str2 = null;
        if (pr0Var2 != null) {
            yr0Var = pr0Var2.c();
        } else {
            yr0Var = null;
        }
        if (yr0Var == null) {
            return false;
        }
        pr0 pr0Var3 = this.c;
        if (pr0Var3 != null) {
            yr0Var2 = pr0Var3.c();
        } else {
            yr0Var2 = null;
        }
        Intrinsics.checkNotNull(yr0Var2);
        if (yr0Var2.h() <= 0) {
            return false;
        }
        pr0 pr0Var4 = this.c;
        if (pr0Var4 != null && (h2 = pr0Var4.h()) != null) {
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
        pr0 pr0Var5 = this.c;
        if (pr0Var5 != null && (h = pr0Var5.h()) != null) {
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
