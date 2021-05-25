package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import d.a.l0.a.d;
import d.a.l0.a.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
/* loaded from: classes3.dex */
public class FullScreenFloatView extends FrameLayout {
    public static final boolean r = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public View f11100e;

    /* renamed from: f  reason: collision with root package name */
    public int f11101f;

    /* renamed from: g  reason: collision with root package name */
    public int f11102g;

    /* renamed from: h  reason: collision with root package name */
    public int f11103h;

    /* renamed from: i  reason: collision with root package name */
    public int f11104i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public b p;
    public c q;

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.k = false;
            if (FullScreenFloatView.r) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onClick();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 66;
        this.k = false;
        this.l = false;
        this.m = true;
        this.p = new b();
        setStatusBarHeight();
    }

    public void b(View view) {
        if (this.f11103h == 0) {
            this.f11103h = getWidth();
        }
        if (this.f11104i == 0) {
            this.f11104i = getHeight();
        }
        this.f11101f = view.getWidth();
        this.f11102g = view.getHeight();
        if (r) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.f11103h + ", mScreenHeight = " + this.f11104i + ",mFloatViewWidth = " + this.f11101f + ", mFloatViewHeight = " + this.f11102g);
        }
    }

    public int c(float f2, float f3) {
        if (r) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f2 + ", y = " + f3);
        }
        boolean z = f2 <= ((float) this.f11103h) - f2;
        boolean z2 = f3 <= ((float) this.f11104i) - f3;
        if (z && z2) {
            return f2 <= f3 ? 1 : 3;
        } else if (z && !z2) {
            return f2 <= ((float) this.f11104i) - f3 ? 1 : 4;
        } else if (!z && z2) {
            return ((float) this.f11103h) - f2 <= f3 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.f11103h) - f2 <= ((float) this.f11104i) - f3 ? 2 : 4;
        }
    }

    public final void d(float f2, float f3) {
        if (this.f11100e == null) {
            return;
        }
        if (r) {
            Log.e("FullScreenFloatView", "move--> x = " + f2 + ", y = " + f3);
        }
        int i2 = (int) (f2 - (this.f11101f / 2));
        int i3 = (int) (f3 - (this.f11102g / 2));
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i3 <= 0) {
            i3 = 0;
        }
        int i4 = this.f11103h;
        int i5 = this.f11101f;
        if (i2 > i4 - i5) {
            i2 = i4 - i5;
        }
        int i6 = this.f11104i;
        int i7 = this.f11102g;
        if (i3 > i6 - i7) {
            i3 = i6 - i7;
        }
        int i8 = (this.f11103h - i2) - this.f11101f;
        int i9 = (this.f11104i - i3) - this.f11102g;
        if (r) {
            Log.e("FullScreenFloatView", "move--> left = " + i2 + ", top = " + i3 + ", right = " + i8 + ",bottom = " + i9 + ", mStatusBarHeight = " + this.j);
        }
        this.f11100e.setX(i2);
        this.f11100e.setY(i3);
        requestLayout();
    }

    public void e() {
        if (this.f11100e != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.swan_app_dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(d.swan_app_dimens_51dp);
            this.f11100e.animate().x((n0.o(getContext()) - dimensionPixelOffset) - this.f11101f).y((n0.n(getContext()) - dimensionPixelOffset2) - this.f11102g).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    public c getDragImageListener() {
        return this.q;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11103h = getHeight() + this.j;
        this.f11104i = getWidth() - this.j;
        if (r) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.f11103h + ", mScreenHeight = " + this.f11104i);
        }
        e();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        if (this.f11100e == null) {
            View findViewById = findViewById(f.float_imgview);
            this.f11100e = findViewById;
            b(findViewById);
        }
        this.f11100e.getHitRect(rect);
        if (rect.contains((int) x, (int) y)) {
            this.l = true;
            this.n = x;
            this.o = y;
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f11103h = getWidth();
        this.f11104i = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11100e.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.n = x;
                this.o = y;
                this.l = true;
                this.k = true;
                postDelayed(this.p, ViewConfiguration.getTapTimeout());
            }
        } else if (action == 1) {
            if (this.k) {
                c cVar2 = this.q;
                if (cVar2 != null) {
                    cVar2.onClick();
                }
                removeCallbacks(this.p);
            } else if (this.l && (cVar = this.q) != null) {
                cVar.a();
            }
            if (r) {
                Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.k);
            }
            if (this.m && !this.k) {
                int i2 = this.f11101f;
                if (x > i2 / 2 && x < this.f11103h - (i2 / 2)) {
                    int i3 = this.f11102g;
                    if (y > i3 / 2 && y < this.f11104i - (i3 / 2)) {
                        int c2 = c(x, y);
                        if (r) {
                            Log.e("FullScreenFloatView", "mScreenHeight = " + this.f11104i + ", mintype = " + c2);
                        }
                        if (c2 == 1) {
                            x = 0.0f;
                        } else if (c2 == 2) {
                            x = this.f11103h - this.f11101f;
                        } else if (c2 == 3) {
                            y = 0.0f;
                        } else if (c2 == 4) {
                            y = this.f11104i - this.f11102g;
                        }
                        if (c2 == 1 || c2 == 2) {
                            this.f11100e.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                        } else if (c2 == 3 || c2 == 4) {
                            this.f11100e.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                        }
                    }
                }
            }
            this.k = false;
            this.l = false;
        } else if (action == 2) {
            float abs = Math.abs(x - this.n);
            float abs2 = Math.abs(y - this.o);
            if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                this.k = false;
            }
            d(x, y);
        } else if (action == 3) {
            this.k = false;
            this.l = false;
        } else if (action == 4) {
            this.k = false;
            this.l = false;
        }
        return this.k || this.l;
    }

    public void setAutoAttachEnable(boolean z) {
        this.m = z;
    }

    public void setDragImageListener(c cVar) {
        this.q = cVar;
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(f.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void setFloatImageBackground(int i2) {
        View findViewById = findViewById(f.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i2);
        }
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.j = getResources().getDimensionPixelSize(identifier);
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 66;
        this.k = false;
        this.l = false;
        this.m = true;
        this.p = new b();
        setStatusBarHeight();
    }
}
