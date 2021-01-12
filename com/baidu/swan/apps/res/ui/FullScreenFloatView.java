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
    public float bIH;
    public View dtZ;
    public int dua;
    public int dub;
    public int duc;
    public int dud;
    public boolean due;
    public boolean duf;
    public boolean dug;
    public float duh;
    public a dui;
    public b duj;
    public int mStatusBarHeight;

    /* loaded from: classes8.dex */
    public interface b {
        void azC();

        void onClick();
    }

    public b getDragImageListener() {
        return this.duj;
    }

    public void setDragImageListener(b bVar) {
        this.duj = bVar;
    }

    public void setAutoAttachEnable(boolean z) {
        this.dug = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.due = false;
            if (FullScreenFloatView.DEBUG) {
                Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
            }
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.due = false;
        this.duf = false;
        this.dug = true;
        this.dui = new a();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.due = false;
        this.duf = false;
        this.dug = true;
        this.dui = new a();
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
        if (this.duc == 0) {
            this.duc = getWidth();
        }
        if (this.dud == 0) {
            this.dud = getHeight();
        }
        this.dua = view.getWidth();
        this.dub = view.getHeight();
        if (DEBUG) {
            Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.duc + ", mScreenHeight = " + this.dud + ",mFloatViewWidth = " + this.dua + ", mFloatViewHeight = " + this.dub);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.dtZ == null) {
                    this.dtZ = findViewById(a.f.float_imgview);
                    aH(this.dtZ);
                }
                this.dtZ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.duf = true;
                    this.duh = x;
                    this.bIH = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.duc = getWidth();
        this.dud = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.dtZ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.duh = x;
                    this.bIH = y;
                    this.duf = true;
                    this.due = true;
                    postDelayed(this.dui, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.due) {
                    if (this.duj != null) {
                        this.duj.onClick();
                    }
                    removeCallbacks(this.dui);
                } else if (this.duf && this.duj != null) {
                    this.duj.azC();
                }
                if (DEBUG) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.due);
                }
                if (this.dug && !this.due && x > this.dua / 2 && x < this.duc - (this.dua / 2) && y > this.dub / 2 && y < this.dud - (this.dub / 2)) {
                    int p = p(x, y);
                    if (DEBUG) {
                        Log.e("FullScreenFloatView", "mScreenHeight = " + this.dud + ", mintype = " + p);
                    }
                    switch (p) {
                        case 1:
                            x = 0.0f;
                            break;
                        case 2:
                            x = this.duc - this.dua;
                            break;
                        case 3:
                            y = 0.0f;
                            break;
                        case 4:
                            y = this.dud - this.dub;
                            break;
                    }
                    switch (p) {
                        case 1:
                        case 2:
                            this.dtZ.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.dtZ.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.due = false;
                this.duf = false;
                break;
            case 2:
                float abs = Math.abs(x - this.duh);
                float abs2 = Math.abs(y - this.bIH);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.due = false;
                }
                o(x, y);
                break;
            case 3:
                this.due = false;
                this.duf = false;
                break;
            case 4:
                this.due = false;
                this.duf = false;
                break;
        }
        return this.due || this.duf;
    }

    public int p(float f, float f2) {
        if (DEBUG) {
            Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
        }
        boolean z = f <= ((float) this.duc) - f;
        boolean z2 = f2 <= ((float) this.dud) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.dud) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.duc) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.duc) - f <= ((float) this.dud) - f2 ? 2 : 4;
        }
    }

    private void o(float f, float f2) {
        if (this.dtZ != null) {
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dua / 2));
            int i2 = (int) (f2 - (this.dub / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.duc - this.dua ? this.duc - this.dua : i;
            if (i3 > this.dud - this.dub) {
                i3 = this.dud - this.dub;
            }
            int i5 = (this.duc - i4) - this.dua;
            int i6 = (this.dud - i3) - this.dub;
            if (DEBUG) {
                Log.e("FullScreenFloatView", "move--> left = " + i4 + ", top = " + i3 + ", right = " + i5 + ",bottom = " + i6 + ", mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.dtZ.setX(i4);
            this.dtZ.setY(i3);
            requestLayout();
        }
    }

    public void aGr() {
        if (this.dtZ != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.dimens_51dp);
            this.dtZ.animate().x((ah.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.dua).y((ah.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.dub).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.duc = getHeight() + this.mStatusBarHeight;
        this.dud = getWidth() - this.mStatusBarHeight;
        if (DEBUG) {
            Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.duc + ", mScreenHeight = " + this.dud);
        }
        aGr();
    }
}
