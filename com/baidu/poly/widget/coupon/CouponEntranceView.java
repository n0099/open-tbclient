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
    private ImageView bCj;
    private TextView bCk;
    private TextView bCl;
    private TextView bCm;
    private View bCn;
    private a bCo;
    private a.C0253a bCp;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bCj = (ImageView) findViewById(b.e.coupon_icon);
        this.bCm = (TextView) findViewById(b.e.coupon_text);
        this.bCk = (TextView) findViewById(b.e.coupon_title);
        this.bCl = (TextView) findViewById(b.e.coupon_subtitle);
        this.bCn = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bCo = aVar;
        g();
    }

    public void g() {
        String str;
        List<a.C0253a> list;
        this.bCp = null;
        a aVar = this.bCo;
        if (!((aVar == null || (list = aVar.bCr) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0253a> it = this.bCo.bCr.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0253a next = it.next();
            if (next.bCw == 1) {
                this.bCp = next;
                break;
            }
        }
        if (this.bCp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.NY().b(this.bCj, this.bCp.icon);
        this.bCk.setText(this.bCp.bCs);
        a.C0253a c0253a = this.bCp;
        if (c0253a.type == -1) {
            str = c0253a.bCt;
            this.bCl.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bCp.bCv.longValue()) + "元";
            this.bCl.setVisibility(0);
            this.bCl.setText(this.bCp.bCt);
        }
        this.bCm.setText(str);
        if (this.bCo.bCq) {
            this.bCm.setTextColor(getResources().getColor(b.C0249b.coupon_description));
            this.bCn.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bCm.setTextColor(getResources().getColor(b.C0249b.black));
        this.bCn.setVisibility(8);
        setEnabled(false);
    }

    public a.C0253a getSelectedItem() {
        return this.bCp;
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
