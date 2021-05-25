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
import d.a.c0.e;
import d.a.c0.f;
import d.a.c0.g;
import d.a.c0.k.d.b;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9314e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9315f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9316g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f9317h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0119a f9318i;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0119a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    public void a(o oVar, InterfaceC0119a interfaceC0119a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        b.c().b(this.f9314e, icon);
        this.f9315f.setText(displayName);
        if (P == 1) {
            this.f9317h.setImageResource(e.channel_checked);
        } else {
            this.f9317h.setImageResource(e.unchecked);
        }
        if (1 == N) {
            this.f9318i = interfaceC0119a;
        } else {
            this.f9314e.setAlpha(0.4f);
            this.f9315f.setAlpha(0.4f);
            this.f9316g.setAlpha(0.4f);
            this.f9317h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.f9316g.setTextColor(Color.parseColor(M));
                } catch (Exception unused) {
                }
            }
            this.f9316g.setText(S);
            return;
        }
        this.f9316g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9315f.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.f9315f.setLayoutParams(layoutParams);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(g.view_channel_list_item, (ViewGroup) this, true);
        this.f9314e = (ImageView) findViewById(f.channel_icon_view);
        this.f9315f = (TextView) findViewById(f.channel_name_view);
        this.f9316g = (TextView) findViewById(f.channel_desc_view);
        this.f9317h = (ImageView) findViewById(f.channel_select_view);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0119a interfaceC0119a = this.f9318i;
        if (interfaceC0119a != null) {
            interfaceC0119a.a();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context);
    }
}
