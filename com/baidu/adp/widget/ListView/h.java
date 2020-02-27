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
    private i Bh;
    private float Bj;
    private float Bk;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Bl = false;
    private SparseIntArray Bi = new SparseIntArray();
    private SparseArray<ValueAnimator> Bm = new SparseArray<>();
    private SparseIntArray Bn = new SparseIntArray();

    public h(i iVar) {
        this.Bh = iVar;
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
            if (Math.abs(f2) < this.Bh.kz()) {
                this.Bl = true;
                ko();
                return;
            }
            this.mCurrentPosition = i;
            this.Bl = false;
            if (Math.abs(f2) > this.Bh.kv()) {
                f3 = f2 > 0.0f ? this.Bh.kv() : -this.Bh.kv();
            } else {
                f3 = f2;
            }
            this.Bi.clear();
            float kr = f3 * this.Bh.kr();
            if (f3 < 0.0f) {
                float ks = this.Bh.ks();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = kr + (i3 * ks);
                    float f5 = ks * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float kq = (f4 / this.Bh.kq()) + this.Bi.get(i4);
                    if (Math.abs(kq) > this.Bh.ku()) {
                        kq = -this.Bh.ku();
                    }
                    this.Bi.append(i4, (int) kq);
                    i3++;
                    ks = f5;
                }
                float ks2 = this.Bh.ks();
                while (true) {
                    int i5 = i + i2;
                    float f6 = kr + (i2 * ks2);
                    float f7 = ks2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float kp = (f6 / this.Bh.kp()) + this.Bi.get(i5);
                        if (Math.abs(kp) > this.Bh.kt()) {
                            kp = -this.Bh.kt();
                        }
                        this.Bi.append(i5, (int) kp);
                        i2++;
                        ks2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float ks3 = this.Bh.ks();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = kr - (i6 * ks3);
                    float f9 = ks3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float kp2 = (f8 / this.Bh.kp()) + this.Bi.get(i7);
                    if (Math.abs(kp2) > this.Bh.kt()) {
                        kp2 = this.Bh.kt();
                    }
                    this.Bi.append(i7, (int) kp2);
                    i6++;
                    ks3 = f9;
                }
                float ks4 = this.Bh.ks();
                while (true) {
                    int i8 = i + i2;
                    float f10 = kr - (i2 * ks4);
                    float f11 = ks4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float kq2 = (f10 / this.Bh.kq()) + this.Bi.get(i8);
                        if (Math.abs(kq2) > this.Bh.ku()) {
                            kq2 = this.Bh.ku();
                        }
                        this.Bi.append(i8, (int) kq2);
                        i2++;
                        ks4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void ap(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Bi.clear();
                ko();
            } else if (this.mScrollState == 2) {
                ko();
            } else if (this.mScrollState == 1) {
                this.Bi.clear();
                ko();
            }
        }
    }

    public void i(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Bl) {
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
                    float z = z(view) + (this.Bh.kx() * f);
                    if (z > (-this.Bi.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.Bh.kw() * f);
                    if (z2 > (-this.Bi.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.Bh.kx() * f);
                if (z3 < (-this.Bi.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.Bh.kw() * f);
                if (z4 < (-this.Bi.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.Bi.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Bj = f;
                    } else {
                        f = this.Bj;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Bi.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Bk = f2;
                    } else {
                        f2 = this.Bk;
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
            this.Bi.delete(childAdapterPosition);
            if (this.Bm.get(childAdapterPosition) != null) {
                this.Bm.get(childAdapterPosition).cancel();
            }
            this.Bm.delete(childAdapterPosition);
            this.Bn.delete(childAdapterPosition);
        }
    }

    private void ko() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.Bm.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Bh.kA());
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
                        h.this.Bm.delete(i);
                        h.this.Bn.delete(i);
                        h.this.Bi.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.Bm.delete(i);
                        h.this.Bn.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Bm.append(i, ofFloat);
                this.Bn.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.Bn.get(i)) + this.Bh.ky()) {
                this.Bn.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
