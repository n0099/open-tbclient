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
import com.baidu.swan.apps.aq.ai;
/* loaded from: classes7.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public float bke;
    public View cCY;
    public int cCZ;
    public int cDa;
    public int cDb;
    public boolean cDc;
    public boolean cDd;
    public boolean cDe;
    public float cDf;
    public a cDg;
    public b cDh;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes7.dex */
    public interface b {
        void akg();

        void onClick();
    }

    public b getDragImageListener() {
        return this.cDh;
    }

    public void setDragImageListener(b bVar) {
        this.cDh = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.cDe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.cDc = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.cDc = false;
        this.cDd = false;
        this.cDe = true;
        this.cDg = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.cDc = false;
        this.cDd = false;
        this.cDe = true;
        this.cDg = new a();
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

    public void ap(View view) {
        if (this.cDb == 0) {
            this.cDb = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.cCZ = view.getWidth();
        this.cDa = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.cDb + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.cCZ + ", mFloatViewHeight = " + this.cDa);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.cCY == null) {
                    this.cCY = findViewById(a.f.float_imgview);
                    ap(this.cCY);
                }
                this.cCY.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cDd = true;
                    this.cDf = x;
                    this.bke = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.cDb = getWidth();
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
                this.cCY.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.cDf = x;
                    this.bke = y;
                    this.cDd = true;
                    this.cDc = true;
                    postDelayed(this.cDg, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.cDc) {
                    if (this.cDh != null) {
                        this.cDh.onClick();
                    }
                    removeCallbacks(this.cDg);
                } else if (this.cDd && this.cDh != null) {
                    this.cDh.akg();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.cDc);
                }
                if (this.cDe && !this.cDc && x > this.cCZ / 2 && x < this.cDb - (this.cCZ / 2) && y > this.cDa / 2 && y < this.mParentHeight - (this.cDa / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.cDb - this.cCZ;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.cDa;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.cCY.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.cCY.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.cDc = false;
                this.cDd = false;
                break;
            case 2:
                float abs = Math.abs(x - this.cDf);
                float abs2 = Math.abs(y - this.bke);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.cDc = false;
                }
                n(x, y);
                break;
            case 3:
                this.cDc = false;
                this.cDd = false;
                break;
            case 4:
                this.cDc = false;
                this.cDd = false;
                break;
        }
        return this.cDc || this.cDd;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.cDb) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.cDb) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.cDb) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.cCY != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.cCZ / 2));
            int i2 = (int) (f2 - (this.cDa / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.cDb - this.cCZ ? this.cDb - this.cCZ : i;
            if (i3 > this.mParentHeight - this.cDa) {
                i3 = this.mParentHeight - this.cDa;
            }
            int i5 = (this.cDb - i4) - this.cCZ;
            int i6 = (this.mParentHeight - i3) - this.cDa;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.cCY.setX(i4);
            this.cCY.setY(i3);
            requestLayout();
        }
    }

    public void aqv() {
        if (this.cCY != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.cCY.animate().x((ai.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.cCZ).y((ai.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.cDa).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cDb = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.cDb + ", mScreenHeight = " + this.mParentHeight);
        }
        aqv();
    }
}
