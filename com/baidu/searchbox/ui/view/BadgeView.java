package com.baidu.searchbox.ui.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes12.dex */
public class BadgeView extends TextView {
    private boolean mHideOnNull;

    public BadgeView(Context context) {
        this(context, null);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHideOnNull = true;
        init();
    }

    private void init() {
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        }
        setTextColor(getResources().getColor(R.color.badge_text_color));
        setTextSize(1, 9.0f);
        setPadding(dip2Px(4.0f), 0, dip2Px(4.0f), 0);
        setGravity(17);
        setHideOnNull(true);
        setBadgeCount(0);
        setBadgeBackground(R.drawable.common_badge);
    }

    public void setBadgeBackground(@DimenRes int i, @ColorInt int i2, int i3) {
        int dip2Px = dip2Px(i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(dip2Px);
        gradientDrawable.setStroke(3, i3);
        setBackground(gradientDrawable);
    }

    public void setBadgeBackground(int i, int i2) {
        int dip2Px = dip2Px(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        setBackground(shapeDrawable);
    }

    public void setBadgeBackground(@DrawableRes int i) {
        setBackground(getResources().getDrawable(i));
    }

    public void setWidthAndHeight(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = DeviceUtil.ScreenInfo.dp2px(getContext(), i);
        layoutParams.height = DeviceUtil.ScreenInfo.dp2px(getContext(), i2);
        setLayoutParams(layoutParams);
    }

    protected boolean isHideOnNull() {
        return this.mHideOnNull;
    }

    public void setHideOnNull(boolean z) {
        this.mHideOnNull = z;
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (isHideOnNull() && (charSequence == null || charSequence.toString().equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        super.setText(charSequence, bufferType);
    }

    public void setBadgeCount(int i) {
        setText(String.valueOf(i));
    }

    public void setBadgeCount(String str) {
        setText(str);
    }

    public Integer getBadgeCount() {
        if (getText() == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(getText().toString()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void setBadgeGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public int getBadgeGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public void setBadgeMargin(int i) {
        setBadgeMargin(i, i, i, i);
    }

    public void setBadgeMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = dip2Px(i);
        layoutParams.topMargin = dip2Px(i2);
        layoutParams.rightMargin = dip2Px(i3);
        layoutParams.bottomMargin = dip2Px(i4);
        setLayoutParams(layoutParams);
    }

    public int[] getBadgeMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public void incrementBadgeCount(int i) {
        Integer badgeCount = getBadgeCount();
        if (badgeCount == null) {
            setBadgeCount(i);
        } else {
            setBadgeCount(badgeCount.intValue() + i);
        }
    }

    public void decrementBadgeCount(int i) {
        incrementBadgeCount(-i);
    }

    public void bindView(TabWidget tabWidget, int i) {
        bindView(tabWidget.getChildTabViewAt(i));
    }

    public void bindView(View view) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view != null) {
            if (view.getParent() instanceof FrameLayout) {
                ((FrameLayout) view.getParent()).addView(this);
            } else if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                FrameLayout frameLayout = new FrameLayout(getContext());
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                frameLayout.setLayoutParams(layoutParams);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.addView(frameLayout, indexOfChild, layoutParams);
                frameLayout.addView(view);
                frameLayout.addView(this);
            } else if (view.getParent() == null) {
                Log.e(getClass().getSimpleName(), "ParentView is needed");
            }
        }
    }

    public void unbind() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private int dip2Px(float f) {
        return DeviceUtil.ScreenInfo.dp2px(getContext(), f);
    }
}
