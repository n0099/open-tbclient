package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bk3;
import com.baidu.tieba.ck3;
import com.baidu.tieba.dd3;
import com.baidu.tieba.di3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.k63;
import com.baidu.tieba.ld3;
import com.baidu.tieba.pf3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.xr2;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k63 c;

        public a(String str, String str2, k63 k63Var) {
            this.a = str;
            this.b = str2;
            this.c = k63Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            rp2.u().b(this.c.w(), this.c.P(), this.c.a0(), ck3.u(this.a, this.b));
        }
    }

    public DomainErrorView(Context context) {
        super(context);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void b(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        boolean d = ck3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f0814c5);
        setTitle(R.string.obfuscated_res_0x7f0f0190);
        di3 di3Var = new di3();
        di3Var.k(5L);
        di3Var.i(41L);
        di3Var.f("domain not in white list--" + stringBuffer2);
        k63 c0 = k63.c0();
        if (c0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01dc), ek3.D(), pf3.i(xr2.V().getCoreVersion(), c0.Z().H()), String.valueOf(di3Var.a()));
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            if (d) {
                str2 = stringBuffer2;
            } else {
                str2 = format;
            }
            sb.append(str2);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            setSubTitle(sb.toString());
            this.g.setVisibility(0);
            this.g.setOnClickListener(new a(format, stringBuffer2, c0));
        }
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1573));
        this.c.setPadding(bk3.g(70.0f), 0, bk3.g(70.0f), 0);
        String e = ek3.n().e();
        String a2 = ek3.v().a();
        ld3 ld3Var = new ld3();
        ld3Var.p(di3Var);
        ld3Var.q(dd3.n(0));
        ld3Var.m(k63.h0());
        ld3Var.l("errorDomain", stringBuffer2);
        ld3Var.l("path", e);
        ld3Var.l("prePath", a2);
        ld3Var.l("curPath", ek3.n().a());
        dd3.R(ld3Var);
    }
}
