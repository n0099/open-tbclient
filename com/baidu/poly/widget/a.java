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
/* loaded from: classes6.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView bZh;
    private TextView bZi;
    private TextView bZj;
    private ImageView bZk;
    private InterfaceC0302a bZl;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0302a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.bZh = (ImageView) findViewById(b.e.channel_icon_view);
        this.bZi = (TextView) findViewById(b.e.channel_name_view);
        this.bZj = (TextView) findViewById(b.e.channel_desc_view);
        this.bZk = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0302a interfaceC0302a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.Yz().b(this.bZh, icon);
        this.bZi.setText(displayName);
        if (P == 1) {
            this.bZk.setImageResource(b.d.channel_checked);
        } else {
            this.bZk.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.bZl = interfaceC0302a;
        } else {
            this.bZh.setAlpha(0.4f);
            this.bZi.setAlpha(0.4f);
            this.bZj.setAlpha(0.4f);
            this.bZk.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.bZj.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.bZj.setText(S);
            return;
        }
        this.bZj.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bZi.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.bZi.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0302a interfaceC0302a = this.bZl;
        if (interfaceC0302a != null) {
            interfaceC0302a.a();
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
