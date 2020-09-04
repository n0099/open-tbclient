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
    private l VR;
    private float VT;
    private float VU;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean VV = false;
    private SparseIntArray VS = new SparseIntArray();
    private SparseArray<ValueAnimator> VW = new SparseArray<>();
    private SparseIntArray VX = new SparseIntArray();

    public k(l lVar) {
        this.VR = lVar;
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
            if (Math.abs(f2) < this.VR.ra()) {
                this.VV = true;
                qP();
                return;
            }
            this.mCurrentPosition = i;
            this.VV = false;
            if (Math.abs(f2) > this.VR.qW()) {
                f3 = f2 > 0.0f ? this.VR.qW() : -this.VR.qW();
            } else {
                f3 = f2;
            }
            this.VS.clear();
            float qS = f3 * this.VR.qS();
            if (f3 < 0.0f) {
                float qT = this.VR.qT();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = qS + (i3 * qT);
                    float f5 = qT * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float qR = (f4 / this.VR.qR()) + this.VS.get(i4);
                    if (Math.abs(qR) > this.VR.qV()) {
                        qR = -this.VR.qV();
                    }
                    this.VS.append(i4, (int) qR);
                    i3++;
                    qT = f5;
                }
                float qT2 = this.VR.qT();
                while (true) {
                    int i5 = i + i2;
                    float f6 = qS + (i2 * qT2);
                    float f7 = qT2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float qQ = (f6 / this.VR.qQ()) + this.VS.get(i5);
                        if (Math.abs(qQ) > this.VR.qU()) {
                            qQ = -this.VR.qU();
                        }
                        this.VS.append(i5, (int) qQ);
                        i2++;
                        qT2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float qT3 = this.VR.qT();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = qS - (i6 * qT3);
                    float f9 = qT3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float qQ2 = (f8 / this.VR.qQ()) + this.VS.get(i7);
                    if (Math.abs(qQ2) > this.VR.qU()) {
                        qQ2 = this.VR.qU();
                    }
                    this.VS.append(i7, (int) qQ2);
                    i6++;
                    qT3 = f9;
                }
                float qT4 = this.VR.qT();
                while (true) {
                    int i8 = i + i2;
                    float f10 = qS - (i2 * qT4);
                    float f11 = qT4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float qR2 = (f10 / this.VR.qR()) + this.VS.get(i8);
                        if (Math.abs(qR2) > this.VR.qV()) {
                            qR2 = this.VR.qV();
                        }
                        this.VS.append(i8, (int) qR2);
                        i2++;
                        qT4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aM(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.VS.clear();
                qP();
            } else if (this.mScrollState == 2) {
                qP();
            } else if (this.mScrollState == 1) {
                this.VS.clear();
                qP();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.VV) {
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
                    float B = B(view) + (this.VR.qY() * f);
                    if (B > (-this.VS.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.VR.qX() * f);
                    if (B2 > (-this.VS.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.VR.qY() * f);
                if (B3 < (-this.VS.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.VR.qX() * f);
                if (B4 < (-this.VS.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.VS.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.VT = f;
                    } else {
                        f = this.VT;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.VS.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.VU = f2;
                    } else {
                        f2 = this.VU;
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
            this.VS.delete(childAdapterPosition);
            if (this.VW.get(childAdapterPosition) != null) {
                this.VW.get(childAdapterPosition).cancel();
            }
            this.VW.delete(childAdapterPosition);
            this.VX.delete(childAdapterPosition);
        }
    }

    private void qP() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.VW.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.VR.rb());
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
                        k.this.VW.delete(i);
                        k.this.VX.delete(i);
                        k.this.VS.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        k.this.VW.delete(i);
                        k.this.VX.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.VW.append(i, ofFloat);
                this.VX.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.VX.get(i)) + this.VR.qZ()) {
                this.VX.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
