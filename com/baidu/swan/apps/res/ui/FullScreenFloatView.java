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
    public float byX;
    public View dhV;
    public int dhW;
    public int dhX;
    public int dhY;
    public boolean dhZ;
    public boolean dia;
    public boolean dib;
    public float dic;
    public a die;
    public b dif;
    public int mParentHeight;
    public int mStatusBarHeight;

    /* loaded from: classes10.dex */
    public interface b {
        void axd();

        void onClick();
    }

    public b getDragImageListener() {
        return this.dif;
    }

    public void setDragImageListener(b bVar) {
        this.dif = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dib = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.dhZ = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.dhZ = false;
        this.dia = false;
        this.dib = true;
        this.die = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.dhZ = false;
        this.dia = false;
        this.dib = true;
        this.die = new a();
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

    public void au(View view) {
        if (this.dhY == 0) {
            this.dhY = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.dhW = view.getWidth();
        this.dhX = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.dhY + ", mScreenHeight = " + this.mParentHeight + ",mFloatViewWidth = " + this.dhW + ", mFloatViewHeight = " + this.dhX);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dhV == null) {
                    this.dhV = findViewById(a.f.float_imgview);
                    au(this.dhV);
                }
                this.dhV.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dia = true;
                    this.dic = x;
                    this.byX = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dhY = getWidth();
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
                this.dhV.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dic = x;
                    this.byX = y;
                    this.dia = true;
                    this.dhZ = true;
                    postDelayed(this.die, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dhZ) {
                    if (this.dif != null) {
                        this.dif.onClick();
                    }
                    removeCallbacks(this.die);
                } else if (this.dia && this.dif != null) {
                    this.dif.axd();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dhZ);
                }
                if (this.dib && !this.dhZ && x > this.dhW / 2 && x < this.dhY - (this.dhW / 2) && y > this.dhX / 2 && y < this.mParentHeight - (this.dhX / 2)) {
                    int o = o(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.mParentHeight + ", mintype = " + o);
                    }
                    switch (o) {
                        case 1:
                            break;
                        case 2:
                            f = this.dhY - this.dhW;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.dhX;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (o) {
                        case 1:
                        case 2:
                            this.dhV.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dhV.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.dhZ = false;
                this.dia = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dic);
                float abs2 = Math.abs(y - this.byX);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dhZ = false;
                }
                n(x, y);
                break;
            case 3:
                this.dhZ = false;
                this.dia = false;
                break;
            case 4:
                this.dhZ = false;
                this.dia = false;
                break;
        }
        return this.dhZ || this.dia;
    }

    public int o(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.dhY) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.dhY) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.dhY) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void n(float f, float f2) {
        if (this.dhV != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dhW / 2));
            int i2 = (int) (f2 - (this.dhX / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.dhY - this.dhW ? this.dhY - this.dhW : i;
            if (i3 > this.mParentHeight - this.dhX) {
                i3 = this.mParentHeight - this.dhX;
            }
            int i5 = (this.dhY - i4) - this.dhW;
            int i6 = (this.mParentHeight - i3) - this.dhX;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dhV.setX(i4);
            this.dhV.setY(i3);
            requestLayout();
        }
    }

    public void aDL() {
        if (this.dhV != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dhV.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dhW).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dhX).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dhY = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.dhY + ", mScreenHeight = " + this.mParentHeight);
        }
        aDL();
    }
}
