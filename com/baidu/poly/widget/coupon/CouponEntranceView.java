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
    private ImageView cmg;
    private TextView cmh;
    private TextView cmi;
    private TextView cmj;
    private View cmk;
    private a cml;
    private a.C0308a cmm;

    public CouponEntranceView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.coupon_entrance, (ViewGroup) this, true);
        this.cmg = (ImageView) findViewById(b.e.coupon_icon);
        this.cmj = (TextView) findViewById(b.e.coupon_text);
        this.cmh = (TextView) findViewById(b.e.coupon_title);
        this.cmi = (TextView) findViewById(b.e.coupon_subtitle);
        this.cmk = findViewById(b.e.icon_more);
    }

    public void a(a aVar) {
        this.cml = aVar;
        h();
    }

    public a.C0308a getSelectedItem() {
        return this.cmm;
    }

    public void h() {
        String str;
        List<a.C0308a> list;
        this.cmm = null;
        a aVar = this.cml;
        if (!((aVar == null || (list = aVar.cmo) == null || list.size() <= 0) ? false : true)) {
            setVisibility(8);
            return;
        }
        Iterator<a.C0308a> it = this.cml.cmo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.C0308a next = it.next();
            if (next.cms == 1) {
                this.cmm = next;
                break;
            }
        }
        if (this.cmm == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.abB().b(this.cmg, this.cmm.icon);
        this.cmh.setText(this.cmm.cmp);
        a.C0308a c0308a = this.cmm;
        if (c0308a.type == -1) {
            str = c0308a.cmq;
            this.cmi.setVisibility(8);
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cmm.cmr.longValue()) + "元";
            this.cmi.setVisibility(0);
            this.cmi.setText(this.cmm.cmq);
        }
        this.cmj.setText(str);
        if (this.cml.cmn) {
            this.cmj.setTextColor(getResources().getColor(b.C0303b.coupon_description));
            this.cmk.setVisibility(0);
            setEnabled(true);
            return;
        }
        this.cmj.setTextColor(getResources().getColor(b.C0303b.black));
        this.cmk.setVisibility(8);
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
