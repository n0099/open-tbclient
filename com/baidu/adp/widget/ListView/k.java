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
    private l Vo;
    private float Vq;
    private float Vr;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Vs = false;
    private SparseIntArray Vp = new SparseIntArray();
    private SparseArray<ValueAnimator> Vt = new SparseArray<>();
    private SparseIntArray Vu = new SparseIntArray();

    public k(l lVar) {
        this.Vo = lVar;
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
            if (Math.abs(f2) < this.Vo.pB()) {
                this.Vs = true;
                pq();
                return;
            }
            this.mCurrentPosition = i;
            this.Vs = false;
            if (Math.abs(f2) > this.Vo.px()) {
                f3 = f2 > 0.0f ? this.Vo.px() : -this.Vo.px();
            } else {
                f3 = f2;
            }
            this.Vp.clear();
            float pt = f3 * this.Vo.pt();
            if (f3 < 0.0f) {
                float pu = this.Vo.pu();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = pt + (i3 * pu);
                    float f5 = pu * 1.4f;
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
                    int i5 = i + i2;
                    float f6 = pt + (i2 * pu2);
                    float f7 = pu2 * 1.4f;
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
                    int i7 = i - i6;
                    float f8 = pt - (i6 * pu3);
                    float f9 = pu3 * 1.4f;
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
                    int i8 = i + i2;
                    float f10 = pt - (i2 * pu4);
                    float f11 = pu4 * 1.4f;
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

    public void aK(int i) {
        if (this.mRecyclerView != null) {
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

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Vs) {
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
                    float B = B(view) + (this.Vo.pz() * f);
                    if (B > (-this.Vp.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.Vo.py() * f);
                    if (B2 > (-this.Vp.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.Vo.pz() * f);
                if (B3 < (-this.Vp.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.Vo.py() * f);
                if (B4 < (-this.Vp.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.Vp.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Vq = f;
                    } else {
                        f = this.Vq;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Vp.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Vr = f2;
                    } else {
                        f2 = this.Vr;
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
            this.Vp.delete(childAdapterPosition);
            if (this.Vt.get(childAdapterPosition) != null) {
                this.Vt.get(childAdapterPosition).cancel();
            }
            this.Vt.delete(childAdapterPosition);
            this.Vu.delete(childAdapterPosition);
        }
    }

    private void pq() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.Vt.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new m(1.0f));
                ofFloat.setDuration(this.Vo.pC());
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
                        k.this.Vt.delete(i);
                        k.this.Vu.delete(i);
                        k.this.Vp.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        k.this.Vt.delete(i);
                        k.this.Vu.delete(i);
                        k.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Vt.append(i, ofFloat);
                this.Vu.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.Vu.get(i)) + this.Vo.pA()) {
                this.Vu.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
