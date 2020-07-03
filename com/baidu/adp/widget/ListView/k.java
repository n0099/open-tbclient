package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
/* loaded from: classes.dex */
public class k {
    private l Vv;
    private float Vx;
    private float Vy;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Vz = false;
    private SparseIntArray Vw = new SparseIntArray();
    private SparseArray<ValueAnimator> VA = new SparseArray<>();
    private SparseIntArray VB = new SparseIntArray();

    public k(l lVar) {
        this.Vv = lVar;
    }

    public void a(RecyclerView recyclerView, int i) {
        this.mRecyclerView = recyclerView;
        this.mOrientation = i;
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.mRecyclerView != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Vv.pA()) {
                this.Vz = true;
                pp();
                return;
            }
            this.mCurrentPosition = i;
            this.Vz = false;
            if (Math.abs(f2) > this.Vv.pw()) {
                f3 = f2 > 0.0f ? this.Vv.pw() : -this.Vv.pw();
            } else {
                f3 = f2;
            }
            this.Vw.clear();
            float ps = f3 * this.Vv.ps();
            if (f3 < 0.0f) {
                float pt = this.Vv.pt();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = ps + (i3 * pt);
                    float f5 = pt * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float pr = (f4 / this.Vv.pr()) + this.Vw.get(i4);
                    if (Math.abs(pr) > this.Vv.pv()) {
                        pr = -this.Vv.pv();
                    }
                    this.Vw.append(i4, (int) pr);
                    i3++;
                    pt = f5;
                }
                float pt2 = this.Vv.pt();
                while (true) {
                    int i5 = i + i2;
                    float f6 = ps + (i2 * pt2);
                    float f7 = pt2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float pq = (f6 / this.Vv.pq()) + this.Vw.get(i5);
                        if (Math.abs(pq) > this.Vv.pu()) {
                            pq = -this.Vv.pu();
                        }
                        this.Vw.append(i5, (int) pq);
                        i2++;
                        pt2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float pt3 = this.Vv.pt();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = ps - (i6 * pt3);
                    float f9 = pt3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float pq2 = (f8 / this.Vv.pq()) + this.Vw.get(i7);
                    if (Math.abs(pq2) > this.Vv.pu()) {
                        pq2 = this.Vv.pu();
                    }
                    this.Vw.append(i7, (int) pq2);
                    i6++;
                    pt3 = f9;
                }
                float pt4 = this.Vv.pt();
                while (true) {
                    int i8 = i + i2;
                    float f10 = ps - (i2 * pt4);
                    float f11 = pt4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float pr2 = (f10 / this.Vv.pr()) + this.Vw.get(i8);
                        if (Math.abs(pr2) > this.Vv.pv()) {
                            pr2 = this.Vv.pv();
                        }
                        this.Vw.append(i8, (int) pr2);
                        i2++;
                        pt4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aI(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Vw.clear();
                pp();
            } else if (this.mScrollState == 2) {
                pp();
            } else if (this.mScrollState == 1) {
                this.Vw.clear();
                pp();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Vz) {
            if (this.mOrientation != 2) {
                i2 = i;
            }
            int childCount = this.mRecyclerView.getChildCount();
            if (this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                int findFirstVisibleItemPosition = i3 - ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                    View childAt = this.mRecyclerView.getChildAt(i4);
                    int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1) {
                        a(childAt, i2, childAdapterPosition, i3, i4);
                    }
                }
                for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                    View childAt2 = this.mRecyclerView.getChildAt(i5);
                    int childAdapterPosition2 = this.mRecyclerView.getChildAdapterPosition(childAt2);
                    if (childAdapterPosition2 != -1) {
                        a(childAt2, i2, childAdapterPosition2, i3, i5);
                    }
                }
            }
        }
    }

    private float z(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.mOrientation == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, float f) {
        if (view != null) {
            if (this.mOrientation == 2) {
                view.setTranslationY(f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private void a(View view, float f, int i, int i2, int i3) {
        if (view != null) {
            if (f < 0.0f) {
                if (i < i2) {
                    float z = z(view) + (this.Vv.py() * f);
                    if (z > (-this.Vw.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.Vv.px() * f);
                    if (z2 > (-this.Vw.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.Vv.py() * f);
                if (z3 < (-this.Vw.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.Vv.px() * f);
                if (z4 < (-this.Vw.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, z4);
                } else {
                    c(view, i);
                }
            }
        }
    }

    public void A(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.Vw.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Vx = f;
                    } else {
                        f = this.Vx;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Vw.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Vy = f2;
                    } else {
                        f2 = this.Vy;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? z(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                c(view, childAdapterPosition);
            }
        }
    }

    public void B(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.Vw.delete(childAdapterPosition);
            if (this.VA.get(childAdapterPosition) != null) {
                this.VA.get(childAdapterPosition).cancel();
            }
            this.VA.delete(childAdapterPosition);
            this.VB.delete(childAdapterPosition);
        }
    }

    private void pp() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.VA.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Vv.pB());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.k.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        k.this.m(view, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.k.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.VA.delete(i);
                        k.this.VB.delete(i);
                        k.this.Vw.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        k.this.VA.delete(i);
                        k.this.VB.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.VA.append(i, ofFloat);
                this.VB.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.VB.get(i)) + this.Vv.pz()) {
                this.VB.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
