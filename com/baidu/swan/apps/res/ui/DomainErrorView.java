package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ah3;
import com.baidu.tieba.cr2;
import com.baidu.tieba.it2;
import com.baidu.tieba.ml3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.oe3;
import com.baidu.tieba.oj3;
import com.baidu.tieba.pl3;
import com.baidu.tieba.v73;
import com.baidu.tieba.we3;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v73 c;

        public a(String str, String str2, v73 v73Var) {
            this.a = str;
            this.b = str2;
            this.c = v73Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            cr2.u().b(this.c.w(), this.c.O(), this.c.Z(), nl3.u(this.a, this.b));
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
        boolean d = nl3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081232);
        setTitle(R.string.obfuscated_res_0x7f0f015b);
        oj3 oj3Var = new oj3();
        oj3Var.k(5L);
        oj3Var.i(41L);
        oj3Var.f("domain not in white list--" + stringBuffer2);
        v73 b0 = v73.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a7), pl3.D(), ah3.i(it2.U().M(), b0.Y().G()), String.valueOf(oj3Var.a()));
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
        this.c.setPadding(ml3.g(70.0f), 0, ml3.g(70.0f), 0);
        String e = pl3.n().e();
        String a2 = pl3.v().a();
        we3 we3Var = new we3();
        we3Var.p(oj3Var);
        we3Var.q(oe3.n(0));
        we3Var.m(v73.g0());
        we3Var.l("errorDomain", stringBuffer2);
        we3Var.l("path", e);
        we3Var.l("prePath", a2);
        we3Var.l("curPath", pl3.n().a());
        oe3.R(we3Var);
    }
}
