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
    private ImageView ceZ;
    private TextView cfa;
    private TextView cfb;
    private TextView cfc;
    private View cfd;
    private a cfe;
    private a.C0316a cff;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.ceZ = (ImageView) findViewById(b.e.coupon_icon);
        this.cfc = (TextView) findViewById(b.e.coupon_text);
        this.cfa = (TextView) findViewById(b.e.coupon_title);
        this.cfb = (TextView) findViewById(b.e.coupon_subtitle);
        this.cfd = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cfe = aVar;
        h();
    }

    public a.C0316a getSelectedItem() {
        return this.cff;
    }

    public void h() {
        String str;
        List<a.C0316a> list;
        this.cff = null;
        a aVar = this.cfe;
        if (!((aVar == null || (list = aVar.cfh) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0316a> it = this.cfe.cfh.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0316a next = it.next();
            if (next.cf == 1) {
                this.cff = next;
                break;
            }
        }
        if (this.cff == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aaY().b(this.ceZ, this.cff.icon);
        this.cfa.setText(this.cff.cfi);
        a.C0316a c0316a = this.cff;
        if (c0316a.type == -1) {
            str = c0316a.cfj;
            this.cfb.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cff.cfk.longValue()) + "元";
            this.cfb.setVisibility(0);
            this.cfb.setText(this.cff.cfj);
        }
        this.cfc.setText(str);
        if (this.cfe.cfg) {
            this.cfc.setTextColor(getResources().getColor(b.C0311b.coupon_description));
            this.cfd.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cfc.setTextColor(getResources().getColor(b.C0311b.black));
        this.cfd.setVisibility(8);
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
