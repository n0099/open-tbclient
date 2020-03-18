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
    private TextView aTN;
    private ImageView aUr;
    private TextView aUs;
    private TextView aUt;
    private SwitchButton aUu;
    private n aUv;
    private a aUw;
    private boolean aUx;

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
            HostMarketView.this.aUw.b(c0161a);
            if (c0161a != null) {
                if (c0161a.statusCode == 0) {
                    if (HostMarketView.this.aUu.isChecked()) {
                        HostMarketView.this.aUt.setVisibility(0);
                    } else {
                        HostMarketView.this.aUt.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aUu.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aUv.h(HostMarketView.this.aUu.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aUv == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.EJ().b(this.aUr, this.aUv.getIcon());
        this.aTN.setText(this.aUv.t());
        this.aUs.setText(this.aUv.z());
        if (!TextUtils.isEmpty(this.aUv.s())) {
            try {
                this.aUs.setTextColor(Color.parseColor(this.aUv.s()));
            } catch (Exception e) {
            }
        }
        if (this.aUx) {
            this.aUu.setVisibility(4);
            this.aUt.setVisibility(0);
            this.aUt.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aUv.r()) + "元");
            return;
        }
        this.aUu.setVisibility(0);
        this.aUt.setVisibility(4);
        if (this.aUv.w() == 1) {
            this.aUu.setChecked(true);
        } else {
            this.aUu.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aUw = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aUr = (ImageView) findViewById(b.e.icon);
        this.aTN = (TextView) findViewById(b.e.title);
        this.aUs = (TextView) findViewById(b.e.subtitle);
        this.aUt = (TextView) findViewById(b.e.cut_text);
        this.aUu = (SwitchButton) findViewById(b.e.switch_button);
        this.aUu.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUx = false;
        c(context);
    }

    public void a(n nVar) {
        this.aUv = nVar;
        n nVar2 = this.aUv;
        if (nVar2 != null) {
            this.aUx = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aUw != null) {
            this.aUv.h(this.aUu.isChecked() ? 1 : 0);
            this.aUw.a(z, this.aUv, new c());
        }
    }
}
