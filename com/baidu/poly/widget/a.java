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
    private ImageView bHW;
    private TextView bHX;
    private TextView bHY;
    private ImageView bHZ;
    private InterfaceC0275a bIa;

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
        this.bHW = (ImageView) findViewById(b.e.channel_icon_view);
        this.bHX = (TextView) findViewById(b.e.channel_name_view);
        this.bHY = (TextView) findViewById(b.e.channel_desc_view);
        this.bHZ = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0275a interfaceC0275a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.TZ().b(this.bHW, icon);
        this.bHX.setText(displayName);
        if (P == 1) {
            this.bHZ.setImageResource(b.d.channel_checked);
        } else {
            this.bHZ.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.bIa = interfaceC0275a;
        } else {
            this.bHW.setAlpha(0.4f);
            this.bHX.setAlpha(0.4f);
            this.bHY.setAlpha(0.4f);
            this.bHZ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.bHY.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.bHY.setText(S);
            return;
        }
        this.bHY.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bHX.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bHX.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0275a interfaceC0275a = this.bIa;
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
