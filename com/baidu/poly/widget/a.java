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
/* loaded from: classes4.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    private ImageView cqs;
    private TextView cqt;
    private TextView cqu;
    private ImageView cqv;
    private InterfaceC0310a cqw;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0310a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.cqs = (ImageView) findViewById(b.e.channel_icon_view);
        this.cqt = (TextView) findViewById(b.e.channel_name_view);
        this.cqu = (TextView) findViewById(b.e.channel_desc_view);
        this.cqv = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0310a interfaceC0310a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.adp().b(this.cqs, icon);
        this.cqt.setText(displayName);
        if (P == 1) {
            this.cqv.setImageResource(b.d.channel_checked);
        } else {
            this.cqv.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.cqw = interfaceC0310a;
        } else {
            this.cqs.setAlpha(0.4f);
            this.cqt.setAlpha(0.4f);
            this.cqu.setAlpha(0.4f);
            this.cqv.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.cqu.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.cqu.setText(S);
            return;
        }
        this.cqu.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqt.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.cqt.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0310a interfaceC0310a = this.cqw;
        if (interfaceC0310a != null) {
            interfaceC0310a.a();
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
