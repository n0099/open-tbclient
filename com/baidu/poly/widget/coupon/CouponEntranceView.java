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
/* loaded from: classes9.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView bKh;
    private TextView bKi;
    private TextView bKj;
    private TextView bKk;
    private View bKl;
    private a bKm;
    private a.C0275a bKn;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bKh = (ImageView) findViewById(b.e.coupon_icon);
        this.bKk = (TextView) findViewById(b.e.coupon_text);
        this.bKi = (TextView) findViewById(b.e.coupon_title);
        this.bKj = (TextView) findViewById(b.e.coupon_subtitle);
        this.bKl = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bKm = aVar;
        h();
    }

    public a.C0275a getSelectedItem() {
        return this.bKn;
    }

    public void h() {
        String str;
        List<a.C0275a> list;
        this.bKn = null;
        a aVar = this.bKm;
        if (!((aVar == null || (list = aVar.bKp) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0275a> it = this.bKm.bKp.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0275a next = it.next();
            if (next.cf == 1) {
                this.bKn = next;
                break;
            }
        }
        if (this.bKn == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.UI().b(this.bKh, this.bKn.icon);
        this.bKi.setText(this.bKn.bKq);
        a.C0275a c0275a = this.bKn;
        if (c0275a.type == -1) {
            str = c0275a.bKr;
            this.bKj.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bKn.bKs.longValue()) + "元";
            this.bKj.setVisibility(0);
            this.bKj.setText(this.bKn.bKr);
        }
        this.bKk.setText(str);
        if (this.bKm.bKo) {
            this.bKk.setTextColor(getResources().getColor(b.C0270b.coupon_description));
            this.bKl.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bKk.setTextColor(getResources().getColor(b.C0270b.black));
        this.bKl.setVisibility(8);
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
