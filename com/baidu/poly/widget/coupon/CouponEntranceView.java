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
    private TextView aTB;
    private TextView aTC;
    private View aTD;
    private a aTE;
    private a.C0168a aTF;
    private ImageView aTz;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aTz = (ImageView) findViewById(b.e.coupon_icon);
        this.aTC = (TextView) findViewById(b.e.coupon_text);
        this.aTA = (TextView) findViewById(b.e.coupon_title);
        this.aTB = (TextView) findViewById(b.e.coupon_subtitle);
        this.aTD = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aTE = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0168a> list;
        this.aTF = null;
        a aVar = this.aTE;
        if (!((aVar == null || (list = aVar.aTH) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0168a> it = this.aTE.aTH.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0168a next = it.next();
            if (next.aTM == 1) {
                this.aTF = next;
                break;
            }
        }
        if (this.aTF == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.ED().b(this.aTz, this.aTF.icon);
        this.aTA.setText(this.aTF.aTI);
        a.C0168a c0168a = this.aTF;
        if (c0168a.type == -1) {
            str = c0168a.aTJ;
            this.aTB.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aTF.aTL.longValue()) + "元";
            this.aTB.setVisibility(0);
            this.aTB.setText(this.aTF.aTJ);
        }
        this.aTC.setText(str);
        if (this.aTE.aTG) {
            this.aTC.setTextColor(getResources().getColor(b.C0164b.coupon_description));
            this.aTD.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aTC.setTextColor(getResources().getColor(b.C0164b.black));
        this.aTD.setVisibility(8);
        setEnabled(false);
    }

    public a.C0168a getSelectedItem() {
        return this.aTF;
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
