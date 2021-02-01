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
/* loaded from: classes4.dex */
public class HostMarketView extends FrameLayout {
    private TextView cqz;
    private ImageView crb;
    private TextView crd;
    private TextView cre;
    private SwitchButton crf;
    private o crg;
    private a crh;
    private boolean cri;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0305a c0305a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0305a c0305a) {
            HostMarketView.this.crh.b(c0305a);
            if (c0305a != null) {
                if (c0305a.statusCode == 0) {
                    if (HostMarketView.this.crf.isChecked()) {
                        HostMarketView.this.cre.setVisibility(0);
                    } else {
                        HostMarketView.this.cre.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.crf.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.crg.i(HostMarketView.this.crf.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.crg == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.adp().b(this.crb, this.crg.getIcon());
        this.cqz.setText(this.crg.getDisplayName());
        this.crd.setText(this.crg.S());
        if (!TextUtils.isEmpty(this.crg.M())) {
            try {
                this.crd.setTextColor(Color.parseColor(this.crg.M()));
            } catch (Exception e) {
            }
        }
        if (this.cri) {
            this.crf.setVisibility(4);
            this.cre.setVisibility(0);
            this.cre.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.crg.L()) + "元");
            return;
        }
        this.crf.setVisibility(0);
        this.cre.setVisibility(4);
        if (this.crg.P() == 1) {
            this.crf.setChecked(true);
        } else {
            this.crf.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.crh = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.crb = (ImageView) findViewById(b.e.icon);
        this.cqz = (TextView) findViewById(b.e.title);
        this.crd = (TextView) findViewById(b.e.subtitle);
        this.cre = (TextView) findViewById(b.e.cut_text);
        this.crf = (SwitchButton) findViewById(b.e.switch_button);
        this.crf.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cri = false;
        c(context);
    }

    public void a(o oVar) {
        this.crg = oVar;
        o oVar2 = this.crg;
        if (oVar2 != null) {
            this.cri = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.crh != null) {
            this.crg.i(this.crf.isChecked() ? 1 : 0);
            this.crh.a(z, this.crg, new c());
        }
    }
}
