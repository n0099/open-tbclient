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
/* loaded from: classes11.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView bpF;
    private TextView bpG;
    private TextView bpH;
    private ImageView bpI;
    private InterfaceC0190a bpJ;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0190a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bpF = (ImageView) findViewById(b.e.channel_icon_view);
        this.bpG = (TextView) findViewById(b.e.channel_name_view);
        this.bpH = (TextView) findViewById(b.e.channel_desc_view);
        this.bpI = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0190a interfaceC0190a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.KU().b(this.bpF, icon);
        this.bpG.setText(t);
        if (w == 1) {
            this.bpI.setImageResource(b.d.channel_checked);
        } else {
            this.bpI.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.bpJ = interfaceC0190a;
        } else {
            this.bpF.setAlpha(0.4f);
            this.bpG.setAlpha(0.4f);
            this.bpH.setAlpha(0.4f);
            this.bpI.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.bpH.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.bpH.setText(z);
            return;
        }
        this.bpH.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bpG.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bpG.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0190a interfaceC0190a = this.bpJ;
        if (interfaceC0190a != null) {
            interfaceC0190a.a();
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
