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
/* loaded from: classes14.dex */
public class HostMarketView extends FrameLayout {
    private ImageView csC;
    private TextView csD;
    private TextView csE;
    private SwitchButton csF;
    private o csG;
    private a csH;
    private boolean csI;
    private TextView csa;

    /* loaded from: classes14.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0311a c0311a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0311a c0311a) {
            HostMarketView.this.csH.b(c0311a);
            if (c0311a != null) {
                if (c0311a.statusCode == 0) {
                    if (HostMarketView.this.csF.isChecked()) {
                        HostMarketView.this.csE.setVisibility(0);
                    } else {
                        HostMarketView.this.csE.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.csF.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.csG.i(HostMarketView.this.csF.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.csG == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.ads().b(this.csC, this.csG.getIcon());
        this.csa.setText(this.csG.getDisplayName());
        this.csD.setText(this.csG.S());
        if (!TextUtils.isEmpty(this.csG.M())) {
            try {
                this.csD.setTextColor(Color.parseColor(this.csG.M()));
            } catch (Exception e) {
            }
        }
        if (this.csI) {
            this.csF.setVisibility(4);
            this.csE.setVisibility(0);
            this.csE.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.csG.L()) + "元");
            return;
        }
        this.csF.setVisibility(0);
        this.csE.setVisibility(4);
        if (this.csG.P() == 1) {
            this.csF.setChecked(true);
        } else {
            this.csF.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.csH = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.csC = (ImageView) findViewById(b.e.icon);
        this.csa = (TextView) findViewById(b.e.title);
        this.csD = (TextView) findViewById(b.e.subtitle);
        this.csE = (TextView) findViewById(b.e.cut_text);
        this.csF = (SwitchButton) findViewById(b.e.switch_button);
        this.csF.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csI = false;
        c(context);
    }

    public void a(o oVar) {
        this.csG = oVar;
        o oVar2 = this.csG;
        if (oVar2 != null) {
            this.csI = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.csH != null) {
            this.csG.i(this.csF.isChecked() ? 1 : 0);
            this.csH.a(z, this.csG, new c());
        }
    }
}
