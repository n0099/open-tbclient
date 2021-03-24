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
import d.b.c0.f;
import d.b.c0.g;
import d.b.c0.h;
import d.b.c0.k.j.a;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class HostMarketView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10470e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10471f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10472g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10473h;
    public SwitchButton i;
    public o j;
    public a k;
    public boolean l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(a.C0569a c0569a);

        void b(boolean z, o oVar, d.b.c0.k.j.a aVar);
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
    public class c implements d.b.c0.k.j.a {
        public c() {
        }

        @Override // d.b.c0.k.j.a
        public void a(a.C0569a c0569a) {
            HostMarketView.this.k.a(c0569a);
            if (c0569a == null) {
                return;
            }
            if (c0569a.f42665a == 0) {
                if (HostMarketView.this.i.isChecked()) {
                    HostMarketView.this.f10473h.setVisibility(0);
                } else {
                    HostMarketView.this.f10473h.setVisibility(4);
                }
            } else {
                HostMarketView.this.i.j();
                Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(h.host_market_calculate_error), 0).show();
            }
            HostMarketView.this.j.i(HostMarketView.this.i.isChecked() ? 1 : 0);
        }
    }

    public HostMarketView(Context context) {
        this(context, null);
    }

    public final String b(long j) {
        double d2 = j;
        Double.isNaN(d2);
        return new DecimalFormat("0.00").format((d2 * 1.0d) / 100.0d);
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
        this.f10470e = (ImageView) findViewById(f.icon);
        this.f10471f = (TextView) findViewById(f.title);
        this.f10472g = (TextView) findViewById(f.subtitle);
        this.f10473h = (TextView) findViewById(f.cut_text);
        SwitchButton switchButton = (SwitchButton) findViewById(f.switch_button);
        this.i = switchButton;
        switchButton.setOnCheckedChangeListener(new b());
    }

    public final void h(boolean z) {
        if (this.k == null) {
            return;
        }
        this.j.i(this.i.isChecked() ? 1 : 0);
        this.k.b(z, this.j, new c());
    }

    public final void j() {
        if (this.j == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d.b.c0.k.d.b.c().b(this.f10470e, this.j.getIcon());
        this.f10471f.setText(this.j.getDisplayName());
        this.f10472g.setText(this.j.S());
        if (!TextUtils.isEmpty(this.j.M())) {
            try {
                this.f10472g.setTextColor(Color.parseColor(this.j.M()));
            } catch (Exception unused) {
            }
        }
        if (this.l) {
            this.i.setVisibility(4);
            this.f10473h.setVisibility(0);
            TextView textView = this.f10473h;
            textView.setText("-" + b(this.j.L()) + "元");
            return;
        }
        this.i.setVisibility(0);
        this.f10473h.setVisibility(4);
        if (this.j.P() == 1) {
            this.i.setChecked(true);
        } else {
            this.i.setChecked(false);
        }
    }

    public void setListener(a aVar) {
        this.k = aVar;
    }

    public HostMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HostMarketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
        g(context);
    }
}
