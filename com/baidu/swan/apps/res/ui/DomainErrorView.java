package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dl3;
import com.baidu.tieba.fv2;
import com.baidu.tieba.lx2;
import com.baidu.tieba.pp3;
import com.baidu.tieba.qp3;
import com.baidu.tieba.ri3;
import com.baidu.tieba.rn3;
import com.baidu.tieba.sp3;
import com.baidu.tieba.yb3;
import com.baidu.tieba.zi3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ yb3 c;

        public a(String str, String str2, yb3 yb3Var) {
            this.a = str;
            this.b = str2;
            this.c = yb3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            fv2.u().b(this.c.w(), this.c.O(), this.c.Z(), qp3.u(this.a, this.b));
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
        boolean d = qp3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081401);
        setTitle(R.string.obfuscated_res_0x7f0f0183);
        rn3 rn3Var = new rn3();
        rn3Var.k(5L);
        rn3Var.i(41L);
        rn3Var.f("domain not in white list--" + stringBuffer2);
        yb3 b0 = yb3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01cf), sp3.D(), dl3.i(lx2.T().getCoreVersion(), b0.Y().G()), String.valueOf(rn3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f14d5));
        this.c.setPadding(pp3.g(70.0f), 0, pp3.g(70.0f), 0);
        String e = sp3.n().e();
        String a2 = sp3.v().a();
        zi3 zi3Var = new zi3();
        zi3Var.p(rn3Var);
        zi3Var.q(ri3.n(0));
        zi3Var.m(yb3.g0());
        zi3Var.l("errorDomain", stringBuffer2);
        zi3Var.l("path", e);
        zi3Var.l("prePath", a2);
        zi3Var.l("curPath", sp3.n().a());
        ri3.R(zi3Var);
    }
}
