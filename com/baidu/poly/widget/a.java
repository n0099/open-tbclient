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
    private ImageView aTr;
    private TextView aTs;
    private TextView aTt;
    private ImageView aTu;
    private InterfaceC0166a aTv;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0166a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.aTr = (ImageView) findViewById(b.e.channel_icon_view);
        this.aTs = (TextView) findViewById(b.e.channel_name_view);
        this.aTt = (TextView) findViewById(b.e.channel_desc_view);
        this.aTu = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0166a interfaceC0166a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.EB().b(this.aTr, icon);
        this.aTs.setText(t);
        if (w == 1) {
            this.aTu.setImageResource(b.d.channel_checked);
        } else {
            this.aTu.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.aTv = interfaceC0166a;
        } else {
            this.aTr.setAlpha(0.4f);
            this.aTs.setAlpha(0.4f);
            this.aTt.setAlpha(0.4f);
            this.aTu.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.aTt.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.aTt.setText(z);
            return;
        }
        this.aTt.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aTs.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aTs.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0166a interfaceC0166a = this.aTv;
        if (interfaceC0166a != null) {
            interfaceC0166a.a();
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
