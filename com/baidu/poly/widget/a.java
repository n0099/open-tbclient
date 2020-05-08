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
    private ImageView bpK;
    private TextView bpL;
    private TextView bpM;
    private ImageView bpN;
    private InterfaceC0212a bpO;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0212a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bpK = (ImageView) findViewById(b.e.channel_icon_view);
        this.bpL = (TextView) findViewById(b.e.channel_name_view);
        this.bpM = (TextView) findViewById(b.e.channel_desc_view);
        this.bpN = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0212a interfaceC0212a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.KT().b(this.bpK, icon);
        this.bpL.setText(t);
        if (w == 1) {
            this.bpN.setImageResource(b.d.channel_checked);
        } else {
            this.bpN.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.bpO = interfaceC0212a;
        } else {
            this.bpK.setAlpha(0.4f);
            this.bpL.setAlpha(0.4f);
            this.bpM.setAlpha(0.4f);
            this.bpN.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.bpM.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.bpM.setText(z);
            return;
        }
        this.bpM.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bpL.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bpL.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0212a interfaceC0212a = this.bpO;
        if (interfaceC0212a != null) {
            interfaceC0212a.a();
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
