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
    public static int f10190a = 20;

    /* renamed from: c  reason: collision with root package name */
    public static String f10191c = "MultiViewGroup";

    /* renamed from: b  reason: collision with root package name */
    public Context f10192b;

    /* renamed from: d  reason: collision with root package name */
    public int f10193d;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f10194e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<View> f10195f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<Integer> f10196g;

    /* renamed from: h  reason: collision with root package name */
    public int f10197h;
    public int i;
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
        this.f10193d = 0;
        this.f10194e = null;
        this.f10195f = new ArrayList<>();
        this.f10196g = new ArrayList<>();
        this.f10197h = 60;
        this.i = 0;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = null;
        this.r = 0;
        this.f10192b = context;
        this.l = aVar;
        a();
    }

    public void a(int i) {
        int n;
        int scrollX;
        boolean z = this.f10193d != i;
        int i2 = this.f10193d;
        boolean z2 = this.f10193d <= i;
        this.f10193d = i;
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "curscreen" + this.f10193d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.f10193d);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(this.f10193d);
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        if (z) {
            if (z2) {
                if (this.f10193d == 1) {
                    d dVar = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10193d + 1), -1);
                    dVar.setTag(Integer.valueOf(this.f10193d + 1));
                    d a2 = a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a2);
                    this.f10195f.add(a2);
                }
                if (this.f10193d >= 2) {
                    this.i += com.baidu.platform.comapi.walknavi.segmentbrowse.c.m();
                    removeView(this.f10195f.get(0));
                    this.f10195f.remove(0);
                    com.baidu.platform.comapi.wnplatform.d.a.a("curscreen", "curscreen" + this.f10193d);
                    if (this.f10193d < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                        d dVar2 = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10193d + 1), -1);
                        dVar2.setTag(Integer.valueOf(this.f10193d + 1));
                        d a3 = a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                        addView(a3);
                        this.f10195f.add(a3);
                    }
                }
            } else {
                if (this.f10193d >= 1) {
                    this.i -= com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                    if (getChildCount() == 3) {
                        removeView(this.f10195f.get(2));
                        this.f10195f.remove(2);
                        d dVar3 = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10193d - 1), -1);
                        dVar3.setTag(Integer.valueOf(this.f10193d - 1));
                        d a4 = a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a4);
                        this.f10195f.add(0, a4);
                    } else if (getChildCount() == 2) {
                        d dVar4 = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(this.f10193d - 1), -1);
                        dVar4.setTag(Integer.valueOf(this.f10193d - 1));
                        d a5 = a(dVar4, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                        addView(a5);
                        this.f10195f.add(0, a5);
                    }
                }
                if (this.f10193d == 0 && getChildCount() == 3) {
                    removeView(this.f10195f.get(2));
                    this.f10195f.remove(2);
                }
            }
        }
        if (z) {
            if (z2) {
                n = this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                scrollX = getScrollX();
            } else if (this.f10193d == 0) {
                n = this.i;
                scrollX = getScrollX();
            } else {
                n = this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
                scrollX = getScrollX();
            }
            int i3 = n - scrollX;
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "dx******************" + i3);
            this.f10194e.startScroll(getScrollX(), 0, i3, 0, Math.abs(i3));
            this.j = false;
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "computeScroll");
        if (this.f10194e.computeScrollOffset()) {
            String str = f10191c;
            com.baidu.platform.comapi.wnplatform.d.a.a(str, this.f10194e.getCurrX() + "======" + this.f10194e.getCurrY());
            scrollTo(this.f10194e.getCurrX(), this.f10194e.getCurrY());
            String str2 = f10191c;
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
        String str = f10191c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "onInterceptTouchEvent-slop:" + this.n);
        int action = motionEvent.getAction();
        if (action != 2 || this.m == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "onInterceptTouchEvent move");
                        if (((int) Math.abs(this.o - x)) > this.n) {
                            this.m = 1;
                        }
                    }
                }
                com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "onInterceptTouchEvent up or cancel");
                this.m = 0;
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "onInterceptTouchEvent down");
                this.o = x;
                this.p = y;
                String str2 = f10191c;
                com.baidu.platform.comapi.wnplatform.d.a.a(str2, this.f10194e.isFinished() + "");
                this.m = this.f10194e.isFinished() ^ 1;
            }
            String str3 = f10191c;
            com.baidu.platform.comapi.wnplatform.d.a.a(str3, this.m + "====0");
            return this.m != 0;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "--- start onLayout --");
        com.baidu.platform.comapi.wnplatform.d.a.a("view count onlayout", getChildCount() + "child count");
        int childCount = getChildCount();
        String str = f10191c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "--- onLayout childCount is -->" + childCount);
        if (childCount == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                View view = this.f10195f.get(0);
                if (view.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                    int i5 = this.i;
                    view.layout(i5, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + i5, this.k + 0);
                }
                View view2 = this.f10195f.get(1);
                if (view2.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    view2.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
                }
            } else {
                View view3 = this.f10195f.get(0);
                if (view3.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() != -1) {
                    int i6 = this.i;
                    view3.layout(i6, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + i6, this.k + 0);
                }
                View view4 = this.f10195f.get(1);
                if (view4.getVisibility() != 8) {
                    view4.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
                }
            }
        }
        if (childCount == 3) {
            View view5 = this.f10195f.get(0);
            if (view5.getVisibility() != 8 && com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() != -1) {
                int i7 = this.i;
                view5.layout(i7, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + i7, this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "0**" + view5.getLeft() + "**" + view5.getRight());
            View view6 = this.f10195f.get(1);
            if (view6.getVisibility() != 8) {
                view6.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "1**" + view6.getLeft() + "**" + view6.getRight());
            View view7 = this.f10195f.get(2);
            if (view7.getVisibility() != 8) {
                view7.layout(this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.i + com.baidu.platform.comapi.walknavi.segmentbrowse.c.n() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + com.baidu.platform.comapi.walknavi.segmentbrowse.c.p(), this.k + 0);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "2**" + view7.getLeft() + "**" + view7.getRight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "--- start onMeasure --");
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int childCount = getChildCount();
        String str = f10191c;
        com.baidu.platform.comapi.wnplatform.d.a.a(str, "--- onMeasure childCount is -->" + childCount);
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(getWidth(), 200);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "--- onTouchEvent--> ");
        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "onTouchEvent start");
        if (this.q == null) {
            com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "onTouchEvent start-------** VelocityTracker.obtain");
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
                    String str = f10191c;
                    com.baidu.platform.comapi.wnplatform.d.a.a(str, "---velocityX---" + xVelocity);
                    int i = f10190a;
                    if (xVelocity > i) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "snap left");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是起点，不能左滑");
                        } else {
                            a(this.f10193d - 1);
                        }
                    } else if (xVelocity < (-i)) {
                        com.baidu.platform.comapi.wnplatform.d.a.a(f10191c, "snap right");
                        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                            com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "该点是终点，不能右滑");
                        } else {
                            a(this.f10193d + 1);
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
                int i2 = (int) (this.o - x);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i2 < 0) {
                    z = false;
                }
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i2 > 0) {
                    z = false;
                }
                if (z) {
                    String str2 = f10191c;
                    com.baidu.platform.comapi.wnplatform.d.a.a(str2, "--- MotionEvent.ACTION_MOVE--> detaX is " + i2);
                    this.o = x;
                }
            }
        } else if (this.j) {
            Scroller scroller = this.f10194e;
            if (scroller != null && !scroller.isFinished()) {
                this.f10194e.abortAnimation();
            }
            this.o = x;
        }
        return false;
    }

    private void a() {
        com.baidu.platform.comapi.walknavi.b.a().Q().l();
        this.f10194e = new Scroller(this.f10192b);
        this.k = b.a(this.f10192b, 95.0f);
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != 0) {
            d dVar = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1), -1);
            dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() - 1));
            this.f10195f.add(a(dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e()));
            this.i = 0 - com.baidu.platform.comapi.walknavi.segmentbrowse.c.n();
            this.f10193d = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
        }
        d dVar2 = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()), -1);
        dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a()));
        this.f10195f.add(a(dVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d()));
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            d dVar3 = new d(this.f10192b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1), -1);
            dVar3.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() + 1));
            this.f10195f.add(a(dVar3, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f()));
        }
        for (int i = 0; i < this.f10195f.size(); i++) {
            addView(this.f10195f.get(i));
        }
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private d a(d dVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar) {
        if (aVar != null && this.l != null) {
            int d2 = aVar.d();
            if (d2 < 0 || d2 >= 30) {
                if (d2 >= 30 && d2 < 150) {
                    if (this.l.f10056b != null) {
                        dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f10056b));
                    }
                } else if (d2 >= 150 && this.l.f10057c != null) {
                    dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f10057c));
                }
            } else if (this.l.f10055a != null) {
                dVar.setBackgroundDrawable(new BitmapDrawable(this.l.f10055a));
            }
        }
        return dVar;
    }
}
