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
    public float bjK;
    public View cAl;
    public int cAm;
    public int cAn;
    public int cAo;
    public boolean cAp;
    public boolean cAq;
    public boolean cAr;
    public float cAs;
    public a cAt;
    public b cAu;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface b {
        void aiQ();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cAu;
    }

    public void setDragImageListener(b bVar) {
        this.cAu = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cAr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cAp = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cAp = false;
        this.cAq = false;
        this.cAr = true;
        this.cAt = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cAp = false;
        this.cAq = false;
        this.cAr = true;
        this.cAt = new a();
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
        if (this.cAo == 0) {
            this.cAo = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cAm = view.getWidth();
        this.cAn = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cAo + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cAm + ", mFloatViewHeight = " + this.cAn);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cAl == null) {
                    this.cAl = findViewById(a.f.float_imgview);
                    am(this.cAl);
                }
                this.cAl.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cAq = true;
                    this.cAs = x;
                    this.bjK = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cAo = getWidth();
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
                this.cAl.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cAs = x;
                    this.bjK = y;
                    this.cAq = true;
                    this.cAp = true;
                    postDelayed(this.cAt, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cAp) {
                    if (this.cAu != null) {
                        this.cAu.onClick();
                    }
                    removeCallbacks(this.cAt);
                } else if (this.cAq && this.cAu != null) {
                    this.cAu.aiQ();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cAp);
                }
                if (this.cAr && !this.cAp && x > this.cAm / 2 && x < this.cAo - (this.cAm / 2) && y > this.cAn / 2 && y < this.mParentHeight - (this.cAn / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.cAo - this.cAm;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cAn;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.cAl.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cAl.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cAp = false;
                this.cAq = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cAs);
                float abs2 = Math.abs(y - this.bjK);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cAp = false;
                }
                n(x, y);
                break;
            case 3:
                this.cAp = false;
                this.cAq = false;
                break;
            case 4:
                this.cAp = false;
                this.cAq = false;
                break;
        }
        return this.cAp || this.cAq;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cAo) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cAo) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cAo) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.cAl != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cAm / 2));
            int i2 = (int) (f2 - (this.cAn / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cAo - this.cAm ? this.cAo - this.cAm : i;
            if (i3 > this.mParentHeight - this.cAn) {
                i3 = this.mParentHeight - this.cAn;
            }
            int i5 = (this.cAo - i4) - this.cAm;
            int i6 = (this.mParentHeight - i3) - this.cAn;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cAl.setX(i4);
            this.cAl.setY(i3);
            requestLayout();
        }
    }

    public void aoL() {
        if (this.cAl != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cAl.animate().x((ag.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cAm).y((ag.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cAn).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cAo = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cAo + ", mScreenHeight = " + this.mParentHeight);
        }
        aoL();
    }
}
