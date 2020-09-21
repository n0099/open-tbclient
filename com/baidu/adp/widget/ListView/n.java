package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class n {
    private k WG;
    private o WH;
    private int WI;
    private com.baidu.tbadk.n.a.a WJ;
    private int mCurrentPosition;
    private float mLastX;
    private float mLastY;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener WK = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.n.1
        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            n.this.E(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            n.this.F(view);
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.n.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            n.this.aR(i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            n.this.p(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.n.3
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                n.this.mRecyclerView.stopScroll();
                n.this.mLastX = motionEvent.getX();
                n.this.mLastY = motionEvent.getY();
                n.this.mCurrentPosition = n.this.mRecyclerView.getChildAdapterPosition(n.this.findChildViewUnder(n.this.mLastX, n.this.mLastY));
                if (n.this.mVelocityTracker == null) {
                    n.this.mVelocityTracker = VelocityTracker.obtain();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (n.this.mOrientation == 2 ? y - n.this.mLastY : x - n.this.mLastX) >= 0.0f ? 2 : 1;
                if (i != n.this.WI) {
                    n.this.WI = i;
                    n.this.mVelocityTracker.clear();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                n.this.mVelocityTracker.computeCurrentVelocity(50);
                n.this.j(n.this.mVelocityTracker.getXVelocity(), n.this.mVelocityTracker.getYVelocity());
                n.this.mLastX = x;
                n.this.mLastY = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                n.this.mLastX = 0.0f;
                n.this.mLastY = 0.0f;
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
        this.WG = new k(lVar);
        this.WH = new o(lVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.WK);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.WH.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.WG.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.WK);
        }
    }

    public void rh() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.WK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.WH.a(f, f2, this.mCurrentPosition);
        }
        this.WG.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.WH.j(i, i2, this.mCurrentPosition);
        }
        this.WG.j(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.WJ == null) {
                    this.WJ = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.WJ.bvz();
            }
        } else if (i == 0 && this.WJ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.WJ.bvA();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.WH.aQ(i);
        }
        this.WG.aQ(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.WH.C(view);
        } else {
            this.WG.C(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.WH.D(view);
        } else {
            this.WG.D(view);
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
