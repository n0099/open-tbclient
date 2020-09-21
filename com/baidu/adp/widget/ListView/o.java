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
    private BdTypeRecyclerView WM;
    private LinearLayoutManager WN;
    private l Wk;
    private float Wm;
    private float Wn;
    private int mOrientation;
    private int mScrollState;
    private boolean Wo = false;
    private HashSet<Integer> WO = new HashSet<>();
    private HashSet<Integer> WP = new HashSet<>();
    private SparseIntArray Wl = new SparseIntArray();
    private SparseArray<ValueAnimator> Wp = new SparseArray<>();
    private SparseIntArray Wq = new SparseIntArray();

    public o(l lVar) {
        this.Wk = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.WM = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.WN = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.WM != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Wk.rf()) {
                this.Wo = true;
                qU();
                return;
            }
            this.Wo = false;
            if (Math.abs(f2) > this.Wk.rb()) {
                f3 = f2 > 0.0f ? this.Wk.rb() : -this.Wk.rb();
            } else {
                f3 = f2;
            }
            this.Wl.clear();
            float qX = f3 * this.Wk.qX();
            int aS = aS(i);
            if (aS >= 0) {
                if (f3 < 0.0f) {
                    float qY = this.Wk.qY();
                    int i3 = 1;
                    while (true) {
                        int i4 = aS - i3;
                        float f4 = qX + (i3 * qY);
                        float f5 = qY * 1.2f;
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
                        int i5 = aS + i2;
                        float f6 = qX + (i2 * qY2);
                        float f7 = qY2 * 1.2f;
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
                        int i7 = aS - i6;
                        float f8 = qX - (i6 * qY3);
                        float f9 = qY3 * 1.2f;
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
                        int i8 = aS + i2;
                        float f10 = qX - (i2 * qY4);
                        float f11 = qY4 * 1.2f;
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
    }

    private int aS(int i) {
        if (i > 0) {
            q item = this.WM.getItem(i - this.WM.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aS;
        int aS2;
        if (this.WM != null && this.WN != null && this.mScrollState == 1 && !this.Wo) {
            int findFirstVisibleItemPosition = i3 - this.WN.findFirstVisibleItemPosition();
            int aS3 = aS(i3);
            if (aS3 >= 0) {
                this.WO.add(Integer.valueOf(aS3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.WM.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.WM.getChildAt(i5);
                    int childAdapterPosition = this.WM.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aS2 = aS(childAdapterPosition)) >= 0 && !this.WO.contains(Integer.valueOf(aS2))) {
                        this.WO.add(Integer.valueOf(aS2));
                        a(childAt, i4, childAdapterPosition, i3, aS2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.WM.getChildAt(i7);
                        int childAdapterPosition2 = this.WM.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aS = aS(childAdapterPosition2)) >= 0 && !this.WO.contains(Integer.valueOf(aS))) {
                            this.WO.add(Integer.valueOf(aS));
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
                    float B = B(view) + (i * this.Wk.rd());
                    if (B > c(i4, i2, true) + (-this.Wl.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.Wk.rc());
                    if (B2 > c(i4, i2, false) + (-this.Wl.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.Wk.rd());
                if (B3 < c(i4, i2, false) + (-this.Wl.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.Wk.rc());
                if (B4 < c(i4, i2, true) + (-this.Wl.get(i4))) {
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
            ValueAnimator valueAnimator = this.Wp.get(aS);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Wk.rg());
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
                        o.this.Wp.delete(aS);
                        o.this.Wq.delete(aS);
                        o.this.Wl.delete(aS);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.Wp.delete(aS);
                        o.this.Wq.delete(aS);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Wp.append(aS, ofFloat);
                this.Wq.append(aS, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.Wq.get(aS)) + this.Wk.re()) {
                this.Wq.append(aS, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aQ(int i) {
        if (this.WM != null) {
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

    public void C(View view) {
        int childAdapterPosition;
        int aS;
        float f;
        float f2;
        if (this.WM != null && this.WN != null && this.mScrollState != 0 && (aS = aS((childAdapterPosition = this.WM.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.WN.findFirstVisibleItemPosition()) {
                float B = this.WM.getChildAt(1) != null ? B(this.WM.getChildAt(1)) : 0.0f;
                int aS2 = aS(childAdapterPosition + 1);
                if (aS2 >= 0) {
                    if (aS2 == aS) {
                        m(view, B);
                    } else {
                        float f3 = -this.Wl.get(aS, 0);
                        if (f3 != 0.0f) {
                            this.Wm = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Wm;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.WM.getChildAt(this.WM.getChildCount() + (-2)) != null ? B(this.WM.getChildAt(this.WM.getChildCount() - 2)) : 0.0f;
                int aS3 = aS(childAdapterPosition - 1);
                if (aS3 >= 0) {
                    if (aS3 == aS) {
                        m(view, B2);
                    } else {
                        float f4 = -this.Wl.get(aS, 0);
                        if (f4 != 0.0f) {
                            this.Wn = f4;
                            f = f4;
                        } else {
                            f = this.Wn;
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
        if (this.WM != null) {
            m(view, 0.0f);
            int aS = aS(this.WM.getChildAdapterPosition(view));
            if (aS >= 0 && b(aS, 0, true) == -1) {
                this.Wl.delete(aS);
                if (this.Wp.get(aS) != null) {
                    this.Wp.get(aS).cancel();
                }
                this.Wp.delete(aS);
                this.Wq.delete(aS);
            }
        }
    }

    private void qU() {
        int childCount = this.WM.getChildCount();
        this.WP.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.WM.getChildAt(i);
            int childAdapterPosition = this.WM.getChildAdapterPosition(childAt);
            int aS = aS(childAdapterPosition);
            if (aS >= 0 && !this.WP.contains(Integer.valueOf(aS))) {
                this.WP.add(Integer.valueOf(aS));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.WM.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.WM, i, f);
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
            return B(this.WM.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.WM.getChildAt(b(i - 1, i2, false)));
    }
}
