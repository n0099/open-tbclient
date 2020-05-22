package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.poly.b;
import com.baidu.poly.widget.coupon.a;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView bxt;
    private TextView bxu;
    private TextView bxv;
    private TextView bxw;
    private View bxx;
    private a bxy;
    private a.C0247a bxz;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bxt = (ImageView) findViewById(b.e.coupon_icon);
        this.bxw = (TextView) findViewById(b.e.coupon_text);
        this.bxu = (TextView) findViewById(b.e.coupon_title);
        this.bxv = (TextView) findViewById(b.e.coupon_subtitle);
        this.bxx = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bxy = aVar;
        g();
    }

    public void g() {
        String str;
        List<a.C0247a> list;
        this.bxz = null;
        a aVar = this.bxy;
        if (!((aVar == null || (list = aVar.bxB) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0247a> it = this.bxy.bxB.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0247a next = it.next();
            if (next.bxG == 1) {
                this.bxz = next;
                break;
            }
        }
        if (this.bxz == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.MP().b(this.bxt, this.bxz.icon);
        this.bxu.setText(this.bxz.bxC);
        a.C0247a c0247a = this.bxz;
        if (c0247a.type == -1) {
            str = c0247a.bxD;
            this.bxv.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bxz.bxF.longValue()) + "元";
            this.bxv.setVisibility(0);
            this.bxv.setText(this.bxz.bxD);
        }
        this.bxw.setText(str);
        if (this.bxy.bxA) {
            this.bxw.setTextColor(getResources().getColor(b.C0243b.coupon_description));
            this.bxx.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bxw.setTextColor(getResources().getColor(b.C0243b.black));
        this.bxx.setVisibility(8);
        setEnabled(false);
    }

    public a.C0247a getSelectedItem() {
        return this.bxz;
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CouponEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }
}
