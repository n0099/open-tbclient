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
/* loaded from: classes19.dex */
public class CouponEntranceView extends FrameLayout {
    private ImageView cjS;
    private TextView cjT;
    private TextView cjU;
    private TextView cjV;
    private View cjW;
    private a cjX;
    private a.C0325a cjY;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.cjS = (ImageView) findViewById(b.e.coupon_icon);
        this.cjV = (TextView) findViewById(b.e.coupon_text);
        this.cjT = (TextView) findViewById(b.e.coupon_title);
        this.cjU = (TextView) findViewById(b.e.coupon_subtitle);
        this.cjW = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cjX = aVar;
        h();
    }

    public a.C0325a getSelectedItem() {
        return this.cjY;
    }

    public void h() {
        String str;
        List<a.C0325a> list;
        this.cjY = null;
        a aVar = this.cjX;
        if (!((aVar == null || (list = aVar.cka) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0325a> it = this.cjX.cka.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0325a next = it.next();
            if (next.cke == 1) {
                this.cjY = next;
                break;
            }
        }
        if (this.cjY == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.adx().b(this.cjS, this.cjY.icon);
        this.cjT.setText(this.cjY.ckb);
        a.C0325a c0325a = this.cjY;
        if (c0325a.type == -1) {
            str = c0325a.ckc;
            this.cjU.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cjY.ckd.longValue()) + "元";
            this.cjU.setVisibility(0);
            this.cjU.setText(this.cjY.ckc);
        }
        this.cjV.setText(str);
        if (this.cjX.cjZ) {
            this.cjV.setTextColor(getResources().getColor(b.C0320b.coupon_description));
            this.cjW.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cjV.setTextColor(getResources().getColor(b.C0320b.black));
        this.cjW.setVisibility(8);
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
