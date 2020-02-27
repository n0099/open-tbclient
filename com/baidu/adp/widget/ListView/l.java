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
    private BdTypeRecyclerView BK;
    private LinearLayoutManager BL;
    private i Bh;
    private float Bj;
    private float Bk;
    private int mOrientation;
    private int mScrollState;
    private boolean Bl = false;
    private HashSet<Integer> BM = new HashSet<>();
    private HashSet<Integer> BN = new HashSet<>();
    private SparseIntArray Bi = new SparseIntArray();
    private SparseArray<ValueAnimator> Bm = new SparseArray<>();
    private SparseIntArray Bn = new SparseIntArray();

    public l(i iVar) {
        this.Bh = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.BK = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.BL = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.BK != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Bh.kz()) {
                this.Bl = true;
                ko();
                return;
            }
            this.Bl = false;
            if (Math.abs(f2) > this.Bh.kv()) {
                f3 = f2 > 0.0f ? this.Bh.kv() : -this.Bh.kv();
            } else {
                f3 = f2;
            }
            this.Bi.clear();
            float kr = f3 * this.Bh.kr();
            int ar = ar(i);
            if (ar >= 0) {
                if (f3 < 0.0f) {
                    float ks = this.Bh.ks();
                    int i3 = 1;
                    while (true) {
                        int i4 = ar - i3;
                        float f4 = kr + (i3 * ks);
                        float f5 = ks * 1.2f;
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
                        int i5 = ar + i2;
                        float f6 = kr + (i2 * ks2);
                        float f7 = ks2 * 1.2f;
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
                        int i7 = ar - i6;
                        float f8 = kr - (i6 * ks3);
                        float f9 = ks3 * 1.2f;
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
                        int i8 = ar + i2;
                        float f10 = kr - (i2 * ks4);
                        float f11 = ks4 * 1.2f;
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
    }

    private int ar(int i) {
        if (i > 0) {
            m item = this.BK.getItem(i - this.BK.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void i(int i, int i2, int i3) {
        int ar;
        int ar2;
        if (this.BK != null && this.BL != null && this.mScrollState == 1 && !this.Bl) {
            int findFirstVisibleItemPosition = i3 - this.BL.findFirstVisibleItemPosition();
            int ar3 = ar(i3);
            if (ar3 >= 0) {
                this.BM.add(Integer.valueOf(ar3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.BK.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.BK.getChildAt(i5);
                    int childAdapterPosition = this.BK.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (ar2 = ar(childAdapterPosition)) >= 0 && !this.BM.contains(Integer.valueOf(ar2))) {
                        this.BM.add(Integer.valueOf(ar2));
                        a(childAt, i4, childAdapterPosition, i3, ar2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.BK.getChildAt(i7);
                        int childAdapterPosition2 = this.BK.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (ar = ar(childAdapterPosition2)) >= 0 && !this.BM.contains(Integer.valueOf(ar))) {
                            this.BM.add(Integer.valueOf(ar));
                            a(childAt2, i4, childAdapterPosition2, i3, ar);
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
                    float z = z(view) + (i * this.Bh.kx());
                    if (z > c(i4, i2, true) + (-this.Bi.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.Bh.kw());
                    if (z2 > c(i4, i2, false) + (-this.Bi.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.Bh.kx());
                if (z3 < c(i4, i2, false) + (-this.Bi.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.Bh.kw());
                if (z4 < c(i4, i2, true) + (-this.Bi.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int ar;
        if (view != null && (ar = ar(i)) >= 0) {
            ValueAnimator valueAnimator = this.Bm.get(ar);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Bh.kA());
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
                        l.this.Bm.delete(ar);
                        l.this.Bn.delete(ar);
                        l.this.Bi.delete(ar);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.Bm.delete(ar);
                        l.this.Bn.delete(ar);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Bm.append(ar, ofFloat);
                this.Bn.append(ar, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.Bn.get(ar)) + this.Bh.ky()) {
                this.Bn.append(ar, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void ap(int i) {
        if (this.BK != null) {
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

    public void A(View view) {
        int childAdapterPosition;
        int ar;
        float f;
        float f2;
        if (this.BK != null && this.BL != null && this.mScrollState != 0 && (ar = ar((childAdapterPosition = this.BK.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.BL.findFirstVisibleItemPosition()) {
                float z = this.BK.getChildAt(1) != null ? z(this.BK.getChildAt(1)) : 0.0f;
                int ar2 = ar(childAdapterPosition + 1);
                if (ar2 >= 0) {
                    if (ar2 == ar) {
                        m(view, z);
                    } else {
                        float f3 = -this.Bi.get(ar, 0);
                        if (f3 != 0.0f) {
                            this.Bj = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Bj;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.BK.getChildAt(this.BK.getChildCount() + (-2)) != null ? z(this.BK.getChildAt(this.BK.getChildCount() - 2)) : 0.0f;
                int ar3 = ar(childAdapterPosition - 1);
                if (ar3 >= 0) {
                    if (ar3 == ar) {
                        m(view, z2);
                    } else {
                        float f4 = -this.Bi.get(ar, 0);
                        if (f4 != 0.0f) {
                            this.Bk = f4;
                            f = f4;
                        } else {
                            f = this.Bk;
                        }
                        m(view, z2 + f);
                    }
                } else {
                    return;
                }
            }
            c(view, childAdapterPosition);
        }
    }

    public void B(View view) {
        if (this.BK != null) {
            m(view, 0.0f);
            int ar = ar(this.BK.getChildAdapterPosition(view));
            if (ar >= 0 && b(ar, 0, true) == -1) {
                this.Bi.delete(ar);
                if (this.Bm.get(ar) != null) {
                    this.Bm.get(ar).cancel();
                }
                this.Bm.delete(ar);
                this.Bn.delete(ar);
            }
        }
    }

    private void ko() {
        int childCount = this.BK.getChildCount();
        this.BN.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.BK.getChildAt(i);
            int childAdapterPosition = this.BK.getChildAdapterPosition(childAt);
            int ar = ar(childAdapterPosition);
            if (ar >= 0 && !this.BN.contains(Integer.valueOf(ar))) {
                this.BN.add(Integer.valueOf(ar));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.BK.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == ar(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == ar(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.BK, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float z(View view) {
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
            return z(this.BK.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.BK.getChildAt(b(i - 1, i2, false)));
    }
}
