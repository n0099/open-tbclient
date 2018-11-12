package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.tieba.R;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class CustomScrollView extends ScrollView {
    public static final Object TAG = new Object();
    private VelocityTracker a;
    private int b;
    public int bottom;
    private int c;
    private b d;
    private b e;
    private GestureDetector f;
    private GestureDetector g;
    private int h;
    private int i;
    private LinearLayout j;
    private View k;
    private LinearLayout l;
    private boolean m;
    private com.baidu.platform.comapi.wnplatform.n.b n;
    protected Field scrollerField;
    public int top;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i);

        void a(com.baidu.platform.comapi.wnplatform.n.b bVar, com.baidu.platform.comapi.wnplatform.n.b bVar2);
    }

    public CustomScrollView(Context context) {
        this(context, null);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        initView(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        initView(context);
    }

    private void initView(Context context) {
        setTag(TAG);
        this.f = new GestureDetector(context, new c());
        this.g = new GestureDetector(context, new a());
        setFadingEdgeLength(0);
        setVerticalScrollBarEnabled(false);
        this.top = com.baidu.platform.comapi.wnplatform.o.f.c(context) - com.baidu.platform.comapi.wnplatform.o.f.d(context);
        this.bottom = 0;
        this.c = 3;
        com.baidu.platform.comapi.wnplatform.o.a.a.a((Activity) getContext(), R.layout.abc_action_mode_bar, this);
        this.j = (LinearLayout) findViewById(2131165245);
        this.l = (LinearLayout) findViewById(2131165244);
        this.l.setMinimumHeight(this.top);
    }

    public void setStatusHeight(int i, int i2) {
        this.l.setMinimumHeight(i);
        this.top = i;
        this.bottom = i2;
        this.c = 3;
    }

    public void setBlankHeight(int i) {
        this.j.removeAllViews();
        this.k = new View(getContext());
        this.k.setLayoutParams(new AbsListView.LayoutParams(0, i));
        this.j.addView(this.k);
    }

    public void addContentView(View view) {
        this.l.addView(view);
    }

    public void removeContentView(View view) {
        if (this.l != null) {
            this.l.removeView(view);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewConfiguration.get(getContext());
        this.b = ViewConfiguration.getMaximumFlingVelocity();
        if ((this.k == null ? false : canMoveMap(motionEvent, this.k)) && this.n == com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            return false;
        }
        acquireVelocityTracker(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
                VelocityTracker velocityTracker = this.a;
                velocityTracker.computeCurrentVelocity(1000, this.b);
                com.baidu.platform.comapi.wnplatform.n.b calculateNextStatus = calculateNextStatus((int) velocityTracker.getYVelocity(), getScrollY());
                if (calculateNextStatus != com.baidu.platform.comapi.wnplatform.n.b.NULL) {
                    updateStatus(calculateNextStatus, true);
                    return true;
                }
                break;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private com.baidu.platform.comapi.wnplatform.n.b calculateNextStatus(int i, int i2) {
        switch (this.n) {
            case BOTTOM:
                if ((i < 0 && Math.abs(i) > 1000) || i2 > this.c) {
                    return com.baidu.platform.comapi.wnplatform.n.b.TOP;
                }
                return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
            case TOP:
                if (i > 1000 || i2 < this.c) {
                    return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
                }
                if (i2 > this.top) {
                    return com.baidu.platform.comapi.wnplatform.n.b.NULL;
                }
                return com.baidu.platform.comapi.wnplatform.n.b.TOP;
            default:
                return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            stopAnim();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.f.onTouchEvent(motionEvent);
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.a == null) {
            this.a = VelocityTracker.obtain();
        }
        this.a.addMovement(motionEvent);
    }

    private boolean canMoveMap(MotionEvent motionEvent, View view) {
        boolean isPointInsideView = isPointInsideView(motionEvent.getY(), view);
        if (motionEvent.getAction() == 0) {
            if (isPointInsideView) {
                this.m = true;
            } else {
                this.m = false;
            }
        }
        if (motionEvent.getAction() == 1) {
            this.m = false;
        }
        return this.m && isPointInsideView && motionEvent.getAction() != 1;
    }

    private boolean isPointInsideView(float f, View view) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        return f > ((float) rect.top) && f < ((float) (rect.bottom - getScrollY()));
    }

    public void updateStatus(com.baidu.platform.comapi.wnplatform.n.b bVar, boolean z) {
        if (this.d != null) {
            this.d.a(this.n, bVar);
        }
        if (this.e != null) {
            this.e.a(this.n, bVar);
        }
        this.n = bVar;
        switch (bVar) {
            case BOTTOM:
                if (z) {
                    smoothScrollTo(0, this.bottom);
                    return;
                } else {
                    scrollTo(0, this.bottom);
                    return;
                }
            case TOP:
                if (z) {
                    smoothScrollTo(0, this.top);
                    return;
                } else {
                    scrollTo(0, this.top);
                    return;
                }
            default:
                return;
        }
    }

    public com.baidu.platform.comapi.wnplatform.n.b getStatus() {
        return this.n;
    }

    public void setOnScrollChangeListener(b bVar) {
        this.d = bVar;
    }

    public void setCustomOnScrollChangeListener(b bVar) {
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f2) > Math.abs(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return f2 > 0.0f;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.d != null) {
            this.d.a(i2);
        }
        if (this.e != null) {
            this.e.a(i2);
        }
        boolean z = this.h - this.i == i2;
        if (i2 == 0 || z) {
            try {
                if (this.scrollerField == null) {
                    this.scrollerField = getDeclaredField(this, "mScroller");
                }
                Object obj = this.scrollerField.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                } else {
                    return;
                }
            } catch (Exception e) {
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    private void stopAnim() {
        try {
            if (this.scrollerField == null) {
                this.scrollerField = getDeclaredField(this, "mScroller");
            }
            Object obj = this.scrollerField.get(this);
            if (obj != null) {
                obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected int computeVerticalScrollRange() {
        this.h = super.computeVerticalScrollRange();
        return this.h;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.i = i4 - i2;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || (!(view2 instanceof WebView) && !(view2 instanceof ListView) && !(view2 instanceof ScrollView))) {
            super.requestChildFocus(view, view2);
        }
    }

    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
