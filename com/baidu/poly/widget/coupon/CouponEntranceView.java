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
    private View aTC;
    private a aTD;
    private a.C0168a aTE;
    private ImageView aTy;
    private TextView aTz;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.aTy = (ImageView) findViewById(b.e.coupon_icon);
        this.aTB = (TextView) findViewById(b.e.coupon_text);
        this.aTz = (TextView) findViewById(b.e.coupon_title);
        this.aTA = (TextView) findViewById(b.e.coupon_subtitle);
        this.aTC = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.aTD = aVar;
        e();
    }

    public void e() {
        String str;
        List<a.C0168a> list;
        this.aTE = null;
        a aVar = this.aTD;
        if (!((aVar == null || (list = aVar.aTG) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0168a> it = this.aTD.aTG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0168a next = it.next();
            if (next.aTL == 1) {
                this.aTE = next;
                break;
            }
        }
        if (this.aTE == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.ED().b(this.aTy, this.aTE.icon);
        this.aTz.setText(this.aTE.aTH);
        a.C0168a c0168a = this.aTE;
        if (c0168a.type == -1) {
            str = c0168a.aTI;
            this.aTA.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aTE.aTK.longValue()) + "元";
            this.aTA.setVisibility(0);
            this.aTA.setText(this.aTE.aTI);
        }
        this.aTB.setText(str);
        if (this.aTD.aTF) {
            this.aTB.setTextColor(getResources().getColor(b.C0164b.coupon_description));
            this.aTC.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.aTB.setTextColor(getResources().getColor(b.C0164b.black));
        this.aTC.setVisibility(8);
        setEnabled(false);
    }

    public a.C0168a getSelectedItem() {
        return this.aTE;
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
