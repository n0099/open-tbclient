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
    private BdTypeRecyclerView VT;
    private LinearLayoutManager VU;
    private l Vo;
    private float Vq;
    private float Vr;
    private int mOrientation;
    private int mScrollState;
    private boolean Vs = false;
    private HashSet<Integer> VV = new HashSet<>();
    private HashSet<Integer> VW = new HashSet<>();
    private SparseIntArray Vp = new SparseIntArray();
    private SparseArray<ValueAnimator> Vt = new SparseArray<>();
    private SparseIntArray Vu = new SparseIntArray();

    public o(l lVar) {
        this.Vo = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.VT = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.VU = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.VT != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Vo.pB()) {
                this.Vs = true;
                pq();
                return;
            }
            this.Vs = false;
            if (Math.abs(f2) > this.Vo.px()) {
                f3 = f2 > 0.0f ? this.Vo.px() : -this.Vo.px();
            } else {
                f3 = f2;
            }
            this.Vp.clear();
            float pt = f3 * this.Vo.pt();
            int aM = aM(i);
            if (aM >= 0) {
                if (f3 < 0.0f) {
                    float pu = this.Vo.pu();
                    int i3 = 1;
                    while (true) {
                        int i4 = aM - i3;
                        float f4 = pt + (i3 * pu);
                        float f5 = pu * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float ps = (f4 / this.Vo.ps()) + this.Vp.get(i4);
                        if (Math.abs(ps) > this.Vo.pw()) {
                            ps = -this.Vo.pw();
                        }
                        this.Vp.append(i4, (int) ps);
                        i3++;
                        pu = f5;
                    }
                    float pu2 = this.Vo.pu();
                    while (true) {
                        int i5 = aM + i2;
                        float f6 = pt + (i2 * pu2);
                        float f7 = pu2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float pr = (f6 / this.Vo.pr()) + this.Vp.get(i5);
                            if (Math.abs(pr) > this.Vo.pv()) {
                                pr = -this.Vo.pv();
                            }
                            this.Vp.append(i5, (int) pr);
                            i2++;
                            pu2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float pu3 = this.Vo.pu();
                    int i6 = 1;
                    while (true) {
                        int i7 = aM - i6;
                        float f8 = pt - (i6 * pu3);
                        float f9 = pu3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float pr2 = (f8 / this.Vo.pr()) + this.Vp.get(i7);
                        if (Math.abs(pr2) > this.Vo.pv()) {
                            pr2 = this.Vo.pv();
                        }
                        this.Vp.append(i7, (int) pr2);
                        i6++;
                        pu3 = f9;
                    }
                    float pu4 = this.Vo.pu();
                    while (true) {
                        int i8 = aM + i2;
                        float f10 = pt - (i2 * pu4);
                        float f11 = pu4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float ps2 = (f10 / this.Vo.ps()) + this.Vp.get(i8);
                            if (Math.abs(ps2) > this.Vo.pw()) {
                                ps2 = this.Vo.pw();
                            }
                            this.Vp.append(i8, (int) ps2);
                            i2++;
                            pu4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aM(int i) {
        if (i > 0) {
            q item = this.VT.getItem(i - this.VT.getHeaderViewsCount());
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aM;
        int aM2;
        if (this.VT != null && this.VU != null && this.mScrollState == 1 && !this.Vs) {
            int findFirstVisibleItemPosition = i3 - this.VU.findFirstVisibleItemPosition();
            int aM3 = aM(i3);
            if (aM3 >= 0) {
                this.VV.add(Integer.valueOf(aM3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.VT.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.VT.getChildAt(i5);
                    int childAdapterPosition = this.VT.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aM2 = aM(childAdapterPosition)) >= 0 && !this.VV.contains(Integer.valueOf(aM2))) {
                        this.VV.add(Integer.valueOf(aM2));
                        a(childAt, i4, childAdapterPosition, i3, aM2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.VT.getChildAt(i7);
                        int childAdapterPosition2 = this.VT.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aM = aM(childAdapterPosition2)) >= 0 && !this.VV.contains(Integer.valueOf(aM))) {
                            this.VV.add(Integer.valueOf(aM));
                            a(childAt2, i4, childAdapterPosition2, i3, aM);
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
                    float B = B(view) + (i * this.Vo.pz());
                    if (B > c(i4, i2, true) + (-this.Vp.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.Vo.py());
                    if (B2 > c(i4, i2, false) + (-this.Vp.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.Vo.pz());
                if (B3 < c(i4, i2, false) + (-this.Vp.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.Vo.py());
                if (B4 < c(i4, i2, true) + (-this.Vp.get(i4))) {
                    a(view, i2, B4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aM;
        if (view != null && (aM = aM(i)) >= 0) {
            ValueAnimator valueAnimator = this.Vt.get(aM);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Vo.pC());
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
                        o.this.Vt.delete(aM);
                        o.this.Vu.delete(aM);
                        o.this.Vp.delete(aM);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.Vt.delete(aM);
                        o.this.Vu.delete(aM);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Vt.append(aM, ofFloat);
                this.Vu.append(aM, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.Vu.get(aM)) + this.Vo.pA()) {
                this.Vu.append(aM, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aK(int i) {
        if (this.VT != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Vp.clear();
                pq();
            } else if (this.mScrollState == 2) {
                pq();
            } else if (this.mScrollState == 1) {
                this.Vp.clear();
                pq();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aM;
        float f;
        float f2;
        if (this.VT != null && this.VU != null && this.mScrollState != 0 && (aM = aM((childAdapterPosition = this.VT.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.VU.findFirstVisibleItemPosition()) {
                float B = this.VT.getChildAt(1) != null ? B(this.VT.getChildAt(1)) : 0.0f;
                int aM2 = aM(childAdapterPosition + 1);
                if (aM2 >= 0) {
                    if (aM2 == aM) {
                        m(view, B);
                    } else {
                        float f3 = -this.Vp.get(aM, 0);
                        if (f3 != 0.0f) {
                            this.Vq = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Vq;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.VT.getChildAt(this.VT.getChildCount() + (-2)) != null ? B(this.VT.getChildAt(this.VT.getChildCount() - 2)) : 0.0f;
                int aM3 = aM(childAdapterPosition - 1);
                if (aM3 >= 0) {
                    if (aM3 == aM) {
                        m(view, B2);
                    } else {
                        float f4 = -this.Vp.get(aM, 0);
                        if (f4 != 0.0f) {
                            this.Vr = f4;
                            f = f4;
                        } else {
                            f = this.Vr;
                        }
                        m(view, B2 + f);
                    }
                } else {
                    return;
                }
            }
            c(view, childAdapterPosition);
        }
    }

    public void D(View view) {
        if (this.VT != null) {
            m(view, 0.0f);
            int aM = aM(this.VT.getChildAdapterPosition(view));
            if (aM >= 0 && b(aM, 0, true) == -1) {
                this.Vp.delete(aM);
                if (this.Vt.get(aM) != null) {
                    this.Vt.get(aM).cancel();
                }
                this.Vt.delete(aM);
                this.Vu.delete(aM);
            }
        }
    }

    private void pq() {
        int childCount = this.VT.getChildCount();
        this.VW.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.VT.getChildAt(i);
            int childAdapterPosition = this.VT.getChildAdapterPosition(childAt);
            int aM = aM(childAdapterPosition);
            if (aM >= 0 && !this.VW.contains(Integer.valueOf(aM))) {
                this.VW.add(Integer.valueOf(aM));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.VT.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aM(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aM(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.VT, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float B(View view) {
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
            return B(this.VT.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.VT.getChildAt(b(i - 1, i2, false)));
    }
}
