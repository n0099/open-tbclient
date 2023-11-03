package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ak3;
import com.baidu.tieba.g63;
import com.baidu.tieba.hd3;
import com.baidu.tieba.lf3;
import com.baidu.tieba.np2;
import com.baidu.tieba.tr2;
import com.baidu.tieba.xj3;
import com.baidu.tieba.yj3;
import com.baidu.tieba.zc3;
import com.baidu.tieba.zh3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g63 c;

        public a(String str, String str2, g63 g63Var) {
            this.a = str;
            this.b = str2;
            this.c = g63Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            np2.u().b(this.c.w(), this.c.P(), this.c.a0(), yj3.u(this.a, this.b));
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
        boolean d = yj3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f08149f);
        setTitle(R.string.obfuscated_res_0x7f0f0188);
        zh3 zh3Var = new zh3();
        zh3Var.k(5L);
        zh3Var.i(41L);
        zh3Var.f("domain not in white list--" + stringBuffer2);
        g63 c0 = g63.c0();
        if (c0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d4), ak3.D(), lf3.i(tr2.V().getCoreVersion(), c0.Z().H()), String.valueOf(zh3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1562));
        this.c.setPadding(xj3.g(70.0f), 0, xj3.g(70.0f), 0);
        String e = ak3.n().e();
        String a2 = ak3.v().a();
        hd3 hd3Var = new hd3();
        hd3Var.p(zh3Var);
        hd3Var.q(zc3.n(0));
        hd3Var.m(g63.h0());
        hd3Var.l("errorDomain", stringBuffer2);
        hd3Var.l("path", e);
        hd3Var.l("prePath", a2);
        hd3Var.l("curPath", ak3.n().a());
        zc3.R(hd3Var);
    }
}
