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
    private TextView aTA;
    private ImageView aUe;
    private TextView aUf;
    private TextView aUg;
    private SwitchButton aUh;
    private n aUi;
    private a aUj;
    private boolean aUk;

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
            HostMarketView.this.aUj.b(c0161a);
            if (c0161a != null) {
                if (c0161a.statusCode == 0) {
                    if (HostMarketView.this.aUh.isChecked()) {
                        HostMarketView.this.aUg.setVisibility(0);
                    } else {
                        HostMarketView.this.aUg.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aUh.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aUi.h(HostMarketView.this.aUh.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aUi == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.ED().b(this.aUe, this.aUi.getIcon());
        this.aTA.setText(this.aUi.t());
        this.aUf.setText(this.aUi.z());
        if (!TextUtils.isEmpty(this.aUi.s())) {
            try {
                this.aUf.setTextColor(Color.parseColor(this.aUi.s()));
            } catch (Exception e) {
            }
        }
        if (this.aUk) {
            this.aUh.setVisibility(4);
            this.aUg.setVisibility(0);
            this.aUg.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aUi.r()) + "元");
            return;
        }
        this.aUh.setVisibility(0);
        this.aUg.setVisibility(4);
        if (this.aUi.w() == 1) {
            this.aUh.setChecked(true);
        } else {
            this.aUh.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aUj = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aUe = (ImageView) findViewById(b.e.icon);
        this.aTA = (TextView) findViewById(b.e.title);
        this.aUf = (TextView) findViewById(b.e.subtitle);
        this.aUg = (TextView) findViewById(b.e.cut_text);
        this.aUh = (SwitchButton) findViewById(b.e.switch_button);
        this.aUh.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUk = false;
        c(context);
    }

    public void a(n nVar) {
        this.aUi = nVar;
        n nVar2 = this.aUi;
        if (nVar2 != null) {
            this.aUk = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aUj != null) {
            this.aUi.h(this.aUh.isChecked() ? 1 : 0);
            this.aUj.a(z, this.aUi, new c());
        }
    }
}
