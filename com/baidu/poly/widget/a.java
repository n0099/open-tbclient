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
/* loaded from: classes14.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView crT;
    private TextView crU;
    private TextView crV;
    private ImageView crW;
    private InterfaceC0316a crX;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0316a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.crT = (ImageView) findViewById(b.e.channel_icon_view);
        this.crU = (TextView) findViewById(b.e.channel_name_view);
        this.crV = (TextView) findViewById(b.e.channel_desc_view);
        this.crW = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0316a interfaceC0316a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.ads().b(this.crT, icon);
        this.crU.setText(displayName);
        if (P == 1) {
            this.crW.setImageResource(b.d.channel_checked);
        } else {
            this.crW.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.crX = interfaceC0316a;
        } else {
            this.crT.setAlpha(0.4f);
            this.crU.setAlpha(0.4f);
            this.crV.setAlpha(0.4f);
            this.crW.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.crV.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.crV.setText(S);
            return;
        }
        this.crV.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.crU.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.crU.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0316a interfaceC0316a = this.crX;
        if (interfaceC0316a != null) {
            interfaceC0316a.a();
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
