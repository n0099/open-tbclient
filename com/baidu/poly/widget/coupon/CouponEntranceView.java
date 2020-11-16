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
    private ImageView cdo;
    private TextView cdp;
    private TextView cdq;
    private TextView cdr;
    private View cds;
    private a cdt;
    private a.C0314a cdu;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.cdo = (ImageView) findViewById(b.e.coupon_icon);
        this.cdr = (TextView) findViewById(b.e.coupon_text);
        this.cdp = (TextView) findViewById(b.e.coupon_title);
        this.cdq = (TextView) findViewById(b.e.coupon_subtitle);
        this.cds = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cdt = aVar;
        h();
    }

    public a.C0314a getSelectedItem() {
        return this.cdu;
    }

    public void h() {
        String str;
        List<a.C0314a> list;
        this.cdu = null;
        a aVar = this.cdt;
        if (!((aVar == null || (list = aVar.cdw) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0314a> it = this.cdt.cdw.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0314a next = it.next();
            if (next.cf == 1) {
                this.cdu = next;
                break;
            }
        }
        if (this.cdu == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aap().b(this.cdo, this.cdu.icon);
        this.cdp.setText(this.cdu.cdx);
        a.C0314a c0314a = this.cdu;
        if (c0314a.type == -1) {
            str = c0314a.cdy;
            this.cdq.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cdu.cdz.longValue()) + "元";
            this.cdq.setVisibility(0);
            this.cdq.setText(this.cdu.cdy);
        }
        this.cdr.setText(str);
        if (this.cdt.cdv) {
            this.cdr.setTextColor(getResources().getColor(b.C0309b.coupon_description));
            this.cds.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cdr.setTextColor(getResources().getColor(b.C0309b.black));
        this.cds.setVisibility(8);
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
