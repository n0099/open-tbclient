package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.adp.lib.debug.a.o;
import com.baidu.adp.lib.debug.a.p;
import java.io.IOException;
/* loaded from: classes.dex */
public final class j extends View {
    View a;
    View b;
    TextView c;
    com.baidu.adp.lib.debug.a.e d;
    o e;
    com.baidu.adp.lib.debug.a.h f;
    com.baidu.adp.lib.debug.a.m g;
    com.baidu.adp.lib.debug.a.b h;
    com.baidu.adp.lib.debug.a.j i;
    p j;
    Context k;
    ImageButton l;
    ImageButton m;
    TextView n;
    TextView o;
    TextView p;
    TextView q;
    TextView r;
    TextView s;
    TextView t;
    TextView u;
    TextView v;
    boolean w;

    public j(Context context) {
        super(context);
        this.k = null;
        this.w = true;
        this.k = context;
        try {
            this.d = new com.baidu.adp.lib.debug.a.e(this.k);
            this.e = new o(this.k);
            this.f = new com.baidu.adp.lib.debug.a.h();
            this.g = new com.baidu.adp.lib.debug.a.m();
            this.i = new com.baidu.adp.lib.debug.a.j();
            this.j = new p(this.k);
            this.h = new com.baidu.adp.lib.debug.a.b(this.k);
            this.a = LayoutInflater.from(this.k).inflate(com.baidu.adp.e.adp_debug_monitor_view, (ViewGroup) null);
            this.b = this.a.findViewById(com.baidu.adp.d.monitor_view);
            this.c = (TextView) this.a.findViewById(com.baidu.adp.d.debug_text);
            this.l = (ImageButton) this.a.findViewById(com.baidu.adp.d.debug_switch);
            this.m = (ImageButton) this.a.findViewById(com.baidu.adp.d.debug_refresh);
            this.n = (TextView) this.a.findViewById(com.baidu.adp.d.debug_fps);
            this.o = (TextView) this.a.findViewById(com.baidu.adp.d.debug_mem);
            this.p = (TextView) this.a.findViewById(com.baidu.adp.d.debug_cpu);
            this.q = (TextView) this.a.findViewById(com.baidu.adp.d.debug_gc);
            this.r = (TextView) this.a.findViewById(com.baidu.adp.d.debug_sm);
            this.s = (TextView) this.a.findViewById(com.baidu.adp.d.debug_bt);
            this.t = (TextView) this.a.findViewById(com.baidu.adp.d.debug_snd);
            this.u = (TextView) this.a.findViewById(com.baidu.adp.d.debug_rcv);
            this.v = (TextView) this.a.findViewById(com.baidu.adp.d.debug_total);
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
            if (!this.j.a()) {
                new Thread(this.j).start();
            }
            if (!this.h.a()) {
                this.h.b();
            }
            com.baidu.adp.lib.debug.b.a = new n(this);
            this.m.setOnTouchListener(new k(this));
            this.l.setOnTouchListener(new l(this));
            i.a(this.k, this.a);
            this.a.setOnTouchListener(new m(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        this.a.setVisibility(i);
    }

    public final void onClick(View view) {
    }

    public final void a() {
        if (this.e != null) {
            this.e.c();
        }
        if (this.i != null) {
            this.i.c();
        }
        if (this.d != null) {
            this.d.c();
        }
        if (this.j != null) {
            this.j.c();
        }
        if (this.h != null) {
            this.h.c();
        }
    }
}
