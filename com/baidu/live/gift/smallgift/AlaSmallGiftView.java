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
/* loaded from: classes10.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aZX;
    private c aZZ;
    private TextView bbs;
    private ObjectAnimator biD;
    private ObjectAnimator biE;
    private ObjectAnimator biF;
    private AnimatorSet biG;
    private ObjectAnimator biH;
    private ObjectAnimator biI;
    private ObjectAnimator biJ;
    private AnimatorSet biK;
    private ObjectAnimator biL;
    private ObjectAnimator biM;
    private RelativeLayout biN;
    private HeadImageView biO;
    private TextView biP;
    private TbImageView biQ;
    private LottieAnimationView biR;
    private AlaGiftStrokeTextView biS;
    private LottieAnimationView biT;
    private a biU;
    private int biV;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void GZ();

        void Ha();

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
        this.biN = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.biN.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.biO = (HeadImageView) findViewById(a.f.sender_avatar);
        this.biO.setIsRound(true);
        this.biO.setAutoChangeStyle(false);
        this.biO.setDefaultBgResource(a.e.sdk_default_avatar);
        this.biO.setOnClickListener(this);
        this.aZX = (TextView) findViewById(a.f.sender_name);
        this.aZX.setOnClickListener(this);
        this.bbs = (TextView) findViewById(a.f.gift_name);
        this.biP = (TextView) findViewById(a.f.giftNameTip);
        this.biQ = (TbImageView) findViewById(a.f.gift_icon);
        this.biQ.setAutoChangeStyle(false);
        this.biQ.setDefaultBgResource(a.c.sdk_transparent);
        this.biQ.setDefaultErrorResource(a.c.sdk_transparent);
        this.biQ.setGifIconSupport(false);
        this.biS = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.biR = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.biR.loop(true);
        this.biR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.biT = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.biT.loop(true);
        this.biS.getPaint().setFakeBoldText(true);
        Il();
    }

    public void setMode(boolean z) {
        this.biV = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void Il() {
        this.biE = ObjectAnimator.ofFloat(this.biO, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.biE.setDuration(350L);
        this.biE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.In();
                AlaSmallGiftView.this.Io();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biH = ObjectAnimator.ofFloat(this.biQ, "ScaleX", 0.1f, 1.0f);
        this.biI = ObjectAnimator.ofFloat(this.biQ, "ScaleY", 0.1f, 1.0f);
        this.biG = new AnimatorSet();
        this.biG.playTogether(this.biH, this.biI);
        this.biG.setInterpolator(new OvershootInterpolator(4.0f));
        this.biG.setDuration(400L);
        this.biG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.biU != null) {
                    AlaSmallGiftView.this.biU.GZ();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biJ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.biJ.setDuration(300L);
        this.biJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.It();
                AlaSmallGiftView.this.Iu();
                if (AlaSmallGiftView.this.biU != null) {
                    AlaSmallGiftView.this.biU.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biL = ObjectAnimator.ofFloat(this.biS, "ScaleX", 3.0f, 1.0f);
        this.biM = ObjectAnimator.ofFloat(this.biS, "ScaleY", 3.0f, 1.0f);
        this.biK = new AnimatorSet();
        this.biK.playTogether(this.biL, this.biM);
        this.biK.setDuration(240L);
        this.biK.setInterpolator(new OvershootInterpolator());
        this.biK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.biU != null) {
                    AlaSmallGiftView.this.biU.Ha();
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

    private void Im() {
        this.biO.setVisibility(0);
        this.biE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In() {
        this.biQ.setVisibility(0);
        this.biG.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (this.biR != null && this.biR.getVisibility() == 0) {
            this.biR.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.biR.cancelAnimation();
                    AlaSmallGiftView.this.biR.playAnimation();
                }
            });
        }
        if (this.biT != null && this.biT.getVisibility() == 0) {
            this.biT.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.biT.cancelAnimation();
                    AlaSmallGiftView.this.biT.playAnimation();
                }
            });
        }
    }

    private void Ip() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.biF = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.biF.setInterpolator(new OvershootInterpolator());
            this.biF.setDuration(300L);
            this.biF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.In();
                    AlaSmallGiftView.this.Io();
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

    private void Iq() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.biD = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.biD.setInterpolator(new OvershootInterpolator());
            this.biD.setDuration(300L);
        }
    }

    public void Ir() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Iu();
            if (this.biE != null) {
                this.biE.cancel();
            }
            this.biO.setVisibility(0);
            if (this.biF == null) {
                Ip();
            }
            this.biF.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Iu();
            if (this.biD == null) {
                Iq();
            }
            this.biD.start();
            Im();
        }
    }

    public void Is() {
        this.biJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void It() {
        this.biQ.setVisibility(8);
    }

    public void Iu() {
        setTranslationY(0.0f);
        if (this.biE != null) {
            this.biE.cancel();
        }
        if (this.biG != null) {
            this.biG.cancel();
        }
        if (this.biK != null) {
            this.biK.cancel();
        }
        if (this.biD != null) {
            this.biD.cancel();
        }
        if (this.biF != null) {
            this.biF.cancel();
        }
        if (this.biJ != null) {
            this.biJ.cancel();
        }
        if (this.biT != null) {
            this.biT.cancelAnimation();
        }
        if (this.biR != null) {
            this.biR.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bep != null) {
            this.aZZ = cVar;
            setGiftCnt(cVar.bew);
            gD(cVar.userName);
            this.bbs.setText(cVar.bep.DV());
            if (!TextUtils.isEmpty(cVar.beG)) {
                this.biP.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.biP.setText(cVar.beG);
            } else {
                this.biP.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha90));
                this.biP.setText(this.mContext.getString(a.h.gift_name_prefix));
            }
            Iv();
            Iw();
            if (z) {
                setDisplayStyle(cVar.bew);
            }
        }
    }

    private void Iv() {
        if (this.aZZ != null) {
            this.biO.setUrl(this.aZZ.portrait);
            m.a(this.biO, this.aZZ.portrait, false, !StringUtils.isNull(this.aZZ.appId));
        }
    }

    private void Iw() {
        if (this.aZZ != null && this.aZZ.bep != null) {
            this.biQ.setVisibility(0);
            this.biQ.startLoad(this.aZZ.bep.getThumbnail_url(), 10, false);
        }
    }

    private void gD(String str) {
        this.aZX.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aZX.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.biR.setVisibility(8);
            this.biT.setVisibility(8);
            this.biN.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.biS.setGravity(3);
        } else if (j <= 65) {
            this.biR.setVisibility(8);
            this.biT.setVisibility(8);
            this.biN.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.biS.setGravity(19);
        } else if (j <= 187) {
            this.biR.setVisibility(0);
            this.biR.setAnimation("66-1.json");
            this.biT.setVisibility(8);
            this.biN.setBackgroundResource(a.c.sdk_transparent);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.biR.setVisibility(0);
            this.biR.setAnimation("188-1.json");
            this.biT.setVisibility(0);
            this.biT.setAnimation("188-2.json");
            this.biN.setBackgroundResource(a.c.sdk_transparent);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.biR.setVisibility(0);
            this.biR.setAnimation("520-1.json");
            this.biT.setVisibility(0);
            this.biT.setAnimation("520-2.json");
            this.biN.setBackgroundResource(a.c.sdk_transparent);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.biR.setVisibility(0);
            this.biR.setAnimation("1314-1.json");
            this.biT.setVisibility(0);
            this.biT.setAnimation("1314-2.json");
            this.biN.setBackgroundResource(a.c.sdk_transparent);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.biR.setVisibility(0);
            this.biR.setAnimation("9999-1.json");
            this.biT.setVisibility(0);
            this.biT.setAnimation("9999-2.json");
            this.biN.setBackgroundResource(a.c.sdk_transparent);
            this.biS.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.biS.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.biS.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.biT.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.biS.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.biS.setLayoutParams(layoutParams);
            this.biS.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.biS.getLayoutParams();
            layoutParams2.width = -2;
            this.biS.setLayoutParams(layoutParams2);
            this.biS.setGravity(19);
        }
        this.biL.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biM.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biK.setDuration(840L);
        this.biK.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.biK.getChildAnimations();
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
                if (this.biV > 0) {
                    this.biN.setBackgroundResource(this.biV);
                } else {
                    this.biN.setBackgroundResource(a.e.gray_circle);
                }
                this.biS.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.biN.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.biS.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.biL.setFloatValues(3.0f, 1.0f);
                this.biM.setFloatValues(3.0f, 1.0f);
                this.biK.setDuration(240L);
                this.biK.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.biL.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biM.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biK.setDuration(480L);
                this.biK.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.biK.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.biS.setVisibility(8);
        } else {
            this.biS.setVisibility(0);
        }
        this.biS.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aZZ;
    }

    public void i(long j, long j2) {
        Iv();
        Iw();
        if (j < 1) {
            this.biS.setVisibility(8);
        } else if (this.aZZ != null) {
            this.aZZ.bew = j2;
            this.aZZ.bev = j;
            this.biS.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Ix();
            Io();
        }
    }

    private void Ix() {
        this.biS.setVisibility(0);
        this.biK.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aZZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aZZ.userId), this.aZZ.userName, this.aZZ.portrait, this.aZZ.sex, this.aZZ.ber, this.aZZ.location, this.aZZ.description, 0L, this.aZZ.fansCount, this.aZZ.followCount, this.aZZ.userStatus, this.aZZ.liveId, this.aZZ.groupId, this.aZZ.bey, this.aZZ.bez, this.aZZ.appId, this.aZZ.userName)));
        }
    }

    public void onDestroy() {
        Iu();
        if (this.biN != null) {
            this.biN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aZZ != null && this.aZZ.bew < this.aZZ.bev) {
            if (this.aZZ.bew <= 0) {
                this.aZZ.bew = 1L;
            }
            this.biS.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aZZ.bew)));
            Ix();
            setDisplayStyle(this.aZZ.bew);
            Io();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.biU = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.biR != null && this.biR.getVisibility() == 0) {
            int width = this.biN.getWidth();
            int height = this.biN.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.biR.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.biR.setLayoutParams(layoutParams);
        }
    }
}
