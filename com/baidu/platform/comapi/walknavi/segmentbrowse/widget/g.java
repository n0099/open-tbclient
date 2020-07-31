package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class g extends ViewGroup {
    private Context b;
    private int d;
    private Scroller e;
    private ArrayList<View> f;
    private ArrayList<Integer> g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private com.baidu.platform.comapi.walknavi.g.a l;
    private int m;
    private int n;
    private float o;
    private float p;
    private VelocityTracker q;
    private int r;
    private static String c = "MultiViewGroup";
    public static int a = 20;

    public g(Context context, com.baidu.platform.comapi.walknavi.g.a aVar) {
        super(context);
        this.d = 0;
        this.e = null;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = 60;
        this.i = 0;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = null;
        this.r = 0;
        this.b = context;
        this.l = aVar;
        a();
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "computeScroll");
        if (this.e.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a(c, this.e.getCurrX() + "======" + this.e.getCurrY());
            scrollTo(this.e.getCurrX(), this.e.getCurrY());
            com.baidu.platform.comapi.wnplatform.d.a.a(c, "### getleft is " + getLeft() + " ### getRight is " + getRight());
            postInvalidate();
            return;
        }
        this.j = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "onInterceptTouchEvent-slop:" + this.n);
        int action = motionEvent.getAction();
        if (action != 2 || this.m == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (action) {
                case 0:
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, "onInterceptTouchEvent down");
                    this.o = x;
                    this.p = y;
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, this.e.isFinished() + "");
                    this.m = this.e.isFinished() ? 0 : 1;
                    break;
                case 1:
                case 3:
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, "onInterceptTouchEvent up or cancel");
                    this.m = 0;
                    break;
                case 2:
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, "onInterceptTouchEvent move");
                    if (((int) Math.abs(this.o - x)) > this.n) {
                        this.m = 1;
                        break;
                    }
                    break;
            }
            com.baidu.platform.comapi.wnplatform.d.a.a(c, this.m + "====0");
            return this.m != 0;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onTouchEvent--> ");
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "onTouchEvent start");
        if (this.q == null) {
            com.baidu.platform.comapi.wnplatform.d.a.a(c, "onTouchEvent start-------** VelocityTracker.obtain");
            this.q = VelocityTracker.obtain();
        }
        this.q.addMovement(motionEvent);
        super.onTouchEvent(motionEvent);
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.j) {
                    if (this.e != null && !this.e.isFinished()) {
                        this.e.abortAnimation();
                    }
                    this.o = x;
                    break;
                }
                break;
            case 1:
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING) {
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.segment");
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
                    com.baidu.platform.comapi.walknavi.b.a().D().k();
                    com.baidu.platform.comapi.walknavi.b.a().F().run("强诱导转到分段");
                }
                if (this.j) {
                    VelocityTracker velocityTracker = this.q;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    com.baidu.platform.comapi.wnplatform.d.a.a(c, "---velocityX---" + xVelocity);
                    if (xVelocity > a) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "snap left");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是起点，不能左滑");
                        } else {
                            a(this.d - 1);
                        }
                    } else if (xVelocity < (-a)) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "snap right");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是终点，不能右滑");
                        } else {
                            a(this.d + 1);
                        }
                    }
                    if (this.q != null) {
                        this.q.recycle();
                        this.q = null;
                    }
                    this.m = 0;
                    break;
                }
                break;
            case 2:
                if (this.j) {
                    int i = (int) (this.o - x);
                    boolean z = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i < 0) {
                        z = false;
                    }
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i > 0) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- MotionEvent.ACTION_MOVE--> detaX is " + i);
                        this.o = x;
                        break;
                    }
                }
                break;
            case 3:
                this.m = 0;
                break;
        }
        return false;
    }

    public void a(int i) {
        int n;
        boolean z = this.d != i;
        if (this.d < i) {
        }
        boolean z2 = this.d <= i;
        this.d = i;
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "curscreen" + this.d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(this.d);
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        if (z) {
            if (z2) {
                if (this.d == 1) {
                    d dVar = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.d + 1), -1);
                    dVar.setTag(Integer.valueOf(this.d + 1));
                    d a2 = a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a2);
                    this.f.add(a2);
                }
                if (this.d >= 2) {
                    this.i += com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                    removeView(this.f.get(0));
                    this.f.remove(0);
                    com.baidu.platform.comapi.wnplatform.d.a.a("curscreen", "curscreen" + this.d);
                    if (this.d < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                        d dVar2 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.d + 1), -1);
                        dVar2.setTag(Integer.valueOf(this.d + 1));
                        d a3 = a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                        addView(a3);
                        this.f.add(a3);
                    }
                }
            } else {
                if (this.d >= 1) {
                    this.i -= com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                    if (getChildCount() == 3) {
                        removeView(this.f.get(2));
                        this.f.remove(2);
                        d dVar3 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.d - 1), -1);
                        dVar3.setTag(Integer.valueOf(this.d - 1));
                        d a4 = a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a4);
                        this.f.add(0, a4);
                    } else if (getChildCount() == 2) {
                        d dVar4 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.d - 1), -1);
                        dVar4.setTag(Integer.valueOf(this.d - 1));
                        d a5 = a(dVar4, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a5);
                        this.f.add(0, a5);
                    }
                }
                if (this.d == 0 && getChildCount() == 3) {
                    removeView(this.f.get(2));
                    this.f.remove(2);
                }
            }
        }
        if (z) {
            if (z2) {
                n = (this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX();
            } else if (this.d == 0) {
                n = this.i - getScrollX();
            } else {
                n = (this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX();
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "dx******************" + n);
            this.e.startScroll(getScrollX(), 0, n, 0, Math.abs(n));
            this.j = false;
        }
        invalidate();
    }

    private void a() {
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        this.e = new Scroller(this.b);
        this.k = b.a(this.b, 95.0f);
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != 0) {
            d dVar = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1), -1);
            dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1));
            this.f.add(a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e()));
            this.i = 0 - com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
            this.d = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
        }
        d dVar2 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()), -1);
        dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()));
        this.f.add(a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d()));
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            d dVar3 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1), -1);
            dVar3.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1));
            this.f.add(a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()));
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.size()) {
                addView(this.f.get(i2));
                i = i2 + 1;
            } else {
                this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- start onMeasure --");
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int childCount = getChildCount();
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onMeasure childCount is -->" + childCount);
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(getWidth(), 200);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- start onLayout --");
        com.baidu.platform.comapi.wnplatform.d.a.a("view count onlayout", getChildCount() + "child count");
        int childCount = getChildCount();
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "--- onLayout childCount is -->" + childCount);
        if (childCount == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                View view = this.f.get(0);
                if (view.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                    view.layout(this.i, 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), this.k + 0);
                }
                View view2 = this.f.get(1);
                if (view2.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    view2.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
                }
            } else {
                View view3 = this.f.get(0);
                if (view3.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    view3.layout(this.i, 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
                }
                View view4 = this.f.get(1);
                if (view4.getVisibility() != 8) {
                    view4.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
                }
            }
        }
        if (childCount == 3) {
            View view5 = this.f.get(0);
            if (view5.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                view5.layout(this.i, 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "0**" + view5.getLeft() + "**" + view5.getRight());
            View view6 = this.f.get(1);
            if (view6.getVisibility() != 8) {
                view6.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "1**" + view6.getLeft() + "**" + view6.getRight());
            View view7 = this.f.get(2);
            if (view7.getVisibility() != 8) {
                view7.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "2**" + view7.getLeft() + "**" + view7.getRight());
        }
    }

    private d a(d dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar != null && this.l != null) {
            int d = aVar.d();
            if (d >= 0 && d < 30) {
                if (this.l.a != null) {
                    dVar.setBackgroundDrawable(new BitmapDrawable(this.l.a));
                }
            } else if (d >= 30 && d < 150) {
                if (this.l.b != null) {
                    dVar.setBackgroundDrawable(new BitmapDrawable(this.l.b));
                }
            } else if (d >= 150 && this.l.c != null) {
                dVar.setBackgroundDrawable(new BitmapDrawable(this.l.c));
            }
        }
        return dVar;
    }
}
