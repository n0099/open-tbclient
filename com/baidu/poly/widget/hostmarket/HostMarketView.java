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
    private ImageView bxX;
    private TextView bxY;
    private TextView bxZ;
    private TextView bxu;
    private SwitchButton bya;
    private o byb;
    private a byc;
    private boolean byd;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.j.a aVar);

        void b(a.C0240a c0240a);
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
        public void a(a.C0240a c0240a) {
            HostMarketView.this.byc.b(c0240a);
            if (c0240a != null) {
                if (c0240a.statusCode == 0) {
                    if (HostMarketView.this.bya.isChecked()) {
                        HostMarketView.this.bxZ.setVisibility(0);
                    } else {
                        HostMarketView.this.bxZ.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bya.j();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.byb.h(HostMarketView.this.bya.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void g() {
        if (this.byb == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.c.b.MP().b(this.bxX, this.byb.getIcon());
        this.bxu.setText(this.byb.getDisplayName());
        this.bxY.setText(this.byb.J());
        if (!TextUtils.isEmpty(this.byb.D())) {
            try {
                this.bxY.setTextColor(Color.parseColor(this.byb.D()));
            } catch (Exception e) {
            }
        }
        if (this.byd) {
            this.bya.setVisibility(4);
            this.bxZ.setVisibility(0);
            this.bxZ.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.byb.C()) + "元");
            return;
        }
        this.bya.setVisibility(0);
        this.bxZ.setVisibility(4);
        if (this.byb.G() == 1) {
            this.bya.setChecked(true);
        } else {
            this.bya.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.byc = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bxX = (ImageView) findViewById(b.e.icon);
        this.bxu = (TextView) findViewById(b.e.title);
        this.bxY = (TextView) findViewById(b.e.subtitle);
        this.bxZ = (TextView) findViewById(b.e.cut_text);
        this.bya = (SwitchButton) findViewById(b.e.switch_button);
        this.bya.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byd = false;
        c(context);
    }

    public void a(o oVar) {
        this.byb = oVar;
        o oVar2 = this.byb;
        if (oVar2 != null) {
            this.byd = oVar2.G() == 1;
        }
        g();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.byc != null) {
            this.byb.h(this.bya.isChecked() ? 1 : 0);
            this.byc.a(z, this.byb, new c());
        }
    }
}
