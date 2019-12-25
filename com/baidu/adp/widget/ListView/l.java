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
    private i AH;
    private float AJ;
    private float AK;
    private BdTypeRecyclerView Bn;
    private LinearLayoutManager Bo;
    private int mOrientation;
    private int mScrollState;
    private boolean AM = false;
    private HashSet<Integer> Bp = new HashSet<>();
    private HashSet<Integer> Bq = new HashSet<>();
    private SparseIntArray AI = new SparseIntArray();
    private SparseArray<ValueAnimator> AN = new SparseArray<>();
    private SparseIntArray AO = new SparseIntArray();

    public l(i iVar) {
        this.AH = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Bn = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Bo = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Bn != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.AH.kj()) {
                this.AM = true;
                jY();
                return;
            }
            this.AM = false;
            if (Math.abs(f2) > this.AH.kf()) {
                f3 = f2 > 0.0f ? this.AH.kf() : -this.AH.kf();
            } else {
                f3 = f2;
            }
            this.AI.clear();
            float kb = f3 * this.AH.kb();
            int ao = ao(i);
            if (ao >= 0) {
                if (f3 < 0.0f) {
                    float kc = this.AH.kc();
                    int i3 = 1;
                    while (true) {
                        int i4 = ao - i3;
                        float f4 = kb + (i3 * kc);
                        float f5 = kc * 1.2f;
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
                        int i5 = ao + i2;
                        float f6 = kb + (i2 * kc2);
                        float f7 = kc2 * 1.2f;
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
                        int i7 = ao - i6;
                        float f8 = kb - (i6 * kc3);
                        float f9 = kc3 * 1.2f;
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
                        int i8 = ao + i2;
                        float f10 = kb - (i2 * kc4);
                        float f11 = kc4 * 1.2f;
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
    }

    private int ao(int i) {
        if (i > 0) {
            m item = this.Bn.getItem(i - this.Bn.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void i(int i, int i2, int i3) {
        int ao;
        int ao2;
        if (this.Bn != null && this.Bo != null && this.mScrollState == 1 && !this.AM) {
            int findFirstVisibleItemPosition = i3 - this.Bo.findFirstVisibleItemPosition();
            int ao3 = ao(i3);
            if (ao3 >= 0) {
                this.Bp.add(Integer.valueOf(ao3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Bn.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Bn.getChildAt(i5);
                    int childAdapterPosition = this.Bn.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (ao2 = ao(childAdapterPosition)) >= 0 && !this.Bp.contains(Integer.valueOf(ao2))) {
                        this.Bp.add(Integer.valueOf(ao2));
                        a(childAt, i4, childAdapterPosition, i3, ao2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Bn.getChildAt(i7);
                        int childAdapterPosition2 = this.Bn.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (ao = ao(childAdapterPosition2)) >= 0 && !this.Bp.contains(Integer.valueOf(ao))) {
                            this.Bp.add(Integer.valueOf(ao));
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
                    float z = z(view) + (i * this.AH.kh());
                    if (z > c(i4, i2, true) + (-this.AI.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.AH.kg());
                    if (z2 > c(i4, i2, false) + (-this.AI.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.AH.kh());
                if (z3 < c(i4, i2, false) + (-this.AI.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.AH.kg());
                if (z4 < c(i4, i2, true) + (-this.AI.get(i4))) {
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
            ValueAnimator valueAnimator = this.AN.get(ao);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.AH.kk());
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
                        l.this.AN.delete(ao);
                        l.this.AO.delete(ao);
                        l.this.AI.delete(ao);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.AN.delete(ao);
                        l.this.AO.delete(ao);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.AN.append(ao, ofFloat);
                this.AO.append(ao, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.AO.get(ao)) + this.AH.ki()) {
                this.AO.append(ao, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void am(int i) {
        if (this.Bn != null) {
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

    public void A(View view) {
        int childAdapterPosition;
        int ao;
        float f;
        float f2;
        if (this.Bn != null && this.Bo != null && this.mScrollState != 0 && (ao = ao((childAdapterPosition = this.Bn.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Bo.findFirstVisibleItemPosition()) {
                float z = this.Bn.getChildAt(1) != null ? z(this.Bn.getChildAt(1)) : 0.0f;
                int ao2 = ao(childAdapterPosition + 1);
                if (ao2 >= 0) {
                    if (ao2 == ao) {
                        m(view, z);
                    } else {
                        float f3 = -this.AI.get(ao, 0);
                        if (f3 != 0.0f) {
                            this.AJ = f3;
                            f2 = f3;
                        } else {
                            f2 = this.AJ;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Bn.getChildAt(this.Bn.getChildCount() + (-2)) != null ? z(this.Bn.getChildAt(this.Bn.getChildCount() - 2)) : 0.0f;
                int ao3 = ao(childAdapterPosition - 1);
                if (ao3 >= 0) {
                    if (ao3 == ao) {
                        m(view, z2);
                    } else {
                        float f4 = -this.AI.get(ao, 0);
                        if (f4 != 0.0f) {
                            this.AK = f4;
                            f = f4;
                        } else {
                            f = this.AK;
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
        if (this.Bn != null) {
            m(view, 0.0f);
            int ao = ao(this.Bn.getChildAdapterPosition(view));
            if (ao >= 0 && b(ao, 0, true) == -1) {
                this.AI.delete(ao);
                if (this.AN.get(ao) != null) {
                    this.AN.get(ao).cancel();
                }
                this.AN.delete(ao);
                this.AO.delete(ao);
            }
        }
    }

    private void jY() {
        int childCount = this.Bn.getChildCount();
        this.Bq.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Bn.getChildAt(i);
            int childAdapterPosition = this.Bn.getChildAdapterPosition(childAt);
            int ao = ao(childAdapterPosition);
            if (ao >= 0 && !this.Bq.contains(Integer.valueOf(ao))) {
                this.Bq.add(Integer.valueOf(ao));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Bn.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.Bn, i, f);
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
            return z(this.Bn.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Bn.getChildAt(b(i - 1, i2, false)));
    }
}
