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
/* loaded from: classes3.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView clZ;
    private TextView cma;
    private TextView cmb;
    private ImageView cmc;
    private InterfaceC0306a cme;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0306a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.clZ = (ImageView) findViewById(b.e.channel_icon_view);
        this.cma = (TextView) findViewById(b.e.channel_name_view);
        this.cmb = (TextView) findViewById(b.e.channel_desc_view);
        this.cmc = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0306a interfaceC0306a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.abB().b(this.clZ, icon);
        this.cma.setText(displayName);
        if (P == 1) {
            this.cmc.setImageResource(b.d.channel_checked);
        } else {
            this.cmc.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.cme = interfaceC0306a;
        } else {
            this.clZ.setAlpha(0.4f);
            this.cma.setAlpha(0.4f);
            this.cmb.setAlpha(0.4f);
            this.cmc.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.cmb.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.cmb.setText(S);
            return;
        }
        this.cmb.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cma.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.cma.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0306a interfaceC0306a = this.cme;
        if (interfaceC0306a != null) {
            interfaceC0306a.a();
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
