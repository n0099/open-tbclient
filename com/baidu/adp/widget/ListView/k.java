package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class k {
    private h NQ;
    private l NR;
    private float NT;
    private float NU;
    private int NV;
    private com.baidu.tbadk.p.a.a NW;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener NX = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.k.1
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
            k.this.aQ(i);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            k.this.r(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.k.3
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k.this.mRecyclerView.stopScroll();
                k.this.NT = motionEvent.getX();
                k.this.NU = motionEvent.getY();
                k.this.mCurrentPosition = k.this.mRecyclerView.getChildAdapterPosition(k.this.findChildViewUnder(k.this.NT, k.this.NU));
                if (k.this.mVelocityTracker == null) {
                    k.this.mVelocityTracker = VelocityTracker.obtain();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (k.this.mOrientation == 2 ? y - k.this.NU : x - k.this.NT) >= 0.0f ? 2 : 1;
                if (i != k.this.NV) {
                    k.this.NV = i;
                    k.this.mVelocityTracker.clear();
                }
                k.this.mVelocityTracker.addMovement(motionEvent);
                k.this.mVelocityTracker.computeCurrentVelocity(50);
                k.this.o(k.this.mVelocityTracker.getXVelocity(), k.this.mVelocityTracker.getYVelocity());
                k.this.NT = x;
                k.this.NU = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                k.this.NT = 0.0f;
                k.this.NU = 0.0f;
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
        this.NQ = new h(iVar);
        this.NR = new l(iVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.NX);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.NR.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.NQ.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.NX);
        }
    }

    public void oa() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.NX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.NR.a(f, f2, this.mCurrentPosition);
        }
        this.NQ.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.NR.k(i, i2, this.mCurrentPosition);
        }
        this.NQ.k(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.NW == null) {
                    this.NW = new com.baidu.tbadk.p.a.a("anim_switch_slide");
                }
                this.NW.aus();
            }
        } else if (i == 0 && this.NW != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.NW.aut();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.NR.aP(i);
        }
        this.NQ.aP(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.NR.D(view);
        } else {
            this.NQ.D(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.NR.E(view);
        } else {
            this.NQ.E(view);
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
