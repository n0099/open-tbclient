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
/* loaded from: classes10.dex */
public class HostMarketView extends FrameLayout {
    private TextView aOZ;
    private ImageView aPD;
    private TextView aPE;
    private TextView aPF;
    private SwitchButton aPG;
    private n aPH;
    private a aPI;
    private boolean aPJ;

    /* loaded from: classes10.dex */
    public interface a {
        void a(boolean z, n nVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0152a c0152a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements com.baidu.poly.a.j.a {
        c() {
        }

        @Override // com.baidu.poly.a.j.a
        public void a(a.C0152a c0152a) {
            HostMarketView.this.aPI.b(c0152a);
            if (c0152a != null) {
                if (c0152a.statusCode == 0) {
                    if (HostMarketView.this.aPG.isChecked()) {
                        HostMarketView.this.aPF.setVisibility(0);
                    } else {
                        HostMarketView.this.aPF.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.aPG.g();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.aPH.h(HostMarketView.this.aPG.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.aPH == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.Cf().b(this.aPD, this.aPH.getIcon());
        this.aOZ.setText(this.aPH.t());
        this.aPE.setText(this.aPH.z());
        if (!TextUtils.isEmpty(this.aPH.s())) {
            try {
                this.aPE.setTextColor(Color.parseColor(this.aPH.s()));
            } catch (Exception e) {
            }
        }
        if (this.aPJ) {
            this.aPG.setVisibility(4);
            this.aPF.setVisibility(0);
            this.aPF.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.aPH.r()) + "元");
            return;
        }
        this.aPG.setVisibility(0);
        this.aPF.setVisibility(4);
        if (this.aPH.w() == 1) {
            this.aPG.setChecked(true);
        } else {
            this.aPG.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.aPI = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.aPD = (ImageView) findViewById(b.e.icon);
        this.aOZ = (TextView) findViewById(b.e.title);
        this.aPE = (TextView) findViewById(b.e.subtitle);
        this.aPF = (TextView) findViewById(b.e.cut_text);
        this.aPG = (SwitchButton) findViewById(b.e.switch_button);
        this.aPG.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPJ = false;
        c(context);
    }

    public void a(n nVar) {
        this.aPH = nVar;
        n nVar2 = this.aPH;
        if (nVar2 != null) {
            this.aPJ = nVar2.w() == 1;
        }
        e();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aPI != null) {
            this.aPH.h(this.aPG.isChecked() ? 1 : 0);
            this.aPI.a(z, this.aPH, new c());
        }
    }
}
