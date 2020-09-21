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
    private ImageView bKK;
    private TextView bKL;
    private TextView bKM;
    private SwitchButton bKN;
    private o bKO;
    private a bKP;
    private boolean bKQ;
    private TextView bKi;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0268a c0268a);
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
        public void a(a.C0268a c0268a) {
            HostMarketView.this.bKP.b(c0268a);
            if (c0268a != null) {
                if (c0268a.statusCode == 0) {
                    if (HostMarketView.this.bKN.isChecked()) {
                        HostMarketView.this.bKM.setVisibility(0);
                    } else {
                        HostMarketView.this.bKM.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bKN.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bKO.i(HostMarketView.this.bKN.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.bKO == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.UI().b(this.bKK, this.bKO.getIcon());
        this.bKi.setText(this.bKO.getDisplayName());
        this.bKL.setText(this.bKO.S());
        if (!TextUtils.isEmpty(this.bKO.M())) {
            try {
                this.bKL.setTextColor(Color.parseColor(this.bKO.M()));
            } catch (Exception e) {
            }
        }
        if (this.bKQ) {
            this.bKN.setVisibility(4);
            this.bKM.setVisibility(0);
            this.bKM.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bKO.L()) + "元");
            return;
        }
        this.bKN.setVisibility(0);
        this.bKM.setVisibility(4);
        if (this.bKO.P() == 1) {
            this.bKN.setChecked(true);
        } else {
            this.bKN.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bKP = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bKK = (ImageView) findViewById(b.e.icon);
        this.bKi = (TextView) findViewById(b.e.title);
        this.bKL = (TextView) findViewById(b.e.subtitle);
        this.bKM = (TextView) findViewById(b.e.cut_text);
        this.bKN = (SwitchButton) findViewById(b.e.switch_button);
        this.bKN.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKQ = false;
        c(context);
    }

    public void a(o oVar) {
        this.bKO = oVar;
        o oVar2 = this.bKO;
        if (oVar2 != null) {
            this.bKQ = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bKP != null) {
            this.bKO.i(this.bKN.isChecked() ? 1 : 0);
            this.bKP.a(z, this.bKO, new c());
        }
    }
}
