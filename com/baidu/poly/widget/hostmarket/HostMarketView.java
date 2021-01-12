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
/* loaded from: classes3.dex */
public class HostMarketView extends FrameLayout {
    private ImageView cmJ;
    private TextView cmK;
    private TextView cmL;
    private SwitchButton cmM;
    private o cmN;
    private a cmO;
    private boolean cmP;
    private TextView cmh;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, o oVar, com.baidu.poly.a.k.a aVar);

        void b(a.C0301a c0301a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements com.baidu.poly.a.k.a {
        c() {
        }

        @Override // com.baidu.poly.a.k.a
        public void a(a.C0301a c0301a) {
            HostMarketView.this.cmO.b(c0301a);
            if (c0301a != null) {
                if (c0301a.statusCode == 0) {
                    if (HostMarketView.this.cmM.isChecked()) {
                        HostMarketView.this.cmL.setVisibility(0);
                    } else {
                        HostMarketView.this.cmL.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.cmM.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.cmN.i(HostMarketView.this.cmM.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.cmN == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.abB().b(this.cmJ, this.cmN.getIcon());
        this.cmh.setText(this.cmN.getDisplayName());
        this.cmK.setText(this.cmN.S());
        if (!TextUtils.isEmpty(this.cmN.M())) {
            try {
                this.cmK.setTextColor(Color.parseColor(this.cmN.M()));
            } catch (Exception e) {
            }
        }
        if (this.cmP) {
            this.cmM.setVisibility(4);
            this.cmL.setVisibility(0);
            this.cmL.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.cmN.L()) + "元");
            return;
        }
        this.cmM.setVisibility(0);
        this.cmL.setVisibility(4);
        if (this.cmN.P() == 1) {
            this.cmM.setChecked(true);
        } else {
            this.cmM.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.cmO = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.cmJ = (ImageView) findViewById(b.e.icon);
        this.cmh = (TextView) findViewById(b.e.title);
        this.cmK = (TextView) findViewById(b.e.subtitle);
        this.cmL = (TextView) findViewById(b.e.cut_text);
        this.cmM = (SwitchButton) findViewById(b.e.switch_button);
        this.cmM.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmP = false;
        c(context);
    }

    public void a(o oVar) {
        this.cmN = oVar;
        o oVar2 = this.cmN;
        if (oVar2 != null) {
            this.cmP = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.cmO != null) {
            this.cmN.i(this.cmM.isChecked() ? 1 : 0);
            this.cmO.a(z, this.cmN, new c());
        }
    }
}
