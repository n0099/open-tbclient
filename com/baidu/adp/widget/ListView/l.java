package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tieba.card.CardLinkageManager;
import java.util.HashSet;
/* loaded from: classes.dex */
public class l {
    private BdTypeRecyclerView NZ;
    private i Ns;
    private float Nu;
    private float Nv;
    private LinearLayoutManager Oa;
    private int mOrientation;
    private int mScrollState;
    private boolean Nw = false;
    private HashSet<Integer> Ob = new HashSet<>();
    private HashSet<Integer> Oc = new HashSet<>();
    private SparseIntArray Nt = new SparseIntArray();
    private SparseArray<ValueAnimator> Nx = new SparseArray<>();
    private SparseIntArray Ny = new SparseIntArray();

    public l(i iVar) {
        this.Ns = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.NZ = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Oa = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.NZ != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Ns.nY()) {
                this.Nw = true;
                nN();
                return;
            }
            this.Nw = false;
            if (Math.abs(f2) > this.Ns.nU()) {
                f3 = f2 > 0.0f ? this.Ns.nU() : -this.Ns.nU();
            } else {
                f3 = f2;
            }
            this.Nt.clear();
            float nQ = f3 * this.Ns.nQ();
            int aR = aR(i);
            if (aR >= 0) {
                if (f3 < 0.0f) {
                    float nR = this.Ns.nR();
                    int i3 = 1;
                    while (true) {
                        int i4 = aR - i3;
                        float f4 = nQ + (i3 * nR);
                        float f5 = nR * 1.2f;
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
                        int i5 = aR + i2;
                        float f6 = nQ + (i2 * nR2);
                        float f7 = nR2 * 1.2f;
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
                        int i7 = aR - i6;
                        float f8 = nQ - (i6 * nR3);
                        float f9 = nR3 * 1.2f;
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
                        int i8 = aR + i2;
                        float f10 = nQ - (i2 * nR4);
                        float f11 = nR4 * 1.2f;
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
    }

    private int aR(int i) {
        if (i > 0) {
            m item = this.NZ.getItem(i - this.NZ.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void k(int i, int i2, int i3) {
        int aR;
        int aR2;
        if (this.NZ != null && this.Oa != null && this.mScrollState == 1 && !this.Nw) {
            int findFirstVisibleItemPosition = i3 - this.Oa.findFirstVisibleItemPosition();
            int aR3 = aR(i3);
            if (aR3 >= 0) {
                this.Ob.add(Integer.valueOf(aR3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.NZ.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.NZ.getChildAt(i5);
                    int childAdapterPosition = this.NZ.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aR2 = aR(childAdapterPosition)) >= 0 && !this.Ob.contains(Integer.valueOf(aR2))) {
                        this.Ob.add(Integer.valueOf(aR2));
                        a(childAt, i4, childAdapterPosition, i3, aR2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.NZ.getChildAt(i7);
                        int childAdapterPosition2 = this.NZ.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aR = aR(childAdapterPosition2)) >= 0 && !this.Ob.contains(Integer.valueOf(aR))) {
                            this.Ob.add(Integer.valueOf(aR));
                            a(childAt2, i4, childAdapterPosition2, i3, aR);
                        }
                        i6 = i7 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            if (i < 0) {
                if (i2 < i3) {
                    float C = C(view) + (i * this.Ns.nW());
                    if (C > c(i4, i2, true) + (-this.Nt.get(i4))) {
                        a(view, i2, C);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float C2 = C(view) + (i * this.Ns.nV());
                    if (C2 > c(i4, i2, false) + (-this.Nt.get(i4))) {
                        a(view, i2, C2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float C3 = C(view) + (i * this.Ns.nW());
                if (C3 < c(i4, i2, false) + (-this.Nt.get(i4))) {
                    a(view, i2, C3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float C4 = C(view) + (i * this.Ns.nV());
                if (C4 < c(i4, i2, true) + (-this.Nt.get(i4))) {
                    a(view, i2, C4);
                } else {
                    e(view, i2);
                }
            }
        }
    }

    private void e(final View view, final int i) {
        final int aR;
        if (view != null && (aR = aR(i)) >= 0) {
            ValueAnimator valueAnimator = this.Nx.get(aR);
            if (valueAnimator == null) {
                if (Math.abs(C(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(C(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Ns.nZ());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.l.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        l.this.a(view, i, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.l.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        l.this.Nx.delete(aR);
                        l.this.Ny.delete(aR);
                        l.this.Nt.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.Nx.delete(aR);
                        l.this.Ny.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Nx.append(aR, ofFloat);
                this.Ny.append(aR, (int) C(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float C = C(view);
            if (Math.abs(C) > Math.abs(this.Ny.get(aR)) + this.Ns.nX()) {
                this.Ny.append(aR, (int) C);
                valueAnimator.setFloatValues(C, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aP(int i) {
        if (this.NZ != null) {
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

    public void D(View view) {
        int childAdapterPosition;
        int aR;
        float f;
        float f2;
        if (this.NZ != null && this.Oa != null && this.mScrollState != 0 && (aR = aR((childAdapterPosition = this.NZ.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Oa.findFirstVisibleItemPosition()) {
                float C = this.NZ.getChildAt(1) != null ? C(this.NZ.getChildAt(1)) : 0.0f;
                int aR2 = aR(childAdapterPosition + 1);
                if (aR2 >= 0) {
                    if (aR2 == aR) {
                        m(view, C);
                    } else {
                        float f3 = -this.Nt.get(aR, 0);
                        if (f3 != 0.0f) {
                            this.Nu = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Nu;
                        }
                        m(view, C + f2);
                    }
                } else {
                    return;
                }
            } else {
                float C2 = this.NZ.getChildAt(this.NZ.getChildCount() + (-2)) != null ? C(this.NZ.getChildAt(this.NZ.getChildCount() - 2)) : 0.0f;
                int aR3 = aR(childAdapterPosition - 1);
                if (aR3 >= 0) {
                    if (aR3 == aR) {
                        m(view, C2);
                    } else {
                        float f4 = -this.Nt.get(aR, 0);
                        if (f4 != 0.0f) {
                            this.Nv = f4;
                            f = f4;
                        } else {
                            f = this.Nv;
                        }
                        m(view, C2 + f);
                    }
                } else {
                    return;
                }
            }
            e(view, childAdapterPosition);
        }
    }

    public void E(View view) {
        if (this.NZ != null) {
            m(view, 0.0f);
            int aR = aR(this.NZ.getChildAdapterPosition(view));
            if (aR >= 0 && b(aR, 0, true) == -1) {
                this.Nt.delete(aR);
                if (this.Nx.get(aR) != null) {
                    this.Nx.get(aR).cancel();
                }
                this.Nx.delete(aR);
                this.Ny.delete(aR);
            }
        }
    }

    private void nN() {
        int childCount = this.NZ.getChildCount();
        this.Oc.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.NZ.getChildAt(i);
            int childAdapterPosition = this.NZ.getChildAdapterPosition(childAt);
            int aR = aR(childAdapterPosition);
            if (aR >= 0 && !this.Oc.contains(Integer.valueOf(aR))) {
                this.Oc.add(Integer.valueOf(aR));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.NZ.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aR(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aR(i6)) {
                    return i6;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i, float f) {
        if (view != null) {
            if (this.mOrientation == 2) {
                CardLinkageManager.INSTANCE.translationY(this.NZ, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float C(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.mOrientation == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    private void m(View view, float f) {
        if (view != null) {
            if (this.mOrientation == 2) {
                view.setTranslationY(f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float c(int i, int i2, boolean z) {
        if (z) {
            return C(this.NZ.getChildAt(b(i + 1, i2, true)));
        }
        return C(this.NZ.getChildAt(b(i - 1, i2, false)));
    }
}
