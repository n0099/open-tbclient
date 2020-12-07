package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
/* loaded from: classes.dex */
public class k {
    private l XC;
    private float XE;
    private float XF;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean XG = false;
    private SparseIntArray XD = new SparseIntArray();
    private SparseArray<ValueAnimator> XH = new SparseArray<>();
    private SparseIntArray XI = new SparseIntArray();

    public k(l lVar) {
        this.XC = lVar;
    }

    public void a(RecyclerView recyclerView, int i) {
        this.mRecyclerView = recyclerView;
        this.mOrientation = i;
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.mRecyclerView != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.XC.rh()) {
                this.XG = true;
                qW();
                return;
            }
            this.mCurrentPosition = i;
            this.XG = false;
            if (Math.abs(f2) > this.XC.rd()) {
                f3 = f2 > 0.0f ? this.XC.rd() : -this.XC.rd();
            } else {
                f3 = f2;
            }
            this.XD.clear();
            float qZ = f3 * this.XC.qZ();
            if (f3 < 0.0f) {
                float ra = this.XC.ra();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = qZ + (i3 * ra);
                    float f5 = ra * 1.4f;
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
                    int i5 = i + i2;
                    float f6 = qZ + (i2 * ra2);
                    float f7 = ra2 * 1.4f;
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
                    int i7 = i - i6;
                    float f8 = qZ - (i6 * ra3);
                    float f9 = ra3 * 1.4f;
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
                    int i8 = i + i2;
                    float f10 = qZ - (i2 * ra4);
                    float f11 = ra4 * 1.4f;
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

    public void aV(int i) {
        if (this.mRecyclerView != null) {
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

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.XG) {
            if (this.mOrientation != 2) {
                i2 = i;
            }
            int childCount = this.mRecyclerView.getChildCount();
            if (this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                int findFirstVisibleItemPosition = i3 - ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                    View childAt = this.mRecyclerView.getChildAt(i4);
                    int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1) {
                        a(childAt, i2, childAdapterPosition, i3, i4);
                    }
                }
                for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                    View childAt2 = this.mRecyclerView.getChildAt(i5);
                    int childAdapterPosition2 = this.mRecyclerView.getChildAdapterPosition(childAt2);
                    if (childAdapterPosition2 != -1) {
                        a(childAt2, i2, childAdapterPosition2, i3, i5);
                    }
                }
            }
        }
    }

    private float B(View view) {
        if (view == null) {
            return 0.0f;
        }
        return this.mOrientation == 2 ? view.getTranslationY() : view.getTranslationX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, float f) {
        if (view != null) {
            if (this.mOrientation == 2) {
                view.setTranslationY(f);
            } else {
                view.setTranslationX(f);
            }
        }
    }

    private void a(View view, float f, int i, int i2, int i3) {
        if (view != null) {
            if (f < 0.0f) {
                if (i < i2) {
                    float B = B(view) + (this.XC.rf() * f);
                    if (B > (-this.XD.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.XC.re() * f);
                    if (B2 > (-this.XD.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.XC.rf() * f);
                if (B3 < (-this.XD.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.XC.re() * f);
                if (B4 < (-this.XD.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, B4);
                } else {
                    c(view, i);
                }
            }
        }
    }

    public void C(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.XD.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.XE = f;
                    } else {
                        f = this.XE;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.XD.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.XF = f2;
                    } else {
                        f2 = this.XF;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? B(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                c(view, childAdapterPosition);
            }
        }
    }

    public void D(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.XD.delete(childAdapterPosition);
            if (this.XH.get(childAdapterPosition) != null) {
                this.XH.get(childAdapterPosition).cancel();
            }
            this.XH.delete(childAdapterPosition);
            this.XI.delete(childAdapterPosition);
        }
    }

    private void qW() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.XH.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.XC.ri());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.k.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        k.this.m(view, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.k.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.XH.delete(i);
                        k.this.XI.delete(i);
                        k.this.XD.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        k.this.XH.delete(i);
                        k.this.XI.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.XH.append(i, ofFloat);
                this.XI.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XI.get(i)) + this.XC.rg()) {
                this.XI.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
