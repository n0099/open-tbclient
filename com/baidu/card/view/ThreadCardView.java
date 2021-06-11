package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.card.CardLinkageManager;
import d.a.c.k.e.s;
/* loaded from: classes.dex */
public class ThreadCardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public s f4538e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4539f;

    /* renamed from: g  reason: collision with root package name */
    public int f4540g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4541h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4542i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4541h) {
                return;
            }
            if (ThreadCardView.this.f4538e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4538e, ThreadCardView.this.f4540g, true);
            } else if (ThreadCardView.this.f4539f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4539f, ThreadCardView.this.f4540g, true);
            }
            if (ThreadCardView.this.f4541h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4539f, ThreadCardView.this.f4540g, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4538e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4538e, ThreadCardView.this.f4540g, false);
            } else if (ThreadCardView.this.f4539f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4539f, ThreadCardView.this.f4540g, false);
            }
        }
    }

    public ThreadCardView(Context context) {
        super(context);
        this.f4542i = new a();
        this.j = new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4542i);
        removeCallbacks(this.j);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4541h = false;
            postDelayed(this.f4542i, ViewConfiguration.getTapTimeout());
        } else if (action == 1) {
            this.f4541h = true;
            removeCallbacks(this.f4542i);
            CardLinkageManager.INSTANCE.pressLinkage(this.f4538e, this.f4540g, true);
            postDelayed(this.j, ViewConfiguration.getTapTimeout());
        } else if (action == 3) {
            this.f4541h = true;
            removeCallbacks(this.f4542i);
            removeCallbacks(this.j);
            s sVar = this.f4538e;
            if (sVar != null) {
                CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4540g, false);
            } else {
                ViewGroup viewGroup = this.f4539f;
                if (viewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4540g, false);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setITypeListView(s sVar) {
        this.f4538e = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.f4539f = viewGroup;
    }

    public void setPosition(int i2) {
        this.f4540g = i2;
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4542i = new a();
        this.j = new b();
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4542i = new a();
        this.j = new b();
    }
}
