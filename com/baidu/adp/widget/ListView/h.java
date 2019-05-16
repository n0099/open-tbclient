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
    private i Ns;
    private float Nu;
    private float Nv;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Nw = false;
    private SparseIntArray Nt = new SparseIntArray();
    private SparseArray<ValueAnimator> Nx = new SparseArray<>();
    private SparseIntArray Ny = new SparseIntArray();

    public h(i iVar) {
        this.Ns = iVar;
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
            if (Math.abs(f2) < this.Ns.nY()) {
                this.Nw = true;
                nN();
                return;
            }
            this.mCurrentPosition = i;
            this.Nw = false;
            if (Math.abs(f2) > this.Ns.nU()) {
                f3 = f2 > 0.0f ? this.Ns.nU() : -this.Ns.nU();
            } else {
                f3 = f2;
            }
            this.Nt.clear();
            float nQ = f3 * this.Ns.nQ();
            if (f3 < 0.0f) {
                float nR = this.Ns.nR();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = nQ + (i3 * nR);
                    float f5 = nR * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float nP = (f4 / this.Ns.nP()) + this.Nt.get(i4);
                    if (Math.abs(nP) > this.Ns.nT()) {
                        nP = -this.Ns.nT();
                    }
                    this.Nt.append(i4, (int) nP);
                    i3++;
                    nR = f5;
                }
                float nR2 = this.Ns.nR();
                while (true) {
                    int i5 = i + i2;
                    float f6 = nQ + (i2 * nR2);
                    float f7 = nR2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float nO = (f6 / this.Ns.nO()) + this.Nt.get(i5);
                        if (Math.abs(nO) > this.Ns.nS()) {
                            nO = -this.Ns.nS();
                        }
                        this.Nt.append(i5, (int) nO);
                        i2++;
                        nR2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float nR3 = this.Ns.nR();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = nQ - (i6 * nR3);
                    float f9 = nR3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float nO2 = (f8 / this.Ns.nO()) + this.Nt.get(i7);
                    if (Math.abs(nO2) > this.Ns.nS()) {
                        nO2 = this.Ns.nS();
                    }
                    this.Nt.append(i7, (int) nO2);
                    i6++;
                    nR3 = f9;
                }
                float nR4 = this.Ns.nR();
                while (true) {
                    int i8 = i + i2;
                    float f10 = nQ - (i2 * nR4);
                    float f11 = nR4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float nP2 = (f10 / this.Ns.nP()) + this.Nt.get(i8);
                        if (Math.abs(nP2) > this.Ns.nT()) {
                            nP2 = this.Ns.nT();
                        }
                        this.Nt.append(i8, (int) nP2);
                        i2++;
                        nR4 = f11;
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
                this.Nt.clear();
                nN();
            } else if (this.mScrollState == 2) {
                nN();
            } else if (this.mScrollState == 1) {
                this.Nt.clear();
                nN();
            }
        }
    }

    public void k(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Nw) {
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

    private float C(View view) {
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
                    float C = C(view) + (this.Ns.nW() * f);
                    if (C > (-this.Nt.get(i)) + C(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, C);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float C2 = C(view) + (this.Ns.nV() * f);
                    if (C2 > (-this.Nt.get(i)) + C(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, C2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float C3 = C(view) + (this.Ns.nW() * f);
                if (C3 < (-this.Nt.get(i)) + C(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, C3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float C4 = C(view) + (this.Ns.nV() * f);
                if (C4 < (-this.Nt.get(i)) + C(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, C4);
                } else {
                    e(view, i);
                }
            }
        }
    }

    public void D(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.Nt.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Nu = f;
                    } else {
                        f = this.Nu;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? C(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Nt.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Nv = f2;
                    } else {
                        f2 = this.Nv;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? C(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                e(view, childAdapterPosition);
            }
        }
    }

    public void E(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.Nt.delete(childAdapterPosition);
            if (this.Nx.get(childAdapterPosition) != null) {
                this.Nx.get(childAdapterPosition).cancel();
            }
            this.Nx.delete(childAdapterPosition);
            this.Ny.delete(childAdapterPosition);
        }
    }

    private void nN() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.Nx.get(i);
            if (valueAnimator == null) {
                if (Math.abs(C(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(C(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Ns.nZ());
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
                        h.this.Nx.delete(i);
                        h.this.Ny.delete(i);
                        h.this.Nt.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.Nx.delete(i);
                        h.this.Ny.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Nx.append(i, ofFloat);
                this.Ny.append(i, (int) C(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float C = C(view);
            if (Math.abs(C) > Math.abs(this.Ny.get(i)) + this.Ns.nX()) {
                this.Ny.append(i, (int) C);
                valueAnimator.setFloatValues(C, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
