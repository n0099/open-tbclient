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
import d.a.a0.e;
import d.a.a0.f;
import d.a.a0.g;
import d.a.a0.k.d.b;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9414e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9415f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9416g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f9417h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0118a f9418i;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0118a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    public void a(o oVar, InterfaceC0118a interfaceC0118a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        b.c().b(this.f9414e, icon);
        this.f9415f.setText(displayName);
        if (P == 1) {
            this.f9417h.setImageResource(e.channel_checked);
        } else {
            this.f9417h.setImageResource(e.unchecked);
        }
        if (1 == N) {
            this.f9418i = interfaceC0118a;
        } else {
            this.f9414e.setAlpha(0.4f);
            this.f9415f.setAlpha(0.4f);
            this.f9416g.setAlpha(0.4f);
            this.f9417h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.f9416g.setTextColor(Color.parseColor(M));
                } catch (Exception unused) {
                }
            }
            this.f9416g.setText(S);
            return;
        }
        this.f9416g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9415f.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.f9415f.setLayoutParams(layoutParams);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(g.view_channel_list_item, (ViewGroup) this, true);
        this.f9414e = (ImageView) findViewById(f.channel_icon_view);
        this.f9415f = (TextView) findViewById(f.channel_name_view);
        this.f9416g = (TextView) findViewById(f.channel_desc_view);
        this.f9417h = (ImageView) findViewById(f.channel_select_view);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0118a interfaceC0118a = this.f9418i;
        if (interfaceC0118a != null) {
            interfaceC0118a.a();
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
