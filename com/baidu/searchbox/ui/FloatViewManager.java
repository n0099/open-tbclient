package com.baidu.searchbox.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes4.dex */
public class FloatViewManager {
    public View mFloatView;
    public boolean mFloatViewVisible;
    public OnCalcViewLocationListener mListener;
    public View mPinnedView;
    public IPinnedView mPinnedViewProxy;
    public int mCurScrollY = 0;
    public int mInitScrollY = 0;
    public Rect mFloatViewRect = new Rect();

    /* loaded from: classes4.dex */
    public interface IPinnedView {
        int getPinnedViewHeight();

        int getPinnedViewTop();
    }

    /* loaded from: classes4.dex */
    public interface OnCalcViewLocationListener {
        int getFloatViewTop(View view2);

        int getPinnedViewTop(View view2);
    }

    public FloatViewManager(OnCalcViewLocationListener onCalcViewLocationListener) {
        this.mListener = onCalcViewLocationListener;
    }

    private void offsetFloatViewTo(int i) {
        View view2 = this.mFloatView;
        if (i != view2.getTop()) {
            int left = view2.getLeft();
            view2.layout(left, i, view2.getMeasuredWidth() + left, view2.getMeasuredHeight() + i);
        }
    }

    private void onFloatViewVisibilityChanged(final boolean z) {
        View view2 = this.mFloatView;
        if (view2 == null) {
            return;
        }
        if (view2.getMeasuredHeight() != 0 && this.mFloatView.getMeasuredWidth() != 0) {
            onFloatViewVisibilityChanged(true, z);
        } else {
            this.mFloatView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ui.FloatViewManager.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    FloatViewManager.this.mFloatView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    FloatViewManager.this.onFloatViewVisibilityChanged(true, z);
                }
            });
        }
    }

    public void setFloatView(View view2) {
        this.mFloatView = view2;
    }

    public void setInitScrollY(int i) {
        View view2;
        this.mInitScrollY = i;
        this.mFloatViewRect.setEmpty();
        if (!this.mFloatViewVisible && (view2 = this.mPinnedView) != null) {
            view2.setVisibility(0);
        }
    }

    public void setPinnedView(View view2) {
        this.mPinnedView = view2;
        if (view2 instanceof IPinnedView) {
            this.mPinnedViewProxy = (IPinnedView) view2;
        }
    }

    private int getPinnedViewHeight() {
        IPinnedView iPinnedView = this.mPinnedViewProxy;
        if (iPinnedView != null) {
            return iPinnedView.getPinnedViewHeight();
        }
        return this.mPinnedView.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFloatViewVisibilityChanged(boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                offsetFloatViewTo((-this.mFloatViewRect.height()) + this.mFloatViewRect.top);
            } else {
                offsetFloatViewTo(this.mFloatViewRect.top);
            }
        }
        View view2 = this.mFloatView;
        int i2 = 0;
        if (view2 != null) {
            if (z2) {
                i = 0;
            } else {
                i = 4;
            }
            view2.setVisibility(i);
        }
        View view3 = this.mPinnedView;
        if (view3 != null) {
            if (z2) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        int i6;
        if (this.mFloatView == null || this.mPinnedView == null || this.mCurScrollY == i2) {
            return;
        }
        this.mCurScrollY = i2;
        if (this.mFloatViewRect.isEmpty()) {
            View view2 = this.mFloatView;
            int left = view2.getLeft();
            int top = view2.getTop();
            this.mFloatViewRect.set(left, top, view2.getMeasuredWidth() + left, view2.getMeasuredHeight() + top);
            Rect rect = this.mFloatViewRect;
            rect.offsetTo(rect.left, this.mInitScrollY);
        }
        int i7 = i4 - i2;
        if (i7 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            OnCalcViewLocationListener onCalcViewLocationListener = this.mListener;
            if (onCalcViewLocationListener != null) {
                i5 = onCalcViewLocationListener.getPinnedViewTop(this.mPinnedView);
            } else {
                i5 = 0;
            }
            if (i2 < getPinnedViewHeight() + i5) {
                OnCalcViewLocationListener onCalcViewLocationListener2 = this.mListener;
                if (onCalcViewLocationListener2 != null) {
                    i6 = onCalcViewLocationListener2.getFloatViewTop(this.mFloatView);
                } else {
                    i6 = 0;
                }
                if (i5 - i2 >= i6 && this.mFloatViewVisible) {
                    this.mFloatViewVisible = false;
                    onFloatViewVisibilityChanged(false);
                }
            } else if (i2 > this.mFloatView.getHeight() && !this.mFloatViewVisible) {
                this.mFloatViewVisible = true;
                onFloatViewVisibilityChanged(true);
            }
        }
        if (this.mFloatViewVisible) {
            int top2 = this.mFloatView.getTop();
            if (z) {
                offsetFloatViewTo(Math.min(top2 + i7, this.mFloatViewRect.top));
                return;
            }
            int i8 = top2 + i7;
            if (this.mFloatView.getBottom() + i7 < this.mFloatViewRect.top) {
                i8 = this.mInitScrollY - this.mFloatView.getHeight();
                this.mFloatView.setVisibility(4);
                this.mFloatViewVisible = false;
            }
            offsetFloatViewTo(i8);
            return;
        }
        this.mPinnedView.setVisibility(0);
    }
}
