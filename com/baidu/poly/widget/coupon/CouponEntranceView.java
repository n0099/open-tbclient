package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import d.a.a0.c;
import d.a.a0.f;
import d.a.a0.g;
import d.a.a0.k.d.b;
import d.a.a0.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10382e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10383f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10384g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10385h;

    /* renamed from: i  reason: collision with root package name */
    public View f10386i;
    public a j;
    public a.C0501a k;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    public final String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    public void b(a aVar) {
        this.j = aVar;
        d();
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(g.coupon_entrance, (ViewGroup) this, true);
        this.f10382e = (ImageView) findViewById(f.coupon_icon);
        this.f10385h = (TextView) findViewById(f.coupon_text);
        this.f10383f = (TextView) findViewById(f.coupon_title);
        this.f10384g = (TextView) findViewById(f.coupon_subtitle);
        this.f10386i = findViewById(f.icon_more);
    }

    public void d() {
        String str;
        List<a.C0501a> list;
        this.k = null;
        a aVar = this.j;
        if (!((aVar == null || (list = aVar.f39236b) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0501a> it = this.j.f39236b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0501a next = it.next();
            if (next.f39243g == 1) {
                this.k = next;
                break;
            }
        }
        if (this.k == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.c().b(this.f10382e, this.k.f39241e);
        this.f10383f.setText(this.k.f39238b);
        a.C0501a c0501a = this.k;
        if (c0501a.f39237a == -1) {
            str = c0501a.f39239c;
            this.f10384g.setVisibility(8);
        } else {
            str = "-" + a(this.k.f39242f.longValue()) + "元";
            this.f10384g.setVisibility(0);
            this.f10384g.setText(this.k.f39239c);
        }
        this.f10385h.setText(str);
        if (this.j.f39235a) {
            this.f10385h.setTextColor(getResources().getColor(c.coupon_description));
            this.f10386i.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.f10385h.setTextColor(getResources().getColor(c.black));
        this.f10386i.setVisibility(8);
        setEnabled(false);
    }

    public a.C0501a getSelectedItem() {
        return this.k;
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
