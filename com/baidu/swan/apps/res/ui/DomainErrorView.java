package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad3;
import com.baidu.tieba.ai3;
import com.baidu.tieba.bk3;
import com.baidu.tieba.h63;
import com.baidu.tieba.id3;
import com.baidu.tieba.mf3;
import com.baidu.tieba.op2;
import com.baidu.tieba.ur2;
import com.baidu.tieba.yj3;
import com.baidu.tieba.zj3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h63 c;

        public a(String str, String str2, h63 h63Var) {
            this.a = str;
            this.b = str2;
            this.c = h63Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            op2.u().b(this.c.w(), this.c.P(), this.c.a0(), zj3.u(this.a, this.b));
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
        boolean d = zj3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f0814c2);
        setTitle(R.string.obfuscated_res_0x7f0f0190);
        ai3 ai3Var = new ai3();
        ai3Var.k(5L);
        ai3Var.i(41L);
        ai3Var.f("domain not in white list--" + stringBuffer2);
        h63 c0 = h63.c0();
        if (c0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01dc), bk3.D(), mf3.i(ur2.V().getCoreVersion(), c0.Z().H()), String.valueOf(ai3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1572));
        this.c.setPadding(yj3.g(70.0f), 0, yj3.g(70.0f), 0);
        String e = bk3.n().e();
        String a2 = bk3.v().a();
        id3 id3Var = new id3();
        id3Var.p(ai3Var);
        id3Var.q(ad3.n(0));
        id3Var.m(h63.h0());
        id3Var.l("errorDomain", stringBuffer2);
        id3Var.l("path", e);
        id3Var.l("prePath", a2);
        id3Var.l("curPath", bk3.n().a());
        ad3.R(id3Var);
    }
}
