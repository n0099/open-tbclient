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
/* loaded from: classes10.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView aOS;
    private TextView aOT;
    private TextView aOU;
    private ImageView aOV;
    private InterfaceC0157a aOW;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0157a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.aOS = (ImageView) findViewById(b.e.channel_icon_view);
        this.aOT = (TextView) findViewById(b.e.channel_name_view);
        this.aOU = (TextView) findViewById(b.e.channel_desc_view);
        this.aOV = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0157a interfaceC0157a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.Cf().b(this.aOS, icon);
        this.aOT.setText(t);
        if (w == 1) {
            this.aOV.setImageResource(b.d.channel_checked);
        } else {
            this.aOV.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.aOW = interfaceC0157a;
        } else {
            this.aOS.setAlpha(0.4f);
            this.aOT.setAlpha(0.4f);
            this.aOU.setAlpha(0.4f);
            this.aOV.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.aOU.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.aOU.setText(z);
            return;
        }
        this.aOU.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aOT.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aOT.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0157a interfaceC0157a = this.aOW;
        if (interfaceC0157a != null) {
            interfaceC0157a.a();
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
