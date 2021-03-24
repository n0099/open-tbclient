package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import d.b.g0.a.b1.g.a;
import d.b.g0.a.b1.g.c;
import d.b.g0.a.r1.e;
/* loaded from: classes3.dex */
public class RewardVideoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f12786e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12787f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12788g;

    public RewardVideoView(Context context) {
        this(context, null);
    }

    @NonNull
    public final c a() {
        c cVar = new c();
        cVar.n = "SwanAdPlayer";
        cVar.f43112f = "SwanAdPlayer";
        cVar.s = true;
        cVar.o = this.f12788g;
        cVar.B = false;
        cVar.M = false;
        cVar.I = false;
        return cVar;
    }

    public final void b() {
        e y = e.y();
        if (y == null) {
            return;
        }
        this.f12786e = new a(y.n(), a());
        FrameLayout frameLayout = new FrameLayout(this.f12787f);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f12786e.y(frameLayout);
    }

    public boolean c() {
        return this.f12788g;
    }

    public void d(boolean z) {
        a aVar = this.f12786e;
        if (aVar != null) {
            this.f12788g = z;
            aVar.p(z);
        }
    }

    public void e(String str) {
        c a2 = a();
        a2.C = str;
        this.f12786e.q(a2);
        this.f12786e.x(false);
    }

    public a getPlayer() {
        return this.f12786e;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12787f = context;
        b();
    }
}
