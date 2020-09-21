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
    private l Wk;
    private float Wm;
    private float Wn;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Wo = false;
    private SparseIntArray Wl = new SparseIntArray();
    private SparseArray<ValueAnimator> Wp = new SparseArray<>();
    private SparseIntArray Wq = new SparseIntArray();

    public k(l lVar) {
        this.Wk = lVar;
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
            if (Math.abs(f2) < this.Wk.rf()) {
                this.Wo = true;
                qU();
                return;
            }
            this.mCurrentPosition = i;
            this.Wo = false;
            if (Math.abs(f2) > this.Wk.rb()) {
                f3 = f2 > 0.0f ? this.Wk.rb() : -this.Wk.rb();
            } else {
                f3 = f2;
            }
            this.Wl.clear();
            float qX = f3 * this.Wk.qX();
            if (f3 < 0.0f) {
                float qY = this.Wk.qY();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = qX + (i3 * qY);
                    float f5 = qY * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float qW = (f4 / this.Wk.qW()) + this.Wl.get(i4);
                    if (Math.abs(qW) > this.Wk.ra()) {
                        qW = -this.Wk.ra();
                    }
                    this.Wl.append(i4, (int) qW);
                    i3++;
                    qY = f5;
                }
                float qY2 = this.Wk.qY();
                while (true) {
                    int i5 = i + i2;
                    float f6 = qX + (i2 * qY2);
                    float f7 = qY2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float qV = (f6 / this.Wk.qV()) + this.Wl.get(i5);
                        if (Math.abs(qV) > this.Wk.qZ()) {
                            qV = -this.Wk.qZ();
                        }
                        this.Wl.append(i5, (int) qV);
                        i2++;
                        qY2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float qY3 = this.Wk.qY();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = qX - (i6 * qY3);
                    float f9 = qY3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float qV2 = (f8 / this.Wk.qV()) + this.Wl.get(i7);
                    if (Math.abs(qV2) > this.Wk.qZ()) {
                        qV2 = this.Wk.qZ();
                    }
                    this.Wl.append(i7, (int) qV2);
                    i6++;
                    qY3 = f9;
                }
                float qY4 = this.Wk.qY();
                while (true) {
                    int i8 = i + i2;
                    float f10 = qX - (i2 * qY4);
                    float f11 = qY4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float qW2 = (f10 / this.Wk.qW()) + this.Wl.get(i8);
                        if (Math.abs(qW2) > this.Wk.ra()) {
                            qW2 = this.Wk.ra();
                        }
                        this.Wl.append(i8, (int) qW2);
                        i2++;
                        qY4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aQ(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Wl.clear();
                qU();
            } else if (this.mScrollState == 2) {
                qU();
            } else if (this.mScrollState == 1) {
                this.Wl.clear();
                qU();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Wo) {
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

    private float B(View view) {
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
                    float B = B(view) + (this.Wk.rd() * f);
                    if (B > (-this.Wl.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.Wk.rc() * f);
                    if (B2 > (-this.Wl.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.Wk.rd() * f);
                if (B3 < (-this.Wl.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.Wk.rc() * f);
                if (B4 < (-this.Wl.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, B4);
                } else {
                    c(view, i);
                }
            }
        }
    }

    public void C(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.Wl.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Wm = f;
                    } else {
                        f = this.Wm;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Wl.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Wn = f2;
                    } else {
                        f2 = this.Wn;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? B(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                c(view, childAdapterPosition);
            }
        }
    }

    public void D(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.Wl.delete(childAdapterPosition);
            if (this.Wp.get(childAdapterPosition) != null) {
                this.Wp.get(childAdapterPosition).cancel();
            }
            this.Wp.delete(childAdapterPosition);
            this.Wq.delete(childAdapterPosition);
        }
    }

    private void qU() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.Wp.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Wk.rg());
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
                        k.this.Wp.delete(i);
                        k.this.Wq.delete(i);
                        k.this.Wl.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        k.this.Wp.delete(i);
                        k.this.Wq.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Wp.append(i, ofFloat);
                this.Wq.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.Wq.get(i)) + this.Wk.re()) {
                this.Wq.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
