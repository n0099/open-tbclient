package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.an3;
import com.baidu.tieba.g93;
import com.baidu.tieba.hg3;
import com.baidu.tieba.li3;
import com.baidu.tieba.ns2;
import com.baidu.tieba.tu2;
import com.baidu.tieba.xm3;
import com.baidu.tieba.ym3;
import com.baidu.tieba.zf3;
import com.baidu.tieba.zk3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g93 c;

        public a(String str, String str2, g93 g93Var) {
            this.a = str;
            this.b = str2;
            this.c = g93Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ns2.u().b(this.c.w(), this.c.O(), this.c.Z(), ym3.u(this.a, this.b));
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
        boolean d = ym3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f0813d2);
        setTitle(R.string.obfuscated_res_0x7f0f0183);
        zk3 zk3Var = new zk3();
        zk3Var.k(5L);
        zk3Var.i(41L);
        zk3Var.f("domain not in white list--" + stringBuffer2);
        g93 b0 = g93.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01cf), an3.D(), li3.i(tu2.U().M(), b0.Y().G()), String.valueOf(zk3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1483));
        this.c.setPadding(xm3.g(70.0f), 0, xm3.g(70.0f), 0);
        String e = an3.n().e();
        String a2 = an3.v().a();
        hg3 hg3Var = new hg3();
        hg3Var.p(zk3Var);
        hg3Var.q(zf3.n(0));
        hg3Var.m(g93.g0());
        hg3Var.l("errorDomain", stringBuffer2);
        hg3Var.l("path", e);
        hg3Var.l("prePath", a2);
        hg3Var.l("curPath", an3.n().a());
        zf3.R(hg3Var);
    }
}
