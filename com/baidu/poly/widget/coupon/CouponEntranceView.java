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
    private ImageView aTM;
    private TextView aTN;
    private TextView aTO;
    private TextView aTP;
    private View aTQ;
    private a aTR;
    private a.C0168a aTS;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aTM = (ImageView) findViewById(b.e.coupon_icon);
        this.aTP = (TextView) findViewById(b.e.coupon_text);
        this.aTN = (TextView) findViewById(b.e.coupon_title);
        this.aTO = (TextView) findViewById(b.e.coupon_subtitle);
        this.aTQ = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aTR = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0168a> list;
        this.aTS = null;
        a aVar = this.aTR;
        if (!((aVar == null || (list = aVar.aTU) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0168a> it = this.aTR.aTU.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0168a next = it.next();
            if (next.aTZ == 1) {
                this.aTS = next;
                break;
            }
        }
        if (this.aTS == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.EJ().b(this.aTM, this.aTS.icon);
        this.aTN.setText(this.aTS.aTV);
        a.C0168a c0168a = this.aTS;
        if (c0168a.type == -1) {
            str = c0168a.aTW;
            this.aTO.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aTS.aTY.longValue()) + "元";
            this.aTO.setVisibility(0);
            this.aTO.setText(this.aTS.aTW);
        }
        this.aTP.setText(str);
        if (this.aTR.aTT) {
            this.aTP.setTextColor(getResources().getColor(b.C0164b.coupon_description));
            this.aTQ.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aTP.setTextColor(getResources().getColor(b.C0164b.black));
        this.aTQ.setVisibility(8);
        setEnabled(false);
    }

    public a.C0168a getSelectedItem() {
        return this.aTS;
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
