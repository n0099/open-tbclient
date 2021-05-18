package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.card.CardLinkageManager;
import d.a.c.j.e.s;
/* loaded from: classes.dex */
public class ThreadCardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public s f4516e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4517f;

    /* renamed from: g  reason: collision with root package name */
    public int f4518g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4519h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4520i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4519h) {
                return;
            }
            if (ThreadCardView.this.f4516e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4516e, ThreadCardView.this.f4518g, true);
            } else if (ThreadCardView.this.f4517f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4517f, ThreadCardView.this.f4518g, true);
            }
            if (ThreadCardView.this.f4519h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4517f, ThreadCardView.this.f4518g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4516e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4516e, ThreadCardView.this.f4518g, false);
            } else if (ThreadCardView.this.f4517f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4517f, ThreadCardView.this.f4518g, false);
            }
        }
    }

    public ThreadCardView(Context context) {
        super(context);
        this.f4520i = new a();
        this.j = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4520i);
        removeCallbacks(this.j);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4519h = false;
            postDelayed(this.f4520i, ViewConfiguration.getTapTimeout());
        } else if (action == 1) {
            this.f4519h = true;
            removeCallbacks(this.f4520i);
            CardLinkageManager.INSTANCE.pressLinkage(this.f4516e, this.f4518g, true);
            postDelayed(this.j, ViewConfiguration.getTapTimeout());
        } else if (action == 3) {
            this.f4519h = true;
            removeCallbacks(this.f4520i);
            removeCallbacks(this.j);
            s sVar = this.f4516e;
            if (sVar != null) {
                CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4518g, false);
            } else {
                ViewGroup viewGroup = this.f4517f;
                if (viewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4518g, false);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setITypeListView(s sVar) {
        this.f4516e = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.f4517f = viewGroup;
    }

    public void setPosition(int i2) {
        this.f4518g = i2;
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4520i = new a();
        this.j = new b();
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4520i = new a();
        this.j = new b();
    }
}
