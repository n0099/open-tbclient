package com.baidu.swan.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.i0.k.f;
import d.a.i0.k.g;
import d.a.i0.k.h;
import d.a.i0.k.i;
import d.a.i0.k.j;
import d.a.i0.k.o;
/* loaded from: classes3.dex */
public class SwanAppMenuItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11911e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11912f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11913g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f11914h;

    /* renamed from: i  reason: collision with root package name */
    public o f11915i;
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
            o oVar = SwanAppMenuItemView.this.f11915i;
            if (oVar == null || oVar.d() == null) {
                return;
            }
            SwanAppMenuItemView swanAppMenuItemView = SwanAppMenuItemView.this;
            swanAppMenuItemView.l = swanAppMenuItemView.f11915i.d().a(SwanAppMenuItemView.this.f11915i);
        }
    }

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.l = false;
        this.m = new a();
        d();
    }

    private void setAllPressed(boolean z) {
        this.f11911e.setPressed(z);
        this.f11912f.setPressed(z);
        setPressed(z);
    }

    public final String a(long j) {
        return j <= 99 ? String.valueOf(j) : "99+";
    }

    public final Drawable b(o oVar) {
        return oVar.a(getContext());
    }

    public final int c(int i2) {
        Resources resources = getResources();
        return (int) (((i2 * 0.5d) + (resources.getDimension(g.aiapp_menu_item_icon_width) * 0.5d)) - resources.getDimension(g.aiapp_menu_item_new_tips_cross_with_icon));
    }

    public final void d() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(j.aiapp_menu_item_view_layout, this);
        this.f11911e = (ImageView) findViewById(i.aiapp_menu_item_icon);
        this.f11912f = (TextView) findViewById(i.aiapp_menu_item_title);
        this.f11913g = (TextView) findViewById(i.aiapp_menu_item_new_tips);
        this.f11914h = (ImageView) findViewById(i.aiapp_menu_item_new_dot);
        setBackgroundResource(0);
    }

    public final void e(o oVar, int i2) {
        this.f11912f.setEllipsize(TextUtils.TruncateAt.END);
        this.f11912f.setAlpha(oVar.i() ? 1.0f : 0.3f);
        this.f11911e.setEnabled(oVar.i());
        this.f11911e.setScaleType(ImageView.ScaleType.CENTER);
        this.f11911e.setVisibility(0);
        g(oVar);
        f(oVar, i2);
    }

    public final void f(o oVar, int i2) {
        if (oVar == null) {
            return;
        }
        int f2 = oVar.f();
        if (f2 == 0) {
            this.f11913g.setVisibility(8);
            this.f11913g.setVisibility(8);
        } else if (f2 != 1) {
            if (f2 != 2) {
                this.f11913g.setVisibility(8);
                this.f11914h.setVisibility(8);
                return;
            }
            this.f11913g.setVisibility(8);
            this.f11914h.setImageDrawable(getResources().getDrawable(h.swan_app_menu_new_dot));
            this.f11914h.setVisibility(0);
        } else if (i2 <= 0) {
        } else {
            this.f11914h.setVisibility(8);
            this.f11913g.setText(a(oVar.e()));
            this.f11913g.setTextColor(getResources().getColor(f.swan_app_menu_item_tip_text));
            this.f11913g.setBackground(getResources().getDrawable(h.swan_app_menu_new_bg));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11913g.getLayoutParams();
            marginLayoutParams.leftMargin = c(i2);
            this.f11913g.setLayoutParams(marginLayoutParams);
            this.f11913g.setVisibility(0);
        }
    }

    public final void g(o oVar) {
        if (oVar == null) {
            return;
        }
        setAlpha(1.0f);
        this.f11912f.setText(oVar.h(getContext()));
        Drawable b2 = b(oVar);
        if (b2 != null) {
            this.f11911e.setImageDrawable(b2);
            this.f11911e.setImageLevel(oVar.b());
        }
    }

    public void h(o oVar, int i2) {
        if (oVar == null) {
            return;
        }
        e(oVar, i2);
        this.f11915i = oVar;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            o oVar = this.f11915i;
            if (oVar != null && oVar.d() != null) {
                removeCallbacks(this.m);
                this.l = false;
                this.j = x;
                this.k = y;
                postDelayed(this.m, 3000L);
                setAllPressed(true);
            } else {
                return super.onTouchEvent(motionEvent);
            }
        } else if (action == 1) {
            removeCallbacks(this.m);
            if (!this.l && this.f11915i.g() != null) {
                this.f11915i.g().b(this, this.f11915i);
            }
            this.l = false;
            setAllPressed(false);
            return super.onTouchEvent(motionEvent);
        } else if (action != 2) {
            if (action == 3) {
                removeCallbacks(this.m);
                this.l = false;
                setAllPressed(false);
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
        d();
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = false;
        this.m = new a();
        d();
    }
}
