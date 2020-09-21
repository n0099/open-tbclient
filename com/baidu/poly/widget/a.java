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
    private ImageView bKb;
    private TextView bKc;
    private TextView bKd;
    private ImageView bKe;
    private InterfaceC0273a bKf;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0273a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bKb = (ImageView) findViewById(b.e.channel_icon_view);
        this.bKc = (TextView) findViewById(b.e.channel_name_view);
        this.bKd = (TextView) findViewById(b.e.channel_desc_view);
        this.bKe = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0273a interfaceC0273a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.UI().b(this.bKb, icon);
        this.bKc.setText(displayName);
        if (P == 1) {
            this.bKe.setImageResource(b.d.channel_checked);
        } else {
            this.bKe.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.bKf = interfaceC0273a;
        } else {
            this.bKb.setAlpha(0.4f);
            this.bKc.setAlpha(0.4f);
            this.bKd.setAlpha(0.4f);
            this.bKe.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.bKd.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.bKd.setText(S);
            return;
        }
        this.bKd.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKc.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bKc.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0273a interfaceC0273a = this.bKf;
        if (interfaceC0273a != null) {
            interfaceC0273a.a();
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
