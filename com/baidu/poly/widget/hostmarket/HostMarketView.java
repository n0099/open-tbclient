package com.baidu.poly.widget.hostmarket;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.poly.a.j.a;
import com.baidu.poly.b;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.n;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
/* loaded from: classes11.dex */
public class HostMarketView extends FrameLayout {
    private TextView bpM;
    private ImageView bqq;
    private TextView bqr;
    private TextView bqs;
    private SwitchButton bqt;
    private n bqu;
    private a bqv;
    private boolean bqw;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0185a c0185a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements com.baidu.poly.a.j.a {
        c() {
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0185a c0185a) {
            HostMarketView.this.bqv.b(c0185a);
            if (c0185a != null) {
                if (c0185a.statusCode == 0) {
                    if (HostMarketView.this.bqt.isChecked()) {
                        HostMarketView.this.bqs.setVisibility(0);
                    } else {
                        HostMarketView.this.bqs.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bqt.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bqu.h(HostMarketView.this.bqt.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.bqu == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.KU().b(this.bqq, this.bqu.getIcon());
        this.bpM.setText(this.bqu.t());
        this.bqr.setText(this.bqu.z());
        if (!TextUtils.isEmpty(this.bqu.s())) {
            try {
                this.bqr.setTextColor(Color.parseColor(this.bqu.s()));
            } catch (Exception e) {
            }
        }
        if (this.bqw) {
            this.bqt.setVisibility(4);
            this.bqs.setVisibility(0);
            this.bqs.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bqu.r()) + "元");
            return;
        }
        this.bqt.setVisibility(0);
        this.bqs.setVisibility(4);
        if (this.bqu.w() == 1) {
            this.bqt.setChecked(true);
        } else {
            this.bqt.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bqv = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bqq = (ImageView) findViewById(b.e.icon);
        this.bpM = (TextView) findViewById(b.e.title);
        this.bqr = (TextView) findViewById(b.e.subtitle);
        this.bqs = (TextView) findViewById(b.e.cut_text);
        this.bqt = (SwitchButton) findViewById(b.e.switch_button);
        this.bqt.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqw = false;
        c(context);
    }

    public void a(n nVar) {
        this.bqu = nVar;
        n nVar2 = this.bqu;
        if (nVar2 != null) {
            this.bqw = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bqv != null) {
            this.bqu.h(this.bqt.isChecked() ? 1 : 0);
            this.bqv.a(z, this.bqu, new c());
        }
    }
}
