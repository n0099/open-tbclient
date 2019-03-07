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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private View aGS;
    private int aGT;
    private int aGU;
    private int aGV;
    private boolean aGW;
    private boolean aGX;
    private boolean aGY;
    private float aGZ;
    private float aHa;
    private a aHb;
    private b aHc;
    private int mParentHeight;
    private int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void DS();

        void onClick();
    }

    public b getDragImageListener() {
        return this.aHc;
    }

    public void setDragImageListener(b bVar) {
        this.aHc = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.aGY = z;
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.aGW = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.aGW = false;
        this.aGX = false;
        this.aGY = true;
        this.aHb = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.aGW = false;
        this.aGX = false;
        this.aGY = true;
        this.aHb = new a();
        setStatusBarHeight();
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mStatusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById = findViewById(b.f.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i);
        }
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(b.f.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void X(View view) {
        if (this.aGV == 0) {
            this.aGV = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.aGT = view.getWidth();
        this.aGU = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.aGV + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.aGT + ", mFloatViewHeight = " + this.aGU);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.aGS == null) {
                    this.aGS = findViewById(b.f.float_imgview);
                    X(this.aGS);
                }
                this.aGS.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aGX = true;
                    this.aGZ = x;
                    this.aHa = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aGV = getWidth();
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
                this.aGS.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aGZ = x;
                    this.aHa = y;
                    this.aGX = true;
                    this.aGW = true;
                    postDelayed(this.aHb, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aGW) {
                    if (this.aHc != null) {
                        this.aHc.onClick();
                    }
                    removeCallbacks(this.aHb);
                } else if (this.aGX && this.aHc != null) {
                    this.aHc.DS();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aGW);
                }
                if (this.aGY && !this.aGW && x > this.aGT / 2 && x < this.aGV - (this.aGT / 2) && y > this.aGU / 2 && y < this.mParentHeight - (this.aGU / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.aGV - this.aGT;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.aGU;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.aGS.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.aGS.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.aGW = false;
                this.aGX = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aGZ);
                float abs2 = Math.abs(y - this.aHa);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aGW = false;
                }
                q(x, y);
                break;
            case 3:
                this.aGW = false;
                this.aGX = false;
                break;
            case 4:
                this.aGW = false;
                this.aGX = false;
                break;
        }
        return this.aGW | this.aGX;
    }

    private int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.aGV) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else {
            if ((!z) && z2) {
                return ((float) this.aGV) - f <= f2 ? 2 : 3;
            }
            if ((!z) && (z2 ? false : true)) {
                return ((float) this.aGV) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
            }
            return 0;
        }
    }

    private void q(float f, float f2) {
        if (this.aGS != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aGT / 2));
            int i2 = (int) (f2 - (this.aGU / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.aGV - this.aGT ? this.aGV - this.aGT : i;
            if (i3 > this.mParentHeight - this.aGU) {
                i3 = this.mParentHeight - this.aGU;
            }
            int i5 = (this.aGV - i4) - this.aGT;
            int i6 = (this.mParentHeight - i3) - this.aGU;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aGS.setX(i4);
            this.aGS.setY(i3);
            requestLayout();
        }
    }

    public void GZ() {
        if (this.aGS != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(b.d.dimens_51dp);
            this.aGS.animate().x((x.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.aGT).y((x.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.aGU).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aGV = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.aGV + ", mScreenHeight = " + this.mParentHeight);
        }
        GZ();
    }
}
