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
    private ImageView bxn;
    private TextView bxo;
    private TextView bxp;
    private ImageView bxq;
    private InterfaceC0245a bxr;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0245a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bxn = (ImageView) findViewById(b.e.channel_icon_view);
        this.bxo = (TextView) findViewById(b.e.channel_name_view);
        this.bxp = (TextView) findViewById(b.e.channel_desc_view);
        this.bxq = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0245a interfaceC0245a) {
        String displayName = oVar.getDisplayName();
        String J = oVar.J();
        String icon = oVar.getIcon();
        int G = oVar.G();
        int E = oVar.E();
        com.baidu.poly.a.c.b.MP().b(this.bxn, icon);
        this.bxo.setText(displayName);
        if (G == 1) {
            this.bxq.setImageResource(b.d.channel_checked);
        } else {
            this.bxq.setImageResource(b.d.unchecked);
        }
        if (1 == E) {
            this.bxr = interfaceC0245a;
        } else {
            this.bxn.setAlpha(0.4f);
            this.bxo.setAlpha(0.4f);
            this.bxp.setAlpha(0.4f);
            this.bxq.setVisibility(8);
        }
        if (!TextUtils.isEmpty(J)) {
            String D = oVar.D();
            if (!TextUtils.isEmpty(D)) {
                try {
                    this.bxp.setTextColor(Color.parseColor(D));
                } catch (Exception e) {
                }
            }
            this.bxp.setText(J);
            return;
        }
        this.bxp.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bxo.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bxo.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0245a interfaceC0245a = this.bxr;
        if (interfaceC0245a != null) {
            interfaceC0245a.a();
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
