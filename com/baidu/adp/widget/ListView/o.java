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
    private l WB;
    private float WD;
    private float WE;
    private BdTypeRecyclerView Xe;
    private LinearLayoutManager Xf;
    private int mOrientation;
    private int mScrollState;
    private boolean WF = false;
    private HashSet<Integer> Xg = new HashSet<>();
    private HashSet<Integer> Xh = new HashSet<>();
    private SparseIntArray WC = new SparseIntArray();
    private SparseArray<ValueAnimator> WG = new SparseArray<>();
    private SparseIntArray WH = new SparseIntArray();

    public o(l lVar) {
        this.WB = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Xe = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Xf = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Xe != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.WB.rf()) {
                this.WF = true;
                qU();
                return;
            }
            this.WF = false;
            if (Math.abs(f2) > this.WB.rb()) {
                f3 = f2 > 0.0f ? this.WB.rb() : -this.WB.rb();
            } else {
                f3 = f2;
            }
            this.WC.clear();
            float qX = f3 * this.WB.qX();
            int aS = aS(i);
            if (aS >= 0) {
                if (f3 < 0.0f) {
                    float qY = this.WB.qY();
                    int i3 = 1;
                    while (true) {
                        int i4 = aS - i3;
                        float f4 = qX + (i3 * qY);
                        float f5 = qY * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float qW = (f4 / this.WB.qW()) + this.WC.get(i4);
                        if (Math.abs(qW) > this.WB.ra()) {
                            qW = -this.WB.ra();
                        }
                        this.WC.append(i4, (int) qW);
                        i3++;
                        qY = f5;
                    }
                    float qY2 = this.WB.qY();
                    while (true) {
                        int i5 = aS + i2;
                        float f6 = qX + (i2 * qY2);
                        float f7 = qY2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float qV = (f6 / this.WB.qV()) + this.WC.get(i5);
                            if (Math.abs(qV) > this.WB.qZ()) {
                                qV = -this.WB.qZ();
                            }
                            this.WC.append(i5, (int) qV);
                            i2++;
                            qY2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float qY3 = this.WB.qY();
                    int i6 = 1;
                    while (true) {
                        int i7 = aS - i6;
                        float f8 = qX - (i6 * qY3);
                        float f9 = qY3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float qV2 = (f8 / this.WB.qV()) + this.WC.get(i7);
                        if (Math.abs(qV2) > this.WB.qZ()) {
                            qV2 = this.WB.qZ();
                        }
                        this.WC.append(i7, (int) qV2);
                        i6++;
                        qY3 = f9;
                    }
                    float qY4 = this.WB.qY();
                    while (true) {
                        int i8 = aS + i2;
                        float f10 = qX - (i2 * qY4);
                        float f11 = qY4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float qW2 = (f10 / this.WB.qW()) + this.WC.get(i8);
                            if (Math.abs(qW2) > this.WB.ra()) {
                                qW2 = this.WB.ra();
                            }
                            this.WC.append(i8, (int) qW2);
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

    private int aS(int i) {
        if (i > 0) {
            q item = this.Xe.getItem(i - this.Xe.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aS;
        int aS2;
        if (this.Xe != null && this.Xf != null && this.mScrollState == 1 && !this.WF) {
            int findFirstVisibleItemPosition = i3 - this.Xf.findFirstVisibleItemPosition();
            int aS3 = aS(i3);
            if (aS3 >= 0) {
                this.Xg.add(Integer.valueOf(aS3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Xe.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Xe.getChildAt(i5);
                    int childAdapterPosition = this.Xe.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aS2 = aS(childAdapterPosition)) >= 0 && !this.Xg.contains(Integer.valueOf(aS2))) {
                        this.Xg.add(Integer.valueOf(aS2));
                        a(childAt, i4, childAdapterPosition, i3, aS2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Xe.getChildAt(i7);
                        int childAdapterPosition2 = this.Xe.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aS = aS(childAdapterPosition2)) >= 0 && !this.Xg.contains(Integer.valueOf(aS))) {
                            this.Xg.add(Integer.valueOf(aS));
                            a(childAt2, i4, childAdapterPosition2, i3, aS);
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
                    float B = B(view) + (i * this.WB.rd());
                    if (B > c(i4, i2, true) + (-this.WC.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.WB.rc());
                    if (B2 > c(i4, i2, false) + (-this.WC.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.WB.rd());
                if (B3 < c(i4, i2, false) + (-this.WC.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.WB.rc());
                if (B4 < c(i4, i2, true) + (-this.WC.get(i4))) {
                    a(view, i2, B4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aS;
        if (view != null && (aS = aS(i)) >= 0) {
            ValueAnimator valueAnimator = this.WG.get(aS);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.WB.rg());
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
                        o.this.WG.delete(aS);
                        o.this.WH.delete(aS);
                        o.this.WC.delete(aS);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.WG.delete(aS);
                        o.this.WH.delete(aS);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.WG.append(aS, ofFloat);
                this.WH.append(aS, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.WH.get(aS)) + this.WB.re()) {
                this.WH.append(aS, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aQ(int i) {
        if (this.Xe != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.WC.clear();
                qU();
            } else if (this.mScrollState == 2) {
                qU();
            } else if (this.mScrollState == 1) {
                this.WC.clear();
                qU();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aS;
        float f;
        float f2;
        if (this.Xe != null && this.Xf != null && this.mScrollState != 0 && (aS = aS((childAdapterPosition = this.Xe.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Xf.findFirstVisibleItemPosition()) {
                float B = this.Xe.getChildAt(1) != null ? B(this.Xe.getChildAt(1)) : 0.0f;
                int aS2 = aS(childAdapterPosition + 1);
                if (aS2 >= 0) {
                    if (aS2 == aS) {
                        m(view, B);
                    } else {
                        float f3 = -this.WC.get(aS, 0);
                        if (f3 != 0.0f) {
                            this.WD = f3;
                            f2 = f3;
                        } else {
                            f2 = this.WD;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Xe.getChildAt(this.Xe.getChildCount() + (-2)) != null ? B(this.Xe.getChildAt(this.Xe.getChildCount() - 2)) : 0.0f;
                int aS3 = aS(childAdapterPosition - 1);
                if (aS3 >= 0) {
                    if (aS3 == aS) {
                        m(view, B2);
                    } else {
                        float f4 = -this.WC.get(aS, 0);
                        if (f4 != 0.0f) {
                            this.WE = f4;
                            f = f4;
                        } else {
                            f = this.WE;
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
        if (this.Xe != null) {
            m(view, 0.0f);
            int aS = aS(this.Xe.getChildAdapterPosition(view));
            if (aS >= 0 && b(aS, 0, true) == -1) {
                this.WC.delete(aS);
                if (this.WG.get(aS) != null) {
                    this.WG.get(aS).cancel();
                }
                this.WG.delete(aS);
                this.WH.delete(aS);
            }
        }
    }

    private void qU() {
        int childCount = this.Xe.getChildCount();
        this.Xh.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Xe.getChildAt(i);
            int childAdapterPosition = this.Xe.getChildAdapterPosition(childAt);
            int aS = aS(childAdapterPosition);
            if (aS >= 0 && !this.Xh.contains(Integer.valueOf(aS))) {
                this.Xh.add(Integer.valueOf(aS));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Xe.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aS(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aS(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Xe, i, f);
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
            return B(this.Xe.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Xe.getChildAt(b(i - 1, i2, false)));
    }
}
