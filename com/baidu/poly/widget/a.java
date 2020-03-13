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
    private ImageView aTt;
    private TextView aTu;
    private TextView aTv;
    private ImageView aTw;
    private InterfaceC0166a aTx;

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
        this.aTt = (ImageView) findViewById(b.e.channel_icon_view);
        this.aTu = (TextView) findViewById(b.e.channel_name_view);
        this.aTv = (TextView) findViewById(b.e.channel_desc_view);
        this.aTw = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(n nVar, InterfaceC0166a interfaceC0166a) {
        String t = nVar.t();
        String z = nVar.z();
        String icon = nVar.getIcon();
        int w = nVar.w();
        int u = nVar.u();
        com.baidu.poly.a.c.b.ED().b(this.aTt, icon);
        this.aTu.setText(t);
        if (w == 1) {
            this.aTw.setImageResource(b.d.channel_checked);
        } else {
            this.aTw.setImageResource(b.d.unchecked);
        }
        if (1 == u) {
            this.aTx = interfaceC0166a;
        } else {
            this.aTt.setAlpha(0.4f);
            this.aTu.setAlpha(0.4f);
            this.aTv.setAlpha(0.4f);
            this.aTw.setVisibility(8);
        }
        if (!TextUtils.isEmpty(z)) {
            String s = nVar.s();
            if (!TextUtils.isEmpty(s)) {
                try {
                    this.aTv.setTextColor(Color.parseColor(s));
                } catch (Exception e) {
                }
            }
            this.aTv.setText(z);
            return;
        }
        this.aTv.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aTu.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.aTu.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0166a interfaceC0166a = this.aTx;
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
