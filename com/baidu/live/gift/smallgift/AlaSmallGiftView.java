package com.baidu.live.gift.smallgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView bac;
    private c bae;
    private TextView bbz;
    private ObjectAnimator biK;
    private ObjectAnimator biL;
    private ObjectAnimator biM;
    private AnimatorSet biN;
    private ObjectAnimator biO;
    private ObjectAnimator biP;
    private ObjectAnimator biQ;
    private AnimatorSet biR;
    private ObjectAnimator biS;
    private ObjectAnimator biT;
    private RelativeLayout biU;
    private HeadImageView biV;
    private TextView biW;
    private TbImageView biX;
    private LottieAnimationView biY;
    private AlaGiftStrokeTextView biZ;
    private LottieAnimationView bja;
    private a bjb;
    private int bjc;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void JB();

        void JC();

        void T(View view);
    }

    public AlaSmallGiftView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public AlaSmallGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.popup_gift_layout, this);
        this.biU = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.biU.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.biV = (HeadImageView) findViewById(a.f.sender_avatar);
        this.biV.setIsRound(true);
        this.biV.setAutoChangeStyle(false);
        this.biV.setDefaultBgResource(a.e.sdk_default_avatar);
        this.biV.setOnClickListener(this);
        this.bac = (TextView) findViewById(a.f.sender_name);
        this.bac.setOnClickListener(this);
        this.bbz = (TextView) findViewById(a.f.gift_name);
        this.biW = (TextView) findViewById(a.f.giftNameTip);
        this.biX = (TbImageView) findViewById(a.f.gift_icon);
        this.biX.setAutoChangeStyle(false);
        this.biX.setDefaultBgResource(a.c.sdk_transparent);
        this.biX.setDefaultErrorResource(a.c.sdk_transparent);
        this.biX.setGifIconSupport(false);
        this.biZ = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.biY = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.biY.loop(true);
        this.biY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bja = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bja.loop(true);
        this.biZ.getPaint().setFakeBoldText(true);
        KN();
    }

    public void setMode(boolean z) {
        this.bjc = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void KN() {
        this.biL = ObjectAnimator.ofFloat(this.biV, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.biL.setDuration(350L);
        this.biL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.KP();
                AlaSmallGiftView.this.KQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biO = ObjectAnimator.ofFloat(this.biX, "ScaleX", 0.1f, 1.0f);
        this.biP = ObjectAnimator.ofFloat(this.biX, "ScaleY", 0.1f, 1.0f);
        this.biN = new AnimatorSet();
        this.biN.playTogether(this.biO, this.biP);
        this.biN.setInterpolator(new OvershootInterpolator(4.0f));
        this.biN.setDuration(400L);
        this.biN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bjb != null) {
                    AlaSmallGiftView.this.bjb.JB();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biQ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.biQ.setDuration(300L);
        this.biQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.KV();
                AlaSmallGiftView.this.KW();
                if (AlaSmallGiftView.this.bjb != null) {
                    AlaSmallGiftView.this.bjb.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biS = ObjectAnimator.ofFloat(this.biZ, "ScaleX", 3.0f, 1.0f);
        this.biT = ObjectAnimator.ofFloat(this.biZ, "ScaleY", 3.0f, 1.0f);
        this.biR = new AnimatorSet();
        this.biR.playTogether(this.biS, this.biT);
        this.biR.setDuration(240L);
        this.biR.setInterpolator(new OvershootInterpolator());
        this.biR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bjb != null) {
                    AlaSmallGiftView.this.bjb.JC();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void KO() {
        this.biV.setVisibility(0);
        this.biL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP() {
        this.biX.setVisibility(0);
        this.biN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KQ() {
        if (this.biY != null && this.biY.getVisibility() == 0) {
            this.biY.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.biY.cancelAnimation();
                    AlaSmallGiftView.this.biY.playAnimation();
                }
            });
        }
        if (this.bja != null && this.bja.getVisibility() == 0) {
            this.bja.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bja.cancelAnimation();
                    AlaSmallGiftView.this.bja.playAnimation();
                }
            });
        }
    }

    private void KR() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.biM = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.biM.setInterpolator(new OvershootInterpolator());
            this.biM.setDuration(300L);
            this.biM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.KP();
                    AlaSmallGiftView.this.KQ();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
        }
    }

    private void KS() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.biK = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.biK.setInterpolator(new OvershootInterpolator());
            this.biK.setDuration(300L);
        }
    }

    public void KT() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            KW();
            if (this.biL != null) {
                this.biL.cancel();
            }
            this.biV.setVisibility(0);
            if (this.biM == null) {
                KR();
            }
            this.biM.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            KW();
            if (this.biK == null) {
                KS();
            }
            this.biK.start();
            KO();
        }
    }

    public void KU() {
        this.biQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        this.biX.setVisibility(8);
    }

    public void KW() {
        setTranslationY(0.0f);
        if (this.biL != null) {
            this.biL.cancel();
        }
        if (this.biN != null) {
            this.biN.cancel();
        }
        if (this.biR != null) {
            this.biR.cancel();
        }
        if (this.biK != null) {
            this.biK.cancel();
        }
        if (this.biM != null) {
            this.biM.cancel();
        }
        if (this.biQ != null) {
            this.biQ.cancel();
        }
        if (this.bja != null) {
            this.bja.cancelAnimation();
        }
        if (this.biY != null) {
            this.biY.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bex != null) {
            this.bae = cVar;
            setGiftCnt(cVar.beD);
            hl(cVar.userName);
            this.bbz.setText(cVar.bex.Gy());
            if (!TextUtils.isEmpty(cVar.beN)) {
                this.biW.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.biW.setText(cVar.beN);
            } else {
                this.biW.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha90));
                this.biW.setText(this.mContext.getString(a.h.gift_name_prefix));
            }
            KX();
            KY();
            if (z) {
                setDisplayStyle(cVar.beD);
            }
        }
    }

    private void KX() {
        if (this.bae != null) {
            this.biV.setUrl(this.bae.portrait);
            m.a(this.biV, this.bae.portrait, false, !StringUtils.isNull(this.bae.appId));
        }
    }

    private void KY() {
        if (this.bae != null && this.bae.bex != null) {
            this.biX.setVisibility(0);
            this.biX.startLoad(this.bae.bex.getThumbnail_url(), 10, false);
        }
    }

    private void hl(String str) {
        this.bac.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.bac.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.biY.setVisibility(8);
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.biZ.setGravity(3);
        } else if (j <= 65) {
            this.biY.setVisibility(8);
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.biZ.setGravity(19);
        } else if (j <= 187) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("66-1.json");
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("188-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("188-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("520-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("520-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("1314-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("1314-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.biY.setVisibility(0);
            this.biY.setAnimation("9999-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("9999-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.biZ.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.biZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biZ.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bja.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.biZ.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.biZ.setLayoutParams(layoutParams);
            this.biZ.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.biZ.getLayoutParams();
            layoutParams2.width = -2;
            this.biZ.setLayoutParams(layoutParams2);
            this.biZ.setGravity(19);
        }
        this.biS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biT.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biR.setDuration(840L);
        this.biR.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.biR.getChildAnimations();
        for (int i = 0; i < childAnimations.size(); i++) {
            Animator animator = childAnimations.get(i);
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(0);
            }
        }
    }

    private void setSendUserBg(int i) {
        switch (i) {
            case 0:
                if (this.bjc > 0) {
                    this.biU.setBackgroundResource(this.bjc);
                } else {
                    this.biU.setBackgroundResource(a.e.gray_circle);
                }
                this.biZ.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.biU.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.biZ.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.biS.setFloatValues(3.0f, 1.0f);
                this.biT.setFloatValues(3.0f, 1.0f);
                this.biR.setDuration(240L);
                this.biR.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.biS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biT.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biR.setDuration(480L);
                this.biR.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.biR.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.biZ.setVisibility(8);
        } else {
            this.biZ.setVisibility(0);
        }
        this.biZ.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.bae;
    }

    public void i(long j, long j2) {
        KX();
        KY();
        if (j < 1) {
            this.biZ.setVisibility(8);
        } else if (this.bae != null) {
            this.bae.beD = j2;
            this.bae.beC = j;
            this.biZ.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            KZ();
            KQ();
        }
    }

    private void KZ() {
        this.biZ.setVisibility(0);
        this.biR.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bae != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bae.userId), this.bae.userName, this.bae.portrait, this.bae.sex, this.bae.bez, this.bae.location, this.bae.description, 0L, this.bae.fansCount, this.bae.followCount, this.bae.userStatus, this.bae.liveId, this.bae.groupId, this.bae.beF, this.bae.beG, this.bae.appId, this.bae.userName)));
        }
    }

    public void onDestroy() {
        KW();
        if (this.biU != null) {
            this.biU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bae != null && this.bae.beD < this.bae.beC) {
            if (this.bae.beD <= 0) {
                this.bae.beD = 1L;
            }
            this.biZ.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.bae.beD)));
            KZ();
            setDisplayStyle(this.bae.beD);
            KQ();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bjb = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.biY != null && this.biY.getVisibility() == 0) {
            int width = this.biU.getWidth();
            int height = this.biU.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.biY.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.biY.setLayoutParams(layoutParams);
        }
    }
}
