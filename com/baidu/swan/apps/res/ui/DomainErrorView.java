package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.cr2;
import com.baidu.tieba.gj3;
import com.baidu.tieba.hj3;
import com.baidu.tieba.ic3;
import com.baidu.tieba.ih3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.p53;
import com.baidu.tieba.qc3;
import com.baidu.tieba.ue3;
import com.baidu.tieba.wo2;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ p53 c;

        public a(String str, String str2, p53 p53Var) {
            this.a = str;
            this.b = str2;
            this.c = p53Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            wo2.u().b(this.c.w(), this.c.P(), this.c.a0(), hj3.u(this.a, this.b));
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
        boolean d = hj3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081488);
        setTitle(R.string.obfuscated_res_0x7f0f0188);
        ih3 ih3Var = new ih3();
        ih3Var.k(5L);
        ih3Var.i(41L);
        ih3Var.f("domain not in white list--" + stringBuffer2);
        p53 c0 = p53.c0();
        if (c0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d4), jj3.D(), ue3.i(cr2.V().getCoreVersion(), c0.Z().H()), String.valueOf(ih3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f154b));
        this.c.setPadding(gj3.g(70.0f), 0, gj3.g(70.0f), 0);
        String e = jj3.n().e();
        String a2 = jj3.v().a();
        qc3 qc3Var = new qc3();
        qc3Var.p(ih3Var);
        qc3Var.q(ic3.n(0));
        qc3Var.m(p53.h0());
        qc3Var.l("errorDomain", stringBuffer2);
        qc3Var.l("path", e);
        qc3Var.l("prePath", a2);
        qc3Var.l("curPath", jj3.n().a());
        ic3.R(qc3Var);
    }
}
