package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import d.b.c0.c;
import d.b.c0.f;
import d.b.c0.g;
import d.b.c0.k.d.b;
import d.b.c0.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10452e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10453f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10454g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10455h;
    public View i;
    public a j;
    public a.C0572a k;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    public final String a(long j) {
        double d2 = j;
        Double.isNaN(d2);
        return new DecimalFormat("0.00").format((d2 * 1.0d) / 100.0d);
    }

    public void b(a aVar) {
        this.j = aVar;
        d();
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(g.coupon_entrance, (ViewGroup) this, true);
        this.f10452e = (ImageView) findViewById(f.coupon_icon);
        this.f10455h = (TextView) findViewById(f.coupon_text);
        this.f10453f = (TextView) findViewById(f.coupon_title);
        this.f10454g = (TextView) findViewById(f.coupon_subtitle);
        this.i = findViewById(f.icon_more);
    }

    public void d() {
        String str;
        List<a.C0572a> list;
        this.k = null;
        a aVar = this.j;
        if (!((aVar == null || (list = aVar.f42684b) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0572a> it = this.j.f42684b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0572a next = it.next();
            if (next.f42691g == 1) {
                this.k = next;
                break;
            }
        }
        if (this.k == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.c().b(this.f10452e, this.k.f42689e);
        this.f10453f.setText(this.k.f42686b);
        a.C0572a c0572a = this.k;
        if (c0572a.f42685a == -1) {
            str = c0572a.f42687c;
            this.f10454g.setVisibility(8);
        } else {
            str = "-" + a(this.k.f42690f.longValue()) + "元";
            this.f10454g.setVisibility(0);
            this.f10454g.setText(this.k.f42687c);
        }
        this.f10455h.setText(str);
        if (this.j.f42683a) {
            this.f10455h.setTextColor(getResources().getColor(c.coupon_description));
            this.i.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.f10455h.setTextColor(getResources().getColor(c.black));
        this.i.setVisibility(8);
        setEnabled(false);
    }

    public a.C0572a getSelectedItem() {
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
