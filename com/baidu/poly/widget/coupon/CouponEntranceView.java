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
    public ImageView f9419e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9420f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9421g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9422h;

    /* renamed from: i  reason: collision with root package name */
    public View f9423i;
    public a j;
    public a.C0488a k;

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
        this.f9419e = (ImageView) findViewById(f.coupon_icon);
        this.f9422h = (TextView) findViewById(f.coupon_text);
        this.f9420f = (TextView) findViewById(f.coupon_title);
        this.f9421g = (TextView) findViewById(f.coupon_subtitle);
        this.f9423i = findViewById(f.icon_more);
    }

    public void d() {
        String str;
        List<a.C0488a> list;
        this.k = null;
        a aVar = this.j;
        if (!((aVar == null || (list = aVar.f38481b) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0488a> it = this.j.f38481b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0488a next = it.next();
            if (next.f38488g == 1) {
                this.k = next;
                break;
            }
        }
        if (this.k == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.c().b(this.f9419e, this.k.f38486e);
        this.f9420f.setText(this.k.f38483b);
        a.C0488a c0488a = this.k;
        if (c0488a.f38482a == -1) {
            str = c0488a.f38484c;
            this.f9421g.setVisibility(8);
        } else {
            str = "-" + a(this.k.f38487f.longValue()) + "元";
            this.f9421g.setVisibility(0);
            this.f9421g.setText(this.k.f38484c);
        }
        this.f9422h.setText(str);
        if (this.j.f38480a) {
            this.f9422h.setTextColor(getResources().getColor(c.coupon_description));
            this.f9423i.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.f9422h.setTextColor(getResources().getColor(c.black));
        this.f9423i.setVisibility(8);
        setEnabled(false);
    }

    public a.C0488a getSelectedItem() {
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
