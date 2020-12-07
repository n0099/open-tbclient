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
/* loaded from: classes19.dex */
public class HostMarketView extends FrameLayout {
    private TextView cjT;
    private o ckA;
    private a ckB;
    private boolean ckC;
    private ImageView ckw;
    private TextView ckx;
    private TextView cky;
    private SwitchButton ckz;

    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0318a c0318a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0318a c0318a) {
            HostMarketView.this.ckB.b(c0318a);
            if (c0318a != null) {
                if (c0318a.statusCode == 0) {
                    if (HostMarketView.this.ckz.isChecked()) {
                        HostMarketView.this.cky.setVisibility(0);
                    } else {
                        HostMarketView.this.cky.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.ckz.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.ckA.i(HostMarketView.this.ckz.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.ckA == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.adx().b(this.ckw, this.ckA.getIcon());
        this.cjT.setText(this.ckA.getDisplayName());
        this.ckx.setText(this.ckA.S());
        if (!TextUtils.isEmpty(this.ckA.M())) {
            try {
                this.ckx.setTextColor(Color.parseColor(this.ckA.M()));
            } catch (Exception e) {
            }
        }
        if (this.ckC) {
            this.ckz.setVisibility(4);
            this.cky.setVisibility(0);
            this.cky.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.ckA.L()) + "元");
            return;
        }
        this.ckz.setVisibility(0);
        this.cky.setVisibility(4);
        if (this.ckA.P() == 1) {
            this.ckz.setChecked(true);
        } else {
            this.ckz.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.ckB = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.ckw = (ImageView) findViewById(b.e.icon);
        this.cjT = (TextView) findViewById(b.e.title);
        this.ckx = (TextView) findViewById(b.e.subtitle);
        this.cky = (TextView) findViewById(b.e.cut_text);
        this.ckz = (SwitchButton) findViewById(b.e.switch_button);
        this.ckz.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ckC = false;
        c(context);
    }

    public void a(o oVar) {
        this.ckA = oVar;
        o oVar2 = this.ckA;
        if (oVar2 != null) {
            this.ckC = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.ckB != null) {
            this.ckA.i(this.ckz.isChecked() ? 1 : 0);
            this.ckB.a(z, this.ckA, new c());
        }
    }
}
