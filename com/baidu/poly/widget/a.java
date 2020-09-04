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
    private ImageView bIa;
    private TextView bIb;
    private TextView bIc;
    private ImageView bId;
    private InterfaceC0275a bIe;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0275a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bIa = (ImageView) findViewById(b.e.channel_icon_view);
        this.bIb = (TextView) findViewById(b.e.channel_name_view);
        this.bIc = (TextView) findViewById(b.e.channel_desc_view);
        this.bId = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0275a interfaceC0275a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.TZ().b(this.bIa, icon);
        this.bIb.setText(displayName);
        if (P == 1) {
            this.bId.setImageResource(b.d.channel_checked);
        } else {
            this.bId.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.bIe = interfaceC0275a;
        } else {
            this.bIa.setAlpha(0.4f);
            this.bIb.setAlpha(0.4f);
            this.bIc.setAlpha(0.4f);
            this.bId.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.bIc.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.bIc.setText(S);
            return;
        }
        this.bIc.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bIb.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bIb.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0275a interfaceC0275a = this.bIe;
        if (interfaceC0275a != null) {
            interfaceC0275a.a();
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
