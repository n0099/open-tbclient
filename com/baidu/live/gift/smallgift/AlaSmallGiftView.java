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
import com.baidu.live.utils.l;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aVE;
    private c aVG;
    private TextView aWV;
    private AnimatorSet bdA;
    private ObjectAnimator bdB;
    private ObjectAnimator bdC;
    private RelativeLayout bdD;
    private HeadImageView bdE;
    private TbImageView bdF;
    private LottieAnimationView bdG;
    private AlaGiftStrokeTextView bdH;
    private LottieAnimationView bdI;
    private a bdJ;
    private int bdK;
    private ObjectAnimator bdt;
    private ObjectAnimator bdu;
    private ObjectAnimator bdv;
    private AnimatorSet bdw;
    private ObjectAnimator bdx;
    private ObjectAnimator bdy;
    private ObjectAnimator bdz;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Iq();

        void Ir();

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
        LayoutInflater.from(getContext()).inflate(a.h.popup_gift_layout, this);
        this.bdD = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.bdD.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bdE = (HeadImageView) findViewById(a.g.sender_avatar);
        this.bdE.setIsRound(true);
        this.bdE.setAutoChangeStyle(false);
        this.bdE.setDefaultBgResource(a.f.sdk_default_avatar);
        this.bdE.setOnClickListener(this);
        this.aVE = (TextView) findViewById(a.g.sender_name);
        this.aVE.setOnClickListener(this);
        this.aWV = (TextView) findViewById(a.g.gift_name);
        this.bdF = (TbImageView) findViewById(a.g.gift_icon);
        this.bdF.setAutoChangeStyle(false);
        this.bdF.setDefaultBgResource(a.d.sdk_transparent);
        this.bdF.setDefaultErrorResource(a.d.sdk_transparent);
        this.bdF.setGifIconSupport(false);
        this.bdH = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.bdG = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.bdG.loop(true);
        this.bdG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bdI = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.bdI.loop(true);
        this.bdH.getPaint().setFakeBoldText(true);
        Jw();
    }

    public void setMode(boolean z) {
        this.bdK = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void Jw() {
        this.bdu = ObjectAnimator.ofFloat(this.bdE, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bdu.setDuration(350L);
        this.bdu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Jy();
                AlaSmallGiftView.this.Jz();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdx = ObjectAnimator.ofFloat(this.bdF, "ScaleX", 0.1f, 1.0f);
        this.bdy = ObjectAnimator.ofFloat(this.bdF, "ScaleY", 0.1f, 1.0f);
        this.bdw = new AnimatorSet();
        this.bdw.playTogether(this.bdx, this.bdy);
        this.bdw.setInterpolator(new OvershootInterpolator(4.0f));
        this.bdw.setDuration(400L);
        this.bdw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bdJ != null) {
                    AlaSmallGiftView.this.bdJ.Iq();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdz = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bdz.setDuration(300L);
        this.bdz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.JE();
                AlaSmallGiftView.this.JF();
                if (AlaSmallGiftView.this.bdJ != null) {
                    AlaSmallGiftView.this.bdJ.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdB = ObjectAnimator.ofFloat(this.bdH, "ScaleX", 3.0f, 1.0f);
        this.bdC = ObjectAnimator.ofFloat(this.bdH, "ScaleY", 3.0f, 1.0f);
        this.bdA = new AnimatorSet();
        this.bdA.playTogether(this.bdB, this.bdC);
        this.bdA.setDuration(240L);
        this.bdA.setInterpolator(new OvershootInterpolator());
        this.bdA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bdJ != null) {
                    AlaSmallGiftView.this.bdJ.Ir();
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

    private void Jx() {
        this.bdE.setVisibility(0);
        this.bdu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        this.bdF.setVisibility(0);
        this.bdw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jz() {
        if (this.bdG != null && this.bdG.getVisibility() == 0) {
            this.bdG.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bdG.cancelAnimation();
                    AlaSmallGiftView.this.bdG.playAnimation();
                }
            });
        }
        if (this.bdI != null && this.bdI.getVisibility() == 0) {
            this.bdI.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bdI.cancelAnimation();
                    AlaSmallGiftView.this.bdI.playAnimation();
                }
            });
        }
    }

    private void JA() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdv = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bdv.setInterpolator(new OvershootInterpolator());
            this.bdv.setDuration(300L);
            this.bdv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Jy();
                    AlaSmallGiftView.this.Jz();
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

    private void JB() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdt = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bdt.setInterpolator(new OvershootInterpolator());
            this.bdt.setDuration(300L);
        }
    }

    public void JC() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            JF();
            if (this.bdu != null) {
                this.bdu.cancel();
            }
            this.bdE.setVisibility(0);
            if (this.bdv == null) {
                JA();
            }
            this.bdv.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            JF();
            if (this.bdt == null) {
                JB();
            }
            this.bdt.start();
            Jx();
        }
    }

    public void JD() {
        this.bdz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        this.bdF.setVisibility(8);
    }

    public void JF() {
        setTranslationY(0.0f);
        if (this.bdu != null) {
            this.bdu.cancel();
        }
        if (this.bdw != null) {
            this.bdw.cancel();
        }
        if (this.bdA != null) {
            this.bdA.cancel();
        }
        if (this.bdt != null) {
            this.bdt.cancel();
        }
        if (this.bdv != null) {
            this.bdv.cancel();
        }
        if (this.bdz != null) {
            this.bdz.cancel();
        }
        if (this.bdI != null) {
            this.bdI.cancelAnimation();
        }
        if (this.bdG != null) {
            this.bdG.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aZJ != null) {
            this.aVG = cVar;
            setGiftCnt(cVar.aZQ);
            he(cVar.userName);
            this.aWV.setText(cVar.aZJ.Ft());
            JG();
            JH();
            if (z) {
                setDisplayStyle(cVar.aZQ);
            }
        }
    }

    private void JG() {
        if (this.aVG != null) {
            this.bdE.setUrl(this.aVG.portrait);
            l.a(this.bdE, this.aVG.portrait, false, !StringUtils.isNull(this.aVG.appId));
        }
    }

    private void JH() {
        if (this.aVG != null && this.aVG.aZJ != null) {
            this.bdF.setVisibility(0);
            this.bdF.startLoad(this.aVG.aZJ.getThumbnail_url(), 10, false);
        }
    }

    private void he(String str) {
        this.aVE.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aVE.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bdG.setVisibility(8);
            this.bdI.setVisibility(8);
            this.bdD.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.bdH.setGravity(3);
        } else if (j <= 65) {
            this.bdG.setVisibility(8);
            this.bdI.setVisibility(8);
            this.bdD.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.bdH.setGravity(19);
        } else if (j <= 187) {
            this.bdG.setVisibility(0);
            this.bdG.setAnimation("66-1.json");
            this.bdI.setVisibility(8);
            this.bdD.setBackgroundResource(a.d.sdk_transparent);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bdG.setVisibility(0);
            this.bdG.setAnimation("188-1.json");
            this.bdI.setVisibility(0);
            this.bdI.setAnimation("188-2.json");
            this.bdD.setBackgroundResource(a.d.sdk_transparent);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bdG.setVisibility(0);
            this.bdG.setAnimation("520-1.json");
            this.bdI.setVisibility(0);
            this.bdI.setAnimation("520-2.json");
            this.bdD.setBackgroundResource(a.d.sdk_transparent);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bdG.setVisibility(0);
            this.bdG.setAnimation("1314-1.json");
            this.bdI.setVisibility(0);
            this.bdI.setAnimation("1314-2.json");
            this.bdD.setBackgroundResource(a.d.sdk_transparent);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.bdG.setVisibility(0);
            this.bdG.setAnimation("9999-1.json");
            this.bdI.setVisibility(0);
            this.bdI.setAnimation("9999-2.json");
            this.bdD.setBackgroundResource(a.d.sdk_transparent);
            this.bdH.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.bdH.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bdH.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.bdI.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdH.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.bdH.setLayoutParams(layoutParams);
            this.bdH.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bdH.getLayoutParams();
            layoutParams2.width = -2;
            this.bdH.setLayoutParams(layoutParams2);
            this.bdH.setGravity(19);
        }
        this.bdB.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bdC.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bdA.setDuration(840L);
        this.bdA.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bdA.getChildAnimations();
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
                if (this.bdK > 0) {
                    this.bdD.setBackgroundResource(this.bdK);
                } else {
                    this.bdD.setBackgroundResource(a.f.gray_circle);
                }
                this.bdH.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.bdD.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bdH.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bdB.setFloatValues(3.0f, 1.0f);
                this.bdC.setFloatValues(3.0f, 1.0f);
                this.bdA.setDuration(240L);
                this.bdA.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bdB.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bdC.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bdA.setDuration(480L);
                this.bdA.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bdA.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bdH.setVisibility(8);
        } else {
            this.bdH.setVisibility(0);
        }
        this.bdH.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aVG;
    }

    public void f(long j, long j2) {
        JG();
        JH();
        if (j < 1) {
            this.bdH.setVisibility(8);
        } else if (this.aVG != null) {
            this.aVG.aZQ = j2;
            this.aVG.aZP = j;
            this.bdH.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            JI();
            Jz();
        }
    }

    private void JI() {
        this.bdH.setVisibility(0);
        this.bdA.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVG.userId), this.aVG.userName, this.aVG.portrait, this.aVG.sex, this.aVG.aZL, this.aVG.location, this.aVG.description, 0L, this.aVG.fansCount, this.aVG.aZM, this.aVG.userStatus, this.aVG.liveId, this.aVG.groupId, this.aVG.aZR, this.aVG.aZS, this.aVG.appId, this.aVG.userName, "")));
        }
    }

    public void onDestroy() {
        JF();
        if (this.bdD != null) {
            this.bdD.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aVG != null && this.aVG.aZQ < this.aVG.aZP) {
            if (this.aVG.aZQ <= 0) {
                this.aVG.aZQ = 1L;
            }
            this.bdH.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aVG.aZQ)));
            JI();
            setDisplayStyle(this.aVG.aZQ);
            Jz();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bdJ = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bdG != null && this.bdG.getVisibility() == 0) {
            int width = this.bdD.getWidth();
            int height = this.bdD.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdG.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bdG.setLayoutParams(layoutParams);
        }
    }
}
