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
    public float aDd;
    public View bKU;
    public int bKV;
    public int bKW;
    public int bKX;
    public boolean bKY;
    public boolean bKZ;
    public boolean bLa;
    public float bLb;
    public a bLc;
    public b bLd;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface b {
        void WI();

        void onClick();
    }

    public b getDragImageListener() {
        return this.bLd;
    }

    public void setDragImageListener(b bVar) {
        this.bLd = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.bLa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.bKY = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.bKY = false;
        this.bKZ = false;
        this.bLa = true;
        this.bLc = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.bKY = false;
        this.bKZ = false;
        this.bLa = true;
        this.bLc = new a();
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
        if (this.bKX == 0) {
            this.bKX = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.bKV = view.getWidth();
        this.bKW = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.bKX + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.bKV + ", mFloatViewHeight = " + this.bKW);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.bKU == null) {
                    this.bKU = findViewById(a.f.float_imgview);
                    al(this.bKU);
                }
                this.bKU.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bKZ = true;
                    this.bLb = x;
                    this.aDd = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bKX = getWidth();
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
                this.bKU.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bLb = x;
                    this.aDd = y;
                    this.bKZ = true;
                    this.bKY = true;
                    postDelayed(this.bLc, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bKY) {
                    if (this.bLd != null) {
                        this.bLd.onClick();
                    }
                    removeCallbacks(this.bLc);
                } else if (this.bKZ && this.bLd != null) {
                    this.bLd.WI();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bKY);
                }
                if (this.bLa && !this.bKY && x > this.bKV / 2 && x < this.bKX - (this.bKV / 2) && y > this.bKW / 2 && y < this.mParentHeight - (this.bKW / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.bKX - this.bKV;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.bKW;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.bKU.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.bKU.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.bKY = false;
                this.bKZ = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bLb);
                float abs2 = Math.abs(y - this.aDd);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bKY = false;
                }
                o(x, y);
                break;
            case 3:
                this.bKY = false;
                this.bKZ = false;
                break;
            case 4:
                this.bKY = false;
                this.bKZ = false;
                break;
        }
        return this.bKY || this.bKZ;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.bKX) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.bKX) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.bKX) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.bKU != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bKV / 2));
            int i2 = (int) (f2 - (this.bKW / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.bKX - this.bKV ? this.bKX - this.bKV : i;
            if (i3 > this.mParentHeight - this.bKW) {
                i3 = this.mParentHeight - this.bKW;
            }
            int i5 = (this.bKX - i4) - this.bKV;
            int i6 = (this.mParentHeight - i3) - this.bKW;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.bKU.setX(i4);
            this.bKU.setY(i3);
            requestLayout();
        }
    }

    public void abK() {
        if (this.bKU != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.bKU.animate().x((af.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.bKV).y((af.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.bKW).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bKX = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.bKX + ", mScreenHeight = " + this.mParentHeight);
        }
        abK();
    }
}
