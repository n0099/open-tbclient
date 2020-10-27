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
    private ImageView bZQ;
    private TextView bZR;
    private TextView bZS;
    private SwitchButton bZT;
    private o bZU;
    private a bZV;
    private boolean bZW;
    private TextView bZo;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0297a c0297a);
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
        public void a(a.C0297a c0297a) {
            HostMarketView.this.bZV.b(c0297a);
            if (c0297a != null) {
                if (c0297a.statusCode == 0) {
                    if (HostMarketView.this.bZT.isChecked()) {
                        HostMarketView.this.bZS.setVisibility(0);
                    } else {
                        HostMarketView.this.bZS.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bZT.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bZU.i(HostMarketView.this.bZT.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.bZU == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.Yz().b(this.bZQ, this.bZU.getIcon());
        this.bZo.setText(this.bZU.getDisplayName());
        this.bZR.setText(this.bZU.S());
        if (!TextUtils.isEmpty(this.bZU.M())) {
            try {
                this.bZR.setTextColor(Color.parseColor(this.bZU.M()));
            } catch (Exception e) {
            }
        }
        if (this.bZW) {
            this.bZT.setVisibility(4);
            this.bZS.setVisibility(0);
            this.bZS.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bZU.L()) + "元");
            return;
        }
        this.bZT.setVisibility(0);
        this.bZS.setVisibility(4);
        if (this.bZU.P() == 1) {
            this.bZT.setChecked(true);
        } else {
            this.bZT.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bZV = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bZQ = (ImageView) findViewById(b.e.icon);
        this.bZo = (TextView) findViewById(b.e.title);
        this.bZR = (TextView) findViewById(b.e.subtitle);
        this.bZS = (TextView) findViewById(b.e.cut_text);
        this.bZT = (SwitchButton) findViewById(b.e.switch_button);
        this.bZT.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZW = false;
        c(context);
    }

    public void a(o oVar) {
        this.bZU = oVar;
        o oVar2 = this.bZU;
        if (oVar2 != null) {
            this.bZW = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bZV != null) {
            this.bZU.i(this.bZT.isChecked() ? 1 : 0);
            this.bZV.a(z, this.bZU, new c());
        }
    }
}
