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
    private ImageView bCB;
    private TextView bCC;
    private TextView bCD;
    private TextView bCE;
    private View bCF;
    private a bCG;
    private a.C0256a bCH;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.bCB = (ImageView) findViewById(b.e.coupon_icon);
        this.bCE = (TextView) findViewById(b.e.coupon_text);
        this.bCC = (TextView) findViewById(b.e.coupon_title);
        this.bCD = (TextView) findViewById(b.e.coupon_subtitle);
        this.bCF = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.bCG = aVar;
        g();
    }

    public void g() {
        String str;
        List<a.C0256a> list;
        this.bCH = null;
        a aVar = this.bCG;
        if (!((aVar == null || (list = aVar.bCJ) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0256a> it = this.bCG.bCJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0256a next = it.next();
            if (next.bCN == 1) {
                this.bCH = next;
                break;
            }
        }
        if (this.bCH == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.Og().b(this.bCB, this.bCH.icon);
        this.bCC.setText(this.bCH.bCK);
        a.C0256a c0256a = this.bCH;
        if (c0256a.type == -1) {
            str = c0256a.bCL;
            this.bCD.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bCH.bCM.longValue()) + "元";
            this.bCD.setVisibility(0);
            this.bCD.setText(this.bCH.bCL);
        }
        this.bCE.setText(str);
        if (this.bCG.bCI) {
            this.bCE.setTextColor(getResources().getColor(b.C0251b.coupon_description));
            this.bCF.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.bCE.setTextColor(getResources().getColor(b.C0251b.black));
        this.bCF.setVisibility(8);
        setEnabled(false);
    }

    public a.C0256a getSelectedItem() {
        return this.bCH;
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
