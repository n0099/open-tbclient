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
    private i NK;
    private float NM;
    private float NN;
    private BdTypeRecyclerView Oo;
    private LinearLayoutManager Op;
    private int mOrientation;
    private int mScrollState;
    private boolean NP = false;
    private HashSet<Integer> Oq = new HashSet<>();
    private HashSet<Integer> Or = new HashSet<>();
    private SparseIntArray NL = new SparseIntArray();
    private SparseArray<ValueAnimator> NQ = new SparseArray<>();
    private SparseIntArray NR = new SparseIntArray();

    public l(i iVar) {
        this.NK = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Oo = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Op = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Oo != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.NK.ov()) {
                this.NP = true;
                ok();
                return;
            }
            this.NP = false;
            if (Math.abs(f2) > this.NK.or()) {
                f3 = f2 > 0.0f ? this.NK.or() : -this.NK.or();
            } else {
                f3 = f2;
            }
            this.NL.clear();
            float on = f3 * this.NK.on();
            int aR = aR(i);
            if (aR >= 0) {
                if (f3 < 0.0f) {
                    float oo = this.NK.oo();
                    int i3 = 1;
                    while (true) {
                        int i4 = aR - i3;
                        float f4 = on + (i3 * oo);
                        float f5 = oo * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float om = (f4 / this.NK.om()) + this.NL.get(i4);
                        if (Math.abs(om) > this.NK.oq()) {
                            om = -this.NK.oq();
                        }
                        this.NL.append(i4, (int) om);
                        i3++;
                        oo = f5;
                    }
                    float oo2 = this.NK.oo();
                    while (true) {
                        int i5 = aR + i2;
                        float f6 = on + (i2 * oo2);
                        float f7 = oo2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float ol = (f6 / this.NK.ol()) + this.NL.get(i5);
                            if (Math.abs(ol) > this.NK.op()) {
                                ol = -this.NK.op();
                            }
                            this.NL.append(i5, (int) ol);
                            i2++;
                            oo2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float oo3 = this.NK.oo();
                    int i6 = 1;
                    while (true) {
                        int i7 = aR - i6;
                        float f8 = on - (i6 * oo3);
                        float f9 = oo3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float ol2 = (f8 / this.NK.ol()) + this.NL.get(i7);
                        if (Math.abs(ol2) > this.NK.op()) {
                            ol2 = this.NK.op();
                        }
                        this.NL.append(i7, (int) ol2);
                        i6++;
                        oo3 = f9;
                    }
                    float oo4 = this.NK.oo();
                    while (true) {
                        int i8 = aR + i2;
                        float f10 = on - (i2 * oo4);
                        float f11 = oo4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float om2 = (f10 / this.NK.om()) + this.NL.get(i8);
                            if (Math.abs(om2) > this.NK.oq()) {
                                om2 = this.NK.oq();
                            }
                            this.NL.append(i8, (int) om2);
                            i2++;
                            oo4 = f11;
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
            m item = this.Oo.getItem(i - this.Oo.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void k(int i, int i2, int i3) {
        int aR;
        int aR2;
        if (this.Oo != null && this.Op != null && this.mScrollState == 1 && !this.NP) {
            int findFirstVisibleItemPosition = i3 - this.Op.findFirstVisibleItemPosition();
            int aR3 = aR(i3);
            if (aR3 >= 0) {
                this.Oq.add(Integer.valueOf(aR3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Oo.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Oo.getChildAt(i5);
                    int childAdapterPosition = this.Oo.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aR2 = aR(childAdapterPosition)) >= 0 && !this.Oq.contains(Integer.valueOf(aR2))) {
                        this.Oq.add(Integer.valueOf(aR2));
                        a(childAt, i4, childAdapterPosition, i3, aR2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Oo.getChildAt(i7);
                        int childAdapterPosition2 = this.Oo.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aR = aR(childAdapterPosition2)) >= 0 && !this.Oq.contains(Integer.valueOf(aR))) {
                            this.Oq.add(Integer.valueOf(aR));
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
                    float E = E(view) + (i * this.NK.ot());
                    if (E > c(i4, i2, true) + (-this.NL.get(i4))) {
                        a(view, i2, E);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float E2 = E(view) + (i * this.NK.os());
                    if (E2 > c(i4, i2, false) + (-this.NL.get(i4))) {
                        a(view, i2, E2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float E3 = E(view) + (i * this.NK.ot());
                if (E3 < c(i4, i2, false) + (-this.NL.get(i4))) {
                    a(view, i2, E3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float E4 = E(view) + (i * this.NK.os());
                if (E4 < c(i4, i2, true) + (-this.NL.get(i4))) {
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
            ValueAnimator valueAnimator = this.NQ.get(aR);
            if (valueAnimator == null) {
                if (Math.abs(E(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(E(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.NK.ow());
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
                        l.this.NQ.delete(aR);
                        l.this.NR.delete(aR);
                        l.this.NL.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.NQ.delete(aR);
                        l.this.NR.delete(aR);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.NQ.append(aR, ofFloat);
                this.NR.append(aR, (int) E(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float E = E(view);
            if (Math.abs(E) > Math.abs(this.NR.get(aR)) + this.NK.ou()) {
                this.NR.append(aR, (int) E);
                valueAnimator.setFloatValues(E, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aP(int i) {
        if (this.Oo != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.NL.clear();
                ok();
            } else if (this.mScrollState == 2) {
                ok();
            } else if (this.mScrollState == 1) {
                this.NL.clear();
                ok();
            }
        }
    }

    public void F(View view) {
        int childAdapterPosition;
        int aR;
        float f;
        float f2;
        if (this.Oo != null && this.Op != null && this.mScrollState != 0 && (aR = aR((childAdapterPosition = this.Oo.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Op.findFirstVisibleItemPosition()) {
                float E = this.Oo.getChildAt(1) != null ? E(this.Oo.getChildAt(1)) : 0.0f;
                int aR2 = aR(childAdapterPosition + 1);
                if (aR2 >= 0) {
                    if (aR2 == aR) {
                        m(view, E);
                    } else {
                        float f3 = -this.NL.get(aR, 0);
                        if (f3 != 0.0f) {
                            this.NM = f3;
                            f2 = f3;
                        } else {
                            f2 = this.NM;
                        }
                        m(view, E + f2);
                    }
                } else {
                    return;
                }
            } else {
                float E2 = this.Oo.getChildAt(this.Oo.getChildCount() + (-2)) != null ? E(this.Oo.getChildAt(this.Oo.getChildCount() - 2)) : 0.0f;
                int aR3 = aR(childAdapterPosition - 1);
                if (aR3 >= 0) {
                    if (aR3 == aR) {
                        m(view, E2);
                    } else {
                        float f4 = -this.NL.get(aR, 0);
                        if (f4 != 0.0f) {
                            this.NN = f4;
                            f = f4;
                        } else {
                            f = this.NN;
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
        if (this.Oo != null) {
            m(view, 0.0f);
            int aR = aR(this.Oo.getChildAdapterPosition(view));
            if (aR >= 0 && b(aR, 0, true) == -1) {
                this.NL.delete(aR);
                if (this.NQ.get(aR) != null) {
                    this.NQ.get(aR).cancel();
                }
                this.NQ.delete(aR);
                this.NR.delete(aR);
            }
        }
    }

    private void ok() {
        int childCount = this.Oo.getChildCount();
        this.Or.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Oo.getChildAt(i);
            int childAdapterPosition = this.Oo.getChildAdapterPosition(childAt);
            int aR = aR(childAdapterPosition);
            if (aR >= 0 && !this.Or.contains(Integer.valueOf(aR))) {
                this.Or.add(Integer.valueOf(aR));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Oo.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.Oo, i, f);
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
            return E(this.Oo.getChildAt(b(i + 1, i2, true)));
        }
        return E(this.Oo.getChildAt(b(i - 1, i2, false)));
    }
}
