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
    private TextView aTA;
    private View aTB;
    private a aTC;
    private a.C0168a aTD;
    private ImageView aTx;
    private TextView aTy;
    private TextView aTz;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aTx = (ImageView) findViewById(b.e.coupon_icon);
        this.aTA = (TextView) findViewById(b.e.coupon_text);
        this.aTy = (TextView) findViewById(b.e.coupon_title);
        this.aTz = (TextView) findViewById(b.e.coupon_subtitle);
        this.aTB = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aTC = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0168a> list;
        this.aTD = null;
        a aVar = this.aTC;
        if (!((aVar == null || (list = aVar.aTF) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0168a> it = this.aTC.aTF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0168a next = it.next();
            if (next.aTK == 1) {
                this.aTD = next;
                break;
            }
        }
        if (this.aTD == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.EB().b(this.aTx, this.aTD.icon);
        this.aTy.setText(this.aTD.aTG);
        a.C0168a c0168a = this.aTD;
        if (c0168a.type == -1) {
            str = c0168a.aTH;
            this.aTz.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aTD.aTJ.longValue()) + "元";
            this.aTz.setVisibility(0);
            this.aTz.setText(this.aTD.aTH);
        }
        this.aTA.setText(str);
        if (this.aTC.aTE) {
            this.aTA.setTextColor(getResources().getColor(b.C0164b.coupon_description));
            this.aTB.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aTA.setTextColor(getResources().getColor(b.C0164b.black));
        this.aTB.setVisibility(8);
        setEnabled(false);
    }

    public a.C0168a getSelectedItem() {
        return this.aTD;
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
