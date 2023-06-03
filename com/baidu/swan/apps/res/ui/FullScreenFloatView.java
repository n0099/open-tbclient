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
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.tieba.is1;
import com.baidu.tieba.pp3;
/* loaded from: classes4.dex */
public class FullScreenFloatView extends FrameLayout {
    public static final boolean n = is1.a;
    public View a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public float j;
    public float k;
    public b l;
    public c m;

    /* loaded from: classes4.dex */
    public interface c {
        void onClick();

        void onDrag();
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.g = false;
            if (FullScreenFloatView.n) {
                Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "CheckClick=====checkTap====");
            }
        }
    }

    public c getDragImageListener() {
        return this.m;
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
        if (identifier > 0) {
            this.f = getResources().getDimensionPixelSize(identifier);
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 66;
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = new b();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 66;
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = new b();
        setStatusBarHeight();
    }

    public void b(View view2) {
        if (this.d == 0) {
            this.d = getWidth();
        }
        if (this.e == 0) {
            this.e = getHeight();
        }
        this.b = view2.getWidth();
        this.c = view2.getHeight();
        if (n) {
            Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "dragInit-> mScreenWidth = " + this.d + ", mScreenHeight = " + this.e + ",mFloatViewWidth = " + this.b + ", mFloatViewHeight = " + this.c);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d = getHeight() + this.f;
        this.e = getWidth() - this.f;
        if (n) {
            Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.d + ", mScreenHeight = " + this.e);
        }
        e();
    }

    public int c(float f, float f2) {
        boolean z;
        boolean z2;
        if (n) {
            Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "minDIstance---> x = " + f + ", y = " + f2);
        }
        if (f <= this.d - f) {
            z = true;
        } else {
            z = false;
        }
        if (f2 <= this.e - f2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if (f <= f2) {
                return 1;
            }
            return 3;
        } else if (z && !z2) {
            if (f <= this.e - f2) {
                return 1;
            }
            return 4;
        } else if (!z && z2) {
            if (this.d - f > f2) {
                return 3;
            }
            return 2;
        } else if (z || z2) {
            return 0;
        } else {
            if (this.d - f > this.e - f2) {
                return 4;
            }
            return 2;
        }
    }

    public final void d(float f, float f2) {
        if (this.a == null) {
            return;
        }
        if (n) {
            Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "move--> x = " + f + ", y = " + f2);
        }
        int i = (int) (f - (this.b / 2));
        int i2 = (int) (f2 - (this.c / 2));
        if (i <= 0) {
            i = 0;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int i3 = this.d;
        int i4 = this.b;
        if (i > i3 - i4) {
            i = i3 - i4;
        }
        int i5 = this.e;
        int i6 = this.c;
        if (i2 > i5 - i6) {
            i2 = i5 - i6;
        }
        int i7 = (this.d - i) - this.b;
        int i8 = (this.e - i2) - this.c;
        if (n) {
            Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "move--> left = " + i + ", top = " + i2 + ", right = " + i7 + ",bottom = " + i8 + ", mStatusBarHeight = " + this.f);
        }
        this.a.setX(i);
        this.a.setY(i2);
        requestLayout();
    }

    public void e() {
        if (this.a != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0707d0);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0707d1);
            this.a.animate().x((pp3.o(getContext()) - dimensionPixelOffset) - this.b).y((pp3.n(getContext()) - dimensionPixelOffset2) - this.c).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            if (this.a == null) {
                View findViewById = findViewById(R.id.float_imgview);
                this.a = findViewById;
                b(findViewById);
            }
            this.a.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.h = true;
                this.j = x;
                this.k = y;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.d = getWidth();
        this.e = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 4) {
                            this.g = false;
                            this.h = false;
                        }
                    } else {
                        this.g = false;
                        this.h = false;
                    }
                } else {
                    float abs = Math.abs(x - this.j);
                    float abs2 = Math.abs(y - this.k);
                    if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                        this.g = false;
                    }
                    d(x, y);
                }
            } else {
                if (this.g) {
                    c cVar2 = this.m;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.l);
                } else if (this.h && (cVar = this.m) != null) {
                    cVar.onDrag();
                }
                if (n) {
                    Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.g);
                }
                if (this.i && !this.g) {
                    int i = this.b;
                    if (x > i / 2 && x < this.d - (i / 2)) {
                        int i2 = this.c;
                        if (y > i2 / 2 && y < this.e - (i2 / 2)) {
                            int c2 = c(x, y);
                            if (n) {
                                Log.e(com.baidu.searchbox.ui.FullScreenFloatView.TAG, "mScreenHeight = " + this.e + ", mintype = " + c2);
                            }
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                        if (c2 == 4) {
                                            y = this.e - this.c;
                                        }
                                    } else {
                                        y = 0.0f;
                                    }
                                } else {
                                    x = this.d - this.b;
                                }
                            } else {
                                x = 0.0f;
                            }
                            if (c2 != 1 && c2 != 2) {
                                if (c2 == 3 || c2 == 4) {
                                    this.a.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                                }
                            } else {
                                this.a.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            }
                        }
                    }
                }
                this.g = false;
                this.h = false;
            }
        } else {
            this.a.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.j = x;
                this.k = y;
                this.h = true;
                this.g = true;
                postDelayed(this.l, ViewConfiguration.getTapTimeout());
            }
        }
        if (this.g || this.h) {
            return true;
        }
        return false;
    }

    public void setAutoAttachEnable(boolean z) {
        this.i = z;
    }

    public void setDragImageListener(c cVar) {
        this.m = cVar;
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(R.id.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById = findViewById(R.id.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i);
        }
    }
}
