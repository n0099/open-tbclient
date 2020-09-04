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
    private ImageView bIg;
    private TextView bIh;
    private TextView bIi;
    private TextView bIj;
    private View bIk;
    private a bIl;
    private a.C0277a bIm;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bIg = (ImageView) findViewById(b.e.coupon_icon);
        this.bIj = (TextView) findViewById(b.e.coupon_text);
        this.bIh = (TextView) findViewById(b.e.coupon_title);
        this.bIi = (TextView) findViewById(b.e.coupon_subtitle);
        this.bIk = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bIl = aVar;
        h();
    }

    public a.C0277a getSelectedItem() {
        return this.bIm;
    }

    public void h() {
        String str;
        List<a.C0277a> list;
        this.bIm = null;
        a aVar = this.bIl;
        if (!((aVar == null || (list = aVar.bIo) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0277a> it = this.bIl.bIo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0277a next = it.next();
            if (next.cf == 1) {
                this.bIm = next;
                break;
            }
        }
        if (this.bIm == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.TZ().b(this.bIg, this.bIm.icon);
        this.bIh.setText(this.bIm.bIp);
        a.C0277a c0277a = this.bIm;
        if (c0277a.type == -1) {
            str = c0277a.bIq;
            this.bIi.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bIm.bIr.longValue()) + "元";
            this.bIi.setVisibility(0);
            this.bIi.setText(this.bIm.bIq);
        }
        this.bIj.setText(str);
        if (this.bIl.bIn) {
            this.bIj.setTextColor(getResources().getColor(b.C0272b.coupon_description));
            this.bIk.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bIj.setTextColor(getResources().getColor(b.C0272b.black));
        this.bIk.setVisibility(8);
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
