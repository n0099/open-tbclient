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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bNR;
    public View dxK;
    public int dxL;
    public int dxM;
    public boolean dxN;
    public boolean dxO;
    public boolean dxP;
    public float dxQ;
    public a dxR;
    public b dxS;
    public int mParentHeight;
    public int mParentWidth;
    public int mStatusBarHeight;

    /* loaded from: classes8.dex */
    public interface b {
        void aAd();

        void onClick();
    }

    public b getDragImageListener() {
        return this.dxS;
    }

    public void setDragImageListener(b bVar) {
        this.dxS = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dxP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.dxN = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.dxN = false;
        this.dxO = false;
        this.dxP = true;
        this.dxR = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.dxN = false;
        this.dxO = false;
        this.dxP = true;
        this.dxR = new a();
        setStatusBarHeight();
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
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

    public void aD(View view) {
        if (this.mParentWidth == 0) {
            this.mParentWidth = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.dxL = view.getWidth();
        this.dxM = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.mParentWidth + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.dxL + ", mFloatViewHeight = " + this.dxM);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dxK == null) {
                    this.dxK = findViewById(a.f.float_imgview);
                    aD(this.dxK);
                }
                this.dxK.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dxO = true;
                    this.dxQ = x;
                    this.bNR = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mParentWidth = getWidth();
        this.mParentHeight = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.dxK.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dxQ = x;
                    this.bNR = y;
                    this.dxO = true;
                    this.dxN = true;
                    postDelayed(this.dxR, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dxN) {
                    if (this.dxS != null) {
                        this.dxS.onClick();
                    }
                    removeCallbacks(this.dxR);
                } else if (this.dxO && this.dxS != null) {
                    this.dxS.aAd();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dxN);
                }
                if (this.dxP && !this.dxN && x > this.dxL / 2 && x < this.mParentWidth - (this.dxL / 2) && y > this.dxM / 2 && y < this.mParentHeight - (this.dxM / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            x = 0.0f;
                            break;
                        case 2:
                            x = this.mParentWidth - this.dxL;
                            break;
                        case 3:
                            y = 0.0f;
                            break;
                        case 4:
                            y = this.mParentHeight - this.dxM;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.dxK.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dxK.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.dxN = false;
                this.dxO = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dxQ);
                float abs2 = Math.abs(y - this.bNR);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dxN = false;
                }
                o(x, y);
                break;
            case 3:
                this.dxN = false;
                this.dxO = false;
                break;
            case 4:
                this.dxN = false;
                this.dxO = false;
                break;
        }
        return this.dxN || this.dxO;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.mParentWidth) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.mParentWidth) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.mParentWidth) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.dxK != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dxL / 2));
            int i2 = (int) (f2 - (this.dxM / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.mParentWidth - this.dxL ? this.mParentWidth - this.dxL : i;
            if (i3 > this.mParentHeight - this.dxM) {
                i3 = this.mParentHeight - this.dxM;
            }
            int i5 = (this.mParentWidth - i4) - this.dxL;
            int i6 = (this.mParentHeight - i3) - this.dxM;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dxK.setX(i4);
            this.dxK.setY(i3);
            requestLayout();
        }
    }

    public void aGP() {
        if (this.dxK != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dxK.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dxL).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dxM).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mParentWidth = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.mParentWidth + ", mScreenHeight = " + this.mParentHeight);
        }
        aGP();
    }
}
