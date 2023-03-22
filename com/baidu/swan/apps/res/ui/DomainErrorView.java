package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ar2;
import com.baidu.tieba.gt2;
import com.baidu.tieba.kl3;
import com.baidu.tieba.ll3;
import com.baidu.tieba.me3;
import com.baidu.tieba.mj3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.t73;
import com.baidu.tieba.ue3;
import com.baidu.tieba.yg3;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ t73 c;

        public a(String str, String str2, t73 t73Var) {
            this.a = str;
            this.b = str2;
            this.c = t73Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ar2.u().b(this.c.w(), this.c.O(), this.c.Z(), ll3.u(this.a, this.b));
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
        boolean d = ll3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081248);
        setTitle(R.string.obfuscated_res_0x7f0f015b);
        mj3 mj3Var = new mj3();
        mj3Var.k(5L);
        mj3Var.i(41L);
        mj3Var.f("domain not in white list--" + stringBuffer2);
        t73 b0 = t73.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a7), nl3.D(), yg3.i(gt2.U().M(), b0.Y().G()), String.valueOf(mj3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f13a1));
        this.c.setPadding(kl3.g(70.0f), 0, kl3.g(70.0f), 0);
        String e = nl3.n().e();
        String a2 = nl3.v().a();
        ue3 ue3Var = new ue3();
        ue3Var.p(mj3Var);
        ue3Var.q(me3.n(0));
        ue3Var.m(t73.g0());
        ue3Var.l("errorDomain", stringBuffer2);
        ue3Var.l("path", e);
        ue3Var.l("prePath", a2);
        ue3Var.l("curPath", nl3.n().a());
        me3.R(ue3Var);
    }
}
