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
/* loaded from: classes9.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView aOg;
    private TextView aOh;
    private TextView aOi;
    private TextView aOj;
    private View aOk;
    private a aOl;
    private a.C0157a aOm;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aOg = (ImageView) findViewById(b.e.coupon_icon);
        this.aOj = (TextView) findViewById(b.e.coupon_text);
        this.aOh = (TextView) findViewById(b.e.coupon_title);
        this.aOi = (TextView) findViewById(b.e.coupon_subtitle);
        this.aOk = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aOl = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0157a> list;
        this.aOm = null;
        a aVar = this.aOl;
        if (!((aVar == null || (list = aVar.aOo) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0157a> it = this.aOl.aOo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0157a next = it.next();
            if (next.aOt == 1) {
                this.aOm = next;
                break;
            }
        }
        if (this.aOm == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.BJ().b(this.aOg, this.aOm.icon);
        this.aOh.setText(this.aOm.aOp);
        a.C0157a c0157a = this.aOm;
        if (c0157a.type == -1) {
            str = c0157a.aOq;
            this.aOi.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aOm.aOs.longValue()) + "元";
            this.aOi.setVisibility(0);
            this.aOi.setText(this.aOm.aOq);
        }
        this.aOj.setText(str);
        if (this.aOl.aOn) {
            this.aOj.setTextColor(getResources().getColor(b.C0153b.coupon_description));
            this.aOk.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aOj.setTextColor(getResources().getColor(b.C0153b.black));
        this.aOk.setVisibility(8);
        setEnabled(false);
    }

    public a.C0157a getSelectedItem() {
        return this.aOm;
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
