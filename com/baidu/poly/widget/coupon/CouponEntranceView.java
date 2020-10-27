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
/* loaded from: classes6.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView bZn;
    private TextView bZo;
    private TextView bZp;
    private TextView bZq;
    private View bZr;
    private a bZs;
    private a.C0304a bZt;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bZn = (ImageView) findViewById(b.e.coupon_icon);
        this.bZq = (TextView) findViewById(b.e.coupon_text);
        this.bZo = (TextView) findViewById(b.e.coupon_title);
        this.bZp = (TextView) findViewById(b.e.coupon_subtitle);
        this.bZr = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bZs = aVar;
        h();
    }

    public a.C0304a getSelectedItem() {
        return this.bZt;
    }

    public void h() {
        String str;
        List<a.C0304a> list;
        this.bZt = null;
        a aVar = this.bZs;
        if (!((aVar == null || (list = aVar.bZv) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0304a> it = this.bZs.bZv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0304a next = it.next();
            if (next.cf == 1) {
                this.bZt = next;
                break;
            }
        }
        if (this.bZt == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.Yz().b(this.bZn, this.bZt.icon);
        this.bZo.setText(this.bZt.bZw);
        a.C0304a c0304a = this.bZt;
        if (c0304a.type == -1) {
            str = c0304a.bZx;
            this.bZp.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bZt.bZy.longValue()) + "元";
            this.bZp.setVisibility(0);
            this.bZp.setText(this.bZt.bZx);
        }
        this.bZq.setText(str);
        if (this.bZs.bZu) {
            this.bZq.setTextColor(getResources().getColor(b.C0299b.coupon_description));
            this.bZr.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bZq.setTextColor(getResources().getColor(b.C0299b.black));
        this.bZr.setVisibility(8);
        setEnabled(false);
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
