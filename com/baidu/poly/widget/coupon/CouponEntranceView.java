package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import d.a.c0.c;
import d.a.c0.f;
import d.a.c0.g;
import d.a.c0.k.d.b;
import d.a.c0.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9384e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9385f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9386g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9387h;

    /* renamed from: i  reason: collision with root package name */
    public View f9388i;
    public a j;
    public a.C0573a k;

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
        this.f9384e = (ImageView) findViewById(f.coupon_icon);
        this.f9387h = (TextView) findViewById(f.coupon_text);
        this.f9385f = (TextView) findViewById(f.coupon_title);
        this.f9386g = (TextView) findViewById(f.coupon_subtitle);
        this.f9388i = findViewById(f.icon_more);
    }

    public void d() {
        String str;
        List<a.C0573a> list;
        this.k = null;
        a aVar = this.j;
        if (!((aVar == null || (list = aVar.f43285b) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0573a> it = this.j.f43285b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0573a next = it.next();
            if (next.f43292g == 1) {
                this.k = next;
                break;
            }
        }
        if (this.k == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.c().b(this.f9384e, this.k.f43290e);
        this.f9385f.setText(this.k.f43287b);
        a.C0573a c0573a = this.k;
        if (c0573a.f43286a == -1) {
            str = c0573a.f43288c;
            this.f9386g.setVisibility(8);
        } else {
            str = "-" + a(this.k.f43291f.longValue()) + "元";
            this.f9386g.setVisibility(0);
            this.f9386g.setText(this.k.f43288c);
        }
        this.f9387h.setText(str);
        if (this.j.f43284a) {
            this.f9387h.setTextColor(getResources().getColor(c.coupon_description));
            this.f9388i.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.f9387h.setTextColor(getResources().getColor(c.black));
        this.f9388i.setVisibility(8);
        setEnabled(false);
    }

    public a.C0573a getSelectedItem() {
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
