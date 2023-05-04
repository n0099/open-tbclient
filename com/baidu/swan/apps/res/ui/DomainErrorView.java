package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ch3;
import com.baidu.tieba.er2;
import com.baidu.tieba.kt2;
import com.baidu.tieba.ol3;
import com.baidu.tieba.pl3;
import com.baidu.tieba.qe3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.x73;
import com.baidu.tieba.ye3;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ x73 c;

        public a(String str, String str2, x73 x73Var) {
            this.a = str;
            this.b = str2;
            this.c = x73Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            er2.u().b(this.c.w(), this.c.O(), this.c.Z(), pl3.u(this.a, this.b));
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
        boolean d = pl3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081263);
        setTitle(R.string.obfuscated_res_0x7f0f0159);
        qj3 qj3Var = new qj3();
        qj3Var.k(5L);
        qj3Var.i(41L);
        qj3Var.f("domain not in white list--" + stringBuffer2);
        x73 b0 = x73.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a5), rl3.D(), ch3.i(kt2.U().M(), b0.Y().G()), String.valueOf(qj3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f13b1));
        this.c.setPadding(ol3.g(70.0f), 0, ol3.g(70.0f), 0);
        String e = rl3.n().e();
        String a2 = rl3.v().a();
        ye3 ye3Var = new ye3();
        ye3Var.p(qj3Var);
        ye3Var.q(qe3.n(0));
        ye3Var.m(x73.g0());
        ye3Var.l("errorDomain", stringBuffer2);
        ye3Var.l("path", e);
        ye3Var.l("prePath", a2);
        ye3Var.l("curPath", rl3.n().a());
        qe3.R(ye3Var);
    }
}
