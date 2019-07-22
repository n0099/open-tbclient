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
    public int aJA;
    public int aJB;
    public boolean aJC;
    public boolean aJD;
    public boolean aJE;
    public float aJF;
    public float aJG;
    public a aJH;
    public b aJI;
    public View aJy;
    public int aJz;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void Gv();

        void onClick();
    }

    public b getDragImageListener() {
        return this.aJI;
    }

    public void setDragImageListener(b bVar) {
        this.aJI = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.aJE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.aJC = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.aJC = false;
        this.aJD = false;
        this.aJE = true;
        this.aJH = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.aJC = false;
        this.aJD = false;
        this.aJE = true;
        this.aJH = new a();
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

    public void Z(View view) {
        if (this.aJB == 0) {
            this.aJB = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.aJz = view.getWidth();
        this.aJA = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.aJB + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.aJz + ", mFloatViewHeight = " + this.aJA);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.aJy == null) {
                    this.aJy = findViewById(a.f.float_imgview);
                    Z(this.aJy);
                }
                this.aJy.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aJD = true;
                    this.aJF = x;
                    this.aJG = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aJB = getWidth();
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
                this.aJy.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aJF = x;
                    this.aJG = y;
                    this.aJD = true;
                    this.aJC = true;
                    postDelayed(this.aJH, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aJC) {
                    if (this.aJI != null) {
                        this.aJI.onClick();
                    }
                    removeCallbacks(this.aJH);
                } else if (this.aJD && this.aJI != null) {
                    this.aJI.Gv();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aJC);
                }
                if (this.aJE && !this.aJC && x > this.aJz / 2 && x < this.aJB - (this.aJz / 2) && y > this.aJA / 2 && y < this.mParentHeight - (this.aJA / 2)) {
                    int q = q(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + q);
                    }
                    switch (q) {
                        case 1:
                            break;
                        case 2:
                            f = this.aJB - this.aJz;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.aJA;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (q) {
                        case 1:
                        case 2:
                            this.aJy.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.aJy.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.aJC = false;
                this.aJD = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aJF);
                float abs2 = Math.abs(y - this.aJG);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aJC = false;
                }
                p(x, y);
                break;
            case 3:
                this.aJC = false;
                this.aJD = false;
                break;
            case 4:
                this.aJC = false;
                this.aJD = false;
                break;
        }
        return this.aJC || this.aJD;
    }

    public int q(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.aJB) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.aJB) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.aJB) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void p(float f, float f2) {
        if (this.aJy != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aJz / 2));
            int i2 = (int) (f2 - (this.aJA / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.aJB - this.aJz ? this.aJB - this.aJz : i;
            if (i3 > this.mParentHeight - this.aJA) {
                i3 = this.mParentHeight - this.aJA;
            }
            int i5 = (this.aJB - i4) - this.aJz;
            int i6 = (this.mParentHeight - i3) - this.aJA;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aJy.setX(i4);
            this.aJy.setY(i3);
            requestLayout();
        }
    }

    public void Ka() {
        if (this.aJy != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.aJy.animate().x((z.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.aJz).y((z.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.aJA).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aJB = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.aJB + ", mScreenHeight = " + this.mParentHeight);
        }
        Ka();
    }
}
