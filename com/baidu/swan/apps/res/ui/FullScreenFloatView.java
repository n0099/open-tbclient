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
/* loaded from: classes10.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bFi;
    public View dnR;
    public int dnS;
    public int dnT;
    public int dnU;
    public boolean dnV;
    public boolean dnW;
    public boolean dnX;
    public float dnY;
    public a dnZ;
    public b doa;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes10.dex */
    public interface b {
        void azD();

        void onClick();
    }

    public b getDragImageListener() {
        return this.doa;
    }

    public void setDragImageListener(b bVar) {
        this.doa = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dnX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.dnV = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.dnV = false;
        this.dnW = false;
        this.dnX = true;
        this.dnZ = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.dnV = false;
        this.dnW = false;
        this.dnX = true;
        this.dnZ = new a();
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

    public void ay(View view) {
        if (this.dnU == 0) {
            this.dnU = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.dnS = view.getWidth();
        this.dnT = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.dnU + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.dnS + ", mFloatViewHeight = " + this.dnT);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dnR == null) {
                    this.dnR = findViewById(a.f.float_imgview);
                    ay(this.dnR);
                }
                this.dnR.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dnW = true;
                    this.dnY = x;
                    this.bFi = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dnU = getWidth();
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
                this.dnR.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dnY = x;
                    this.bFi = y;
                    this.dnW = true;
                    this.dnV = true;
                    postDelayed(this.dnZ, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dnV) {
                    if (this.doa != null) {
                        this.doa.onClick();
                    }
                    removeCallbacks(this.dnZ);
                } else if (this.dnW && this.doa != null) {
                    this.doa.azD();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dnV);
                }
                if (this.dnX && !this.dnV && x > this.dnS / 2 && x < this.dnU - (this.dnS / 2) && y > this.dnT / 2 && y < this.mParentHeight - (this.dnT / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.dnU - this.dnS;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.dnT;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.dnR.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dnR.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.dnV = false;
                this.dnW = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dnY);
                float abs2 = Math.abs(y - this.bFi);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dnV = false;
                }
                n(x, y);
                break;
            case 3:
                this.dnV = false;
                this.dnW = false;
                break;
            case 4:
                this.dnV = false;
                this.dnW = false;
                break;
        }
        return this.dnV || this.dnW;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.dnU) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.dnU) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.dnU) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.dnR != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dnS / 2));
            int i2 = (int) (f2 - (this.dnT / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.dnU - this.dnS ? this.dnU - this.dnS : i;
            if (i3 > this.mParentHeight - this.dnT) {
                i3 = this.mParentHeight - this.dnT;
            }
            int i5 = (this.dnU - i4) - this.dnS;
            int i6 = (this.mParentHeight - i3) - this.dnT;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dnR.setX(i4);
            this.dnR.setY(i3);
            requestLayout();
        }
    }

    public void aGl() {
        if (this.dnR != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dnR.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dnS).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dnT).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dnU = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.dnU + ", mScreenHeight = " + this.mParentHeight);
        }
        aGl();
    }
}
