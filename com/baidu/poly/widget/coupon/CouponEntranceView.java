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
    private ImageView bpL;
    private TextView bpM;
    private TextView bpN;
    private TextView bpO;
    private View bpP;
    private a bpQ;
    private a.C0192a bpR;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bpL = (ImageView) findViewById(b.e.coupon_icon);
        this.bpO = (TextView) findViewById(b.e.coupon_text);
        this.bpM = (TextView) findViewById(b.e.coupon_title);
        this.bpN = (TextView) findViewById(b.e.coupon_subtitle);
        this.bpP = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bpQ = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0192a> list;
        this.bpR = null;
        a aVar = this.bpQ;
        if (!((aVar == null || (list = aVar.bpT) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0192a> it = this.bpQ.bpT.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0192a next = it.next();
            if (next.bpY == 1) {
                this.bpR = next;
                break;
            }
        }
        if (this.bpR == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.KU().b(this.bpL, this.bpR.icon);
        this.bpM.setText(this.bpR.bpU);
        a.C0192a c0192a = this.bpR;
        if (c0192a.type == -1) {
            str = c0192a.bpV;
            this.bpN.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bpR.bpX.longValue()) + "元";
            this.bpN.setVisibility(0);
            this.bpN.setText(this.bpR.bpV);
        }
        this.bpO.setText(str);
        if (this.bpQ.bpS) {
            this.bpO.setTextColor(getResources().getColor(b.C0188b.coupon_description));
            this.bpP.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bpO.setTextColor(getResources().getColor(b.C0188b.black));
        this.bpP.setVisibility(8);
        setEnabled(false);
    }

    public a.C0192a getSelectedItem() {
        return this.bpR;
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
