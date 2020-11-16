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
    private ImageView cdR;
    private TextView cdS;
    private TextView cdT;
    private SwitchButton cdU;
    private o cdV;
    private a cdW;
    private boolean cdX;
    private TextView cdp;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0307a c0307a);
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
        public void a(a.C0307a c0307a) {
            HostMarketView.this.cdW.b(c0307a);
            if (c0307a != null) {
                if (c0307a.statusCode == 0) {
                    if (HostMarketView.this.cdU.isChecked()) {
                        HostMarketView.this.cdT.setVisibility(0);
                    } else {
                        HostMarketView.this.cdT.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.cdU.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.cdV.i(HostMarketView.this.cdU.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.cdV == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.aap().b(this.cdR, this.cdV.getIcon());
        this.cdp.setText(this.cdV.getDisplayName());
        this.cdS.setText(this.cdV.S());
        if (!TextUtils.isEmpty(this.cdV.M())) {
            try {
                this.cdS.setTextColor(Color.parseColor(this.cdV.M()));
            } catch (Exception e) {
            }
        }
        if (this.cdX) {
            this.cdU.setVisibility(4);
            this.cdT.setVisibility(0);
            this.cdT.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cdV.L()) + "元");
            return;
        }
        this.cdU.setVisibility(0);
        this.cdT.setVisibility(4);
        if (this.cdV.P() == 1) {
            this.cdU.setChecked(true);
        } else {
            this.cdU.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.cdW = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.cdR = (ImageView) findViewById(b.e.icon);
        this.cdp = (TextView) findViewById(b.e.title);
        this.cdS = (TextView) findViewById(b.e.subtitle);
        this.cdT = (TextView) findViewById(b.e.cut_text);
        this.cdU = (SwitchButton) findViewById(b.e.switch_button);
        this.cdU.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdX = false;
        c(context);
    }

    public void a(o oVar) {
        this.cdV = oVar;
        o oVar2 = this.cdV;
        if (oVar2 != null) {
            this.cdX = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.cdW != null) {
            this.cdV.i(this.cdU.isChecked() ? 1 : 0);
            this.cdW.a(z, this.cdV, new c());
        }
    }
}
