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
    private float XA;
    private float XB;
    private j Xy;
    private BdTypeRecyclerView Ya;
    private LinearLayoutManager Yb;
    private int mOrientation;
    private int mScrollState;
    private boolean XC = false;
    private HashSet<Integer> Yc = new HashSet<>();
    private HashSet<Integer> Ye = new HashSet<>();
    private SparseIntArray Xz = new SparseIntArray();
    private SparseArray<ValueAnimator> XD = new SparseArray<>();
    private SparseIntArray XE = new SparseIntArray();

    public m(j jVar) {
        this.Xy = jVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Ya = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Yb = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Ya != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.Xy.qJ()) {
                this.XC = true;
                qy();
                return;
            }
            this.XC = false;
            if (Math.abs(f2) > this.Xy.qF()) {
                f3 = f2 > 0.0f ? this.Xy.qF() : -this.Xy.qF();
            } else {
                f3 = f2;
            }
            this.Xz.clear();
            float qB = f3 * this.Xy.qB();
            int aY = aY(i);
            if (aY >= 0) {
                if (f3 < 0.0f) {
                    int i3 = 1;
                    float qC = this.Xy.qC();
                    while (true) {
                        int i4 = aY - i3;
                        float f4 = (i3 * qC) + qB;
                        qC *= 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float qA = (f4 / this.Xy.qA()) + this.Xz.get(i4);
                        if (Math.abs(qA) > this.Xy.qE()) {
                            qA = -this.Xy.qE();
                        }
                        this.Xz.append(i4, (int) qA);
                        i3++;
                    }
                    float qC2 = this.Xy.qC();
                    while (true) {
                        int i5 = aY + i2;
                        float f5 = qB + (i2 * qC2);
                        float f6 = qC2 * 1.2f;
                        if (f5 <= 0.0f) {
                            float qz = (f5 / this.Xy.qz()) + this.Xz.get(i5);
                            if (Math.abs(qz) > this.Xy.qD()) {
                                qz = -this.Xy.qD();
                            }
                            this.Xz.append(i5, (int) qz);
                            i2++;
                            qC2 = f6;
                        } else {
                            return;
                        }
                    }
                } else {
                    int i6 = 1;
                    float qC3 = this.Xy.qC();
                    while (true) {
                        int i7 = aY - i6;
                        float f7 = qB - (i6 * qC3);
                        qC3 *= 1.2f;
                        if (f7 < 0.0f) {
                            break;
                        }
                        float qz2 = (f7 / this.Xy.qz()) + this.Xz.get(i7);
                        if (Math.abs(qz2) > this.Xy.qD()) {
                            qz2 = this.Xy.qD();
                        }
                        this.Xz.append(i7, (int) qz2);
                        i6++;
                    }
                    float qC4 = this.Xy.qC();
                    while (true) {
                        int i8 = aY + i2;
                        float f8 = qB - (i2 * qC4);
                        qC4 *= 1.2f;
                        if (f8 >= 0.0f) {
                            float qA2 = (f8 / this.Xy.qA()) + this.Xz.get(i8);
                            if (Math.abs(qA2) > this.Xy.qE()) {
                                qA2 = this.Xy.qE();
                            }
                            this.Xz.append(i8, (int) qA2);
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
            n item = this.Ya.getItem(i - this.Ya.getHeaderViewsCount());
            if (item instanceof BaseCardInfo) {
                return ((BaseCardInfo) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aY;
        int aY2;
        if (this.Ya != null && this.Yb != null && this.mScrollState == 1 && !this.XC) {
            int findFirstVisibleItemPosition = i3 - this.Yb.findFirstVisibleItemPosition();
            int aY3 = aY(i3);
            if (aY3 >= 0) {
                this.Yc.add(Integer.valueOf(aY3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Ya.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Ya.getChildAt(i5);
                    int childAdapterPosition = this.Ya.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aY2 = aY(childAdapterPosition)) >= 0 && !this.Yc.contains(Integer.valueOf(aY2))) {
                        this.Yc.add(Integer.valueOf(aY2));
                        c(childAt, i4, childAdapterPosition, i3, aY2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Ya.getChildAt(i7);
                        int childAdapterPosition2 = this.Ya.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aY = aY(childAdapterPosition2)) >= 0 && !this.Yc.contains(Integer.valueOf(aY))) {
                            this.Yc.add(Integer.valueOf(aY));
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
                    float B = B(view) + (i * this.Xy.qH());
                    if (B > c(i4, i2, true) + (-this.Xz.get(i4))) {
                        a(view, i2, B);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.Xy.qG());
                    if (B2 > c(i4, i2, false) + (-this.Xz.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.Xy.qH());
                if (B3 < c(i4, i2, false) + (-this.Xz.get(i4))) {
                    a(view, i2, B3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.Xy.qG());
                if (B4 < c(i4, i2, true) + (-this.Xz.get(i4))) {
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
            ValueAnimator valueAnimator = this.XD.get(aY);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.Xy.qK());
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
                        m.this.XD.delete(aY);
                        m.this.XE.delete(aY);
                        m.this.Xz.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        m.this.XD.delete(aY);
                        m.this.XE.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.XD.append(aY, ofFloat);
                this.XE.append(aY, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.XE.get(aY)) + this.Xy.qI()) {
                this.XE.append(aY, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aW(int i) {
        if (this.Ya != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.Xz.clear();
                qy();
            } else if (this.mScrollState == 2) {
                qy();
            } else if (this.mScrollState == 1) {
                this.Xz.clear();
                qy();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aY;
        float f;
        float f2;
        if (this.Ya != null && this.Yb != null && this.mScrollState != 0 && (aY = aY((childAdapterPosition = this.Ya.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Yb.findFirstVisibleItemPosition()) {
                float B = this.Ya.getChildAt(1) != null ? B(this.Ya.getChildAt(1)) : 0.0f;
                int aY2 = aY(childAdapterPosition + 1);
                if (aY2 >= 0) {
                    if (aY2 == aY) {
                        m(view, B);
                    } else {
                        float f3 = -this.Xz.get(aY, 0);
                        if (f3 != 0.0f) {
                            this.XA = f3;
                            f2 = f3;
                        } else {
                            f2 = this.XA;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Ya.getChildAt(this.Ya.getChildCount() + (-2)) != null ? B(this.Ya.getChildAt(this.Ya.getChildCount() - 2)) : 0.0f;
                int aY3 = aY(childAdapterPosition - 1);
                if (aY3 >= 0) {
                    if (aY3 == aY) {
                        m(view, B2);
                    } else {
                        float f4 = -this.Xz.get(aY, 0);
                        if (f4 != 0.0f) {
                            this.XB = f4;
                            f = f4;
                        } else {
                            f = this.XB;
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
        if (this.Ya != null) {
            m(view, 0.0f);
            int aY = aY(this.Ya.getChildAdapterPosition(view));
            if (aY >= 0 && b(aY, 0, true) == -1) {
                this.Xz.delete(aY);
                if (this.XD.get(aY) != null) {
                    this.XD.get(aY).cancel();
                }
                this.XD.delete(aY);
                this.XE.delete(aY);
            }
        }
    }

    private void qy() {
        int childCount = this.Ya.getChildCount();
        this.Ye.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Ya.getChildAt(i);
            int childAdapterPosition = this.Ya.getChildAdapterPosition(childAt);
            int aY = aY(childAdapterPosition);
            if (aY >= 0 && !this.Ye.contains(Integer.valueOf(aY))) {
                this.Ye.add(Integer.valueOf(aY));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Ya.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.Ya, i, f);
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
            return B(this.Ya.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Ya.getChildAt(b(i - 1, i2, false)));
    }
}
