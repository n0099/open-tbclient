package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.adp.lib.debug.a.o;
/* loaded from: classes.dex */
public class j extends View {

    /* renamed from: a  reason: collision with root package name */
    View f162a;
    View b;
    TextView c;
    com.baidu.adp.lib.debug.a.e d;
    o e;
    com.baidu.adp.lib.debug.a.h f;
    com.baidu.adp.lib.debug.a.m g;
    com.baidu.adp.lib.debug.a.b h;
    com.baidu.adp.lib.debug.a.j i;
    Context j;
    ImageButton k;
    ImageButton l;
    TextView m;
    TextView n;
    TextView o;
    TextView p;
    TextView q;
    TextView r;
    boolean s;

    public j(Context context) {
        super(context);
        this.j = null;
        this.s = true;
        this.j = context;
        a();
    }

    public void a() {
        this.d = new com.baidu.adp.lib.debug.a.e(this.j);
        this.e = new o(this.j);
        this.f = new com.baidu.adp.lib.debug.a.h();
        this.g = new com.baidu.adp.lib.debug.a.m();
        this.i = new com.baidu.adp.lib.debug.a.j();
        this.h = new com.baidu.adp.lib.debug.a.b(this.j);
        this.f162a = LayoutInflater.from(this.j).inflate(com.baidu.adp.f.adp_debug_monitor_view, (ViewGroup) null);
        this.b = this.f162a.findViewById(com.baidu.adp.e.monitor_view);
        this.c = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_text);
        this.k = (ImageButton) this.f162a.findViewById(com.baidu.adp.e.debug_switch);
        this.l = (ImageButton) this.f162a.findViewById(com.baidu.adp.e.debug_refresh);
        this.m = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_fps);
        this.n = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_mem);
        this.o = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_cpu);
        this.p = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_gc);
        this.q = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_sm);
        this.r = (TextView) this.f162a.findViewById(com.baidu.adp.e.debug_bt);
        b();
        this.l.setOnTouchListener(new k(this));
        this.k.setOnTouchListener(new l(this));
        i.a(this.j, this.f162a);
        this.f162a.setOnTouchListener(new m(this));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        this.f162a.setVisibility(i);
    }

    public void onClick(View view) {
    }

    public void b() {
        if (!this.e.a()) {
            new Thread(this.e).start();
        }
        if (!this.f.a()) {
            this.f.b();
        }
        if (!this.g.a()) {
            this.g.b();
        }
        if (!this.h.a()) {
            this.h.b();
        }
        if (!this.i.a()) {
            new Thread(this.i).start();
        }
        if (!this.d.a()) {
            this.d.b();
        }
        if (!this.h.a()) {
            this.h.b();
        }
        com.baidu.adp.lib.debug.b.f152a = new n(this);
    }

    public void c() {
        if (this.e != null) {
            this.e.c();
        }
        if (this.i != null) {
            this.i.c();
        }
        if (this.d != null) {
            this.d.c();
        }
        if (this.h != null) {
            this.d.c();
        }
    }
}
