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
/* loaded from: classes4.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aJJ;
    private c aJL;
    private TextView aKY;
    private ObjectAnimator aRc;
    private ObjectAnimator aRd;
    private ObjectAnimator aRe;
    private AnimatorSet aRf;
    private ObjectAnimator aRg;
    private ObjectAnimator aRh;
    private ObjectAnimator aRi;
    private AnimatorSet aRj;
    private ObjectAnimator aRk;
    private ObjectAnimator aRl;
    private RelativeLayout aRm;
    private HeadImageView aRn;
    private TbImageView aRo;
    private LottieAnimationView aRp;
    private AlaGiftStrokeTextView aRq;
    private LottieAnimationView aRr;
    private a aRs;
    private int aRt;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void AV();

        void AW();

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
        this.aRm = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aRm.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aRn = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aRn.setIsRound(true);
        this.aRn.setAutoChangeStyle(false);
        this.aRn.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aRn.setOnClickListener(this);
        this.aJJ = (TextView) findViewById(a.g.sender_name);
        this.aJJ.setOnClickListener(this);
        this.aKY = (TextView) findViewById(a.g.gift_name);
        this.aRo = (TbImageView) findViewById(a.g.gift_icon);
        this.aRo.setAutoChangeStyle(false);
        this.aRo.setDefaultBgResource(a.d.sdk_transparent);
        this.aRo.setDefaultErrorResource(a.d.sdk_transparent);
        this.aRo.setGifIconSupport(false);
        this.aRq = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aRp = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aRp.loop(true);
        this.aRp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aRr = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aRr.loop(true);
        this.aRq.getPaint().setFakeBoldText(true);
        Cb();
    }

    public void setMode(boolean z) {
        this.aRt = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void Cb() {
        this.aRd = ObjectAnimator.ofFloat(this.aRn, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aRd.setDuration(350L);
        this.aRd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Cd();
                AlaSmallGiftView.this.Ce();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aRg = ObjectAnimator.ofFloat(this.aRo, "ScaleX", 0.1f, 1.0f);
        this.aRh = ObjectAnimator.ofFloat(this.aRo, "ScaleY", 0.1f, 1.0f);
        this.aRf = new AnimatorSet();
        this.aRf.playTogether(this.aRg, this.aRh);
        this.aRf.setInterpolator(new OvershootInterpolator(4.0f));
        this.aRf.setDuration(400L);
        this.aRf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aRs != null) {
                    AlaSmallGiftView.this.aRs.AV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aRi = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aRi.setDuration(300L);
        this.aRi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Cj();
                AlaSmallGiftView.this.Ck();
                if (AlaSmallGiftView.this.aRs != null) {
                    AlaSmallGiftView.this.aRs.R(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aRk = ObjectAnimator.ofFloat(this.aRq, "ScaleX", 3.0f, 1.0f);
        this.aRl = ObjectAnimator.ofFloat(this.aRq, "ScaleY", 3.0f, 1.0f);
        this.aRj = new AnimatorSet();
        this.aRj.playTogether(this.aRk, this.aRl);
        this.aRj.setDuration(240L);
        this.aRj.setInterpolator(new OvershootInterpolator());
        this.aRj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aRs != null) {
                    AlaSmallGiftView.this.aRs.AW();
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

    private void Cc() {
        this.aRn.setVisibility(0);
        this.aRd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd() {
        this.aRo.setVisibility(0);
        this.aRf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        if (this.aRp != null && this.aRp.getVisibility() == 0) {
            this.aRp.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aRp.cancelAnimation();
                    AlaSmallGiftView.this.aRp.playAnimation();
                }
            });
        }
        if (this.aRr != null && this.aRr.getVisibility() == 0) {
            this.aRr.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aRr.cancelAnimation();
                    AlaSmallGiftView.this.aRr.playAnimation();
                }
            });
        }
    }

    private void Cf() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aRe = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aRe.setInterpolator(new OvershootInterpolator());
            this.aRe.setDuration(300L);
            this.aRe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Cd();
                    AlaSmallGiftView.this.Ce();
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

    private void Cg() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aRc = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aRc.setInterpolator(new OvershootInterpolator());
            this.aRc.setDuration(300L);
        }
    }

    public void Ch() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Ck();
            if (this.aRd != null) {
                this.aRd.cancel();
            }
            this.aRn.setVisibility(0);
            if (this.aRe == null) {
                Cf();
            }
            this.aRe.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Ck();
            if (this.aRc == null) {
                Cg();
            }
            this.aRc.start();
            Cc();
        }
    }

    public void Ci() {
        this.aRi.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        this.aRo.setVisibility(8);
    }

    public void Ck() {
        setTranslationY(0.0f);
        if (this.aRd != null) {
            this.aRd.cancel();
        }
        if (this.aRf != null) {
            this.aRf.cancel();
        }
        if (this.aRj != null) {
            this.aRj.cancel();
        }
        if (this.aRc != null) {
            this.aRc.cancel();
        }
        if (this.aRe != null) {
            this.aRe.cancel();
        }
        if (this.aRi != null) {
            this.aRi.cancel();
        }
        if (this.aRr != null) {
            this.aRr.cancelAnimation();
        }
        if (this.aRp != null) {
            this.aRp.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aND != null) {
            this.aJL = cVar;
            setGiftCnt(cVar.aNI);
            eZ(cVar.userName);
            this.aKY.setText(cVar.aND.yp());
            Cl();
            Cm();
            if (z) {
                setDisplayStyle(cVar.aNI);
            }
        }
    }

    private void Cl() {
        if (this.aJL != null) {
            this.aRn.setUrl(this.aJL.portrait);
            k.a(this.aRn, this.aJL.portrait, false, !StringUtils.isNull(this.aJL.appId));
        }
    }

    private void Cm() {
        if (this.aJL != null && this.aJL.aND != null) {
            this.aRo.setVisibility(0);
            this.aRo.startLoad(this.aJL.aND.getThumbnail_url(), 10, false);
        }
    }

    private void eZ(String str) {
        this.aJJ.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aJJ.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aRp.setVisibility(8);
            this.aRr.setVisibility(8);
            this.aRm.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aRq.setGravity(3);
        } else if (j <= 65) {
            this.aRp.setVisibility(8);
            this.aRr.setVisibility(8);
            this.aRm.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aRq.setGravity(19);
        } else if (j <= 187) {
            this.aRp.setVisibility(0);
            this.aRp.setAnimation("66-1.json");
            this.aRr.setVisibility(8);
            this.aRm.setBackgroundResource(a.d.sdk_transparent);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aRp.setVisibility(0);
            this.aRp.setAnimation("188-1.json");
            this.aRr.setVisibility(0);
            this.aRr.setAnimation("188-2.json");
            this.aRm.setBackgroundResource(a.d.sdk_transparent);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aRp.setVisibility(0);
            this.aRp.setAnimation("520-1.json");
            this.aRr.setVisibility(0);
            this.aRr.setAnimation("520-2.json");
            this.aRm.setBackgroundResource(a.d.sdk_transparent);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aRp.setVisibility(0);
            this.aRp.setAnimation("1314-1.json");
            this.aRr.setVisibility(0);
            this.aRr.setAnimation("1314-2.json");
            this.aRm.setBackgroundResource(a.d.sdk_transparent);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aRp.setVisibility(0);
            this.aRp.setAnimation("9999-1.json");
            this.aRr.setVisibility(0);
            this.aRr.setAnimation("9999-2.json");
            this.aRm.setBackgroundResource(a.d.sdk_transparent);
            this.aRq.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aRq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aRq.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aRr.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRq.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aRq.setLayoutParams(layoutParams);
            this.aRq.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aRq.getLayoutParams();
            layoutParams2.width = -2;
            this.aRq.setLayoutParams(layoutParams2);
            this.aRq.setGravity(19);
        }
        this.aRk.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aRl.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aRj.setDuration(840L);
        this.aRj.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aRj.getChildAnimations();
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
                if (this.aRt > 0) {
                    this.aRm.setBackgroundResource(this.aRt);
                } else {
                    this.aRm.setBackgroundResource(a.f.gray_circle);
                }
                this.aRq.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aRm.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aRq.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aRk.setFloatValues(3.0f, 1.0f);
                this.aRl.setFloatValues(3.0f, 1.0f);
                this.aRj.setDuration(240L);
                this.aRj.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aRk.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aRl.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aRj.setDuration(480L);
                this.aRj.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aRj.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aRq.setVisibility(8);
        } else {
            this.aRq.setVisibility(0);
        }
        this.aRq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aJL;
    }

    public void f(long j, long j2) {
        Cl();
        Cm();
        if (j < 1) {
            this.aRq.setVisibility(8);
        } else if (this.aJL != null) {
            this.aJL.aNI = j2;
            this.aJL.aNH = j;
            this.aRq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Cn();
            Ce();
        }
    }

    private void Cn() {
        this.aRq.setVisibility(0);
        this.aRj.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aJL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aJL.userId), this.aJL.userName, this.aJL.portrait, this.aJL.sex, this.aJL.aNF, this.aJL.location, this.aJL.description, 0L, this.aJL.fansCount, this.aJL.aNG, this.aJL.userStatus, this.aJL.liveId, this.aJL.groupId, this.aJL.aNJ, this.aJL.aNK, this.aJL.appId, this.aJL.userName, "")));
        }
    }

    public void onDestroy() {
        Ck();
        if (this.aRm != null) {
            this.aRm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aJL != null && this.aJL.aNI < this.aJL.aNH) {
            if (this.aJL.aNI <= 0) {
                this.aJL.aNI = 1L;
            }
            this.aRq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aJL.aNI)));
            Cn();
            setDisplayStyle(this.aJL.aNI);
            Ce();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aRs = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aRp != null && this.aRp.getVisibility() == 0) {
            int width = this.aRm.getWidth();
            int height = this.aRm.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRp.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aRp.setLayoutParams(layoutParams);
        }
    }
}
