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
public class o {
    private l Vv;
    private float Vx;
    private float Vy;
    private BdTypeRecyclerView Wa;
    private LinearLayoutManager Wb;
    private int mOrientation;
    private int mScrollState;
    private boolean Vz = false;
    private HashSet<Integer> Wc = new HashSet<>();
    private HashSet<Integer> We = new HashSet<>();
    private SparseIntArray Vw = new SparseIntArray();
    private SparseArray<ValueAnimator> VA = new SparseArray<>();
    private SparseIntArray VB = new SparseIntArray();

    public o(l lVar) {
        this.Vv = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Wa = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Wb = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Wa != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Vv.pA()) {
                this.Vz = true;
                pp();
                return;
            }
            this.Vz = false;
            if (Math.abs(f2) > this.Vv.pw()) {
                f3 = f2 > 0.0f ? this.Vv.pw() : -this.Vv.pw();
            } else {
                f3 = f2;
            }
            this.Vw.clear();
            float ps = f3 * this.Vv.ps();
            int aK = aK(i);
            if (aK >= 0) {
                if (f3 < 0.0f) {
                    float pt = this.Vv.pt();
                    int i3 = 1;
                    while (true) {
                        int i4 = aK - i3;
                        float f4 = ps + (i3 * pt);
                        float f5 = pt * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float pr = (f4 / this.Vv.pr()) + this.Vw.get(i4);
                        if (Math.abs(pr) > this.Vv.pv()) {
                            pr = -this.Vv.pv();
                        }
                        this.Vw.append(i4, (int) pr);
                        i3++;
                        pt = f5;
                    }
                    float pt2 = this.Vv.pt();
                    while (true) {
                        int i5 = aK + i2;
                        float f6 = ps + (i2 * pt2);
                        float f7 = pt2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float pq = (f6 / this.Vv.pq()) + this.Vw.get(i5);
                            if (Math.abs(pq) > this.Vv.pu()) {
                                pq = -this.Vv.pu();
                            }
                            this.Vw.append(i5, (int) pq);
                            i2++;
                            pt2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float pt3 = this.Vv.pt();
                    int i6 = 1;
                    while (true) {
                        int i7 = aK - i6;
                        float f8 = ps - (i6 * pt3);
                        float f9 = pt3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float pq2 = (f8 / this.Vv.pq()) + this.Vw.get(i7);
                        if (Math.abs(pq2) > this.Vv.pu()) {
                            pq2 = this.Vv.pu();
                        }
                        this.Vw.append(i7, (int) pq2);
                        i6++;
                        pt3 = f9;
                    }
                    float pt4 = this.Vv.pt();
                    while (true) {
                        int i8 = aK + i2;
                        float f10 = ps - (i2 * pt4);
                        float f11 = pt4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float pr2 = (f10 / this.Vv.pr()) + this.Vw.get(i8);
                            if (Math.abs(pr2) > this.Vv.pv()) {
                                pr2 = this.Vv.pv();
                            }
                            this.Vw.append(i8, (int) pr2);
                            i2++;
                            pt4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aK(int i) {
        if (i > 0) {
            q item = this.Wa.getItem(i - this.Wa.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aK;
        int aK2;
        if (this.Wa != null && this.Wb != null && this.mScrollState == 1 && !this.Vz) {
            int findFirstVisibleItemPosition = i3 - this.Wb.findFirstVisibleItemPosition();
            int aK3 = aK(i3);
            if (aK3 >= 0) {
                this.Wc.add(Integer.valueOf(aK3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Wa.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Wa.getChildAt(i5);
                    int childAdapterPosition = this.Wa.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aK2 = aK(childAdapterPosition)) >= 0 && !this.Wc.contains(Integer.valueOf(aK2))) {
                        this.Wc.add(Integer.valueOf(aK2));
                        a(childAt, i4, childAdapterPosition, i3, aK2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Wa.getChildAt(i7);
                        int childAdapterPosition2 = this.Wa.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aK = aK(childAdapterPosition2)) >= 0 && !this.Wc.contains(Integer.valueOf(aK))) {
                            this.Wc.add(Integer.valueOf(aK));
                            a(childAt2, i4, childAdapterPosition2, i3, aK);
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
                    float z = z(view) + (i * this.Vv.py());
                    if (z > c(i4, i2, true) + (-this.Vw.get(i4))) {
                        a(view, i2, z);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float z2 = z(view) + (i * this.Vv.px());
                    if (z2 > c(i4, i2, false) + (-this.Vw.get(i4))) {
                        a(view, i2, z2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float z3 = z(view) + (i * this.Vv.py());
                if (z3 < c(i4, i2, false) + (-this.Vw.get(i4))) {
                    a(view, i2, z3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float z4 = z(view) + (i * this.Vv.px());
                if (z4 < c(i4, i2, true) + (-this.Vw.get(i4))) {
                    a(view, i2, z4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aK;
        if (view != null && (aK = aK(i)) >= 0) {
            ValueAnimator valueAnimator = this.VA.get(aK);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Vv.pB());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.o.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        o.this.a(view, i, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.o.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        o.this.VA.delete(aK);
                        o.this.VB.delete(aK);
                        o.this.Vw.delete(aK);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.VA.delete(aK);
                        o.this.VB.delete(aK);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.VA.append(aK, ofFloat);
                this.VB.append(aK, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.VB.get(aK)) + this.Vv.pz()) {
                this.VB.append(aK, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aI(int i) {
        if (this.Wa != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Vw.clear();
                pp();
            } else if (this.mScrollState == 2) {
                pp();
            } else if (this.mScrollState == 1) {
                this.Vw.clear();
                pp();
            }
        }
    }

    public void A(View view) {
        int childAdapterPosition;
        int aK;
        float f;
        float f2;
        if (this.Wa != null && this.Wb != null && this.mScrollState != 0 && (aK = aK((childAdapterPosition = this.Wa.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Wb.findFirstVisibleItemPosition()) {
                float z = this.Wa.getChildAt(1) != null ? z(this.Wa.getChildAt(1)) : 0.0f;
                int aK2 = aK(childAdapterPosition + 1);
                if (aK2 >= 0) {
                    if (aK2 == aK) {
                        m(view, z);
                    } else {
                        float f3 = -this.Vw.get(aK, 0);
                        if (f3 != 0.0f) {
                            this.Vx = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Vx;
                        }
                        m(view, z + f2);
                    }
                } else {
                    return;
                }
            } else {
                float z2 = this.Wa.getChildAt(this.Wa.getChildCount() + (-2)) != null ? z(this.Wa.getChildAt(this.Wa.getChildCount() - 2)) : 0.0f;
                int aK3 = aK(childAdapterPosition - 1);
                if (aK3 >= 0) {
                    if (aK3 == aK) {
                        m(view, z2);
                    } else {
                        float f4 = -this.Vw.get(aK, 0);
                        if (f4 != 0.0f) {
                            this.Vy = f4;
                            f = f4;
                        } else {
                            f = this.Vy;
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
        if (this.Wa != null) {
            m(view, 0.0f);
            int aK = aK(this.Wa.getChildAdapterPosition(view));
            if (aK >= 0 && b(aK, 0, true) == -1) {
                this.Vw.delete(aK);
                if (this.VA.get(aK) != null) {
                    this.VA.get(aK).cancel();
                }
                this.VA.delete(aK);
                this.VB.delete(aK);
            }
        }
    }

    private void pp() {
        int childCount = this.Wa.getChildCount();
        this.We.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Wa.getChildAt(i);
            int childAdapterPosition = this.Wa.getChildAdapterPosition(childAt);
            int aK = aK(childAdapterPosition);
            if (aK >= 0 && !this.We.contains(Integer.valueOf(aK))) {
                this.We.add(Integer.valueOf(aK));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Wa.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aK(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aK(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Wa, i, f);
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
            return z(this.Wa.getChildAt(b(i + 1, i2, true)));
        }
        return z(this.Wa.getChildAt(b(i - 1, i2, false)));
    }
}
