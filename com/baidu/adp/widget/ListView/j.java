package com.baidu.adp.widget.ListView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
/* loaded from: classes.dex */
public class j {
    private k UR;
    private float UT;
    private float UU;
    private int mCurrentPosition;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mScrollState;
    private boolean UV = false;
    private SparseIntArray US = new SparseIntArray();
    private SparseArray<ValueAnimator> UW = new SparseArray<>();
    private SparseIntArray UX = new SparseIntArray();

    public j(k kVar) {
        this.UR = kVar;
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
            if (Math.abs(f2) < this.UR.pj()) {
                this.UV = true;
                oY();
                return;
            }
            this.mCurrentPosition = i;
            this.UV = false;
            if (Math.abs(f2) > this.UR.pf()) {
                f3 = f2 > 0.0f ? this.UR.pf() : -this.UR.pf();
            } else {
                f3 = f2;
            }
            this.US.clear();
            float pb = f3 * this.UR.pb();
            if (f3 < 0.0f) {
                float pc = this.UR.pc();
                int i3 = 1;
                while (true) {
                    int i4 = i - i3;
                    float f4 = pb + (i3 * pc);
                    float f5 = pc * 1.4f;
                    if (f4 > 0.0f) {
                        break;
                    }
                    float pa = (f4 / this.UR.pa()) + this.US.get(i4);
                    if (Math.abs(pa) > this.UR.pe()) {
                        pa = -this.UR.pe();
                    }
                    this.US.append(i4, (int) pa);
                    i3++;
                    pc = f5;
                }
                float pc2 = this.UR.pc();
                while (true) {
                    int i5 = i + i2;
                    float f6 = pb + (i2 * pc2);
                    float f7 = pc2 * 1.4f;
                    if (f6 <= 0.0f) {
                        float oZ = (f6 / this.UR.oZ()) + this.US.get(i5);
                        if (Math.abs(oZ) > this.UR.pd()) {
                            oZ = -this.UR.pd();
                        }
                        this.US.append(i5, (int) oZ);
                        i2++;
                        pc2 = f7;
                    } else {
                        return;
                    }
                }
            } else {
                float pc3 = this.UR.pc();
                int i6 = 1;
                while (true) {
                    int i7 = i - i6;
                    float f8 = pb - (i6 * pc3);
                    float f9 = pc3 * 1.4f;
                    if (f8 < 0.0f) {
                        break;
                    }
                    float oZ2 = (f8 / this.UR.oZ()) + this.US.get(i7);
                    if (Math.abs(oZ2) > this.UR.pd()) {
                        oZ2 = this.UR.pd();
                    }
                    this.US.append(i7, (int) oZ2);
                    i6++;
                    pc3 = f9;
                }
                float pc4 = this.UR.pc();
                while (true) {
                    int i8 = i + i2;
                    float f10 = pb - (i2 * pc4);
                    float f11 = pc4 * 1.4f;
                    if (f10 >= 0.0f) {
                        float pa2 = (f10 / this.UR.pa()) + this.US.get(i8);
                        if (Math.abs(pa2) > this.UR.pe()) {
                            pa2 = this.UR.pe();
                        }
                        this.US.append(i8, (int) pa2);
                        i2++;
                        pc4 = f11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void aC(int i) {
        if (this.mRecyclerView != null) {
            this.mScrollState = i;
            if (this.mScrollState == 0) {
                this.US.clear();
                oY();
            } else if (this.mScrollState == 2) {
                oY();
            } else if (this.mScrollState == 1) {
                this.US.clear();
                oY();
            }
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mRecyclerView != null && this.mScrollState == 1 && !this.UV) {
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

    private float z(View view) {
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
                    float z = z(view) + (this.UR.ph() * f);
                    if (z > (-this.US.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                        m(view, z);
                    } else {
                        c(view, i);
                    }
                } else if (i > i2) {
                    float z2 = z(view) + (this.UR.pg() * f);
                    if (z2 > (-this.US.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                        m(view, z2);
                    } else {
                        c(view, i);
                    }
                }
            } else if (i > i2) {
                float z3 = z(view) + (this.UR.ph() * f);
                if (z3 < (-this.US.get(i)) + z(this.mRecyclerView.getChildAt(i3 - 1))) {
                    m(view, z3);
                } else {
                    c(view, i);
                }
            } else if (i < i2) {
                float z4 = z(view) + (this.UR.pg() * f);
                if (z4 < (-this.US.get(i)) + z(this.mRecyclerView.getChildAt(i3 + 1))) {
                    m(view, z4);
                } else {
                    c(view, i);
                }
            }
        }
    }

    public void A(View view) {
        if (this.mRecyclerView != null && this.mScrollState != 0) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                    float f = -this.US.get(childAdapterPosition, 0);
                    if (f != 0.0f) {
                        this.UT = f;
                    } else {
                        f = this.UT;
                    }
                    m(view, f + (this.mRecyclerView.getChildAt(1) != null ? z(this.mRecyclerView.getChildAt(1)) : 0.0f));
                } else {
                    float f2 = -this.US.get(childAdapterPosition, 0);
                    if (f2 != 0.0f) {
                        this.UU = f2;
                    } else {
                        f2 = this.UU;
                    }
                    m(view, f2 + (this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-2)) != null ? z(this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() - 2)) : 0.0f));
                }
                c(view, childAdapterPosition);
            }
        }
    }

    public void B(View view) {
        if (this.mRecyclerView != null) {
            m(view, 0.0f);
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
            this.US.delete(childAdapterPosition);
            if (this.UW.get(childAdapterPosition) != null) {
                this.UW.get(childAdapterPosition).cancel();
            }
            this.UW.delete(childAdapterPosition);
            this.UX.delete(childAdapterPosition);
        }
    }

    private void oY() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            c(childAt, this.mRecyclerView.getChildAdapterPosition(childAt));
        }
    }

    private void c(final View view, final int i) {
        if (view != null) {
            ValueAnimator valueAnimator = this.UW.get(i);
            if (valueAnimator == null) {
                if (Math.abs(z(view)) < 0.1f) {
                    m(view, 0.0f);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(z(view), 0.0f);
                ofFloat.setInterpolator(new l(1.0f));
                ofFloat.setDuration(this.UR.pk());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.ListView.j.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        j.this.m(view, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.adp.widget.ListView.j.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        j.this.UW.delete(i);
                        j.this.UX.delete(i);
                        j.this.US.delete(i);
                        j.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        j.this.UW.delete(i);
                        j.this.UX.delete(i);
                        j.this.m(view, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.UW.append(i, ofFloat);
                this.UX.append(i, (int) z(view));
                ofFloat.start();
                return;
            }
            if (!valueAnimator.isRunning()) {
                valueAnimator.start();
            }
            float z = z(view);
            if (Math.abs(z) > Math.abs(this.UX.get(i)) + this.UR.pi()) {
                this.UX.append(i, (int) z);
                valueAnimator.setFloatValues(z, 0.0f);
                valueAnimator.cancel();
                valueAnimator.start();
            }
        }
    }
}
