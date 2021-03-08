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
/* loaded from: classes14.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView crZ;
    private TextView csa;
    private TextView csb;
    private TextView csc;
    private View csd;
    private a cse;
    private a.C0318a csf;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.crZ = (ImageView) findViewById(b.e.coupon_icon);
        this.csc = (TextView) findViewById(b.e.coupon_text);
        this.csa = (TextView) findViewById(b.e.coupon_title);
        this.csb = (TextView) findViewById(b.e.coupon_subtitle);
        this.csd = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cse = aVar;
        h();
    }

    public a.C0318a getSelectedItem() {
        return this.csf;
    }

    public void h() {
        String str;
        List<a.C0318a> list;
        this.csf = null;
        a aVar = this.cse;
        if (!((aVar == null || (list = aVar.csh) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0318a> it = this.cse.csh.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0318a next = it.next();
            if (next.csl == 1) {
                this.csf = next;
                break;
            }
        }
        if (this.csf == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.ads().b(this.crZ, this.csf.icon);
        this.csa.setText(this.csf.csi);
        a.C0318a c0318a = this.csf;
        if (c0318a.type == -1) {
            str = c0318a.csj;
            this.csb.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.csf.csk.longValue()) + "元";
            this.csb.setVisibility(0);
            this.csb.setText(this.csf.csj);
        }
        this.csc.setText(str);
        if (this.cse.csg) {
            this.csc.setTextColor(getResources().getColor(b.C0313b.coupon_description));
            this.csd.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.csc.setTextColor(getResources().getColor(b.C0313b.black));
        this.csd.setVisibility(8);
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
