package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.al3;
import com.baidu.tieba.cv2;
import com.baidu.tieba.ix2;
import com.baidu.tieba.mp3;
import com.baidu.tieba.np3;
import com.baidu.tieba.oi3;
import com.baidu.tieba.on3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wi3;
/* loaded from: classes4.dex */
public class DomainErrorView extends CommonEmptyView {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vb3 c;

        public a(String str, String str2, vb3 vb3Var) {
            this.a = str;
            this.b = str2;
            this.c = vb3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            cv2.u().b(this.c.w(), this.c.O(), this.c.Z(), np3.u(this.a, this.b));
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
        boolean d = np3.d(str, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        setIcon(R.drawable.obfuscated_res_0x7f08144c);
        setTitle(R.string.obfuscated_res_0x7f0f0185);
        on3 on3Var = new on3();
        on3Var.k(5L);
        on3Var.i(41L);
        on3Var.f("domain not in white list--" + stringBuffer2);
        vb3 b0 = vb3.b0();
        if (b0 != null) {
            String format = String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f01d1), pp3.D(), al3.i(ix2.T().getCoreVersion(), b0.Y().G()), String.valueOf(on3Var.a()));
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
        this.b.setText(getResources().getText(R.string.obfuscated_res_0x7f0f150c));
        this.c.setPadding(mp3.g(70.0f), 0, mp3.g(70.0f), 0);
        String e = pp3.n().e();
        String a2 = pp3.v().a();
        wi3 wi3Var = new wi3();
        wi3Var.p(on3Var);
        wi3Var.q(oi3.n(0));
        wi3Var.m(vb3.g0());
        wi3Var.l("errorDomain", stringBuffer2);
        wi3Var.l("path", e);
        wi3Var.l("prePath", a2);
        wi3Var.l("curPath", pp3.n().a());
        oi3.R(wi3Var);
    }
}
