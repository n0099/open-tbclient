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
    public static int f10118a = 600;

    /* renamed from: b  reason: collision with root package name */
    public Context f10119b;

    /* renamed from: c  reason: collision with root package name */
    public int f10120c;

    /* renamed from: d  reason: collision with root package name */
    public Scroller f10121d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10122e;

    /* renamed from: f  reason: collision with root package name */
    public a f10123f;

    /* renamed from: g  reason: collision with root package name */
    public int f10124g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f10125h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10126i;
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

    public void a(int i2) {
        if (this.k) {
            if (i2 == com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.f10124g) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.k = false;
                }
                this.f10122e = false;
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.f10125h.remove(0);
                } else {
                    removeViews(0, 2);
                    this.f10125h.remove(0);
                    this.f10125h.remove(0);
                }
                d dVar = new d(this.f10119b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()), this.f10120c);
                dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                addView(dVar);
                this.f10125h.add(0, dVar);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    d dVar2 = new d(this.f10119b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), this.f10120c);
                    dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    addView(dVar2);
                    this.f10125h.add(dVar2);
                }
            }
            if (i2 <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f10124g))) {
                this.f10122e = true;
            }
            this.f10120c = i2;
            f.a().a(this.f10120c);
            a();
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "computeScroll--->" + this.f10121d.computeScrollOffset());
        if (this.f10121d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", this.f10121d.getCurrX() + "======" + this.f10121d.getCurrY());
            scrollTo(this.f10121d.getCurrX(), this.f10121d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "istime:isGoToNext:" + this.f10126i + "isGoToLast:" + this.j);
        if (this.f10126i) {
            this.f10126i = false;
            this.f10123f.a(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
        }
        if (this.j) {
            this.j = false;
            this.f10123f.a("last");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (!this.f10122e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.f10125h.get(1).layout(0, 0, this.f10120c, this.l);
                    return;
                }
                if (this.f10120c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.f10125h.get(0).layout(0, 0, this.f10120c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f10120c);
                    this.f10125h.get(0).layout(0, 0, this.f10120c + 0, this.l);
                }
                int i6 = this.f10120c;
                this.f10125h.get(1).layout(i6 + 0, 0, i6 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)), this.l);
                return;
            }
            this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.f10120c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.f10125h.get(1).layout(0, 0, this.f10120c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f10120c);
                this.f10125h.get(1).layout(0, 0, this.f10120c + 0, this.l);
            }
            int i7 = this.f10120c;
            this.f10125h.get(2).layout(i7 + 0, 0, i7 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.f10120c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.f10125h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.f10125h.get(0).layout(this.f10120c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f10124g)), 0, this.f10120c, this.l);
            int i8 = this.f10120c;
            this.f10125h.get(1).layout(i8, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)) + i8, this.l);
            return;
        }
        this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.f10125h.get(1).layout(this.f10120c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f10124g)), 0, this.f10120c, this.l);
        int i9 = this.f10120c;
        this.f10125h.get(2).layout(i9, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)) + i9, this.l);
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
            Scroller scroller = this.f10121d;
            if (scroller != null && !scroller.isFinished()) {
                this.f10121d.abortAnimation();
            }
            this.o = x;
        } else if (action == 1) {
            VelocityTracker velocityTracker = this.p;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (xVelocity > f10118a) {
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.f10120c);
                this.m = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                    this.m = false;
                }
                if (this.m) {
                    this.j = true;
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent up startScroll---------------");
                    this.f10121d.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX(), 0, 1000);
                    invalidate();
                }
            } else if (xVelocity < 0) {
                this.m = true;
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.m = false;
                }
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.f10120c);
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent getscrollx" + getScrollX());
                com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent isNeedMove" + this.m);
                if (this.m) {
                    this.f10126i = true;
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent down startScroll---------------");
                    this.f10121d.startScroll(getScrollX(), 0, this.f10120c - getScrollX(), 0, 500);
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
            int i2 = (int) (this.o - x);
            this.m = true;
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g() && i2 < 0) {
                this.m = false;
            }
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h() && i2 > 0) {
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
        if (!this.f10122e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.f10125h.get(1).layout(0, 0, this.f10120c, this.l);
                    return;
                }
                if (this.f10120c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.f10125h.get(0).layout(0, 0, this.f10120c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f10120c);
                    this.f10125h.get(0).layout(0, 0, this.f10120c + 0, this.l);
                }
                int i2 = this.f10120c;
                this.f10125h.get(1).layout(i2 + 0, 0, i2 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)), this.l);
                return;
            }
            this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.f10120c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.f10125h.get(1).layout(0, 0, this.f10120c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.f10120c);
                this.f10125h.get(1).layout(0, 0, this.f10120c + 0, this.l);
            }
            int i3 = this.f10120c;
            this.f10125h.get(2).layout(i3 + 0, 0, i3 + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.f10120c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.f10125h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.f10125h.get(0).layout(this.f10120c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f10124g)), 0, this.f10120c, this.l);
            int i4 = this.f10120c;
            this.f10125h.get(1).layout(i4, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)) + i4, this.l);
            return;
        }
        this.f10125h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.f10125h.get(1).layout(this.f10120c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.f10124g)), 0, this.f10120c, this.l);
        int i5 = this.f10120c;
        this.f10125h.get(2).layout(i5, 0, ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f10124g)) + i5, this.l);
    }
}
