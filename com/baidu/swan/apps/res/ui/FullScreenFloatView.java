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
import com.baidu.swan.apps.aq.ag;
/* loaded from: classes11.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bez;
    public View cvA;
    public int cvB;
    public int cvC;
    public int cvD;
    public boolean cvE;
    public boolean cvF;
    public boolean cvG;
    public float cvH;
    public a cvI;
    public b cvJ;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface b {
        void ahK();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cvJ;
    }

    public void setDragImageListener(b bVar) {
        this.cvJ = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cvG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cvE = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cvE = false;
        this.cvF = false;
        this.cvG = true;
        this.cvI = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cvE = false;
        this.cvF = false;
        this.cvG = true;
        this.cvI = new a();
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

    public void am(View view) {
        if (this.cvD == 0) {
            this.cvD = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cvB = view.getWidth();
        this.cvC = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cvD + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cvB + ", mFloatViewHeight = " + this.cvC);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cvA == null) {
                    this.cvA = findViewById(a.f.float_imgview);
                    am(this.cvA);
                }
                this.cvA.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cvF = true;
                    this.cvH = x;
                    this.bez = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cvD = getWidth();
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
                this.cvA.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cvH = x;
                    this.bez = y;
                    this.cvF = true;
                    this.cvE = true;
                    postDelayed(this.cvI, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cvE) {
                    if (this.cvJ != null) {
                        this.cvJ.onClick();
                    }
                    removeCallbacks(this.cvI);
                } else if (this.cvF && this.cvJ != null) {
                    this.cvJ.ahK();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cvE);
                }
                if (this.cvG && !this.cvE && x > this.cvB / 2 && x < this.cvD - (this.cvB / 2) && y > this.cvC / 2 && y < this.mParentHeight - (this.cvC / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.cvD - this.cvB;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cvC;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.cvA.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cvA.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cvE = false;
                this.cvF = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cvH);
                float abs2 = Math.abs(y - this.bez);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cvE = false;
                }
                n(x, y);
                break;
            case 3:
                this.cvE = false;
                this.cvF = false;
                break;
            case 4:
                this.cvE = false;
                this.cvF = false;
                break;
        }
        return this.cvE || this.cvF;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cvD) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cvD) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cvD) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.cvA != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cvB / 2));
            int i2 = (int) (f2 - (this.cvC / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cvD - this.cvB ? this.cvD - this.cvB : i;
            if (i3 > this.mParentHeight - this.cvC) {
                i3 = this.mParentHeight - this.cvC;
            }
            int i5 = (this.cvD - i4) - this.cvB;
            int i6 = (this.mParentHeight - i3) - this.cvC;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cvA.setX(i4);
            this.cvA.setY(i3);
            requestLayout();
        }
    }

    public void anF() {
        if (this.cvA != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cvA.animate().x((ag.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cvB).y((ag.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cvC).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cvD = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cvD + ", mScreenHeight = " + this.mParentHeight);
        }
        anF();
    }
}
