package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class n {
    private k VS;
    private o VT;
    private float VU;
    private float VV;
    private int VW;
    private com.baidu.tbadk.n.a.a VX;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener VY = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.n.1
        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            n.this.C(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            n.this.D(view);
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.n.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            n.this.aJ(i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            n.this.n(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.n.3
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                n.this.mRecyclerView.stopScroll();
                n.this.VU = motionEvent.getX();
                n.this.VV = motionEvent.getY();
                n.this.mCurrentPosition = n.this.mRecyclerView.getChildAdapterPosition(n.this.findChildViewUnder(n.this.VU, n.this.VV));
                if (n.this.mVelocityTracker == null) {
                    n.this.mVelocityTracker = VelocityTracker.obtain();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (n.this.mOrientation == 2 ? y - n.this.VV : x - n.this.VU) >= 0.0f ? 2 : 1;
                if (i != n.this.VW) {
                    n.this.VW = i;
                    n.this.mVelocityTracker.clear();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                n.this.mVelocityTracker.computeCurrentVelocity(50);
                n.this.k(n.this.mVelocityTracker.getXVelocity(), n.this.mVelocityTracker.getYVelocity());
                n.this.VU = x;
                n.this.VV = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                n.this.VU = 0.0f;
                n.this.VV = 0.0f;
                n.this.mVelocityTracker.clear();
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

    public n(l lVar) {
        this.VS = new k(lVar);
        this.VT = new o(lVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.VY);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.VT.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.VS.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.VY);
        }
    }

    public void pC() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.VY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VT.a(f, f2, this.mCurrentPosition);
        }
        this.VS.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VT.j(i, i2, this.mCurrentPosition);
        }
        this.VS.j(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.VX == null) {
                    this.VX = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.VX.bhW();
            }
        } else if (i == 0 && this.VX != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.VX.bhX();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VT.aI(i);
        }
        this.VS.aI(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VT.A(view);
        } else {
            this.VS.A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VT.B(view);
        } else {
            this.VS.B(view);
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
