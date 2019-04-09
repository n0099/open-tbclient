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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
/* loaded from: classes2.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View aGX;
    private int aGY;
    private int aGZ;
    private int aHa;
    private boolean aHb;
    private boolean aHc;
    private boolean aHd;
    private float aHe;
    private float aHf;
    private a aHg;
    private b aHh;
    private int mParentHeight;
    private int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void DQ();

        void onClick();
    }

    public b getDragImageListener() {
        return this.aHh;
    }

    public void setDragImageListener(b bVar) {
        this.aHh = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.aHd = z;
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.aHb = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.aHb = false;
        this.aHc = false;
        this.aHd = true;
        this.aHg = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.aHb = false;
        this.aHc = false;
        this.aHd = true;
        this.aHg = new a();
        setStatusBarHeight();
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mStatusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById = findViewById(a.f.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i);
        }
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(a.f.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void X(View view) {
        if (this.aHa == 0) {
            this.aHa = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.aGY = view.getWidth();
        this.aGZ = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.aHa + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.aGY + ", mFloatViewHeight = " + this.aGZ);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.aGX == null) {
                    this.aGX = findViewById(a.f.float_imgview);
                    X(this.aGX);
                }
                this.aGX.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aHc = true;
                    this.aHe = x;
                    this.aHf = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aHa = getWidth();
        this.mParentHeight = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.aGX.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aHe = x;
                    this.aHf = y;
                    this.aHc = true;
                    this.aHb = true;
                    postDelayed(this.aHg, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aHb) {
                    if (this.aHh != null) {
                        this.aHh.onClick();
                    }
                    removeCallbacks(this.aHg);
                } else if (this.aHc && this.aHh != null) {
                    this.aHh.DQ();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aHb);
                }
                if (this.aHd && !this.aHb && x > this.aGY / 2 && x < this.aHa - (this.aGY / 2) && y > this.aGZ / 2 && y < this.mParentHeight - (this.aGZ / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.aHa - this.aGY;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.aGZ;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.aGX.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.aGX.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.aHb = false;
                this.aHc = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aHe);
                float abs2 = Math.abs(y - this.aHf);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aHb = false;
                }
                q(x, y);
                break;
            case 3:
                this.aHb = false;
                this.aHc = false;
                break;
            case 4:
                this.aHb = false;
                this.aHc = false;
                break;
        }
        return this.aHb | this.aHc;
    }

    private int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.aHa) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else {
            if ((!z) && z2) {
                return ((float) this.aHa) - f <= f2 ? 2 : 3;
            }
            if ((!z) && (z2 ? false : true)) {
                return ((float) this.aHa) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
            }
            return 0;
        }
    }

    private void q(float f, float f2) {
        if (this.aGX != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aGY / 2));
            int i2 = (int) (f2 - (this.aGZ / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.aHa - this.aGY ? this.aHa - this.aGY : i;
            if (i3 > this.mParentHeight - this.aGZ) {
                i3 = this.mParentHeight - this.aGZ;
            }
            int i5 = (this.aHa - i4) - this.aGY;
            int i6 = (this.mParentHeight - i3) - this.aGZ;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aGX.setX(i4);
            this.aGX.setY(i3);
            requestLayout();
        }
    }

    public void GX() {
        if (this.aGX != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.aGX.animate().x((x.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.aGY).y((x.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.aGZ).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aHa = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.aHa + ", mScreenHeight = " + this.mParentHeight);
        }
        GX();
    }
}
