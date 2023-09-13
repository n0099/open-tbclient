package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ai3;
import com.baidu.tieba.an3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.hb3;
import com.baidu.tieba.ii3;
import com.baidu.tieba.mk3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.uw2;
import com.baidu.tieba.yo3;
import com.baidu.tieba.zo3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hb3 c;

        public a(String str, String str2, hb3 hb3Var) {
            this.a = str;
            this.b = str2;
            this.c = hb3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ou2.u().b(this.c.w(), this.c.O(), this.c.Z(), zo3.u(this.a, this.b));
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
        boolean d = zo3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f081490);
        setTitle(R.string.obfuscated_res_0x7f0f0186);
        an3 an3Var = new an3();
        an3Var.k(5L);
        an3Var.i(41L);
        an3Var.f("domain not in white list--" + stringBuffer2);
        hb3 b0 = hb3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d2), bp3.D(), mk3.i(uw2.T().getCoreVersion(), b0.Y().G()), String.valueOf(an3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1537));
        this.c.setPadding(yo3.g(70.0f), 0, yo3.g(70.0f), 0);
        String e = bp3.n().e();
        String a2 = bp3.v().a();
        ii3 ii3Var = new ii3();
        ii3Var.p(an3Var);
        ii3Var.q(ai3.n(0));
        ii3Var.m(hb3.g0());
        ii3Var.l("errorDomain", stringBuffer2);
        ii3Var.l("path", e);
        ii3Var.l("prePath", a2);
        ii3Var.l("curPath", bp3.n().a());
        ai3.R(ii3Var);
    }
}
