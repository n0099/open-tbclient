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
/* loaded from: classes10.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView aOY;
    private TextView aOZ;
    private TextView aPa;
    private TextView aPb;
    private View aPc;
    private a aPd;
    private a.C0159a aPe;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aOY = (ImageView) findViewById(b.e.coupon_icon);
        this.aPb = (TextView) findViewById(b.e.coupon_text);
        this.aOZ = (TextView) findViewById(b.e.coupon_title);
        this.aPa = (TextView) findViewById(b.e.coupon_subtitle);
        this.aPc = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aPd = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0159a> list;
        this.aPe = null;
        a aVar = this.aPd;
        if (!((aVar == null || (list = aVar.aPg) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0159a> it = this.aPd.aPg.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0159a next = it.next();
            if (next.aPl == 1) {
                this.aPe = next;
                break;
            }
        }
        if (this.aPe == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.Cf().b(this.aOY, this.aPe.icon);
        this.aOZ.setText(this.aPe.aPh);
        a.C0159a c0159a = this.aPe;
        if (c0159a.type == -1) {
            str = c0159a.aPi;
            this.aPa.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aPe.aPk.longValue()) + "元";
            this.aPa.setVisibility(0);
            this.aPa.setText(this.aPe.aPi);
        }
        this.aPb.setText(str);
        if (this.aPd.aPf) {
            this.aPb.setTextColor(getResources().getColor(b.C0155b.coupon_description));
            this.aPc.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aPb.setTextColor(getResources().getColor(b.C0155b.black));
        this.aPc.setVisibility(8);
        setEnabled(false);
    }

    public a.C0159a getSelectedItem() {
        return this.aPe;
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
