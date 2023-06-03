package com.baidu.searchbox.ui.stickylistheader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes4.dex */
public class WrapperView extends ViewGroup {
    public Drawable mDivider;
    public int mDividerHeight;
    public View mHeader;
    public View mItem;
    public int mItemTop;

    public WrapperView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mHeader == null && this.mDivider != null && this.mItem.getVisibility() != 8) {
            if (Build.VERSION.SDK_INT < 11) {
                canvas.clipRect(0, 0, getWidth(), this.mDividerHeight);
            }
            this.mDivider.draw(canvas);
        }
    }

    public View getHeader() {
        return this.mHeader;
    }

    public View getItem() {
        return this.mItem;
    }

    public boolean hasHeader() {
        if (this.mHeader != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        View view2 = this.mHeader;
        if (view2 != null) {
            int measuredHeight = view2.getMeasuredHeight();
            this.mHeader.layout(0, 0, width, measuredHeight);
            this.mItemTop = measuredHeight;
            this.mItem.layout(0, measuredHeight, width, height);
            return;
        }
        Drawable drawable = this.mDivider;
        if (drawable != null) {
            drawable.setBounds(0, 0, width, this.mDividerHeight);
            int i5 = this.mDividerHeight;
            this.mItemTop = i5;
            this.mItem.layout(0, i5, width, height);
            return;
        }
        this.mItemTop = 0;
        this.mItem.layout(0, 0, width, height);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int measuredHeight;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        View view2 = this.mHeader;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null && (i5 = layoutParams.height) > 0) {
                this.mHeader.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
            } else {
                this.mHeader.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            i3 = this.mHeader.getMeasuredHeight() + 0;
        } else if (this.mDivider != null && this.mItem.getVisibility() != 8) {
            i3 = this.mDividerHeight + 0;
        } else {
            i3 = 0;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mItem.getLayoutParams();
        if (this.mItem.getVisibility() == 8) {
            this.mItem.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        } else {
            if (layoutParams2 != null && (i4 = layoutParams2.height) >= 0) {
                this.mItem.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                measuredHeight = this.mItem.getMeasuredHeight();
            } else {
                this.mItem.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = this.mItem.getMeasuredHeight();
            }
            i3 += measuredHeight;
        }
        setMeasuredDimension(size, i3);
    }

    @SuppressLint({"BDThrowableCheck"})
    public void update(View view2, View view3, Drawable drawable, int i) {
        if (view2 != null) {
            View view4 = this.mItem;
            if (view4 != view2) {
                removeView(view4);
                this.mItem = view2;
                ViewParent parent = view2.getParent();
                if (parent != null && parent != this && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view2);
                }
                addView(view2);
            }
            View view5 = this.mHeader;
            if (view5 != view3) {
                if (view5 != null) {
                    removeView(view5);
                }
                this.mHeader = view3;
                if (view3 != null) {
                    addView(view3);
                }
            }
            if (this.mDivider != drawable) {
                this.mDivider = drawable;
                this.mDividerHeight = i;
                invalidate();
                return;
            }
            return;
        }
        throw new NullPointerException("List view item must not be null.");
    }
}
