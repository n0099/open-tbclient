package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.card.CardLinkageManager;
import d.b.c.j.e.s;
/* loaded from: classes.dex */
public class ThreadCardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public s f4561e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4562f;

    /* renamed from: g  reason: collision with root package name */
    public int f4563g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4564h;
    public Runnable i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4564h) {
                return;
            }
            if (ThreadCardView.this.f4561e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4561e, ThreadCardView.this.f4563g, true);
            } else if (ThreadCardView.this.f4562f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4562f, ThreadCardView.this.f4563g, true);
            }
            if (ThreadCardView.this.f4564h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4562f, ThreadCardView.this.f4563g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4561e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4561e, ThreadCardView.this.f4563g, false);
            } else if (ThreadCardView.this.f4562f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4562f, ThreadCardView.this.f4563g, false);
            }
        }
    }

    public ThreadCardView(Context context) {
        super(context);
        this.i = new a();
        this.j = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.i);
        removeCallbacks(this.j);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4564h = false;
            postDelayed(this.i, ViewConfiguration.getTapTimeout());
        } else if (action == 1) {
            this.f4564h = true;
            removeCallbacks(this.i);
            CardLinkageManager.INSTANCE.pressLinkage(this.f4561e, this.f4563g, true);
            postDelayed(this.j, ViewConfiguration.getTapTimeout());
        } else if (action == 3) {
            this.f4564h = true;
            removeCallbacks(this.i);
            removeCallbacks(this.j);
            s sVar = this.f4561e;
            if (sVar != null) {
                CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4563g, false);
            } else {
                ViewGroup viewGroup = this.f4562f;
                if (viewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4563g, false);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setITypeListView(s sVar) {
        this.f4561e = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.f4562f = viewGroup;
    }

    public void setPosition(int i) {
        this.f4563g = i;
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new a();
        this.j = new b();
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new a();
        this.j = new b();
    }
}
