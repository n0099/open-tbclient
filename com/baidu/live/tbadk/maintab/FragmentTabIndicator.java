package com.baidu.live.tbadk.maintab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.maintab.TbFragmentTabIndicator;
import com.baidu.live.tieba.view.TabTextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    public static final int TIP_POS_TYPE_CENTER = 0;
    public static final int TIP_POS_TYPE_TOP = 1;
    public int dayTextColorResId;
    private int drawableRightResId;
    private int drawableTopResId;
    private TabTextView mContentTv;
    private ImageView mIconView;
    private int mTipPosType;
    private int mTipRightMargin;
    private int mTipTopMargin;
    private HashMap<String, TbFragmentTabIndicator.FragmentTapTip> mTips;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.mTipPosType = 0;
        this.mTips = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mTips = new HashMap<>();
        init();
    }

    private void init() {
        this.mTipTopMargin = getResources().getDimensionPixelSize(a.e.sdk_ds2);
        this.mTipRightMargin = getResources().getDimensionPixelSize(a.e.sdk_ds12);
        this.mContentTv = new TabTextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mContentTv.setLayoutParams(layoutParams);
        this.mContentTv.setGravity(17);
        this.mContentTv.setDuplicateParentStateEnabled(true);
        addView(this.mContentTv);
    }

    public void setGradientAttrs(int i, int i2, float f, float f2, boolean z) {
        if (this.mContentTv != null) {
            this.mContentTv.setGradientAttrs(i, i2, f, f2, z);
        }
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.mContentTv.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentTv.getLayoutParams();
            layoutParams.topMargin = i;
            this.mContentTv.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : this.mTips.entrySet()) {
            TbFragmentTabIndicator.FragmentTapTip value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            } else {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> it = this.mTips.entrySet().iterator();
        while (it.hasNext() && this.mContentTv.getText() != null) {
            TbFragmentTabIndicator.FragmentTapTip value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.mContentTv.getPaint().measureText(this.mContentTv.getText().toString());
            if (value.isRight) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.offsetX;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.offsetX) - (measureText / 2);
            }
            if (this.mTipPosType == 1) {
                i5 = measuredWidth - this.mTipRightMargin;
                measuredHeight = this.mTipTopMargin;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.mTipTopMargin = i;
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.mTipPosType = i;
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void addTip(String str, TbFragmentTabIndicator.FragmentTapTip fragmentTapTip) {
        if (fragmentTapTip.view != null) {
            addView(fragmentTapTip.view);
            this.mTips.put(str, fragmentTapTip);
        }
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip getTip(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip removeTip(String str) {
        if (this.mTips.containsKey(str)) {
            removeView(this.mTips.get(str).view);
            return this.mTips.remove(str);
        }
        return null;
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mContentTv.setText(i);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setText(String str) {
        this.mContentTv.setText(str);
        this.mContentTv.setContentDescription(str);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.mContentTv.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.mContentTv.getText().toString();
        if (z) {
            charSequence = getContext().getString(a.i.sdk_talk_checked_tip) + charSequence;
        }
        this.mContentTv.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.mContentTv.setText(spannableString);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.drawableTopResId = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.drawableRightResId = i;
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.mContentTv.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.mContentTv.setTextSize(f);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.mContentTv.setTextSize(i, f);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.dayTextColorResId = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void onChangeSkin(int i) {
        SkinManager.setViewTextColor(this.mContentTv, this.dayTextColorResId, 1);
        if (this.mContentTv != null) {
            if (this.mContentTv.getText() != null && StringHelper.isEmpty(this.mContentTv.getText().toString())) {
                this.mIconView.setImageDrawable(SkinManager.getSkinDrawable(null, this.drawableTopResId));
            } else {
                this.mContentTv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.drawableTopResId), SkinManager.getDrawable(this.drawableRightResId), (Drawable) null);
            }
        }
        for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : this.mTips.entrySet()) {
            entry.getValue().onChangeSkin(i);
        }
    }

    public void setContentWidthWrapContent() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentTv.getLayoutParams();
        layoutParams.width = -2;
        this.mContentTv.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mContentTv;
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        if (this.mContentTv != null) {
            this.mContentTv.setVisibility(8);
        }
        this.mIconView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.mIconView.setLayoutParams(layoutParams);
        addView(this.mIconView);
        this.mIconView.setImageDrawable(SkinManager.getSkinDrawable(null, this.drawableTopResId));
    }

    @Override // com.baidu.live.tbadk.maintab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.mIsContentSelectBold = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.mIsContentSelectBold) {
            this.mContentTv.getPaint().setFakeBoldText(z);
        }
    }
}
