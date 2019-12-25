package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class h extends ViewGroup {
    public static int a = Constants.HTTP_DNS_INAVAILABLE_TIME;
    private Context b;
    private int c;
    private Scroller d;
    private boolean e;
    private a f;
    private int g;
    private ArrayList<d> h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private int n;
    private float o;
    private VelocityTracker p;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);
    }

    public void a(int i) {
        if (this.k) {
            if (i == com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.g) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.k = false;
                }
                this.e = false;
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.h.remove(0);
                } else {
                    removeViews(0, 2);
                    this.h.remove(0);
                    this.h.remove(0);
                }
                d dVar = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()), this.c);
                dVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                addView(dVar);
                this.h.add(0, dVar);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    d dVar2 = new d(this.b, com.baidu.platform.comapi.walknavi.segmentbrowse.c.d(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()), this.c);
                    dVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    addView(dVar2);
                    this.h.add(dVar2);
                }
            }
            if (i <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.g))) {
                this.e = true;
            }
            this.c = i;
            f.a().a(this.c);
            a();
            invalidate();
        }
    }

    private void a() {
        if (!this.e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.h.get(1).layout(0, 0, this.c, this.l);
                    return;
                }
                if (this.c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.h.get(0).layout(0, 0, this.c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.c);
                    this.h.get(0).layout(0, 0, this.c + 0, this.l);
                }
                this.h.get(1).layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
                return;
            }
            this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.h.get(1).layout(0, 0, this.c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.c);
                this.h.get(1).layout(0, 0, this.c + 0, this.l);
            }
            this.h.get(2).layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.h.get(0).layout(this.c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.g)), 0, this.c, this.l);
            this.h.get(1).layout(this.c, 0, this.c + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
            return;
        }
        this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.h.get(1).layout(this.c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.g)), 0, this.c, this.l);
        this.h.get(2).layout(this.c, 0, this.c + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.d != null && !this.d.isFinished()) {
                    this.d.abortAnimation();
                }
                this.o = x;
                break;
            case 1:
                VelocityTracker velocityTracker = this.p;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > a) {
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.c);
                    this.m = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                        this.m = false;
                    }
                    if (this.m) {
                        this.j = true;
                        int scrollX = (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX();
                        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent up startScroll---------------");
                        this.d.startScroll(getScrollX(), 0, scrollX, 0, 1000);
                        invalidate();
                    }
                } else if (xVelocity < 0) {
                    this.m = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                        this.m = false;
                    }
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent width" + this.c);
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent getscrollx" + getScrollX());
                    com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent isNeedMove" + this.m);
                    if (this.m) {
                        this.i = true;
                        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "onTouchEvent down startScroll---------------");
                        this.d.startScroll(getScrollX(), 0, this.c - getScrollX(), 0, 500);
                        invalidate();
                    }
                }
                if (this.p != null) {
                    this.p.recycle();
                    this.p = null;
                }
                this.n = 0;
                break;
            case 2:
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
                    break;
                }
                break;
            case 3:
                this.n = 0;
                break;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.e) {
            if (getChildCount() == 2) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                    this.h.get(1).layout(0, 0, this.c, this.l);
                    return;
                }
                if (this.c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                    this.h.get(0).layout(0, 0, this.c + 0, this.l);
                } else {
                    com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.c);
                    this.h.get(0).layout(0, 0, this.c + 0, this.l);
                }
                this.h.get(1).layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
                return;
            }
            this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
            if (this.c == com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                this.h.get(1).layout(0, 0, this.c + 0, this.l);
            } else {
                com.baidu.platform.comapi.wnplatform.d.a.a("on layout true", "width" + this.c);
                this.h.get(1).layout(0, 0, this.c + 0, this.l);
            }
            this.h.get(2).layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("on layout false", "width" + this.c);
        if (getChildCount() == 2) {
            com.baidu.platform.comapi.wnplatform.d.a.a("getchild cur uid", "uid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
                this.h.get(1).layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), this.l);
                return;
            }
            this.h.get(0).layout(this.c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.g)), 0, this.c, this.l);
            this.h.get(1).layout(this.c, 0, this.c + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
            return;
        }
        this.h.get(0).layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.l);
        this.h.get(1).layout(this.c - ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.q() * this.g)), 0, this.c, this.l);
        this.h.get(2).layout(this.c, 0, this.c + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.g)), this.l);
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "computeScroll--->" + this.d.computeScrollOffset());
        if (this.d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", this.d.getCurrX() + "======" + this.d.getCurrY());
            scrollTo(this.d.getCurrX(), this.d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("TextViewOne", "istime:isGoToNext:" + this.i + "isGoToLast:" + this.j);
        if (this.i) {
            this.i = false;
            this.f.a(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
        }
        if (this.j) {
            this.j = false;
            this.f.a("last");
        }
    }
}
