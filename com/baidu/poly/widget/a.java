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
import d.b.c0.e;
import d.b.c0.f;
import d.b.c0.g;
import d.b.c0.k.d.b;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10449e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10450f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10451g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f10452h;
    public InterfaceC0134a i;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0134a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    public void a(o oVar, InterfaceC0134a interfaceC0134a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        b.c().b(this.f10449e, icon);
        this.f10450f.setText(displayName);
        if (P == 1) {
            this.f10452h.setImageResource(e.channel_checked);
        } else {
            this.f10452h.setImageResource(e.unchecked);
        }
        if (1 == N) {
            this.i = interfaceC0134a;
        } else {
            this.f10449e.setAlpha(0.4f);
            this.f10450f.setAlpha(0.4f);
            this.f10451g.setAlpha(0.4f);
            this.f10452h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.f10451g.setTextColor(Color.parseColor(M));
                } catch (Exception unused) {
                }
            }
            this.f10451g.setText(S);
            return;
        }
        this.f10451g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10450f.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.f10450f.setLayoutParams(layoutParams);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(g.view_channel_list_item, (ViewGroup) this, true);
        this.f10449e = (ImageView) findViewById(f.channel_icon_view);
        this.f10450f = (TextView) findViewById(f.channel_name_view);
        this.f10451g = (TextView) findViewById(f.channel_desc_view);
        this.f10452h = (ImageView) findViewById(f.channel_select_view);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0134a interfaceC0134a = this.i;
        if (interfaceC0134a != null) {
            interfaceC0134a.a();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
