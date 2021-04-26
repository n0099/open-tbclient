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
    public s f4662e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4663f;

    /* renamed from: g  reason: collision with root package name */
    public int f4664g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4665h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4666i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4665h) {
                return;
            }
            if (ThreadCardView.this.f4662e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4662e, ThreadCardView.this.f4664g, true);
            } else if (ThreadCardView.this.f4663f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4663f, ThreadCardView.this.f4664g, true);
            }
            if (ThreadCardView.this.f4665h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4663f, ThreadCardView.this.f4664g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4662e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4662e, ThreadCardView.this.f4664g, false);
            } else if (ThreadCardView.this.f4663f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4663f, ThreadCardView.this.f4664g, false);
            }
        }
    }

    public ThreadCardView(Context context) {
        super(context);
        this.f4666i = new a();
        this.j = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4666i);
        removeCallbacks(this.j);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4665h = false;
            postDelayed(this.f4666i, ViewConfiguration.getTapTimeout());
        } else if (action == 1) {
            this.f4665h = true;
            removeCallbacks(this.f4666i);
            CardLinkageManager.INSTANCE.pressLinkage(this.f4662e, this.f4664g, true);
            postDelayed(this.j, ViewConfiguration.getTapTimeout());
        } else if (action == 3) {
            this.f4665h = true;
            removeCallbacks(this.f4666i);
            removeCallbacks(this.j);
            s sVar = this.f4662e;
            if (sVar != null) {
                CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4664g, false);
            } else {
                ViewGroup viewGroup = this.f4663f;
                if (viewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4664g, false);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setITypeListView(s sVar) {
        this.f4662e = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.f4663f = viewGroup;
    }

    public void setPosition(int i2) {
        this.f4664g = i2;
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4666i = new a();
        this.j = new b();
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4666i = new a();
        this.j = new b();
    }
}
