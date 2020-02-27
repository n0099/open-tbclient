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
    private TextView aTy;
    private ImageView aUc;
    private TextView aUd;
    private TextView aUe;
    private SwitchButton aUf;
    private n aUg;
    private a aUh;
    private boolean aUi;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0161a c0161a);
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
        public void a(a.C0161a c0161a) {
            HostMarketView.this.aUh.b(c0161a);
            if (c0161a != null) {
                if (c0161a.statusCode == 0) {
                    if (HostMarketView.this.aUf.isChecked()) {
                        HostMarketView.this.aUe.setVisibility(0);
                    } else {
                        HostMarketView.this.aUe.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aUf.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aUg.h(HostMarketView.this.aUf.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aUg == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.EB().b(this.aUc, this.aUg.getIcon());
        this.aTy.setText(this.aUg.t());
        this.aUd.setText(this.aUg.z());
        if (!TextUtils.isEmpty(this.aUg.s())) {
            try {
                this.aUd.setTextColor(Color.parseColor(this.aUg.s()));
            } catch (Exception e) {
            }
        }
        if (this.aUi) {
            this.aUf.setVisibility(4);
            this.aUe.setVisibility(0);
            this.aUe.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aUg.r()) + "元");
            return;
        }
        this.aUf.setVisibility(0);
        this.aUe.setVisibility(4);
        if (this.aUg.w() == 1) {
            this.aUf.setChecked(true);
        } else {
            this.aUf.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aUh = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aUc = (ImageView) findViewById(b.e.icon);
        this.aTy = (TextView) findViewById(b.e.title);
        this.aUd = (TextView) findViewById(b.e.subtitle);
        this.aUe = (TextView) findViewById(b.e.cut_text);
        this.aUf = (SwitchButton) findViewById(b.e.switch_button);
        this.aUf.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUi = false;
        c(context);
    }

    public void a(n nVar) {
        this.aUg = nVar;
        n nVar2 = this.aUg;
        if (nVar2 != null) {
            this.aUi = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aUh != null) {
            this.aUg.h(this.aUf.isChecked() ? 1 : 0);
            this.aUh.a(z, this.aUg, new c());
        }
    }
}
