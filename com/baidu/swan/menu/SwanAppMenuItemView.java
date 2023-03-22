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
import com.baidu.tieba.be4;
/* loaded from: classes3.dex */
public class SwanAppMenuItemView extends RelativeLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public be4 e;
    public int f;
    public int g;
    public boolean h;
    public Runnable i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            be4 be4Var = SwanAppMenuItemView.this.e;
            if (be4Var != null && be4Var.d() != null) {
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

    public final Drawable b(be4 be4Var) {
        return be4Var.a(getContext());
    }

    public final int c(int i) {
        Resources resources = getResources();
        return (int) (((i * 0.5d) + (resources.getDimension(R.dimen.obfuscated_res_0x7f0700e2) * 0.5d)) - resources.getDimension(R.dimen.obfuscated_res_0x7f0700e3));
    }

    public final void g(be4 be4Var) {
        if (be4Var == null) {
            return;
        }
        setAlpha(1.0f);
        this.b.setText(be4Var.h(getContext()));
        Drawable b = b(be4Var);
        if (b != null) {
            this.a.setImageDrawable(b);
            this.a.setImageLevel(be4Var.b());
        }
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = new a();
        d();
    }

    public void h(be4 be4Var, int i) {
        if (be4Var == null) {
            return;
        }
        e(be4Var, i);
        this.e = be4Var;
    }

    public SwanAppMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.i = new a();
        d();
    }

    public final void d() {
        setGravity(49);
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0090, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090194);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090197);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090196);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090195);
        setBackgroundResource(0);
    }

    public final void e(be4 be4Var, int i) {
        float f;
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        if (be4Var.i()) {
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        this.b.setAlpha(f);
        this.a.setEnabled(be4Var.i());
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setVisibility(0);
        g(be4Var);
        f(be4Var, i);
    }

    public final void f(be4 be4Var, int i) {
        if (be4Var == null) {
            return;
        }
        int f = be4Var.f();
        if (f != 0) {
            if (f != 1) {
                if (f != 2) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(8);
                this.d.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081203));
                this.d.setVisibility(0);
                return;
            } else if (i <= 0) {
                return;
            } else {
                this.d.setVisibility(8);
                this.c.setText(a(be4Var.e()));
                this.c.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060929));
                this.c.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081202));
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
            be4 be4Var = this.e;
            if (be4Var != null && be4Var.d() != null) {
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
