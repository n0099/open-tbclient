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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aOW;
    private c aOY;
    private TextView aQn;
    private ObjectAnimator aWA;
    private RelativeLayout aWB;
    private HeadImageView aWC;
    private TbImageView aWD;
    private LottieAnimationView aWE;
    private AlaGiftStrokeTextView aWF;
    private LottieAnimationView aWG;
    private a aWH;
    private int aWI;
    private ObjectAnimator aWr;
    private ObjectAnimator aWs;
    private ObjectAnimator aWt;
    private AnimatorSet aWu;
    private ObjectAnimator aWv;
    private ObjectAnimator aWw;
    private ObjectAnimator aWx;
    private AnimatorSet aWy;
    private ObjectAnimator aWz;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void GA();

        void Gz();

        void R(View view);
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
        LayoutInflater.from(getContext()).inflate(a.h.popup_gift_layout, this);
        this.aWB = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aWB.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aWC = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aWC.setIsRound(true);
        this.aWC.setAutoChangeStyle(false);
        this.aWC.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aWC.setOnClickListener(this);
        this.aOW = (TextView) findViewById(a.g.sender_name);
        this.aOW.setOnClickListener(this);
        this.aQn = (TextView) findViewById(a.g.gift_name);
        this.aWD = (TbImageView) findViewById(a.g.gift_icon);
        this.aWD.setAutoChangeStyle(false);
        this.aWD.setDefaultBgResource(a.d.sdk_transparent);
        this.aWD.setDefaultErrorResource(a.d.sdk_transparent);
        this.aWD.setGifIconSupport(false);
        this.aWF = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aWE = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aWE.loop(true);
        this.aWE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aWG = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aWG.loop(true);
        this.aWF.getPaint().setFakeBoldText(true);
        HE();
    }

    public void setMode(boolean z) {
        this.aWI = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void HE() {
        this.aWs = ObjectAnimator.ofFloat(this.aWC, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aWs.setDuration(350L);
        this.aWs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.HG();
                AlaSmallGiftView.this.HH();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aWv = ObjectAnimator.ofFloat(this.aWD, "ScaleX", 0.1f, 1.0f);
        this.aWw = ObjectAnimator.ofFloat(this.aWD, "ScaleY", 0.1f, 1.0f);
        this.aWu = new AnimatorSet();
        this.aWu.playTogether(this.aWv, this.aWw);
        this.aWu.setInterpolator(new OvershootInterpolator(4.0f));
        this.aWu.setDuration(400L);
        this.aWu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aWH != null) {
                    AlaSmallGiftView.this.aWH.Gz();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aWx = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aWx.setDuration(300L);
        this.aWx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.HM();
                AlaSmallGiftView.this.HN();
                if (AlaSmallGiftView.this.aWH != null) {
                    AlaSmallGiftView.this.aWH.R(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aWz = ObjectAnimator.ofFloat(this.aWF, "ScaleX", 3.0f, 1.0f);
        this.aWA = ObjectAnimator.ofFloat(this.aWF, "ScaleY", 3.0f, 1.0f);
        this.aWy = new AnimatorSet();
        this.aWy.playTogether(this.aWz, this.aWA);
        this.aWy.setDuration(240L);
        this.aWy.setInterpolator(new OvershootInterpolator());
        this.aWy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aWH != null) {
                    AlaSmallGiftView.this.aWH.GA();
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

    private void HF() {
        this.aWC.setVisibility(0);
        this.aWs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        this.aWD.setVisibility(0);
        this.aWu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        if (this.aWE != null && this.aWE.getVisibility() == 0) {
            this.aWE.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aWE.cancelAnimation();
                    AlaSmallGiftView.this.aWE.playAnimation();
                }
            });
        }
        if (this.aWG != null && this.aWG.getVisibility() == 0) {
            this.aWG.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aWG.cancelAnimation();
                    AlaSmallGiftView.this.aWG.playAnimation();
                }
            });
        }
    }

    private void HI() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aWt = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aWt.setInterpolator(new OvershootInterpolator());
            this.aWt.setDuration(300L);
            this.aWt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.HG();
                    AlaSmallGiftView.this.HH();
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

    private void HJ() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aWr = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aWr.setInterpolator(new OvershootInterpolator());
            this.aWr.setDuration(300L);
        }
    }

    public void HK() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            HN();
            if (this.aWs != null) {
                this.aWs.cancel();
            }
            this.aWC.setVisibility(0);
            if (this.aWt == null) {
                HI();
            }
            this.aWt.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            HN();
            if (this.aWr == null) {
                HJ();
            }
            this.aWr.start();
            HF();
        }
    }

    public void HL() {
        this.aWx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        this.aWD.setVisibility(8);
    }

    public void HN() {
        setTranslationY(0.0f);
        if (this.aWs != null) {
            this.aWs.cancel();
        }
        if (this.aWu != null) {
            this.aWu.cancel();
        }
        if (this.aWy != null) {
            this.aWy.cancel();
        }
        if (this.aWr != null) {
            this.aWr.cancel();
        }
        if (this.aWt != null) {
            this.aWt.cancel();
        }
        if (this.aWx != null) {
            this.aWx.cancel();
        }
        if (this.aWG != null) {
            this.aWG.cancelAnimation();
        }
        if (this.aWE != null) {
            this.aWE.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aSS != null) {
            this.aOY = cVar;
            setGiftCnt(cVar.aSX);
            gv(cVar.userName);
            this.aQn.setText(cVar.aSS.DS());
            HO();
            HP();
            if (z) {
                setDisplayStyle(cVar.aSX);
            }
        }
    }

    private void HO() {
        if (this.aOY != null) {
            this.aWC.setUrl(this.aOY.portrait);
            k.a(this.aWC, this.aOY.portrait, false, !StringUtils.isNull(this.aOY.appId));
        }
    }

    private void HP() {
        if (this.aOY != null && this.aOY.aSS != null) {
            this.aWD.setVisibility(0);
            this.aWD.startLoad(this.aOY.aSS.getThumbnail_url(), 10, false);
        }
    }

    private void gv(String str) {
        this.aOW.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aOW.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aWE.setVisibility(8);
            this.aWG.setVisibility(8);
            this.aWB.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aWF.setGravity(3);
        } else if (j <= 65) {
            this.aWE.setVisibility(8);
            this.aWG.setVisibility(8);
            this.aWB.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aWF.setGravity(19);
        } else if (j <= 187) {
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("66-1.json");
            this.aWG.setVisibility(8);
            this.aWB.setBackgroundResource(a.d.sdk_transparent);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("188-1.json");
            this.aWG.setVisibility(0);
            this.aWG.setAnimation("188-2.json");
            this.aWB.setBackgroundResource(a.d.sdk_transparent);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("520-1.json");
            this.aWG.setVisibility(0);
            this.aWG.setAnimation("520-2.json");
            this.aWB.setBackgroundResource(a.d.sdk_transparent);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("1314-1.json");
            this.aWG.setVisibility(0);
            this.aWG.setAnimation("1314-2.json");
            this.aWB.setBackgroundResource(a.d.sdk_transparent);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("9999-1.json");
            this.aWG.setVisibility(0);
            this.aWG.setAnimation("9999-2.json");
            this.aWB.setBackgroundResource(a.d.sdk_transparent);
            this.aWF.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aWF.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWF.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aWG.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aWF.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aWF.setLayoutParams(layoutParams);
            this.aWF.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aWF.getLayoutParams();
            layoutParams2.width = -2;
            this.aWF.setLayoutParams(layoutParams2);
            this.aWF.setGravity(19);
        }
        this.aWz.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aWA.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aWy.setDuration(840L);
        this.aWy.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aWy.getChildAnimations();
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
                if (this.aWI > 0) {
                    this.aWB.setBackgroundResource(this.aWI);
                } else {
                    this.aWB.setBackgroundResource(a.f.gray_circle);
                }
                this.aWF.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aWB.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aWF.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aWz.setFloatValues(3.0f, 1.0f);
                this.aWA.setFloatValues(3.0f, 1.0f);
                this.aWy.setDuration(240L);
                this.aWy.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aWz.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aWA.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aWy.setDuration(480L);
                this.aWy.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aWy.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aWF.setVisibility(8);
        } else {
            this.aWF.setVisibility(0);
        }
        this.aWF.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aOY;
    }

    public void f(long j, long j2) {
        HO();
        HP();
        if (j < 1) {
            this.aWF.setVisibility(8);
        } else if (this.aOY != null) {
            this.aOY.aSX = j2;
            this.aOY.aSW = j;
            this.aWF.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            HQ();
            HH();
        }
    }

    private void HQ() {
        this.aWF.setVisibility(0);
        this.aWy.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOY.userId), this.aOY.userName, this.aOY.portrait, this.aOY.sex, this.aOY.aSU, this.aOY.location, this.aOY.description, 0L, this.aOY.fansCount, this.aOY.aSV, this.aOY.userStatus, this.aOY.liveId, this.aOY.groupId, this.aOY.aSY, this.aOY.aSZ, this.aOY.appId, this.aOY.userName, "")));
        }
    }

    public void onDestroy() {
        HN();
        if (this.aWB != null) {
            this.aWB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aOY != null && this.aOY.aSX < this.aOY.aSW) {
            if (this.aOY.aSX <= 0) {
                this.aOY.aSX = 1L;
            }
            this.aWF.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aOY.aSX)));
            HQ();
            setDisplayStyle(this.aOY.aSX);
            HH();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aWH = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aWE != null && this.aWE.getVisibility() == 0) {
            int width = this.aWB.getWidth();
            int height = this.aWB.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aWE.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aWE.setLayoutParams(layoutParams);
        }
    }
}
