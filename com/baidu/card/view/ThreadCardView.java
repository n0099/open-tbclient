package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.card.CardLinkageManager;
import d.b.b.j.e.s;
/* loaded from: classes2.dex */
public class ThreadCardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public s f4525e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4526f;

    /* renamed from: g  reason: collision with root package name */
    public int f4527g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4528h;
    public Runnable i;
    public Runnable j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4528h) {
                return;
            }
            if (ThreadCardView.this.f4525e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4525e, ThreadCardView.this.f4527g, true);
            } else if (ThreadCardView.this.f4526f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4526f, ThreadCardView.this.f4527g, true);
            }
            if (ThreadCardView.this.f4528h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4526f, ThreadCardView.this.f4527g, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadCardView.this.f4525e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.f4525e, ThreadCardView.this.f4527g, false);
            } else if (ThreadCardView.this.f4526f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.f4526f, ThreadCardView.this.f4527g, false);
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
            this.f4528h = false;
            postDelayed(this.i, ViewConfiguration.getTapTimeout());
        } else if (action == 1) {
            this.f4528h = true;
            removeCallbacks(this.i);
            CardLinkageManager.INSTANCE.pressLinkage(this.f4525e, this.f4527g, true);
            postDelayed(this.j, ViewConfiguration.getTapTimeout());
        } else if (action == 3) {
            this.f4528h = true;
            removeCallbacks(this.i);
            removeCallbacks(this.j);
            s sVar = this.f4525e;
            if (sVar != null) {
                CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4527g, false);
            } else {
                ViewGroup viewGroup = this.f4526f;
                if (viewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4527g, false);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setITypeListView(s sVar) {
        this.f4525e = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.f4526f = viewGroup;
    }

    public void setPosition(int i) {
        this.f4527g = i;
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
