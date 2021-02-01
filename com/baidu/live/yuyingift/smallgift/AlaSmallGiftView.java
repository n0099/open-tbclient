package com.baidu.live.yuyingift.smallgift;

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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aYx;
    private TextView aZR;
    private c bXV;
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
    private TbImageView bho;
    private LottieAnimationView bhp;
    private LottieAnimationView bhr;
    private int bht;
    private AlaGiftStrokeTextView caA;
    private a caB;
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
        LayoutInflater.from(getContext()).inflate(a.g.yuyinpopup_gift_layout, this);
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
        this.bho = (TbImageView) findViewById(a.f.gift_icon);
        this.bho.setAutoChangeStyle(false);
        this.bho.setDefaultBgResource(a.c.sdk_transparent);
        this.bho.setDefaultErrorResource(a.c.sdk_transparent);
        this.bho.setGifIconSupport(false);
        this.caA = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bhp = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bhp.loop(true);
        this.bhp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bhr = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bhr.loop(true);
        this.caA.getPaint().setFakeBoldText(true);
        Ii();
    }

    public void setMode(boolean z) {
        this.bht = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void Ii() {
        this.bhc = ObjectAnimator.ofFloat(this.bhm, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bhc.setDuration(350L);
        this.bhc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.1
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
        this.bhe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.caB != null) {
                    AlaSmallGiftView.this.caB.GW();
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
        this.bhh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Iq();
                AlaSmallGiftView.this.Ir();
                if (AlaSmallGiftView.this.caB != null) {
                    AlaSmallGiftView.this.caB.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhj = ObjectAnimator.ofFloat(this.caA, "ScaleX", 3.0f, 1.0f);
        this.bhk = ObjectAnimator.ofFloat(this.caA, "ScaleY", 3.0f, 1.0f);
        this.bhi = new AnimatorSet();
        this.bhi.playTogether(this.bhj, this.bhk);
        this.bhi.setDuration(240L);
        this.bhi.setInterpolator(new OvershootInterpolator());
        this.bhi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.caB != null) {
                    AlaSmallGiftView.this.caB.GX();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
        this.bho.setVisibility(0);
        this.bhe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (this.bhp != null && this.bhp.getVisibility() == 0) {
            this.bhp.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhp.cancelAnimation();
                    AlaSmallGiftView.this.bhp.playAnimation();
                }
            });
        }
        if (this.bhr != null && this.bhr.getVisibility() == 0) {
            this.bhr.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhr.cancelAnimation();
                    AlaSmallGiftView.this.bhr.playAnimation();
                }
            });
        }
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
            this.bXV = cVar;
            setGiftCnt(cVar.bcU);
            gx(cVar.userName);
            this.aZR.setText(cVar.bcO.DS());
            Is();
            It();
            if (z) {
                setDisplayStyle(cVar.bcU);
            }
        }
    }

    private void Is() {
        if (this.bXV != null) {
            this.bhm.setUrl(this.bXV.portrait);
            m.a(this.bhm, this.bXV.portrait, false, !StringUtils.isNull(this.bXV.appId));
        }
    }

    private void It() {
        if (this.bXV != null && this.bXV.bcO != null) {
            this.bho.setVisibility(0);
            this.bho.startLoad(this.bXV.bcO.getThumbnail_url(), 10, false);
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
            this.caA.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.caA.setGravity(3);
        } else if (j <= 65) {
            this.bhp.setVisibility(8);
            this.bhr.setVisibility(8);
            this.bhl.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.caA.setGravity(19);
        } else if (j <= 187) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("yuyin-66-1.json");
            this.bhr.setVisibility(8);
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("yuyin-188-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("yuyin-188-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("yuyin-520-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("yuyin-520-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("yuyin-1314-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("yuyin-1314-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bhp.setVisibility(0);
            this.bhp.setAnimation("yuyin-9999-1.json");
            this.bhr.setVisibility(0);
            this.bhr.setAnimation("yuyin-9999-2.json");
            this.bhl.setBackgroundResource(a.c.sdk_transparent);
            this.caA.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.caA.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.caA.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bhr.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caA.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.caA.setLayoutParams(layoutParams);
            this.caA.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.caA.getLayoutParams();
            layoutParams2.width = -2;
            this.caA.setLayoutParams(layoutParams2);
            this.caA.setGravity(19);
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
                this.caA.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.bhl.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.caA.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
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
            this.caA.setVisibility(8);
        } else {
            this.caA.setVisibility(0);
        }
        this.caA.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.bXV;
    }

    private void Iu() {
        this.caA.setVisibility(0);
        this.bhi.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bXV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bXV.userId), this.bXV.userName, this.bXV.portrait, this.bXV.sex, this.bXV.bcQ, this.bXV.location, this.bXV.description, 0L, this.bXV.fansCount, this.bXV.followCount, this.bXV.userStatus, this.bXV.groupId, this.bXV.liveId, this.bXV.bcW, this.bXV.bcX, this.bXV.appId, this.bXV.userName, "")));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bXV != null && this.bXV.bcU < this.bXV.bcT) {
            if (this.bXV.bcU <= 0) {
                this.bXV.bcU = 1L;
            }
            this.caA.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.bXV.bcU)));
            Iu();
            setDisplayStyle(this.bXV.bcU);
            Il();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.caB = aVar;
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
