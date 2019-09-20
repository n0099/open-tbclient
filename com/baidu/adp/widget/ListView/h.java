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
    private i NK;
    private float NM;
    private float NN;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean NP = false;
    private SparseIntArray NL = new SparseIntArray();
    private SparseArray<ValueAnimator> NQ = new SparseArray<>();
    private SparseIntArray NR = new SparseIntArray();

    public h(i iVar) {
        this.NK = iVar;
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
            if (Math.abs(f2) < this.NK.ov()) {
                this.NP = true;
                ok();
                return;
            }
            this.mCurrentPosition = i;
            this.NP = false;
            if (Math.abs(f2) > this.NK.or()) {
                f3 = f2 > 0.0f ? this.NK.or() : -this.NK.or();
            } else {
                f3 = f2;
            }
            this.NL.clear();
            float on = f3 * this.NK.on();
            if (f3 < 0.0f) {
                float oo = this.NK.oo();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = on + (i3 * oo);
                    float f5 = oo * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float om = (f4 / this.NK.om()) + this.NL.get(i4);
                    if (Math.abs(om) > this.NK.oq()) {
                        om = -this.NK.oq();
                    }
                    this.NL.append(i4, (int) om);
                    i3++;
                    oo = f5;
                }
                float oo2 = this.NK.oo();
                while (true) {
                    int i5 = i + i2;
                    float f6 = on + (i2 * oo2);
                    float f7 = oo2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float ol = (f6 / this.NK.ol()) + this.NL.get(i5);
                        if (Math.abs(ol) > this.NK.op()) {
                            ol = -this.NK.op();
                        }
                        this.NL.append(i5, (int) ol);
                        i2++;
                        oo2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float oo3 = this.NK.oo();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = on - (i6 * oo3);
                    float f9 = oo3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float ol2 = (f8 / this.NK.ol()) + this.NL.get(i7);
                    if (Math.abs(ol2) > this.NK.op()) {
                        ol2 = this.NK.op();
                    }
                    this.NL.append(i7, (int) ol2);
                    i6++;
                    oo3 = f9;
                }
                float oo4 = this.NK.oo();
                while (true) {
                    int i8 = i + i2;
                    float f10 = on - (i2 * oo4);
                    float f11 = oo4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float om2 = (f10 / this.NK.om()) + this.NL.get(i8);
                        if (Math.abs(om2) > this.NK.oq()) {
                            om2 = this.NK.oq();
                        }
                        this.NL.append(i8, (int) om2);
                        i2++;
                        oo4 = f11;
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
                this.NL.clear();
                ok();
            } else if (this.mScrollState == 2) {
                ok();
            } else if (this.mScrollState == 1) {
                this.NL.clear();
                ok();
            }
        }
    }

    public void k(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.NP) {
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
                    float E = E(view) + (this.NK.ot() * f);
                    if (E > (-this.NL.get(i)) + E(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, E);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float E2 = E(view) + (this.NK.os() * f);
                    if (E2 > (-this.NL.get(i)) + E(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, E2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float E3 = E(view) + (this.NK.ot() * f);
                if (E3 < (-this.NL.get(i)) + E(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, E3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float E4 = E(view) + (this.NK.os() * f);
                if (E4 < (-this.NL.get(i)) + E(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.NL.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.NM = f;
                    } else {
                        f = this.NM;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? E(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.NL.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.NN = f2;
                    } else {
                        f2 = this.NN;
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
            this.NL.delete(childAdapterPosition);
            if (this.NQ.get(childAdapterPosition) != null) {
                this.NQ.get(childAdapterPosition).cancel();
            }
            this.NQ.delete(childAdapterPosition);
            this.NR.delete(childAdapterPosition);
        }
    }

    private void ok() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.NQ.get(i);
            if (valueAnimator == null) {
                if (Math.abs(E(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(E(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.NK.ow());
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
                        h.this.NQ.delete(i);
                        h.this.NR.delete(i);
                        h.this.NL.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.NQ.delete(i);
                        h.this.NR.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.NQ.append(i, ofFloat);
                this.NR.append(i, (int) E(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float E = E(view);
            if (Math.abs(E) > Math.abs(this.NR.get(i)) + this.NK.ou()) {
                this.NR.append(i, (int) E);
                valueAnimator.setFloatValues(E, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
