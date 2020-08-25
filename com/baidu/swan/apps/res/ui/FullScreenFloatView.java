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
    public float bpJ;
    public View cLn;
    public int cLo;
    public int cLp;
    public int cLq;
    public boolean cLr;
    public boolean cLs;
    public boolean cLt;
    public float cLu;
    public a cLv;
    public b cLw;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes8.dex */
    public interface b {
        void arN();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cLw;
    }

    public void setDragImageListener(b bVar) {
        this.cLw = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cLt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cLr = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cLr = false;
        this.cLs = false;
        this.cLt = true;
        this.cLv = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cLr = false;
        this.cLs = false;
        this.cLt = true;
        this.cLv = new a();
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
        if (this.cLq == 0) {
            this.cLq = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cLo = view.getWidth();
        this.cLp = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cLq + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cLo + ", mFloatViewHeight = " + this.cLp);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cLn == null) {
                    this.cLn = findViewById(a.f.float_imgview);
                    aq(this.cLn);
                }
                this.cLn.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cLs = true;
                    this.cLu = x;
                    this.bpJ = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cLq = getWidth();
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
                this.cLn.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cLu = x;
                    this.bpJ = y;
                    this.cLs = true;
                    this.cLr = true;
                    postDelayed(this.cLv, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cLr) {
                    if (this.cLw != null) {
                        this.cLw.onClick();
                    }
                    removeCallbacks(this.cLv);
                } else if (this.cLs && this.cLw != null) {
                    this.cLw.arN();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cLr);
                }
                if (this.cLt && !this.cLr && x > this.cLo / 2 && x < this.cLq - (this.cLo / 2) && y > this.cLp / 2 && y < this.mParentHeight - (this.cLp / 2)) {
                    int n = n(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + n);
                    }
                    switch (n) {
                        case 1:
                            break;
                        case 2:
                            f = this.cLq - this.cLo;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cLp;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (n) {
                        case 1:
                        case 2:
                            this.cLn.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cLn.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cLr = false;
                this.cLs = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cLu);
                float abs2 = Math.abs(y - this.bpJ);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cLr = false;
                }
                m(x, y);
                break;
            case 3:
                this.cLr = false;
                this.cLs = false;
                break;
            case 4:
                this.cLr = false;
                this.cLs = false;
                break;
        }
        return this.cLr || this.cLs;
    }

    public int n(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cLq) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cLq) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cLq) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void m(float f, float f2) {
        if (this.cLn != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cLo / 2));
            int i2 = (int) (f2 - (this.cLp / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cLq - this.cLo ? this.cLq - this.cLo : i;
            if (i3 > this.mParentHeight - this.cLp) {
                i3 = this.mParentHeight - this.cLp;
            }
            int i5 = (this.cLq - i4) - this.cLo;
            int i6 = (this.mParentHeight - i3) - this.cLp;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cLn.setX(i4);
            this.cLn.setY(i3);
            requestLayout();
        }
    }

    public void ayz() {
        if (this.cLn != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cLn.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cLo).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cLp).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cLq = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cLq + ", mScreenHeight = " + this.mParentHeight);
        }
        ayz();
    }
}
