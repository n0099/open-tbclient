package com.baidu.nadcore.max.component;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.component.AlsComponent$alsService$2;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.el0;
import com.baidu.tieba.hl0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.ll0;
import com.baidu.tieba.ne0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.wk0;
import com.baidu.tieba.xk0;
import com.baidu.tieba.xl0;
import com.baidu.tieba.yk0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006."}, d2 = {"Lcom/baidu/nadcore/max/component/AlsComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "injectService", "()V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "type", DnsModel.AREA_KEY, "sendActionAls", "(Ljava/lang/String;Ljava/lang/String;)V", PermissionStorage.PermissionItem.ITEM_EXT_1, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setWebViewAlsInfo", "adExtInfo", "Ljava/lang/String;", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "adVideoTimeStamp", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "Lcom/baidu/nadcore/max/service/IAlsService;", "alsService$delegate", "Lkotlin/Lazy;", "getAlsService", "()Lcom/baidu/nadcore/max/service/IAlsService;", "alsService", "", "hasCalculationStartTime", "Z", "hasRecordTime", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class AlsComponent extends AbsComponentPlugin {
    public String d;
    public boolean f;
    public boolean g;
    public final tl0 e = new tl0();
    public final Lazy h = LazyKt__LazyJVMKt.lazy(new Function0<AlsComponent$alsService$2.a>() { // from class: com.baidu.nadcore.max.component.AlsComponent$alsService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements hl0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.hl0
            public void a(String type, String area) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(area, "area");
                AlsComponent.this.q(type, area);
            }

            @Override // com.baidu.tieba.hl0
            public void c(String type, String area, String ext1) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(area, "area");
                Intrinsics.checkNotNullParameter(ext1, "ext1");
                AlsComponent.this.s(type, area, ext1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final hl0 j() {
        return (hl0) this.h.getValue();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void y() {
        super.y();
        g().w(hl0.class, j());
    }

    public final void k(yk0 yk0Var) {
        int i = wk0.$EnumSwitchMapping$0[yk0Var.b().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.g = false;
                return;
            }
            return;
        }
        this.e.l(System.currentTimeMillis());
        this.g = false;
    }

    public final void o(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            this.d = String.valueOf(hashMap.get(MigrateStatisticUtils.EXT_INFO));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        o(intent);
    }

    public final void n(el0 el0Var) {
        int i = wk0.$EnumSwitchMapping$1[el0Var.b().ordinal()];
        if (i != 1) {
            if (i == 2) {
                v();
                return;
            }
            return;
        }
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var != null && !kl0Var.j()) {
            this.e.h(System.currentTimeMillis());
        } else {
            this.e.g(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var == null || !kl0Var.j()) {
            return;
        }
        this.e.j(System.currentTimeMillis());
        long max = Math.max(this.e.d() - Math.max(this.e.e(), this.e.f()), 0L);
        tl0 tl0Var = this.e;
        tl0Var.i(tl0Var.c() + max);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var == null || !kl0Var.j()) {
            return;
        }
        this.e.k(System.currentTimeMillis());
        if (!this.f) {
            this.e.i(Math.max(this.e.e() - this.e.a(), 0L));
            this.f = true;
        }
    }

    public final void q(String type, String area) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, "area");
        s(type, area, "");
    }

    public final void s(String type, String area, String ext1) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        ClogBuilder u = new ClogBuilder().z(type).u(ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP);
        if (!TextUtils.isEmpty(area)) {
            u.j(area);
        }
        if (!TextUtils.isEmpty(this.d)) {
            u.p(this.d);
        }
        if (!TextUtils.isEmpty(ext1)) {
            u.k(ext1);
        }
        jy0.e(u);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(ne0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        String a = event.a();
        if (Intrinsics.areEqual(a, yk0.class.getSimpleName())) {
            k((yk0) event);
        } else if (Intrinsics.areEqual(a, el0.class.getSimpleName())) {
            n((el0) event);
        } else if (Intrinsics.areEqual(a, xk0.class.getSimpleName())) {
            if (this.e.b() == 0) {
                this.e.h(System.currentTimeMillis());
            }
            if (!this.g) {
                this.g = true;
                kl0 kl0Var = (kl0) g().q(kl0.class);
                if (kl0Var != null && kl0Var.j()) {
                    long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                    tl0 tl0Var = this.e;
                    tl0Var.i(tl0Var.c() + max);
                }
            }
        }
    }

    public final void v() {
        kl0 kl0Var = (kl0) g().q(kl0.class);
        if (kl0Var == null || kl0Var.j()) {
            long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
            tl0 tl0Var = this.e;
            tl0Var.i(tl0Var.c() + max);
        }
        ll0 ll0Var = (ll0) g().q(ll0.class);
        if (ll0Var != null) {
            try {
                xl0 b = ll0Var.b();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("immersive_video_stay_time", this.e.c());
                jSONObject.put("immersive_webview_first_show_time", this.e.b());
                Unit unit = Unit.INSTANCE;
                b.k(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }
}
