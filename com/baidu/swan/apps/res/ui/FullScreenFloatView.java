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
/* loaded from: classes10.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float ayM;
    public View bGO;
    public int bGP;
    public int bGQ;
    public int bGR;
    public boolean bGS;
    public boolean bGT;
    public boolean bGU;
    public float bGV;
    public a bGW;
    public b bGX;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes10.dex */
    public interface b {
        void Us();

        void onClick();
    }

    public b getDragImageListener() {
        return this.bGX;
    }

    public void setDragImageListener(b bVar) {
        this.bGX = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.bGU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.bGS = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.bGS = false;
        this.bGT = false;
        this.bGU = true;
        this.bGW = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.bGS = false;
        this.bGT = false;
        this.bGU = true;
        this.bGW = new a();
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
        if (this.bGR == 0) {
            this.bGR = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.bGP = view.getWidth();
        this.bGQ = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.bGR + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.bGP + ", mFloatViewHeight = " + this.bGQ);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.bGO == null) {
                    this.bGO = findViewById(a.f.float_imgview);
                    al(this.bGO);
                }
                this.bGO.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bGT = true;
                    this.bGV = x;
                    this.ayM = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bGR = getWidth();
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
                this.bGO.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bGV = x;
                    this.ayM = y;
                    this.bGT = true;
                    this.bGS = true;
                    postDelayed(this.bGW, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bGS) {
                    if (this.bGX != null) {
                        this.bGX.onClick();
                    }
                    removeCallbacks(this.bGW);
                } else if (this.bGT && this.bGX != null) {
                    this.bGX.Us();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bGS);
                }
                if (this.bGU && !this.bGS && x > this.bGP / 2 && x < this.bGR - (this.bGP / 2) && y > this.bGQ / 2 && y < this.mParentHeight - (this.bGQ / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            break;
                        case 2:
                            f = this.bGR - this.bGP;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.bGQ;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.bGO.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.bGO.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.bGS = false;
                this.bGT = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bGV);
                float abs2 = Math.abs(y - this.ayM);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bGS = false;
                }
                o(x, y);
                break;
            case 3:
                this.bGS = false;
                this.bGT = false;
                break;
            case 4:
                this.bGS = false;
                this.bGT = false;
                break;
        }
        return this.bGS || this.bGT;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.bGR) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.bGR) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.bGR) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.bGO != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bGP / 2));
            int i2 = (int) (f2 - (this.bGQ / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.bGR - this.bGP ? this.bGR - this.bGP : i;
            if (i3 > this.mParentHeight - this.bGQ) {
                i3 = this.mParentHeight - this.bGQ;
            }
            int i5 = (this.bGR - i4) - this.bGP;
            int i6 = (this.mParentHeight - i3) - this.bGQ;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.bGO.setX(i4);
            this.bGO.setY(i3);
            requestLayout();
        }
    }

    public void Zu() {
        if (this.bGO != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.bGO.animate().x((af.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.bGP).y((af.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.bGQ).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bGR = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.bGR + ", mScreenHeight = " + this.mParentHeight);
        }
        Zu();
    }
}
