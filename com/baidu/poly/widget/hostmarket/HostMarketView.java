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
    private ImageView bIJ;
    private TextView bIK;
    private TextView bIL;
    private SwitchButton bIM;
    private o bIN;
    private a bIO;
    private boolean bIP;
    private TextView bIh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0270a c0270a);
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
        public void a(a.C0270a c0270a) {
            HostMarketView.this.bIO.b(c0270a);
            if (c0270a != null) {
                if (c0270a.statusCode == 0) {
                    if (HostMarketView.this.bIM.isChecked()) {
                        HostMarketView.this.bIL.setVisibility(0);
                    } else {
                        HostMarketView.this.bIL.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bIM.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bIN.i(HostMarketView.this.bIM.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.bIN == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.TZ().b(this.bIJ, this.bIN.getIcon());
        this.bIh.setText(this.bIN.getDisplayName());
        this.bIK.setText(this.bIN.S());
        if (!TextUtils.isEmpty(this.bIN.M())) {
            try {
                this.bIK.setTextColor(Color.parseColor(this.bIN.M()));
            } catch (Exception e) {
            }
        }
        if (this.bIP) {
            this.bIM.setVisibility(4);
            this.bIL.setVisibility(0);
            this.bIL.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bIN.L()) + "元");
            return;
        }
        this.bIM.setVisibility(0);
        this.bIL.setVisibility(4);
        if (this.bIN.P() == 1) {
            this.bIM.setChecked(true);
        } else {
            this.bIM.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bIO = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bIJ = (ImageView) findViewById(b.e.icon);
        this.bIh = (TextView) findViewById(b.e.title);
        this.bIK = (TextView) findViewById(b.e.subtitle);
        this.bIL = (TextView) findViewById(b.e.cut_text);
        this.bIM = (SwitchButton) findViewById(b.e.switch_button);
        this.bIM.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIP = false;
        c(context);
    }

    public void a(o oVar) {
        this.bIN = oVar;
        o oVar2 = this.bIN;
        if (oVar2 != null) {
            this.bIP = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bIO != null) {
            this.bIN.i(this.bIM.isChecked() ? 1 : 0);
            this.bIO.a(z, this.bIN, new c());
        }
    }
}
