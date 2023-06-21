package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.aj3;
import com.baidu.tieba.el3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.mx2;
import com.baidu.tieba.qp3;
import com.baidu.tieba.rp3;
import com.baidu.tieba.si3;
import com.baidu.tieba.sn3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.zb3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zb3 c;

        public a(String str, String str2, zb3 zb3Var) {
            this.a = str;
            this.b = str2;
            this.c = zb3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            gv2.u().b(this.c.w(), this.c.O(), this.c.Z(), rp3.u(this.a, this.b));
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
        boolean d = rp3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081405);
        setTitle(R.string.obfuscated_res_0x7f0f0183);
        sn3 sn3Var = new sn3();
        sn3Var.k(5L);
        sn3Var.i(41L);
        sn3Var.f("domain not in white list--" + stringBuffer2);
        zb3 b0 = zb3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01cf), tp3.D(), el3.i(mx2.T().getCoreVersion(), b0.Y().G()), String.valueOf(sn3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f14d9));
        this.c.setPadding(qp3.g(70.0f), 0, qp3.g(70.0f), 0);
        String e = tp3.n().e();
        String a2 = tp3.v().a();
        aj3 aj3Var = new aj3();
        aj3Var.p(sn3Var);
        aj3Var.q(si3.n(0));
        aj3Var.m(zb3.g0());
        aj3Var.l("errorDomain", stringBuffer2);
        aj3Var.l("path", e);
        aj3Var.l("prePath", a2);
        aj3Var.l("curPath", tp3.n().a());
        si3.R(aj3Var);
    }
}
