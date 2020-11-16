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
/* loaded from: classes7.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bDx;
    public View dmj;
    public int dmk;
    public int dml;
    public int dmm;
    public boolean dmn;
    public boolean dmo;
    public boolean dmp;
    public float dmq;
    public a dmr;
    public b dms;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes7.dex */
    public interface b {
        void ayV();

        void onClick();
    }

    public b getDragImageListener() {
        return this.dms;
    }

    public void setDragImageListener(b bVar) {
        this.dms = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dmp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.dmn = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.dmn = false;
        this.dmo = false;
        this.dmp = true;
        this.dmr = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.dmn = false;
        this.dmo = false;
        this.dmp = true;
        this.dmr = new a();
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
        if (this.dmm == 0) {
            this.dmm = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.dmk = view.getWidth();
        this.dml = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.dmm + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.dmk + ", mFloatViewHeight = " + this.dml);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dmj == null) {
                    this.dmj = findViewById(a.f.float_imgview);
                    ay(this.dmj);
                }
                this.dmj.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dmo = true;
                    this.dmq = x;
                    this.bDx = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dmm = getWidth();
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
                this.dmj.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dmq = x;
                    this.bDx = y;
                    this.dmo = true;
                    this.dmn = true;
                    postDelayed(this.dmr, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dmn) {
                    if (this.dms != null) {
                        this.dms.onClick();
                    }
                    removeCallbacks(this.dmr);
                } else if (this.dmo && this.dms != null) {
                    this.dms.ayV();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dmn);
                }
                if (this.dmp && !this.dmn && x > this.dmk / 2 && x < this.dmm - (this.dmk / 2) && y > this.dml / 2 && y < this.mParentHeight - (this.dml / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.dmm - this.dmk;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.dml;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.dmj.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dmj.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.dmn = false;
                this.dmo = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dmq);
                float abs2 = Math.abs(y - this.bDx);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dmn = false;
                }
                n(x, y);
                break;
            case 3:
                this.dmn = false;
                this.dmo = false;
                break;
            case 4:
                this.dmn = false;
                this.dmo = false;
                break;
        }
        return this.dmn || this.dmo;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.dmm) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.dmm) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.dmm) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.dmj != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dmk / 2));
            int i2 = (int) (f2 - (this.dml / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.dmm - this.dmk ? this.dmm - this.dmk : i;
            if (i3 > this.mParentHeight - this.dml) {
                i3 = this.mParentHeight - this.dml;
            }
            int i5 = (this.dmm - i4) - this.dmk;
            int i6 = (this.mParentHeight - i3) - this.dml;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dmj.setX(i4);
            this.dmj.setY(i3);
            requestLayout();
        }
    }

    public void aFD() {
        if (this.dmj != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dmj.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dmk).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dml).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dmm = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.dmm + ", mScreenHeight = " + this.mParentHeight);
        }
        aFD();
    }
}
