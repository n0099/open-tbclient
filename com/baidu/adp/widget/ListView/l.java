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
    private i Uw;
    private float Uy;
    private float Uz;
    private BdTypeRecyclerView Vf;
    private LinearLayoutManager Vg;
    private int mOrientation;
    private int mScrollState;
    private boolean UB = false;
    private HashSet<Integer> Vh = new HashSet<>();
    private HashSet<Integer> Vi = new HashSet<>();
    private SparseIntArray Ux = new SparseIntArray();
    private SparseArray<ValueAnimator> UC = new SparseArray<>();
    private SparseIntArray UD = new SparseIntArray();

    public l(i iVar) {
        this.Uw = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Vf = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Vg = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Vf != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Uw.pd()) {
                this.UB = true;
                oS();
                return;
            }
            this.UB = false;
            if (Math.abs(f2) > this.Uw.oZ()) {
                f3 = f2 > 0.0f ? this.Uw.oZ() : -this.Uw.oZ();
            } else {
                f3 = f2;
            }
            this.Ux.clear();
            float oV = f3 * this.Uw.oV();
            int aD = aD(i);
            if (aD >= 0) {
                if (f3 < 0.0f) {
                    float oW = this.Uw.oW();
                    int i3 = 1;
                    while (true) {
                        int i4 = aD - i3;
                        float f4 = oV + (i3 * oW);
                        float f5 = oW * 1.2f;
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
                        int i5 = aD + i2;
                        float f6 = oV + (i2 * oW2);
                        float f7 = oW2 * 1.2f;
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
                        int i7 = aD - i6;
                        float f8 = oV - (i6 * oW3);
                        float f9 = oW3 * 1.2f;
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
                        int i8 = aD + i2;
                        float f10 = oV - (i2 * oW4);
                        float f11 = oW4 * 1.2f;
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
    }

    private int aD(int i) {
        if (i > 0) {
            m item = this.Vf.getItem(i - this.Vf.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aD;
        int aD2;
        if (this.Vf != null && this.Vg != null && this.mScrollState == 1 && !this.UB) {
            int findFirstVisibleItemPosition = i3 - this.Vg.findFirstVisibleItemPosition();
            int aD3 = aD(i3);
            if (aD3 >= 0) {
                this.Vh.add(Integer.valueOf(aD3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Vf.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Vf.getChildAt(i5);
                    int childAdapterPosition = this.Vf.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aD2 = aD(childAdapterPosition)) >= 0 && !this.Vh.contains(Integer.valueOf(aD2))) {
                        this.Vh.add(Integer.valueOf(aD2));
                        a(childAt, i4, childAdapterPosition, i3, aD2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Vf.getChildAt(i7);
                        int childAdapterPosition2 = this.Vf.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aD = aD(childAdapterPosition2)) >= 0 && !this.Vh.contains(Integer.valueOf(aD))) {
                            this.Vh.add(Integer.valueOf(aD));
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
                    float z = z(view) + (i * this.Uw.pb());
                    if (z > c(i4, i2, true) + (-this.Ux.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.Uw.pa());
                    if (z2 > c(i4, i2, false) + (-this.Ux.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.Uw.pb());
                if (z3 < c(i4, i2, false) + (-this.Ux.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.Uw.pa());
                if (z4 < c(i4, i2, true) + (-this.Ux.get(i4))) {
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
            ValueAnimator valueAnimator = this.UC.get(aD);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.Uw.pe());
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
                        l.this.UC.delete(aD);
                        l.this.UD.delete(aD);
                        l.this.Ux.delete(aD);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.UC.delete(aD);
                        l.this.UD.delete(aD);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.UC.append(aD, ofFloat);
                this.UD.append(aD, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.UD.get(aD)) + this.Uw.pc()) {
                this.UD.append(aD, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aB(int i) {
        if (this.Vf != null) {
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

    public void A(View view) {
        int childAdapterPosition;
        int aD;
        float f;
        float f2;
        if (this.Vf != null && this.Vg != null && this.mScrollState != 0 && (aD = aD((childAdapterPosition = this.Vf.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Vg.findFirstVisibleItemPosition()) {
                float z = this.Vf.getChildAt(1) != null ? z(this.Vf.getChildAt(1)) : 0.0f;
                int aD2 = aD(childAdapterPosition + 1);
                if (aD2 >= 0) {
                    if (aD2 == aD) {
                        m(view, z);
                    } else {
                        float f3 = -this.Ux.get(aD, 0);
                        if (f3 != 0.0f) {
                            this.Uy = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Uy;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Vf.getChildAt(this.Vf.getChildCount() + (-2)) != null ? z(this.Vf.getChildAt(this.Vf.getChildCount() - 2)) : 0.0f;
                int aD3 = aD(childAdapterPosition - 1);
                if (aD3 >= 0) {
                    if (aD3 == aD) {
                        m(view, z2);
                    } else {
                        float f4 = -this.Ux.get(aD, 0);
                        if (f4 != 0.0f) {
                            this.Uz = f4;
                            f = f4;
                        } else {
                            f = this.Uz;
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
        if (this.Vf != null) {
            m(view, 0.0f);
            int aD = aD(this.Vf.getChildAdapterPosition(view));
            if (aD >= 0 && b(aD, 0, true) == -1) {
                this.Ux.delete(aD);
                if (this.UC.get(aD) != null) {
                    this.UC.get(aD).cancel();
                }
                this.UC.delete(aD);
                this.UD.delete(aD);
            }
        }
    }

    private void oS() {
        int childCount = this.Vf.getChildCount();
        this.Vi.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Vf.getChildAt(i);
            int childAdapterPosition = this.Vf.getChildAdapterPosition(childAt);
            int aD = aD(childAdapterPosition);
            if (aD >= 0 && !this.Vi.contains(Integer.valueOf(aD))) {
                this.Vi.add(Integer.valueOf(aD));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Vf.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.Vf, i, f);
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
            return z(this.Vf.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Vf.getChildAt(b(i - 1, i2, false)));
    }
}
