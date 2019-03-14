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
    private i PK;
    private float PN;
    private float PO;
    private BdTypeRecyclerView Qr;
    private LinearLayoutManager Qs;
    private int mOrientation;
    private int mScrollState;
    private boolean PP = false;
    private HashSet<Integer> Qt = new HashSet<>();
    private HashSet<Integer> Qu = new HashSet<>();
    private SparseIntArray PM = new SparseIntArray();
    private SparseArray<ValueAnimator> PQ = new SparseArray<>();
    private SparseIntArray PR = new SparseIntArray();

    public l(i iVar) {
        this.PK = iVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Qr = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Qs = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Qr != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.PK.pe()) {
                this.PP = true;
                oT();
                return;
            }
            this.PP = false;
            if (Math.abs(f2) > this.PK.pa()) {
                f3 = f2 > 0.0f ? this.PK.pa() : -this.PK.pa();
            } else {
                f3 = f2;
            }
            this.PM.clear();
            float oW = f3 * this.PK.oW();
            int aZ = aZ(i);
            if (aZ >= 0) {
                if (f3 < 0.0f) {
                    float oX = this.PK.oX();
                    int i3 = 1;
                    while (true) {
                        int i4 = aZ - i3;
                        float f4 = oW + (i3 * oX);
                        float f5 = oX * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float oV = (f4 / this.PK.oV()) + this.PM.get(i4);
                        if (Math.abs(oV) > this.PK.oZ()) {
                            oV = -this.PK.oZ();
                        }
                        this.PM.append(i4, (int) oV);
                        i3++;
                        oX = f5;
                    }
                    float oX2 = this.PK.oX();
                    while (true) {
                        int i5 = aZ + i2;
                        float f6 = oW + (i2 * oX2);
                        float f7 = oX2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float oU = (f6 / this.PK.oU()) + this.PM.get(i5);
                            if (Math.abs(oU) > this.PK.oY()) {
                                oU = -this.PK.oY();
                            }
                            this.PM.append(i5, (int) oU);
                            i2++;
                            oX2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float oX3 = this.PK.oX();
                    int i6 = 1;
                    while (true) {
                        int i7 = aZ - i6;
                        float f8 = oW - (i6 * oX3);
                        float f9 = oX3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float oU2 = (f8 / this.PK.oU()) + this.PM.get(i7);
                        if (Math.abs(oU2) > this.PK.oY()) {
                            oU2 = this.PK.oY();
                        }
                        this.PM.append(i7, (int) oU2);
                        i6++;
                        oX3 = f9;
                    }
                    float oX4 = this.PK.oX();
                    while (true) {
                        int i8 = aZ + i2;
                        float f10 = oW - (i2 * oX4);
                        float f11 = oX4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float oV2 = (f10 / this.PK.oV()) + this.PM.get(i8);
                            if (Math.abs(oV2) > this.PK.oZ()) {
                                oV2 = this.PK.oZ();
                            }
                            this.PM.append(i8, (int) oV2);
                            i2++;
                            oX4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aZ(int i) {
        if (i > 0) {
            m item = this.Qr.getItem(i);
            if (item instanceof com.baidu.tieba.card.data.b) {
                return ((com.baidu.tieba.card.data.b) item).position;
            }
        }
        return -1;
    }

    public void l(int i, int i2, int i3) {
        int aZ;
        int aZ2;
        if (this.Qr != null && this.Qs != null && this.mScrollState == 1 && !this.PP) {
            int findFirstVisibleItemPosition = i3 - this.Qs.findFirstVisibleItemPosition();
            int aZ3 = aZ(i3);
            if (aZ3 >= 0) {
                this.Qt.add(Integer.valueOf(aZ3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Qr.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Qr.getChildAt(i5);
                    int childAdapterPosition = this.Qr.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aZ2 = aZ(childAdapterPosition)) >= 0 && !this.Qt.contains(Integer.valueOf(aZ2))) {
                        this.Qt.add(Integer.valueOf(aZ2));
                        a(childAt, i4, childAdapterPosition, i3, aZ2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Qr.getChildAt(i7);
                        int childAdapterPosition2 = this.Qr.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aZ = aZ(childAdapterPosition2)) >= 0 && !this.Qt.contains(Integer.valueOf(aZ))) {
                            this.Qt.add(Integer.valueOf(aZ));
                            a(childAt2, i4, childAdapterPosition2, i3, aZ);
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
                    float C = C(view) + (i * this.PK.pc());
                    if (C > c(i4, i2, true) + (-this.PM.get(i4))) {
                        a(view, i2, C);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float C2 = C(view) + (i * this.PK.pb());
                    if (C2 > c(i4, i2, false) + (-this.PM.get(i4))) {
                        a(view, i2, C2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float C3 = C(view) + (i * this.PK.pc());
                if (C3 < c(i4, i2, false) + (-this.PM.get(i4))) {
                    a(view, i2, C3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float C4 = C(view) + (i * this.PK.pb());
                if (C4 < c(i4, i2, true) + (-this.PM.get(i4))) {
                    a(view, i2, C4);
                } else {
                    e(view, i2);
                }
            }
        }
    }

    private void e(final View view, final int i) {
        final int aZ;
        if (view != null && (aZ = aZ(i)) >= 0) {
            ValueAnimator valueAnimator = this.PQ.get(aZ);
            if (valueAnimator == null) {
                if (Math.abs(C(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(C(view), 0.0f);
                ofFloat.setInterpolator(new j(1.0f));
                ofFloat.setDuration(this.PK.pf());
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
                        l.this.PQ.delete(aZ);
                        l.this.PR.delete(aZ);
                        l.this.PM.delete(aZ);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        l.this.PQ.delete(aZ);
                        l.this.PR.delete(aZ);
                        l.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.PQ.append(aZ, ofFloat);
                this.PR.append(aZ, (int) C(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float C = C(view);
            if (Math.abs(C) > Math.abs(this.PR.get(aZ)) + this.PK.pd()) {
                this.PR.append(aZ, (int) C);
                valueAnimator.setFloatValues(C, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aX(int i) {
        if (this.Qr != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.PM.clear();
                oT();
            } else if (this.mScrollState == 2) {
                oT();
            } else if (this.mScrollState == 1) {
                this.PM.clear();
                oT();
            }
        }
    }

    public void D(View view) {
        int childAdapterPosition;
        int aZ;
        float f;
        float f2;
        if (this.Qr != null && this.Qs != null && this.mScrollState != 0 && (aZ = aZ((childAdapterPosition = this.Qr.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Qs.findFirstVisibleItemPosition()) {
                float C = this.Qr.getChildAt(1) != null ? C(this.Qr.getChildAt(1)) : 0.0f;
                int aZ2 = aZ(childAdapterPosition + 1);
                if (aZ2 >= 0) {
                    if (aZ2 == aZ) {
                        m(view, C);
                    } else {
                        float f3 = -this.PM.get(aZ, 0);
                        if (f3 != 0.0f) {
                            this.PN = f3;
                            f2 = f3;
                        } else {
                            f2 = this.PN;
                        }
                        m(view, C + f2);
                    }
                } else {
                    return;
                }
            } else {
                float C2 = this.Qr.getChildAt(this.Qr.getChildCount() + (-2)) != null ? C(this.Qr.getChildAt(this.Qr.getChildCount() - 2)) : 0.0f;
                int aZ3 = aZ(childAdapterPosition - 1);
                if (aZ3 >= 0) {
                    if (aZ3 == aZ) {
                        m(view, C2);
                    } else {
                        float f4 = -this.PM.get(aZ, 0);
                        if (f4 != 0.0f) {
                            this.PO = f4;
                            f = f4;
                        } else {
                            f = this.PO;
                        }
                        m(view, C2 + f);
                    }
                } else {
                    return;
                }
            }
            e(view, childAdapterPosition);
        }
    }

    public void E(View view) {
        if (this.Qr != null) {
            m(view, 0.0f);
            int aZ = aZ(this.Qr.getChildAdapterPosition(view));
            if (aZ >= 0 && b(aZ, 0, true) == -1) {
                this.PM.delete(aZ);
                if (this.PQ.get(aZ) != null) {
                    this.PQ.get(aZ).cancel();
                }
                this.PQ.delete(aZ);
                this.PR.delete(aZ);
            }
        }
    }

    private void oT() {
        int childCount = this.Qr.getChildCount();
        this.Qu.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Qr.getChildAt(i);
            int childAdapterPosition = this.Qr.getChildAdapterPosition(childAt);
            int aZ = aZ(childAdapterPosition);
            if (aZ >= 0 && !this.Qu.contains(Integer.valueOf(aZ))) {
                this.Qu.add(Integer.valueOf(aZ));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Qr.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aZ(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aZ(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Qr, i, f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private float C(View view) {
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
            return C(this.Qr.getChildAt(b(i + 1, i2, true)));
        }
        return C(this.Qr.getChildAt(b(i - 1, i2, false)));
    }
}
