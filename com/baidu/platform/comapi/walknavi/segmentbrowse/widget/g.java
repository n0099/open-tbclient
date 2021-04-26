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
/* loaded from: classes2.dex */
public class g extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static int f10109a = 20;

    /* renamed from: c  reason: collision with root package name */
    public static String f10110c = "MultiViewGroup";

    /* renamed from: b  reason: collision with root package name */
    public Context f10111b;

    /* renamed from: d  reason: collision with root package name */
    public int f10112d;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f10113e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<View> f10114f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<Integer> f10115g;

    /* renamed from: h  reason: collision with root package name */
    public int f10116h;

    /* renamed from: i  reason: collision with root package name */
    public int f10117i;
    public boolean j;
    public int k;
    public com.baidu.platform.comapi.walknavi.g.a l;
    public int m;
    public int n;
    public float o;
    public float p;
    public VelocityTracker q;
    public int r;

    public g(Context context, com.baidu.platform.comapi.walknavi.g.a aVar) {
        super(context);
        this.f10112d = 0;
        this.f10113e = null;
        this.f10114f = new ArrayList<>();
        this.f10115g = new ArrayList<>();
        this.f10116h = 60;
        this.f10117i = 0;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = null;
        this.r = 0;
        this.f10111b = context;
        this.l = aVar;
        a();
    }

    public void a(int i2) {
        int n;
        int scrollX;
        boolean z = this.f10112d != i2;
        int i3 = this.f10112d;
        boolean z2 = this.f10112d <= i2;
        this.f10112d = i2;
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "curscreen" + this.f10112d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.f10112d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(this.f10112d);
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        if (z) {
            if (z2) {
                if (this.f10112d == 1) {
                    d dVar = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10112d + 1), -1);
                    dVar.setTag(Integer.valueOf(this.f10112d + 1));
                    d a2 = a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a2);
                    this.f10114f.add(a2);
                }
                if (this.f10112d >= 2) {
                    this.f10117i += com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                    removeView(this.f10114f.get(0));
                    this.f10114f.remove(0);
                    com.baidu.platform.comapi.wnplatform.d.a.a("curscreen", "curscreen" + this.f10112d);
                    if (this.f10112d < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                        d dVar2 = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10112d + 1), -1);
                        dVar2.setTag(Integer.valueOf(this.f10112d + 1));
                        d a3 = a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                        addView(a3);
                        this.f10114f.add(a3);
                    }
                }
            } else {
                if (this.f10112d >= 1) {
                    this.f10117i -= com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                    if (getChildCount() == 3) {
                        removeView(this.f10114f.get(2));
                        this.f10114f.remove(2);
                        d dVar3 = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10112d - 1), -1);
                        dVar3.setTag(Integer.valueOf(this.f10112d - 1));
                        d a4 = a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a4);
                        this.f10114f.add(0, a4);
                    } else if (getChildCount() == 2) {
                        d dVar4 = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10112d - 1), -1);
                        dVar4.setTag(Integer.valueOf(this.f10112d - 1));
                        d a5 = a(dVar4, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a5);
                        this.f10114f.add(0, a5);
                    }
                }
                if (this.f10112d == 0 && getChildCount() == 3) {
                    removeView(this.f10114f.get(2));
                    this.f10114f.remove(2);
                }
            }
        }
        if (z) {
            if (z2) {
                n = this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                scrollX = getScrollX();
            } else if (this.f10112d == 0) {
                n = this.f10117i;
                scrollX = getScrollX();
            } else {
                n = this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                scrollX = getScrollX();
            }
            int i4 = n - scrollX;
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "dx******************" + i4);
            this.f10113e.startScroll(getScrollX(), 0, i4, 0, Math.abs(i4));
            this.j = false;
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "computeScroll");
        if (this.f10113e.computeScrollOffset()) {
            String str = f10110c;
            com.baidu.platform.comapi.wnplatform.d.a.a(str, this.f10113e.getCurrX() + "======" + this.f10113e.getCurrY());
            scrollTo(this.f10113e.getCurrX(), this.f10113e.getCurrY());
            String str2 = f10110c;
            com.baidu.platform.comapi.wnplatform.d.a.a(str2, "### getleft is " + getLeft() + " ### getRight is " + getRight());
            postInvalidate();
            return;
        }
        this.j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        String str = f10110c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "onInterceptTouchEvent-slop:" + this.n);
        int action = motionEvent.getAction();
        if (action != 2 || this.m == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "onInterceptTouchEvent move");
                        if (((int) Math.abs(this.o - x)) > this.n) {
                            this.m = 1;
                        }
                    }
                }
                com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "onInterceptTouchEvent up or cancel");
                this.m = 0;
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "onInterceptTouchEvent down");
                this.o = x;
                this.p = y;
                String str2 = f10110c;
                com.baidu.platform.comapi.wnplatform.d.a.a(str2, this.f10113e.isFinished() + "");
                this.m = this.f10113e.isFinished() ^ 1;
            }
            String str3 = f10110c;
            com.baidu.platform.comapi.wnplatform.d.a.a(str3, this.m + "====0");
            return this.m != 0;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "--- start onLayout --");
        com.baidu.platform.comapi.wnplatform.d.a.a("view count onlayout", getChildCount() + "child count");
        int childCount = getChildCount();
        String str = f10110c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "--- onLayout childCount is -->" + childCount);
        if (childCount == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                View view = this.f10114f.get(0);
                if (view.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                    int i6 = this.f10117i;
                    view.layout(i6, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + i6, this.k + 0);
                }
                View view2 = this.f10114f.get(1);
                if (view2.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    view2.layout(this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
                }
            } else {
                View view3 = this.f10114f.get(0);
                if (view3.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    int i7 = this.f10117i;
                    view3.layout(i7, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + i7, this.k + 0);
                }
                View view4 = this.f10114f.get(1);
                if (view4.getVisibility() != 8) {
                    view4.layout(this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
                }
            }
        }
        if (childCount == 3) {
            View view5 = this.f10114f.get(0);
            if (view5.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                int i8 = this.f10117i;
                view5.layout(i8, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + i8, this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "0**" + view5.getLeft() + "**" + view5.getRight());
            View view6 = this.f10114f.get(1);
            if (view6.getVisibility() != 8) {
                view6.layout(this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "1**" + view6.getLeft() + "**" + view6.getRight());
            View view7 = this.f10114f.get(2);
            if (view7.getVisibility() != 8) {
                view7.layout(this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10117i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "2**" + view7.getLeft() + "**" + view7.getRight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "--- start onMeasure --");
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        int childCount = getChildCount();
        String str = f10110c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "--- onMeasure childCount is -->" + childCount);
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(getWidth(), 200);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "--- onTouchEvent--> ");
        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "onTouchEvent start");
        if (this.q == null) {
            com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "onTouchEvent start-------** VelocityTracker.obtain");
            this.q = VelocityTracker.obtain();
        }
        this.q.addMovement(motionEvent);
        super.onTouchEvent(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = true;
            if (action == 1) {
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
                    String str = f10110c;
                    com.baidu.platform.comapi.wnplatform.d.a.a(str, "---velocityX---" + xVelocity);
                    int i2 = f10109a;
                    if (xVelocity > i2) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "snap left");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是起点，不能左滑");
                        } else {
                            a(this.f10112d - 1);
                        }
                    } else if (xVelocity < (-i2)) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10110c, "snap right");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是终点，不能右滑");
                        } else {
                            a(this.f10112d + 1);
                        }
                    }
                    VelocityTracker velocityTracker2 = this.q;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.q = null;
                    }
                    this.m = 0;
                }
            } else if (action != 2) {
                if (action == 3) {
                    this.m = 0;
                }
            } else if (this.j) {
                int i3 = (int) (this.o - x);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i3 < 0) {
                    z = false;
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i3 > 0) {
                    z = false;
                }
                if (z) {
                    String str2 = f10110c;
                    com.baidu.platform.comapi.wnplatform.d.a.a(str2, "--- MotionEvent.ACTION_MOVE--> detaX is " + i3);
                    this.o = x;
                }
            }
        } else if (this.j) {
            Scroller scroller = this.f10113e;
            if (scroller != null && !scroller.isFinished()) {
                this.f10113e.abortAnimation();
            }
            this.o = x;
        }
        return false;
    }

    private void a() {
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        this.f10113e = new Scroller(this.f10111b);
        this.k = b.a(this.f10111b, 95.0f);
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != 0) {
            d dVar = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1), -1);
            dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1));
            this.f10114f.add(a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e()));
            this.f10117i = 0 - com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
            this.f10112d = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
        }
        d dVar2 = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()), -1);
        dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()));
        this.f10114f.add(a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d()));
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            d dVar3 = new d(this.f10111b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1), -1);
            dVar3.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1));
            this.f10114f.add(a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()));
        }
        for (int i2 = 0; i2 < this.f10114f.size(); i2++) {
            addView(this.f10114f.get(i2));
        }
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private d a(d dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar != null && this.l != null) {
            int d2 = aVar.d();
            if (d2 < 0 || d2 >= 30) {
                if (d2 >= 30 && d2 < 150) {
                    if (this.l.f9973b != null) {
                        dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f9973b));
                    }
                } else if (d2 >= 150 && this.l.f9974c != null) {
                    dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f9974c));
                }
            } else if (this.l.f9972a != null) {
                dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f9972a));
            }
        }
        return dVar;
    }
}
