package com.baidu.adp.widget.ListView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes.dex */
public class n {
    private k VK;
    private o VL;
    private float VM;
    private float VN;
    private int VP;
    private com.baidu.tbadk.n.a.a VQ;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    private RecyclerView.OnChildAttachStateChangeListener VR = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.adp.widget.ListView.n.1
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
            n.this.aL(i);
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
                n.this.VM = motionEvent.getX();
                n.this.VN = motionEvent.getY();
                n.this.mCurrentPosition = n.this.mRecyclerView.getChildAdapterPosition(n.this.findChildViewUnder(n.this.VM, n.this.VN));
                if (n.this.mVelocityTracker == null) {
                    n.this.mVelocityTracker = VelocityTracker.obtain();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                return false;
            } else if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = (n.this.mOrientation == 2 ? y - n.this.VN : x - n.this.VM) >= 0.0f ? 2 : 1;
                if (i != n.this.VP) {
                    n.this.VP = i;
                    n.this.mVelocityTracker.clear();
                }
                n.this.mVelocityTracker.addMovement(motionEvent);
                n.this.mVelocityTracker.computeCurrentVelocity(50);
                n.this.k(n.this.mVelocityTracker.getXVelocity(), n.this.mVelocityTracker.getYVelocity());
                n.this.VM = x;
                n.this.VN = y;
                return false;
            } else if (actionMasked == 3 || actionMasked == 1) {
                n.this.VM = 0.0f;
                n.this.VN = 0.0f;
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
        this.VK = new k(lVar);
        this.VL = new o(lVar);
    }

    public void a(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                this.mRecyclerView.removeOnChildAttachStateChangeListener(this.VR);
            }
            this.mRecyclerView = recyclerView;
            this.mOrientation = i;
            if (this.mRecyclerView instanceof BdTypeRecyclerView) {
                this.VL.a((BdTypeRecyclerView) this.mRecyclerView, this.mOrientation);
            } else {
                this.VK.a(this.mRecyclerView, this.mOrientation);
            }
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.VR);
        }
    }

    public void pD() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this.VR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f, float f2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VL.a(f, f2, this.mCurrentPosition);
        }
        this.VK.a(f, f2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VL.j(i, i2, this.mCurrentPosition);
        }
        this.VK.j(i, i2, this.mCurrentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(int i) {
        if (i == 1) {
            if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                if (this.VQ == null) {
                    this.VQ = new com.baidu.tbadk.n.a.a("anim_switch_slide");
                }
                this.VQ.blH();
            }
        } else if (i == 0 && this.VQ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
            this.VQ.blI();
        }
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VL.aK(i);
        }
        this.VK.aK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VL.C(view);
        } else {
            this.VK.C(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view) {
        if (this.mRecyclerView instanceof BdTypeRecyclerView) {
            this.VL.D(view);
        } else {
            this.VK.D(view);
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
