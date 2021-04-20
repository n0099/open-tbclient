package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static int f9757a = 600;

    /* renamed from: b  reason: collision with root package name */
    public Context f9758b;

    /* renamed from: c  reason: collision with root package name */
    public int f9759c;

    /* renamed from: d  reason: collision with root package name */
    public Scroller f9760d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9761e;

    /* renamed from: f  reason: collision with root package name */
    public a f9762f;

    /* renamed from: g  reason: collision with root package name */
    public int f9763g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f9764h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public float o;
    public VelocityTracker p;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    public void a(int i) {
        if (this.k) {
            if (i == com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.f9763g) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.k = false;
                }
                this.f9761e = false;
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.f9764h.remove(0);
                } else {
                    removeViews(0, 2);
                    this.f9764h.remove(0);
                    this.f9764h.remove(0);
                }
                d dVar = new d(this.f9758b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()), this.f9759c);
                dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                addView(dVar);
                this.f9764h.add(0, dVar);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    d dVar2 = new d(this.f9758b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), this.f9759c);
                    dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    addView(dVar2);
                    this.f9764h.add(dVar2);
                }
            }
            if (i <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f9763g))) {
                this.f9761e = true;
            }
            this.f9759c = i;
            f.a().a(this.f9759c);
            a();
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "computeScroll--->" + this.f9760d.computeScrollOffset());
        if (this.f9760d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", this.f9760d.getCurrX() + "======" + this.f9760d.getCurrY());
            scrollTo(this.f9760d.getCurrX(), this.f9760d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "istime:isGoToNext:" + this.i + "isGoToLast:" + this.j);
        if (this.i) {
            this.i = false;
            this.f9762f.a(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
        }
        if (this.j) {
            this.j = false;
            this.f9762f.a("last");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.f9761e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.f9764h.get(1).layout(0, 0, this.f9759c, this.l);
                    return;
                }
                if (this.f9759c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.f9764h.get(0).layout(0, 0, this.f9759c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f9759c);
                    this.f9764h.get(0).layout(0, 0, this.f9759c + 0, this.l);
                }
                int i5 = this.f9759c;
                this.f9764h.get(1).layout(i5 + 0, 0, i5 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)), this.l);
                return;
            }
            this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.f9759c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.f9764h.get(1).layout(0, 0, this.f9759c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f9759c);
                this.f9764h.get(1).layout(0, 0, this.f9759c + 0, this.l);
            }
            int i6 = this.f9759c;
            this.f9764h.get(2).layout(i6 + 0, 0, i6 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.f9759c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.f9764h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.f9764h.get(0).layout(this.f9759c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f9763g)), 0, this.f9759c, this.l);
            int i7 = this.f9759c;
            this.f9764h.get(1).layout(i7, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)) + i7, this.l);
            return;
        }
        this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.f9764h.get(1).layout(this.f9759c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f9763g)), 0, this.f9759c, this.l);
        int i8 = this.f9759c;
        this.f9764h.get(2).layout(i8, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)) + i8, this.l);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            Scroller scroller = this.f9760d;
            if (scroller != null && !scroller.isFinished()) {
                this.f9760d.abortAnimation();
            }
            this.o = x;
        } else if (action == 1) {
            VelocityTracker velocityTracker = this.p;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (xVelocity > f9757a) {
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.f9759c);
                this.m = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                    this.m = false;
                }
                if (this.m) {
                    this.j = true;
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent up startScroll---------------");
                    this.f9760d.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX(), 0, 1000);
                    invalidate();
                }
            } else if (xVelocity < 0) {
                this.m = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.m = false;
                }
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.f9759c);
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent getscrollx" + getScrollX());
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent isNeedMove" + this.m);
                if (this.m) {
                    this.i = true;
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent down startScroll---------------");
                    this.f9760d.startScroll(getScrollX(), 0, this.f9759c - getScrollX(), 0, 500);
                    invalidate();
                }
            }
            VelocityTracker velocityTracker2 = this.p;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.p = null;
            }
            this.n = 0;
        } else if (action == 2) {
            int i = (int) (this.o - x);
            this.m = true;
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i < 0) {
                this.m = false;
            }
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i > 0) {
                this.m = false;
            }
            if (this.m) {
                scrollBy(1, 0);
                this.o = x;
            }
        } else if (action == 3) {
            this.n = 0;
        }
        return false;
    }

    private void a() {
        if (!this.f9761e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.f9764h.get(1).layout(0, 0, this.f9759c, this.l);
                    return;
                }
                if (this.f9759c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.f9764h.get(0).layout(0, 0, this.f9759c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f9759c);
                    this.f9764h.get(0).layout(0, 0, this.f9759c + 0, this.l);
                }
                int i = this.f9759c;
                this.f9764h.get(1).layout(i + 0, 0, i + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)), this.l);
                return;
            }
            this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.f9759c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.f9764h.get(1).layout(0, 0, this.f9759c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f9759c);
                this.f9764h.get(1).layout(0, 0, this.f9759c + 0, this.l);
            }
            int i2 = this.f9759c;
            this.f9764h.get(2).layout(i2 + 0, 0, i2 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.f9759c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.f9764h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.f9764h.get(0).layout(this.f9759c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f9763g)), 0, this.f9759c, this.l);
            int i3 = this.f9759c;
            this.f9764h.get(1).layout(i3, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)) + i3, this.l);
            return;
        }
        this.f9764h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.f9764h.get(1).layout(this.f9759c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f9763g)), 0, this.f9759c, this.l);
        int i4 = this.f9759c;
        this.f9764h.get(2).layout(i4, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f9763g)) + i4, this.l);
    }
}
