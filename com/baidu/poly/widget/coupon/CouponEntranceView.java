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
/* loaded from: classes4.dex */
public class CouponEntranceView extends FrameLayout {
    private TextView cqA;
    private TextView cqB;
    private View cqC;
    private a cqD;
    private a.C0312a cqE;
    private ImageView cqy;
    private TextView cqz;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.cqy = (ImageView) findViewById(b.e.coupon_icon);
        this.cqB = (TextView) findViewById(b.e.coupon_text);
        this.cqz = (TextView) findViewById(b.e.coupon_title);
        this.cqA = (TextView) findViewById(b.e.coupon_subtitle);
        this.cqC = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cqD = aVar;
        h();
    }

    public a.C0312a getSelectedItem() {
        return this.cqE;
    }

    public void h() {
        String str;
        List<a.C0312a> list;
        this.cqE = null;
        a aVar = this.cqD;
        if (!((aVar == null || (list = aVar.cqG) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0312a> it = this.cqD.cqG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0312a next = it.next();
            if (next.cqK == 1) {
                this.cqE = next;
                break;
            }
        }
        if (this.cqE == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.adp().b(this.cqy, this.cqE.icon);
        this.cqz.setText(this.cqE.cqH);
        a.C0312a c0312a = this.cqE;
        if (c0312a.type == -1) {
            str = c0312a.cqI;
            this.cqA.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cqE.cqJ.longValue()) + "元";
            this.cqA.setVisibility(0);
            this.cqA.setText(this.cqE.cqI);
        }
        this.cqB.setText(str);
        if (this.cqD.cqF) {
            this.cqB.setTextColor(getResources().getColor(b.C0307b.coupon_description));
            this.cqC.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cqB.setTextColor(getResources().getColor(b.C0307b.black));
        this.cqC.setVisibility(8);
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
