package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
public class BdExpandListView extends BdListView {
    public a a;
    private final Context b;
    private final Scroller c;
    private View d;
    private float e;
    private float f;
    private b g;
    private boolean h;
    private float i;
    private float j;
    private final int k;
    private final int l;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.b = context;
        this.c = new Scroller(this.b);
        this.k = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.ExpandListView).getDimensionPixelSize(1, 0);
    }

    public void setExpandView(View view) {
        this.d = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.c.isFinished()) {
            this.f = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.d.getHeight();
                    this.e = this.f;
                    this.i = this.j;
                    this.g = new b(0, height, 0, this.l + height);
                    break;
                case 1:
                case 3:
                    if (this.h) {
                        a();
                    }
                    this.h = false;
                    break;
                case 2:
                    float f = this.j - this.i;
                    float f2 = this.f - this.e;
                    this.i = this.j;
                    if (this.d.getParent() == this && this.g != null && this.d.isShown() && this.d.getTop() >= 0 && Math.abs(f2) >= this.k && Math.abs(f) < this.k) {
                        int a = this.g.a(this.f - this.e);
                        if (a > this.g.b && a <= this.g.d) {
                            this.h = true;
                            this.d.setLayoutParams(new AbsListView.LayoutParams(this.d.getWidth(), a));
                            a(a - this.g.b);
                        } else if (a <= this.g.b) {
                            this.h = false;
                        } else if (a > this.g.d) {
                            this.h = true;
                        } else {
                            this.h = false;
                        }
                        if (!this.h) {
                            this.a.a();
                            break;
                        }
                    } else {
                        this.a.a();
                        this.h = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void a() {
        if (this.g != null) {
            if (this.d.getHeight() >= this.g.d - (this.l / 2)) {
                b();
            } else {
                this.a.a();
            }
            this.c.startScroll(0, this.d.getHeight(), 0, this.g.b - this.d.getHeight(), Constants.MEDIA_INFO);
            invalidate();
            this.h = false;
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.c.computeScrollOffset()) {
            this.d.setLayoutParams(new AbsListView.LayoutParams(this.d.getWidth(), this.c.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void a(float f) {
        this.a.a(360.0f - ((f * 360.0f) / this.l));
    }
}
