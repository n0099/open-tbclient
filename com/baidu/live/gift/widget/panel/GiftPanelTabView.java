package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GiftPanelTabView extends LinearLayout {
    private static final String[] aIc = {"礼物", "背包"};
    private a aId;
    private int aIe;
    private int aIf;
    private int aIg;
    private int aIh;
    private int aIi;
    private MotionEvent mMotionEvent;

    /* loaded from: classes3.dex */
    public interface a {
        void bO(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.aId = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.aIe = i;
        this.aIf = i2;
        this.aIg = i3;
        this.aIh = i4;
        refreshUI();
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.aIi = i;
            refreshUI();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        int findPosByView;
        if (this.mMotionEvent == null) {
            return super.performClick();
        }
        View findChild = findChild((int) this.mMotionEvent.getX(), (int) this.mMotionEvent.getY());
        this.mMotionEvent = null;
        if (findChild != null && (findPosByView = findPosByView(findChild)) != -1 && findPosByView != this.aIi && this.aId != null) {
            this.aId.bO(findPosByView);
        }
        return true;
    }

    private void init() {
        setClickable(true);
        Ai();
        setOrientation(0);
        Aj();
        Ak();
    }

    private void Ai() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void Aj() {
        this.aIe = -13815746;
        this.aIf = -15987436;
        this.aIg = -1;
        this.aIh = -13289398;
    }

    private void Ak() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        for (int i = 0; i <= 1; i++) {
            addView(u(i, dimensionPixelOffset), new LinearLayout.LayoutParams(-2, -1));
        }
    }

    private TextView u(int i, int i2) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setPadding(i2, 0, i2, 0);
        textView.setSelected(false);
        textView.setText(aIc[i]);
        textView.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize28));
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        switch (i) {
            case 0:
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
                break;
            case 1:
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f});
                break;
        }
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private void refreshUI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Drawable background = childAt.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(i2 == this.aIi ? this.aIe : this.aIf);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof TextView) {
                        ((TextView) childAt).setTextColor(i2 == this.aIi ? this.aIg : this.aIh);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View findChild(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private int findPosByView(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }
}
