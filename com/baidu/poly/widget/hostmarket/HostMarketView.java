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
    private ImageView bIF;
    private TextView bIG;
    private TextView bIH;
    private SwitchButton bII;
    private o bIJ;
    private a bIK;
    private boolean bIL;
    private TextView bId;

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
            HostMarketView.this.bIK.b(c0270a);
            if (c0270a != null) {
                if (c0270a.statusCode == 0) {
                    if (HostMarketView.this.bII.isChecked()) {
                        HostMarketView.this.bIH.setVisibility(0);
                    } else {
                        HostMarketView.this.bIH.setVisibility(4);
                    }
                } else {
                    HostMarketView.this.bII.o();
                    Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(b.g.host_market_calculate_error), 0).show();
                }
                HostMarketView.this.bIJ.i(HostMarketView.this.bII.isChecked() ? 1 : 0);
            }
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    private void h() {
        if (this.bIJ == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        com.baidu.poly.a.d.b.TZ().b(this.bIF, this.bIJ.getIcon());
        this.bId.setText(this.bIJ.getDisplayName());
        this.bIG.setText(this.bIJ.S());
        if (!TextUtils.isEmpty(this.bIJ.M())) {
            try {
                this.bIG.setTextColor(Color.parseColor(this.bIJ.M()));
            } catch (Exception e) {
            }
        }
        if (this.bIL) {
            this.bII.setVisibility(4);
            this.bIH.setVisibility(0);
            this.bIH.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER + a(this.bIJ.L()) + "元");
            return;
        }
        this.bII.setVisibility(0);
        this.bIH.setVisibility(4);
        if (this.bIJ.P() == 1) {
            this.bII.setChecked(true);
        } else {
            this.bII.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.bIK = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.hostmarket_item, (ViewGroup) this, true);
        this.bIF = (ImageView) findViewById(b.e.icon);
        this.bId = (TextView) findViewById(b.e.title);
        this.bIG = (TextView) findViewById(b.e.subtitle);
        this.bIH = (TextView) findViewById(b.e.cut_text);
        this.bII = (SwitchButton) findViewById(b.e.switch_button);
        this.bII.setOnCheckedChangeListener(new b());
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIL = false;
        c(context);
    }

    public void a(o oVar) {
        this.bIJ = oVar;
        o oVar2 = this.bIJ;
        if (oVar2 != null) {
            this.bIL = oVar2.P() == 1;
        }
        h();
    }

    private String a(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.bIK != null) {
            this.bIJ.i(this.bII.isChecked() ? 1 : 0);
            this.bIK.a(z, this.bIJ, new c());
        }
    }
}
