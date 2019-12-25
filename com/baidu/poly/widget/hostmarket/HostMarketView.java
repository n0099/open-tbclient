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
/* loaded from: classes9.dex */
public class HostMarketView extends FrameLayout {
    private ImageView aOL;
    private TextView aOM;
    private TextView aON;
    private SwitchButton aOO;
    private n aOP;
    private a aOQ;
    private boolean aOR;
    private TextView aOh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0150a c0150a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements com.baidu.poly.a.j.a {
        c() {
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0150a c0150a) {
            HostMarketView.this.aOQ.b(c0150a);
            if (c0150a != null) {
                if (c0150a.statusCode == 0) {
                    if (HostMarketView.this.aOO.isChecked()) {
                        HostMarketView.this.aON.setVisibility(0);
                    } else {
                        HostMarketView.this.aON.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aOO.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aOP.h(HostMarketView.this.aOO.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aOP == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.BJ().b(this.aOL, this.aOP.getIcon());
        this.aOh.setText(this.aOP.t());
        this.aOM.setText(this.aOP.z());
        if (!TextUtils.isEmpty(this.aOP.s())) {
            try {
                this.aOM.setTextColor(Color.parseColor(this.aOP.s()));
            } catch (Exception e) {
            }
        }
        if (this.aOR) {
            this.aOO.setVisibility(4);
            this.aON.setVisibility(0);
            this.aON.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aOP.r()) + "元");
            return;
        }
        this.aOO.setVisibility(0);
        this.aON.setVisibility(4);
        if (this.aOP.w() == 1) {
            this.aOO.setChecked(true);
        } else {
            this.aOO.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aOQ = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aOL = (ImageView) findViewById(b.e.icon);
        this.aOh = (TextView) findViewById(b.e.title);
        this.aOM = (TextView) findViewById(b.e.subtitle);
        this.aON = (TextView) findViewById(b.e.cut_text);
        this.aOO = (SwitchButton) findViewById(b.e.switch_button);
        this.aOO.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOR = false;
        c(context);
    }

    public void a(n nVar) {
        this.aOP = nVar;
        n nVar2 = this.aOP;
        if (nVar2 != null) {
            this.aOR = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aOQ != null) {
            this.aOP.h(this.aOO.isChecked() ? 1 : 0);
            this.aOQ.a(z, this.aOP, new c());
        }
    }
}
