package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.cc3;
import com.baidu.tieba.dj3;
import com.baidu.tieba.hl3;
import com.baidu.tieba.jv2;
import com.baidu.tieba.px2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.up3;
import com.baidu.tieba.vi3;
import com.baidu.tieba.vn3;
import com.baidu.tieba.wp3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cc3 c;

        public a(String str, String str2, cc3 cc3Var) {
            this.a = str;
            this.b = str2;
            this.c = cc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            jv2.u().b(this.c.w(), this.c.O(), this.c.Z(), up3.u(this.a, this.b));
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
        boolean d = up3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081437);
        setTitle(R.string.obfuscated_res_0x7f0f0185);
        vn3 vn3Var = new vn3();
        vn3Var.k(5L);
        vn3Var.i(41L);
        vn3Var.f("domain not in white list--" + stringBuffer2);
        cc3 b0 = cc3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d1), wp3.D(), hl3.i(px2.T().getCoreVersion(), b0.Y().G()), String.valueOf(vn3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f14f6));
        this.c.setPadding(tp3.g(70.0f), 0, tp3.g(70.0f), 0);
        String e = wp3.n().e();
        String a2 = wp3.v().a();
        dj3 dj3Var = new dj3();
        dj3Var.p(vn3Var);
        dj3Var.q(vi3.n(0));
        dj3Var.m(cc3.g0());
        dj3Var.l("errorDomain", stringBuffer2);
        dj3Var.l("path", e);
        dj3Var.l("prePath", a2);
        dj3Var.l("curPath", wp3.n().a());
        vi3.R(dj3Var);
    }
}
