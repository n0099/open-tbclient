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
    public static int f9765a = 600;

    /* renamed from: b  reason: collision with root package name */
    public Context f9766b;

    /* renamed from: c  reason: collision with root package name */
    public int f9767c;

    /* renamed from: d  reason: collision with root package name */
    public Scroller f9768d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9769e;

    /* renamed from: f  reason: collision with root package name */
    public int f9770f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a> f9771g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9772h;
    public int i;
    public boolean j;
    public com.baidu.platform.comapi.walknavi.g.a k;
    public int l;
    public float m;
    public VelocityTracker n;

    public void a(int i) {
        if (this.f9772h) {
            if (i == com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.f9770f) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f9772h = false;
                }
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.f9771g.remove(0);
                } else {
                    removeViews(0, 2);
                    this.f9771g.remove(0);
                    this.f9771g.remove(0);
                }
                a aVar = new a(this.f9766b, "", -1);
                aVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                a a2 = a(aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                addView(a2);
                this.f9771g.add(0, a2);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    a aVar2 = new a(this.f9766b, "", -1);
                    aVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    a a3 = a(aVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a3);
                    this.f9771g.add(a3);
                }
            }
            this.f9767c = i;
            a();
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("scroll", "computeScroll");
        if (this.f9768d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("scroll", this.f9768d.getCurrX() + "======" + this.f9768d.getCurrY());
            scrollTo(this.f9768d.getCurrX(), this.f9768d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("istime", "istime");
        if (this.f9769e) {
            this.f9769e = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                a aVar = this.f9771g.get(0);
                aVar.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
                a aVar2 = this.f9771g.get(1);
                aVar2.layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
                return;
            }
            a aVar3 = this.f9771g.get(0);
            aVar3.layout(this.f9767c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f9767c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar4 = this.f9771g.get(1);
            int i5 = this.f9767c;
            aVar4.layout(i5 + 0, 0, i5 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * ((double) this.f9770f))), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
            return;
        }
        a aVar5 = this.f9771g.get(0);
        aVar5.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
        a aVar6 = this.f9771g.get(1);
        aVar6.layout(this.f9767c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f9767c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.f9771g.get(2);
            int i6 = this.f9767c;
            aVar7.layout(i6 + 0, 0, i6 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9770f)), this.i);
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
            Scroller scroller = this.f9768d;
            if (scroller != null && !scroller.isFinished()) {
                this.f9768d.abortAnimation();
            }
            this.m = x;
        } else if (action == 1) {
            VelocityTracker velocityTracker = this.n;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (xVelocity > f9765a) {
                this.j = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                    this.j = false;
                }
                if (this.j) {
                    this.f9769e = true;
                    this.f9768d.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX(), 0, 1000);
                }
            } else if (xVelocity < 0) {
                com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background width" + this.f9767c);
                com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background getscrollx" + getScrollX());
                this.j = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.j = false;
                }
                if (this.j) {
                    this.f9769e = true;
                    this.f9768d.startScroll(getScrollX(), 0, this.f9767c - getScrollX(), 0, 500);
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
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                a aVar = this.f9771g.get(0);
                aVar.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
                a aVar2 = this.f9771g.get(1);
                aVar2.layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
                return;
            }
            a aVar3 = this.f9771g.get(0);
            aVar3.layout(this.f9767c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f9767c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar4 = this.f9771g.get(1);
            int i = this.f9767c;
            aVar4.layout(i + 0, 0, i + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * ((double) this.f9770f))), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
            return;
        }
        a aVar5 = this.f9771g.get(0);
        aVar5.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
        a aVar6 = this.f9771g.get(1);
        aVar6.layout(this.f9767c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.f9767c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.f9771g.get(2);
            int i2 = this.f9767c;
            aVar7.layout(i2 + 0, 0, i2 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9770f)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 7**left=" + aVar7.getLeft() + "**right=" + aVar7.getRight());
        }
    }

    @SuppressLint({"NewApi"})
    private a a(a aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar2) {
        if (aVar2 != null && this.k != null) {
            int d2 = aVar2.d();
            if (d2 < 0 || d2 >= 30) {
                if (d2 >= 30 && d2 < 150) {
                    if (this.k.f9615b != null) {
                        aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f9615b));
                    }
                } else if (d2 >= 150 && this.k.f9616c != null) {
                    aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f9616c));
                }
            } else if (this.k.f9614a != null) {
                aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f9614a));
            }
        }
        return aVar;
    }
}
