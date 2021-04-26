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
import d.a.a0.f;
import d.a.a0.g;
import d.a.a0.h;
import d.a.a0.k.j.a;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class HostMarketView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10402e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10403f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10404g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10405h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f10406i;
    public o j;
    public a k;
    public boolean l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, o oVar, d.a.a0.k.j.a aVar);

        void b(a.C0498a c0498a);
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
    public class c implements d.a.a0.k.j.a {
        public c() {
        }

        @Override // d.a.a0.k.j.a
        public void a(a.C0498a c0498a) {
            HostMarketView.this.k.b(c0498a);
            if (c0498a == null) {
                return;
            }
            if (c0498a.f39217a == 0) {
                if (HostMarketView.this.f10406i.isChecked()) {
                    HostMarketView.this.f10405h.setVisibility(0);
                } else {
                    HostMarketView.this.f10405h.setVisibility(4);
                }
            } else {
                HostMarketView.this.f10406i.j();
                Toast.makeText(HostMarketView.this.getContext(), HostMarketView.this.getResources().getString(h.host_market_calculate_error), 0).show();
            }
            HostMarketView.this.j.i(HostMarketView.this.f10406i.isChecked() ? 1 : 0);
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
        this.f10402e = (ImageView) findViewById(f.icon);
        this.f10403f = (TextView) findViewById(f.title);
        this.f10404g = (TextView) findViewById(f.subtitle);
        this.f10405h = (TextView) findViewById(f.cut_text);
        SwitchButton switchButton = (SwitchButton) findViewById(f.switch_button);
        this.f10406i = switchButton;
        switchButton.setOnCheckedChangeListener(new b());
    }

    public final void h(boolean z) {
        if (this.k == null) {
            return;
        }
        this.j.i(this.f10406i.isChecked() ? 1 : 0);
        this.k.a(z, this.j, new c());
    }

    public final void j() {
        if (this.j == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d.a.a0.k.d.b.c().b(this.f10402e, this.j.getIcon());
        this.f10403f.setText(this.j.getDisplayName());
        this.f10404g.setText(this.j.S());
        if (!TextUtils.isEmpty(this.j.M())) {
            try {
                this.f10404g.setTextColor(Color.parseColor(this.j.M()));
            } catch (Exception unused) {
            }
        }
        if (this.l) {
            this.f10406i.setVisibility(4);
            this.f10405h.setVisibility(0);
            TextView textView = this.f10405h;
            textView.setText("-" + b(this.j.L()) + "元");
            return;
        }
        this.f10406i.setVisibility(0);
        this.f10405h.setVisibility(4);
        if (this.j.P() == 1) {
            this.f10406i.setChecked(true);
        } else {
            this.f10406i.setChecked(false);
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
