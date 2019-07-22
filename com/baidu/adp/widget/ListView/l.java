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
    private i NJ;
    private float NL;
    private float NM;
    private BdTypeRecyclerView Op;
    private LinearLayoutManager Oq;
    private int mOrientation;
    private int mScrollState;
    private boolean NN = false;
    private HashSet<Integer> Or = new HashSet<>();
    private HashSet<Integer> Os = new HashSet<>();
    private SparseIntArray NK = new SparseIntArray();
    private SparseArray<ValueAnimator> NP = new SparseArray<>();
    private SparseIntArray NQ = new SparseIntArray();

    public l(i iVar) {
        this.NJ = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Op = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Oq = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Op != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.NJ.ou()) {
                this.NN = true;
                oj();
                return;
            }
            this.NN = false;
            if (Math.abs(f2) > this.NJ.oq()) {
                f3 = f2 > 0.0f ? this.NJ.oq() : -this.NJ.oq();
            } else {
                f3 = f2;
            }
            this.NK.clear();
            float om = f3 * this.NJ.om();
            int aR = aR(i);
            if (aR >= 0) {
                if (f3 < 0.0f) {
                    float on = this.NJ.on();
                    int i3 = 1;
                    while (true) {
                        int i4 = aR - i3;
                        float f4 = om + (i3 * on);
                        float f5 = on * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float ol = (f4 / this.NJ.ol()) + this.NK.get(i4);
                        if (Math.abs(ol) > this.NJ.op()) {
                            ol = -this.NJ.op();
                        }
                        this.NK.append(i4, (int) ol);
                        i3++;
                        on = f5;
                    }
                    float on2 = this.NJ.on();
                    while (true) {
                        int i5 = aR + i2;
                        float f6 = om + (i2 * on2);
                        float f7 = on2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float ok = (f6 / this.NJ.ok()) + this.NK.get(i5);
                            if (Math.abs(ok) > this.NJ.oo()) {
                                ok = -this.NJ.oo();
                            }
                            this.NK.append(i5, (int) ok);
                            i2++;
                            on2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float on3 = this.NJ.on();
                    int i6 = 1;
                    while (true) {
                        int i7 = aR - i6;
                        float f8 = om - (i6 * on3);
                        float f9 = on3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float ok2 = (f8 / this.NJ.ok()) + this.NK.get(i7);
                        if (Math.abs(ok2) > this.NJ.oo()) {
                            ok2 = this.NJ.oo();
                        }
                        this.NK.append(i7, (int) ok2);
                        i6++;
                        on3 = f9;
                    }
                    float on4 = this.NJ.on();
                    while (true) {
                        int i8 = aR + i2;
                        float f10 = om - (i2 * on4);
                        float f11 = on4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float ol2 = (f10 / this.NJ.ol()) + this.NK.get(i8);
                            if (Math.abs(ol2) > this.NJ.op()) {
                                ol2 = this.NJ.op();
                            }
                            this.NK.append(i8, (int) ol2);
                            i2++;
                            on4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aR(int i) {
        if (i > 0) {
            m item = this.Op.getItem(i - this.Op.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void k(int i, int i2, int i3) {
        int aR;
        int aR2;
        if (this.Op != null && this.Oq != null && this.mScrollState == 1 && !this.NN) {
            int findFirstVisibleItemPosition = i3 - this.Oq.findFirstVisibleItemPosition();
            int aR3 = aR(i3);
            if (aR3 >= 0) {
                this.Or.add(Integer.valueOf(aR3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Op.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Op.getChildAt(i5);
                    int childAdapterPosition = this.Op.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aR2 = aR(childAdapterPosition)) >= 0 && !this.Or.contains(Integer.valueOf(aR2))) {
                        this.Or.add(Integer.valueOf(aR2));
                        a(childAt, i4, childAdapterPosition, i3, aR2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Op.getChildAt(i7);
                        int childAdapterPosition2 = this.Op.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aR = aR(childAdapterPosition2)) >= 0 && !this.Or.contains(Integer.valueOf(aR))) {
                            this.Or.add(Integer.valueOf(aR));
                            a(childAt2, i4, childAdapterPosition2, i3, aR);
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
                    float E = E(view) + (i * this.NJ.os());
                    if (E > c(i4, i2, true) + (-this.NK.get(i4))) {
                        a(view, i2, E);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float E2 = E(view) + (i * this.NJ.or());
                    if (E2 > c(i4, i2, false) + (-this.NK.get(i4))) {
                        a(view, i2, E2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float E3 = E(view) + (i * this.NJ.os());
                if (E3 < c(i4, i2, false) + (-this.NK.get(i4))) {
                    a(view, i2, E3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float E4 = E(view) + (i * this.NJ.or());
                if (E4 < c(i4, i2, true) + (-this.NK.get(i4))) {
                    a(view, i2, E4);
                } else {
                    e(view, i2);
                }
            }
        }
    }

    private void e(final View view, final int i) {
        final int aR;
        if (view != null && (aR = aR(i)) >= 0) {
            ValueAnimator valueAnimator = this.NP.get(aR);
            if (valueAnimator == null) {
                if (Math.abs(E(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(E(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.NJ.ov());
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
                        l.this.NP.delete(aR);
                        l.this.NQ.delete(aR);
                        l.this.NK.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.NP.delete(aR);
                        l.this.NQ.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.NP.append(aR, ofFloat);
                this.NQ.append(aR, (int) E(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float E = E(view);
            if (Math.abs(E) > Math.abs(this.NQ.get(aR)) + this.NJ.ot()) {
                this.NQ.append(aR, (int) E);
                valueAnimator.setFloatValues(E, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aP(int i) {
        if (this.Op != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.NK.clear();
                oj();
            } else if (this.mScrollState == 2) {
                oj();
            } else if (this.mScrollState == 1) {
                this.NK.clear();
                oj();
            }
        }
    }

    public void F(View view) {
        int childAdapterPosition;
        int aR;
        float f;
        float f2;
        if (this.Op != null && this.Oq != null && this.mScrollState != 0 && (aR = aR((childAdapterPosition = this.Op.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Oq.findFirstVisibleItemPosition()) {
                float E = this.Op.getChildAt(1) != null ? E(this.Op.getChildAt(1)) : 0.0f;
                int aR2 = aR(childAdapterPosition + 1);
                if (aR2 >= 0) {
                    if (aR2 == aR) {
                        m(view, E);
                    } else {
                        float f3 = -this.NK.get(aR, 0);
                        if (f3 != 0.0f) {
                            this.NL = f3;
                            f2 = f3;
                        } else {
                            f2 = this.NL;
                        }
                        m(view, E + f2);
                    }
                } else {
                    return;
                }
            } else {
                float E2 = this.Op.getChildAt(this.Op.getChildCount() + (-2)) != null ? E(this.Op.getChildAt(this.Op.getChildCount() - 2)) : 0.0f;
                int aR3 = aR(childAdapterPosition - 1);
                if (aR3 >= 0) {
                    if (aR3 == aR) {
                        m(view, E2);
                    } else {
                        float f4 = -this.NK.get(aR, 0);
                        if (f4 != 0.0f) {
                            this.NM = f4;
                            f = f4;
                        } else {
                            f = this.NM;
                        }
                        m(view, E2 + f);
                    }
                } else {
                    return;
                }
            }
            e(view, childAdapterPosition);
        }
    }

    public void G(View view) {
        if (this.Op != null) {
            m(view, 0.0f);
            int aR = aR(this.Op.getChildAdapterPosition(view));
            if (aR >= 0 && b(aR, 0, true) == -1) {
                this.NK.delete(aR);
                if (this.NP.get(aR) != null) {
                    this.NP.get(aR).cancel();
                }
                this.NP.delete(aR);
                this.NQ.delete(aR);
            }
        }
    }

    private void oj() {
        int childCount = this.Op.getChildCount();
        this.Os.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Op.getChildAt(i);
            int childAdapterPosition = this.Op.getChildAdapterPosition(childAt);
            int aR = aR(childAdapterPosition);
            if (aR >= 0 && !this.Os.contains(Integer.valueOf(aR))) {
                this.Os.add(Integer.valueOf(aR));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Op.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aR(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aR(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Op, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float E(View view) {
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
            return E(this.Op.getChildAt(b(i + 1, i2, true)));
        }
        return E(this.Op.getChildAt(b(i - 1, i2, false)));
    }
}
