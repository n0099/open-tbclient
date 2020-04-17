package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class k {
    private h UW;
    private l UX;
    private float UY;
    private float UZ;
    private int Va;
    private com.baidu.tbadk.n.a.a Vb;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener Vc = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.k.1
        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            k.this.C(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            k.this.D(view);
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.k.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            k.this.aC(i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            k.this.m(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.k.3
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k.this.mRecyclerView.stopScroll();
                k.this.UY = motionEvent.getX();
                k.this.UZ = motionEvent.getY();
                k.this.mCurrentPosition = k.this.mRecyclerView.getChildAdapterPosition(k.this.findChildViewUnder(k.this.UY, k.this.UZ));
                if (k.this.mVelocityTracker == null) {
                    k.this.mVelocityTracker = VelocityTracker.obtain();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (k.this.mOrientation == 2 ? y - k.this.UZ : x - k.this.UY) >= 0.0f ? 2 : 1;
                if (i != k.this.Va) {
                    k.this.Va = i;
                    k.this.mVelocityTracker.clear();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                k.this.mVelocityTracker.computeCurrentVelocity(50);
                k.this.k(k.this.mVelocityTracker.getXVelocity(), k.this.mVelocityTracker.getYVelocity());
                k.this.UY = x;
                k.this.UZ = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                k.this.UY = 0.0f;
                k.this.UZ = 0.0f;
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
        this.UW = new h(iVar);
        this.UX = new l(iVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Vc);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.UX.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.UW.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.Vc);
        }
    }

    public void pf() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Vc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.UX.a(f, f2, this.mCurrentPosition);
        }
        this.UW.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.UX.j(i, i2, this.mCurrentPosition);
        }
        this.UW.j(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.Vb == null) {
                    this.Vb = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.Vb.aZH();
            }
        } else if (i == 0 && this.Vb != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.Vb.aZI();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.UX.aB(i);
        }
        this.UW.aB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.UX.A(view);
        } else {
            this.UW.A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.UX.B(view);
        } else {
            this.UW.B(view);
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
