package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.poly.b;
/* loaded from: classes4.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView cqP;
    private TextView cqQ;
    private TextView cqR;
    private ImageView cqS;
    private InterfaceC0323a cqT;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0323a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.cqP = (ImageView) findViewById(b.e.channel_icon_view);
        this.cqQ = (TextView) findViewById(b.e.channel_name_view);
        this.cqR = (TextView) findViewById(b.e.channel_desc_view);
        this.cqS = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0323a interfaceC0323a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.afu().b(this.cqP, icon);
        this.cqQ.setText(displayName);
        if (P == 1) {
            this.cqS.setImageResource(b.d.channel_checked);
        } else {
            this.cqS.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.cqT = interfaceC0323a;
        } else {
            this.cqP.setAlpha(0.4f);
            this.cqQ.setAlpha(0.4f);
            this.cqR.setAlpha(0.4f);
            this.cqS.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.cqR.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.cqR.setText(S);
            return;
        }
        this.cqR.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqQ.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.cqQ.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0323a interfaceC0323a = this.cqT;
        if (interfaceC0323a != null) {
            interfaceC0323a.a();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
