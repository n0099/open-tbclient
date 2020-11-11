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
/* loaded from: classes6.dex */
public class HostMarketView extends FrameLayout {
    private ImageView cfC;
    private TextView cfD;
    private TextView cfE;
    private SwitchButton cfF;
    private o cfG;
    private a cfH;
    private boolean cfI;
    private TextView cfa;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0309a c0309a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0309a c0309a) {
            HostMarketView.this.cfH.b(c0309a);
            if (c0309a != null) {
                if (c0309a.statusCode == 0) {
                    if (HostMarketView.this.cfF.isChecked()) {
                        HostMarketView.this.cfE.setVisibility(0);
                    } else {
                        HostMarketView.this.cfE.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.cfF.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.cfG.i(HostMarketView.this.cfF.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.cfG == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aaY().b(this.cfC, this.cfG.getIcon());
        this.cfa.setText(this.cfG.getDisplayName());
        this.cfD.setText(this.cfG.S());
        if (!TextUtils.isEmpty(this.cfG.M())) {
            try {
                this.cfD.setTextColor(Color.parseColor(this.cfG.M()));
            } catch (Exception e) {
            }
        }
        if (this.cfI) {
            this.cfF.setVisibility(4);
            this.cfE.setVisibility(0);
            this.cfE.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cfG.L()) + "元");
            return;
        }
        this.cfF.setVisibility(0);
        this.cfE.setVisibility(4);
        if (this.cfG.P() == 1) {
            this.cfF.setChecked(true);
        } else {
            this.cfF.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.cfH = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.cfC = (ImageView) findViewById(b.e.icon);
        this.cfa = (TextView) findViewById(b.e.title);
        this.cfD = (TextView) findViewById(b.e.subtitle);
        this.cfE = (TextView) findViewById(b.e.cut_text);
        this.cfF = (SwitchButton) findViewById(b.e.switch_button);
        this.cfF.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfI = false;
        c(context);
    }

    public void a(o oVar) {
        this.cfG = oVar;
        o oVar2 = this.cfG;
        if (oVar2 != null) {
            this.cfI = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.cfH != null) {
            this.cfG.i(this.cfF.isChecked() ? 1 : 0);
            this.cfH.a(z, this.cfG, new c());
        }
    }
}
