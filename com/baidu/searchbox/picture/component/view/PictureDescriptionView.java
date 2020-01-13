package com.baidu.searchbox.picture.component.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.searchbox.common.lib_atlas_base.R;
/* loaded from: classes12.dex */
public class PictureDescriptionView extends FrameLayout {
    private float factor;
    private int mChildHeight;
    private ScrollView mChildView;
    private int mExpandHeight;
    private int mExpandLandscapeHeight;
    private int mExpandPotraitHeight;
    private int mHeight;
    private boolean mInterceptFlag;
    private int mLastInterceptX;
    private int mLastInterceptY;
    private int mLastX;
    private int mLastY;
    private int mMaxHeight;
    private int mMaxLandscapeHeight;
    private int mMaxPotraitHeight;
    private int mScrollDistance;
    private int mTouchSlop;
    private boolean shouldShowShader;

    public PictureDescriptionView(Context context) {
        super(context);
        this.mLastX = 0;
        this.mLastY = 0;
        this.mLastInterceptX = 0;
        this.mLastInterceptY = 0;
        this.mMaxHeight = 164;
        this.mExpandHeight = 281;
        this.factor = 0.88f;
        this.mScrollDistance = 0;
        this.mInterceptFlag = true;
        this.mChildHeight = 0;
        this.mExpandLandscapeHeight = 0;
        this.mMaxLandscapeHeight = 0;
        this.mExpandPotraitHeight = 0;
        this.mMaxPotraitHeight = 0;
        this.shouldShowShader = false;
    }

    public PictureDescriptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastX = 0;
        this.mLastY = 0;
        this.mLastInterceptX = 0;
        this.mLastInterceptY = 0;
        this.mMaxHeight = 164;
        this.mExpandHeight = 281;
        this.factor = 0.88f;
        this.mScrollDistance = 0;
        this.mInterceptFlag = true;
        this.mChildHeight = 0;
        this.mExpandLandscapeHeight = 0;
        this.mMaxLandscapeHeight = 0;
        this.mExpandPotraitHeight = 0;
        this.mMaxPotraitHeight = 0;
        this.shouldShowShader = false;
        initAttrs(context, attributeSet);
    }

    public PictureDescriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastX = 0;
        this.mLastY = 0;
        this.mLastInterceptX = 0;
        this.mLastInterceptY = 0;
        this.mMaxHeight = 164;
        this.mExpandHeight = 281;
        this.factor = 0.88f;
        this.mScrollDistance = 0;
        this.mInterceptFlag = true;
        this.mChildHeight = 0;
        this.mExpandLandscapeHeight = 0;
        this.mMaxLandscapeHeight = 0;
        this.mExpandPotraitHeight = 0;
        this.mMaxPotraitHeight = 0;
        this.shouldShowShader = false;
        initAttrs(context, attributeSet);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureDescriptionView, 0, 0);
            this.mExpandPotraitHeight = (int) obtainStyledAttributes.getDimension(R.styleable.PictureDescriptionView_expandLandscapeDesHeight, this.mExpandPotraitHeight);
            this.mMaxPotraitHeight = (int) obtainStyledAttributes.getDimension(R.styleable.PictureDescriptionView_maxPotraitDesHeight, this.mMaxPotraitHeight);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mExpandHeight = this.mExpandPotraitHeight;
        this.mMaxHeight = this.mMaxPotraitHeight;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int max = getChildAt(i3) instanceof ScrollView ? Math.max(((ViewGroup) getChildAt(i3)).getChildAt(0).getMeasuredHeight(), i4) : i4;
            i3++;
            i4 = max;
        }
        this.mInterceptFlag = true;
        if (i4 <= this.mMaxHeight) {
            this.mChildHeight = i4;
            setMeasuredDimension(View.MeasureSpec.getSize(i), i4);
        } else if (i4 <= this.mExpandHeight) {
            this.mChildHeight = i4;
            this.shouldShowShader = true;
        } else {
            this.mChildHeight = this.mExpandHeight;
            this.shouldShowShader = true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        switch (action) {
            case 0:
                this.mLastInterceptX = x;
                this.mLastInterceptY = y;
                this.mLastX = x;
                this.mLastY = y;
                z = false;
                break;
            case 1:
            case 3:
                this.mLastInterceptX = 0;
                this.mLastInterceptY = 0;
                z = false;
                break;
            case 2:
                int i = x - this.mLastInterceptX;
                int i2 = y - this.mLastInterceptY;
                if (Math.abs(i2) > this.mTouchSlop && Math.abs(i) >= Math.abs(i2)) {
                    z = true;
                    break;
                } else if (i != i2 || i != 0) {
                    if (getHeight() == this.mExpandHeight && (!isTop() || i2 <= this.mTouchSlop)) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        return z && this.mInterceptFlag;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                updateUI(this.mScrollDistance);
                this.mScrollDistance = 0;
                break;
            case 2:
                this.mScrollDistance = (-((int) ((y - this.mLastY) * this.factor))) + this.mScrollDistance;
                break;
        }
        this.mLastX = x;
        this.mLastY = y;
        return true;
    }

    private void updateUI(int i) {
        if (i != 0) {
            this.mHeight = getHeight();
            int height = getHeight();
            if (i > 0) {
                this.mHeight = Math.min(this.mExpandHeight, this.mChildHeight);
            } else {
                this.mHeight = this.mMaxHeight;
            }
            doAnimation(height, this.mHeight);
        }
    }

    public void reLayoutAfterFontSizeChange() {
        requestLayout();
    }

    private void doAnimation(int i, int i2) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "height", i, i2);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    private boolean isTop() {
        getChildView();
        return this.mChildView != null && this.mChildView.getScrollY() == 0;
    }

    private void getChildView() {
        if (this.mChildView == null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    if (!(childAt instanceof ScrollView)) {
                        i = i2 + 1;
                    } else {
                        this.mChildView = (ScrollView) childAt;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void scrollToTop() {
        getChildView();
        if (this.mChildView != null) {
            this.mChildView.fullScroll(33);
        }
    }

    private void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
