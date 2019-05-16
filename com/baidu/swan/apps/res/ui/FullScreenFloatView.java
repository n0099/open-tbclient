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
    public View aIQ;
    public int aIR;
    public int aIS;
    public int aIT;
    public boolean aIU;
    public boolean aIV;
    public boolean aIW;
    public float aIX;
    public float aIY;
    public a aIZ;
    public b aJa;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface b {
        void FL();

        void onClick();
    }

    public b getDragImageListener() {
        return this.aJa;
    }

    public void setDragImageListener(b bVar) {
        this.aJa = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.aIW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.aIU = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIZ = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIZ = new a();
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

    public void X(View view) {
        if (this.aIT == 0) {
            this.aIT = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.aIR = view.getWidth();
        this.aIS = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.aIT + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.aIR + ", mFloatViewHeight = " + this.aIS);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.aIQ == null) {
                    this.aIQ = findViewById(a.f.float_imgview);
                    X(this.aIQ);
                }
                this.aIQ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aIV = true;
                    this.aIX = x;
                    this.aIY = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aIT = getWidth();
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
                this.aIQ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aIX = x;
                    this.aIY = y;
                    this.aIV = true;
                    this.aIU = true;
                    postDelayed(this.aIZ, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aIU) {
                    if (this.aJa != null) {
                        this.aJa.onClick();
                    }
                    removeCallbacks(this.aIZ);
                } else if (this.aIV && this.aJa != null) {
                    this.aJa.FL();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aIU);
                }
                if (this.aIW && !this.aIU && x > this.aIR / 2 && x < this.aIT - (this.aIR / 2) && y > this.aIS / 2 && y < this.mParentHeight - (this.aIS / 2)) {
                    int q = q(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + q);
                    }
                    switch (q) {
                        case 1:
                            break;
                        case 2:
                            f = this.aIT - this.aIR;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.aIS;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (q) {
                        case 1:
                        case 2:
                            this.aIQ.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.aIQ.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.aIU = false;
                this.aIV = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aIX);
                float abs2 = Math.abs(y - this.aIY);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aIU = false;
                }
                p(x, y);
                break;
            case 3:
                this.aIU = false;
                this.aIV = false;
                break;
            case 4:
                this.aIU = false;
                this.aIV = false;
                break;
        }
        return this.aIU || this.aIV;
    }

    public int q(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.aIT) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.aIT) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.aIT) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void p(float f, float f2) {
        if (this.aIQ != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aIR / 2));
            int i2 = (int) (f2 - (this.aIS / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.aIT - this.aIR ? this.aIT - this.aIR : i;
            if (i3 > this.mParentHeight - this.aIS) {
                i3 = this.mParentHeight - this.aIS;
            }
            int i5 = (this.aIT - i4) - this.aIR;
            int i6 = (this.mParentHeight - i3) - this.aIS;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aIQ.setX(i4);
            this.aIQ.setY(i3);
            requestLayout();
        }
    }

    public void Jn() {
        if (this.aIQ != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.aIQ.animate().x((z.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.aIR).y((z.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.aIS).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aIT = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.aIT + ", mScreenHeight = " + this.mParentHeight);
        }
        Jn();
    }
}
