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
    private TextView bpR;
    private a bqA;
    private boolean bqB;
    private ImageView bqv;
    private TextView bqw;
    private TextView bqx;
    private SwitchButton bqy;
    private n bqz;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0207a c0207a);
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
        public void a(a.C0207a c0207a) {
            HostMarketView.this.bqA.b(c0207a);
            if (c0207a != null) {
                if (c0207a.statusCode == 0) {
                    if (HostMarketView.this.bqy.isChecked()) {
                        HostMarketView.this.bqx.setVisibility(0);
                    } else {
                        HostMarketView.this.bqx.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bqy.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bqz.h(HostMarketView.this.bqy.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.bqz == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.KT().b(this.bqv, this.bqz.getIcon());
        this.bpR.setText(this.bqz.t());
        this.bqw.setText(this.bqz.z());
        if (!TextUtils.isEmpty(this.bqz.s())) {
            try {
                this.bqw.setTextColor(Color.parseColor(this.bqz.s()));
            } catch (Exception e) {
            }
        }
        if (this.bqB) {
            this.bqy.setVisibility(4);
            this.bqx.setVisibility(0);
            this.bqx.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bqz.r()) + "元");
            return;
        }
        this.bqy.setVisibility(0);
        this.bqx.setVisibility(4);
        if (this.bqz.w() == 1) {
            this.bqy.setChecked(true);
        } else {
            this.bqy.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bqA = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bqv = (ImageView) findViewById(b.e.icon);
        this.bpR = (TextView) findViewById(b.e.title);
        this.bqw = (TextView) findViewById(b.e.subtitle);
        this.bqx = (TextView) findViewById(b.e.cut_text);
        this.bqy = (SwitchButton) findViewById(b.e.switch_button);
        this.bqy.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqB = false;
        c(context);
    }

    public void a(n nVar) {
        this.bqz = nVar;
        n nVar2 = this.bqz;
        if (nVar2 != null) {
            this.bqB = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bqA != null) {
            this.bqz.h(this.bqy.isChecked() ? 1 : 0);
            this.bqA.a(z, this.bqz, new c());
        }
    }
}
