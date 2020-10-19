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
    private TextView bQR;
    private ImageView bRt;
    private TextView bRu;
    private TextView bRv;
    private SwitchButton bRw;
    private o bRx;
    private a bRy;
    private boolean bRz;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0283a c0283a);
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
        public void a(a.C0283a c0283a) {
            HostMarketView.this.bRy.b(c0283a);
            if (c0283a != null) {
                if (c0283a.statusCode == 0) {
                    if (HostMarketView.this.bRw.isChecked()) {
                        HostMarketView.this.bRv.setVisibility(0);
                    } else {
                        HostMarketView.this.bRv.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bRw.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bRx.i(HostMarketView.this.bRw.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.bRx == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.WF().b(this.bRt, this.bRx.getIcon());
        this.bQR.setText(this.bRx.getDisplayName());
        this.bRu.setText(this.bRx.S());
        if (!TextUtils.isEmpty(this.bRx.M())) {
            try {
                this.bRu.setTextColor(Color.parseColor(this.bRx.M()));
            } catch (Exception e) {
            }
        }
        if (this.bRz) {
            this.bRw.setVisibility(4);
            this.bRv.setVisibility(0);
            this.bRv.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bRx.L()) + "元");
            return;
        }
        this.bRw.setVisibility(0);
        this.bRv.setVisibility(4);
        if (this.bRx.P() == 1) {
            this.bRw.setChecked(true);
        } else {
            this.bRw.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bRy = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bRt = (ImageView) findViewById(b.e.icon);
        this.bQR = (TextView) findViewById(b.e.title);
        this.bRu = (TextView) findViewById(b.e.subtitle);
        this.bRv = (TextView) findViewById(b.e.cut_text);
        this.bRw = (SwitchButton) findViewById(b.e.switch_button);
        this.bRw.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRz = false;
        c(context);
    }

    public void a(o oVar) {
        this.bRx = oVar;
        o oVar2 = this.bRx;
        if (oVar2 != null) {
            this.bRz = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bRy != null) {
            this.bRx.i(this.bRw.isChecked() ? 1 : 0);
            this.bRy.a(z, this.bRx, new c());
        }
    }
}
