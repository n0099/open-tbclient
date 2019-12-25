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
    private i AH;
    private float AJ;
    private float AK;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean AM = false;
    private SparseIntArray AI = new SparseIntArray();
    private SparseArray<ValueAnimator> AN = new SparseArray<>();
    private SparseIntArray AO = new SparseIntArray();

    public h(i iVar) {
        this.AH = iVar;
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
            if (Math.abs(f2) < this.AH.kj()) {
                this.AM = true;
                jY();
                return;
            }
            this.mCurrentPosition = i;
            this.AM = false;
            if (Math.abs(f2) > this.AH.kf()) {
                f3 = f2 > 0.0f ? this.AH.kf() : -this.AH.kf();
            } else {
                f3 = f2;
            }
            this.AI.clear();
            float kb = f3 * this.AH.kb();
            if (f3 < 0.0f) {
                float kc = this.AH.kc();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = kb + (i3 * kc);
                    float f5 = kc * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float ka = (f4 / this.AH.ka()) + this.AI.get(i4);
                    if (Math.abs(ka) > this.AH.ke()) {
                        ka = -this.AH.ke();
                    }
                    this.AI.append(i4, (int) ka);
                    i3++;
                    kc = f5;
                }
                float kc2 = this.AH.kc();
                while (true) {
                    int i5 = i + i2;
                    float f6 = kb + (i2 * kc2);
                    float f7 = kc2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float jZ = (f6 / this.AH.jZ()) + this.AI.get(i5);
                        if (Math.abs(jZ) > this.AH.kd()) {
                            jZ = -this.AH.kd();
                        }
                        this.AI.append(i5, (int) jZ);
                        i2++;
                        kc2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float kc3 = this.AH.kc();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = kb - (i6 * kc3);
                    float f9 = kc3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float jZ2 = (f8 / this.AH.jZ()) + this.AI.get(i7);
                    if (Math.abs(jZ2) > this.AH.kd()) {
                        jZ2 = this.AH.kd();
                    }
                    this.AI.append(i7, (int) jZ2);
                    i6++;
                    kc3 = f9;
                }
                float kc4 = this.AH.kc();
                while (true) {
                    int i8 = i + i2;
                    float f10 = kb - (i2 * kc4);
                    float f11 = kc4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float ka2 = (f10 / this.AH.ka()) + this.AI.get(i8);
                        if (Math.abs(ka2) > this.AH.ke()) {
                            ka2 = this.AH.ke();
                        }
                        this.AI.append(i8, (int) ka2);
                        i2++;
                        kc4 = f11;
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
                this.AI.clear();
                jY();
            } else if (this.mScrollState == 2) {
                jY();
            } else if (this.mScrollState == 1) {
                this.AI.clear();
                jY();
            }
        }
    }

    public void i(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.AM) {
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
                    float z = z(view) + (this.AH.kh() * f);
                    if (z > (-this.AI.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.AH.kg() * f);
                    if (z2 > (-this.AI.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.AH.kh() * f);
                if (z3 < (-this.AI.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.AH.kg() * f);
                if (z4 < (-this.AI.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.AI.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.AJ = f;
                    } else {
                        f = this.AJ;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.AI.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.AK = f2;
                    } else {
                        f2 = this.AK;
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
            this.AI.delete(childAdapterPosition);
            if (this.AN.get(childAdapterPosition) != null) {
                this.AN.get(childAdapterPosition).cancel();
            }
            this.AN.delete(childAdapterPosition);
            this.AO.delete(childAdapterPosition);
        }
    }

    private void jY() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.AN.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.AH.kk());
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
                        h.this.AN.delete(i);
                        h.this.AO.delete(i);
                        h.this.AI.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        h.this.AN.delete(i);
                        h.this.AO.delete(i);
                        h.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.AN.append(i, ofFloat);
                this.AO.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.AO.get(i)) + this.AH.ki()) {
                this.AO.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
