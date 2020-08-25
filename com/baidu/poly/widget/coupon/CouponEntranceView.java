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
    private ImageView bIc;
    private TextView bId;
    private TextView bIe;
    private TextView bIf;
    private View bIg;
    private a bIh;
    private a.C0277a bIi;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bIc = (ImageView) findViewById(b.e.coupon_icon);
        this.bIf = (TextView) findViewById(b.e.coupon_text);
        this.bId = (TextView) findViewById(b.e.coupon_title);
        this.bIe = (TextView) findViewById(b.e.coupon_subtitle);
        this.bIg = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bIh = aVar;
        h();
    }

    public a.C0277a getSelectedItem() {
        return this.bIi;
    }

    public void h() {
        String str;
        List<a.C0277a> list;
        this.bIi = null;
        a aVar = this.bIh;
        if (!((aVar == null || (list = aVar.bIk) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0277a> it = this.bIh.bIk.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0277a next = it.next();
            if (next.cf == 1) {
                this.bIi = next;
                break;
            }
        }
        if (this.bIi == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.TZ().b(this.bIc, this.bIi.icon);
        this.bId.setText(this.bIi.bIl);
        a.C0277a c0277a = this.bIi;
        if (c0277a.type == -1) {
            str = c0277a.bIm;
            this.bIe.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bIi.bIn.longValue()) + "元";
            this.bIe.setVisibility(0);
            this.bIe.setText(this.bIi.bIm);
        }
        this.bIf.setText(str);
        if (this.bIh.bIj) {
            this.bIf.setTextColor(getResources().getColor(b.C0272b.coupon_description));
            this.bIg.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bIf.setTextColor(getResources().getColor(b.C0272b.black));
        this.bIg.setVisibility(8);
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
