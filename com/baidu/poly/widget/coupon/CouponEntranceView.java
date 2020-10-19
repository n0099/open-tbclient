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
    private ImageView bQQ;
    private TextView bQR;
    private TextView bQS;
    private TextView bQT;
    private View bQU;
    private a bQV;
    private a.C0290a bQW;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bQQ = (ImageView) findViewById(b.e.coupon_icon);
        this.bQT = (TextView) findViewById(b.e.coupon_text);
        this.bQR = (TextView) findViewById(b.e.coupon_title);
        this.bQS = (TextView) findViewById(b.e.coupon_subtitle);
        this.bQU = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bQV = aVar;
        h();
    }

    public a.C0290a getSelectedItem() {
        return this.bQW;
    }

    public void h() {
        String str;
        List<a.C0290a> list;
        this.bQW = null;
        a aVar = this.bQV;
        if (!((aVar == null || (list = aVar.bQY) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0290a> it = this.bQV.bQY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0290a next = it.next();
            if (next.cf == 1) {
                this.bQW = next;
                break;
            }
        }
        if (this.bQW == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.WF().b(this.bQQ, this.bQW.icon);
        this.bQR.setText(this.bQW.bQZ);
        a.C0290a c0290a = this.bQW;
        if (c0290a.type == -1) {
            str = c0290a.bRa;
            this.bQS.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bQW.bRb.longValue()) + "元";
            this.bQS.setVisibility(0);
            this.bQS.setText(this.bQW.bRa);
        }
        this.bQT.setText(str);
        if (this.bQV.bQX) {
            this.bQT.setTextColor(getResources().getColor(b.C0285b.coupon_description));
            this.bQU.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bQT.setTextColor(getResources().getColor(b.C0285b.black));
        this.bQU.setVisibility(8);
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
