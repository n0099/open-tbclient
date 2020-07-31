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
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GiftPanelTabView extends LinearLayout {
    private static final String[] aRQ = {"礼物", "背包"};
    private a aRR;
    private int aRS;
    private int aRT;
    private int aRU;
    private int aRV;
    private int aRW;
    private MotionEvent mMotionEvent;

    /* loaded from: classes4.dex */
    public interface a {
        void cj(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.aRR = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.aRS = i;
        this.aRT = i2;
        this.aRU = i3;
        this.aRV = i4;
        refreshUI();
    }

    public int getSelect() {
        return this.aRW;
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.aRW = i;
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
        if (findChild != null && (findPosByView = findPosByView(findChild)) != -1 && findPosByView != this.aRW && this.aRR != null) {
            this.aRR.cj(findPosByView);
        }
        return true;
    }

    private void init() {
        setClickable(true);
        Cz();
        setOrientation(0);
        CA();
        CB();
    }

    private void Cz() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void CA() {
        this.aRS = -13815746;
        this.aRT = -15987436;
        this.aRU = -1;
        this.aRV = -13289398;
    }

    private void CB() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        for (int i = 0; i <= 1; i++) {
            addView(z(i, dimensionPixelOffset), new LinearLayout.LayoutParams(-2, -1));
        }
    }

    private TextView z(int i, int i2) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setPadding(i2, 0, i2, 0);
        textView.setSelected(false);
        textView.setText(aRQ[i]);
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
                        ((GradientDrawable) background).setColor(i2 == this.aRW ? this.aRS : this.aRT);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof TextView) {
                        ((TextView) childAt).setTextColor(i2 == this.aRW ? this.aRU : this.aRV);
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
