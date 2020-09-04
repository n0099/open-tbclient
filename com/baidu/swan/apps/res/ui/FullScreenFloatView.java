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
/* loaded from: classes8.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bpM;
    public b cLA;
    public View cLr;
    public int cLs;
    public int cLt;
    public int cLu;
    public boolean cLv;
    public boolean cLw;
    public boolean cLx;
    public float cLy;
    public a cLz;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes8.dex */
    public interface b {
        void arN();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cLA;
    }

    public void setDragImageListener(b bVar) {
        this.cLA = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cLx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cLv = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cLv = false;
        this.cLw = false;
        this.cLx = true;
        this.cLz = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cLv = false;
        this.cLw = false;
        this.cLx = true;
        this.cLz = new a();
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

    public void aq(View view) {
        if (this.cLu == 0) {
            this.cLu = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cLs = view.getWidth();
        this.cLt = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cLu + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cLs + ", mFloatViewHeight = " + this.cLt);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cLr == null) {
                    this.cLr = findViewById(a.f.float_imgview);
                    aq(this.cLr);
                }
                this.cLr.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cLw = true;
                    this.cLy = x;
                    this.bpM = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cLu = getWidth();
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
                this.cLr.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cLy = x;
                    this.bpM = y;
                    this.cLw = true;
                    this.cLv = true;
                    postDelayed(this.cLz, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cLv) {
                    if (this.cLA != null) {
                        this.cLA.onClick();
                    }
                    removeCallbacks(this.cLz);
                } else if (this.cLw && this.cLA != null) {
                    this.cLA.arN();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cLv);
                }
                if (this.cLx && !this.cLv && x > this.cLs / 2 && x < this.cLu - (this.cLs / 2) && y > this.cLt / 2 && y < this.mParentHeight - (this.cLt / 2)) {
                    int n = n(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + n);
                    }
                    switch (n) {
                        case 1:
                            break;
                        case 2:
                            f = this.cLu - this.cLs;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cLt;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (n) {
                        case 1:
                        case 2:
                            this.cLr.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cLr.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cLv = false;
                this.cLw = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cLy);
                float abs2 = Math.abs(y - this.bpM);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cLv = false;
                }
                m(x, y);
                break;
            case 3:
                this.cLv = false;
                this.cLw = false;
                break;
            case 4:
                this.cLv = false;
                this.cLw = false;
                break;
        }
        return this.cLv || this.cLw;
    }

    public int n(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cLu) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cLu) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cLu) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void m(float f, float f2) {
        if (this.cLr != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cLs / 2));
            int i2 = (int) (f2 - (this.cLt / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cLu - this.cLs ? this.cLu - this.cLs : i;
            if (i3 > this.mParentHeight - this.cLt) {
                i3 = this.mParentHeight - this.cLt;
            }
            int i5 = (this.cLu - i4) - this.cLs;
            int i6 = (this.mParentHeight - i3) - this.cLt;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cLr.setX(i4);
            this.cLr.setY(i3);
            requestLayout();
        }
    }

    public void ayz() {
        if (this.cLr != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cLr.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cLs).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cLt).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cLu = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cLu + ", mScreenHeight = " + this.mParentHeight);
        }
        ayz();
    }
}
