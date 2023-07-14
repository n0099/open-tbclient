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
import com.baidu.tieba.bs0;
import com.baidu.tieba.do0;
import com.baidu.tieba.dt0;
import com.baidu.tieba.fk0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.ft0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.it0;
import com.baidu.tieba.js0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.oq0;
import com.baidu.tieba.qq0;
import com.baidu.tieba.ri0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.ss0;
import com.baidu.tieba.ts0;
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
/* loaded from: classes3.dex */
public final class NadRewardTaskHelper {
    public Context a;
    public Handler b;
    public js0 c;
    public aq0 d;
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
            ft0 i;
            js0 js0Var = NadRewardTaskHelper.this.c;
            if (js0Var != null && (i = js0Var.i()) != null && i.a()) {
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
    public static final class d extends ho0<ko0> {
        public d(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ho0
        public void onEvent(ko0 event) {
            js0 js0Var;
            ss0 c;
            Long n;
            fs0 fs0Var;
            js0 js0Var2;
            ss0 c2;
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
                if (nadRewardTaskHelper.x(nadRewardTaskHelper.a) && (js0Var2 = NadRewardTaskHelper.this.c) != null && (c2 = js0Var2.c()) != null && (g = c2.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
            if (!NadRewardTaskHelper.this.k && NadRewardTaskHelper.this.i && !NadRewardTaskHelper.this.j) {
                NadRewardTaskHelper nadRewardTaskHelper2 = NadRewardTaskHelper.this;
                js0 js0Var3 = nadRewardTaskHelper2.c;
                if (js0Var3 != null && (fs0Var = js0Var3.f) != null) {
                    str = fs0Var.c;
                }
                if (nadRewardTaskHelper2.y(str, NadRewardTaskHelper.this.a) && (js0Var = NadRewardTaskHelper.this.c) != null && (c = js0Var.c()) != null && (n = c.n()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.l, n.longValue());
                }
            }
        }
    }

    public NadRewardTaskHelper() {
        Context b2 = rk0.b();
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
        do0.a().b(this, new d(ko0.class));
    }

    public final void F() {
        this.b.removeCallbacksAndMessages(null);
        do0.a().unregister(this);
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
        ss0 c2;
        Long n;
        if (!B()) {
            return;
        }
        this.m = new a();
        js0 js0Var = this.c;
        if (js0Var != null && (c2 = js0Var.c()) != null && (n = c2.n()) != null) {
            long longValue = n.longValue();
            Handler handler = this.b;
            Runnable runnable = this.m;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, longValue);
        }
        E();
    }

    public final void H(js0 adModel) {
        Intrinsics.checkNotNullParameter(adModel, "adModel");
        this.c = adModel;
        G();
        u();
    }

    public final boolean B() {
        int i;
        String str;
        it0 it0Var;
        dt0 h;
        dt0 h2;
        ss0 c2;
        fs0 fs0Var;
        fs0 fs0Var2;
        dt0 h3;
        it0 q;
        js0 js0Var = this.c;
        if (js0Var != null && (h3 = js0Var.h()) != null && (q = h3.q()) != null) {
            i = q.b();
        } else {
            i = -1;
        }
        ts0 ts0Var = null;
        r2 = null;
        String str2 = null;
        ts0Var = null;
        if (i <= 0) {
            js0 js0Var2 = this.c;
            if (js0Var2 != null && (fs0Var2 = js0Var2.f) != null) {
                str2 = fs0Var2.d;
            }
            qq0.e(str2, "18", "18002");
            return false;
        }
        js0 js0Var3 = this.c;
        if (js0Var3 != null && (fs0Var = js0Var3.f) != null) {
            str = fs0Var.c;
        } else {
            str = null;
        }
        if (!y(str, this.a)) {
            return false;
        }
        js0 js0Var4 = this.c;
        if (js0Var4 != null && (c2 = js0Var4.c()) != null && c2.o() == 0) {
            return false;
        }
        js0 js0Var5 = this.c;
        if (js0Var5 != null && (h2 = js0Var5.h()) != null) {
            it0Var = h2.q();
        } else {
            it0Var = null;
        }
        if (it0Var != null) {
            js0 js0Var6 = this.c;
            if (js0Var6 != null && (h = js0Var6.h()) != null) {
                ts0Var = h.f();
            }
            if (ts0Var != null) {
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
        fs0 fs0Var;
        bs0 bs0Var;
        bs0 bs0Var2;
        bs0 bs0Var3;
        bs0 bs0Var4;
        dt0 h;
        it0 q;
        ri0 ri0Var = new ri0();
        ri0Var.a = "4";
        js0 js0Var = this.c;
        String str5 = null;
        if (js0Var != null && (h = js0Var.h()) != null && (q = h.q()) != null) {
            num = Integer.valueOf(q.b());
        } else {
            num = null;
        }
        ri0Var.c = String.valueOf(num);
        js0 js0Var2 = this.c;
        if (js0Var2 != null && (bs0Var4 = js0Var2.m) != null) {
            str = bs0Var4.k;
        } else {
            str = null;
        }
        ri0Var.d = str;
        js0 js0Var3 = this.c;
        if (js0Var3 != null && (bs0Var3 = js0Var3.m) != null) {
            str2 = bs0Var3.l;
        } else {
            str2 = null;
        }
        ri0Var.e = str2;
        js0 js0Var4 = this.c;
        if (js0Var4 != null && (bs0Var2 = js0Var4.m) != null) {
            str3 = bs0Var2.m;
        } else {
            str3 = null;
        }
        ri0Var.f = str3;
        js0 js0Var5 = this.c;
        if (js0Var5 != null && (bs0Var = js0Var5.m) != null) {
            str4 = bs0Var.n;
        } else {
            str4 = null;
        }
        ri0Var.g = str4;
        ri0Var.h = this.j;
        js0 js0Var6 = this.c;
        if (js0Var6 != null && (fs0Var = js0Var6.f) != null) {
            str5 = fs0Var.d;
        }
        ri0Var.i = str5;
        do0.a().a(ri0Var);
    }

    public final void v() {
        dt0 dt0Var;
        dt0 h;
        if (this.g) {
            return;
        }
        aq0 aq0Var = this.d;
        if (!this.e || aq0Var == null || !aq0Var.a() || !x(this.a)) {
            return;
        }
        if (this.f) {
            oq0 oq0Var = oq0.a;
            js0 js0Var = this.c;
            if (js0Var != null) {
                dt0Var = js0Var.h();
            } else {
                dt0Var = null;
            }
            dt0 dt0Var2 = dt0Var;
            String g = aq0Var.g();
            js0 js0Var2 = this.c;
            oq0Var.c(dt0Var2, g, (js0Var2 == null || (h = js0Var2.h()) == null || (r0 = h.e()) == null) ? "" : "", new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkDownloadTaskComplete$1
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
                    fs0 fs0Var;
                    Intrinsics.checkNotNullParameter(coin, "coin");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Toast.makeText(NadRewardTaskHelper.this.a, "恭喜！成功领取金币啦～", 0).show();
                    js0 js0Var3 = NadRewardTaskHelper.this.c;
                    if (js0Var3 != null && (fs0Var = js0Var3.f) != null) {
                        str2 = fs0Var.d;
                    } else {
                        str2 = null;
                    }
                    qq0.h(str2, "2", coin, null, 8, null);
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
                    fs0 fs0Var;
                    fs0 fs0Var2;
                    Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                    String str2 = null;
                    if (i == 1) {
                        js0 js0Var3 = NadRewardTaskHelper.this.c;
                        if (js0Var3 != null && (fs0Var2 = js0Var3.f) != null) {
                            str2 = fs0Var2.d;
                        }
                        qq0.q(str2, "2");
                        return;
                    }
                    js0 js0Var4 = NadRewardTaskHelper.this.c;
                    if (js0Var4 != null && (fs0Var = js0Var4.f) != null) {
                        str = fs0Var.d;
                    } else {
                        str = null;
                    }
                    qq0.p(str, "2", null, 4, null);
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
        bs0 bs0Var;
        String str;
        bs0 bs0Var2;
        ss0 c2;
        ri0 ri0Var = new ri0();
        ri0Var.a = "2";
        js0 js0Var = this.c;
        String str2 = null;
        if (js0Var != null && (c2 = js0Var.c()) != null) {
            num = Integer.valueOf(c2.h());
        } else {
            num = null;
        }
        ri0Var.b = String.valueOf(num);
        aq0 aq0Var = this.d;
        if (aq0Var != null) {
            str2 = aq0Var.h();
        }
        ri0Var.c = str2;
        js0 js0Var2 = this.c;
        String str3 = "";
        ri0Var.d = (js0Var2 == null || (bs0Var2 = js0Var2.m) == null || (r1 = bs0Var2.i) == null) ? "" : "";
        js0 js0Var3 = this.c;
        if (js0Var3 != null && (bs0Var = js0Var3.m) != null && (str = bs0Var.j) != null) {
            str3 = str;
        }
        ri0Var.e = str3;
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
        ri0Var.h = this.f;
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
                js0 js0Var4;
                ss0 c3;
                Long g;
                if (NadRewardTaskHelper.this.e && !NadRewardTaskHelper.this.f && (js0Var4 = NadRewardTaskHelper.this.c) != null && (c3 = js0Var4.c()) != null && (g = c3.g()) != null) {
                    NadRewardTaskHelper.this.b.postDelayed(NadRewardTaskHelper.this.h, g.longValue());
                }
            }
        };
        do0.a().a(ri0Var);
    }

    public final void t(aq0 response, AdDownloadStatus downloadStatus, String ext) {
        boolean z;
        String str;
        fs0 fs0Var;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (response.h().length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            qq0.e(ext, "18", "18001");
        }
        if (!response.a() || !z(this.a) || downloadStatus != AdDownloadStatus.NONE) {
            return;
        }
        this.d = response;
        C();
        this.e = true;
        js0 js0Var = this.c;
        if (js0Var != null && (fs0Var = js0Var.f) != null) {
            str = fs0Var.d;
        } else {
            str = null;
        }
        qq0.c(str, "2", response.h());
        E();
    }

    public final void w() {
        dt0 h;
        it0 it0Var;
        ts0 ts0Var;
        dt0 dt0Var;
        it0 it0Var2;
        ts0 ts0Var2;
        dt0 h2;
        dt0 h3;
        dt0 h4;
        dt0 h5;
        dt0 h6;
        if (this.k || !this.i) {
            return;
        }
        String str = null;
        if (this.j) {
            js0 js0Var = this.c;
            if (js0Var != null && (h6 = js0Var.h()) != null) {
                it0Var = h6.q();
            } else {
                it0Var = null;
            }
            if (it0Var != null) {
                js0 js0Var2 = this.c;
                if (js0Var2 != null && (h5 = js0Var2.h()) != null) {
                    ts0Var = h5.f();
                } else {
                    ts0Var = null;
                }
                if (ts0Var != null) {
                    oq0 oq0Var = oq0.a;
                    js0 js0Var3 = this.c;
                    if (js0Var3 != null) {
                        dt0Var = js0Var3.h();
                    } else {
                        dt0Var = null;
                    }
                    js0 js0Var4 = this.c;
                    if (js0Var4 != null && (h4 = js0Var4.h()) != null) {
                        it0Var2 = h4.q();
                    } else {
                        it0Var2 = null;
                    }
                    Intrinsics.checkNotNull(it0Var2);
                    String a2 = it0Var2.a();
                    js0 js0Var5 = this.c;
                    if (js0Var5 != null && (h3 = js0Var5.h()) != null) {
                        ts0Var2 = h3.f();
                    } else {
                        ts0Var2 = null;
                    }
                    Intrinsics.checkNotNull(ts0Var2);
                    oq0Var.c(dt0Var, a2, ts0Var2.d(), new Function2<String, String, Unit>() { // from class: com.baidu.nadcore.lp.reward.util.NadRewardTaskHelper$checkInvokeTaskComplete$1
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
                            dt0 h7;
                            fs0 fs0Var;
                            Intrinsics.checkNotNullParameter(coin, "coin");
                            Intrinsics.checkNotNullParameter(nextCoin, "nextCoin");
                            js0 js0Var6 = NadRewardTaskHelper.this.c;
                            if (js0Var6 != null && (fs0Var = js0Var6.f) != null) {
                                str2 = fs0Var.d;
                            } else {
                                str2 = null;
                            }
                            qq0.h(str2, "4", coin, null, 8, null);
                            js0 js0Var7 = NadRewardTaskHelper.this.c;
                            if (js0Var7 != null && (h7 = js0Var7.h()) != null) {
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
                            fs0 fs0Var;
                            fs0 fs0Var2;
                            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
                            String str3 = null;
                            if (i == 1) {
                                js0 js0Var6 = NadRewardTaskHelper.this.c;
                                if (js0Var6 != null && (fs0Var2 = js0Var6.f) != null) {
                                    str3 = fs0Var2.d;
                                }
                                qq0.q(str3, "4");
                                return;
                            }
                            js0 js0Var7 = NadRewardTaskHelper.this.c;
                            if (js0Var7 != null && (fs0Var = js0Var7.f) != null) {
                                str2 = fs0Var.d;
                            } else {
                                str2 = null;
                            }
                            qq0.p(str2, "4", null, 4, null);
                        }
                    });
                    Context context = this.a;
                    js0 js0Var6 = this.c;
                    if (js0Var6 != null && (h2 = js0Var6.h()) != null) {
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
        js0 js0Var7 = this.c;
        if (js0Var7 != null && (h = js0Var7.h()) != null) {
            str = h.h();
        }
        Toast.makeText(context2, String.valueOf(str), 0).show();
    }

    public final boolean x(Context context) {
        String str;
        boolean z;
        String str2;
        bs0 bs0Var;
        xr0 xr0Var;
        bs0 bs0Var2;
        xr0 xr0Var2;
        js0 js0Var = this.c;
        PackageInfo packageInfo = null;
        if (js0Var != null && (bs0Var2 = js0Var.m) != null && (xr0Var2 = bs0Var2.p) != null) {
            str = xr0Var2.a;
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
            js0 js0Var2 = this.c;
            if (js0Var2 != null && (bs0Var = js0Var2.m) != null && (xr0Var = bs0Var.p) != null) {
                str2 = xr0Var.a;
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
        Object m846constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap<String, String> d2 = new fk0(str).d();
        Intrinsics.checkNotNullExpressionValue(d2, "entity.params");
        String str2 = d2.get("params");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(str2);
            m846constructorimpl = Result.m846constructorimpl(new JSONObject(str2).optString(DeepLinkItem.DEEPLINK_APPURL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m846constructorimpl = Result.m846constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m852isFailureimpl(m846constructorimpl)) {
            m846constructorimpl = null;
        }
        String str3 = (String) m846constructorimpl;
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
        ss0 ss0Var;
        ss0 ss0Var2;
        String str;
        boolean z;
        boolean z2;
        dt0 h;
        dt0 h2;
        js0 js0Var = this.c;
        if ((js0Var != null && !js0Var.n()) || x(context)) {
            return false;
        }
        js0 js0Var2 = this.c;
        String str2 = null;
        if (js0Var2 != null) {
            ss0Var = js0Var2.c();
        } else {
            ss0Var = null;
        }
        if (ss0Var == null) {
            return false;
        }
        js0 js0Var3 = this.c;
        if (js0Var3 != null) {
            ss0Var2 = js0Var3.c();
        } else {
            ss0Var2 = null;
        }
        Intrinsics.checkNotNull(ss0Var2);
        if (ss0Var2.h() <= 0) {
            return false;
        }
        js0 js0Var4 = this.c;
        if (js0Var4 != null && (h2 = js0Var4.h()) != null) {
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
        js0 js0Var5 = this.c;
        if (js0Var5 != null && (h = js0Var5.h()) != null) {
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
