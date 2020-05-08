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
    private float UC;
    private float UD;
    private i Uz;
    private BdTypeRecyclerView Vi;
    private LinearLayoutManager Vj;
    private int mOrientation;
    private int mScrollState;
    private boolean UE = false;
    private HashSet<Integer> Vk = new HashSet<>();
    private HashSet<Integer> Vl = new HashSet<>();
    private SparseIntArray UB = new SparseIntArray();
    private SparseArray<ValueAnimator> UF = new SparseArray<>();
    private SparseIntArray UG = new SparseIntArray();

    public l(i iVar) {
        this.Uz = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Vi = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Vj = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Vi != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Uz.pd()) {
                this.UE = true;
                oS();
                return;
            }
            this.UE = false;
            if (Math.abs(f2) > this.Uz.oZ()) {
                f3 = f2 > 0.0f ? this.Uz.oZ() : -this.Uz.oZ();
            } else {
                f3 = f2;
            }
            this.UB.clear();
            float oV = f3 * this.Uz.oV();
            int aD = aD(i);
            if (aD >= 0) {
                if (f3 < 0.0f) {
                    float oW = this.Uz.oW();
                    int i3 = 1;
                    while (true) {
                        int i4 = aD - i3;
                        float f4 = oV + (i3 * oW);
                        float f5 = oW * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float oU = (f4 / this.Uz.oU()) + this.UB.get(i4);
                        if (Math.abs(oU) > this.Uz.oY()) {
                            oU = -this.Uz.oY();
                        }
                        this.UB.append(i4, (int) oU);
                        i3++;
                        oW = f5;
                    }
                    float oW2 = this.Uz.oW();
                    while (true) {
                        int i5 = aD + i2;
                        float f6 = oV + (i2 * oW2);
                        float f7 = oW2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float oT = (f6 / this.Uz.oT()) + this.UB.get(i5);
                            if (Math.abs(oT) > this.Uz.oX()) {
                                oT = -this.Uz.oX();
                            }
                            this.UB.append(i5, (int) oT);
                            i2++;
                            oW2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float oW3 = this.Uz.oW();
                    int i6 = 1;
                    while (true) {
                        int i7 = aD - i6;
                        float f8 = oV - (i6 * oW3);
                        float f9 = oW3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float oT2 = (f8 / this.Uz.oT()) + this.UB.get(i7);
                        if (Math.abs(oT2) > this.Uz.oX()) {
                            oT2 = this.Uz.oX();
                        }
                        this.UB.append(i7, (int) oT2);
                        i6++;
                        oW3 = f9;
                    }
                    float oW4 = this.Uz.oW();
                    while (true) {
                        int i8 = aD + i2;
                        float f10 = oV - (i2 * oW4);
                        float f11 = oW4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float oU2 = (f10 / this.Uz.oU()) + this.UB.get(i8);
                            if (Math.abs(oU2) > this.Uz.oY()) {
                                oU2 = this.Uz.oY();
                            }
                            this.UB.append(i8, (int) oU2);
                            i2++;
                            oW4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aD(int i) {
        if (i > 0) {
            m item = this.Vi.getItem(i - this.Vi.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aD;
        int aD2;
        if (this.Vi != null && this.Vj != null && this.mScrollState == 1 && !this.UE) {
            int findFirstVisibleItemPosition = i3 - this.Vj.findFirstVisibleItemPosition();
            int aD3 = aD(i3);
            if (aD3 >= 0) {
                this.Vk.add(Integer.valueOf(aD3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Vi.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Vi.getChildAt(i5);
                    int childAdapterPosition = this.Vi.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aD2 = aD(childAdapterPosition)) >= 0 && !this.Vk.contains(Integer.valueOf(aD2))) {
                        this.Vk.add(Integer.valueOf(aD2));
                        a(childAt, i4, childAdapterPosition, i3, aD2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Vi.getChildAt(i7);
                        int childAdapterPosition2 = this.Vi.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aD = aD(childAdapterPosition2)) >= 0 && !this.Vk.contains(Integer.valueOf(aD))) {
                            this.Vk.add(Integer.valueOf(aD));
                            a(childAt2, i4, childAdapterPosition2, i3, aD);
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
                    float z = z(view) + (i * this.Uz.pb());
                    if (z > c(i4, i2, true) + (-this.UB.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.Uz.pa());
                    if (z2 > c(i4, i2, false) + (-this.UB.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.Uz.pb());
                if (z3 < c(i4, i2, false) + (-this.UB.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.Uz.pa());
                if (z4 < c(i4, i2, true) + (-this.UB.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aD;
        if (view != null && (aD = aD(i)) >= 0) {
            ValueAnimator valueAnimator = this.UF.get(aD);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Uz.pe());
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
                        l.this.UF.delete(aD);
                        l.this.UG.delete(aD);
                        l.this.UB.delete(aD);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.UF.delete(aD);
                        l.this.UG.delete(aD);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.UF.append(aD, ofFloat);
                this.UG.append(aD, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.UG.get(aD)) + this.Uz.pc()) {
                this.UG.append(aD, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aB(int i) {
        if (this.Vi != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.UB.clear();
                oS();
            } else if (this.mScrollState == 2) {
                oS();
            } else if (this.mScrollState == 1) {
                this.UB.clear();
                oS();
            }
        }
    }

    public void A(View view) {
        int childAdapterPosition;
        int aD;
        float f;
        float f2;
        if (this.Vi != null && this.Vj != null && this.mScrollState != 0 && (aD = aD((childAdapterPosition = this.Vi.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Vj.findFirstVisibleItemPosition()) {
                float z = this.Vi.getChildAt(1) != null ? z(this.Vi.getChildAt(1)) : 0.0f;
                int aD2 = aD(childAdapterPosition + 1);
                if (aD2 >= 0) {
                    if (aD2 == aD) {
                        m(view, z);
                    } else {
                        float f3 = -this.UB.get(aD, 0);
                        if (f3 != 0.0f) {
                            this.UC = f3;
                            f2 = f3;
                        } else {
                            f2 = this.UC;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Vi.getChildAt(this.Vi.getChildCount() + (-2)) != null ? z(this.Vi.getChildAt(this.Vi.getChildCount() - 2)) : 0.0f;
                int aD3 = aD(childAdapterPosition - 1);
                if (aD3 >= 0) {
                    if (aD3 == aD) {
                        m(view, z2);
                    } else {
                        float f4 = -this.UB.get(aD, 0);
                        if (f4 != 0.0f) {
                            this.UD = f4;
                            f = f4;
                        } else {
                            f = this.UD;
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
        if (this.Vi != null) {
            m(view, 0.0f);
            int aD = aD(this.Vi.getChildAdapterPosition(view));
            if (aD >= 0 && b(aD, 0, true) == -1) {
                this.UB.delete(aD);
                if (this.UF.get(aD) != null) {
                    this.UF.get(aD).cancel();
                }
                this.UF.delete(aD);
                this.UG.delete(aD);
            }
        }
    }

    private void oS() {
        int childCount = this.Vi.getChildCount();
        this.Vl.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Vi.getChildAt(i);
            int childAdapterPosition = this.Vi.getChildAdapterPosition(childAt);
            int aD = aD(childAdapterPosition);
            if (aD >= 0 && !this.Vl.contains(Integer.valueOf(aD))) {
                this.Vl.add(Integer.valueOf(aD));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Vi.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aD(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aD(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Vi, i, f);
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
            return z(this.Vi.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Vi.getChildAt(b(i - 1, i2, false)));
    }
}
