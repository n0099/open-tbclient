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
    private i AN;
    private float AP;
    private float AQ;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean AR = false;
    private SparseIntArray AO = new SparseIntArray();
    private SparseArray<ValueAnimator> AU = new SparseArray<>();
    private SparseIntArray AV = new SparseIntArray();

    public h(i iVar) {
        this.AN = iVar;
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
            if (Math.abs(f2) < this.AN.kk()) {
                this.AR = true;
                jZ();
                return;
            }
            this.mCurrentPosition = i;
            this.AR = false;
            if (Math.abs(f2) > this.AN.kg()) {
                f3 = f2 > 0.0f ? this.AN.kg() : -this.AN.kg();
            } else {
                f3 = f2;
            }
            this.AO.clear();
            float kc = f3 * this.AN.kc();
            if (f3 < 0.0f) {
                float kd = this.AN.kd();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = kc + (i3 * kd);
                    float f5 = kd * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float kb = (f4 / this.AN.kb()) + this.AO.get(i4);
                    if (Math.abs(kb) > this.AN.kf()) {
                        kb = -this.AN.kf();
                    }
                    this.AO.append(i4, (int) kb);
                    i3++;
                    kd = f5;
                }
                float kd2 = this.AN.kd();
                while (true) {
                    int i5 = i + i2;
                    float f6 = kc + (i2 * kd2);
                    float f7 = kd2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float ka = (f6 / this.AN.ka()) + this.AO.get(i5);
                        if (Math.abs(ka) > this.AN.ke()) {
                            ka = -this.AN.ke();
                        }
                        this.AO.append(i5, (int) ka);
                        i2++;
                        kd2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float kd3 = this.AN.kd();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = kc - (i6 * kd3);
                    float f9 = kd3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float ka2 = (f8 / this.AN.ka()) + this.AO.get(i7);
                    if (Math.abs(ka2) > this.AN.ke()) {
                        ka2 = this.AN.ke();
                    }
                    this.AO.append(i7, (int) ka2);
                    i6++;
                    kd3 = f9;
                }
                float kd4 = this.AN.kd();
                while (true) {
                    int i8 = i + i2;
                    float f10 = kc - (i2 * kd4);
                    float f11 = kd4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float kb2 = (f10 / this.AN.kb()) + this.AO.get(i8);
                        if (Math.abs(kb2) > this.AN.kf()) {
                            kb2 = this.AN.kf();
                        }
                        this.AO.append(i8, (int) kb2);
                        i2++;
                        kd4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void am(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.AO.clear();
                jZ();
            } else if (this.mScrollState == 2) {
                jZ();
            } else if (this.mScrollState == 1) {
                this.AO.clear();
                jZ();
            }
        }
    }

    public void i(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.AR) {
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
                    float z = z(view) + (this.AN.ki() * f);
                    if (z > (-this.AO.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.AN.kh() * f);
                    if (z2 > (-this.AO.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.AN.ki() * f);
                if (z3 < (-this.AO.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.AN.kh() * f);
                if (z4 < (-this.AO.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.AO.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.AP = f;
                    } else {
                        f = this.AP;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.AO.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.AQ = f2;
                    } else {
                        f2 = this.AQ;
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
            this.AO.delete(childAdapterPosition);
            if (this.AU.get(childAdapterPosition) != null) {
                this.AU.get(childAdapterPosition).cancel();
            }
            this.AU.delete(childAdapterPosition);
            this.AV.delete(childAdapterPosition);
        }
    }

    private void jZ() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.AU.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.AN.kl());
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
                        h.this.AU.delete(i);
                        h.this.AV.delete(i);
                        h.this.AO.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.AU.delete(i);
                        h.this.AV.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.AU.append(i, ofFloat);
                this.AV.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.AV.get(i)) + this.AN.kj()) {
                this.AV.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
