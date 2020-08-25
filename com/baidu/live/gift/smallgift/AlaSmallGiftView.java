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
    private TextView aOU;
    private c aOW;
    private TextView aQl;
    private HeadImageView aWA;
    private TbImageView aWB;
    private LottieAnimationView aWC;
    private AlaGiftStrokeTextView aWD;
    private LottieAnimationView aWE;
    private a aWF;
    private int aWG;
    private ObjectAnimator aWp;
    private ObjectAnimator aWq;
    private ObjectAnimator aWr;
    private AnimatorSet aWs;
    private ObjectAnimator aWt;
    private ObjectAnimator aWu;
    private ObjectAnimator aWv;
    private AnimatorSet aWw;
    private ObjectAnimator aWx;
    private ObjectAnimator aWy;
    private RelativeLayout aWz;
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
        this.aWz = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aWz.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aWA = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aWA.setIsRound(true);
        this.aWA.setAutoChangeStyle(false);
        this.aWA.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aWA.setOnClickListener(this);
        this.aOU = (TextView) findViewById(a.g.sender_name);
        this.aOU.setOnClickListener(this);
        this.aQl = (TextView) findViewById(a.g.gift_name);
        this.aWB = (TbImageView) findViewById(a.g.gift_icon);
        this.aWB.setAutoChangeStyle(false);
        this.aWB.setDefaultBgResource(a.d.sdk_transparent);
        this.aWB.setDefaultErrorResource(a.d.sdk_transparent);
        this.aWB.setGifIconSupport(false);
        this.aWD = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aWC = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aWC.loop(true);
        this.aWC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aWE = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aWE.loop(true);
        this.aWD.getPaint().setFakeBoldText(true);
        HE();
    }

    public void setMode(boolean z) {
        this.aWG = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void HE() {
        this.aWq = ObjectAnimator.ofFloat(this.aWA, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aWq.setDuration(350L);
        this.aWq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
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
        this.aWt = ObjectAnimator.ofFloat(this.aWB, "ScaleX", 0.1f, 1.0f);
        this.aWu = ObjectAnimator.ofFloat(this.aWB, "ScaleY", 0.1f, 1.0f);
        this.aWs = new AnimatorSet();
        this.aWs.playTogether(this.aWt, this.aWu);
        this.aWs.setInterpolator(new OvershootInterpolator(4.0f));
        this.aWs.setDuration(400L);
        this.aWs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aWF != null) {
                    AlaSmallGiftView.this.aWF.Gz();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aWv = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aWv.setDuration(300L);
        this.aWv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.HM();
                AlaSmallGiftView.this.HN();
                if (AlaSmallGiftView.this.aWF != null) {
                    AlaSmallGiftView.this.aWF.R(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aWx = ObjectAnimator.ofFloat(this.aWD, "ScaleX", 3.0f, 1.0f);
        this.aWy = ObjectAnimator.ofFloat(this.aWD, "ScaleY", 3.0f, 1.0f);
        this.aWw = new AnimatorSet();
        this.aWw.playTogether(this.aWx, this.aWy);
        this.aWw.setDuration(240L);
        this.aWw.setInterpolator(new OvershootInterpolator());
        this.aWw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aWF != null) {
                    AlaSmallGiftView.this.aWF.GA();
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
        this.aWA.setVisibility(0);
        this.aWq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        this.aWB.setVisibility(0);
        this.aWs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        if (this.aWC != null && this.aWC.getVisibility() == 0) {
            this.aWC.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aWC.cancelAnimation();
                    AlaSmallGiftView.this.aWC.playAnimation();
                }
            });
        }
        if (this.aWE != null && this.aWE.getVisibility() == 0) {
            this.aWE.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aWE.cancelAnimation();
                    AlaSmallGiftView.this.aWE.playAnimation();
                }
            });
        }
    }

    private void HI() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aWr = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aWr.setInterpolator(new OvershootInterpolator());
            this.aWr.setDuration(300L);
            this.aWr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
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
            this.aWp = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aWp.setInterpolator(new OvershootInterpolator());
            this.aWp.setDuration(300L);
        }
    }

    public void HK() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            HN();
            if (this.aWq != null) {
                this.aWq.cancel();
            }
            this.aWA.setVisibility(0);
            if (this.aWr == null) {
                HI();
            }
            this.aWr.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            HN();
            if (this.aWp == null) {
                HJ();
            }
            this.aWp.start();
            HF();
        }
    }

    public void HL() {
        this.aWv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        this.aWB.setVisibility(8);
    }

    public void HN() {
        setTranslationY(0.0f);
        if (this.aWq != null) {
            this.aWq.cancel();
        }
        if (this.aWs != null) {
            this.aWs.cancel();
        }
        if (this.aWw != null) {
            this.aWw.cancel();
        }
        if (this.aWp != null) {
            this.aWp.cancel();
        }
        if (this.aWr != null) {
            this.aWr.cancel();
        }
        if (this.aWv != null) {
            this.aWv.cancel();
        }
        if (this.aWE != null) {
            this.aWE.cancelAnimation();
        }
        if (this.aWC != null) {
            this.aWC.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aSQ != null) {
            this.aOW = cVar;
            setGiftCnt(cVar.aSV);
            gu(cVar.userName);
            this.aQl.setText(cVar.aSQ.DS());
            HO();
            HP();
            if (z) {
                setDisplayStyle(cVar.aSV);
            }
        }
    }

    private void HO() {
        if (this.aOW != null) {
            this.aWA.setUrl(this.aOW.portrait);
            k.a(this.aWA, this.aOW.portrait, false, !StringUtils.isNull(this.aOW.appId));
        }
    }

    private void HP() {
        if (this.aOW != null && this.aOW.aSQ != null) {
            this.aWB.setVisibility(0);
            this.aWB.startLoad(this.aOW.aSQ.getThumbnail_url(), 10, false);
        }
    }

    private void gu(String str) {
        this.aOU.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aOU.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aWC.setVisibility(8);
            this.aWE.setVisibility(8);
            this.aWz.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aWD.setGravity(3);
        } else if (j <= 65) {
            this.aWC.setVisibility(8);
            this.aWE.setVisibility(8);
            this.aWz.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aWD.setGravity(19);
        } else if (j <= 187) {
            this.aWC.setVisibility(0);
            this.aWC.setAnimation("66-1.json");
            this.aWE.setVisibility(8);
            this.aWz.setBackgroundResource(a.d.sdk_transparent);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aWC.setVisibility(0);
            this.aWC.setAnimation("188-1.json");
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("188-2.json");
            this.aWz.setBackgroundResource(a.d.sdk_transparent);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aWC.setVisibility(0);
            this.aWC.setAnimation("520-1.json");
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("520-2.json");
            this.aWz.setBackgroundResource(a.d.sdk_transparent);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aWC.setVisibility(0);
            this.aWC.setAnimation("1314-1.json");
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("1314-2.json");
            this.aWz.setBackgroundResource(a.d.sdk_transparent);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aWC.setVisibility(0);
            this.aWC.setAnimation("9999-1.json");
            this.aWE.setVisibility(0);
            this.aWE.setAnimation("9999-2.json");
            this.aWz.setBackgroundResource(a.d.sdk_transparent);
            this.aWD.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aWD.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aWD.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aWE.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aWD.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aWD.setLayoutParams(layoutParams);
            this.aWD.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aWD.getLayoutParams();
            layoutParams2.width = -2;
            this.aWD.setLayoutParams(layoutParams2);
            this.aWD.setGravity(19);
        }
        this.aWx.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aWy.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aWw.setDuration(840L);
        this.aWw.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aWw.getChildAnimations();
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
                if (this.aWG > 0) {
                    this.aWz.setBackgroundResource(this.aWG);
                } else {
                    this.aWz.setBackgroundResource(a.f.gray_circle);
                }
                this.aWD.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aWz.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aWD.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aWx.setFloatValues(3.0f, 1.0f);
                this.aWy.setFloatValues(3.0f, 1.0f);
                this.aWw.setDuration(240L);
                this.aWw.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aWx.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aWy.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aWw.setDuration(480L);
                this.aWw.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aWw.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aWD.setVisibility(8);
        } else {
            this.aWD.setVisibility(0);
        }
        this.aWD.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aOW;
    }

    public void f(long j, long j2) {
        HO();
        HP();
        if (j < 1) {
            this.aWD.setVisibility(8);
        } else if (this.aOW != null) {
            this.aOW.aSV = j2;
            this.aOW.aSU = j;
            this.aWD.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            HQ();
            HH();
        }
    }

    private void HQ() {
        this.aWD.setVisibility(0);
        this.aWw.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOW.userId), this.aOW.userName, this.aOW.portrait, this.aOW.sex, this.aOW.aSS, this.aOW.location, this.aOW.description, 0L, this.aOW.fansCount, this.aOW.aST, this.aOW.userStatus, this.aOW.liveId, this.aOW.groupId, this.aOW.aSW, this.aOW.aSX, this.aOW.appId, this.aOW.userName, "")));
        }
    }

    public void onDestroy() {
        HN();
        if (this.aWz != null) {
            this.aWz.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aOW != null && this.aOW.aSV < this.aOW.aSU) {
            if (this.aOW.aSV <= 0) {
                this.aOW.aSV = 1L;
            }
            this.aWD.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aOW.aSV)));
            HQ();
            setDisplayStyle(this.aOW.aSV);
            HH();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aWF = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aWC != null && this.aWC.getVisibility() == 0) {
            int width = this.aWz.getWidth();
            int height = this.aWz.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aWC.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aWC.setLayoutParams(layoutParams);
        }
    }
}
