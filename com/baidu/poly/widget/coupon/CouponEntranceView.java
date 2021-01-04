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
/* loaded from: classes3.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView cqV;
    private TextView cqW;
    private TextView cqX;
    private TextView cqY;
    private View cqZ;
    private a cra;
    private a.C0325a crb;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.cqV = (ImageView) findViewById(b.e.coupon_icon);
        this.cqY = (TextView) findViewById(b.e.coupon_text);
        this.cqW = (TextView) findViewById(b.e.coupon_title);
        this.cqX = (TextView) findViewById(b.e.coupon_subtitle);
        this.cqZ = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cra = aVar;
        h();
    }

    public a.C0325a getSelectedItem() {
        return this.crb;
    }

    public void h() {
        String str;
        List<a.C0325a> list;
        this.crb = null;
        a aVar = this.cra;
        if (!((aVar == null || (list = aVar.cre) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0325a> it = this.cra.cre.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0325a next = it.next();
            if (next.cri == 1) {
                this.crb = next;
                break;
            }
        }
        if (this.crb == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aft().b(this.cqV, this.crb.icon);
        this.cqW.setText(this.crb.crf);
        a.C0325a c0325a = this.crb;
        if (c0325a.type == -1) {
            str = c0325a.crg;
            this.cqX.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.crb.crh.longValue()) + "元";
            this.cqX.setVisibility(0);
            this.cqX.setText(this.crb.crg);
        }
        this.cqY.setText(str);
        if (this.cra.crd) {
            this.cqY.setTextColor(getResources().getColor(b.C0320b.coupon_description));
            this.cqZ.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cqY.setTextColor(getResources().getColor(b.C0320b.black));
        this.cqZ.setVisibility(8);
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
