package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class i extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static int f10206a = 600;

    /* renamed from: b  reason: collision with root package name */
    public Context f10207b;

    /* renamed from: c  reason: collision with root package name */
    public int f10208c;

    /* renamed from: d  reason: collision with root package name */
    public Scroller f10209d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10210e;

    /* renamed from: f  reason: collision with root package name */
    public int f10211f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a> f10212g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10213h;
    public int i;
    public boolean j;
    public com.baidu.platform.comapi.walknavi.g.a k;
    public int l;
    public float m;
    public VelocityTracker n;

    public void a(int i) {
        if (this.f10213h) {
            double k = com.baidu.platform.comapi.walknavi.segmentbrowse.c.k();
            double d2 = this.f10211f;
            Double.isNaN(d2);
            if (i == k * d2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f10213h = false;
                }
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.f10212g.remove(0);
                } else {
                    removeViews(0, 2);
                    this.f10212g.remove(0);
                    this.f10212g.remove(0);
                }
                a aVar = new a(this.f10207b, "", -1);
                aVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                a a2 = a(aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                addView(a2);
                this.f10212g.add(0, a2);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    a aVar2 = new a(this.f10207b, "", -1);
                    aVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    a a3 = a(aVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a3);
                    this.f10212g.add(a3);
                }
            }
            this.f10208c = i;
            a();
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("scroll", "computeScroll");
        if (this.f10209d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("scroll", this.f10209d.getCurrX() + "======" + this.f10209d.getCurrY());
            scrollTo(this.f10209d.getCurrX(), this.f10209d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("istime", "istime");
        if (this.f10210e) {
            this.f10210e = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f10212g.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
                this.f10212g.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
                return;
            }
            this.f10212g.get(0).layout(this.f10208c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10208c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar6 = this.f10212g.get(1);
            int i5 = this.f10208c;
            double l = com.baidu.platform.comapi.walknavi.segmentbrowse.c.l();
            double d2 = (double) this.f10211f;
            Double.isNaN(d2);
            aVar6.layout(i5 + 0, 0, i5 + 0 + ((int) (l * d2)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
            return;
        }
        this.f10212g.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
        this.f10212g.get(1).layout(this.f10208c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10208c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.f10212g.get(2);
            int i6 = this.f10208c;
            double l2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.l();
            double d3 = this.f10211f;
            Double.isNaN(d3);
            aVar7.layout(i6 + 0, 0, i6 + 0 + ((int) (l2 * d3)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 7**left=" + aVar7.getLeft() + "**right=" + aVar7.getRight());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a("backgroundview ontouch", "event" + motionEvent.getAction());
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            Scroller scroller = this.f10209d;
            if (scroller != null && !scroller.isFinished()) {
                this.f10209d.abortAnimation();
            }
            this.m = x;
        } else if (action == 1) {
            VelocityTracker velocityTracker = this.n;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (xVelocity > f10206a) {
                this.j = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                    this.j = false;
                }
                if (this.j) {
                    this.f10210e = true;
                    this.f10209d.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX(), 0, 1000);
                }
            } else if (xVelocity < 0) {
                com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background width" + this.f10208c);
                com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background getscrollx" + getScrollX());
                this.j = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.j = false;
                }
                if (this.j) {
                    this.f10210e = true;
                    this.f10209d.startScroll(getScrollX(), 0, this.f10208c - getScrollX(), 0, 500);
                }
            }
            VelocityTracker velocityTracker2 = this.n;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.n = null;
            }
            this.l = 0;
        } else if (action == 2) {
            int i = (int) (this.m - x);
            this.j = true;
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i < 0) {
                this.j = false;
            }
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i > 0) {
                this.j = false;
            }
            if (this.j) {
                scrollBy(1, 0);
                this.m = x;
            }
        } else if (action == 3) {
            this.l = 0;
        }
        return false;
    }

    private void a() {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f10212g.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
                this.f10212g.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
                return;
            }
            this.f10212g.get(0).layout(this.f10208c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10208c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar6 = this.f10212g.get(1);
            int i = this.f10208c;
            double l = com.baidu.platform.comapi.walknavi.segmentbrowse.c.l();
            double d2 = (double) this.f10211f;
            Double.isNaN(d2);
            aVar6.layout(i + 0, 0, i + 0 + ((int) (l * d2)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
            return;
        }
        this.f10212g.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
        this.f10212g.get(1).layout(this.f10208c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f10208c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.f10212g.get(2);
            int i2 = this.f10208c;
            double l2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.l();
            double d3 = this.f10211f;
            Double.isNaN(d3);
            aVar7.layout(i2 + 0, 0, i2 + 0 + ((int) (l2 * d3)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 7**left=" + aVar7.getLeft() + "**right=" + aVar7.getRight());
        }
    }

    @SuppressLint({"NewApi"})
    private a a(a aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar2) {
        if (aVar2 != null && this.k != null) {
            int d2 = aVar2.d();
            if (d2 < 0 || d2 >= 30) {
                if (d2 >= 30 && d2 < 150) {
                    if (this.k.f10056b != null) {
                        aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f10056b));
                    }
                } else if (d2 >= 150 && this.k.f10057c != null) {
                    aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f10057c));
                }
            } else if (this.k.f10055a != null) {
                aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f10055a));
            }
        }
        return aVar;
    }
}
