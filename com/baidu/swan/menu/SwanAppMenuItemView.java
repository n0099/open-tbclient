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
import d.a.h0.i.f;
import d.a.h0.i.h;
import d.a.h0.i.i;
import d.a.h0.i.j;
import d.a.h0.i.o;
/* loaded from: classes3.dex */
public class SwanAppMenuItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12569e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12570f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12571g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12572h;

    /* renamed from: i  reason: collision with root package name */
    public o f12573i;
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
            if (SwanAppMenuItemView.this.f12573i == null || SwanAppMenuItemView.this.f12573i.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = SwanAppMenuItemView.this;
            swanAppMenuItemView.l = swanAppMenuItemView.f12573i.d().a(SwanAppMenuItemView.this.f12573i);
        }
    }

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.l = false;
        this.m = new a();
        e();
    }

    private void setItemView(o oVar) {
        this.f12570f.setEllipsize(TextUtils.TruncateAt.END);
        this.f12570f.setAlpha(oVar.j() ? 1.0f : 0.3f);
        System.out.println(oVar.j());
        this.f12569e.setEnabled(oVar.j());
        this.f12569e.setScaleType(ImageView.ScaleType.CENTER);
        this.f12569e.setVisibility(0);
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
        this.f12569e = (ImageView) findViewById(i.aiapp_menu_item_icon);
        this.f12570f = (TextView) findViewById(i.aiapp_menu_item_title);
        this.f12571g = (TextView) findViewById(i.aiapp_menu_item_new_tips);
        this.f12572h = (ImageView) findViewById(i.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    public final void f(o oVar) {
        if (oVar == null) {
            return;
        }
        int f2 = oVar.f();
        if (f2 == 0) {
            this.f12571g.setVisibility(8);
            this.f12571g.setVisibility(8);
        } else if (f2 == 1) {
            this.f12572h.setVisibility(8);
            this.f12571g.setText(c(oVar.e()));
            this.f12571g.setTextColor(getResources().getColor(f.swan_app_menu_item_tip_text));
            this.f12571g.setBackground(getResources().getDrawable(h.swan_app_menu_new_bg));
            this.f12571g.setVisibility(0);
        } else if (f2 != 2) {
            this.f12571g.setVisibility(8);
            this.f12572h.setVisibility(8);
        } else {
            this.f12571g.setVisibility(8);
            this.f12572h.setImageDrawable(getResources().getDrawable(h.swan_app_menu_new_dot));
            this.f12572h.setVisibility(0);
        }
    }

    public final void g(o oVar) {
        if (oVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f12570f.setText(oVar.h(getContext()));
        Drawable d2 = d(oVar);
        if (d2 != null) {
            this.f12569e.setImageDrawable(d2);
            this.f12569e.setImageLevel(oVar.b());
        }
        this.f12570f.setTextColor(getResources().getColor(oVar.i()));
    }

    public void h(o oVar) {
        if (oVar == null) {
            return;
        }
        setItemView(oVar);
        this.f12573i = oVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            o oVar = this.f12573i;
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
            if (!this.l && this.f12573i.g() != null) {
                this.f12573i.g().b(this, this.f12573i);
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

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = false;
        this.m = new a();
        e();
    }
}
