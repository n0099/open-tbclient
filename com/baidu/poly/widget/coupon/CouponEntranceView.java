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
    private ImageView bpQ;
    private TextView bpR;
    private TextView bpS;
    private TextView bpT;
    private View bpU;
    private a bpV;
    private a.C0214a bpW;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bpQ = (ImageView) findViewById(b.e.coupon_icon);
        this.bpT = (TextView) findViewById(b.e.coupon_text);
        this.bpR = (TextView) findViewById(b.e.coupon_title);
        this.bpS = (TextView) findViewById(b.e.coupon_subtitle);
        this.bpU = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bpV = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0214a> list;
        this.bpW = null;
        a aVar = this.bpV;
        if (!((aVar == null || (list = aVar.bpY) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0214a> it = this.bpV.bpY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0214a next = it.next();
            if (next.bqd == 1) {
                this.bpW = next;
                break;
            }
        }
        if (this.bpW == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.KT().b(this.bpQ, this.bpW.icon);
        this.bpR.setText(this.bpW.bpZ);
        a.C0214a c0214a = this.bpW;
        if (c0214a.type == -1) {
            str = c0214a.bqa;
            this.bpS.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bpW.bqc.longValue()) + "元";
            this.bpS.setVisibility(0);
            this.bpS.setText(this.bpW.bqa);
        }
        this.bpT.setText(str);
        if (this.bpV.bpX) {
            this.bpT.setTextColor(getResources().getColor(b.C0210b.coupon_description));
            this.bpU.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bpT.setTextColor(getResources().getColor(b.C0210b.black));
        this.bpU.setVisibility(8);
        setEnabled(false);
    }

    public a.C0214a getSelectedItem() {
        return this.bpW;
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
