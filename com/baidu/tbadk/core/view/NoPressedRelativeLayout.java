package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class NoPressedRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f13107e;

    /* renamed from: f  reason: collision with root package name */
    public View f13108f;

    /* renamed from: g  reason: collision with root package name */
    public float f13109g;

    /* renamed from: h  reason: collision with root package name */
    public int f13110h;
    public float i;
    public Rect j;
    public boolean k;
    public a l;
    public boolean m;

    /* loaded from: classes3.dex */
    public interface a {
        void a(MotionEvent motionEvent);
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13109g = 0.0f;
        this.f13110h = 0;
        this.i = 0.0f;
        this.k = false;
        this.m = false;
        this.f13110h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private Rect getTopViewRect() {
        if (a()) {
            int[] iArr = {0, 0};
            View view = this.f13107e;
            if (view != null) {
                view.getLocationOnScreen(iArr);
                this.j = new Rect(iArr[0], iArr[1], iArr[0] + this.f13107e.getWidth(), iArr[1] + this.f13107e.getHeight());
            }
        }
        return this.j;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        View view = this.f13108f;
        if (view != null) {
            view.setEnabled(z);
            this.f13108f.setClickable(z);
            this.f13108f.setLongClickable(z);
        }
    }

    public final boolean a() {
        if (this.f13107e == null) {
            return false;
        }
        Rect rect = this.j;
        return rect == null || rect.width() <= 0 || this.j.height() <= 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 3) goto L48;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(motionEvent);
        }
        if (this.f13107e != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float abs = this.i > Math.abs(this.f13109g - motionEvent.getRawY()) ? this.i : Math.abs(this.f13109g - motionEvent.getRawY());
                        this.i = abs;
                        if (this.k && abs < this.f13110h) {
                            setBottomViewClickEventEnabled(false);
                        } else {
                            setBottomViewClickEventEnabled(true);
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                if (this.k) {
                    float abs2 = Math.abs(this.f13109g - motionEvent.getRawY());
                    int i = this.f13110h;
                    if (abs2 < i && this.i < i && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.f13107e.isClickable()) {
                            this.f13107e.performClick();
                        }
                        return true;
                    }
                }
            } else {
                this.f13109g = motionEvent.getRawY();
                this.i = 0.0f;
                if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    this.k = true;
                    setBottomViewClickEventEnabled(false);
                } else {
                    this.k = false;
                    setBottomViewClickEventEnabled(true);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setBottomOrderView(View view) {
        this.f13108f = view;
    }

    public void setDispathEventAction(a aVar) {
        this.l = aVar;
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.m = z;
    }

    public void setTopOrderView(View view) {
        this.f13107e = view;
    }
}
