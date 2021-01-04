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
import com.baidu.poly.a.k.a;
import com.baidu.poly.b;
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.o;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class HostMarketView extends FrameLayout {
    private TextView cqW;
    private TextView crA;
    private TextView crB;
    private SwitchButton crC;
    private o crD;
    private a crE;
    private boolean crF;
    private ImageView crz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0318a c0318a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0318a c0318a) {
            HostMarketView.this.crE.b(c0318a);
            if (c0318a != null) {
                if (c0318a.statusCode == 0) {
                    if (HostMarketView.this.crC.isChecked()) {
                        HostMarketView.this.crB.setVisibility(0);
                    } else {
                        HostMarketView.this.crB.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.crC.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.crD.i(HostMarketView.this.crC.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.crD == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aft().b(this.crz, this.crD.getIcon());
        this.cqW.setText(this.crD.getDisplayName());
        this.crA.setText(this.crD.S());
        if (!TextUtils.isEmpty(this.crD.M())) {
            try {
                this.crA.setTextColor(Color.parseColor(this.crD.M()));
            } catch (Exception e) {
            }
        }
        if (this.crF) {
            this.crC.setVisibility(4);
            this.crB.setVisibility(0);
            this.crB.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.crD.L()) + "元");
            return;
        }
        this.crC.setVisibility(0);
        this.crB.setVisibility(4);
        if (this.crD.P() == 1) {
            this.crC.setChecked(true);
        } else {
            this.crC.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.crE = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.crz = (ImageView) findViewById(b.e.icon);
        this.cqW = (TextView) findViewById(b.e.title);
        this.crA = (TextView) findViewById(b.e.subtitle);
        this.crB = (TextView) findViewById(b.e.cut_text);
        this.crC = (SwitchButton) findViewById(b.e.switch_button);
        this.crC.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crF = false;
        c(context);
    }

    public void a(o oVar) {
        this.crD = oVar;
        o oVar2 = this.crD;
        if (oVar2 != null) {
            this.crF = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.crE != null) {
            this.crD.i(this.crC.isChecked() ? 1 : 0);
            this.crE.a(z, this.crD, new c());
        }
    }
}
