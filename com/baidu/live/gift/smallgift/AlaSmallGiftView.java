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
    private TextView aAs;
    private c aAu;
    private TextView aBB;
    private TbImageView aHA;
    private LottieAnimationView aHB;
    private AlaGiftStrokeTextView aHC;
    private LottieAnimationView aHD;
    private a aHE;
    private int aHF;
    private ObjectAnimator aHo;
    private ObjectAnimator aHp;
    private ObjectAnimator aHq;
    private AnimatorSet aHr;
    private ObjectAnimator aHs;
    private ObjectAnimator aHt;
    private ObjectAnimator aHu;
    private AnimatorSet aHv;
    private ObjectAnimator aHw;
    private ObjectAnimator aHx;
    private RelativeLayout aHy;
    private HeadImageView aHz;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void P(View view);

        void yE();

        void yF();
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
        this.aHy = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aHy.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aHz = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aHz.setIsRound(true);
        this.aHz.setAutoChangeStyle(false);
        this.aHz.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aHz.setOnClickListener(this);
        this.aAs = (TextView) findViewById(a.g.sender_name);
        this.aAs.setOnClickListener(this);
        this.aBB = (TextView) findViewById(a.g.gift_name);
        this.aHA = (TbImageView) findViewById(a.g.gift_icon);
        this.aHA.setAutoChangeStyle(false);
        this.aHA.setDefaultBgResource(a.d.sdk_transparent);
        this.aHA.setDefaultErrorResource(a.d.sdk_transparent);
        this.aHA.setGifIconSupport(false);
        this.aHC = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aHB = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aHB.loop(true);
        this.aHB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aHD = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aHD.loop(true);
        this.aHC.getPaint().setFakeBoldText(true);
        zK();
    }

    public void setMode(boolean z) {
        this.aHF = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void zK() {
        this.aHp = ObjectAnimator.ofFloat(this.aHz, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aHp.setDuration(350L);
        this.aHp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.zM();
                AlaSmallGiftView.this.zN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHs = ObjectAnimator.ofFloat(this.aHA, "ScaleX", 0.1f, 1.0f);
        this.aHt = ObjectAnimator.ofFloat(this.aHA, "ScaleY", 0.1f, 1.0f);
        this.aHr = new AnimatorSet();
        this.aHr.playTogether(this.aHs, this.aHt);
        this.aHr.setInterpolator(new OvershootInterpolator(4.0f));
        this.aHr.setDuration(400L);
        this.aHr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aHE != null) {
                    AlaSmallGiftView.this.aHE.yE();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHu = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aHu.setDuration(300L);
        this.aHu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.zS();
                AlaSmallGiftView.this.zT();
                if (AlaSmallGiftView.this.aHE != null) {
                    AlaSmallGiftView.this.aHE.P(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHw = ObjectAnimator.ofFloat(this.aHC, "ScaleX", 3.0f, 1.0f);
        this.aHx = ObjectAnimator.ofFloat(this.aHC, "ScaleY", 3.0f, 1.0f);
        this.aHv = new AnimatorSet();
        this.aHv.playTogether(this.aHw, this.aHx);
        this.aHv.setDuration(240L);
        this.aHv.setInterpolator(new OvershootInterpolator());
        this.aHv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aHE != null) {
                    AlaSmallGiftView.this.aHE.yF();
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

    private void zL() {
        this.aHz.setVisibility(0);
        this.aHp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM() {
        this.aHA.setVisibility(0);
        this.aHr.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN() {
        if (this.aHB != null && this.aHB.getVisibility() == 0) {
            this.aHB.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aHB.cancelAnimation();
                    AlaSmallGiftView.this.aHB.playAnimation();
                }
            });
        }
        if (this.aHD != null && this.aHD.getVisibility() == 0) {
            this.aHD.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aHD.cancelAnimation();
                    AlaSmallGiftView.this.aHD.playAnimation();
                }
            });
        }
    }

    private void zO() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aHq = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aHq.setInterpolator(new OvershootInterpolator());
            this.aHq.setDuration(300L);
            this.aHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.zM();
                    AlaSmallGiftView.this.zN();
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

    private void zP() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aHo = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aHo.setInterpolator(new OvershootInterpolator());
            this.aHo.setDuration(300L);
        }
    }

    public void zQ() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            zT();
            if (this.aHp != null) {
                this.aHp.cancel();
            }
            this.aHz.setVisibility(0);
            if (this.aHq == null) {
                zO();
            }
            this.aHq.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            zT();
            if (this.aHo == null) {
                zP();
            }
            this.aHo.start();
            zL();
        }
    }

    public void zR() {
        this.aHu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS() {
        this.aHA.setVisibility(8);
    }

    public void zT() {
        setTranslationY(0.0f);
        if (this.aHp != null) {
            this.aHp.cancel();
        }
        if (this.aHr != null) {
            this.aHr.cancel();
        }
        if (this.aHv != null) {
            this.aHv.cancel();
        }
        if (this.aHo != null) {
            this.aHo.cancel();
        }
        if (this.aHq != null) {
            this.aHq.cancel();
        }
        if (this.aHu != null) {
            this.aHu.cancel();
        }
        if (this.aHD != null) {
            this.aHD.cancelAnimation();
        }
        if (this.aHB != null) {
            this.aHB.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aDX != null) {
            this.aAu = cVar;
            setGiftCnt(cVar.aEc);
            ek(cVar.userName);
            this.aBB.setText(cVar.aDX.vW());
            zU();
            zV();
            if (z) {
                setDisplayStyle(cVar.aEc);
            }
        }
    }

    private void zU() {
        if (this.aAu != null) {
            this.aHz.setUrl(this.aAu.portrait);
            k.a(this.aHz, this.aAu.portrait, false, !StringUtils.isNull(this.aAu.appId));
        }
    }

    private void zV() {
        if (this.aAu != null && this.aAu.aDX != null) {
            this.aHA.setVisibility(0);
            this.aHA.startLoad(this.aAu.aDX.vY(), 10, false);
        }
    }

    private void ek(String str) {
        this.aAs.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aAs.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aHB.setVisibility(8);
            this.aHD.setVisibility(8);
            this.aHy.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aHC.setGravity(3);
        } else if (j <= 65) {
            this.aHB.setVisibility(8);
            this.aHD.setVisibility(8);
            this.aHy.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aHC.setGravity(19);
        } else if (j <= 187) {
            this.aHB.setVisibility(0);
            this.aHB.setAnimation("66-1.json");
            this.aHD.setVisibility(8);
            this.aHy.setBackgroundResource(a.d.sdk_transparent);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aHB.setVisibility(0);
            this.aHB.setAnimation("188-1.json");
            this.aHD.setVisibility(0);
            this.aHD.setAnimation("188-2.json");
            this.aHy.setBackgroundResource(a.d.sdk_transparent);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aHB.setVisibility(0);
            this.aHB.setAnimation("520-1.json");
            this.aHD.setVisibility(0);
            this.aHD.setAnimation("520-2.json");
            this.aHy.setBackgroundResource(a.d.sdk_transparent);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aHB.setVisibility(0);
            this.aHB.setAnimation("1314-1.json");
            this.aHD.setVisibility(0);
            this.aHD.setAnimation("1314-2.json");
            this.aHy.setBackgroundResource(a.d.sdk_transparent);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aHB.setVisibility(0);
            this.aHB.setAnimation("9999-1.json");
            this.aHD.setVisibility(0);
            this.aHD.setAnimation("9999-2.json");
            this.aHy.setBackgroundResource(a.d.sdk_transparent);
            this.aHC.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aHC.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aHC.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aHD.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHC.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aHC.setLayoutParams(layoutParams);
            this.aHC.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aHC.getLayoutParams();
            layoutParams2.width = -2;
            this.aHC.setLayoutParams(layoutParams2);
            this.aHC.setGravity(19);
        }
        this.aHw.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aHx.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aHv.setDuration(840L);
        this.aHv.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aHv.getChildAnimations();
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
                if (this.aHF > 0) {
                    this.aHy.setBackgroundResource(this.aHF);
                } else {
                    this.aHy.setBackgroundResource(a.f.gray_circle);
                }
                this.aHC.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aHy.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aHC.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aHw.setFloatValues(3.0f, 1.0f);
                this.aHx.setFloatValues(3.0f, 1.0f);
                this.aHv.setDuration(240L);
                this.aHv.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aHw.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aHx.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aHv.setDuration(480L);
                this.aHv.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aHv.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aHC.setVisibility(8);
        } else {
            this.aHC.setVisibility(0);
        }
        this.aHC.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aAu;
    }

    public void e(long j, long j2) {
        zU();
        zV();
        if (j < 1) {
            this.aHC.setVisibility(8);
        } else if (this.aAu != null) {
            this.aAu.aEc = j2;
            this.aAu.aEb = j;
            this.aHC.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            zW();
            zN();
        }
    }

    private void zW() {
        this.aHC.setVisibility(0);
        this.aHv.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAu.userId), this.aAu.userName, this.aAu.portrait, this.aAu.sex, this.aAu.aDZ, this.aAu.location, this.aAu.description, 0L, this.aAu.fansCount, this.aAu.aEa, this.aAu.userStatus, this.aAu.liveId, this.aAu.groupId, this.aAu.aEd, this.aAu.aEe, this.aAu.appId, this.aAu.userName, "")));
        }
    }

    public void onDestroy() {
        zT();
        if (this.aHy != null) {
            this.aHy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aAu != null && this.aAu.aEc < this.aAu.aEb) {
            if (this.aAu.aEc <= 0) {
                this.aAu.aEc = 1L;
            }
            this.aHC.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aAu.aEc)));
            zW();
            setDisplayStyle(this.aAu.aEc);
            zN();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aHE = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aHB != null && this.aHB.getVisibility() == 0) {
            int width = this.aHy.getWidth();
            int height = this.aHy.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHB.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aHB.setLayoutParams(layoutParams);
        }
    }
}
