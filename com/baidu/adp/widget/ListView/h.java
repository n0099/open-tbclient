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
    private i Uw;
    private float Uy;
    private float Uz;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean UB = false;
    private SparseIntArray Ux = new SparseIntArray();
    private SparseArray<ValueAnimator> UC = new SparseArray<>();
    private SparseIntArray UD = new SparseIntArray();

    public h(i iVar) {
        this.Uw = iVar;
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
            if (Math.abs(f2) < this.Uw.pd()) {
                this.UB = true;
                oS();
                return;
            }
            this.mCurrentPosition = i;
            this.UB = false;
            if (Math.abs(f2) > this.Uw.oZ()) {
                f3 = f2 > 0.0f ? this.Uw.oZ() : -this.Uw.oZ();
            } else {
                f3 = f2;
            }
            this.Ux.clear();
            float oV = f3 * this.Uw.oV();
            if (f3 < 0.0f) {
                float oW = this.Uw.oW();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = oV + (i3 * oW);
                    float f5 = oW * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float oU = (f4 / this.Uw.oU()) + this.Ux.get(i4);
                    if (Math.abs(oU) > this.Uw.oY()) {
                        oU = -this.Uw.oY();
                    }
                    this.Ux.append(i4, (int) oU);
                    i3++;
                    oW = f5;
                }
                float oW2 = this.Uw.oW();
                while (true) {
                    int i5 = i + i2;
                    float f6 = oV + (i2 * oW2);
                    float f7 = oW2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float oT = (f6 / this.Uw.oT()) + this.Ux.get(i5);
                        if (Math.abs(oT) > this.Uw.oX()) {
                            oT = -this.Uw.oX();
                        }
                        this.Ux.append(i5, (int) oT);
                        i2++;
                        oW2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float oW3 = this.Uw.oW();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = oV - (i6 * oW3);
                    float f9 = oW3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float oT2 = (f8 / this.Uw.oT()) + this.Ux.get(i7);
                    if (Math.abs(oT2) > this.Uw.oX()) {
                        oT2 = this.Uw.oX();
                    }
                    this.Ux.append(i7, (int) oT2);
                    i6++;
                    oW3 = f9;
                }
                float oW4 = this.Uw.oW();
                while (true) {
                    int i8 = i + i2;
                    float f10 = oV - (i2 * oW4);
                    float f11 = oW4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float oU2 = (f10 / this.Uw.oU()) + this.Ux.get(i8);
                        if (Math.abs(oU2) > this.Uw.oY()) {
                            oU2 = this.Uw.oY();
                        }
                        this.Ux.append(i8, (int) oU2);
                        i2++;
                        oW4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aB(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Ux.clear();
                oS();
            } else if (this.mScrollState == 2) {
                oS();
            } else if (this.mScrollState == 1) {
                this.Ux.clear();
                oS();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.UB) {
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
                    float z = z(view) + (this.Uw.pb() * f);
                    if (z > (-this.Ux.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.Uw.pa() * f);
                    if (z2 > (-this.Ux.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.Uw.pb() * f);
                if (z3 < (-this.Ux.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.Uw.pa() * f);
                if (z4 < (-this.Ux.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.Ux.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Uy = f;
                    } else {
                        f = this.Uy;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Ux.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Uz = f2;
                    } else {
                        f2 = this.Uz;
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
            this.Ux.delete(childAdapterPosition);
            if (this.UC.get(childAdapterPosition) != null) {
                this.UC.get(childAdapterPosition).cancel();
            }
            this.UC.delete(childAdapterPosition);
            this.UD.delete(childAdapterPosition);
        }
    }

    private void oS() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.UC.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Uw.pe());
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
                        h.this.UC.delete(i);
                        h.this.UD.delete(i);
                        h.this.Ux.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.UC.delete(i);
                        h.this.UD.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.UC.append(i, ofFloat);
                this.UD.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.UD.get(i)) + this.Uw.pc()) {
                this.UD.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
