package com.baidu.searchbox.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.ext.widget.toast.UniversalToast;
/* loaded from: classes4.dex */
public class PraiseView extends LinearLayout {
    public boolean mCanPraise;
    public ImageView mCommentlistitemPraiseRightStar;
    public ImageView mCommentlistitemPraiseTopStar;
    public ImageView mCommentlistitemPraiseicon;
    public View mCommentlistitemPraiseiconBg;
    public ImageView mCommentlistitemPraiseiconLow;
    public TextView mCommentlistitemPraisenum;
    public TextView mCommentlistitemPraisenumDiffLow;
    public TextView mCommentlistitemPraisenumDiffUp;
    public int mCount;
    public boolean mIsPraised;
    public boolean mNeedDefaultToast;
    public OnClickPraiseListener mOnClickPraiseListener;

    /* loaded from: classes4.dex */
    public interface OnClickPraiseListener {
        void onClick(boolean z, int i);
    }

    public PraiseView(Context context) {
        super(context, null);
        this.mIsPraised = false;
        this.mCount = 0;
        this.mCanPraise = true;
        this.mNeedDefaultToast = true;
        this.mOnClickPraiseListener = null;
    }

    public void setNeedDefaultToast(boolean z) {
        this.mNeedDefaultToast = z;
    }

    public void setOnClickPraiseListener(OnClickPraiseListener onClickPraiseListener) {
        this.mOnClickPraiseListener = onClickPraiseListener;
    }

    public void setPraiseAble(boolean z) {
        this.mCanPraise = z;
    }

    public void setPraiseCount(int i) {
        this.mCount = i;
        if (i == 0) {
            this.mCommentlistitemPraisenum.setText(getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f04a6));
        } else {
            this.mCommentlistitemPraisenum.setText(displayLikeCount(i, getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f04a7)));
        }
    }

    public PraiseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPraised = false;
        this.mCount = 0;
        this.mCanPraise = true;
        this.mNeedDefaultToast = true;
        this.mOnClickPraiseListener = null;
        init(context);
    }

    private int getDiffPos(String str, String str2) {
        int length;
        if (str == null || str2 == null || (length = str.length()) != str2.length()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != str2.charAt(i2)) {
                return i;
            }
            i++;
        }
        return i;
    }

    public String displayLikeCount(int i, String str) {
        if (i > 9999) {
            return String.valueOf((((int) ((i / 1000.0d) + 0.5d)) / 10.0d) + str);
        }
        return String.valueOf(i);
    }

    public PraiseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPraised = false;
        this.mCount = 0;
        this.mCanPraise = true;
        this.mNeedDefaultToast = true;
        this.mOnClickPraiseListener = null;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.praise_view, (ViewGroup) this, true);
        this.mCommentlistitemPraiseiconBg = findViewById(com.baidu.tieba.R.id.iv_commentlistitem_praiseicon_bg);
        this.mCommentlistitemPraiseicon = (ImageView) findViewById(com.baidu.tieba.R.id.iv_commentlistitem_praiseicon);
        this.mCommentlistitemPraiseiconLow = (ImageView) findViewById(com.baidu.tieba.R.id.iv_commentlistitem_praiseicon_below);
        this.mCommentlistitemPraiseTopStar = (ImageView) findViewById(com.baidu.tieba.R.id.iv_commentlistitem_praise_top_star);
        this.mCommentlistitemPraiseRightStar = (ImageView) findViewById(com.baidu.tieba.R.id.iv_commentlistitem_praise_right_star);
        this.mCommentlistitemPraisenum = (TextView) findViewById(com.baidu.tieba.R.id.tv_commentlistitem_praisenum);
        this.mCommentlistitemPraisenumDiffLow = (TextView) findViewById(com.baidu.tieba.R.id.tv_commentlistitem_praisenum_diff_low);
        this.mCommentlistitemPraisenumDiffUp = (TextView) findViewById(com.baidu.tieba.R.id.tv_commentlistitem_praisenum_diff_up);
        this.mCommentlistitemPraiseicon.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080270));
        this.mCommentlistitemPraiseicon.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080270));
        this.mCommentlistitemPraisenum.setTextColor(getResources().getColor(com.baidu.tieba.R.color.bdcomment_tv_commentlistitem_praisenum_text_color));
        this.mCommentlistitemPraisenum.setTextColor(getResources().getColor(com.baidu.tieba.R.color.bdcomment_tv_commentlistitem_praisenum_text_color));
        setup();
    }

    private void setup() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.PraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PraiseView.this.isPraiseAble()) {
                    if (PraiseView.this.mIsPraised) {
                        if (PraiseView.this.needDefaultToast()) {
                            UniversalToast.makeText(PraiseView.this.getContext().getApplicationContext(), (int) com.baidu.tieba.R.string.comment_detail_liked).showToast();
                        }
                    } else {
                        PraiseView.this.mCommentlistitemPraiseicon.setImageDrawable(PraiseView.this.getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080515));
                        int i = PraiseView.this.mCount + 1;
                        int i2 = PraiseView.this.mCount;
                        TextView textView = PraiseView.this.mCommentlistitemPraisenum;
                        PraiseView praiseView = PraiseView.this;
                        textView.setText(praiseView.displayLikeCount(i, praiseView.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f04a7)));
                        PraiseView.this.mCommentlistitemPraisenum.setTextColor(PraiseView.this.getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0604fe));
                        PraiseView.this.startPraiseAnim(i2 + "", i + "");
                        PraiseView.this.mCount = i;
                        PraiseView.this.setPraise(true);
                    }
                }
                if (PraiseView.this.mOnClickPraiseListener != null) {
                    PraiseView.this.mOnClickPraiseListener.onClick(PraiseView.this.mIsPraised, PraiseView.this.mCount);
                }
            }
        });
    }

    public boolean isPraiseAble() {
        return this.mCanPraise;
    }

    public boolean needDefaultToast() {
        return this.mNeedDefaultToast;
    }

    public void startPraiseAnim() {
        startPraiseAnim(this.mCount + "", (this.mCount + 1) + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPraiseAnim(String str, final String str2) {
        String str3;
        View view2;
        int diffPos = getDiffPos(str, str2);
        if (diffPos != 0) {
            str3 = str2.substring(0, diffPos);
        } else {
            str3 = "";
        }
        String substring = str2.substring(diffPos);
        String substring2 = str.substring(diffPos);
        this.mCommentlistitemPraisenum.setText(str3);
        this.mCommentlistitemPraisenum.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0604f7));
        this.mCommentlistitemPraisenumDiffUp.setText(substring);
        this.mCommentlistitemPraisenumDiffUp.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0604f7));
        this.mCommentlistitemPraisenumDiffLow.setText(substring2);
        this.mCommentlistitemPraisenumDiffLow.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0604f8));
        float height = this.mCommentlistitemPraisenumDiffUp.getHeight();
        float f = (-1.0f) * height;
        this.mCommentlistitemPraisenumDiffUp.setTranslationY(f);
        this.mCommentlistitemPraiseiconBg.setPivotX(0.0f);
        this.mCommentlistitemPraiseiconBg.setPivotY(view2.getHeight());
        this.mCommentlistitemPraiseiconLow.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080270));
        this.mCommentlistitemPraiseiconLow.setAlpha(1.0f);
        this.mCommentlistitemPraiseicon.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08026a));
        this.mCommentlistitemPraiseicon.setAlpha(0.0f);
        this.mCommentlistitemPraiseTopStar.setScaleX(0.0f);
        this.mCommentlistitemPraiseTopStar.setScaleY(0.0f);
        this.mCommentlistitemPraiseRightStar.setScaleX(0.0f);
        this.mCommentlistitemPraiseRightStar.setScaleY(0.0f);
        this.mCommentlistitemPraiseTopStar.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.bdcomment_list_praise_star));
        this.mCommentlistitemPraiseRightStar.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.bdcomment_list_praise_star));
        this.mCommentlistitemPraisenumDiffUp.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseiconBg, "rotation", 0.0f, 20.0f);
        ofFloat.setDuration(130L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseiconBg, "rotation", 20.0f, -20.0f);
        ofFloat2.setDuration(200L).setStartDelay(130L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseiconBg, "rotation", -20.0f, 10.0f);
        ofFloat3.setDuration(130L).setStartDelay(330L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseiconBg, "rotation", 10.0f, 0.0f);
        ofFloat4.setDuration(70L).setStartDelay(460L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseiconLow, Key.ALPHA, 1.0f, 0.0f);
        ofFloat5.setDuration(130L).setStartDelay(330L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseicon, Key.ALPHA, 0.0f, 1.0f);
        ofFloat6.setDuration(100L).setStartDelay(330L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseTopStar, Key.SCALE_X, 0.0f, 1.3f, 0.0f);
        ofFloat7.setDuration(320L).setStartDelay(210L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseTopStar, Key.SCALE_Y, 0.0f, 1.3f, 0.0f);
        ofFloat8.setDuration(320L).setStartDelay(210L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseRightStar, Key.SCALE_X, 0.0f, 1.3f, 0.0f);
        ofFloat9.setDuration(320L).setStartDelay(370L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.mCommentlistitemPraiseRightStar, Key.SCALE_Y, 0.0f, 1.3f, 0.0f);
        ofFloat10.setDuration(320L).setStartDelay(370L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.mCommentlistitemPraisenumDiffUp, Key.TRANSLATION_Y, f, 0.0f);
        ofFloat11.setDuration(250L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.mCommentlistitemPraisenumDiffUp, Key.ALPHA, 0.0f, 1.0f);
        ofFloat12.setDuration(250L);
        ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this.mCommentlistitemPraisenumDiffLow, Key.TRANSLATION_Y, 0.0f, height);
        ofFloat13.setDuration(250L);
        ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(this.mCommentlistitemPraisenumDiffLow, Key.ALPHA, 1.0f, 0.0f);
        ofFloat14.setDuration(250L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofFloat8, ofFloat9, ofFloat10, ofFloat11, ofFloat12, ofFloat13, ofFloat14);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.PraiseView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PraiseView.this.mCommentlistitemPraiseiconLow.setAlpha(0.0f);
                PraiseView.this.mCommentlistitemPraiseicon.setAlpha(1.0f);
                PraiseView.this.mCommentlistitemPraisenum.setText(str2);
                PraiseView.this.mCommentlistitemPraisenumDiffUp.setText("");
                PraiseView.this.mCommentlistitemPraisenumDiffLow.setText("");
                PraiseView.this.mCommentlistitemPraisenumDiffLow.setAlpha(0.0f);
            }
        });
        animatorSet.start();
    }

    public void setPraise(boolean z) {
        this.mIsPraised = z;
        if (z) {
            this.mCommentlistitemPraiseicon.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080515));
            this.mCommentlistitemPraisenum.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0604fe));
            return;
        }
        this.mCommentlistitemPraiseicon.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080516));
        this.mCommentlistitemPraisenum.setTextColor(getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0604ff));
    }
}
