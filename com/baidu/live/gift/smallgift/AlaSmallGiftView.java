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
    private TextView aWW;
    private c aWY;
    private TextView aYn;
    private ObjectAnimator beO;
    private ObjectAnimator beP;
    private ObjectAnimator beQ;
    private AnimatorSet beR;
    private ObjectAnimator beS;
    private ObjectAnimator beT;
    private ObjectAnimator beU;
    private AnimatorSet beV;
    private ObjectAnimator beW;
    private ObjectAnimator beX;
    private RelativeLayout beY;
    private HeadImageView beZ;
    private TbImageView bfa;
    private LottieAnimationView bfc;
    private AlaGiftStrokeTextView bfd;
    private LottieAnimationView bfe;
    private a bff;
    private int bfg;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void IR();

        void IS();

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
        this.beY = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.beY.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.beZ = (HeadImageView) findViewById(a.f.sender_avatar);
        this.beZ.setIsRound(true);
        this.beZ.setAutoChangeStyle(false);
        this.beZ.setDefaultBgResource(a.e.sdk_default_avatar);
        this.beZ.setOnClickListener(this);
        this.aWW = (TextView) findViewById(a.f.sender_name);
        this.aWW.setOnClickListener(this);
        this.aYn = (TextView) findViewById(a.f.gift_name);
        this.bfa = (TbImageView) findViewById(a.f.gift_icon);
        this.bfa.setAutoChangeStyle(false);
        this.bfa.setDefaultBgResource(a.c.sdk_transparent);
        this.bfa.setDefaultErrorResource(a.c.sdk_transparent);
        this.bfa.setGifIconSupport(false);
        this.bfd = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bfc = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bfc.loop(true);
        this.bfc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bfe = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bfe.loop(true);
        this.bfd.getPaint().setFakeBoldText(true);
        JW();
    }

    public void setMode(boolean z) {
        this.bfg = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void JW() {
        this.beP = ObjectAnimator.ofFloat(this.beZ, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.beP.setDuration(350L);
        this.beP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.JY();
                AlaSmallGiftView.this.JZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.beS = ObjectAnimator.ofFloat(this.bfa, "ScaleX", 0.1f, 1.0f);
        this.beT = ObjectAnimator.ofFloat(this.bfa, "ScaleY", 0.1f, 1.0f);
        this.beR = new AnimatorSet();
        this.beR.playTogether(this.beS, this.beT);
        this.beR.setInterpolator(new OvershootInterpolator(4.0f));
        this.beR.setDuration(400L);
        this.beR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bff != null) {
                    AlaSmallGiftView.this.bff.IR();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.beU = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.beU.setDuration(300L);
        this.beU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Ke();
                AlaSmallGiftView.this.Kf();
                if (AlaSmallGiftView.this.bff != null) {
                    AlaSmallGiftView.this.bff.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.beW = ObjectAnimator.ofFloat(this.bfd, "ScaleX", 3.0f, 1.0f);
        this.beX = ObjectAnimator.ofFloat(this.bfd, "ScaleY", 3.0f, 1.0f);
        this.beV = new AnimatorSet();
        this.beV.playTogether(this.beW, this.beX);
        this.beV.setDuration(240L);
        this.beV.setInterpolator(new OvershootInterpolator());
        this.beV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bff != null) {
                    AlaSmallGiftView.this.bff.IS();
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

    private void JX() {
        this.beZ.setVisibility(0);
        this.beP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY() {
        this.bfa.setVisibility(0);
        this.beR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JZ() {
        if (this.bfc != null && this.bfc.getVisibility() == 0) {
            this.bfc.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bfc.cancelAnimation();
                    AlaSmallGiftView.this.bfc.playAnimation();
                }
            });
        }
        if (this.bfe != null && this.bfe.getVisibility() == 0) {
            this.bfe.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bfe.cancelAnimation();
                    AlaSmallGiftView.this.bfe.playAnimation();
                }
            });
        }
    }

    private void Ka() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.beQ = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.beQ.setInterpolator(new OvershootInterpolator());
            this.beQ.setDuration(300L);
            this.beQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.JY();
                    AlaSmallGiftView.this.JZ();
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

    private void Kb() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.beO = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.beO.setInterpolator(new OvershootInterpolator());
            this.beO.setDuration(300L);
        }
    }

    public void Kc() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Kf();
            if (this.beP != null) {
                this.beP.cancel();
            }
            this.beZ.setVisibility(0);
            if (this.beQ == null) {
                Ka();
            }
            this.beQ.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Kf();
            if (this.beO == null) {
                Kb();
            }
            this.beO.start();
            JX();
        }
    }

    public void Kd() {
        this.beU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        this.bfa.setVisibility(8);
    }

    public void Kf() {
        setTranslationY(0.0f);
        if (this.beP != null) {
            this.beP.cancel();
        }
        if (this.beR != null) {
            this.beR.cancel();
        }
        if (this.beV != null) {
            this.beV.cancel();
        }
        if (this.beO != null) {
            this.beO.cancel();
        }
        if (this.beQ != null) {
            this.beQ.cancel();
        }
        if (this.beU != null) {
            this.beU.cancel();
        }
        if (this.bfe != null) {
            this.bfe.cancelAnimation();
        }
        if (this.bfc != null) {
            this.bfc.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bbc != null) {
            this.aWY = cVar;
            setGiftCnt(cVar.bbj);
            hl(cVar.userName);
            this.aYn.setText(cVar.bbc.FU());
            Kg();
            Kh();
            if (z) {
                setDisplayStyle(cVar.bbj);
            }
        }
    }

    private void Kg() {
        if (this.aWY != null) {
            this.beZ.setUrl(this.aWY.portrait);
            l.a(this.beZ, this.aWY.portrait, false, !StringUtils.isNull(this.aWY.appId));
        }
    }

    private void Kh() {
        if (this.aWY != null && this.aWY.bbc != null) {
            this.bfa.setVisibility(0);
            this.bfa.startLoad(this.aWY.bbc.getThumbnail_url(), 10, false);
        }
    }

    private void hl(String str) {
        this.aWW.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aWW.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bfc.setVisibility(8);
            this.bfe.setVisibility(8);
            this.beY.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.bfd.setGravity(3);
        } else if (j <= 65) {
            this.bfc.setVisibility(8);
            this.bfe.setVisibility(8);
            this.beY.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.bfd.setGravity(19);
        } else if (j <= 187) {
            this.bfc.setVisibility(0);
            this.bfc.setAnimation("66-1.json");
            this.bfe.setVisibility(8);
            this.beY.setBackgroundResource(a.c.sdk_transparent);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bfc.setVisibility(0);
            this.bfc.setAnimation("188-1.json");
            this.bfe.setVisibility(0);
            this.bfe.setAnimation("188-2.json");
            this.beY.setBackgroundResource(a.c.sdk_transparent);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bfc.setVisibility(0);
            this.bfc.setAnimation("520-1.json");
            this.bfe.setVisibility(0);
            this.bfe.setAnimation("520-2.json");
            this.beY.setBackgroundResource(a.c.sdk_transparent);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bfc.setVisibility(0);
            this.bfc.setAnimation("1314-1.json");
            this.bfe.setVisibility(0);
            this.bfe.setAnimation("1314-2.json");
            this.beY.setBackgroundResource(a.c.sdk_transparent);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bfc.setVisibility(0);
            this.bfc.setAnimation("9999-1.json");
            this.bfe.setVisibility(0);
            this.bfe.setAnimation("9999-2.json");
            this.beY.setBackgroundResource(a.c.sdk_transparent);
            this.bfd.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.bfd.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bfd.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bfe.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bfd.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.bfd.setLayoutParams(layoutParams);
            this.bfd.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bfd.getLayoutParams();
            layoutParams2.width = -2;
            this.bfd.setLayoutParams(layoutParams2);
            this.bfd.setGravity(19);
        }
        this.beW.setFloatValues(1.0f, 1.5f, 1.0f);
        this.beX.setFloatValues(1.0f, 1.5f, 1.0f);
        this.beV.setDuration(840L);
        this.beV.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.beV.getChildAnimations();
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
                if (this.bfg > 0) {
                    this.beY.setBackgroundResource(this.bfg);
                } else {
                    this.beY.setBackgroundResource(a.e.gray_circle);
                }
                this.bfd.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.beY.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bfd.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.beW.setFloatValues(3.0f, 1.0f);
                this.beX.setFloatValues(3.0f, 1.0f);
                this.beV.setDuration(240L);
                this.beV.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.beW.setFloatValues(1.0f, 1.5f, 1.0f);
                this.beX.setFloatValues(1.0f, 1.5f, 1.0f);
                this.beV.setDuration(480L);
                this.beV.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.beV.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bfd.setVisibility(8);
        } else {
            this.bfd.setVisibility(0);
        }
        this.bfd.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aWY;
    }

    public void f(long j, long j2) {
        Kg();
        Kh();
        if (j < 1) {
            this.bfd.setVisibility(8);
        } else if (this.aWY != null) {
            this.aWY.bbj = j2;
            this.aWY.bbi = j;
            this.bfd.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Ki();
            JZ();
        }
    }

    private void Ki() {
        this.bfd.setVisibility(0);
        this.beV.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aWY.userId), this.aWY.userName, this.aWY.portrait, this.aWY.sex, this.aWY.bbe, this.aWY.location, this.aWY.description, 0L, this.aWY.fansCount, this.aWY.bbf, this.aWY.userStatus, this.aWY.liveId, this.aWY.groupId, this.aWY.bbk, this.aWY.bbl, this.aWY.appId, this.aWY.userName, "")));
        }
    }

    public void onDestroy() {
        Kf();
        if (this.beY != null) {
            this.beY.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aWY != null && this.aWY.bbj < this.aWY.bbi) {
            if (this.aWY.bbj <= 0) {
                this.aWY.bbj = 1L;
            }
            this.bfd.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aWY.bbj)));
            Ki();
            setDisplayStyle(this.aWY.bbj);
            JZ();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bff = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bfc != null && this.bfc.getVisibility() == 0) {
            int width = this.beY.getWidth();
            int height = this.beY.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bfc.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bfc.setLayoutParams(layoutParams);
        }
    }
}
