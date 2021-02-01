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
    private j Xu;
    private float Xw;
    private float Xx;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean Xy = false;
    private SparseIntArray Xv = new SparseIntArray();
    private SparseArray<ValueAnimator> Xz = new SparseArray<>();
    private SparseIntArray XA = new SparseIntArray();

    public i(j jVar) {
        this.Xu = jVar;
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
            if (Math.abs(f2) < this.Xu.qH()) {
                this.Xy = true;
                qw();
                return;
            }
            this.mCurrentPosition = i;
            this.Xy = false;
            if (Math.abs(f2) > this.Xu.qD()) {
                f3 = f2 > 0.0f ? this.Xu.qD() : -this.Xu.qD();
            } else {
                f3 = f2;
            }
            this.Xv.clear();
            float qz = f3 * this.Xu.qz();
            if (f3 < 0.0f) {
                int i3 = 1;
                float qA = this.Xu.qA();
                while (true) {
                    int i4 = i - i3;
                    float f4 = (i3 * qA) + qz;
                    qA *= 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float qy = (f4 / this.Xu.qy()) + this.Xv.get(i4);
                    if (Math.abs(qy) > this.Xu.qC()) {
                        qy = -this.Xu.qC();
                    }
                    this.Xv.append(i4, (int) qy);
                    i3++;
                }
                float qA2 = this.Xu.qA();
                while (true) {
                    int i5 = i + i2;
                    float f5 = qz + (i2 * qA2);
                    float f6 = qA2 * 1.4f;
                    if (f5 <= 0.0f) {
                        float qx = (f5 / this.Xu.qx()) + this.Xv.get(i5);
                        if (Math.abs(qx) > this.Xu.qB()) {
                            qx = -this.Xu.qB();
                        }
                        this.Xv.append(i5, (int) qx);
                        i2++;
                        qA2 = f6;
                    } else {
                        return;
                    }
                }
            } else {
                int i6 = 1;
                float qA3 = this.Xu.qA();
                while (true) {
                    int i7 = i - i6;
                    float f7 = qz - (i6 * qA3);
                    qA3 *= 1.4f;
                    if (f7 < 0.0f) {
                        break;
                    }
                    float qx2 = (f7 / this.Xu.qx()) + this.Xv.get(i7);
                    if (Math.abs(qx2) > this.Xu.qB()) {
                        qx2 = this.Xu.qB();
                    }
                    this.Xv.append(i7, (int) qx2);
                    i6++;
                }
                float qA4 = this.Xu.qA();
                while (true) {
                    int i8 = i + i2;
                    float f8 = qz - (i2 * qA4);
                    qA4 *= 1.4f;
                    if (f8 >= 0.0f) {
                        float qy2 = (f8 / this.Xu.qy()) + this.Xv.get(i8);
                        if (Math.abs(qy2) > this.Xu.qC()) {
                            qy2 = this.Xu.qC();
                        }
                        this.Xv.append(i8, (int) qy2);
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
                this.Xv.clear();
                qw();
            } else if (this.mScrollState == 2) {
                qw();
            } else if (this.mScrollState == 1) {
                this.Xv.clear();
                qw();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.Xy) {
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
                    float B = B(view) + (this.Xu.qF() * f);
                    if (B > (-this.Xv.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, B);
                    } else {
                        e(view, i);
                    }
                } else if (i > i2) {
                    float B2 = B(view) + (this.Xu.qE() * f);
                    if (B2 > (-this.Xv.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, B2);
                    } else {
                        e(view, i);
                    }
                }
            } else if (i > i2) {
                float B3 = B(view) + (this.Xu.qF() * f);
                if (B3 < (-this.Xv.get(i)) + B(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, B3);
                } else {
                    e(view, i);
                }
            } else if (i < i2) {
                float B4 = B(view) + (this.Xu.qE() * f);
                if (B4 < (-this.Xv.get(i)) + B(this.mRecyclerView.getChildAt(i3 + 1))) {
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
                    float f = -this.Xv.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.Xw = f;
                    } else {
                        f = this.Xw;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? B(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.Xv.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.Xx = f2;
                    } else {
                        f2 = this.Xx;
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
            this.Xv.delete(childAdapterPosition);
            if (this.Xz.get(childAdapterPosition) != null) {
                this.Xz.get(childAdapterPosition).cancel();
            }
            this.Xz.delete(childAdapterPosition);
            this.XA.delete(childAdapterPosition);
        }
    }

    private void qw() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            e(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void e(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.Xz.get(i);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.Xu.qI());
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
                        i.this.Xz.delete(i);
                        i.this.XA.delete(i);
                        i.this.Xv.delete(i);
                        i.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        i.this.Xz.delete(i);
                        i.this.XA.delete(i);
                        i.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Xz.append(i, ofFloat);
                this.XA.append(i, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XA.get(i)) + this.Xu.qG()) {
                this.XA.append(i, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
