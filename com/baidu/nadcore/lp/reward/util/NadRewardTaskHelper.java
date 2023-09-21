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
import com.baidu.tieba.bs0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.en0;
import com.baidu.tieba.er0;
import com.baidu.tieba.gj0;
import com.baidu.tieba.in0;
import com.baidu.tieba.ir0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.mr0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.os0;
import com.baidu.tieba.rs0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.sj0;
import com.baidu.tieba.sr0;
import com.baidu.tieba.tp0;
import com.baidu.tieba.wp0;
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
    public sr0 c;
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
            os0 i;
            sr0 sr0Var = NadRewardTaskHelper.this.c;
            if (sr0Var != null && (i = sr0Var.i()) != null && i.a()) {
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
            sr0 sr0Var;
            bs0 c;
            Long n;
            mr0 mr0Var;
            sr0 sr0Var2;
            bs0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (sr0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = sr0Var2.c()) != null && (f = c2.f()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, f.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                sr0 sr0Var3 = nadRewardTaskHelper2.c;
                if (sr0Var3 != null && (mr0Var = sr0Var3.f) != null) {
                    str = mr0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (sr0Var = NadRewardTaskHelper.this.c) != null && (c = sr0Var.c()) != null && (n = c.n()) != null) {
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
        bs0 c2;
        Long n;
        if (!B()) {
            return;
        }
        this.m = new a();
        sr0 sr0Var = this.c;
        if (sr0Var != null && (c2 = sr0Var.c()) != null && (n = c2.n()) != null) {
            long longValue = n.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(sr0 adModel) {
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
        bs0 c2;
        mr0 mr0Var;
        mr0 mr0Var2;
        ms0 g3;
        rs0 q;
        sr0 sr0Var = this.c;
        if (sr0Var != null && (g3 = sr0Var.g()) != null && (q = g3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        cs0 cs0Var = null;
        r2 = null;
        String str2 = null;
        cs0Var = null;
        if (i <= 0) {
            sr0 sr0Var2 = this.c;
            if (sr0Var2 != null && (mr0Var2 = sr0Var2.f) != null) {
                str2 = mr0Var2.d;
            }
            wp0.e(str2, "18", "18002");
            return false;
        }
        sr0 sr0Var3 = this.c;
        if (sr0Var3 != null && (mr0Var = sr0Var3.f) != null) {
            str = mr0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        sr0 sr0Var4 = this.c;
        if (sr0Var4 != null && (c2 = sr0Var4.c()) != null && c2.o() == 0) {
            return false;
        }
        sr0 sr0Var5 = this.c;
        if (sr0Var5 != null && (g2 = sr0Var5.g()) != null) {
            rs0Var = g2.q();
        } else {
            rs0Var = null;
        }
        if (rs0Var != null) {
            sr0 sr0Var6 = this.c;
            if (sr0Var6 != null && (g = sr0Var6.g()) != null) {
                cs0Var = g.f();
            }
            if (cs0Var != null) {
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
        mr0 mr0Var;
        ir0 ir0Var;
        ir0 ir0Var2;
        ir0 ir0Var3;
        ir0 ir0Var4;
        ms0 g;
        rs0 q;
        sh0 sh0Var = new sh0();
        sh0Var.a = "4";
        sr0 sr0Var = this.c;
        String str5 = null;
        if (sr0Var != null && (g = sr0Var.g()) != null && (q = g.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        sh0Var.c = String.valueOf(num);
        sr0 sr0Var2 = this.c;
        if (sr0Var2 != null && (ir0Var4 = sr0Var2.m) != null) {
            str = ir0Var4.k;
        } else {
            str = null;
        }
        sh0Var.d = str;
        sr0 sr0Var3 = this.c;
        if (sr0Var3 != null && (ir0Var3 = sr0Var3.m) != null) {
            str2 = ir0Var3.l;
        } else {
            str2 = null;
        }
        sh0Var.e = str2;
        sr0 sr0Var4 = this.c;
        if (sr0Var4 != null && (ir0Var2 = sr0Var4.m) != null) {
            str3 = ir0Var2.m;
        } else {
            str3 = null;
        }
        sh0Var.f = str3;
        sr0 sr0Var5 = this.c;
        if (sr0Var5 != null && (ir0Var = sr0Var5.m) != null) {
            str4 = ir0Var.n;
        } else {
            str4 = null;
        }
        sh0Var.g = str4;
        sh0Var.h = this.j;
        sr0 sr0Var6 = this.c;
        if (sr0Var6 != null && (mr0Var = sr0Var6.f) != null) {
            str5 = mr0Var.d;
        }
        sh0Var.i = str5;
        en0.a().a(sh0Var);
    }

    public final void v() {
        ms0 ms0Var;
        ms0 g;
        if (this.g) {
            return;
        }
        bp0 bp0Var = this.d;
        if (!this.e || bp0Var == null || !bp0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            tp0 tp0Var = tp0.a;
            sr0 sr0Var = this.c;
            if (sr0Var != null) {
                ms0Var = sr0Var.g();
            } else {
                ms0Var = null;
            }
            ms0 ms0Var2 = ms0Var;
            String g2 = bp0Var.g();
            sr0 sr0Var2 = this.c;
            tp0Var.c(ms0Var2, g2, (sr0Var2 == null || (g = sr0Var2.g()) == null || (r0 = g.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    mr0 mr0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    sr0 sr0Var3 = NadRewardTaskHelper.this.c;
                    if (sr0Var3 != null && (mr0Var = sr0Var3.f) != null) {
                        str2 = mr0Var.d;
                    } else {
                        str2 = null;
                    }
                    wp0.h(str2, "2", coin, null, 8, null);
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
                    mr0 mr0Var;
                    mr0 mr0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        sr0 sr0Var3 = NadRewardTaskHelper.this.c;
                        if (sr0Var3 != null && (mr0Var2 = sr0Var3.f) != null) {
                            str2 = mr0Var2.d;
                        }
                        wp0.r(str2, "2");
                        return;
                    }
                    sr0 sr0Var4 = NadRewardTaskHelper.this.c;
                    if (sr0Var4 != null && (mr0Var = sr0Var4.f) != null) {
                        str = mr0Var.d;
                    } else {
                        str = null;
                    }
                    wp0.q(str, "2", null, 4, null);
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
        ir0 ir0Var;
        String str;
        ir0 ir0Var2;
        bs0 c2;
        sh0 sh0Var = new sh0();
        sh0Var.a = "2";
        sr0 sr0Var = this.c;
        String str2 = null;
        if (sr0Var != null && (c2 = sr0Var.c()) != null) {
            num = Integer.valueOf(c2.g());
        } else {
            num = null;
        }
        sh0Var.b = String.valueOf(num);
        bp0 bp0Var = this.d;
        if (bp0Var != null) {
            str2 = bp0Var.h();
        }
        sh0Var.c = str2;
        sr0 sr0Var2 = this.c;
        String str3 = "";
        sh0Var.d = (sr0Var2 == null || (ir0Var2 = sr0Var2.m) == null || (r1 = ir0Var2.i) == null) ? "" : "";
        sr0 sr0Var3 = this.c;
        if (sr0Var3 != null && (ir0Var = sr0Var3.m) != null && (str = ir0Var.j) != null) {
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
                sr0 sr0Var4;
                bs0 c3;
                Long f;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (sr0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = sr0Var4.c()) != null && (f = c3.f()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, f.longValue());
                }
            }
        };
        en0.a().a(sh0Var);
    }

    public final void t(bp0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        mr0 mr0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            wp0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        sr0 sr0Var = this.c;
        if (sr0Var != null && (mr0Var = sr0Var.f) != null) {
            str = mr0Var.d;
        } else {
            str = null;
        }
        wp0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        ms0 g;
        rs0 rs0Var;
        cs0 cs0Var;
        ms0 ms0Var;
        rs0 rs0Var2;
        cs0 cs0Var2;
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
            sr0 sr0Var = this.c;
            if (sr0Var != null && (g6 = sr0Var.g()) != null) {
                rs0Var = g6.q();
            } else {
                rs0Var = null;
            }
            if (rs0Var != null) {
                sr0 sr0Var2 = this.c;
                if (sr0Var2 != null && (g5 = sr0Var2.g()) != null) {
                    cs0Var = g5.f();
                } else {
                    cs0Var = null;
                }
                if (cs0Var != null) {
                    tp0 tp0Var = tp0.a;
                    sr0 sr0Var3 = this.c;
                    if (sr0Var3 != null) {
                        ms0Var = sr0Var3.g();
                    } else {
                        ms0Var = null;
                    }
                    sr0 sr0Var4 = this.c;
                    if (sr0Var4 != null && (g4 = sr0Var4.g()) != null) {
                        rs0Var2 = g4.q();
                    } else {
                        rs0Var2 = null;
                    }
                    Intrinsics.checkNotNull(rs0Var2);
                    String a2 = rs0Var2.a();
                    sr0 sr0Var5 = this.c;
                    if (sr0Var5 != null && (g3 = sr0Var5.g()) != null) {
                        cs0Var2 = g3.f();
                    } else {
                        cs0Var2 = null;
                    }
                    Intrinsics.checkNotNull(cs0Var2);
                    tp0Var.c(ms0Var, a2, cs0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            mr0 mr0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            sr0 sr0Var6 = NadRewardTaskHelper.this.c;
                            if (sr0Var6 != null && (mr0Var = sr0Var6.f) != null) {
                                str2 = mr0Var.d;
                            } else {
                                str2 = null;
                            }
                            wp0.h(str2, "4", coin, null, 8, null);
                            sr0 sr0Var7 = NadRewardTaskHelper.this.c;
                            if (sr0Var7 != null && (g7 = sr0Var7.g()) != null) {
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
                            mr0 mr0Var;
                            mr0 mr0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                sr0 sr0Var6 = NadRewardTaskHelper.this.c;
                                if (sr0Var6 != null && (mr0Var2 = sr0Var6.f) != null) {
                                    str3 = mr0Var2.d;
                                }
                                wp0.r(str3, "4");
                                return;
                            }
                            sr0 sr0Var7 = NadRewardTaskHelper.this.c;
                            if (sr0Var7 != null && (mr0Var = sr0Var7.f) != null) {
                                str2 = mr0Var.d;
                            } else {
                                str2 = null;
                            }
                            wp0.q(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    sr0 sr0Var6 = this.c;
                    if (sr0Var6 != null && (g2 = sr0Var6.g()) != null) {
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
        sr0 sr0Var7 = this.c;
        if (sr0Var7 != null && (g = sr0Var7.g()) != null) {
            str = g.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        ir0 ir0Var;
        er0 er0Var;
        ir0 ir0Var2;
        er0 er0Var2;
        sr0 sr0Var = this.c;
        PackageInfo packageInfo = null;
        if (sr0Var != null && (ir0Var2 = sr0Var.m) != null && (er0Var2 = ir0Var2.p) != null) {
            str = er0Var2.a;
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
            sr0 sr0Var2 = this.c;
            if (sr0Var2 != null && (ir0Var = sr0Var2.m) != null && (er0Var = ir0Var.p) != null) {
                str2 = er0Var.a;
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
        Object m852constructorimpl;
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
            m852constructorimpl = Result.m852constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m852constructorimpl = Result.m852constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m858isFailureimpl(m852constructorimpl)) {
            m852constructorimpl = null;
        }
        String str3 = (String) m852constructorimpl;
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
        bs0 bs0Var;
        bs0 bs0Var2;
        String str;
        boolean z;
        boolean z2;
        ms0 g;
        ms0 g2;
        sr0 sr0Var = this.c;
        if ((sr0Var != null && !sr0Var.p()) || x(context)) {
            return false;
        }
        sr0 sr0Var2 = this.c;
        String str2 = null;
        if (sr0Var2 != null) {
            bs0Var = sr0Var2.c();
        } else {
            bs0Var = null;
        }
        if (bs0Var == null) {
            return false;
        }
        sr0 sr0Var3 = this.c;
        if (sr0Var3 != null) {
            bs0Var2 = sr0Var3.c();
        } else {
            bs0Var2 = null;
        }
        Intrinsics.checkNotNull(bs0Var2);
        if (bs0Var2.g() <= 0) {
            return false;
        }
        sr0 sr0Var4 = this.c;
        if (sr0Var4 != null && (g2 = sr0Var4.g()) != null) {
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
        sr0 sr0Var5 = this.c;
        if (sr0Var5 != null && (g = sr0Var5.g()) != null) {
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
