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
/* loaded from: classes9.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bNt;
    public View dyL;
    public int dyM;
    public int dyN;
    public int dyO;
    public int dyP;
    public boolean dyQ;
    public boolean dyR;
    public boolean dyS;
    public float dyT;
    public a dyU;
    public b dyV;
    public int mStatusBarHeight;

    /* loaded from: classes9.dex */
    public interface b {
        void aDv();

        void onClick();
    }

    public b getDragImageListener() {
        return this.dyV;
    }

    public void setDragImageListener(b bVar) {
        this.dyV = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dyS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.dyQ = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.dyQ = false;
        this.dyR = false;
        this.dyS = true;
        this.dyU = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.dyQ = false;
        this.dyR = false;
        this.dyS = true;
        this.dyU = new a();
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

    public void aH(View view) {
        if (this.dyO == 0) {
            this.dyO = getWidth();
        }
        if (this.dyP == 0) {
            this.dyP = getHeight();
        }
        this.dyM = view.getWidth();
        this.dyN = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.dyO + ", mScreenHeight = " + this.dyP + ",mFloatViewWidth = " + this.dyM + ", mFloatViewHeight = " + this.dyN);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dyL == null) {
                    this.dyL = findViewById(a.f.float_imgview);
                    aH(this.dyL);
                }
                this.dyL.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dyR = true;
                    this.dyT = x;
                    this.bNt = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dyO = getWidth();
        this.dyP = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.dyL.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dyT = x;
                    this.bNt = y;
                    this.dyR = true;
                    this.dyQ = true;
                    postDelayed(this.dyU, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dyQ) {
                    if (this.dyV != null) {
                        this.dyV.onClick();
                    }
                    removeCallbacks(this.dyU);
                } else if (this.dyR && this.dyV != null) {
                    this.dyV.aDv();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dyQ);
                }
                if (this.dyS && !this.dyQ && x > this.dyM / 2 && x < this.dyO - (this.dyM / 2) && y > this.dyN / 2 && y < this.dyP - (this.dyN / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.dyP + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            x = 0.0f;
                            break;
                        case 2:
                            x = this.dyO - this.dyM;
                            break;
                        case 3:
                            y = 0.0f;
                            break;
                        case 4:
                            y = this.dyP - this.dyN;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.dyL.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dyL.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.dyQ = false;
                this.dyR = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dyT);
                float abs2 = Math.abs(y - this.bNt);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dyQ = false;
                }
                n(x, y);
                break;
            case 3:
                this.dyQ = false;
                this.dyR = false;
                break;
            case 4:
                this.dyQ = false;
                this.dyR = false;
                break;
        }
        return this.dyQ || this.dyR;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.dyO) - f;
        boolean z2 = f2 <= ((float) this.dyP) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.dyP) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.dyO) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.dyO) - f <= ((float) this.dyP) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.dyL != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dyM / 2));
            int i2 = (int) (f2 - (this.dyN / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.dyO - this.dyM ? this.dyO - this.dyM : i;
            if (i3 > this.dyP - this.dyN) {
                i3 = this.dyP - this.dyN;
            }
            int i5 = (this.dyO - i4) - this.dyM;
            int i6 = (this.dyP - i3) - this.dyN;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dyL.setX(i4);
            this.dyL.setY(i3);
            requestLayout();
        }
    }

    public void aKk() {
        if (this.dyL != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dyL.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dyM).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dyN).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dyO = getHeight() + this.mStatusBarHeight;
        this.dyP = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.dyO + ", mScreenHeight = " + this.dyP);
        }
        aKk();
    }
}
