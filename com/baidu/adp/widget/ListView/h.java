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
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private i yH;
    private float yJ;
    private float yK;
    private boolean yL = false;
    private SparseIntArray yI = new SparseIntArray();
    private SparseArray<ValueAnimator> yM = new SparseArray<>();
    private SparseIntArray yN = new SparseIntArray();

    public h(i iVar) {
        this.yH = iVar;
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
            if (Math.abs(f2) < this.yH.jS()) {
                this.yL = true;
                jH();
                return;
            }
            this.mCurrentPosition = i;
            this.yL = false;
            if (Math.abs(f2) > this.yH.jO()) {
                f3 = f2 > 0.0f ? this.yH.jO() : -this.yH.jO();
            } else {
                f3 = f2;
            }
            this.yI.clear();
            float jK = f3 * this.yH.jK();
            if (f3 < 0.0f) {
                float jL = this.yH.jL();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = jK + (i3 * jL);
                    float f5 = jL * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float jJ = (f4 / this.yH.jJ()) + this.yI.get(i4);
                    if (Math.abs(jJ) > this.yH.jN()) {
                        jJ = -this.yH.jN();
                    }
                    this.yI.append(i4, (int) jJ);
                    i3++;
                    jL = f5;
                }
                float jL2 = this.yH.jL();
                while (true) {
                    int i5 = i + i2;
                    float f6 = jK + (i2 * jL2);
                    float f7 = jL2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float jI = (f6 / this.yH.jI()) + this.yI.get(i5);
                        if (Math.abs(jI) > this.yH.jM()) {
                            jI = -this.yH.jM();
                        }
                        this.yI.append(i5, (int) jI);
                        i2++;
                        jL2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float jL3 = this.yH.jL();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = jK - (i6 * jL3);
                    float f9 = jL3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float jI2 = (f8 / this.yH.jI()) + this.yI.get(i7);
                    if (Math.abs(jI2) > this.yH.jM()) {
                        jI2 = this.yH.jM();
                    }
                    this.yI.append(i7, (int) jI2);
                    i6++;
                    jL3 = f9;
                }
                float jL4 = this.yH.jL();
                while (true) {
                    int i8 = i + i2;
                    float f10 = jK - (i2 * jL4);
                    float f11 = jL4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float jJ2 = (f10 / this.yH.jJ()) + this.yI.get(i8);
                        if (Math.abs(jJ2) > this.yH.jN()) {
                            jJ2 = this.yH.jN();
                        }
                        this.yI.append(i8, (int) jJ2);
                        i2++;
                        jL4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aj(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.yI.clear();
                jH();
            } else if (this.mScrollState == 2) {
                jH();
            } else if (this.mScrollState == 1) {
                this.yI.clear();
                jH();
            }
        }
    }

    public void i(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.yL) {
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
                    float z = z(view) + (this.yH.jQ() * f);
                    if (z > (-this.yI.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.yH.jP() * f);
                    if (z2 > (-this.yI.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.yH.jQ() * f);
                if (z3 < (-this.yI.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.yH.jP() * f);
                if (z4 < (-this.yI.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.yI.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.yJ = f;
                    } else {
                        f = this.yJ;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.yI.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.yK = f2;
                    } else {
                        f2 = this.yK;
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
            this.yI.delete(childAdapterPosition);
            if (this.yM.get(childAdapterPosition) != null) {
                this.yM.get(childAdapterPosition).cancel();
            }
            this.yM.delete(childAdapterPosition);
            this.yN.delete(childAdapterPosition);
        }
    }

    private void jH() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.yM.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.yH.jT());
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
                        h.this.yM.delete(i);
                        h.this.yN.delete(i);
                        h.this.yI.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.yM.delete(i);
                        h.this.yN.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.yM.append(i, ofFloat);
                this.yN.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.yN.get(i)) + this.yH.jR()) {
                this.yN.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
