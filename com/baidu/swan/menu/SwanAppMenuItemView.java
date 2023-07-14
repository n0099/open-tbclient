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
import com.baidu.tieba.R;
import com.baidu.tieba.di4;
/* loaded from: classes4.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public di4 e;
    public int f;
    public int g;
    public boolean h;
    public Runnable i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            di4 di4Var = SwanAppMenuItemView.this.e;
            if (di4Var != null && di4Var.d() != null) {
                SwanAppMenuItemView swanAppMenuItemView = SwanAppMenuItemView.this;
                swanAppMenuItemView.h = swanAppMenuItemView.e.d().a(SwanAppMenuItemView.this.e);
            }
        }
    }

    public SwanAppMenuItemView(Context context) {
        super(context);
        this.h = false;
        this.i = new a();
        d();
    }

    private void setAllPressed(boolean z) {
        this.a.setPressed(z);
        this.b.setPressed(z);
        setPressed(z);
    }

    public final String a(long j) {
        if (j <= 99) {
            return String.valueOf(j);
        }
        return "99+";
    }

    public final Drawable b(di4 di4Var) {
        return di4Var.a(getContext());
    }

    public final int c(int i) {
        Resources resources = getResources();
        return (int) (((i * 0.5d) + (resources.getDimension(R.dimen.obfuscated_res_0x7f0700e9) * 0.5d)) - resources.getDimension(R.dimen.obfuscated_res_0x7f0700ea));
    }

    public final void g(di4 di4Var) {
        if (di4Var == null) {
            return;
        }
        setAlpha(1.0f);
        this.b.setText(di4Var.h(getContext()));
        Drawable b = b(di4Var);
        if (b != null) {
            this.a.setImageDrawable(b);
            this.a.setImageLevel(di4Var.b());
        }
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = new a();
        d();
    }

    public void h(di4 di4Var, int i) {
        if (di4Var == null) {
            return;
        }
        e(di4Var, i);
        this.e = di4Var;
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.i = new a();
        d();
    }

    public final void d() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0091, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09019f);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0901a2);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0901a1);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901a0);
        setBackgroundResource(0);
    }

    public final void e(di4 di4Var, int i) {
        float f;
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        if (di4Var.i()) {
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        this.b.setAlpha(f);
        this.a.setEnabled(di4Var.i());
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setVisibility(0);
        g(di4Var);
        f(di4Var, i);
    }

    public final void f(di4 di4Var, int i) {
        if (di4Var == null) {
            return;
        }
        int f = di4Var.f();
        if (f != 0) {
            if (f != 1) {
                if (f != 2) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(8);
                this.d.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081407));
                this.d.setVisibility(0);
                return;
            } else if (i <= 0) {
                return;
            } else {
                this.d.setVisibility(8);
                this.c.setText(a(di4Var.e()));
                this.c.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ac6));
                this.c.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081406));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                marginLayoutParams.leftMargin = c(i);
                this.c.setLayoutParams(marginLayoutParams);
                this.c.setVisibility(0);
                return;
            }
        }
        this.c.setVisibility(8);
        this.c.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        removeCallbacks(this.i);
                        this.h = false;
                        setAllPressed(false);
                        return super.onTouchEvent(motionEvent);
                    }
                } else if (Math.abs(this.f - x) > 10 || Math.abs(this.g - y) > 10) {
                    removeCallbacks(this.i);
                    this.h = false;
                }
            } else {
                removeCallbacks(this.i);
                if (!this.h && this.e.g() != null) {
                    this.e.g().b(this, this.e);
                }
                this.h = false;
                setAllPressed(false);
                return super.onTouchEvent(motionEvent);
            }
        } else {
            di4 di4Var = this.e;
            if (di4Var != null && di4Var.d() != null) {
                removeCallbacks(this.i);
                this.h = false;
                this.f = x;
                this.g = y;
                postDelayed(this.i, 3000L);
                setAllPressed(true);
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }
        return true;
    }
}
