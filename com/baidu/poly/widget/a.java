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
    private ImageView cdh;
    private TextView cdi;
    private TextView cdj;
    private ImageView cdk;
    private InterfaceC0312a cdm;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0312a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_channel_list_item, (ViewGroup) this, true);
        this.cdh = (ImageView) findViewById(b.e.channel_icon_view);
        this.cdi = (TextView) findViewById(b.e.channel_name_view);
        this.cdj = (TextView) findViewById(b.e.channel_desc_view);
        this.cdk = (ImageView) findViewById(b.e.channel_select_view);
        setOnClickListener(this);
    }

    public void a(o oVar, InterfaceC0312a interfaceC0312a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        com.baidu.poly.a.d.b.aap().b(this.cdh, icon);
        this.cdi.setText(displayName);
        if (P == 1) {
            this.cdk.setImageResource(b.d.channel_checked);
        } else {
            this.cdk.setImageResource(b.d.unchecked);
        }
        if (1 == N) {
            this.cdm = interfaceC0312a;
        } else {
            this.cdh.setAlpha(0.4f);
            this.cdi.setAlpha(0.4f);
            this.cdj.setAlpha(0.4f);
            this.cdk.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.cdj.setTextColor(Color.parseColor(M));
                } catch (Exception e) {
                }
            }
            this.cdj.setText(S);
            return;
        }
        this.cdj.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cdi.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.cdi.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0312a interfaceC0312a = this.cdm;
        if (interfaceC0312a != null) {
            interfaceC0312a.a();
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
