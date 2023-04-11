package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.br2;
import com.baidu.tieba.ht2;
import com.baidu.tieba.ll3;
import com.baidu.tieba.ml3;
import com.baidu.tieba.ne3;
import com.baidu.tieba.nj3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.u73;
import com.baidu.tieba.ve3;
import com.baidu.tieba.zg3;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u73 c;

        public a(String str, String str2, u73 u73Var) {
            this.a = str;
            this.b = str2;
            this.c = u73Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            br2.u().b(this.c.w(), this.c.O(), this.c.Z(), ml3.u(this.a, this.b));
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
        boolean d = ml3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081232);
        setTitle(R.string.obfuscated_res_0x7f0f015b);
        nj3 nj3Var = new nj3();
        nj3Var.k(5L);
        nj3Var.i(41L);
        nj3Var.f("domain not in white list--" + stringBuffer2);
        u73 b0 = u73.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a7), ol3.D(), zg3.i(ht2.U().M(), b0.Y().G()), String.valueOf(nj3Var.a()));
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
            this.g.setOnClickListener(new a(format, stringBuffer2, b0));
        }
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1398));
        this.c.setPadding(ll3.g(70.0f), 0, ll3.g(70.0f), 0);
        String e = ol3.n().e();
        String a2 = ol3.v().a();
        ve3 ve3Var = new ve3();
        ve3Var.p(nj3Var);
        ve3Var.q(ne3.n(0));
        ve3Var.m(u73.g0());
        ve3Var.l("errorDomain", stringBuffer2);
        ve3Var.l("path", e);
        ve3Var.l("prePath", a2);
        ve3Var.l("curPath", ol3.n().a());
        ne3.R(ve3Var);
    }
}
