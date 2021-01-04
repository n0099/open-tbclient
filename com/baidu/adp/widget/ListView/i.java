package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class i {
    private j XA;
    private float XC;
    private float XD;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean XE = false;
    private SparseIntArray XB = new SparseIntArray();
    private SparseArray<ValueAnimator> XF = new SparseArray<>();
    private SparseIntArray XG = new SparseIntArray();

    public i(j jVar) {
        this.XA = jVar;
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
            if (Math.abs(f2) < this.XA.qJ()) {
                this.XE = true;
                qy();
                return;
            }
            this.mCurrentPosition = i;
            this.XE = false;
            if (Math.abs(f2) > this.XA.qF()) {
                f3 = f2 > 0.0f ? this.XA.qF() : -this.XA.qF();
            } else {
                f3 = f2;
            }
            this.XB.clear();
            float qB = f3 * this.XA.qB();
            if (f3 < 0.0f) {
                int i3 = 1;
                float qC = this.XA.qC();
                while (true) {
                    int i4 = i - i3;
                    float f4 = (i3 * qC) + qB;
                    qC *= 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float qA = (f4 / this.XA.qA()) + this.XB.get(i4);
                    if (Math.abs(qA) > this.XA.qE()) {
                        qA = -this.XA.qE();
                    }
                    this.XB.append(i4, (int) qA);
                    i3++;
                }
                float qC2 = this.XA.qC();
                while (true) {
                    int i5 = i + i2;
                    float f5 = qB + (i2 * qC2);
                    float f6 = qC2 * 1.4f;
                    if (f5 <= 0.0f) {
                        float qz = (f5 / this.XA.qz()) + this.XB.get(i5);
                        if (Math.abs(qz) > this.XA.qD()) {
                            qz = -this.XA.qD();
                        }
                        this.XB.append(i5, (int) qz);
                        i2++;
                        qC2 = f6;
                    } else {
                        return;
                    }
                }
            } else {
                int i6 = 1;
                float qC3 = this.XA.qC();
                while (true) {
                    int i7 = i - i6;
                    float f7 = qB - (i6 * qC3);
                    qC3 *= 1.4f;
                    if (f7 < 0.0f) {
                        break;
                    }
                    float qz2 = (f7 / this.XA.qz()) + this.XB.get(i7);
                    if (Math.abs(qz2) > this.XA.qD()) {
                        qz2 = this.XA.qD();
                    }
                    this.XB.append(i7, (int) qz2);
                    i6++;
                }
                float qC4 = this.XA.qC();
                while (true) {
                    int i8 = i + i2;
                    float f8 = qB - (i2 * qC4);
                    qC4 *= 1.4f;
                    if (f8 >= 0.0f) {
                        float qA2 = (f8 / this.XA.qA()) + this.XB.get(i8);
                        if (Math.abs(qA2) > this.XA.qE()) {
                            qA2 = this.XA.qE();
                        }
                        this.XB.append(i8, (int) qA2);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aW(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.XB.clear();
                qy();
            } else if (this.mScrollState == 2) {
                qy();
            } else if (this.mScrollState == 1) {
                this.XB.clear();
                qy();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.XE) {
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
                    float B = B(view) + (this.XA.qH() * f);
                    if (B > (-this.XB.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.XA.qG() * f);
                    if (B2 > (-this.XB.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.XA.qH() * f);
                if (B3 < (-this.XB.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.XA.qG() * f);
                if (B4 < (-this.XB.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, B4);
                } else {
                    e(view, i);
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
                    float f = -this.XB.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.XC = f;
                    } else {
                        f = this.XC;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.XB.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.XD = f2;
                    } else {
                        f2 = this.XD;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? B(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                e(view, childAdapterPosition);
            }
        }
    }

    public void D(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.XB.delete(childAdapterPosition);
            if (this.XF.get(childAdapterPosition) != null) {
                this.XF.get(childAdapterPosition).cancel();
            }
            this.XF.delete(childAdapterPosition);
            this.XG.delete(childAdapterPosition);
        }
    }

    private void qy() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.XF.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.XA.qK());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.i.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        i.this.m(view, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.i.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        i.this.XF.delete(i);
                        i.this.XG.delete(i);
                        i.this.XB.delete(i);
                        i.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        i.this.XF.delete(i);
                        i.this.XG.delete(i);
                        i.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.XF.append(i, ofFloat);
                this.XG.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XG.get(i)) + this.XA.qI()) {
                this.XG.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
