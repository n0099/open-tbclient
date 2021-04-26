package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.b2.b;
import d.a.h0.a.h;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.e;
import d.a.h0.a.z0.f;
import d.a.h0.a.z1.k.d;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11969f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f11970g;

        public a(String str, String str2, e eVar) {
            this.f11968e = str;
            this.f11969f = str2;
            this.f11970g = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.h0.a.w0.a.q().b(this.f11970g.v(), this.f11970g.B(), this.f11970g.M(), i0.s(this.f11968e, this.f11969f));
        }
    }

    public DomainErrorView(Context context) {
        super(context);
    }

    public void b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean b2 = i0.b(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(d.a.h0.a.e.aiapps_empty_icon_error);
        setTitle(h.aiapps_emptyview_domain_error_title);
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(5L);
        aVar.h(41L);
        aVar.e("domain not in white list--" + stringBuffer2);
        e O = e.O();
        if (O != null) {
            String format = String.format(getContext().getResources().getString(h.aiapps_open_failed_detail_format), k0.z(), b.g(f.V().N(), O.L().F()), String.valueOf(aVar.a()));
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(b2 ? stringBuffer2 : format);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            setSubTitle(sb.toString());
            this.k.setVisibility(0);
            this.k.setOnClickListener(new a(format, stringBuffer2, O));
        }
        this.f11957f.setText(getResources().getText(h.swanapp_path_forbidden));
        this.f11958g.setPadding(h0.f(70.0f), 0, h0.f(70.0f), 0);
        String d2 = k0.n().d();
        d dVar = new d();
        dVar.p(aVar);
        dVar.q(d.a.h0.a.z1.h.n(0));
        dVar.m(e.T());
        dVar.l("errorDomain", stringBuffer2);
        dVar.l("path", d2);
        d.a.h0.a.z1.h.H(dVar);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
