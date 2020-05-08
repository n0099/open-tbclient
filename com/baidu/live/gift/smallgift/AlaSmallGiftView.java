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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private c aAA;
    private TextView aAy;
    private TextView aBH;
    private ObjectAnimator aHA;
    private AnimatorSet aHB;
    private ObjectAnimator aHC;
    private ObjectAnimator aHD;
    private RelativeLayout aHE;
    private HeadImageView aHF;
    private TbImageView aHG;
    private LottieAnimationView aHH;
    private AlaGiftStrokeTextView aHI;
    private LottieAnimationView aHJ;
    private a aHK;
    private int aHL;
    private ObjectAnimator aHu;
    private ObjectAnimator aHv;
    private ObjectAnimator aHw;
    private AnimatorSet aHx;
    private ObjectAnimator aHy;
    private ObjectAnimator aHz;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void P(View view);

        void yD();

        void yE();
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
        this.aHE = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aHE.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aHF = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aHF.setIsRound(true);
        this.aHF.setAutoChangeStyle(false);
        this.aHF.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aHF.setOnClickListener(this);
        this.aAy = (TextView) findViewById(a.g.sender_name);
        this.aAy.setOnClickListener(this);
        this.aBH = (TextView) findViewById(a.g.gift_name);
        this.aHG = (TbImageView) findViewById(a.g.gift_icon);
        this.aHG.setAutoChangeStyle(false);
        this.aHG.setDefaultBgResource(a.d.sdk_transparent);
        this.aHG.setDefaultErrorResource(a.d.sdk_transparent);
        this.aHG.setGifIconSupport(false);
        this.aHI = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aHH = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aHH.loop(true);
        this.aHH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aHJ = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aHJ.loop(true);
        this.aHI.getPaint().setFakeBoldText(true);
        zJ();
    }

    public void setMode(boolean z) {
        this.aHL = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void zJ() {
        this.aHv = ObjectAnimator.ofFloat(this.aHF, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aHv.setDuration(350L);
        this.aHv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.zL();
                AlaSmallGiftView.this.zM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHy = ObjectAnimator.ofFloat(this.aHG, "ScaleX", 0.1f, 1.0f);
        this.aHz = ObjectAnimator.ofFloat(this.aHG, "ScaleY", 0.1f, 1.0f);
        this.aHx = new AnimatorSet();
        this.aHx.playTogether(this.aHy, this.aHz);
        this.aHx.setInterpolator(new OvershootInterpolator(4.0f));
        this.aHx.setDuration(400L);
        this.aHx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aHK != null) {
                    AlaSmallGiftView.this.aHK.yD();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHA = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aHA.setDuration(300L);
        this.aHA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.zR();
                AlaSmallGiftView.this.zS();
                if (AlaSmallGiftView.this.aHK != null) {
                    AlaSmallGiftView.this.aHK.P(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHC = ObjectAnimator.ofFloat(this.aHI, "ScaleX", 3.0f, 1.0f);
        this.aHD = ObjectAnimator.ofFloat(this.aHI, "ScaleY", 3.0f, 1.0f);
        this.aHB = new AnimatorSet();
        this.aHB.playTogether(this.aHC, this.aHD);
        this.aHB.setDuration(240L);
        this.aHB.setInterpolator(new OvershootInterpolator());
        this.aHB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aHK != null) {
                    AlaSmallGiftView.this.aHK.yE();
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

    private void zK() {
        this.aHF.setVisibility(0);
        this.aHv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL() {
        this.aHG.setVisibility(0);
        this.aHx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM() {
        if (this.aHH != null && this.aHH.getVisibility() == 0) {
            this.aHH.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aHH.cancelAnimation();
                    AlaSmallGiftView.this.aHH.playAnimation();
                }
            });
        }
        if (this.aHJ != null && this.aHJ.getVisibility() == 0) {
            this.aHJ.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aHJ.cancelAnimation();
                    AlaSmallGiftView.this.aHJ.playAnimation();
                }
            });
        }
    }

    private void zN() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aHw = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aHw.setInterpolator(new OvershootInterpolator());
            this.aHw.setDuration(300L);
            this.aHw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.zL();
                    AlaSmallGiftView.this.zM();
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

    private void zO() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aHu = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aHu.setInterpolator(new OvershootInterpolator());
            this.aHu.setDuration(300L);
        }
    }

    public void zP() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            zS();
            if (this.aHv != null) {
                this.aHv.cancel();
            }
            this.aHF.setVisibility(0);
            if (this.aHw == null) {
                zN();
            }
            this.aHw.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            zS();
            if (this.aHu == null) {
                zO();
            }
            this.aHu.start();
            zK();
        }
    }

    public void zQ() {
        this.aHA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR() {
        this.aHG.setVisibility(8);
    }

    public void zS() {
        setTranslationY(0.0f);
        if (this.aHv != null) {
            this.aHv.cancel();
        }
        if (this.aHx != null) {
            this.aHx.cancel();
        }
        if (this.aHB != null) {
            this.aHB.cancel();
        }
        if (this.aHu != null) {
            this.aHu.cancel();
        }
        if (this.aHw != null) {
            this.aHw.cancel();
        }
        if (this.aHA != null) {
            this.aHA.cancel();
        }
        if (this.aHJ != null) {
            this.aHJ.cancelAnimation();
        }
        if (this.aHH != null) {
            this.aHH.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aEd != null) {
            this.aAA = cVar;
            setGiftCnt(cVar.aEi);
            ek(cVar.userName);
            this.aBH.setText(cVar.aEd.vV());
            zT();
            zU();
            if (z) {
                setDisplayStyle(cVar.aEi);
            }
        }
    }

    private void zT() {
        if (this.aAA != null) {
            this.aHF.setUrl(this.aAA.portrait);
            k.a(this.aHF, this.aAA.portrait, false, !StringUtils.isNull(this.aAA.appId));
        }
    }

    private void zU() {
        if (this.aAA != null && this.aAA.aEd != null) {
            this.aHG.setVisibility(0);
            this.aHG.startLoad(this.aAA.aEd.vX(), 10, false);
        }
    }

    private void ek(String str) {
        this.aAy.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aAy.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aHH.setVisibility(8);
            this.aHJ.setVisibility(8);
            this.aHE.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aHI.setGravity(3);
        } else if (j <= 65) {
            this.aHH.setVisibility(8);
            this.aHJ.setVisibility(8);
            this.aHE.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aHI.setGravity(19);
        } else if (j <= 187) {
            this.aHH.setVisibility(0);
            this.aHH.setAnimation("66-1.json");
            this.aHJ.setVisibility(8);
            this.aHE.setBackgroundResource(a.d.sdk_transparent);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aHH.setVisibility(0);
            this.aHH.setAnimation("188-1.json");
            this.aHJ.setVisibility(0);
            this.aHJ.setAnimation("188-2.json");
            this.aHE.setBackgroundResource(a.d.sdk_transparent);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aHH.setVisibility(0);
            this.aHH.setAnimation("520-1.json");
            this.aHJ.setVisibility(0);
            this.aHJ.setAnimation("520-2.json");
            this.aHE.setBackgroundResource(a.d.sdk_transparent);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aHH.setVisibility(0);
            this.aHH.setAnimation("1314-1.json");
            this.aHJ.setVisibility(0);
            this.aHJ.setAnimation("1314-2.json");
            this.aHE.setBackgroundResource(a.d.sdk_transparent);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aHH.setVisibility(0);
            this.aHH.setAnimation("9999-1.json");
            this.aHJ.setVisibility(0);
            this.aHJ.setAnimation("9999-2.json");
            this.aHE.setBackgroundResource(a.d.sdk_transparent);
            this.aHI.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aHI.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHI.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aHJ.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHI.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aHI.setLayoutParams(layoutParams);
            this.aHI.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aHI.getLayoutParams();
            layoutParams2.width = -2;
            this.aHI.setLayoutParams(layoutParams2);
            this.aHI.setGravity(19);
        }
        this.aHC.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aHD.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aHB.setDuration(840L);
        this.aHB.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aHB.getChildAnimations();
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
                if (this.aHL > 0) {
                    this.aHE.setBackgroundResource(this.aHL);
                } else {
                    this.aHE.setBackgroundResource(a.f.gray_circle);
                }
                this.aHI.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aHE.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aHI.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aHC.setFloatValues(3.0f, 1.0f);
                this.aHD.setFloatValues(3.0f, 1.0f);
                this.aHB.setDuration(240L);
                this.aHB.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aHC.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aHD.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aHB.setDuration(480L);
                this.aHB.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aHB.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aHI.setVisibility(8);
        } else {
            this.aHI.setVisibility(0);
        }
        this.aHI.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aAA;
    }

    public void e(long j, long j2) {
        zT();
        zU();
        if (j < 1) {
            this.aHI.setVisibility(8);
        } else if (this.aAA != null) {
            this.aAA.aEi = j2;
            this.aAA.aEh = j;
            this.aHI.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            zV();
            zM();
        }
    }

    private void zV() {
        this.aHI.setVisibility(0);
        this.aHB.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAA.userId), this.aAA.userName, this.aAA.portrait, this.aAA.sex, this.aAA.aEf, this.aAA.location, this.aAA.description, 0L, this.aAA.fansCount, this.aAA.aEg, this.aAA.userStatus, this.aAA.liveId, this.aAA.groupId, this.aAA.aEj, this.aAA.aEk, this.aAA.appId, this.aAA.userName, "")));
        }
    }

    public void onDestroy() {
        zS();
        if (this.aHE != null) {
            this.aHE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aAA != null && this.aAA.aEi < this.aAA.aEh) {
            if (this.aAA.aEi <= 0) {
                this.aAA.aEi = 1L;
            }
            this.aHI.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aAA.aEi)));
            zV();
            setDisplayStyle(this.aAA.aEi);
            zM();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aHK = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aHH != null && this.aHH.getVisibility() == 0) {
            int width = this.aHE.getWidth();
            int height = this.aHE.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHH.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aHH.setLayoutParams(layoutParams);
        }
    }
}
