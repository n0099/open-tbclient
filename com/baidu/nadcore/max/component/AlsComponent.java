package com.baidu.nadcore.max.component;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.component.AlsComponent$alsService$2;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.bp0;
import com.baidu.tieba.eo0;
import com.baidu.tieba.fo0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.go0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.mo0;
import com.baidu.tieba.o11;
import com.baidu.tieba.po0;
import com.baidu.tieba.so0;
import com.baidu.tieba.to0;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006."}, d2 = {"Lcom/baidu/nadcore/max/component/AlsComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "injectService", "()V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "type", DnsModel.AREA_KEY, "sendActionAls", "(Ljava/lang/String;Ljava/lang/String;)V", "ext1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setWebViewAlsInfo", "adExtInfo", "Ljava/lang/String;", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "adVideoTimeStamp", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "Lcom/baidu/nadcore/max/service/IAlsService;", "alsService$delegate", "Lkotlin/Lazy;", "getAlsService", "()Lcom/baidu/nadcore/max/service/IAlsService;", "alsService", "", "hasCalculationStartTime", "Z", "hasRecordTime", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AlsComponent extends AbsComponentPlugin {
    public String d;
    public boolean f;
    public boolean g;
    public final bp0 e = new bp0();
    public final Lazy h = LazyKt__LazyJVMKt.lazy(new Function0<AlsComponent$alsService$2.a>() { // from class: com.baidu.nadcore.max.component.AlsComponent$alsService$2
        {
            super(0);
        }

        /* loaded from: classes2.dex */
        public static final class a implements po0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.po0
            public void a(String type, String area) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(area, "area");
                AlsComponent.this.s(type, area);
            }

            @Override // com.baidu.tieba.po0
            public void c(String type, String area, String ext1) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(area, "area");
                Intrinsics.checkNotNullParameter(ext1, "ext1");
                AlsComponent.this.t(type, area, ext1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final po0 m() {
        return (po0) this.h.getValue();
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void B() {
        super.B();
        l().u(po0.class, m());
    }

    public final void o(go0 go0Var) {
        int i = eo0.$EnumSwitchMapping$0[go0Var.getType().ordinal()];
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

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        r(intent);
    }

    public final void r(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("map");
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            this.d = String.valueOf(hashMap.get("ext_info"));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var == null || !so0Var.k()) {
            return;
        }
        this.e.j(System.currentTimeMillis());
        long max = Math.max(this.e.d() - Math.max(this.e.e(), this.e.f()), 0L);
        bp0 bp0Var = this.e;
        bp0Var.i(bp0Var.c() + max);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var == null || !so0Var.k()) {
            return;
        }
        this.e.k(System.currentTimeMillis());
        if (!this.f) {
            this.e.i(Math.max(this.e.e() - this.e.a(), 0L));
            this.f = true;
        }
    }

    public final void q(mo0 mo0Var) {
        int i = eo0.$EnumSwitchMapping$1[mo0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                u();
                return;
            }
            return;
        }
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var != null && !so0Var.k()) {
            this.e.h(System.currentTimeMillis());
        } else {
            this.e.g(System.currentTimeMillis());
        }
    }

    public final void s(String type, String area) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(area, "area");
        t(type, area, "");
    }

    public final void t(String type, String area, String ext1) {
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
        o11.b(u);
    }

    public final void u() {
        so0 so0Var = (so0) l().r(so0.class);
        if (so0Var == null || so0Var.k()) {
            long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
            bp0 bp0Var = this.e;
            bp0Var.i(bp0Var.c() + max);
        }
        to0 to0Var = (to0) l().r(to0.class);
        if (to0Var != null) {
            try {
                fp0 b = to0Var.b();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("immersive_video_stay_time", this.e.c());
                jSONObject.put("immersive_webview_first_show_time", this.e.b());
                Unit unit = Unit.INSTANCE;
                b.m(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void x(ji0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.x(event);
        String a = event.a();
        if (Intrinsics.areEqual(a, go0.class.getSimpleName())) {
            o((go0) event);
        } else if (Intrinsics.areEqual(a, mo0.class.getSimpleName())) {
            q((mo0) event);
        } else if (Intrinsics.areEqual(a, fo0.class.getSimpleName())) {
            if (this.e.b() == 0) {
                this.e.h(System.currentTimeMillis());
            }
            if (!this.g) {
                this.g = true;
                so0 so0Var = (so0) l().r(so0.class);
                if (so0Var != null && so0Var.k()) {
                    long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                    bp0 bp0Var = this.e;
                    bp0Var.i(bp0Var.c() + max);
                }
            }
        }
    }
}
