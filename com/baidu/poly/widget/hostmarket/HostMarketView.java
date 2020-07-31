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
/* loaded from: classes9.dex */
public class HostMarketView extends FrameLayout {
    private TextView bCC;
    private ImageView bDf;
    private TextView bDg;
    private TextView bDh;
    private SwitchButton bDi;
    private o bDj;
    private a bDk;
    private boolean bDl;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0249a c0249a);
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
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0249a c0249a) {
            HostMarketView.this.bDk.b(c0249a);
            if (c0249a != null) {
                if (c0249a.statusCode == 0) {
                    if (HostMarketView.this.bDi.isChecked()) {
                        HostMarketView.this.bDh.setVisibility(0);
                    } else {
                        HostMarketView.this.bDh.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bDi.j();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bDj.i(HostMarketView.this.bDi.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void g() {
        if (this.bDj == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.Og().b(this.bDf, this.bDj.getIcon());
        this.bCC.setText(this.bDj.getDisplayName());
        this.bDg.setText(this.bDj.R());
        if (!TextUtils.isEmpty(this.bDj.L())) {
            try {
                this.bDg.setTextColor(Color.parseColor(this.bDj.L()));
            } catch (Exception e) {
            }
        }
        if (this.bDl) {
            this.bDi.setVisibility(4);
            this.bDh.setVisibility(0);
            this.bDh.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bDj.K()) + "元");
            return;
        }
        this.bDi.setVisibility(0);
        this.bDh.setVisibility(4);
        if (this.bDj.O() == 1) {
            this.bDi.setChecked(true);
        } else {
            this.bDi.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bDk = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bDf = (ImageView) findViewById(b.e.icon);
        this.bCC = (TextView) findViewById(b.e.title);
        this.bDg = (TextView) findViewById(b.e.subtitle);
        this.bDh = (TextView) findViewById(b.e.cut_text);
        this.bDi = (SwitchButton) findViewById(b.e.switch_button);
        this.bDi.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bDl = false;
        c(context);
    }

    public void a(o oVar) {
        this.bDj = oVar;
        o oVar2 = this.bDj;
        if (oVar2 != null) {
            this.bDl = oVar2.O() == 1;
        }
        g();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bDk != null) {
            this.bDj.i(this.bDi.isChecked() ? 1 : 0);
            this.bDk.a(z, this.bDj, new c());
        }
    }
}
