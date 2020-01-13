package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class k {
    private h Bl;
    private l Bm;
    private float Bn;
    private int Bo;
    private com.baidu.tbadk.n.a.a Bp;
    private int mCurrentPosition;
    private float mLastX;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener Bq = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.k.1
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
            k.this.an(i);
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
                k.this.mLastX = motionEvent.getX();
                k.this.Bn = motionEvent.getY();
                k.this.mCurrentPosition = k.this.mRecyclerView.getChildAdapterPosition(k.this.findChildViewUnder(k.this.mLastX, k.this.Bn));
                if (k.this.mVelocityTracker == null) {
                    k.this.mVelocityTracker = VelocityTracker.obtain();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (k.this.mOrientation == 2 ? y - k.this.Bn : x - k.this.mLastX) >= 0.0f ? 2 : 1;
                if (i != k.this.Bo) {
                    k.this.Bo = i;
                    k.this.mVelocityTracker.clear();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                k.this.mVelocityTracker.computeCurrentVelocity(50);
                k.this.l(k.this.mVelocityTracker.getXVelocity(), k.this.mVelocityTracker.getYVelocity());
                k.this.mLastX = x;
                k.this.Bn = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                k.this.mLastX = 0.0f;
                k.this.Bn = 0.0f;
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
        this.Bl = new h(iVar);
        this.Bm = new l(iVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Bq);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.Bm.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.Bl.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.Bq);
        }
    }

    public void km() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.Bq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Bm.a(f, f2, this.mCurrentPosition);
        }
        this.Bl.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Bm.i(i, i2, this.mCurrentPosition);
        }
        this.Bl.i(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.Bp == null) {
                    this.Bp = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.Bp.aPa();
            }
        } else if (i == 0 && this.Bp != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.Bp.aPb();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Bm.am(i);
        }
        this.Bl.am(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Bm.A(view);
        } else {
            this.Bl.A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.Bm.B(view);
        } else {
            this.Bl.B(view);
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
