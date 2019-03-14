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
    private i PK;
    private float PN;
    private float PO;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean PP = false;
    private SparseIntArray PM = new SparseIntArray();
    private SparseArray<ValueAnimator> PQ = new SparseArray<>();
    private SparseIntArray PR = new SparseIntArray();

    public h(i iVar) {
        this.PK = iVar;
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
            if (Math.abs(f2) < this.PK.pe()) {
                this.PP = true;
                oT();
                return;
            }
            this.mCurrentPosition = i;
            this.PP = false;
            if (Math.abs(f2) > this.PK.pa()) {
                f3 = f2 > 0.0f ? this.PK.pa() : -this.PK.pa();
            } else {
                f3 = f2;
            }
            this.PM.clear();
            float oW = f3 * this.PK.oW();
            if (f3 < 0.0f) {
                float oX = this.PK.oX();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = oW + (i3 * oX);
                    float f5 = oX * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float oV = (f4 / this.PK.oV()) + this.PM.get(i4);
                    if (Math.abs(oV) > this.PK.oZ()) {
                        oV = -this.PK.oZ();
                    }
                    this.PM.append(i4, (int) oV);
                    i3++;
                    oX = f5;
                }
                float oX2 = this.PK.oX();
                while (true) {
                    int i5 = i + i2;
                    float f6 = oW + (i2 * oX2);
                    float f7 = oX2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float oU = (f6 / this.PK.oU()) + this.PM.get(i5);
                        if (Math.abs(oU) > this.PK.oY()) {
                            oU = -this.PK.oY();
                        }
                        this.PM.append(i5, (int) oU);
                        i2++;
                        oX2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float oX3 = this.PK.oX();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = oW - (i6 * oX3);
                    float f9 = oX3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float oU2 = (f8 / this.PK.oU()) + this.PM.get(i7);
                    if (Math.abs(oU2) > this.PK.oY()) {
                        oU2 = this.PK.oY();
                    }
                    this.PM.append(i7, (int) oU2);
                    i6++;
                    oX3 = f9;
                }
                float oX4 = this.PK.oX();
                while (true) {
                    int i8 = i + i2;
                    float f10 = oW - (i2 * oX4);
                    float f11 = oX4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float oV2 = (f10 / this.PK.oV()) + this.PM.get(i8);
                        if (Math.abs(oV2) > this.PK.oZ()) {
                            oV2 = this.PK.oZ();
                        }
                        this.PM.append(i8, (int) oV2);
                        i2++;
                        oX4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aX(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.PM.clear();
                oT();
            } else if (this.mScrollState == 2) {
                oT();
            } else if (this.mScrollState == 1) {
                this.PM.clear();
                oT();
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.PP) {
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
                    float C = C(view) + (this.PK.pc() * f);
                    if (C > (-this.PM.get(i)) + C(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, C);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float C2 = C(view) + (this.PK.pb() * f);
                    if (C2 > (-this.PM.get(i)) + C(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, C2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float C3 = C(view) + (this.PK.pc() * f);
                if (C3 < (-this.PM.get(i)) + C(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, C3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float C4 = C(view) + (this.PK.pb() * f);
                if (C4 < (-this.PM.get(i)) + C(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.PM.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.PN = f;
                    } else {
                        f = this.PN;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? C(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.PM.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.PO = f2;
                    } else {
                        f2 = this.PO;
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
            this.PM.delete(childAdapterPosition);
            if (this.PQ.get(childAdapterPosition) != null) {
                this.PQ.get(childAdapterPosition).cancel();
            }
            this.PQ.delete(childAdapterPosition);
            this.PR.delete(childAdapterPosition);
        }
    }

    private void oT() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.PQ.get(i);
            if (valueAnimator == null) {
                if (Math.abs(C(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(C(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.PK.pf());
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
                        h.this.PQ.delete(i);
                        h.this.PR.delete(i);
                        h.this.PM.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.PQ.delete(i);
                        h.this.PR.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.PQ.append(i, ofFloat);
                this.PR.append(i, (int) C(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float C = C(view);
            if (Math.abs(C) > Math.abs(this.PR.get(i)) + this.PK.pd()) {
                this.PR.append(i, (int) C);
                valueAnimator.setFloatValues(C, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
