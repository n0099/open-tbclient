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
import com.baidu.tieba.bq0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.es0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.mi0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.ns0;
import com.baidu.tieba.pn0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.qs0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ur0;
import com.baidu.tieba.wn0;
import com.baidu.tieba.yj0;
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
    public ur0 c;
    public mp0 d;
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
            ns0 h;
            ur0 ur0Var = NadRewardTaskHelper.this.c;
            if (ur0Var != null && (h = ur0Var.h()) != null && h.a()) {
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
    public static final class d extends tn0<wn0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tn0
        public void onEvent(wn0 event) {
            ur0 ur0Var;
            ds0 c;
            Long k;
            qr0 qr0Var;
            ur0 ur0Var2;
            ds0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (ur0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = ur0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                ur0 ur0Var3 = nadRewardTaskHelper2.c;
                if (ur0Var3 != null && (qr0Var = ur0Var3.f) != null) {
                    str = qr0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (ur0Var = NadRewardTaskHelper.this.c) != null && (c = ur0Var.c()) != null && (k = c.k()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, k.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = kk0.b();
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
        pn0.a().b(this, new d(wn0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        pn0.a().unregister(this);
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
        ds0 c2;
        Long k;
        if (!B()) {
            return;
        }
        this.m = new a();
        ur0 ur0Var = this.c;
        if (ur0Var != null && (c2 = ur0Var.c()) != null && (k = c2.k()) != null) {
            long longValue = k.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(ur0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        qs0 qs0Var;
        ls0 g;
        ls0 g2;
        ds0 c2;
        qr0 qr0Var;
        qr0 qr0Var2;
        ls0 g3;
        qs0 q;
        ur0 ur0Var = this.c;
        if (ur0Var != null && (g3 = ur0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        es0 es0Var = null;
        r2 = null;
        String str2 = null;
        es0Var = null;
        if (i <= 0) {
            ur0 ur0Var2 = this.c;
            if (ur0Var2 != null && (qr0Var2 = ur0Var2.f) != null) {
                str2 = qr0Var2.d;
            }
            bq0.e(str2, "18", "18002");
            return false;
        }
        ur0 ur0Var3 = this.c;
        if (ur0Var3 != null && (qr0Var = ur0Var3.f) != null) {
            str = qr0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        ur0 ur0Var4 = this.c;
        if (ur0Var4 != null && (c2 = ur0Var4.c()) != null && c2.l() == 0) {
            return false;
        }
        ur0 ur0Var5 = this.c;
        if (ur0Var5 != null && (g2 = ur0Var5.g()) != null) {
            qs0Var = g2.q();
        } else {
            qs0Var = null;
        }
        if (qs0Var != null) {
            ur0 ur0Var6 = this.c;
            if (ur0Var6 != null && (g = ur0Var6.g()) != null) {
                es0Var = g.f();
            }
            if (es0Var != null) {
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
        qr0 qr0Var;
        mr0 mr0Var;
        mr0 mr0Var2;
        mr0 mr0Var3;
        mr0 mr0Var4;
        ls0 g;
        qs0 q;
        mi0 mi0Var = new mi0();
        mi0Var.a = "4";
        ur0 ur0Var = this.c;
        String str5 = null;
        if (ur0Var != null && (g = ur0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        mi0Var.c = String.valueOf(num);
        ur0 ur0Var2 = this.c;
        if (ur0Var2 != null && (mr0Var4 = ur0Var2.m) != null) {
            str = mr0Var4.k;
        } else {
            str = null;
        }
        mi0Var.d = str;
        ur0 ur0Var3 = this.c;
        if (ur0Var3 != null && (mr0Var3 = ur0Var3.m) != null) {
            str2 = mr0Var3.l;
        } else {
            str2 = null;
        }
        mi0Var.e = str2;
        ur0 ur0Var4 = this.c;
        if (ur0Var4 != null && (mr0Var2 = ur0Var4.m) != null) {
            str3 = mr0Var2.m;
        } else {
            str3 = null;
        }
        mi0Var.f = str3;
        ur0 ur0Var5 = this.c;
        if (ur0Var5 != null && (mr0Var = ur0Var5.m) != null) {
            str4 = mr0Var.n;
        } else {
            str4 = null;
        }
        mi0Var.g = str4;
        mi0Var.h = this.j;
        ur0 ur0Var6 = this.c;
        if (ur0Var6 != null && (qr0Var = ur0Var6.f) != null) {
            str5 = qr0Var.d;
        }
        mi0Var.i = str5;
        pn0.a().a(mi0Var);
    }

    public final void v() {
        ls0 ls0Var;
        ls0 g;
        if (this.g) {
            return;
        }
        mp0 mp0Var = this.d;
        if (!this.e || mp0Var == null || !mp0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            zp0 zp0Var = zp0.a;
            ur0 ur0Var = this.c;
            if (ur0Var != null) {
                ls0Var = ur0Var.g();
            } else {
                ls0Var = null;
            }
            ls0 ls0Var2 = ls0Var;
            String g2 = mp0Var.g();
            ur0 ur0Var2 = this.c;
            zp0Var.c(ls0Var2, g2, (ur0Var2 == null || (g = ur0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    qr0 qr0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    ur0 ur0Var3 = NadRewardTaskHelper.this.c;
                    if (ur0Var3 != null && (qr0Var = ur0Var3.f) != null) {
                        str2 = qr0Var.d;
                    } else {
                        str2 = null;
                    }
                    bq0.g(str2, "2", coin);
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
                    qr0 qr0Var;
                    qr0 qr0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        ur0 ur0Var3 = NadRewardTaskHelper.this.c;
                        if (ur0Var3 != null && (qr0Var2 = ur0Var3.f) != null) {
                            str2 = qr0Var2.d;
                        }
                        bq0.n(str2, "2");
                        return;
                    }
                    ur0 ur0Var4 = NadRewardTaskHelper.this.c;
                    if (ur0Var4 != null && (qr0Var = ur0Var4.f) != null) {
                        str = qr0Var.d;
                    } else {
                        str = null;
                    }
                    bq0.m(str, "2", null, 4, null);
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
        mr0 mr0Var;
        String str;
        mr0 mr0Var2;
        ds0 c2;
        mi0 mi0Var = new mi0();
        mi0Var.a = "2";
        ur0 ur0Var = this.c;
        String str2 = null;
        if (ur0Var != null && (c2 = ur0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        mi0Var.b = String.valueOf(num);
        mp0 mp0Var = this.d;
        if (mp0Var != null) {
            str2 = mp0Var.h();
        }
        mi0Var.c = str2;
        ur0 ur0Var2 = this.c;
        String str3 = "";
        mi0Var.d = (ur0Var2 == null || (mr0Var2 = ur0Var2.m) == null || (r1 = mr0Var2.i) == null) ? "" : "";
        ur0 ur0Var3 = this.c;
        if (ur0Var3 != null && (mr0Var = ur0Var3.m) != null && (str = mr0Var.j) != null) {
            str3 = str;
        }
        mi0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        mi0Var.h = this.f;
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
                ur0 ur0Var4;
                ds0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (ur0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = ur0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        pn0.a().a(mi0Var);
    }

    public final void t(mp0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        qr0 qr0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bq0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        ur0 ur0Var = this.c;
        if (ur0Var != null && (qr0Var = ur0Var.f) != null) {
            str = qr0Var.d;
        } else {
            str = null;
        }
        bq0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        ls0 g;
        qs0 qs0Var;
        es0 es0Var;
        ls0 ls0Var;
        qs0 qs0Var2;
        es0 es0Var2;
        ls0 g2;
        ls0 g3;
        ls0 g4;
        ls0 g5;
        ls0 g6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            ur0 ur0Var = this.c;
            if (ur0Var != null && (g6 = ur0Var.g()) != null) {
                qs0Var = g6.q();
            } else {
                qs0Var = null;
            }
            if (qs0Var != null) {
                ur0 ur0Var2 = this.c;
                if (ur0Var2 != null && (g5 = ur0Var2.g()) != null) {
                    es0Var = g5.f();
                } else {
                    es0Var = null;
                }
                if (es0Var != null) {
                    zp0 zp0Var = zp0.a;
                    ur0 ur0Var3 = this.c;
                    if (ur0Var3 != null) {
                        ls0Var = ur0Var3.g();
                    } else {
                        ls0Var = null;
                    }
                    ur0 ur0Var4 = this.c;
                    if (ur0Var4 != null && (g4 = ur0Var4.g()) != null) {
                        qs0Var2 = g4.q();
                    } else {
                        qs0Var2 = null;
                    }
                    Intrinsics.checkNotNull(qs0Var2);
                    String a2 = qs0Var2.a();
                    ur0 ur0Var5 = this.c;
                    if (ur0Var5 != null && (g3 = ur0Var5.g()) != null) {
                        es0Var2 = g3.f();
                    } else {
                        es0Var2 = null;
                    }
                    Intrinsics.checkNotNull(es0Var2);
                    zp0Var.c(ls0Var, a2, es0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            ls0 g7;
                            qr0 qr0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            ur0 ur0Var6 = NadRewardTaskHelper.this.c;
                            if (ur0Var6 != null && (qr0Var = ur0Var6.f) != null) {
                                str2 = qr0Var.d;
                            } else {
                                str2 = null;
                            }
                            bq0.g(str2, "4", coin);
                            ur0 ur0Var7 = NadRewardTaskHelper.this.c;
                            if (ur0Var7 != null && (g7 = ur0Var7.g()) != null) {
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
                            qr0 qr0Var;
                            qr0 qr0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                ur0 ur0Var6 = NadRewardTaskHelper.this.c;
                                if (ur0Var6 != null && (qr0Var2 = ur0Var6.f) != null) {
                                    str3 = qr0Var2.d;
                                }
                                bq0.n(str3, "4");
                                return;
                            }
                            ur0 ur0Var7 = NadRewardTaskHelper.this.c;
                            if (ur0Var7 != null && (qr0Var = ur0Var7.f) != null) {
                                str2 = qr0Var.d;
                            } else {
                                str2 = null;
                            }
                            bq0.m(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    ur0 ur0Var6 = this.c;
                    if (ur0Var6 != null && (g2 = ur0Var6.g()) != null) {
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
        ur0 ur0Var7 = this.c;
        if (ur0Var7 != null && (g = ur0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        mr0 mr0Var;
        ir0 ir0Var;
        mr0 mr0Var2;
        ir0 ir0Var2;
        ur0 ur0Var = this.c;
        PackageInfo packageInfo = null;
        if (ur0Var != null && (mr0Var2 = ur0Var.m) != null && (ir0Var2 = mr0Var2.p) != null) {
            str = ir0Var2.a;
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
            ur0 ur0Var2 = this.c;
            if (ur0Var2 != null && (mr0Var = ur0Var2.m) != null && (ir0Var = mr0Var.p) != null) {
                str2 = ir0Var.a;
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
        HashMap<String, String> d2 = new yj0(str).d();
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
        ds0 ds0Var;
        ds0 ds0Var2;
        String str;
        boolean z;
        boolean z2;
        ls0 g;
        ls0 g2;
        ur0 ur0Var = this.c;
        if ((ur0Var != null && !ur0Var.m()) || x(context)) {
            return false;
        }
        ur0 ur0Var2 = this.c;
        String str2 = null;
        if (ur0Var2 != null) {
            ds0Var = ur0Var2.c();
        } else {
            ds0Var = null;
        }
        if (ds0Var == null) {
            return false;
        }
        ur0 ur0Var3 = this.c;
        if (ur0Var3 != null) {
            ds0Var2 = ur0Var3.c();
        } else {
            ds0Var2 = null;
        }
        Intrinsics.checkNotNull(ds0Var2);
        if (ds0Var2.h() <= 0) {
            return false;
        }
        ur0 ur0Var4 = this.c;
        if (ur0Var4 != null && (g2 = ur0Var4.g()) != null) {
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
        ur0 ur0Var5 = this.c;
        if (ur0Var5 != null && (g = ur0Var5.g()) != null) {
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
