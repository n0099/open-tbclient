package com.baidu.searchbox.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.utils.ResUtil;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RedTipImageView extends RelativeLayout implements IFontSizeViewListener {
    public AnimatorSet mCancelStarAnimSet;
    public ImageView mCopyIcon;
    public SelectorImageView mIcon;
    public boolean mIsIgnoreUpdateLayoutParams;
    public boolean mIsResponseFontSize;
    public BadgeView mRedDot;
    public BadgeView mRedTip;
    public int mResId;
    public AnimatorSet mStarAnimSet;

    public RedTipImageView(Context context) {
        super(context);
        this.mResId = -1;
        this.mIsResponseFontSize = false;
        this.mIsIgnoreUpdateLayoutParams = false;
        init();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mIcon.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(int i) {
        this.mResId = i;
        this.mIcon.setVisibility(0);
        onFontSizeChange();
    }

    public void setIconAlpha(float f) {
        this.mIcon.setAlpha(f);
        this.mCopyIcon.setAlpha(1.0f - f);
    }

    public void setIconEnable(boolean z) {
        SelectorImageView selectorImageView = this.mIcon;
        if (selectorImageView != null) {
            selectorImageView.setEnabled(z);
        }
    }

    public void setIsIgnoreFontSizeParams(boolean z) {
        this.mIsIgnoreUpdateLayoutParams = z;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
    }

    public void setSupportDark(boolean z) {
        this.mIcon.setSupportDark(Boolean.valueOf(z));
    }

    public RedTipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mResId = -1;
        this.mIsResponseFontSize = false;
        this.mIsIgnoreUpdateLayoutParams = false;
        init();
    }

    public RedTipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mResId = -1;
        this.mIsResponseFontSize = false;
        this.mIsIgnoreUpdateLayoutParams = false;
        init();
    }

    @TargetApi(21)
    public RedTipImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mResId = -1;
        this.mIsResponseFontSize = false;
        this.mIsIgnoreUpdateLayoutParams = false;
        init();
    }

    private void init() {
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0219, this);
        this.mIcon = (SelectorImageView) findViewById(R.id.obfuscated_res_0x7f091e70);
        this.mCopyIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e71);
        BadgeView badgeView = (BadgeView) findViewById(R.id.obfuscated_res_0x7f091e72);
        this.mRedTip = badgeView;
        badgeView.setType(BadgeView.Type.SMALL_TEXT);
        this.mIcon.setVisibility(0);
        this.mCopyIcon.setVisibility(8);
        this.mRedTip.setVisibility(8);
    }

    private void initRedDotView() {
        if (this.mRedDot == null) {
            BadgeView badgeView = new BadgeView(getContext());
            this.mRedDot = badgeView;
            badgeView.bindView(this.mIcon);
            this.mRedDot.setType(BadgeView.Type.DOT);
        }
    }

    private void stopStarAnim() {
        AnimatorSet animatorSet = this.mStarAnimSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mStarAnimSet.removeAllListeners();
            this.mStarAnimSet = null;
        }
        AnimatorSet animatorSet2 = this.mCancelStarAnimSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.mCancelStarAnimSet.removeAllListeners();
            this.mCancelStarAnimSet = null;
        }
    }

    public TextView getRedTip() {
        return this.mRedTip;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopStarAnim();
        super.onDetachedFromWindow();
    }

    public void setCopyIcon() {
        if (this.mIcon != null) {
            this.mCopyIcon.setVisibility(0);
            this.mCopyIcon.setImageDrawable(this.mIcon.getDrawable());
        }
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (this.mResId == -1) {
            return;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), this.mResId, null);
        if (isResponseFontSize()) {
            if (drawable == null) {
                return;
            }
            int dimenByResId = (int) ResUtil.getDimenByResId(R.dimen.obfuscated_res_0x7f070304);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            Drawable scaledDrawable = FontSizeHelper.getScaledDrawable(0, drawable);
            if (scaledDrawable == null) {
                return;
            }
            int intrinsicWidth2 = scaledDrawable.getIntrinsicWidth();
            this.mIcon.setImageDrawable(scaledDrawable);
            if (this.mIsIgnoreUpdateLayoutParams || (layoutParams2 = getLayoutParams()) == null) {
                return;
            }
            layoutParams2.width = (intrinsicWidth2 - intrinsicWidth) + dimenByResId;
            layoutParams2.height = dimenByResId;
            setLayoutParams(layoutParams2);
            return;
        }
        this.mIcon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.mResId, null));
        if (this.mIsIgnoreUpdateLayoutParams || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070304);
        layoutParams.height = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070304);
        setLayoutParams(layoutParams);
    }

    public void setNewTip(ToolBarNewType toolBarNewType, String str) {
        if (toolBarNewType != null && toolBarNewType != ToolBarNewType.NO_TIP) {
            if (toolBarNewType == ToolBarNewType.DOT_TIP) {
                initRedDotView();
                BadgeView badgeView = this.mRedDot;
                if (badgeView != null) {
                    badgeView.setVisibility(0);
                }
                this.mRedTip.setText("");
                this.mRedTip.setVisibility(8);
                return;
            } else if (toolBarNewType == ToolBarNewType.STRING_TIP) {
                BadgeView badgeView2 = this.mRedDot;
                if (badgeView2 != null) {
                    badgeView2.setVisibility(8);
                }
                this.mRedTip.setText(str);
                this.mRedTip.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        BadgeView badgeView3 = this.mRedDot;
        if (badgeView3 != null) {
            badgeView3.setVisibility(8);
        }
        this.mRedTip.setVisibility(8);
    }

    public void startStarAnim(boolean z) {
        if (this.mIcon == null) {
            return;
        }
        stopStarAnim();
        if (z) {
            setEnabled(false);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mCopyIcon, Key.ALPHA, 1.0f, 0.0f).setDuration(200L);
            duration.setStartDelay(50L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mIcon, Key.ALPHA, 0.0f, 1.0f).setDuration(200L);
            duration2.setStartDelay(50L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mIcon, Key.SCALE_X, 1.0f, 1.3f).setDuration(200L);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.mIcon, Key.SCALE_Y, 1.0f, 1.3f).setDuration(200L);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.mIcon, Key.SCALE_X, 1.3f, 1.0f).setDuration(240L);
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(this.mIcon, Key.SCALE_Y, 1.3f, 1.0f).setDuration(240L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mStarAnimSet = animatorSet;
            animatorSet.play(duration2).with(duration).with(duration3).with(duration4).before(duration5).before(duration6);
            this.mStarAnimSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.toolbar.RedTipImageView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    RedTipImageView.this.setEnabled(true);
                    RedTipImageView.this.mCopyIcon.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            });
            this.mStarAnimSet.start();
            return;
        }
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(this.mIcon, Key.ALPHA, 0.0f, 1.0f).setDuration(300L);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(this.mCopyIcon, Key.ALPHA, 1.0f, 0.0f).setDuration(300L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mCancelStarAnimSet = animatorSet2;
        animatorSet2.play(duration7).with(duration8);
        this.mCancelStarAnimSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.toolbar.RedTipImageView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RedTipImageView.this.setEnabled(true);
                RedTipImageView.this.mCopyIcon.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                RedTipImageView.this.setEnabled(false);
            }
        });
        this.mCancelStarAnimSet.start();
    }
}
