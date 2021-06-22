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
import com.baidu.poly.widget.SwitchButton;
import com.baidu.poly.widget.o;
import d.a.c0.f;
import d.a.c0.g;
import d.a.c0.h;
import d.a.c0.k.j.a;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class HostMarketView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9404e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9405f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9406g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9407h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f9408i;
    public o j;
    public a k;
    public boolean l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, o oVar, d.a.c0.k.j.a aVar);

        void b(a.C0570a c0570a);
    }

    /* loaded from: classes2.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            HostMarketView.this.h(z);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.c0.k.j.a {
        public c() {
        }

        @Override // d.a.c0.k.j.a
        public void a(a.C0570a c0570a) {
            HostMarketView.this.k.b(c0570a);
            if (c0570a == null) {
                return;
            }
            if (c0570a.f43266a == 0) {
                if (HostMarketView.this.f9408i.isChecked()) {
                    HostMarketView.this.f9407h.setVisibility(0);
                } else {
                    HostMarketView.this.f9407h.setVisibility(4);
                }
            } else {
                HostMarketView.this.f9408i.j();
                Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(h.host_market_calculate_error), 0).show();
            }
            HostMarketView.this.j.i(HostMarketView.this.f9408i.isChecked() ? 1 : 0);
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    public final String b(long j) {
        return new DecimalFormat("0.00").format((j * 1.0d) / 100.0d);
    }

    public void d(o oVar) {
        this.j = oVar;
        if (oVar != null) {
            this.l = oVar.P() == 1;
        }
        j();
    }

    public final void g(Context context) {
        LayoutInflater.from(context).inflate(g.hostmarket_item, (ViewGroup) this, true);
        this.f9404e = (ImageView) findViewById(f.icon);
        this.f9405f = (TextView) findViewById(f.title);
        this.f9406g = (TextView) findViewById(f.subtitle);
        this.f9407h = (TextView) findViewById(f.cut_text);
        SwitchButton switchButton = (SwitchButton) findViewById(f.switch_button);
        this.f9408i = switchButton;
        switchButton.setOnCheckedChangeListener(new b());
    }

    public final void h(boolean z) {
        if (this.k == null) {
            return;
        }
        this.j.i(this.f9408i.isChecked() ? 1 : 0);
        this.k.a(z, this.j, new c());
    }

    public final void j() {
        if (this.j == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d.a.c0.k.d.b.c().b(this.f9404e, this.j.getIcon());
        this.f9405f.setText(this.j.getDisplayName());
        this.f9406g.setText(this.j.S());
        if (!TextUtils.isEmpty(this.j.M())) {
            try {
                this.f9406g.setTextColor(Color.parseColor(this.j.M()));
            } catch (Exception unused) {
            }
        }
        if (this.l) {
            this.f9408i.setVisibility(4);
            this.f9407h.setVisibility(0);
            TextView textView = this.f9407h;
            textView.setText("-" + b(this.j.L()) + "元");
            return;
        }
        this.f9408i.setVisibility(0);
        this.f9407h.setVisibility(4);
        if (this.j.P() == 1) {
            this.f9408i.setChecked(true);
        } else {
            this.f9408i.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.k = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = false;
        g(context);
    }
}
