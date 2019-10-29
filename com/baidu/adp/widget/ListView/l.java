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
    private int mOrientation;
    private int mScrollState;
    private i yH;
    private float yJ;
    private float yK;
    private BdTypeRecyclerView zj;
    private LinearLayoutManager zk;
    private boolean yL = false;
    private HashSet<Integer> zl = new HashSet<>();
    private HashSet<Integer> zm = new HashSet<>();
    private SparseIntArray yI = new SparseIntArray();
    private SparseArray<ValueAnimator> yM = new SparseArray<>();
    private SparseIntArray yN = new SparseIntArray();

    public l(i iVar) {
        this.yH = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.zj = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.zk = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.zj != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.yH.jS()) {
                this.yL = true;
                jH();
                return;
            }
            this.yL = false;
            if (Math.abs(f2) > this.yH.jO()) {
                f3 = f2 > 0.0f ? this.yH.jO() : -this.yH.jO();
            } else {
                f3 = f2;
            }
            this.yI.clear();
            float jK = f3 * this.yH.jK();
            int al = al(i);
            if (al >= 0) {
                if (f3 < 0.0f) {
                    float jL = this.yH.jL();
                    int i3 = 1;
                    while (true) {
                        int i4 = al - i3;
                        float f4 = jK + (i3 * jL);
                        float f5 = jL * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float jJ = (f4 / this.yH.jJ()) + this.yI.get(i4);
                        if (Math.abs(jJ) > this.yH.jN()) {
                            jJ = -this.yH.jN();
                        }
                        this.yI.append(i4, (int) jJ);
                        i3++;
                        jL = f5;
                    }
                    float jL2 = this.yH.jL();
                    while (true) {
                        int i5 = al + i2;
                        float f6 = jK + (i2 * jL2);
                        float f7 = jL2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float jI = (f6 / this.yH.jI()) + this.yI.get(i5);
                            if (Math.abs(jI) > this.yH.jM()) {
                                jI = -this.yH.jM();
                            }
                            this.yI.append(i5, (int) jI);
                            i2++;
                            jL2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float jL3 = this.yH.jL();
                    int i6 = 1;
                    while (true) {
                        int i7 = al - i6;
                        float f8 = jK - (i6 * jL3);
                        float f9 = jL3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float jI2 = (f8 / this.yH.jI()) + this.yI.get(i7);
                        if (Math.abs(jI2) > this.yH.jM()) {
                            jI2 = this.yH.jM();
                        }
                        this.yI.append(i7, (int) jI2);
                        i6++;
                        jL3 = f9;
                    }
                    float jL4 = this.yH.jL();
                    while (true) {
                        int i8 = al + i2;
                        float f10 = jK - (i2 * jL4);
                        float f11 = jL4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float jJ2 = (f10 / this.yH.jJ()) + this.yI.get(i8);
                            if (Math.abs(jJ2) > this.yH.jN()) {
                                jJ2 = this.yH.jN();
                            }
                            this.yI.append(i8, (int) jJ2);
                            i2++;
                            jL4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int al(int i) {
        if (i > 0) {
            m item = this.zj.getItem(i - this.zj.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void i(int i, int i2, int i3) {
        int al;
        int al2;
        if (this.zj != null && this.zk != null && this.mScrollState == 1 && !this.yL) {
            int findFirstVisibleItemPosition = i3 - this.zk.findFirstVisibleItemPosition();
            int al3 = al(i3);
            if (al3 >= 0) {
                this.zl.add(Integer.valueOf(al3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.zj.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.zj.getChildAt(i5);
                    int childAdapterPosition = this.zj.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (al2 = al(childAdapterPosition)) >= 0 && !this.zl.contains(Integer.valueOf(al2))) {
                        this.zl.add(Integer.valueOf(al2));
                        a(childAt, i4, childAdapterPosition, i3, al2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.zj.getChildAt(i7);
                        int childAdapterPosition2 = this.zj.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (al = al(childAdapterPosition2)) >= 0 && !this.zl.contains(Integer.valueOf(al))) {
                            this.zl.add(Integer.valueOf(al));
                            a(childAt2, i4, childAdapterPosition2, i3, al);
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
                    float z = z(view) + (i * this.yH.jQ());
                    if (z > c(i4, i2, true) + (-this.yI.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.yH.jP());
                    if (z2 > c(i4, i2, false) + (-this.yI.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.yH.jQ());
                if (z3 < c(i4, i2, false) + (-this.yI.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.yH.jP());
                if (z4 < c(i4, i2, true) + (-this.yI.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int al;
        if (view != null && (al = al(i)) >= 0) {
            ValueAnimator valueAnimator = this.yM.get(al);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.yH.jT());
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
                        l.this.yM.delete(al);
                        l.this.yN.delete(al);
                        l.this.yI.delete(al);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.yM.delete(al);
                        l.this.yN.delete(al);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.yM.append(al, ofFloat);
                this.yN.append(al, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.yN.get(al)) + this.yH.jR()) {
                this.yN.append(al, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aj(int i) {
        if (this.zj != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.yI.clear();
                jH();
            } else if (this.mScrollState == 2) {
                jH();
            } else if (this.mScrollState == 1) {
                this.yI.clear();
                jH();
            }
        }
    }

    public void A(View view) {
        int childAdapterPosition;
        int al;
        float f;
        float f2;
        if (this.zj != null && this.zk != null && this.mScrollState != 0 && (al = al((childAdapterPosition = this.zj.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.zk.findFirstVisibleItemPosition()) {
                float z = this.zj.getChildAt(1) != null ? z(this.zj.getChildAt(1)) : 0.0f;
                int al2 = al(childAdapterPosition + 1);
                if (al2 >= 0) {
                    if (al2 == al) {
                        m(view, z);
                    } else {
                        float f3 = -this.yI.get(al, 0);
                        if (f3 != 0.0f) {
                            this.yJ = f3;
                            f2 = f3;
                        } else {
                            f2 = this.yJ;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.zj.getChildAt(this.zj.getChildCount() + (-2)) != null ? z(this.zj.getChildAt(this.zj.getChildCount() - 2)) : 0.0f;
                int al3 = al(childAdapterPosition - 1);
                if (al3 >= 0) {
                    if (al3 == al) {
                        m(view, z2);
                    } else {
                        float f4 = -this.yI.get(al, 0);
                        if (f4 != 0.0f) {
                            this.yK = f4;
                            f = f4;
                        } else {
                            f = this.yK;
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
        if (this.zj != null) {
            m(view, 0.0f);
            int al = al(this.zj.getChildAdapterPosition(view));
            if (al >= 0 && b(al, 0, true) == -1) {
                this.yI.delete(al);
                if (this.yM.get(al) != null) {
                    this.yM.get(al).cancel();
                }
                this.yM.delete(al);
                this.yN.delete(al);
            }
        }
    }

    private void jH() {
        int childCount = this.zj.getChildCount();
        this.zm.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.zj.getChildAt(i);
            int childAdapterPosition = this.zj.getChildAdapterPosition(childAt);
            int al = al(childAdapterPosition);
            if (al >= 0 && !this.zm.contains(Integer.valueOf(al))) {
                this.zm.add(Integer.valueOf(al));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.zj.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == al(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == al(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.zj, i, f);
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
            return z(this.zj.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.zj.getChildAt(b(i - 1, i2, false)));
    }
}
