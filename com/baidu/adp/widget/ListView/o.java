package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashSet;
/* loaded from: classes.dex */
public class o {
    private l XC;
    private float XE;
    private float XF;
    private BdTypeRecyclerView Yf;
    private LinearLayoutManager Yg;
    private int mOrientation;
    private int mScrollState;
    private boolean XG = false;
    private HashSet<Integer> Yh = new HashSet<>();
    private HashSet<Integer> Yi = new HashSet<>();
    private SparseIntArray XD = new SparseIntArray();
    private SparseArray<ValueAnimator> XH = new SparseArray<>();
    private SparseIntArray XI = new SparseIntArray();

    public o(l lVar) {
        this.XC = lVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Yf = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Yg = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Yf != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.XC.rh()) {
                this.XG = true;
                qW();
                return;
            }
            this.XG = false;
            if (Math.abs(f2) > this.XC.rd()) {
                f3 = f2 > 0.0f ? this.XC.rd() : -this.XC.rd();
            } else {
                f3 = f2;
            }
            this.XD.clear();
            float qZ = f3 * this.XC.qZ();
            int aX = aX(i);
            if (aX >= 0) {
                if (f3 < 0.0f) {
                    float ra = this.XC.ra();
                    int i3 = 1;
                    while (true) {
                        int i4 = aX - i3;
                        float f4 = qZ + (i3 * ra);
                        float f5 = ra * 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float qY = (f4 / this.XC.qY()) + this.XD.get(i4);
                        if (Math.abs(qY) > this.XC.rc()) {
                            qY = -this.XC.rc();
                        }
                        this.XD.append(i4, (int) qY);
                        i3++;
                        ra = f5;
                    }
                    float ra2 = this.XC.ra();
                    while (true) {
                        int i5 = aX + i2;
                        float f6 = qZ + (i2 * ra2);
                        float f7 = ra2 * 1.2f;
                        if (f6 <= 0.0f) {
                            float qX = (f6 / this.XC.qX()) + this.XD.get(i5);
                            if (Math.abs(qX) > this.XC.rb()) {
                                qX = -this.XC.rb();
                            }
                            this.XD.append(i5, (int) qX);
                            i2++;
                            ra2 = f7;
                        } else {
                            return;
                        }
                    }
                } else {
                    float ra3 = this.XC.ra();
                    int i6 = 1;
                    while (true) {
                        int i7 = aX - i6;
                        float f8 = qZ - (i6 * ra3);
                        float f9 = ra3 * 1.2f;
                        if (f8 < 0.0f) {
                            break;
                        }
                        float qX2 = (f8 / this.XC.qX()) + this.XD.get(i7);
                        if (Math.abs(qX2) > this.XC.rb()) {
                            qX2 = this.XC.rb();
                        }
                        this.XD.append(i7, (int) qX2);
                        i6++;
                        ra3 = f9;
                    }
                    float ra4 = this.XC.ra();
                    while (true) {
                        int i8 = aX + i2;
                        float f10 = qZ - (i2 * ra4);
                        float f11 = ra4 * 1.2f;
                        if (f10 >= 0.0f) {
                            float qY2 = (f10 / this.XC.qY()) + this.XD.get(i8);
                            if (Math.abs(qY2) > this.XC.rc()) {
                                qY2 = this.XC.rc();
                            }
                            this.XD.append(i8, (int) qY2);
                            i2++;
                            ra4 = f11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int aX(int i) {
        if (i > 0) {
            q item = this.Yf.getItem(i - this.Yf.getHeaderViewsCount());
            if (item instanceof BaseCardInfo) {
                return ((BaseCardInfo) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aX;
        int aX2;
        if (this.Yf != null && this.Yg != null && this.mScrollState == 1 && !this.XG) {
            int findFirstVisibleItemPosition = i3 - this.Yg.findFirstVisibleItemPosition();
            int aX3 = aX(i3);
            if (aX3 >= 0) {
                this.Yh.add(Integer.valueOf(aX3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Yf.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Yf.getChildAt(i5);
                    int childAdapterPosition = this.Yf.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aX2 = aX(childAdapterPosition)) >= 0 && !this.Yh.contains(Integer.valueOf(aX2))) {
                        this.Yh.add(Integer.valueOf(aX2));
                        a(childAt, i4, childAdapterPosition, i3, aX2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Yf.getChildAt(i7);
                        int childAdapterPosition2 = this.Yf.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aX = aX(childAdapterPosition2)) >= 0 && !this.Yh.contains(Integer.valueOf(aX))) {
                            this.Yh.add(Integer.valueOf(aX));
                            a(childAt2, i4, childAdapterPosition2, i3, aX);
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
                    float B = B(view) + (i * this.XC.rf());
                    if (B > c(i4, i2, true) + (-this.XD.get(i4))) {
                        a(view, i2, B);
                    } else {
                        c(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.XC.re());
                    if (B2 > c(i4, i2, false) + (-this.XD.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        c(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.XC.rf());
                if (B3 < c(i4, i2, false) + (-this.XD.get(i4))) {
                    a(view, i2, B3);
                } else {
                    c(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.XC.re());
                if (B4 < c(i4, i2, true) + (-this.XD.get(i4))) {
                    a(view, i2, B4);
                } else {
                    c(view, i2);
                }
            }
        }
    }

    private void c(final View view, final int i) {
        final int aX;
        if (view != null && (aX = aX(i)) >= 0) {
            ValueAnimator valueAnimator = this.XH.get(aX);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.XC.ri());
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
                        o.this.XH.delete(aX);
                        o.this.XI.delete(aX);
                        o.this.XD.delete(aX);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        o.this.XH.delete(aX);
                        o.this.XI.delete(aX);
                        o.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.XH.append(aX, ofFloat);
                this.XI.append(aX, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XI.get(aX)) + this.XC.rg()) {
                this.XI.append(aX, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aV(int i) {
        if (this.Yf != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.XD.clear();
                qW();
            } else if (this.mScrollState == 2) {
                qW();
            } else if (this.mScrollState == 1) {
                this.XD.clear();
                qW();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aX;
        float f;
        float f2;
        if (this.Yf != null && this.Yg != null && this.mScrollState != 0 && (aX = aX((childAdapterPosition = this.Yf.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Yg.findFirstVisibleItemPosition()) {
                float B = this.Yf.getChildAt(1) != null ? B(this.Yf.getChildAt(1)) : 0.0f;
                int aX2 = aX(childAdapterPosition + 1);
                if (aX2 >= 0) {
                    if (aX2 == aX) {
                        m(view, B);
                    } else {
                        float f3 = -this.XD.get(aX, 0);
                        if (f3 != 0.0f) {
                            this.XE = f3;
                            f2 = f3;
                        } else {
                            f2 = this.XE;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Yf.getChildAt(this.Yf.getChildCount() + (-2)) != null ? B(this.Yf.getChildAt(this.Yf.getChildCount() - 2)) : 0.0f;
                int aX3 = aX(childAdapterPosition - 1);
                if (aX3 >= 0) {
                    if (aX3 == aX) {
                        m(view, B2);
                    } else {
                        float f4 = -this.XD.get(aX, 0);
                        if (f4 != 0.0f) {
                            this.XF = f4;
                            f = f4;
                        } else {
                            f = this.XF;
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
        if (this.Yf != null) {
            m(view, 0.0f);
            int aX = aX(this.Yf.getChildAdapterPosition(view));
            if (aX >= 0 && b(aX, 0, true) == -1) {
                this.XD.delete(aX);
                if (this.XH.get(aX) != null) {
                    this.XH.get(aX).cancel();
                }
                this.XH.delete(aX);
                this.XI.delete(aX);
            }
        }
    }

    private void qW() {
        int childCount = this.Yf.getChildCount();
        this.Yi.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Yf.getChildAt(i);
            int childAdapterPosition = this.Yf.getChildAdapterPosition(childAt);
            int aX = aX(childAdapterPosition);
            if (aX >= 0 && !this.Yi.contains(Integer.valueOf(aX))) {
                this.Yi.add(Integer.valueOf(aX));
                c(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Yf.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aX(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aX(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.Yf, i, f);
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
            return B(this.Yf.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Yf.getChildAt(b(i - 1, i2, false)));
    }
}
