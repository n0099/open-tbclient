package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.h;
import d.a.l0.a.j2.k;
import d.a.l0.a.j2.p.d;
import d.a.l0.a.m2.b;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f11088g;

        public a(String str, String str2, e eVar) {
            this.f11086e = str;
            this.f11087f = str2;
            this.f11088g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.l0.a.c1.a.t().b(this.f11088g.x(), this.f11088g.D(), this.f11088g.O(), o0.u(this.f11086e, this.f11087f));
        }
    }

    public DomainErrorView(Context context) {
        super(context);
    }

    public void b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean d2 = o0.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(d.a.l0.a.e.aiapps_empty_icon_error);
        setTitle(h.aiapps_emptyview_domain_error_title);
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(41L);
        aVar.e("domain not in white list--" + stringBuffer2);
        e Q = e.Q();
        if (Q != null) {
            String format = String.format(getContext().getResources().getString(h.aiapps_open_failed_detail_format), q0.D(), b.i(f.V().N(), Q.N().G()), String.valueOf(aVar.a()));
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(d2 ? stringBuffer2 : format);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            setSubTitle(sb.toString());
            this.k.setVisibility(0);
            this.k.setOnClickListener(new a(format, stringBuffer2, Q));
        }
        this.f11075f.setText(getResources().getText(h.swanapp_domain_error));
        this.f11076g.setPadding(n0.g(70.0f), 0, n0.g(70.0f), 0);
        String f2 = q0.n().f();
        String b2 = q0.v().b();
        d dVar = new d();
        dVar.p(aVar);
        dVar.q(k.m(0));
        dVar.m(e.V());
        dVar.l("errorDomain", stringBuffer2);
        dVar.l("path", f2);
        dVar.l("prePath", b2);
        k.L(dVar);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
