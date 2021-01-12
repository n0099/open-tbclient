package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static int f4379a = 600;

    /* renamed from: b  reason: collision with root package name */
    private Context f4380b;
    private int c;
    private Scroller d;
    private boolean e;
    private int f;
    private ArrayList<a> g;
    private boolean h;
    private int i;
    private boolean j;
    private com.baidu.platform.comapi.walknavi.g.a k;
    private int l;
    private float m;
    private VelocityTracker n;

    public void a(int i) {
        if (this.h) {
            if (i == com.baidu.platform.comapi.walknavi.segmentbrowse.c.k() * this.f) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    this.h = false;
                }
                if (getChildCount() == 2) {
                    removeViews(0, 1);
                    this.g.remove(0);
                } else {
                    removeViews(0, 2);
                    this.g.remove(0);
                    this.g.remove(0);
                }
                a aVar = new a(this.f4380b, "", -1);
                aVar.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.c()));
                a a2 = a(aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.c.e());
                addView(a2);
                this.g.add(0, a2);
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() < com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    a aVar2 = new a(this.f4380b, "", -1);
                    aVar2.setTag(Integer.valueOf(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b()));
                    a a3 = a(aVar2, com.baidu.platform.comapi.walknavi.segmentbrowse.c.f());
                    addView(a3);
                    this.g.add(a3);
                }
            }
            this.c = i;
            a();
            postInvalidate();
        }
    }

    private void a() {
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                a aVar = this.g.get(0);
                aVar.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
                a aVar2 = this.g.get(1);
                aVar2.layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
                return;
            }
            a aVar3 = this.g.get(0);
            aVar3.layout(this.c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar4 = this.g.get(1);
            aVar4.layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
            return;
        }
        a aVar5 = this.g.get(0);
        aVar5.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
        a aVar6 = this.g.get(1);
        aVar6.layout(this.c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.g.get(2);
            aVar7.layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 7**left=" + aVar7.getLeft() + "**right=" + aVar7.getRight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 2) {
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                a aVar = this.g.get(0);
                aVar.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 1**left=" + aVar.getLeft() + "**right=" + aVar.getRight());
                a aVar2 = this.g.get(1);
                aVar2.layout(0, 0, com.baidu.platform.comapi.walknavi.segmentbrowse.c.o() + 0, this.i);
                com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 2**left=" + aVar2.getLeft() + "**right=" + aVar2.getRight());
                return;
            }
            a aVar3 = this.g.get(0);
            aVar3.layout(this.c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.c, this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 3**left=" + aVar3.getLeft() + "**right=" + aVar3.getRight());
            a aVar4 = this.g.get(1);
            aVar4.layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 4**left=" + aVar4.getLeft() + "**right=" + aVar4.getRight());
            return;
        }
        a aVar5 = this.g.get(0);
        aVar5.layout(-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n(), 0, 0, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 5**left=" + aVar5.getLeft() + "**right=" + aVar5.getRight());
        a aVar6 = this.g.get(1);
        aVar6.layout(this.c - com.baidu.platform.comapi.walknavi.segmentbrowse.c.o(), 0, this.c, this.i);
        com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 6**left=" + aVar6.getLeft() + "**right=" + aVar6.getRight());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
            a aVar7 = this.g.get(2);
            aVar7.layout(this.c + 0, 0, this.c + 0 + ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.l() * this.f)), this.i);
            com.baidu.platform.comapi.wnplatform.d.a.a("onlayout", "textviewtwo 7**left=" + aVar7.getLeft() + "**right=" + aVar7.getRight());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        com.baidu.platform.comapi.wnplatform.d.a.a("scroll", "computeScroll");
        if (this.d.computeScrollOffset()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("scroll", this.d.getCurrX() + "======" + this.d.getCurrY());
            scrollTo(this.d.getCurrX(), this.d.getCurrY());
            postInvalidate();
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("istime", "istime");
        if (this.e) {
            this.e = false;
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
        switch (motionEvent.getAction()) {
            case 0:
                if (this.d != null && !this.d.isFinished()) {
                    this.d.abortAnimation();
                }
                this.m = x;
                break;
            case 1:
                VelocityTracker velocityTracker = this.n;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > f4379a) {
                    this.j = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
                        this.j = false;
                    }
                    if (this.j) {
                        this.e = true;
                        this.d.startScroll(getScrollX(), 0, (-com.baidu.platform.comapi.walknavi.segmentbrowse.c.n()) - getScrollX(), 0, 1000);
                    }
                } else if (xVelocity < 0) {
                    com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background width" + this.c);
                    com.baidu.platform.comapi.wnplatform.d.a.a("aaa", "background getscrollx" + getScrollX());
                    this.j = true;
                    if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                        this.j = false;
                    }
                    if (this.j) {
                        this.e = true;
                        this.d.startScroll(getScrollX(), 0, this.c - getScrollX(), 0, 500);
                    }
                }
                if (this.n != null) {
                    this.n.recycle();
                    this.n = null;
                }
                this.l = 0;
                break;
            case 2:
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
                    break;
                }
                break;
            case 3:
                this.l = 0;
                break;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private a a(a aVar, com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar2) {
        if (aVar2 != null && this.k != null) {
            int d = aVar2.d();
            if (d >= 0 && d < 30) {
                if (this.k.f4278a != null) {
                    aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f4278a));
                }
            } else if (d >= 30 && d < 150) {
                if (this.k.f4279b != null) {
                    aVar.setBackgroundDrawable(new BitmapDrawable(this.k.f4279b));
                }
            } else if (d >= 150 && this.k.c != null) {
                aVar.setBackgroundDrawable(new BitmapDrawable(this.k.c));
            }
        }
        return aVar;
    }
}
