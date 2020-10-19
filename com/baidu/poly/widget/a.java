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
/* loaded from: classes6.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView bQK;
    private TextView bQL;
    private TextView bQM;
    private ImageView bQN;
    private InterfaceC0288a bQO;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0288a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bQK = (ImageView) findViewById(b.e.channel_icon_view);
        this.bQL = (TextView) findViewById(b.e.channel_name_view);
        this.bQM = (TextView) findViewById(b.e.channel_desc_view);
        this.bQN = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0288a interfaceC0288a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.WF().b(this.bQK, icon);
        this.bQL.setText(displayName);
        if (P == 1) {
            this.bQN.setImageResource(b.d.channel_checked);
        } else {
            this.bQN.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.bQO = interfaceC0288a;
        } else {
            this.bQK.setAlpha(0.4f);
            this.bQL.setAlpha(0.4f);
            this.bQM.setAlpha(0.4f);
            this.bQN.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.bQM.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.bQM.setText(S);
            return;
        }
        this.bQM.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bQL.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bQL.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0288a interfaceC0288a = this.bQO;
        if (interfaceC0288a != null) {
            interfaceC0288a.a();
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
