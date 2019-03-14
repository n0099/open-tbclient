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
    private View aGT;
    private int aGU;
    private int aGV;
    private int aGW;
    private boolean aGX;
    private boolean aGY;
    private boolean aGZ;
    private float aHa;
    private float aHb;
    private a aHc;
    private b aHd;
    private int mParentHeight;
    private int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void DS();

        void onClick();
    }

    public b getDragImageListener() {
        return this.aHd;
    }

    public void setDragImageListener(b bVar) {
        this.aHd = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.aGZ = z;
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.aGX = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.aGX = false;
        this.aGY = false;
        this.aGZ = true;
        this.aHc = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.aGX = false;
        this.aGY = false;
        this.aGZ = true;
        this.aHc = new a();
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
        if (this.aGW == 0) {
            this.aGW = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.aGU = view.getWidth();
        this.aGV = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.aGW + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.aGU + ", mFloatViewHeight = " + this.aGV);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.aGT == null) {
                    this.aGT = findViewById(a.f.float_imgview);
                    X(this.aGT);
                }
                this.aGT.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aGY = true;
                    this.aHa = x;
                    this.aHb = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aGW = getWidth();
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
                this.aGT.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aHa = x;
                    this.aHb = y;
                    this.aGY = true;
                    this.aGX = true;
                    postDelayed(this.aHc, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aGX) {
                    if (this.aHd != null) {
                        this.aHd.onClick();
                    }
                    removeCallbacks(this.aHc);
                } else if (this.aGY && this.aHd != null) {
                    this.aHd.DS();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aGX);
                }
                if (this.aGZ && !this.aGX && x > this.aGU / 2 && x < this.aGW - (this.aGU / 2) && y > this.aGV / 2 && y < this.mParentHeight - (this.aGV / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.aGW - this.aGU;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.aGV;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.aGT.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.aGT.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.aGX = false;
                this.aGY = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aHa);
                float abs2 = Math.abs(y - this.aHb);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aGX = false;
                }
                q(x, y);
                break;
            case 3:
                this.aGX = false;
                this.aGY = false;
                break;
            case 4:
                this.aGX = false;
                this.aGY = false;
                break;
        }
        return this.aGX | this.aGY;
    }

    private int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.aGW) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else {
            if ((!z) && z2) {
                return ((float) this.aGW) - f <= f2 ? 2 : 3;
            }
            if ((!z) && (z2 ? false : true)) {
                return ((float) this.aGW) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
            }
            return 0;
        }
    }

    private void q(float f, float f2) {
        if (this.aGT != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aGU / 2));
            int i2 = (int) (f2 - (this.aGV / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.aGW - this.aGU ? this.aGW - this.aGU : i;
            if (i3 > this.mParentHeight - this.aGV) {
                i3 = this.mParentHeight - this.aGV;
            }
            int i5 = (this.aGW - i4) - this.aGU;
            int i6 = (this.mParentHeight - i3) - this.aGV;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aGT.setX(i4);
            this.aGT.setY(i3);
            requestLayout();
        }
    }

    public void GZ() {
        if (this.aGT != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.aGT.animate().x((x.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.aGU).y((x.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.aGV).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aGW = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.aGW + ", mScreenHeight = " + this.mParentHeight);
        }
        GZ();
    }
}
