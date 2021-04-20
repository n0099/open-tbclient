package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.z.c;
import d.b.z.f;
import d.b.z.g;
import d.b.z.k.d.b;
import d.b.z.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10011e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10012f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10013g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10014h;
    public View i;
    public a j;
    public a.C1810a k;

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
        this.f10011e = (ImageView) findViewById(f.coupon_icon);
        this.f10014h = (TextView) findViewById(f.coupon_text);
        this.f10012f = (TextView) findViewById(f.coupon_title);
        this.f10013g = (TextView) findViewById(f.coupon_subtitle);
        this.i = findViewById(f.icon_more);
    }

    public void d() {
        String str;
        List<a.C1810a> list;
        this.k = null;
        a aVar = this.j;
        if (!((aVar == null || (list = aVar.f65753b) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C1810a> it = this.j.f65753b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C1810a next = it.next();
            if (next.f65760g == 1) {
                this.k = next;
                break;
            }
        }
        if (this.k == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.c().b(this.f10011e, this.k.f65758e);
        this.f10012f.setText(this.k.f65755b);
        a.C1810a c1810a = this.k;
        if (c1810a.f65754a == -1) {
            str = c1810a.f65756c;
            this.f10013g.setVisibility(8);
        } else {
            str = "-" + a(this.k.f65759f.longValue()) + "元";
            this.f10013g.setVisibility(0);
            this.f10013g.setText(this.k.f65756c);
        }
        this.f10014h.setText(str);
        if (this.j.f65752a) {
            this.f10014h.setTextColor(getResources().getColor(c.coupon_description));
            this.i.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.f10014h.setTextColor(getResources().getColor(c.black));
        this.i.setVisibility(8);
        setEnabled(false);
    }

    public a.C1810a getSelectedItem() {
        return this.k;
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
