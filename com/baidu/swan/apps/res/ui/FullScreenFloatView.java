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
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float aDe;
    public View bKV;
    public int bKW;
    public int bKX;
    public int bKY;
    public boolean bKZ;
    public boolean bLa;
    public boolean bLb;
    public float bLc;
    public a bLd;
    public b bLe;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface b {
        void WI();

        void onClick();
    }

    public b getDragImageListener() {
        return this.bLe;
    }

    public void setDragImageListener(b bVar) {
        this.bLe = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.bLb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.bKZ = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.bKZ = false;
        this.bLa = false;
        this.bLb = true;
        this.bLd = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.bKZ = false;
        this.bLa = false;
        this.bLb = true;
        this.bLd = new a();
        setStatusBarHeight();
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
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

    public void al(View view) {
        if (this.bKY == 0) {
            this.bKY = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.bKW = view.getWidth();
        this.bKX = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.bKY + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.bKW + ", mFloatViewHeight = " + this.bKX);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.bKV == null) {
                    this.bKV = findViewById(a.f.float_imgview);
                    al(this.bKV);
                }
                this.bKV.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bLa = true;
                    this.bLc = x;
                    this.aDe = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bKY = getWidth();
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
                this.bKV.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bLc = x;
                    this.aDe = y;
                    this.bLa = true;
                    this.bKZ = true;
                    postDelayed(this.bLd, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bKZ) {
                    if (this.bLe != null) {
                        this.bLe.onClick();
                    }
                    removeCallbacks(this.bLd);
                } else if (this.bLa && this.bLe != null) {
                    this.bLe.WI();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bKZ);
                }
                if (this.bLb && !this.bKZ && x > this.bKW / 2 && x < this.bKY - (this.bKW / 2) && y > this.bKX / 2 && y < this.mParentHeight - (this.bKX / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.bKY - this.bKW;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.bKX;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.bKV.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.bKV.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.bKZ = false;
                this.bLa = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bLc);
                float abs2 = Math.abs(y - this.aDe);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bKZ = false;
                }
                o(x, y);
                break;
            case 3:
                this.bKZ = false;
                this.bLa = false;
                break;
            case 4:
                this.bKZ = false;
                this.bLa = false;
                break;
        }
        return this.bKZ || this.bLa;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.bKY) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.bKY) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.bKY) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.bKV != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bKW / 2));
            int i2 = (int) (f2 - (this.bKX / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.bKY - this.bKW ? this.bKY - this.bKW : i;
            if (i3 > this.mParentHeight - this.bKX) {
                i3 = this.mParentHeight - this.bKX;
            }
            int i5 = (this.bKY - i4) - this.bKW;
            int i6 = (this.mParentHeight - i3) - this.bKX;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.bKV.setX(i4);
            this.bKV.setY(i3);
            requestLayout();
        }
    }

    public void abK() {
        if (this.bKV != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.bKV.animate().x((af.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.bKW).y((af.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.bKX).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bKY = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.bKY + ", mScreenHeight = " + this.mParentHeight);
        }
        abK();
    }
}
