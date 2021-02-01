package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashSet;
/* loaded from: classes.dex */
public class m {
    private BdTypeRecyclerView XW;
    private LinearLayoutManager XX;
    private j Xu;
    private float Xw;
    private float Xx;
    private int mOrientation;
    private int mScrollState;
    private boolean Xy = false;
    private HashSet<Integer> XY = new HashSet<>();
    private HashSet<Integer> XZ = new HashSet<>();
    private SparseIntArray Xv = new SparseIntArray();
    private SparseArray<ValueAnimator> Xz = new SparseArray<>();
    private SparseIntArray XA = new SparseIntArray();

    public m(j jVar) {
        this.Xu = jVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.XW = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.XX = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.XW != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Xu.qH()) {
                this.Xy = true;
                qw();
                return;
            }
            this.Xy = false;
            if (Math.abs(f2) > this.Xu.qD()) {
                f3 = f2 > 0.0f ? this.Xu.qD() : -this.Xu.qD();
            } else {
                f3 = f2;
            }
            this.Xv.clear();
            float qz = f3 * this.Xu.qz();
            int aY = aY(i);
            if (aY >= 0) {
                if (f3 < 0.0f) {
                    int i3 = 1;
                    float qA = this.Xu.qA();
                    while (true) {
                        int i4 = aY - i3;
                        float f4 = (i3 * qA) + qz;
                        qA *= 1.2f;
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
                        int i5 = aY + i2;
                        float f5 = qz + (i2 * qA2);
                        float f6 = qA2 * 1.2f;
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
                        int i7 = aY - i6;
                        float f7 = qz - (i6 * qA3);
                        qA3 *= 1.2f;
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
                        int i8 = aY + i2;
                        float f8 = qz - (i2 * qA4);
                        qA4 *= 1.2f;
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
    }

    private int aY(int i) {
        if (i > 0) {
            n item = this.XW.getItem(i - this.XW.getHeaderViewsCount());
            if (item instanceof BaseCardInfo) {
                return ((BaseCardInfo) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aY;
        int aY2;
        if (this.XW != null && this.XX != null && this.mScrollState == 1 && !this.Xy) {
            int findFirstVisibleItemPosition = i3 - this.XX.findFirstVisibleItemPosition();
            int aY3 = aY(i3);
            if (aY3 >= 0) {
                this.XY.add(Integer.valueOf(aY3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.XW.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.XW.getChildAt(i5);
                    int childAdapterPosition = this.XW.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aY2 = aY(childAdapterPosition)) >= 0 && !this.XY.contains(Integer.valueOf(aY2))) {
                        this.XY.add(Integer.valueOf(aY2));
                        c(childAt, i4, childAdapterPosition, i3, aY2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.XW.getChildAt(i7);
                        int childAdapterPosition2 = this.XW.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aY = aY(childAdapterPosition2)) >= 0 && !this.XY.contains(Integer.valueOf(aY))) {
                            this.XY.add(Integer.valueOf(aY));
                            c(childAt2, i4, childAdapterPosition2, i3, aY);
                        }
                        i6 = i7 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            if (i < 0) {
                if (i2 < i3) {
                    float B = B(view) + (i * this.Xu.qF());
                    if (B > c(i4, i2, true) + (-this.Xv.get(i4))) {
                        a(view, i2, B);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.Xu.qE());
                    if (B2 > c(i4, i2, false) + (-this.Xv.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.Xu.qF());
                if (B3 < c(i4, i2, false) + (-this.Xv.get(i4))) {
                    a(view, i2, B3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.Xu.qE());
                if (B4 < c(i4, i2, true) + (-this.Xv.get(i4))) {
                    a(view, i2, B4);
                } else {
                    e(view, i2);
                }
            }
        }
    }

    private void e(final View view, final int i) {
        final int aY;
        if (view != null && (aY = aY(i)) >= 0) {
            ValueAnimator valueAnimator = this.Xz.get(aY);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.Xu.qI());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.m.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        m.this.a(view, i, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.m.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        m.this.Xz.delete(aY);
                        m.this.XA.delete(aY);
                        m.this.Xv.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        m.this.Xz.delete(aY);
                        m.this.XA.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.Xz.append(aY, ofFloat);
                this.XA.append(aY, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XA.get(aY)) + this.Xu.qG()) {
                this.XA.append(aY, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aW(int i) {
        if (this.XW != null) {
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

    public void C(View view) {
        int childAdapterPosition;
        int aY;
        float f;
        float f2;
        if (this.XW != null && this.XX != null && this.mScrollState != 0 && (aY = aY((childAdapterPosition = this.XW.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.XX.findFirstVisibleItemPosition()) {
                float B = this.XW.getChildAt(1) != null ? B(this.XW.getChildAt(1)) : 0.0f;
                int aY2 = aY(childAdapterPosition + 1);
                if (aY2 >= 0) {
                    if (aY2 == aY) {
                        m(view, B);
                    } else {
                        float f3 = -this.Xv.get(aY, 0);
                        if (f3 != 0.0f) {
                            this.Xw = f3;
                            f2 = f3;
                        } else {
                            f2 = this.Xw;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.XW.getChildAt(this.XW.getChildCount() + (-2)) != null ? B(this.XW.getChildAt(this.XW.getChildCount() - 2)) : 0.0f;
                int aY3 = aY(childAdapterPosition - 1);
                if (aY3 >= 0) {
                    if (aY3 == aY) {
                        m(view, B2);
                    } else {
                        float f4 = -this.Xv.get(aY, 0);
                        if (f4 != 0.0f) {
                            this.Xx = f4;
                            f = f4;
                        } else {
                            f = this.Xx;
                        }
                        m(view, B2 + f);
                    }
                } else {
                    return;
                }
            }
            e(view, childAdapterPosition);
        }
    }

    public void D(View view) {
        if (this.XW != null) {
            m(view, 0.0f);
            int aY = aY(this.XW.getChildAdapterPosition(view));
            if (aY >= 0 && b(aY, 0, true) == -1) {
                this.Xv.delete(aY);
                if (this.Xz.get(aY) != null) {
                    this.Xz.get(aY).cancel();
                }
                this.Xz.delete(aY);
                this.XA.delete(aY);
            }
        }
    }

    private void qw() {
        int childCount = this.XW.getChildCount();
        this.XZ.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.XW.getChildAt(i);
            int childAdapterPosition = this.XW.getChildAdapterPosition(childAt);
            int aY = aY(childAdapterPosition);
            if (aY >= 0 && !this.XZ.contains(Integer.valueOf(aY))) {
                this.XZ.add(Integer.valueOf(aY));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.XW.getCount() - i2;
            for (int i3 = 1; i3 < count; i3++) {
                int i4 = i2 + i3;
                if (i == aY(i4)) {
                    return i4;
                }
            }
        } else {
            for (int i5 = 1; i5 < i2; i5++) {
                int i6 = i2 - i5;
                if (i == aY(i6)) {
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
                CardLinkageManager.INSTANCE.translationY(this.XW, i, f);
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
            return B(this.XW.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.XW.getChildAt(b(i - 1, i2, false)));
    }
}
