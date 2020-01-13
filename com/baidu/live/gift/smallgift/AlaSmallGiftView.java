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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView afG;
    private c afI;
    private TextView agP;
    private ObjectAnimator amA;
    private ObjectAnimator amB;
    private ObjectAnimator amC;
    private AnimatorSet amD;
    private ObjectAnimator amE;
    private ObjectAnimator amF;
    private RelativeLayout amG;
    private HeadImageView amH;
    private TbImageView amI;
    private LottieAnimationView amJ;
    private AlaGiftStrokeTextView amK;
    private LottieAnimationView amL;
    private a amM;
    private int amN;
    private ObjectAnimator amw;
    private ObjectAnimator amx;
    private ObjectAnimator amy;
    private AnimatorSet amz;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void N(View view);

        void sT();

        void sU();
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
        this.amG = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.amG.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.amH = (HeadImageView) findViewById(a.g.sender_avatar);
        this.amH.setIsRound(true);
        this.amH.setAutoChangeStyle(false);
        this.amH.setDefaultBgResource(a.f.sdk_default_avatar);
        this.amH.setOnClickListener(this);
        this.afG = (TextView) findViewById(a.g.sender_name);
        this.afG.setOnClickListener(this);
        this.agP = (TextView) findViewById(a.g.gift_name);
        this.amI = (TbImageView) findViewById(a.g.gift_icon);
        this.amI.setAutoChangeStyle(false);
        this.amI.setDefaultBgResource(a.d.sdk_transparent);
        this.amI.setDefaultErrorResource(a.d.sdk_transparent);
        this.amI.setGifIconSupport(false);
        this.amK = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.amJ = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.amJ.loop(true);
        this.amJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.amL = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.amL.loop(true);
        this.amK.getPaint().setFakeBoldText(true);
        tQ();
    }

    public void setMode(boolean z) {
        this.amN = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void tQ() {
        this.amx = ObjectAnimator.ofFloat(this.amH, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.amx.setDuration(350L);
        this.amx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.tS();
                AlaSmallGiftView.this.tT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.amA = ObjectAnimator.ofFloat(this.amI, "ScaleX", 0.1f, 1.0f);
        this.amB = ObjectAnimator.ofFloat(this.amI, "ScaleY", 0.1f, 1.0f);
        this.amz = new AnimatorSet();
        this.amz.playTogether(this.amA, this.amB);
        this.amz.setInterpolator(new OvershootInterpolator(4.0f));
        this.amz.setDuration(400L);
        this.amz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.amM != null) {
                    AlaSmallGiftView.this.amM.sT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.amC = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.amC.setDuration(300L);
        this.amC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.tY();
                AlaSmallGiftView.this.tZ();
                if (AlaSmallGiftView.this.amM != null) {
                    AlaSmallGiftView.this.amM.N(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.amE = ObjectAnimator.ofFloat(this.amK, "ScaleX", 3.0f, 1.0f);
        this.amF = ObjectAnimator.ofFloat(this.amK, "ScaleY", 3.0f, 1.0f);
        this.amD = new AnimatorSet();
        this.amD.playTogether(this.amE, this.amF);
        this.amD.setDuration(240L);
        this.amD.setInterpolator(new OvershootInterpolator());
        this.amD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.amM != null) {
                    AlaSmallGiftView.this.amM.sU();
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

    private void tR() {
        this.amH.setVisibility(0);
        this.amx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS() {
        this.amI.setVisibility(0);
        this.amz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tT() {
        if (this.amJ != null && this.amJ.getVisibility() == 0) {
            this.amJ.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.amJ.cancelAnimation();
                    AlaSmallGiftView.this.amJ.playAnimation();
                }
            });
        }
        if (this.amL != null && this.amL.getVisibility() == 0) {
            this.amL.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.amL.cancelAnimation();
                    AlaSmallGiftView.this.amL.playAnimation();
                }
            });
        }
    }

    private void tU() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.amy = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.amy.setInterpolator(new OvershootInterpolator());
            this.amy.setDuration(300L);
            this.amy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.tS();
                    AlaSmallGiftView.this.tT();
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

    private void tV() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.amw = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.amw.setInterpolator(new OvershootInterpolator());
            this.amw.setDuration(300L);
        }
    }

    public void tW() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            tZ();
            if (this.amx != null) {
                this.amx.cancel();
            }
            this.amH.setVisibility(0);
            if (this.amy == null) {
                tU();
            }
            this.amy.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            tZ();
            if (this.amw == null) {
                tV();
            }
            this.amw.start();
            tR();
        }
    }

    public void tX() {
        this.amC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY() {
        this.amI.setVisibility(8);
    }

    public void tZ() {
        setTranslationY(0.0f);
        if (this.amx != null) {
            this.amx.cancel();
        }
        if (this.amz != null) {
            this.amz.cancel();
        }
        if (this.amD != null) {
            this.amD.cancel();
        }
        if (this.amw != null) {
            this.amw.cancel();
        }
        if (this.amy != null) {
            this.amy.cancel();
        }
        if (this.amC != null) {
            this.amC.cancel();
        }
        if (this.amL != null) {
            this.amL.cancelAnimation();
        }
        if (this.amJ != null) {
            this.amJ.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.ajo != null) {
            this.afI = cVar;
            setGiftCnt(cVar.ajt);
            dj(cVar.userName);
            this.agP.setText(cVar.ajo.qF());
            ua();
            ub();
            if (z) {
                setDisplayStyle(cVar.ajt);
            }
        }
    }

    private void ua() {
        if (this.afI != null) {
            this.amH.setUrl(this.afI.portrait);
            k.a(this.amH, this.afI.portrait, false, !StringUtils.isNull(this.afI.appId));
        }
    }

    private void ub() {
        if (this.afI != null && this.afI.ajo != null) {
            this.amI.setVisibility(0);
            this.amI.startLoad(this.afI.ajo.qH(), 10, false);
        }
    }

    private void dj(String str) {
        this.afG.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.afG.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.amJ.setVisibility(8);
            this.amL.setVisibility(8);
            this.amG.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.amK.setGravity(3);
        } else if (j <= 65) {
            this.amJ.setVisibility(8);
            this.amL.setVisibility(8);
            this.amG.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.amK.setGravity(19);
        } else if (j <= 187) {
            this.amJ.setVisibility(0);
            this.amJ.setAnimation("66-1.json");
            this.amL.setVisibility(8);
            this.amG.setBackgroundResource(a.d.sdk_transparent);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.amJ.setVisibility(0);
            this.amJ.setAnimation("188-1.json");
            this.amL.setVisibility(0);
            this.amL.setAnimation("188-2.json");
            this.amG.setBackgroundResource(a.d.sdk_transparent);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.amJ.setVisibility(0);
            this.amJ.setAnimation("520-1.json");
            this.amL.setVisibility(0);
            this.amL.setAnimation("520-2.json");
            this.amG.setBackgroundResource(a.d.sdk_transparent);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.amJ.setVisibility(0);
            this.amJ.setAnimation("1314-1.json");
            this.amL.setVisibility(0);
            this.amL.setAnimation("1314-2.json");
            this.amG.setBackgroundResource(a.d.sdk_transparent);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.amJ.setVisibility(0);
            this.amJ.setAnimation("9999-1.json");
            this.amL.setVisibility(0);
            this.amL.setAnimation("9999-2.json");
            this.amG.setBackgroundResource(a.d.sdk_transparent);
            this.amK.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.amK.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.amK.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.amL.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amK.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
            this.amK.setLayoutParams(layoutParams);
            this.amK.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.amK.getLayoutParams();
            layoutParams2.width = -2;
            this.amK.setLayoutParams(layoutParams2);
            this.amK.setGravity(19);
        }
        this.amE.setFloatValues(1.0f, 1.5f, 1.0f);
        this.amF.setFloatValues(1.0f, 1.5f, 1.0f);
        this.amD.setDuration(840L);
        this.amD.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.amD.getChildAnimations();
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
                if (this.amN > 0) {
                    this.amG.setBackgroundResource(this.amN);
                } else {
                    this.amG.setBackgroundResource(a.f.gray_circle);
                }
                this.amK.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.amG.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.amK.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.amE.setFloatValues(3.0f, 1.0f);
                this.amF.setFloatValues(3.0f, 1.0f);
                this.amD.setDuration(240L);
                this.amD.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.amE.setFloatValues(1.0f, 1.5f, 1.0f);
                this.amF.setFloatValues(1.0f, 1.5f, 1.0f);
                this.amD.setDuration(480L);
                this.amD.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.amD.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.amK.setVisibility(8);
        } else {
            this.amK.setVisibility(0);
        }
        this.amK.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.afI;
    }

    public void e(long j, long j2) {
        ua();
        ub();
        if (j < 1) {
            this.amK.setVisibility(8);
        } else if (this.afI != null) {
            this.afI.ajt = j2;
            this.afI.ajs = j;
            this.amK.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            uc();
            tT();
        }
    }

    private void uc() {
        this.amK.setVisibility(0);
        this.amD.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.afI.userId), this.afI.userName, this.afI.portrait, this.afI.sex, this.afI.ajq, this.afI.location, this.afI.description, 0L, this.afI.fansCount, this.afI.ajr, this.afI.userStatus, this.afI.liveId, this.afI.groupId, this.afI.aju, this.afI.ajv, this.afI.appId, this.afI.userName, "")));
        }
    }

    public void onDestroy() {
        tZ();
        if (this.amG != null) {
            this.amG.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.afI != null && this.afI.ajt < this.afI.ajs) {
            if (this.afI.ajt <= 0) {
                this.afI.ajt = 1L;
            }
            this.amK.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.afI.ajt)));
            uc();
            setDisplayStyle(this.afI.ajt);
            tT();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.amM = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.amJ != null && this.amJ.getVisibility() == 0) {
            int width = this.amG.getWidth();
            int height = this.amG.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amJ.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.amJ.setLayoutParams(layoutParams);
        }
    }
}
