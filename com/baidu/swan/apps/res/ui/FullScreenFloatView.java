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
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float aqG;
    public View bdk;
    public int bdl;
    public int bdm;
    public int bdn;
    public boolean bdo;
    public boolean bdp;
    public boolean bdq;
    public float bdr;
    public a bds;
    public b bdt;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void Lt();

        void onClick();
    }

    public b getDragImageListener() {
        return this.bdt;
    }

    public void setDragImageListener(b bVar) {
        this.bdt = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.bdq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.bdo = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.bdo = false;
        this.bdp = false;
        this.bdq = true;
        this.bds = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.bdo = false;
        this.bdp = false;
        this.bdq = true;
        this.bds = new a();
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

    public void af(View view) {
        if (this.bdn == 0) {
            this.bdn = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.bdl = view.getWidth();
        this.bdm = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.bdn + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.bdl + ", mFloatViewHeight = " + this.bdm);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.bdk == null) {
                    this.bdk = findViewById(a.f.float_imgview);
                    af(this.bdk);
                }
                this.bdk.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bdp = true;
                    this.bdr = x;
                    this.aqG = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bdn = getWidth();
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
                this.bdk.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bdr = x;
                    this.aqG = y;
                    this.bdp = true;
                    this.bdo = true;
                    postDelayed(this.bds, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bdo) {
                    if (this.bdt != null) {
                        this.bdt.onClick();
                    }
                    removeCallbacks(this.bds);
                } else if (this.bdp && this.bdt != null) {
                    this.bdt.Lt();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bdo);
                }
                if (this.bdq && !this.bdo && x > this.bdl / 2 && x < this.bdn - (this.bdl / 2) && y > this.bdm / 2 && y < this.mParentHeight - (this.bdm / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.bdn - this.bdl;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.bdm;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.bdk.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.bdk.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.bdo = false;
                this.bdp = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bdr);
                float abs2 = Math.abs(y - this.aqG);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bdo = false;
                }
                o(x, y);
                break;
            case 3:
                this.bdo = false;
                this.bdp = false;
                break;
            case 4:
                this.bdo = false;
                this.bdp = false;
                break;
        }
        return this.bdo || this.bdp;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.bdn) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.bdn) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.bdn) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.bdk != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bdl / 2));
            int i2 = (int) (f2 - (this.bdm / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.bdn - this.bdl ? this.bdn - this.bdl : i;
            if (i3 > this.mParentHeight - this.bdm) {
                i3 = this.mParentHeight - this.bdm;
            }
            int i5 = (this.bdn - i4) - this.bdl;
            int i6 = (this.mParentHeight - i3) - this.bdm;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.bdk.setX(i4);
            this.bdk.setY(i3);
            requestLayout();
        }
    }

    public void OX() {
        if (this.bdk != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.bdk.animate().x((z.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.bdl).y((z.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.bdm).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bdn = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.bdn + ", mScreenHeight = " + this.mParentHeight);
        }
        OX();
    }
}
