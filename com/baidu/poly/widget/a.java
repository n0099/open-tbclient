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
/* loaded from: classes9.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView aOa;
    private TextView aOb;
    private TextView aOc;
    private ImageView aOd;
    private InterfaceC0155a aOe;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0155a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.aOa = (ImageView) findViewById(b.e.channel_icon_view);
        this.aOb = (TextView) findViewById(b.e.channel_name_view);
        this.aOc = (TextView) findViewById(b.e.channel_desc_view);
        this.aOd = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0155a interfaceC0155a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.BJ().b(this.aOa, icon);
        this.aOb.setText(t);
        if (w == 1) {
            this.aOd.setImageResource(b.d.channel_checked);
        } else {
            this.aOd.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.aOe = interfaceC0155a;
        } else {
            this.aOa.setAlpha(0.4f);
            this.aOb.setAlpha(0.4f);
            this.aOc.setAlpha(0.4f);
            this.aOd.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.aOc.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.aOc.setText(z);
            return;
        }
        this.aOc.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aOb.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aOb.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0155a interfaceC0155a = this.aOe;
        if (interfaceC0155a != null) {
            interfaceC0155a.a();
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
