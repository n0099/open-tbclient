package com.baidu.swan.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.b.g0.i.f;
import d.b.g0.i.h;
import d.b.g0.i.i;
import d.b.g0.i.j;
import d.b.g0.i.o;
/* loaded from: classes3.dex */
public class SwanAppMenuItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12659e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12660f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12661g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12662h;
    public o i;
    public int j;
    public int k;
    public boolean l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppMenuItemView.this.i == null || SwanAppMenuItemView.this.i.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = SwanAppMenuItemView.this;
            swanAppMenuItemView.l = swanAppMenuItemView.i.d().a(SwanAppMenuItemView.this.i);
        }
    }

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.l = false;
        this.m = new a();
        e();
    }

    private void setItemView(o oVar) {
        this.f12660f.setEllipsize(TextUtils.TruncateAt.END);
        this.f12660f.setAlpha(oVar.j() ? 1.0f : 0.3f);
        System.out.println(oVar.j());
        this.f12659e.setEnabled(oVar.j());
        this.f12659e.setScaleType(ImageView.ScaleType.CENTER);
        this.f12659e.setVisibility(0);
        g(oVar);
        f(oVar);
    }

    public final String c(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    public final Drawable d(o oVar) {
        return oVar.a(getContext());
    }

    public final void e() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(j.aiapp_menu_item_view_layout, this);
        this.f12659e = (ImageView) findViewById(i.aiapp_menu_item_icon);
        this.f12660f = (TextView) findViewById(i.aiapp_menu_item_title);
        this.f12661g = (TextView) findViewById(i.aiapp_menu_item_new_tips);
        this.f12662h = (ImageView) findViewById(i.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    public final void f(o oVar) {
        if (oVar == null) {
            return;
        }
        int f2 = oVar.f();
        if (f2 == 0) {
            this.f12661g.setVisibility(8);
            this.f12661g.setVisibility(8);
        } else if (f2 == 1) {
            this.f12662h.setVisibility(8);
            this.f12661g.setText(c(oVar.e()));
            this.f12661g.setTextColor(getResources().getColor(f.swan_app_menu_item_tip_text));
            this.f12661g.setBackground(getResources().getDrawable(h.swan_app_menu_new_bg));
            this.f12661g.setVisibility(0);
        } else if (f2 != 2) {
            this.f12661g.setVisibility(8);
            this.f12662h.setVisibility(8);
        } else {
            this.f12661g.setVisibility(8);
            this.f12662h.setImageDrawable(getResources().getDrawable(h.swan_app_menu_new_dot));
            this.f12662h.setVisibility(0);
        }
    }

    public final void g(o oVar) {
        if (oVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f12660f.setText(oVar.h(getContext()));
        Drawable d2 = d(oVar);
        if (d2 != null) {
            this.f12659e.setImageDrawable(d2);
            this.f12659e.setImageLevel(oVar.b());
        }
        this.f12660f.setTextColor(getResources().getColor(oVar.i()));
    }

    public void h(o oVar) {
        if (oVar == null) {
            return;
        }
        setItemView(oVar);
        this.i = oVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            o oVar = this.i;
            if (oVar != null && oVar.d() != null) {
                removeCallbacks(this.m);
                this.l = false;
                this.j = x;
                this.k = y;
                postDelayed(this.m, 3000L);
                setPressed(true);
            } else {
                return super.onTouchEvent(motionEvent);
            }
        } else if (action == 1) {
            removeCallbacks(this.m);
            if (!this.l && this.i.g() != null) {
                this.i.g().b(this, this.i);
            }
            this.l = false;
            setPressed(false);
            return super.onTouchEvent(motionEvent);
        } else if (action != 2) {
            if (action == 3) {
                removeCallbacks(this.m);
                this.l = false;
                setPressed(false);
                return super.onTouchEvent(motionEvent);
            }
        } else if (Math.abs(this.j - x) > 10 || Math.abs(this.k - y) > 10) {
            removeCallbacks(this.m);
            this.l = false;
        }
        return true;
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = new a();
        e();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
        this.m = new a();
        e();
    }
}
