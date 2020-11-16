package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashSet;
/* loaded from: classes.dex */
public class o {
    private l WF;
    private float WH;
    private float WI;
    private BdTypeRecyclerView Xi;
    private LinearLayoutManager Xj;
    private int mOrientation;
    private int mScrollState;
    private boolean WJ = false;
    private HashSet<Integer> Xk = new HashSet<>();
    private HashSet<Integer> Xl = new HashSet<>();
    private SparseIntArray WG = new SparseIntArray();
    private SparseArray<ValueAnimator> WK = new SparseArray<>();
    private SparseIntArray WL = new SparseIntArray();

    public o(l lVar) {
        this.WF = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Xi = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Xj = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Xi != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.WF.rf()) {
                this.WJ = true;
                qU();
                return;
            }
            this.WJ = false;
            if (Math.abs(f2) > this.WF.rb()) {
                f3 = f2 > 0.0f ? this.WF.rb() : -this.WF.rb();
            } else {
                f3 = f2;
            }
            this.WG.clear();
            float qX = f3 * this.WF.qX();
            int aT = aT(i);
            if (aT >= 0) {
                if (f3 < 0.0f) {
                    float qY = this.WF.qY();
                    int i3 = 1;
                    while (true) {
                        int i4 = aT - i3;
                        float f4 = qX + (i3 * qY);
                        float f5 = qY * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float qW = (f4 / this.WF.qW()) + this.WG.get(i4);
                        if (Math.abs(qW) > this.WF.ra()) {
                            qW = -this.WF.ra();
                        }
                        this.WG.append(i4, (int) qW);
                        i3++;
                        qY = f5;
                    }
                    float qY2 = this.WF.qY();
                    while (true) {
                        int i5 = aT + i2;
                        float f6 = qX + (i2 * qY2);
                        float f7 = qY2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float qV = (f6 / this.WF.qV()) + this.WG.get(i5);
                            if (Math.abs(qV) > this.WF.qZ()) {
                                qV = -this.WF.qZ();
                            }
                            this.WG.append(i5, (int) qV);
                            i2++;
                            qY2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float qY3 = this.WF.qY();
                    int i6 = 1;
                    while (true) {
                        int i7 = aT - i6;
                        float f8 = qX - (i6 * qY3);
                        float f9 = qY3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float qV2 = (f8 / this.WF.qV()) + this.WG.get(i7);
                        if (Math.abs(qV2) > this.WF.qZ()) {
                            qV2 = this.WF.qZ();
                        }
                        this.WG.append(i7, (int) qV2);
                        i6++;
                        qY3 = f9;
                    }
                    float qY4 = this.WF.qY();
                    while (true) {
                        int i8 = aT + i2;
                        float f10 = qX - (i2 * qY4);
                        float f11 = qY4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float qW2 = (f10 / this.WF.qW()) + this.WG.get(i8);
                            if (Math.abs(qW2) > this.WF.ra()) {
                                qW2 = this.WF.ra();
                            }
                            this.WG.append(i8, (int) qW2);
                            i2++;
                            qY4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aT(int i) {
        if (i > 0) {
            q item = this.Xi.getItem(i - this.Xi.getHeaderViewsCount());
            if (item instanceof BaseCardInfo) {
                return ((BaseCardInfo) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aT;
        int aT2;
        if (this.Xi != null && this.Xj != null && this.mScrollState == 1 && !this.WJ) {
            int findFirstVisibleItemPosition = i3 - this.Xj.findFirstVisibleItemPosition();
            int aT3 = aT(i3);
            if (aT3 >= 0) {
                this.Xk.add(Integer.valueOf(aT3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Xi.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Xi.getChildAt(i5);
                    int childAdapterPosition = this.Xi.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aT2 = aT(childAdapterPosition)) >= 0 && !this.Xk.contains(Integer.valueOf(aT2))) {
                        this.Xk.add(Integer.valueOf(aT2));
                        a(childAt, i4, childAdapterPosition, i3, aT2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Xi.getChildAt(i7);
                        int childAdapterPosition2 = this.Xi.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aT = aT(childAdapterPosition2)) >= 0 && !this.Xk.contains(Integer.valueOf(aT))) {
                            this.Xk.add(Integer.valueOf(aT));
                            a(childAt2, i4, childAdapterPosition2, i3, aT);
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
                    float B = B(view) + (i * this.WF.rd());
                    if (B > c(i4, i2, true) + (-this.WG.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.WF.rc());
                    if (B2 > c(i4, i2, false) + (-this.WG.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.WF.rd());
                if (B3 < c(i4, i2, false) + (-this.WG.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.WF.rc());
                if (B4 < c(i4, i2, true) + (-this.WG.get(i4))) {
                    a(view, i2, B4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aT;
        if (view != null && (aT = aT(i)) >= 0) {
            ValueAnimator valueAnimator = this.WK.get(aT);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.WF.rg());
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
                        o.this.WK.delete(aT);
                        o.this.WL.delete(aT);
                        o.this.WG.delete(aT);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.WK.delete(aT);
                        o.this.WL.delete(aT);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.WK.append(aT, ofFloat);
                this.WL.append(aT, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.WL.get(aT)) + this.WF.re()) {
                this.WL.append(aT, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aR(int i) {
        if (this.Xi != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.WG.clear();
                qU();
            } else if (this.mScrollState == 2) {
                qU();
            } else if (this.mScrollState == 1) {
                this.WG.clear();
                qU();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aT;
        float f;
        float f2;
        if (this.Xi != null && this.Xj != null && this.mScrollState != 0 && (aT = aT((childAdapterPosition = this.Xi.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Xj.findFirstVisibleItemPosition()) {
                float B = this.Xi.getChildAt(1) != null ? B(this.Xi.getChildAt(1)) : 0.0f;
                int aT2 = aT(childAdapterPosition + 1);
                if (aT2 >= 0) {
                    if (aT2 == aT) {
                        m(view, B);
                    } else {
                        float f3 = -this.WG.get(aT, 0);
                        if (f3 != 0.0f) {
                            this.WH = f3;
                            f2 = f3;
                        } else {
                            f2 = this.WH;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Xi.getChildAt(this.Xi.getChildCount() + (-2)) != null ? B(this.Xi.getChildAt(this.Xi.getChildCount() - 2)) : 0.0f;
                int aT3 = aT(childAdapterPosition - 1);
                if (aT3 >= 0) {
                    if (aT3 == aT) {
                        m(view, B2);
                    } else {
                        float f4 = -this.WG.get(aT, 0);
                        if (f4 != 0.0f) {
                            this.WI = f4;
                            f = f4;
                        } else {
                            f = this.WI;
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
        if (this.Xi != null) {
            m(view, 0.0f);
            int aT = aT(this.Xi.getChildAdapterPosition(view));
            if (aT >= 0 && b(aT, 0, true) == -1) {
                this.WG.delete(aT);
                if (this.WK.get(aT) != null) {
                    this.WK.get(aT).cancel();
                }
                this.WK.delete(aT);
                this.WL.delete(aT);
            }
        }
    }

    private void qU() {
        int childCount = this.Xi.getChildCount();
        this.Xl.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Xi.getChildAt(i);
            int childAdapterPosition = this.Xi.getChildAdapterPosition(childAt);
            int aT = aT(childAdapterPosition);
            if (aT >= 0 && !this.Xl.contains(Integer.valueOf(aT))) {
                this.Xl.add(Integer.valueOf(aT));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Xi.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aT(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aT(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Xi, i, f);
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
            return B(this.Xi.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Xi.getChildAt(b(i - 1, i2, false)));
    }
}
