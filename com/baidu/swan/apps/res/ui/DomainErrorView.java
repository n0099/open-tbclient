package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dn3;
import com.baidu.tieba.en3;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fl3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.m93;
import com.baidu.tieba.ng3;
import com.baidu.tieba.ri3;
import com.baidu.tieba.ts2;
import com.baidu.tieba.zu2;
/* loaded from: classes3.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ m93 c;

        public a(String str, String str2, m93 m93Var) {
            this.a = str;
            this.b = str2;
            this.c = m93Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ts2.u().b(this.c.w(), this.c.O(), this.c.Z(), en3.u(this.a, this.b));
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
        boolean d = en3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f08122f);
        setTitle(R.string.obfuscated_res_0x7f0f015b);
        fl3 fl3Var = new fl3();
        fl3Var.k(5L);
        fl3Var.i(41L);
        fl3Var.f("domain not in white list--" + stringBuffer2);
        m93 b0 = m93.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01a7), gn3.D(), ri3.i(zu2.U().M(), b0.Y().G()), String.valueOf(fl3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f138d));
        this.c.setPadding(dn3.g(70.0f), 0, dn3.g(70.0f), 0);
        String e = gn3.n().e();
        String a2 = gn3.v().a();
        ng3 ng3Var = new ng3();
        ng3Var.p(fl3Var);
        ng3Var.q(fg3.n(0));
        ng3Var.m(m93.g0());
        ng3Var.l("errorDomain", stringBuffer2);
        ng3Var.l("path", e);
        ng3Var.l("prePath", a2);
        ng3Var.l("curPath", gn3.n().a());
        fg3.R(ng3Var);
    }
}
