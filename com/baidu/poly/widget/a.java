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
import d.b.a0.e;
import d.b.a0.f;
import d.b.a0.g;
import d.b.a0.k.d.b;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10007e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10008f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10009g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f10010h;
    public InterfaceC0133a i;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0133a {
        void a();
    }

    public a(Context context) {
        this(context, null);
    }

    public void a(o oVar, InterfaceC0133a interfaceC0133a) {
        String displayName = oVar.getDisplayName();
        String S = oVar.S();
        String icon = oVar.getIcon();
        int P = oVar.P();
        int N = oVar.N();
        b.c().b(this.f10007e, icon);
        this.f10008f.setText(displayName);
        if (P == 1) {
            this.f10010h.setImageResource(e.channel_checked);
        } else {
            this.f10010h.setImageResource(e.unchecked);
        }
        if (1 == N) {
            this.i = interfaceC0133a;
        } else {
            this.f10007e.setAlpha(0.4f);
            this.f10008f.setAlpha(0.4f);
            this.f10009g.setAlpha(0.4f);
            this.f10010h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(S)) {
            String M = oVar.M();
            if (!TextUtils.isEmpty(M)) {
                try {
                    this.f10009g.setTextColor(Color.parseColor(M));
                } catch (Exception unused) {
                }
            }
            this.f10009g.setText(S);
            return;
        }
        this.f10009g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10008f.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.topMargin = 0;
        this.f10008f.setLayoutParams(layoutParams);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(g.view_channel_list_item, (ViewGroup) this, true);
        this.f10007e = (ImageView) findViewById(f.channel_icon_view);
        this.f10008f = (TextView) findViewById(f.channel_name_view);
        this.f10009g = (TextView) findViewById(f.channel_desc_view);
        this.f10010h = (ImageView) findViewById(f.channel_select_view);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0133a interfaceC0133a = this.i;
        if (interfaceC0133a != null) {
            interfaceC0133a.a();
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
