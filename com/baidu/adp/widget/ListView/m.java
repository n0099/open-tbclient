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
    private j YN;
    private float YP;
    private float YQ;
    private BdTypeRecyclerView Zq;
    private LinearLayoutManager Zr;
    private int mOrientation;
    private int mScrollState;
    private boolean YR = false;
    private HashSet<Integer> Zs = new HashSet<>();
    private HashSet<Integer> Zt = new HashSet<>();
    private SparseIntArray YO = new SparseIntArray();
    private SparseArray<ValueAnimator> YS = new SparseArray<>();
    private SparseIntArray YT = new SparseIntArray();

    public m(j jVar) {
        this.YN = jVar;
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.Zq = bdTypeRecyclerView;
        this.mOrientation = i;
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.Zr = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public void a(float f, float f2, int i) {
        float f3;
        int i2 = 1;
        if (this.Zq != null) {
            if (this.mOrientation != 2) {
                f2 = f;
            }
            if (Math.abs(f2) < this.YN.qH()) {
                this.YR = true;
                qw();
                return;
            }
            this.YR = false;
            if (Math.abs(f2) > this.YN.qD()) {
                f3 = f2 > 0.0f ? this.YN.qD() : -this.YN.qD();
            } else {
                f3 = f2;
            }
            this.YO.clear();
            float qz = f3 * this.YN.qz();
            int aY = aY(i);
            if (aY >= 0) {
                if (f3 < 0.0f) {
                    int i3 = 1;
                    float qA = this.YN.qA();
                    while (true) {
                        int i4 = aY - i3;
                        float f4 = (i3 * qA) + qz;
                        qA *= 1.2f;
                        if (f4 > 0.0f) {
                            break;
                        }
                        float qy = (f4 / this.YN.qy()) + this.YO.get(i4);
                        if (Math.abs(qy) > this.YN.qC()) {
                            qy = -this.YN.qC();
                        }
                        this.YO.append(i4, (int) qy);
                        i3++;
                    }
                    float qA2 = this.YN.qA();
                    while (true) {
                        int i5 = aY + i2;
                        float f5 = qz + (i2 * qA2);
                        float f6 = qA2 * 1.2f;
                        if (f5 <= 0.0f) {
                            float qx = (f5 / this.YN.qx()) + this.YO.get(i5);
                            if (Math.abs(qx) > this.YN.qB()) {
                                qx = -this.YN.qB();
                            }
                            this.YO.append(i5, (int) qx);
                            i2++;
                            qA2 = f6;
                        } else {
                            return;
                        }
                    }
                } else {
                    int i6 = 1;
                    float qA3 = this.YN.qA();
                    while (true) {
                        int i7 = aY - i6;
                        float f7 = qz - (i6 * qA3);
                        qA3 *= 1.2f;
                        if (f7 < 0.0f) {
                            break;
                        }
                        float qx2 = (f7 / this.YN.qx()) + this.YO.get(i7);
                        if (Math.abs(qx2) > this.YN.qB()) {
                            qx2 = this.YN.qB();
                        }
                        this.YO.append(i7, (int) qx2);
                        i6++;
                    }
                    float qA4 = this.YN.qA();
                    while (true) {
                        int i8 = aY + i2;
                        float f8 = qz - (i2 * qA4);
                        qA4 *= 1.2f;
                        if (f8 >= 0.0f) {
                            float qy2 = (f8 / this.YN.qy()) + this.YO.get(i8);
                            if (Math.abs(qy2) > this.YN.qC()) {
                                qy2 = this.YN.qC();
                            }
                            this.YO.append(i8, (int) qy2);
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
            n item = this.Zq.getItem(i - this.Zq.getHeaderViewsCount());
            if (item instanceof BaseCardInfo) {
                return ((BaseCardInfo) item).position;
            }
        }
        return -1;
    }

    public void j(int i, int i2, int i3) {
        int aY;
        int aY2;
        if (this.Zq != null && this.Zr != null && this.mScrollState == 1 && !this.YR) {
            int findFirstVisibleItemPosition = i3 - this.Zr.findFirstVisibleItemPosition();
            int aY3 = aY(i3);
            if (aY3 >= 0) {
                this.Zs.add(Integer.valueOf(aY3));
                int i4 = this.mOrientation == 2 ? i2 : i;
                int childCount = this.Zq.getChildCount();
                for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                    View childAt = this.Zq.getChildAt(i5);
                    int childAdapterPosition = this.Zq.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1 && (aY2 = aY(childAdapterPosition)) >= 0 && !this.Zs.contains(Integer.valueOf(aY2))) {
                        this.Zs.add(Integer.valueOf(aY2));
                        c(childAt, i4, childAdapterPosition, i3, aY2);
                    }
                }
                int i6 = findFirstVisibleItemPosition + 1;
                while (true) {
                    int i7 = i6;
                    if (i7 <= childCount - 1) {
                        View childAt2 = this.Zq.getChildAt(i7);
                        int childAdapterPosition2 = this.Zq.getChildAdapterPosition(childAt2);
                        if (childAdapterPosition2 != -1 && (aY = aY(childAdapterPosition2)) >= 0 && !this.Zs.contains(Integer.valueOf(aY))) {
                            this.Zs.add(Integer.valueOf(aY));
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
                    float B = B(view) + (i * this.YN.qF());
                    if (B > c(i4, i2, true) + (-this.YO.get(i4))) {
                        a(view, i2, B);
                    } else {
                        e(view, i2);
                    }
                } else if (i2 > i3) {
                    float B2 = B(view) + (i * this.YN.qE());
                    if (B2 > c(i4, i2, false) + (-this.YO.get(i4))) {
                        a(view, i2, B2);
                    } else {
                        e(view, i2);
                    }
                }
            } else if (i2 > i3) {
                float B3 = B(view) + (i * this.YN.qF());
                if (B3 < c(i4, i2, false) + (-this.YO.get(i4))) {
                    a(view, i2, B3);
                } else {
                    e(view, i2);
                }
            } else if (i2 < i3) {
                float B4 = B(view) + (i * this.YN.qE());
                if (B4 < c(i4, i2, true) + (-this.YO.get(i4))) {
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
            ValueAnimator valueAnimator = this.YS.get(aY);
            if (valueAnimator == null) {
                if (Math.abs(B(view)) < 0.1f) {
                    a(view, i, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(B(view), 0.0f);
                ofFloat.setInterpolator(new k(1.0f));
                ofFloat.setDuration(this.YN.qI());
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
                        m.this.YS.delete(aY);
                        m.this.YT.delete(aY);
                        m.this.YO.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        m.this.YS.delete(aY);
                        m.this.YT.delete(aY);
                        m.this.a(view, i, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.YS.append(aY, ofFloat);
                this.YT.append(aY, (int) B(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float B = B(view);
            if (Math.abs(B) > Math.abs(this.YT.get(aY)) + this.YN.qG()) {
                this.YT.append(aY, (int) B);
                valueAnimator.setFloatValues(B, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }

    public void aW(int i) {
        if (this.Zq != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.YO.clear();
                qw();
            } else if (this.mScrollState == 2) {
                qw();
            } else if (this.mScrollState == 1) {
                this.YO.clear();
                qw();
            }
        }
    }

    public void C(View view) {
        int childAdapterPosition;
        int aY;
        float f;
        float f2;
        if (this.Zq != null && this.Zr != null && this.mScrollState != 0 && (aY = aY((childAdapterPosition = this.Zq.getChildAdapterPosition(view)))) >= 0) {
            if (childAdapterPosition <= this.Zr.findFirstVisibleItemPosition()) {
                float B = this.Zq.getChildAt(1) != null ? B(this.Zq.getChildAt(1)) : 0.0f;
                int aY2 = aY(childAdapterPosition + 1);
                if (aY2 >= 0) {
                    if (aY2 == aY) {
                        m(view, B);
                    } else {
                        float f3 = -this.YO.get(aY, 0);
                        if (f3 != 0.0f) {
                            this.YP = f3;
                            f2 = f3;
                        } else {
                            f2 = this.YP;
                        }
                        m(view, B + f2);
                    }
                } else {
                    return;
                }
            } else {
                float B2 = this.Zq.getChildAt(this.Zq.getChildCount() + (-2)) != null ? B(this.Zq.getChildAt(this.Zq.getChildCount() - 2)) : 0.0f;
                int aY3 = aY(childAdapterPosition - 1);
                if (aY3 >= 0) {
                    if (aY3 == aY) {
                        m(view, B2);
                    } else {
                        float f4 = -this.YO.get(aY, 0);
                        if (f4 != 0.0f) {
                            this.YQ = f4;
                            f = f4;
                        } else {
                            f = this.YQ;
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
        if (this.Zq != null) {
            m(view, 0.0f);
            int aY = aY(this.Zq.getChildAdapterPosition(view));
            if (aY >= 0 && b(aY, 0, true) == -1) {
                this.YO.delete(aY);
                if (this.YS.get(aY) != null) {
                    this.YS.get(aY).cancel();
                }
                this.YS.delete(aY);
                this.YT.delete(aY);
            }
        }
    }

    private void qw() {
        int childCount = this.Zq.getChildCount();
        this.Zt.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Zq.getChildAt(i);
            int childAdapterPosition = this.Zq.getChildAdapterPosition(childAt);
            int aY = aY(childAdapterPosition);
            if (aY >= 0 && !this.Zt.contains(Integer.valueOf(aY))) {
                this.Zt.add(Integer.valueOf(aY));
                e(childAt, childAdapterPosition);
            }
        }
    }

    private int b(int i, int i2, boolean z) {
        if (z) {
            int count = this.Zq.getCount() - i2;
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
                CardLinkageManager.INSTANCE.translationY(this.Zq, i, f);
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
            return B(this.Zq.getChildAt(b(i + 1, i2, true)));
        }
        return B(this.Zq.getChildAt(b(i - 1, i2, false)));
    }
}
