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
    private TextView aYx;
    private c aYz;
    private TextView aZR;
    private ObjectAnimator bhb;
    private ObjectAnimator bhc;
    private ObjectAnimator bhd;
    private AnimatorSet bhe;
    private ObjectAnimator bhf;
    private ObjectAnimator bhg;
    private ObjectAnimator bhh;
    private AnimatorSet bhi;
    private ObjectAnimator bhj;
    private ObjectAnimator bhk;
    private RelativeLayout bhl;
    private HeadImageView bhm;
    private TextView bhn;
    private TbImageView bho;
    private LottieAnimationView bhp;
    private AlaGiftStrokeTextView bhq;
    private LottieAnimationView bhr;
    private a bhs;
    private int bht;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void GW();

        void GX();

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
        this.bhl = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.bhl.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bhm = (HeadImageView) findViewById(a.f.sender_avatar);
        this.bhm.setIsRound(true);
        this.bhm.setAutoChangeStyle(false);
        this.bhm.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bhm.setOnClickListener(this);
        this.aYx = (TextView) findViewById(a.f.sender_name);
        this.aYx.setOnClickListener(this);
        this.aZR = (TextView) findViewById(a.f.gift_name);
        this.bhn = (TextView) findViewById(a.f.giftNameTip);
        this.bho = (TbImageView) findViewById(a.f.gift_icon);
        this.bho.setAutoChangeStyle(false);
        this.bho.setDefaultBgResource(a.c.sdk_transparent);
        this.bho.setDefaultErrorResource(a.c.sdk_transparent);
        this.bho.setGifIconSupport(false);
        this.bhq = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bhp = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bhp.loop(true);
        this.bhp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bhr = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bhr.loop(true);
        this.bhq.getPaint().setFakeBoldText(true);
        Ii();
    }

    public void setMode(boolean z) {
        this.bht = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void Ii() {
        this.bhc = ObjectAnimator.ofFloat(this.bhm, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bhc.setDuration(350L);
        this.bhc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Ik();
                AlaSmallGiftView.this.Il();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhf = ObjectAnimator.ofFloat(this.bho, "ScaleX", 0.1f, 1.0f);
        this.bhg = ObjectAnimator.ofFloat(this.bho, "ScaleY", 0.1f, 1.0f);
        this.bhe = new AnimatorSet();
        this.bhe.playTogether(this.bhf, this.bhg);
        this.bhe.setInterpolator(new OvershootInterpolator(4.0f));
        this.bhe.setDuration(400L);
        this.bhe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bhs != null) {
                    AlaSmallGiftView.this.bhs.GW();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhh = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bhh.setDuration(300L);
        this.bhh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Iq();
                AlaSmallGiftView.this.Ir();
                if (AlaSmallGiftView.this.bhs != null) {
                    AlaSmallGiftView.this.bhs.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhj = ObjectAnimator.ofFloat(this.bhq, "ScaleX", 3.0f, 1.0f);
        this.bhk = ObjectAnimator.ofFloat(this.bhq, "ScaleY", 3.0f, 1.0f);
        this.bhi = new AnimatorSet();
        this.bhi.playTogether(this.bhj, this.bhk);
        this.bhi.setDuration(240L);
        this.bhi.setInterpolator(new OvershootInterpolator());
        this.bhi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bhs != null) {
                    AlaSmallGiftView.this.bhs.GX();
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

    private void Ij() {
        this.bhm.setVisibility(0);
        this.bhc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
        this.bho.setVisibility(0);
        this.bhe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (this.bhp != null && this.bhp.getVisibility() == 0) {
            this.bhp.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhp.cancelAnimation();
                    AlaSmallGiftView.this.bhp.playAnimation();
                }
            });
        }
        if (this.bhr != null && this.bhr.getVisibility() == 0) {
            this.bhr.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhr.cancelAnimation();
                    AlaSmallGiftView.this.bhr.playAnimation();
                }
            });
        }
    }

    private void Im() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bhd = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bhd.setInterpolator(new OvershootInterpolator());
            this.bhd.setDuration(300L);
            this.bhd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Ik();
                    AlaSmallGiftView.this.Il();
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

    private void In() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bhb = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bhb.setInterpolator(new OvershootInterpolator());
            this.bhb.setDuration(300L);
        }
    }

    public void Io() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Ir();
            if (this.bhc != null) {
                this.bhc.cancel();
            }
            this.bhm.setVisibility(0);
            if (this.bhd == null) {
                Im();
            }
            this.bhd.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Ir();
            if (this.bhb == null) {
                In();
            }
            this.bhb.start();
            Ij();
        }
    }

    public void Ip() {
        this.bhh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iq() {
        this.bho.setVisibility(8);
    }

    public void Ir() {
        setTranslationY(0.0f);
        if (this.bhc != null) {
            this.bhc.cancel();
        }
        if (this.bhe != null) {
            this.bhe.cancel();
        }
        if (this.bhi != null) {
            this.bhi.cancel();
        }
        if (this.bhb != null) {
            this.bhb.cancel();
        }
        if (this.bhd != null) {
            this.bhd.cancel();
        }
        if (this.bhh != null) {
            this.bhh.cancel();
        }
        if (this.bhr != null) {
            this.bhr.cancelAnimation();
        }
        if (this.bhp != null) {
            this.bhp.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bcO != null) {
            this.aYz = cVar;
            setGiftCnt(cVar.bcU);
            gx(cVar.userName);
            this.aZR.setText(cVar.bcO.DS());
            if (!TextUtils.isEmpty(cVar.bde)) {
                this.bhn.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.bhn.setText(cVar.bde);
            } else {
                this.bhn.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha90));
                this.bhn.setText(this.mContext.getString(a.h.gift_name_prefix));
            }
            Is();
            It();
            if (z) {
                setDisplayStyle(cVar.bcU);
            }
        }
    }

    private void Is() {
        if (this.aYz != null) {
            this.bhm.setUrl(this.aYz.portrait);
            m.a(this.bhm, this.aYz.portrait, false, !StringUtils.isNull(this.aYz.appId));
        }
    }

    private void It() {
        if (this.aYz != null && this.aYz.bcO != null) {
            this.bho.setVisibility(0);
            this.bho.startLoad(this.aYz.bcO.getThumbnail_url(), 10, false);
        }
    }

    private void gx(String str) {
        this.aYx.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aYx.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bhp.setVisibility(8);
            this.bhr.setVisibility(8);
            this.bhl.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.bhq.setGravity(3);
        } else if (j <= 65) {
            this.bhp.setVisibility(8);
            this.bhr.setVisibility(8);
            this.bhl.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.bhq.setGravity(19);
        } else if (j <= 187) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("66-1.json");
            this.bhr.setVisibility(8);
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("188-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("188-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("520-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("520-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("1314-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("1314-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("9999-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("9999-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.bhq.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.bhq.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhq.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bhr.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhq.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.bhq.setLayoutParams(layoutParams);
            this.bhq.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bhq.getLayoutParams();
            layoutParams2.width = -2;
            this.bhq.setLayoutParams(layoutParams2);
            this.bhq.setGravity(19);
        }
        this.bhj.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bhk.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bhi.setDuration(840L);
        this.bhi.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bhi.getChildAnimations();
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
                if (this.bht > 0) {
                    this.bhl.setBackgroundResource(this.bht);
                } else {
                    this.bhl.setBackgroundResource(a.e.gray_circle);
                }
                this.bhq.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.bhl.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bhq.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bhj.setFloatValues(3.0f, 1.0f);
                this.bhk.setFloatValues(3.0f, 1.0f);
                this.bhi.setDuration(240L);
                this.bhi.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bhj.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bhk.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bhi.setDuration(480L);
                this.bhi.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bhi.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bhq.setVisibility(8);
        } else {
            this.bhq.setVisibility(0);
        }
        this.bhq.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aYz;
    }

    public void i(long j, long j2) {
        Is();
        It();
        if (j < 1) {
            this.bhq.setVisibility(8);
        } else if (this.aYz != null) {
            this.aYz.bcU = j2;
            this.aYz.bcT = j;
            this.bhq.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Iu();
            Il();
        }
    }

    private void Iu() {
        this.bhq.setVisibility(0);
        this.bhi.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aYz != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYz.userId), this.aYz.userName, this.aYz.portrait, this.aYz.sex, this.aYz.bcQ, this.aYz.location, this.aYz.description, 0L, this.aYz.fansCount, this.aYz.followCount, this.aYz.userStatus, this.aYz.liveId, this.aYz.groupId, this.aYz.bcW, this.aYz.bcX, this.aYz.appId, this.aYz.userName)));
        }
    }

    public void onDestroy() {
        Ir();
        if (this.bhl != null) {
            this.bhl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aYz != null && this.aYz.bcU < this.aYz.bcT) {
            if (this.aYz.bcU <= 0) {
                this.aYz.bcU = 1L;
            }
            this.bhq.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aYz.bcU)));
            Iu();
            setDisplayStyle(this.aYz.bcU);
            Il();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bhs = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bhp != null && this.bhp.getVisibility() == 0) {
            int width = this.bhl.getWidth();
            int height = this.bhl.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhp.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bhp.setLayoutParams(layoutParams);
        }
    }
}
