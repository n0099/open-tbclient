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
    private i AN;
    private float AP;
    private float AQ;
    private BdTypeRecyclerView Bs;
    private LinearLayoutManager Bt;
    private int mOrientation;
    private int mScrollState;
    private boolean AR = false;
    private HashSet<Integer> Bu = new HashSet<>();
    private HashSet<Integer> Bv = new HashSet<>();
    private SparseIntArray AO = new SparseIntArray();
    private SparseArray<ValueAnimator> AU = new SparseArray<>();
    private SparseIntArray AV = new SparseIntArray();

    public l(i iVar) {
        this.AN = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Bs = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Bt = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Bs != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.AN.kk()) {
                this.AR = true;
                jZ();
                return;
            }
            this.AR = false;
            if (Math.abs(f2) > this.AN.kg()) {
                f3 = f2 > 0.0f ? this.AN.kg() : -this.AN.kg();
            } else {
                f3 = f2;
            }
            this.AO.clear();
            float kc = f3 * this.AN.kc();
            int ao = ao(i);
            if (ao >= 0) {
                if (f3 < 0.0f) {
                    float kd = this.AN.kd();
                    int i3 = 1;
                    while (true) {
                        int i4 = ao - i3;
                        float f4 = kc + (i3 * kd);
                        float f5 = kd * 1.2f;
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
                        int i5 = ao + i2;
                        float f6 = kc + (i2 * kd2);
                        float f7 = kd2 * 1.2f;
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
                        int i7 = ao - i6;
                        float f8 = kc - (i6 * kd3);
                        float f9 = kd3 * 1.2f;
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
                        int i8 = ao + i2;
                        float f10 = kc - (i2 * kd4);
                        float f11 = kd4 * 1.2f;
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
    }

    private int ao(int i) {
        if (i > 0) {
            m item = this.Bs.getItem(i - this.Bs.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void i(int i, int i2, int i3) {
        int ao;
        int ao2;
        if (this.Bs != null && this.Bt != null && this.mScrollState == 1 && !this.AR) {
            int findFirstVisibleItemPosition = i3 - this.Bt.findFirstVisibleItemPosition();
            int ao3 = ao(i3);
            if (ao3 >= 0) {
                this.Bu.add(Integer.valueOf(ao3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Bs.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Bs.getChildAt(i5);
                    int childAdapterPosition = this.Bs.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (ao2 = ao(childAdapterPosition)) >= 0 && !this.Bu.contains(Integer.valueOf(ao2))) {
                        this.Bu.add(Integer.valueOf(ao2));
                        a(childAt, i4, childAdapterPosition, i3, ao2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Bs.getChildAt(i7);
                        int childAdapterPosition2 = this.Bs.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (ao = ao(childAdapterPosition2)) >= 0 && !this.Bu.contains(Integer.valueOf(ao))) {
                            this.Bu.add(Integer.valueOf(ao));
                            a(childAt2, i4, childAdapterPosition2, i3, ao);
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
                    float z = z(view) + (i * this.AN.ki());
                    if (z > c(i4, i2, true) + (-this.AO.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.AN.kh());
                    if (z2 > c(i4, i2, false) + (-this.AO.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.AN.ki());
                if (z3 < c(i4, i2, false) + (-this.AO.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.AN.kh());
                if (z4 < c(i4, i2, true) + (-this.AO.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int ao;
        if (view != null && (ao = ao(i)) >= 0) {
            ValueAnimator valueAnimator = this.AU.get(ao);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.AN.kl());
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
                        l.this.AU.delete(ao);
                        l.this.AV.delete(ao);
                        l.this.AO.delete(ao);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.AU.delete(ao);
                        l.this.AV.delete(ao);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.AU.append(ao, ofFloat);
                this.AV.append(ao, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.AV.get(ao)) + this.AN.kj()) {
                this.AV.append(ao, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void am(int i) {
        if (this.Bs != null) {
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

    public void A(View view) {
        int childAdapterPosition;
        int ao;
        float f;
        float f2;
        if (this.Bs != null && this.Bt != null && this.mScrollState != 0 && (ao = ao((childAdapterPosition = this.Bs.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Bt.findFirstVisibleItemPosition()) {
                float z = this.Bs.getChildAt(1) != null ? z(this.Bs.getChildAt(1)) : 0.0f;
                int ao2 = ao(childAdapterPosition + 1);
                if (ao2 >= 0) {
                    if (ao2 == ao) {
                        m(view, z);
                    } else {
                        float f3 = -this.AO.get(ao, 0);
                        if (f3 != 0.0f) {
                            this.AP = f3;
                            f2 = f3;
                        } else {
                            f2 = this.AP;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Bs.getChildAt(this.Bs.getChildCount() + (-2)) != null ? z(this.Bs.getChildAt(this.Bs.getChildCount() - 2)) : 0.0f;
                int ao3 = ao(childAdapterPosition - 1);
                if (ao3 >= 0) {
                    if (ao3 == ao) {
                        m(view, z2);
                    } else {
                        float f4 = -this.AO.get(ao, 0);
                        if (f4 != 0.0f) {
                            this.AQ = f4;
                            f = f4;
                        } else {
                            f = this.AQ;
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
        if (this.Bs != null) {
            m(view, 0.0f);
            int ao = ao(this.Bs.getChildAdapterPosition(view));
            if (ao >= 0 && b(ao, 0, true) == -1) {
                this.AO.delete(ao);
                if (this.AU.get(ao) != null) {
                    this.AU.get(ao).cancel();
                }
                this.AU.delete(ao);
                this.AV.delete(ao);
            }
        }
    }

    private void jZ() {
        int childCount = this.Bs.getChildCount();
        this.Bv.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Bs.getChildAt(i);
            int childAdapterPosition = this.Bs.getChildAdapterPosition(childAt);
            int ao = ao(childAdapterPosition);
            if (ao >= 0 && !this.Bv.contains(Integer.valueOf(ao))) {
                this.Bv.add(Integer.valueOf(ao));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Bs.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == ao(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == ao(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Bs, i, f);
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
            return z(this.Bs.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Bs.getChildAt(b(i - 1, i2, false)));
    }
}
