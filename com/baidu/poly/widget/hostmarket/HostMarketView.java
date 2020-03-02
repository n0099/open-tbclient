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
    private TextView aTz;
    private ImageView aUd;
    private TextView aUe;
    private TextView aUf;
    private SwitchButton aUg;
    private n aUh;
    private a aUi;
    private boolean aUj;

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
            HostMarketView.this.aUi.b(c0161a);
            if (c0161a != null) {
                if (c0161a.statusCode == 0) {
                    if (HostMarketView.this.aUg.isChecked()) {
                        HostMarketView.this.aUf.setVisibility(0);
                    } else {
                        HostMarketView.this.aUf.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aUg.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aUh.h(HostMarketView.this.aUg.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aUh == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.ED().b(this.aUd, this.aUh.getIcon());
        this.aTz.setText(this.aUh.t());
        this.aUe.setText(this.aUh.z());
        if (!TextUtils.isEmpty(this.aUh.s())) {
            try {
                this.aUe.setTextColor(Color.parseColor(this.aUh.s()));
            } catch (Exception e) {
            }
        }
        if (this.aUj) {
            this.aUg.setVisibility(4);
            this.aUf.setVisibility(0);
            this.aUf.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aUh.r()) + "元");
            return;
        }
        this.aUg.setVisibility(0);
        this.aUf.setVisibility(4);
        if (this.aUh.w() == 1) {
            this.aUg.setChecked(true);
        } else {
            this.aUg.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aUi = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aUd = (ImageView) findViewById(b.e.icon);
        this.aTz = (TextView) findViewById(b.e.title);
        this.aUe = (TextView) findViewById(b.e.subtitle);
        this.aUf = (TextView) findViewById(b.e.cut_text);
        this.aUg = (SwitchButton) findViewById(b.e.switch_button);
        this.aUg.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUj = false;
        c(context);
    }

    public void a(n nVar) {
        this.aUh = nVar;
        n nVar2 = this.aUh;
        if (nVar2 != null) {
            this.aUj = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aUi != null) {
            this.aUh.h(this.aUg.isChecked() ? 1 : 0);
            this.aUi.a(z, this.aUh, new c());
        }
    }
}
