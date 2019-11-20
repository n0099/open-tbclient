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
    public float aqo;
    public View bcS;
    public int bcT;
    public int bcU;
    public int bcV;
    public boolean bcW;
    public boolean bcX;
    public boolean bcY;
    public float bcZ;
    public a bda;
    public b bdb;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void Lu();

        void onClick();
    }

    public b getDragImageListener() {
        return this.bdb;
    }

    public void setDragImageListener(b bVar) {
        this.bdb = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.bcY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.bcW = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.bcW = false;
        this.bcX = false;
        this.bcY = true;
        this.bda = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.bcW = false;
        this.bcX = false;
        this.bcY = true;
        this.bda = new a();
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
        if (this.bcV == 0) {
            this.bcV = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.bcT = view.getWidth();
        this.bcU = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.bcV + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.bcT + ", mFloatViewHeight = " + this.bcU);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.bcS == null) {
                    this.bcS = findViewById(a.f.float_imgview);
                    af(this.bcS);
                }
                this.bcS.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bcX = true;
                    this.bcZ = x;
                    this.aqo = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bcV = getWidth();
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
                this.bcS.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bcZ = x;
                    this.aqo = y;
                    this.bcX = true;
                    this.bcW = true;
                    postDelayed(this.bda, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bcW) {
                    if (this.bdb != null) {
                        this.bdb.onClick();
                    }
                    removeCallbacks(this.bda);
                } else if (this.bcX && this.bdb != null) {
                    this.bdb.Lu();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bcW);
                }
                if (this.bcY && !this.bcW && x > this.bcT / 2 && x < this.bcV - (this.bcT / 2) && y > this.bcU / 2 && y < this.mParentHeight - (this.bcU / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.bcV - this.bcT;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.bcU;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.bcS.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.bcS.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.bcW = false;
                this.bcX = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bcZ);
                float abs2 = Math.abs(y - this.aqo);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bcW = false;
                }
                o(x, y);
                break;
            case 3:
                this.bcW = false;
                this.bcX = false;
                break;
            case 4:
                this.bcW = false;
                this.bcX = false;
                break;
        }
        return this.bcW || this.bcX;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.bcV) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.bcV) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.bcV) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.bcS != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bcT / 2));
            int i2 = (int) (f2 - (this.bcU / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.bcV - this.bcT ? this.bcV - this.bcT : i;
            if (i3 > this.mParentHeight - this.bcU) {
                i3 = this.mParentHeight - this.bcU;
            }
            int i5 = (this.bcV - i4) - this.bcT;
            int i6 = (this.mParentHeight - i3) - this.bcU;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.bcS.setX(i4);
            this.bcS.setY(i3);
            requestLayout();
        }
    }

    public void OY() {
        if (this.bcS != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.bcS.animate().x((z.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.bcT).y((z.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.bcU).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bcV = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.bcV + ", mScreenHeight = " + this.mParentHeight);
        }
        OY();
    }
}
