package com.baidu.live.tbadk.maintab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.MessageRedDotView;
/* loaded from: classes4.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean mIsContentSelectBold;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.mIsContentSelectBold = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsContentSelectBold = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsContentSelectBold = false;
    }

    public void onChangeSkin(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void onTabSelected(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setTipPosType(int i) {
    }

    public void addTip(String str, FragmentTapTip fragmentTapTip) {
    }

    public void addTipWrapContent(String str, FragmentTapTip fragmentTapTip) {
    }

    public FragmentTapTip getTip(String str) {
        return null;
    }

    public FragmentTapTip removeTip(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void setIconViewWithoutText(int i, int i2) {
    }

    public void setCompoundDrawablesTopResId(int i) {
    }

    public void setCompoundDrawablePadding(int i) {
    }

    public void setContentTvTopMargin(int i) {
    }

    public void setTextSize(float f) {
    }

    public void setTextSize(int i, float f) {
    }

    public void setTextColorResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.mIsContentSelectBold = z;
    }

    /* loaded from: classes4.dex */
    public static class FragmentTapTip {
        public int bgDayRes;
        public TbFragmentTabIndicator indicator;
        public int offsetX;
        public View view;
        public boolean isRight = true;
        public int textDayColor = a.d.sdk_common_color_10225;

        public void onChangeSkin(int i) {
            if (this.bgDayRes != 0) {
                SkinManager.setBackgroundResource(this.view, this.bgDayRes);
            }
            if (this.view instanceof TextView) {
                if (this.textDayColor != 0) {
                    SkinManager.setViewTextColor((TextView) this.view, this.textDayColor, 1);
                }
                int messageCount = getMessageCount((TextView) this.view);
                if (messageCount > 0 && messageCount < 10) {
                    SkinManager.setBackgroundResource((TextView) this.view, a.f.sdk_icon_news_head_prompt_one);
                } else if (messageCount >= 10 && messageCount < 100) {
                    SkinManager.setBackgroundResource((TextView) this.view, a.f.sdk_icon_news_head_prompt_two);
                } else if (messageCount >= 100) {
                    SkinManager.setBackgroundResource((TextView) this.view, a.f.sdk_icon_news_head_prompt_more);
                }
            }
            if (this.view instanceof MessageRedDotView) {
                ((MessageRedDotView) this.view).onChangeSkinType();
            }
        }

        private int getMessageCount(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return JavaTypesHelper.toInt(charSequence, -1);
        }
    }
}
