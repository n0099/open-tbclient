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
public class o {
    private l VR;
    private float VT;
    private float VU;
    private BdTypeRecyclerView Wu;
    private LinearLayoutManager Wv;
    private int mOrientation;
    private int mScrollState;
    private boolean VV = false;
    private HashSet<Integer> Ww = new HashSet<>();
    private HashSet<Integer> Wx = new HashSet<>();
    private SparseIntArray VS = new SparseIntArray();
    private SparseArray<ValueAnimator> VW = new SparseArray<>();
    private SparseIntArray VX = new SparseIntArray();

    public o(l lVar) {
        this.VR = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Wu = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Wv = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Wu != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.VR.ra()) {
                this.VV = true;
                qP();
                return;
            }
            this.VV = false;
            if (Math.abs(f2) > this.VR.qW()) {
                f3 = f2 > 0.0f ? this.VR.qW() : -this.VR.qW();
            } else {
                f3 = f2;
            }
            this.VS.clear();
            float qS = f3 * this.VR.qS();
            int aO = aO(i);
            if (aO >= 0) {
                if (f3 < 0.0f) {
                    float qT = this.VR.qT();
                    int i3 = 1;
                    while (true) {
                        int i4 = aO - i3;
                        float f4 = qS + (i3 * qT);
                        float f5 = qT * 1.2f;
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
                        int i5 = aO + i2;
                        float f6 = qS + (i2 * qT2);
                        float f7 = qT2 * 1.2f;
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
                        int i7 = aO - i6;
                        float f8 = qS - (i6 * qT3);
                        float f9 = qT3 * 1.2f;
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
                        int i8 = aO + i2;
                        float f10 = qS - (i2 * qT4);
                        float f11 = qT4 * 1.2f;
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
    }

    private int aO(int i) {
        if (i > 0) {
            q item = this.Wu.getItem(i - this.Wu.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aO;
        int aO2;
        if (this.Wu != null && this.Wv != null && this.mScrollState == 1 && !this.VV) {
            int findFirstVisibleItemPosition = i3 - this.Wv.findFirstVisibleItemPosition();
            int aO3 = aO(i3);
            if (aO3 >= 0) {
                this.Ww.add(Integer.valueOf(aO3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Wu.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Wu.getChildAt(i5);
                    int childAdapterPosition = this.Wu.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aO2 = aO(childAdapterPosition)) >= 0 && !this.Ww.contains(Integer.valueOf(aO2))) {
                        this.Ww.add(Integer.valueOf(aO2));
                        a(childAt, i4, childAdapterPosition, i3, aO2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Wu.getChildAt(i7);
                        int childAdapterPosition2 = this.Wu.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aO = aO(childAdapterPosition2)) >= 0 && !this.Ww.contains(Integer.valueOf(aO))) {
                            this.Ww.add(Integer.valueOf(aO));
                            a(childAt2, i4, childAdapterPosition2, i3, aO);
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
                    float B = B(view) + (i * this.VR.qY());
                    if (B > c(i4, i2, true) + (-this.VS.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.VR.qX());
                    if (B2 > c(i4, i2, false) + (-this.VS.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.VR.qY());
                if (B3 < c(i4, i2, false) + (-this.VS.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.VR.qX());
                if (B4 < c(i4, i2, true) + (-this.VS.get(i4))) {
                    a(view, i2, B4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aO;
        if (view != null && (aO = aO(i)) >= 0) {
            ValueAnimator valueAnimator = this.VW.get(aO);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.VR.rb());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.o.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        o.this.a(view, i, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.o.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        o.this.VW.delete(aO);
                        o.this.VX.delete(aO);
                        o.this.VS.delete(aO);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.VW.delete(aO);
                        o.this.VX.delete(aO);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.VW.append(aO, ofFloat);
                this.VX.append(aO, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.VX.get(aO)) + this.VR.qZ()) {
                this.VX.append(aO, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aM(int i) {
        if (this.Wu != null) {
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

    public void C(View view) {
        int childAdapterPosition;
        int aO;
        float f;
        float f2;
        if (this.Wu != null && this.Wv != null && this.mScrollState != 0 && (aO = aO((childAdapterPosition = this.Wu.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Wv.findFirstVisibleItemPosition()) {
                float B = this.Wu.getChildAt(1) != null ? B(this.Wu.getChildAt(1)) : 0.0f;
                int aO2 = aO(childAdapterPosition + 1);
                if (aO2 >= 0) {
                    if (aO2 == aO) {
                        m(view, B);
                    } else {
                        float f3 = -this.VS.get(aO, 0);
                        if (f3 != 0.0f) {
                            this.VT = f3;
                            f2 = f3;
                        } else {
                            f2 = this.VT;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Wu.getChildAt(this.Wu.getChildCount() + (-2)) != null ? B(this.Wu.getChildAt(this.Wu.getChildCount() - 2)) : 0.0f;
                int aO3 = aO(childAdapterPosition - 1);
                if (aO3 >= 0) {
                    if (aO3 == aO) {
                        m(view, B2);
                    } else {
                        float f4 = -this.VS.get(aO, 0);
                        if (f4 != 0.0f) {
                            this.VU = f4;
                            f = f4;
                        } else {
                            f = this.VU;
                        }
                        m(view, B2 + f);
                    }
                } else {
                    return;
                }
            }
            c(view, childAdapterPosition);
        }
    }

    public void D(View view) {
        if (this.Wu != null) {
            m(view, 0.0f);
            int aO = aO(this.Wu.getChildAdapterPosition(view));
            if (aO >= 0 && b(aO, 0, true) == -1) {
                this.VS.delete(aO);
                if (this.VW.get(aO) != null) {
                    this.VW.get(aO).cancel();
                }
                this.VW.delete(aO);
                this.VX.delete(aO);
            }
        }
    }

    private void qP() {
        int childCount = this.Wu.getChildCount();
        this.Wx.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Wu.getChildAt(i);
            int childAdapterPosition = this.Wu.getChildAdapterPosition(childAt);
            int aO = aO(childAdapterPosition);
            if (aO >= 0 && !this.Wx.contains(Integer.valueOf(aO))) {
                this.Wx.add(Integer.valueOf(aO));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Wu.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aO(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aO(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Wu, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float B(View view) {
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
            return B(this.Wu.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Wu.getChildAt(b(i - 1, i2, false)));
    }
}
