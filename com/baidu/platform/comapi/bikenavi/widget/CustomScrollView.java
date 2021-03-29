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
/* loaded from: classes2.dex */
public class CustomScrollView extends ScrollView {
    public static final Object TAG = new Object();

    /* renamed from: a  reason: collision with root package name */
    public VelocityTracker f9850a;

    /* renamed from: b  reason: collision with root package name */
    public int f9851b;
    public int bottom;

    /* renamed from: c  reason: collision with root package name */
    public int f9852c;

    /* renamed from: d  reason: collision with root package name */
    public b f9853d;

    /* renamed from: e  reason: collision with root package name */
    public b f9854e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f9855f;

    /* renamed from: g  reason: collision with root package name */
    public GestureDetector f9856g;

    /* renamed from: h  reason: collision with root package name */
    public int f9857h;
    public int i;
    public LinearLayout j;
    public View k;
    public LinearLayout l;
    public boolean m;
    public com.baidu.platform.comapi.wnplatform.n.b n;
    public Field scrollerField;
    public int top;

    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return f3 > 0.0f;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);

        void a(com.baidu.platform.comapi.wnplatform.n.b bVar, com.baidu.platform.comapi.wnplatform.n.b bVar2);
    }

    /* loaded from: classes2.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f3) > Math.abs(f2);
        }
    }

    public CustomScrollView(Context context) {
        this(context, null);
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.f9850a == null) {
            this.f9850a = VelocityTracker.obtain();
        }
        this.f9850a.addMovement(motionEvent);
    }

    private com.baidu.platform.comapi.wnplatform.n.b calculateNextStatus(int i, int i2) {
        int i3 = f.f9876a[this.n.ordinal()];
        if (i3 == 1) {
            if ((i < 0 && Math.abs(i) > 1000) || i2 > this.f9852c) {
                return com.baidu.platform.comapi.wnplatform.n.b.TOP;
            }
            return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        } else if (i3 != 2) {
            return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        } else {
            if (i <= 1000 && i2 >= this.f9852c) {
                if (i2 > this.top) {
                    return com.baidu.platform.comapi.wnplatform.n.b.NULL;
                }
                return com.baidu.platform.comapi.wnplatform.n.b.TOP;
            }
            return com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        }
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

    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void initView(Context context) {
        setTag(TAG);
        this.f9855f = new GestureDetector(context, new c());
        this.f9856g = new GestureDetector(context, new a());
        setFadingEdgeLength(0);
        setVerticalScrollBarEnabled(false);
        this.top = com.baidu.platform.comapi.wnplatform.o.g.c(context) - com.baidu.platform.comapi.wnplatform.o.g.d(context);
        this.bottom = 0;
        this.f9852c = 3;
        com.baidu.platform.comapi.wnplatform.o.a.a.a((Activity) getContext(), R.array.Mask_X006, this);
        this.j = (LinearLayout) findViewById(R.dimen.abc_action_bar_content_inset_with_nav);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.dimen.abc_action_bar_content_inset_material);
        this.l = linearLayout;
        linearLayout.setMinimumHeight(this.top);
    }

    private boolean isPointInsideView(float f2, View view) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        return f2 > ((float) rect.top) && f2 < ((float) (rect.bottom - getScrollY()));
    }

    private void stopAnim() {
        try {
            if (this.scrollerField == null) {
                this.scrollerField = getDeclaredField(this, "mScroller");
            }
            Object obj = this.scrollerField.get(this);
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("abortAnimation", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void addContentView(View view) {
        this.l.addView(view);
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        this.f9857h = computeVerticalScrollRange;
        return computeVerticalScrollRange;
    }

    public com.baidu.platform.comapi.wnplatform.n.b getStatus() {
        return this.n;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            stopAnim();
        }
        return super.onInterceptTouchEvent(motionEvent) && this.f9855f.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.i = i4 - i2;
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        b bVar = this.f9853d;
        if (bVar != null) {
            bVar.a(i2);
        }
        b bVar2 = this.f9854e;
        if (bVar2 != null) {
            bVar2.a(i2);
        }
        boolean z = this.f9857h - this.i == i2;
        if (i2 == 0 || z) {
            try {
                if (this.scrollerField == null) {
                    this.scrollerField = getDeclaredField(this, "mScroller");
                }
                Object obj = this.scrollerField.get(this);
                if (obj != null && (obj instanceof Scroller)) {
                    ((Scroller) obj).abortAnimation();
                }
                return;
            } catch (Exception unused) {
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewConfiguration.get(getContext());
        this.f9851b = ViewConfiguration.getMaximumFlingVelocity();
        View view = this.k;
        if ((view == null ? false : canMoveMap(motionEvent, view)) && this.n == com.baidu.platform.comapi.wnplatform.n.b.BOTTOM) {
            return false;
        }
        acquireVelocityTracker(motionEvent);
        if (motionEvent.getAction() == 1) {
            VelocityTracker velocityTracker = this.f9850a;
            velocityTracker.computeCurrentVelocity(1000, this.f9851b);
            com.baidu.platform.comapi.wnplatform.n.b calculateNextStatus = calculateNextStatus((int) velocityTracker.getYVelocity(), getScrollY());
            if (calculateNextStatus != com.baidu.platform.comapi.wnplatform.n.b.NULL) {
                updateStatus(calculateNextStatus, true);
                return true;
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void removeContentView(View view) {
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 == null || !((view2 instanceof WebView) || (view2 instanceof ListView) || (view2 instanceof ScrollView))) {
            super.requestChildFocus(view, view2);
        }
    }

    public void setBlankHeight(int i) {
        this.j.removeAllViews();
        this.k = new View(getContext());
        this.k.setLayoutParams(new AbsListView.LayoutParams(0, i));
        this.j.addView(this.k);
    }

    public void setCustomOnScrollChangeListener(b bVar) {
        this.f9854e = bVar;
    }

    public void setOnScrollChangeListener(b bVar) {
        this.f9853d = bVar;
    }

    public void setStatusHeight(int i, int i2) {
        this.l.setMinimumHeight(i);
        this.top = i;
        this.bottom = i2;
        this.f9852c = 3;
    }

    public void updateStatus(com.baidu.platform.comapi.wnplatform.n.b bVar, boolean z) {
        b bVar2 = this.f9853d;
        if (bVar2 != null) {
            bVar2.a(this.n, bVar);
        }
        b bVar3 = this.f9854e;
        if (bVar3 != null) {
            bVar3.a(this.n, bVar);
        }
        this.n = bVar;
        int i = f.f9876a[bVar.ordinal()];
        if (i == 1) {
            if (z) {
                smoothScrollTo(0, this.bottom);
            } else {
                scrollTo(0, this.bottom);
            }
        } else if (i != 2) {
        } else {
            if (z) {
                smoothScrollTo(0, this.top);
            } else {
                scrollTo(0, this.top);
            }
        }
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9857h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        initView(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9857h = 0;
        this.i = 0;
        this.m = false;
        this.n = com.baidu.platform.comapi.wnplatform.n.b.BOTTOM;
        initView(context);
    }
}
