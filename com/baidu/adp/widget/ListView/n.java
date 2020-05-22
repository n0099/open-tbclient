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
public class n {
    private k UR;
    private float UT;
    private float UU;
    private BdTypeRecyclerView Vw;
    private LinearLayoutManager Vx;
    private int mOrientation;
    private int mScrollState;
    private boolean UV = false;
    private HashSet<Integer> Vy = new HashSet<>();
    private HashSet<Integer> Vz = new HashSet<>();
    private SparseIntArray US = new SparseIntArray();
    private SparseArray<ValueAnimator> UW = new SparseArray<>();
    private SparseIntArray UX = new SparseIntArray();

    public n(k kVar) {
        this.UR = kVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Vw = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Vx = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Vw != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.UR.pj()) {
                this.UV = true;
                oY();
                return;
            }
            this.UV = false;
            if (Math.abs(f2) > this.UR.pf()) {
                f3 = f2 > 0.0f ? this.UR.pf() : -this.UR.pf();
            } else {
                f3 = f2;
            }
            this.US.clear();
            float pb = f3 * this.UR.pb();
            int aE = aE(i);
            if (aE >= 0) {
                if (f3 < 0.0f) {
                    float pc = this.UR.pc();
                    int i3 = 1;
                    while (true) {
                        int i4 = aE - i3;
                        float f4 = pb + (i3 * pc);
                        float f5 = pc * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float pa = (f4 / this.UR.pa()) + this.US.get(i4);
                        if (Math.abs(pa) > this.UR.pe()) {
                            pa = -this.UR.pe();
                        }
                        this.US.append(i4, (int) pa);
                        i3++;
                        pc = f5;
                    }
                    float pc2 = this.UR.pc();
                    while (true) {
                        int i5 = aE + i2;
                        float f6 = pb + (i2 * pc2);
                        float f7 = pc2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float oZ = (f6 / this.UR.oZ()) + this.US.get(i5);
                            if (Math.abs(oZ) > this.UR.pd()) {
                                oZ = -this.UR.pd();
                            }
                            this.US.append(i5, (int) oZ);
                            i2++;
                            pc2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float pc3 = this.UR.pc();
                    int i6 = 1;
                    while (true) {
                        int i7 = aE - i6;
                        float f8 = pb - (i6 * pc3);
                        float f9 = pc3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float oZ2 = (f8 / this.UR.oZ()) + this.US.get(i7);
                        if (Math.abs(oZ2) > this.UR.pd()) {
                            oZ2 = this.UR.pd();
                        }
                        this.US.append(i7, (int) oZ2);
                        i6++;
                        pc3 = f9;
                    }
                    float pc4 = this.UR.pc();
                    while (true) {
                        int i8 = aE + i2;
                        float f10 = pb - (i2 * pc4);
                        float f11 = pc4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float pa2 = (f10 / this.UR.pa()) + this.US.get(i8);
                            if (Math.abs(pa2) > this.UR.pe()) {
                                pa2 = this.UR.pe();
                            }
                            this.US.append(i8, (int) pa2);
                            i2++;
                            pc4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aE(int i) {
        if (i > 0) {
            o item = this.Vw.getItem(i - this.Vw.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aE;
        int aE2;
        if (this.Vw != null && this.Vx != null && this.mScrollState == 1 && !this.UV) {
            int findFirstVisibleItemPosition = i3 - this.Vx.findFirstVisibleItemPosition();
            int aE3 = aE(i3);
            if (aE3 >= 0) {
                this.Vy.add(Integer.valueOf(aE3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Vw.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Vw.getChildAt(i5);
                    int childAdapterPosition = this.Vw.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aE2 = aE(childAdapterPosition)) >= 0 && !this.Vy.contains(Integer.valueOf(aE2))) {
                        this.Vy.add(Integer.valueOf(aE2));
                        a(childAt, i4, childAdapterPosition, i3, aE2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Vw.getChildAt(i7);
                        int childAdapterPosition2 = this.Vw.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aE = aE(childAdapterPosition2)) >= 0 && !this.Vy.contains(Integer.valueOf(aE))) {
                            this.Vy.add(Integer.valueOf(aE));
                            a(childAt2, i4, childAdapterPosition2, i3, aE);
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
                    float z = z(view) + (i * this.UR.ph());
                    if (z > c(i4, i2, true) + (-this.US.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.UR.pg());
                    if (z2 > c(i4, i2, false) + (-this.US.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.UR.ph());
                if (z3 < c(i4, i2, false) + (-this.US.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.UR.pg());
                if (z4 < c(i4, i2, true) + (-this.US.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aE;
        if (view != null && (aE = aE(i)) >= 0) {
            ValueAnimator valueAnimator = this.UW.get(aE);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new l(1.0f));
                ofFloat.setDuration(this.UR.pk());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.n.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        n.this.a(view, i, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.n.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        n.this.UW.delete(aE);
                        n.this.UX.delete(aE);
                        n.this.US.delete(aE);
                        n.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        n.this.UW.delete(aE);
                        n.this.UX.delete(aE);
                        n.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.UW.append(aE, ofFloat);
                this.UX.append(aE, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.UX.get(aE)) + this.UR.pi()) {
                this.UX.append(aE, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aC(int i) {
        if (this.Vw != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.US.clear();
                oY();
            } else if (this.mScrollState == 2) {
                oY();
            } else if (this.mScrollState == 1) {
                this.US.clear();
                oY();
            }
        }
    }

    public void A(View view) {
        int childAdapterPosition;
        int aE;
        float f;
        float f2;
        if (this.Vw != null && this.Vx != null && this.mScrollState != 0 && (aE = aE((childAdapterPosition = this.Vw.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Vx.findFirstVisibleItemPosition()) {
                float z = this.Vw.getChildAt(1) != null ? z(this.Vw.getChildAt(1)) : 0.0f;
                int aE2 = aE(childAdapterPosition + 1);
                if (aE2 >= 0) {
                    if (aE2 == aE) {
                        m(view, z);
                    } else {
                        float f3 = -this.US.get(aE, 0);
                        if (f3 != 0.0f) {
                            this.UT = f3;
                            f2 = f3;
                        } else {
                            f2 = this.UT;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Vw.getChildAt(this.Vw.getChildCount() + (-2)) != null ? z(this.Vw.getChildAt(this.Vw.getChildCount() - 2)) : 0.0f;
                int aE3 = aE(childAdapterPosition - 1);
                if (aE3 >= 0) {
                    if (aE3 == aE) {
                        m(view, z2);
                    } else {
                        float f4 = -this.US.get(aE, 0);
                        if (f4 != 0.0f) {
                            this.UU = f4;
                            f = f4;
                        } else {
                            f = this.UU;
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
        if (this.Vw != null) {
            m(view, 0.0f);
            int aE = aE(this.Vw.getChildAdapterPosition(view));
            if (aE >= 0 && b(aE, 0, true) == -1) {
                this.US.delete(aE);
                if (this.UW.get(aE) != null) {
                    this.UW.get(aE).cancel();
                }
                this.UW.delete(aE);
                this.UX.delete(aE);
            }
        }
    }

    private void oY() {
        int childCount = this.Vw.getChildCount();
        this.Vz.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Vw.getChildAt(i);
            int childAdapterPosition = this.Vw.getChildAdapterPosition(childAt);
            int aE = aE(childAdapterPosition);
            if (aE >= 0 && !this.Vz.contains(Integer.valueOf(aE))) {
                this.Vz.add(Integer.valueOf(aE));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Vw.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aE(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aE(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Vw, i, f);
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
            return z(this.Vw.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Vw.getChildAt(b(i - 1, i2, false)));
    }
}
