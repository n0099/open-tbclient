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
import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float aXa;
    public View cjQ;
    public int cjR;
    public int cjS;
    public int cjT;
    public boolean cjU;
    public boolean cjV;
    public boolean cjW;
    public float cjX;
    public a cjY;
    public b cjZ;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface b {
        void aeA();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cjZ;
    }

    public void setDragImageListener(b bVar) {
        this.cjZ = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cjW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cjU = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cjU = false;
        this.cjV = false;
        this.cjW = true;
        this.cjY = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cjU = false;
        this.cjV = false;
        this.cjW = true;
        this.cjY = new a();
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
        if (this.cjT == 0) {
            this.cjT = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cjR = view.getWidth();
        this.cjS = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cjT + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cjR + ", mFloatViewHeight = " + this.cjS);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cjQ == null) {
                    this.cjQ = findViewById(a.f.float_imgview);
                    am(this.cjQ);
                }
                this.cjQ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cjV = true;
                    this.cjX = x;
                    this.aXa = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cjT = getWidth();
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
                this.cjQ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cjX = x;
                    this.aXa = y;
                    this.cjV = true;
                    this.cjU = true;
                    postDelayed(this.cjY, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cjU) {
                    if (this.cjZ != null) {
                        this.cjZ.onClick();
                    }
                    removeCallbacks(this.cjY);
                } else if (this.cjV && this.cjZ != null) {
                    this.cjZ.aeA();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cjU);
                }
                if (this.cjW && !this.cjU && x > this.cjR / 2 && x < this.cjT - (this.cjR / 2) && y > this.cjS / 2 && y < this.mParentHeight - (this.cjS / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.cjT - this.cjR;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cjS;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.cjQ.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cjQ.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cjU = false;
                this.cjV = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cjX);
                float abs2 = Math.abs(y - this.aXa);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cjU = false;
                }
                n(x, y);
                break;
            case 3:
                this.cjU = false;
                this.cjV = false;
                break;
            case 4:
                this.cjU = false;
                this.cjV = false;
                break;
        }
        return this.cjU || this.cjV;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cjT) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cjT) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cjT) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.cjQ != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cjR / 2));
            int i2 = (int) (f2 - (this.cjS / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cjT - this.cjR ? this.cjT - this.cjR : i;
            if (i3 > this.mParentHeight - this.cjS) {
                i3 = this.mParentHeight - this.cjS;
            }
            int i5 = (this.cjT - i4) - this.cjR;
            int i6 = (this.mParentHeight - i3) - this.cjS;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cjQ.setX(i4);
            this.cjQ.setY(i3);
            requestLayout();
        }
    }

    public void ajS() {
        if (this.cjQ != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cjQ.animate().x((af.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cjR).y((af.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cjS).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cjT = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cjT + ", mScreenHeight = " + this.mParentHeight);
        }
        ajS();
    }
}
