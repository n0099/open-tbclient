package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.db3;
import com.baidu.tieba.ei3;
import com.baidu.tieba.ik3;
import com.baidu.tieba.ku2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.uo3;
import com.baidu.tieba.vo3;
import com.baidu.tieba.wh3;
import com.baidu.tieba.wm3;
import com.baidu.tieba.xo3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ db3 c;

        public a(String str, String str2, db3 db3Var) {
            this.a = str;
            this.b = str2;
            this.c = db3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ku2.u().b(this.c.w(), this.c.O(), this.c.Z(), vo3.u(this.a, this.b));
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
        boolean d = vo3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f08146b);
        setTitle(R.string.obfuscated_res_0x7f0f0186);
        wm3 wm3Var = new wm3();
        wm3Var.k(5L);
        wm3Var.i(41L);
        wm3Var.f("domain not in white list--" + stringBuffer2);
        db3 b0 = db3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d2), xo3.D(), ik3.i(qw2.T().getCoreVersion(), b0.Y().G()), String.valueOf(wm3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f151e));
        this.c.setPadding(uo3.g(70.0f), 0, uo3.g(70.0f), 0);
        String e = xo3.n().e();
        String a2 = xo3.v().a();
        ei3 ei3Var = new ei3();
        ei3Var.p(wm3Var);
        ei3Var.q(wh3.n(0));
        ei3Var.m(db3.g0());
        ei3Var.l("errorDomain", stringBuffer2);
        ei3Var.l("path", e);
        ei3Var.l("prePath", a2);
        ei3Var.l("curPath", xo3.n().a());
        wh3.R(ei3Var);
    }
}
