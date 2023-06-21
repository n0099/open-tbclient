package com.baidu.searchbox.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.ui.SelectorTextView;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.spswitch.emotion.EmotionLoader;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CommentInputLayout extends LinearLayout implements IFontSizeViewListener {
    public static final float DISABLED_ALPHA = 0.5f;
    public static final float EMOTION_RATIO = 1.2f;
    public SelectorImageView mCommentEmojiIcon;
    public SelectorImageView mCommentEmojiIcon1;
    public SelectorImageView mCommentEmojiIcon2;
    public View mCommentHotContainer;
    public View mCommentHotCutLine;
    public SelectorImageView mCommentHotIcon;
    public SelectorTextView mCommentInputGuide;
    public ICommentInputLayoutCallback mCommentInputLayoutCallback;
    public SelectorTextView mCommentInputView;
    public AnimatorSet mGuideAnim;
    public AnimatorSet mGuideEndAnim;
    public boolean mIsGuideShowing;
    public boolean mIsResponseFontSize;

    public CommentInputLayout(Context context) {
        super(context);
        this.mIsResponseFontSize = false;
        initLayout(context);
    }

    public void setCommentHotOpen(boolean z) {
        Drawable drawable;
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (z) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.common_tool_bar_item_barrage_open);
        } else {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.common_tool_bar_item_barrage_close);
        }
        selectorImageView.setImageDrawable(drawable);
    }

    public void setCommentInputLayoutCallback(@Nullable ICommentInputLayoutCallback iCommentInputLayoutCallback) {
        this.mCommentInputLayoutCallback = iCommentInputLayoutCallback;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mCommentInputView.setEnabled(z);
        this.mCommentHotIcon.setEnabled(z);
        this.mCommentEmojiIcon.setEnabled(z);
        this.mCommentEmojiIcon1.setEnabled(z);
        this.mCommentEmojiIcon2.setEnabled(z);
        this.mCommentInputGuide.setEnabled(z);
        ICommentInputLayoutCallback iCommentInputLayoutCallback = this.mCommentInputLayoutCallback;
        if (iCommentInputLayoutCallback != null) {
            iCommentInputLayoutCallback.onSetEnabled(z);
        }
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (selectorImageView != null) {
            selectorImageView.setIsResponseFontSize(z);
        }
        SelectorImageView selectorImageView2 = this.mCommentEmojiIcon;
        if (selectorImageView2 != null) {
            selectorImageView2.setIsResponseFontSize(z);
        }
        SelectorImageView selectorImageView3 = this.mCommentEmojiIcon1;
        if (selectorImageView3 != null) {
            selectorImageView3.setIsResponseFontSize(z);
        }
        SelectorImageView selectorImageView4 = this.mCommentEmojiIcon2;
        if (selectorImageView4 != null) {
            selectorImageView4.setIsResponseFontSize(z);
        }
        onFontSizeChange();
    }

    public void setSupportDark(boolean z) {
        this.mCommentHotIcon.setSupportDark(Boolean.valueOf(z));
        this.mCommentEmojiIcon.setSupportDark(Boolean.valueOf(z));
        this.mCommentEmojiIcon1.setSupportDark(Boolean.valueOf(z));
        this.mCommentEmojiIcon2.setSupportDark(Boolean.valueOf(z));
    }

    public CommentInputLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsResponseFontSize = false;
        initLayout(context);
    }

    public CommentInputLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsResponseFontSize = false;
        initLayout(context);
    }

    private AnimatorSet buildCommentInputGuideAnim(int i, View view2, View view3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f, -i);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, Key.TRANSLATION_Y, i, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 1.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(320L);
        animatorSet2.setStartDelay(160L);
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(animatorSet, animatorSet2);
        return animatorSet3;
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.common_comment_intput_layout, (ViewGroup) this, true);
        setIsResponseFontSize(true);
        SelectorTextView selectorTextView = (SelectorTextView) findViewById(R.id.obfuscated_res_0x7f092524);
        this.mCommentInputView = selectorTextView;
        selectorTextView.setPadding(getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070257), 0, 0, 0);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mCommentInputView, 0, R.dimen.obfuscated_res_0x7f070254, 2);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f081499));
        this.mCommentInputView.setText(R.string.obfuscated_res_0x7f0f049c);
        this.mCommentInputView.setSingleLine(true);
        this.mCommentInputView.setEllipsize(TextUtils.TruncateAt.END);
        this.mCommentInputView.setGravity(16);
        this.mCommentHotContainer = findViewById(R.id.comments_hot_comment);
        this.mCommentHotIcon = (SelectorImageView) findViewById(R.id.comments_hot_comment_icon);
        this.mCommentHotCutLine = findViewById(R.id.comments_hot_cut_line);
        this.mCommentEmojiIcon = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji);
        this.mCommentEmojiIcon1 = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji_1);
        this.mCommentEmojiIcon2 = (SelectorImageView) findViewById(R.id.toolbar_comment_input_emoji_2);
        this.mCommentInputGuide = (SelectorTextView) findViewById(R.id.toolbar_comment_input_guide_view);
        onFontSizeChange();
    }

    public void endCommentInputGuide(boolean z) {
        SelectorTextView selectorTextView;
        if (this.mCommentInputGuide != null && (selectorTextView = this.mCommentInputView) != null) {
            if (!z) {
                selectorTextView.setVisibility(0);
                this.mCommentInputView.setTranslationY(0.0f);
                this.mCommentInputView.setAlpha(1.0f);
                this.mCommentInputGuide.setVisibility(8);
                this.mIsGuideShowing = false;
                return;
            }
            int measuredHeight = selectorTextView.getMeasuredHeight();
            if (this.mGuideEndAnim == null) {
                AnimatorSet buildCommentInputGuideAnim = buildCommentInputGuideAnim(-measuredHeight, this.mCommentInputGuide, this.mCommentInputView);
                this.mGuideEndAnim = buildCommentInputGuideAnim;
                buildCommentInputGuideAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.toolbar.CommentInputLayout.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        CommentInputLayout.this.mCommentInputGuide.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        CommentInputLayout.this.mCommentInputView.setVisibility(0);
                        CommentInputLayout.this.mIsGuideShowing = false;
                    }
                });
            }
            this.mGuideEndAnim.start();
        }
    }

    public SelectorImageView getCommentEmojiIcon() {
        return this.mCommentEmojiIcon;
    }

    public SelectorImageView getCommentEmojiIcon1() {
        return this.mCommentEmojiIcon1;
    }

    public SelectorImageView getCommentEmojiIcon2() {
        return this.mCommentEmojiIcon2;
    }

    public View getCommentHotCutLine() {
        return this.mCommentHotCutLine;
    }

    public SelectorImageView getCommentHotIcon() {
        return this.mCommentHotIcon;
    }

    public View getCommentHotView() {
        return this.mCommentHotContainer;
    }

    public SelectorTextView getCommentInputGuide() {
        return this.mCommentInputGuide;
    }

    public SelectorTextView getCommentInputView() {
        return this.mCommentInputView;
    }

    public boolean isGuideShowing() {
        return this.mIsGuideShowing;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    public void releaseAnim() {
        AnimatorSet animatorSet = this.mGuideAnim;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mGuideAnim.end();
            this.mGuideAnim = null;
        }
        AnimatorSet animatorSet2 = this.mGuideEndAnim;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.mGuideEndAnim.end();
            this.mGuideEndAnim = null;
        }
    }

    public void setCommentHotDisable() {
        setCommentHotOpen(false);
        this.mCommentHotIcon.setEnabled(false);
        this.mCommentHotIcon.setAlpha(0.5f);
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        SelectorTextView selectorTextView;
        SelectorTextView selectorTextView2 = this.mCommentInputView;
        if (selectorTextView2 != null) {
            if (this.mIsResponseFontSize) {
                FontSizeTextViewExtKt.setScaledSize(selectorTextView2, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254) * 1.0f, 2);
            } else {
                selectorTextView2.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254));
            }
            this.mCommentInputView.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), this.mCommentInputView.getText(), this.mCommentInputView, 1.2f), TextView.BufferType.SPANNABLE);
        }
        SelectorImageView selectorImageView = this.mCommentHotIcon;
        if (selectorImageView != null) {
            selectorImageView.onFontSizeChange();
        }
        SelectorImageView selectorImageView2 = this.mCommentEmojiIcon;
        if (selectorImageView2 != null) {
            selectorImageView2.onFontSizeChange();
        }
        SelectorImageView selectorImageView3 = this.mCommentEmojiIcon1;
        if (selectorImageView3 != null) {
            selectorImageView3.onFontSizeChange();
        }
        SelectorImageView selectorImageView4 = this.mCommentEmojiIcon2;
        if (selectorImageView4 != null) {
            selectorImageView4.onFontSizeChange();
        }
        if (isResponseFontSize() && (selectorTextView = this.mCommentInputGuide) != null) {
            FontSizeTextViewExtKt.setScaledSize(selectorTextView, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254) * 1.0f, 2);
            this.mCommentInputGuide.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), this.mCommentInputGuide.getText(), this.mCommentInputGuide, 1.2f), TextView.BufferType.SPANNABLE);
        }
        if (isResponseFontSize()) {
            FontSizeViewExtKt.setScaledHeightRes(this, 0, R.dimen.obfuscated_res_0x7f070252, 2);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f081499);
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f070b15));
                setBackground(drawable);
            }
        }
    }

    public void startCommentInputGuide(SpannableString spannableString, boolean z) {
        if (this.mCommentInputGuide != null && this.mCommentInputView != null) {
            this.mCommentInputGuide.setText(EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), spannableString, this.mCommentInputGuide, 1.2f), TextView.BufferType.SPANNABLE);
            if (!z) {
                this.mCommentInputGuide.setVisibility(0);
                this.mCommentInputGuide.setAlpha(1.0f);
                this.mCommentInputGuide.setTranslationY(0.0f);
                this.mCommentInputView.setVisibility(8);
                this.mIsGuideShowing = true;
                return;
            }
            int measuredHeight = this.mCommentInputView.getMeasuredHeight();
            if (this.mGuideAnim == null) {
                AnimatorSet buildCommentInputGuideAnim = buildCommentInputGuideAnim(measuredHeight, this.mCommentInputView, this.mCommentInputGuide);
                this.mGuideAnim = buildCommentInputGuideAnim;
                buildCommentInputGuideAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.toolbar.CommentInputLayout.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        CommentInputLayout.this.mCommentInputView.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        CommentInputLayout.this.mCommentInputGuide.setVisibility(0);
                        CommentInputLayout.this.mIsGuideShowing = true;
                    }
                });
            }
            this.mGuideAnim.start();
        }
    }
}
