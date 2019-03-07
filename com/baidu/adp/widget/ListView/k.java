package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class k {
    private h Qi;
    private l Qj;
    private float Qk;
    private float Ql;
    private int Qm;
    private com.baidu.tbadk.o.a.a Qn;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener Qo = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.k.1
        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            k.this.F(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            k.this.G(view);
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.k.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            k.this.aY(i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            k.this.t(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.k.3
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k.this.mRecyclerView.stopScroll();
                k.this.Qk = motionEvent.getX();
                k.this.Ql = motionEvent.getY();
                k.this.mCurrentPosition = k.this.mRecyclerView.getChildAdapterPosition(k.this.findChildViewUnder(k.this.Qk, k.this.Ql));
                if (k.this.mVelocityTracker == null) {
                    k.this.mVelocityTracker = VelocityTracker.obtain();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (k.this.mOrientation == 2 ? y - k.this.Ql : x - k.this.Qk) >= 0.0f ? 2 : 1;
                if (i != k.this.Qm) {
                    k.this.Qm = i;
                    k.this.mVelocityTracker.clear();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                k.this.mVelocityTracker.computeCurrentVelocity(50);
                k.this.o(k.this.mVelocityTracker.getXVelocity(), k.this.mVelocityTracker.getYVelocity());
                k.this.Qk = x;
                k.this.Ql = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                k.this.Qk = 0.0f;
                k.this.Ql = 0.0f;
                k.this.mVelocityTracker.clear();
                return false;
            } else {
                return false;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }
    };

    public k(i iVar) {
        this.Qi = new h(iVar);
        this.Qj = new l(iVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Qo);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.Qj.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.Qi.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.Qo);
        }
    }

    public void pg() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Qo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Qj.a(f, f2, this.mCurrentPosition);
        }
        this.Qi.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Qj.l(i, i2, this.mCurrentPosition);
        }
        this.Qi.l(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.Qn == null) {
                    this.Qn = new com.baidu.tbadk.o.a.a("anim_switch_slide");
                }
                this.Qn.apt();
            }
        } else if (i == 0 && this.Qn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.Qn.apu();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Qj.aX(i);
        }
        this.Qi.aX(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Qj.D(view);
        } else {
            this.Qi.D(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Qj.E(view);
        } else {
            this.Qi.E(view);
        }
    }

    public View findChildViewUnder(float f, float f2) {
        if (this.mRecyclerView == null) {
            return null;
        }
        for (int childCount = this.mRecyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mRecyclerView.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= childAt.getLeft() + translationX && f <= translationX + childAt.getRight() && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }
}
