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
import com.baidu.poly.widget.o;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
/* loaded from: classes11.dex */
public class HostMarketView extends FrameLayout {
    private ImageView bCN;
    private TextView bCO;
    private TextView bCP;
    private SwitchButton bCQ;
    private o bCR;
    private a bCS;
    private boolean bCT;
    private TextView bCk;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0246a c0246a);
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
        public void a(a.C0246a c0246a) {
            HostMarketView.this.bCS.b(c0246a);
            if (c0246a != null) {
                if (c0246a.statusCode == 0) {
                    if (HostMarketView.this.bCQ.isChecked()) {
                        HostMarketView.this.bCP.setVisibility(0);
                    } else {
                        HostMarketView.this.bCP.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bCQ.j();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bCR.h(HostMarketView.this.bCQ.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void g() {
        if (this.bCR == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.NY().b(this.bCN, this.bCR.getIcon());
        this.bCk.setText(this.bCR.getDisplayName());
        this.bCO.setText(this.bCR.J());
        if (!TextUtils.isEmpty(this.bCR.D())) {
            try {
                this.bCO.setTextColor(Color.parseColor(this.bCR.D()));
            } catch (Exception e) {
            }
        }
        if (this.bCT) {
            this.bCQ.setVisibility(4);
            this.bCP.setVisibility(0);
            this.bCP.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bCR.C()) + "元");
            return;
        }
        this.bCQ.setVisibility(0);
        this.bCP.setVisibility(4);
        if (this.bCR.G() == 1) {
            this.bCQ.setChecked(true);
        } else {
            this.bCQ.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bCS = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bCN = (ImageView) findViewById(b.e.icon);
        this.bCk = (TextView) findViewById(b.e.title);
        this.bCO = (TextView) findViewById(b.e.subtitle);
        this.bCP = (TextView) findViewById(b.e.cut_text);
        this.bCQ = (SwitchButton) findViewById(b.e.switch_button);
        this.bCQ.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCT = false;
        c(context);
    }

    public void a(o oVar) {
        this.bCR = oVar;
        o oVar2 = this.bCR;
        if (oVar2 != null) {
            this.bCT = oVar2.G() == 1;
        }
        g();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bCS != null) {
            this.bCR.h(this.bCQ.isChecked() ? 1 : 0);
            this.bCS.a(z, this.bCR, new c());
        }
    }
}
