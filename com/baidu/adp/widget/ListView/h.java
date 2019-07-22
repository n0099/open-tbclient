package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
/* loaded from: classes.dex */
public class h {
    private i NJ;
    private float NL;
    private float NM;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean NN = false;
    private SparseIntArray NK = new SparseIntArray();
    private SparseArray<ValueAnimator> NP = new SparseArray<>();
    private SparseIntArray NQ = new SparseIntArray();

    public h(i iVar) {
        this.NJ = iVar;
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
            if (Math.abs(f2) < this.NJ.ou()) {
                this.NN = true;
                oj();
                return;
            }
            this.mCurrentPosition = i;
            this.NN = false;
            if (Math.abs(f2) > this.NJ.oq()) {
                f3 = f2 > 0.0f ? this.NJ.oq() : -this.NJ.oq();
            } else {
                f3 = f2;
            }
            this.NK.clear();
            float om = f3 * this.NJ.om();
            if (f3 < 0.0f) {
                float on = this.NJ.on();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = om + (i3 * on);
                    float f5 = on * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float ol = (f4 / this.NJ.ol()) + this.NK.get(i4);
                    if (Math.abs(ol) > this.NJ.op()) {
                        ol = -this.NJ.op();
                    }
                    this.NK.append(i4, (int) ol);
                    i3++;
                    on = f5;
                }
                float on2 = this.NJ.on();
                while (true) {
                    int i5 = i + i2;
                    float f6 = om + (i2 * on2);
                    float f7 = on2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float ok = (f6 / this.NJ.ok()) + this.NK.get(i5);
                        if (Math.abs(ok) > this.NJ.oo()) {
                            ok = -this.NJ.oo();
                        }
                        this.NK.append(i5, (int) ok);
                        i2++;
                        on2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float on3 = this.NJ.on();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = om - (i6 * on3);
                    float f9 = on3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float ok2 = (f8 / this.NJ.ok()) + this.NK.get(i7);
                    if (Math.abs(ok2) > this.NJ.oo()) {
                        ok2 = this.NJ.oo();
                    }
                    this.NK.append(i7, (int) ok2);
                    i6++;
                    on3 = f9;
                }
                float on4 = this.NJ.on();
                while (true) {
                    int i8 = i + i2;
                    float f10 = om - (i2 * on4);
                    float f11 = on4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float ol2 = (f10 / this.NJ.ol()) + this.NK.get(i8);
                        if (Math.abs(ol2) > this.NJ.op()) {
                            ol2 = this.NJ.op();
                        }
                        this.NK.append(i8, (int) ol2);
                        i2++;
                        on4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aP(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.NK.clear();
                oj();
            } else if (this.mScrollState == 2) {
                oj();
            } else if (this.mScrollState == 1) {
                this.NK.clear();
                oj();
            }
        }
    }

    public void k(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.NN) {
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

    private float E(View view) {
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
                    float E = E(view) + (this.NJ.os() * f);
                    if (E > (-this.NK.get(i)) + E(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, E);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float E2 = E(view) + (this.NJ.or() * f);
                    if (E2 > (-this.NK.get(i)) + E(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, E2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float E3 = E(view) + (this.NJ.os() * f);
                if (E3 < (-this.NK.get(i)) + E(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, E3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float E4 = E(view) + (this.NJ.or() * f);
                if (E4 < (-this.NK.get(i)) + E(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, E4);
                } else {
                    e(view, i);
                }
            }
        }
    }

    public void F(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.NK.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.NL = f;
                    } else {
                        f = this.NL;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? E(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.NK.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.NM = f2;
                    } else {
                        f2 = this.NM;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? E(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                e(view, childAdapterPosition);
            }
        }
    }

    public void G(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.NK.delete(childAdapterPosition);
            if (this.NP.get(childAdapterPosition) != null) {
                this.NP.get(childAdapterPosition).cancel();
            }
            this.NP.delete(childAdapterPosition);
            this.NQ.delete(childAdapterPosition);
        }
    }

    private void oj() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.NP.get(i);
            if (valueAnimator == null) {
                if (Math.abs(E(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(E(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.NJ.ov());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.h.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        h.this.m(view, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.h.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        h.this.NP.delete(i);
                        h.this.NQ.delete(i);
                        h.this.NK.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.NP.delete(i);
                        h.this.NQ.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.NP.append(i, ofFloat);
                this.NQ.append(i, (int) E(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float E = E(view);
            if (Math.abs(E) > Math.abs(this.NQ.get(i)) + this.NJ.ot()) {
                this.NQ.append(i, (int) E);
                valueAnimator.setFloatValues(E, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
