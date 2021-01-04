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
    private c bYI;
    private TextView bac;
    private TextView bbz;
    private ObjectAnimator biK;
    private ObjectAnimator biL;
    private ObjectAnimator biM;
    private AnimatorSet biN;
    private ObjectAnimator biO;
    private ObjectAnimator biP;
    private ObjectAnimator biQ;
    private AnimatorSet biR;
    private ObjectAnimator biS;
    private ObjectAnimator biT;
    private RelativeLayout biU;
    private HeadImageView biV;
    private TbImageView biX;
    private LottieAnimationView biY;
    private LottieAnimationView bja;
    private int bjc;
    private AlaGiftStrokeTextView cbk;
    private a cbl;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void JB();

        void JC();

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
        this.biU = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.biU.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.biV = (HeadImageView) findViewById(a.f.sender_avatar);
        this.biV.setIsRound(true);
        this.biV.setAutoChangeStyle(false);
        this.biV.setDefaultBgResource(a.e.sdk_default_avatar);
        this.biV.setOnClickListener(this);
        this.bac = (TextView) findViewById(a.f.sender_name);
        this.bac.setOnClickListener(this);
        this.bbz = (TextView) findViewById(a.f.gift_name);
        this.biX = (TbImageView) findViewById(a.f.gift_icon);
        this.biX.setAutoChangeStyle(false);
        this.biX.setDefaultBgResource(a.c.sdk_transparent);
        this.biX.setDefaultErrorResource(a.c.sdk_transparent);
        this.biX.setGifIconSupport(false);
        this.cbk = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.biY = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.biY.loop(true);
        this.biY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bja = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bja.loop(true);
        this.cbk.getPaint().setFakeBoldText(true);
        KN();
    }

    public void setMode(boolean z) {
        this.bjc = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void KN() {
        this.biL = ObjectAnimator.ofFloat(this.biV, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.biL.setDuration(350L);
        this.biL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.KP();
                AlaSmallGiftView.this.KQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biO = ObjectAnimator.ofFloat(this.biX, "ScaleX", 0.1f, 1.0f);
        this.biP = ObjectAnimator.ofFloat(this.biX, "ScaleY", 0.1f, 1.0f);
        this.biN = new AnimatorSet();
        this.biN.playTogether(this.biO, this.biP);
        this.biN.setInterpolator(new OvershootInterpolator(4.0f));
        this.biN.setDuration(400L);
        this.biN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.cbl != null) {
                    AlaSmallGiftView.this.cbl.JB();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biQ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.biQ.setDuration(300L);
        this.biQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.KV();
                AlaSmallGiftView.this.KW();
                if (AlaSmallGiftView.this.cbl != null) {
                    AlaSmallGiftView.this.cbl.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.biS = ObjectAnimator.ofFloat(this.cbk, "ScaleX", 3.0f, 1.0f);
        this.biT = ObjectAnimator.ofFloat(this.cbk, "ScaleY", 3.0f, 1.0f);
        this.biR = new AnimatorSet();
        this.biR.playTogether(this.biS, this.biT);
        this.biR.setDuration(240L);
        this.biR.setInterpolator(new OvershootInterpolator());
        this.biR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.cbl != null) {
                    AlaSmallGiftView.this.cbl.JC();
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
    public void KP() {
        this.biX.setVisibility(0);
        this.biN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KQ() {
        if (this.biY != null && this.biY.getVisibility() == 0) {
            this.biY.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.biY.cancelAnimation();
                    AlaSmallGiftView.this.biY.playAnimation();
                }
            });
        }
        if (this.bja != null && this.bja.getVisibility() == 0) {
            this.bja.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bja.cancelAnimation();
                    AlaSmallGiftView.this.bja.playAnimation();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        this.biX.setVisibility(8);
    }

    public void KW() {
        setTranslationY(0.0f);
        if (this.biL != null) {
            this.biL.cancel();
        }
        if (this.biN != null) {
            this.biN.cancel();
        }
        if (this.biR != null) {
            this.biR.cancel();
        }
        if (this.biK != null) {
            this.biK.cancel();
        }
        if (this.biM != null) {
            this.biM.cancel();
        }
        if (this.biQ != null) {
            this.biQ.cancel();
        }
        if (this.bja != null) {
            this.bja.cancelAnimation();
        }
        if (this.biY != null) {
            this.biY.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bex != null) {
            this.bYI = cVar;
            setGiftCnt(cVar.beD);
            hl(cVar.userName);
            this.bbz.setText(cVar.bex.Gy());
            KX();
            KY();
            if (z) {
                setDisplayStyle(cVar.beD);
            }
        }
    }

    private void KX() {
        if (this.bYI != null) {
            this.biV.setUrl(this.bYI.portrait);
            m.a(this.biV, this.bYI.portrait, false, !StringUtils.isNull(this.bYI.appId));
        }
    }

    private void KY() {
        if (this.bYI != null && this.bYI.bex != null) {
            this.biX.setVisibility(0);
            this.biX.startLoad(this.bYI.bex.getThumbnail_url(), 10, false);
        }
    }

    private void hl(String str) {
        this.bac.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.bac.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.biY.setVisibility(8);
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.cbk.setGravity(3);
        } else if (j <= 65) {
            this.biY.setVisibility(8);
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.cbk.setGravity(19);
        } else if (j <= 187) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("yuyin-66-1.json");
            this.bja.setVisibility(8);
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("yuyin-188-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("yuyin-188-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("yuyin-520-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("yuyin-520-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.biY.setVisibility(0);
            this.biY.setAnimation("yuyin-1314-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("yuyin-1314-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.biY.setVisibility(0);
            this.biY.setAnimation("yuyin-9999-1.json");
            this.bja.setVisibility(0);
            this.bja.setAnimation("yuyin-9999-2.json");
            this.biU.setBackgroundResource(a.c.sdk_transparent);
            this.cbk.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.cbk.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.cbk.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bja.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cbk.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.cbk.setLayoutParams(layoutParams);
            this.cbk.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cbk.getLayoutParams();
            layoutParams2.width = -2;
            this.cbk.setLayoutParams(layoutParams2);
            this.cbk.setGravity(19);
        }
        this.biS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biT.setFloatValues(1.0f, 1.5f, 1.0f);
        this.biR.setDuration(840L);
        this.biR.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.biR.getChildAnimations();
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
                if (this.bjc > 0) {
                    this.biU.setBackgroundResource(this.bjc);
                } else {
                    this.biU.setBackgroundResource(a.e.gray_circle);
                }
                this.cbk.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.biU.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.cbk.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.biS.setFloatValues(3.0f, 1.0f);
                this.biT.setFloatValues(3.0f, 1.0f);
                this.biR.setDuration(240L);
                this.biR.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.biS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biT.setFloatValues(1.0f, 1.5f, 1.0f);
                this.biR.setDuration(480L);
                this.biR.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.biR.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.cbk.setVisibility(8);
        } else {
            this.cbk.setVisibility(0);
        }
        this.cbk.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.bYI;
    }

    private void KZ() {
        this.cbk.setVisibility(0);
        this.biR.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bYI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bYI.userId), this.bYI.userName, this.bYI.portrait, this.bYI.sex, this.bYI.bez, this.bYI.location, this.bYI.description, 0L, this.bYI.fansCount, this.bYI.followCount, this.bYI.userStatus, this.bYI.groupId, this.bYI.liveId, this.bYI.beF, this.bYI.beG, this.bYI.appId, this.bYI.userName, "")));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bYI != null && this.bYI.beD < this.bYI.beC) {
            if (this.bYI.beD <= 0) {
                this.bYI.beD = 1L;
            }
            this.cbk.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.bYI.beD)));
            KZ();
            setDisplayStyle(this.bYI.beD);
            KQ();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.cbl = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.biY != null && this.biY.getVisibility() == 0) {
            int width = this.biU.getWidth();
            int height = this.biU.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.biY.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.biY.setLayoutParams(layoutParams);
        }
    }
}
