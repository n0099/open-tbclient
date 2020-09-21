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
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes3.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bsV;
    public b cNA;
    public View cNr;
    public int cNs;
    public int cNt;
    public int cNu;
    public boolean cNv;
    public boolean cNw;
    public boolean cNx;
    public float cNy;
    public a cNz;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface b {
        void asy();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cNA;
    }

    public void setDragImageListener(b bVar) {
        this.cNA = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cNx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cNv = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cNv = false;
        this.cNw = false;
        this.cNx = true;
        this.cNz = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cNv = false;
        this.cNw = false;
        this.cNx = true;
        this.cNz = new a();
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

    public void as(View view) {
        if (this.cNu == 0) {
            this.cNu = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cNs = view.getWidth();
        this.cNt = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cNu + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cNs + ", mFloatViewHeight = " + this.cNt);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cNr == null) {
                    this.cNr = findViewById(a.f.float_imgview);
                    as(this.cNr);
                }
                this.cNr.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cNw = true;
                    this.cNy = x;
                    this.bsV = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cNu = getWidth();
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
                this.cNr.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cNy = x;
                    this.bsV = y;
                    this.cNw = true;
                    this.cNv = true;
                    postDelayed(this.cNz, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cNv) {
                    if (this.cNA != null) {
                        this.cNA.onClick();
                    }
                    removeCallbacks(this.cNz);
                } else if (this.cNw && this.cNA != null) {
                    this.cNA.asy();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cNv);
                }
                if (this.cNx && !this.cNv && x > this.cNs / 2 && x < this.cNu - (this.cNs / 2) && y > this.cNt / 2 && y < this.mParentHeight - (this.cNt / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.cNu - this.cNs;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cNt;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.cNr.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cNr.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cNv = false;
                this.cNw = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cNy);
                float abs2 = Math.abs(y - this.bsV);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cNv = false;
                }
                n(x, y);
                break;
            case 3:
                this.cNv = false;
                this.cNw = false;
                break;
            case 4:
                this.cNv = false;
                this.cNw = false;
                break;
        }
        return this.cNv || this.cNw;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cNu) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cNu) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cNu) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.cNr != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cNs / 2));
            int i2 = (int) (f2 - (this.cNt / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cNu - this.cNs ? this.cNu - this.cNs : i;
            if (i3 > this.mParentHeight - this.cNt) {
                i3 = this.mParentHeight - this.cNt;
            }
            int i5 = (this.cNu - i4) - this.cNs;
            int i6 = (this.mParentHeight - i3) - this.cNt;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cNr.setX(i4);
            this.cNr.setY(i3);
            requestLayout();
        }
    }

    public void azi() {
        if (this.cNr != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cNr.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cNs).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cNt).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cNu = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cNu + ", mScreenHeight = " + this.mParentHeight);
        }
        azi();
    }
}
