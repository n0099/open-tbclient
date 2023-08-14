package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dk3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.lw2;
import com.baidu.tieba.po3;
import com.baidu.tieba.qo3;
import com.baidu.tieba.rh3;
import com.baidu.tieba.rm3;
import com.baidu.tieba.so3;
import com.baidu.tieba.ya3;
import com.baidu.tieba.zh3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ya3 c;

        public a(String str, String str2, ya3 ya3Var) {
            this.a = str;
            this.b = str2;
            this.c = ya3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            fu2.u().b(this.c.w(), this.c.O(), this.c.Z(), qo3.u(this.a, this.b));
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
        boolean d = qo3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081455);
        setTitle(R.string.obfuscated_res_0x7f0f0185);
        rm3 rm3Var = new rm3();
        rm3Var.k(5L);
        rm3Var.i(41L);
        rm3Var.f("domain not in white list--" + stringBuffer2);
        ya3 b0 = ya3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d1), so3.D(), dk3.i(lw2.T().getCoreVersion(), b0.Y().G()), String.valueOf(rm3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1510));
        this.c.setPadding(po3.g(70.0f), 0, po3.g(70.0f), 0);
        String e = so3.n().e();
        String a2 = so3.v().a();
        zh3 zh3Var = new zh3();
        zh3Var.p(rm3Var);
        zh3Var.q(rh3.n(0));
        zh3Var.m(ya3.g0());
        zh3Var.l("errorDomain", stringBuffer2);
        zh3Var.l("path", e);
        zh3Var.l("prePath", a2);
        zh3Var.l("curPath", so3.n().a());
        rh3.R(zh3Var);
    }
}
