package com.baidu.adp.widget.ListView;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class l {
    private i XQ;
    private m XR;
    private int XS;
    private com.baidu.tbadk.n.a.a XT;
    private int mCurrentPosition;
    private float mLastX;
    private float mLastY;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener XU = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.l.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            l.this.E(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            l.this.F(view);
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.l.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            l.this.aX(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            l.this.q(i, i2);
        }
    };
    private RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.baidu.adp.widget.ListView.l.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                l.this.mRecyclerView.stopScroll();
                l.this.mLastX = motionEvent.getX();
                l.this.mLastY = motionEvent.getY();
                l.this.mCurrentPosition = l.this.mRecyclerView.getChildAdapterPosition(l.this.findChildViewUnder(l.this.mLastX, l.this.mLastY));
                if (l.this.mVelocityTracker == null) {
                    l.this.mVelocityTracker = VelocityTracker.obtain();
                }
                l.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (l.this.mOrientation == 2 ? y - l.this.mLastY : x - l.this.mLastX) >= 0.0f ? 2 : 1;
                if (i != l.this.XS) {
                    l.this.XS = i;
                    l.this.mVelocityTracker.clear();
                }
                l.this.mVelocityTracker.addMovement(motionEvent);
                l.this.mVelocityTracker.computeCurrentVelocity(50);
                l.this.k(l.this.mVelocityTracker.getXVelocity(), l.this.mVelocityTracker.getYVelocity());
                l.this.mLastX = x;
                l.this.mLastY = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                l.this.mLastX = 0.0f;
                l.this.mLastY = 0.0f;
                l.this.mVelocityTracker.clear();
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }
    };

    public l(j jVar) {
        this.XQ = new i(jVar);
        this.XR = new m(jVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.XU);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.XR.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.XQ.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.XU);
        }
    }

    public void qJ() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.XU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.XR.a(f, f2, this.mCurrentPosition);
        }
        this.XQ.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.XR.j(i, i2, this.mCurrentPosition);
        }
        this.XQ.j(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.XT == null) {
                    this.XT = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.XT.bEr();
            }
        } else if (i == 0 && this.XT != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.XT.bEs();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.XR.aW(i);
        }
        this.XQ.aW(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.XR.C(view);
        } else {
            this.XQ.C(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.XR.D(view);
        } else {
            this.XQ.D(view);
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
