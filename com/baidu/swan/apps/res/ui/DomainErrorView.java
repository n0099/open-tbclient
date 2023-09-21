package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ap3;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hi3;
import com.baidu.tieba.lk3;
import com.baidu.tieba.nu2;
import com.baidu.tieba.tw2;
import com.baidu.tieba.xo3;
import com.baidu.tieba.yo3;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zm3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gb3 c;

        public a(String str, String str2, gb3 gb3Var) {
            this.a = str;
            this.b = str2;
            this.c = gb3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nu2.u().b(this.c.w(), this.c.O(), this.c.Z(), yo3.u(this.a, this.b));
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
        boolean d = yo3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f08148b);
        setTitle(R.string.obfuscated_res_0x7f0f0186);
        zm3 zm3Var = new zm3();
        zm3Var.k(5L);
        zm3Var.i(41L);
        zm3Var.f("domain not in white list--" + stringBuffer2);
        gb3 b0 = gb3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d2), ap3.D(), lk3.i(tw2.T().getCoreVersion(), b0.Y().G()), String.valueOf(zm3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f153a));
        this.c.setPadding(xo3.g(70.0f), 0, xo3.g(70.0f), 0);
        String e = ap3.n().e();
        String a2 = ap3.v().a();
        hi3 hi3Var = new hi3();
        hi3Var.p(zm3Var);
        hi3Var.q(zh3.n(0));
        hi3Var.m(gb3.g0());
        hi3Var.l("errorDomain", stringBuffer2);
        hi3Var.l("path", e);
        hi3Var.l("prePath", a2);
        hi3Var.l("curPath", ap3.n().a());
        zh3.R(hi3Var);
    }
}
