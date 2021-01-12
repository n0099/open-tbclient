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
/* loaded from: classes10.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aVp;
    private TextView aWL;
    private c bTW;
    private AlaGiftStrokeTextView bWy;
    private a bWz;
    private ObjectAnimator bdR;
    private ObjectAnimator bdS;
    private ObjectAnimator bdT;
    private AnimatorSet bdU;
    private ObjectAnimator bdV;
    private ObjectAnimator bdW;
    private ObjectAnimator bdX;
    private AnimatorSet bdY;
    private ObjectAnimator bdZ;
    private ObjectAnimator bea;
    private RelativeLayout beb;
    private HeadImageView bec;
    private TbImageView bee;
    private LottieAnimationView bef;
    private LottieAnimationView bei;
    private int bek;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void FG();

        void FH();

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
        this.beb = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.beb.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bec = (HeadImageView) findViewById(a.f.sender_avatar);
        this.bec.setIsRound(true);
        this.bec.setAutoChangeStyle(false);
        this.bec.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bec.setOnClickListener(this);
        this.aVp = (TextView) findViewById(a.f.sender_name);
        this.aVp.setOnClickListener(this);
        this.aWL = (TextView) findViewById(a.f.gift_name);
        this.bee = (TbImageView) findViewById(a.f.gift_icon);
        this.bee.setAutoChangeStyle(false);
        this.bee.setDefaultBgResource(a.c.sdk_transparent);
        this.bee.setDefaultErrorResource(a.c.sdk_transparent);
        this.bee.setGifIconSupport(false);
        this.bWy = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bef = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bef.loop(true);
        this.bef.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bei = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bei.loop(true);
        this.bWy.getPaint().setFakeBoldText(true);
        GS();
    }

    public void setMode(boolean z) {
        this.bek = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void GS() {
        this.bdS = ObjectAnimator.ofFloat(this.bec, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bdS.setDuration(350L);
        this.bdS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.GU();
                AlaSmallGiftView.this.GV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdV = ObjectAnimator.ofFloat(this.bee, "ScaleX", 0.1f, 1.0f);
        this.bdW = ObjectAnimator.ofFloat(this.bee, "ScaleY", 0.1f, 1.0f);
        this.bdU = new AnimatorSet();
        this.bdU.playTogether(this.bdV, this.bdW);
        this.bdU.setInterpolator(new OvershootInterpolator(4.0f));
        this.bdU.setDuration(400L);
        this.bdU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bWz != null) {
                    AlaSmallGiftView.this.bWz.FG();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdX = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bdX.setDuration(300L);
        this.bdX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Ha();
                AlaSmallGiftView.this.Hb();
                if (AlaSmallGiftView.this.bWz != null) {
                    AlaSmallGiftView.this.bWz.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdZ = ObjectAnimator.ofFloat(this.bWy, "ScaleX", 3.0f, 1.0f);
        this.bea = ObjectAnimator.ofFloat(this.bWy, "ScaleY", 3.0f, 1.0f);
        this.bdY = new AnimatorSet();
        this.bdY.playTogether(this.bdZ, this.bea);
        this.bdY.setDuration(240L);
        this.bdY.setInterpolator(new OvershootInterpolator());
        this.bdY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bWz != null) {
                    AlaSmallGiftView.this.bWz.FH();
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
    public void GU() {
        this.bee.setVisibility(0);
        this.bdU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
        if (this.bef != null && this.bef.getVisibility() == 0) {
            this.bef.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bef.cancelAnimation();
                    AlaSmallGiftView.this.bef.playAnimation();
                }
            });
        }
        if (this.bei != null && this.bei.getVisibility() == 0) {
            this.bei.post(new Runnable() { // from class: com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bei.cancelAnimation();
                    AlaSmallGiftView.this.bei.playAnimation();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        this.bee.setVisibility(8);
    }

    public void Hb() {
        setTranslationY(0.0f);
        if (this.bdS != null) {
            this.bdS.cancel();
        }
        if (this.bdU != null) {
            this.bdU.cancel();
        }
        if (this.bdY != null) {
            this.bdY.cancel();
        }
        if (this.bdR != null) {
            this.bdR.cancel();
        }
        if (this.bdT != null) {
            this.bdT.cancel();
        }
        if (this.bdX != null) {
            this.bdX.cancel();
        }
        if (this.bei != null) {
            this.bei.cancelAnimation();
        }
        if (this.bef != null) {
            this.bef.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aZH != null) {
            this.bTW = cVar;
            setGiftCnt(cVar.aZN);
            fZ(cVar.userName);
            this.aWL.setText(cVar.aZH.CD());
            Hc();
            Hd();
            if (z) {
                setDisplayStyle(cVar.aZN);
            }
        }
    }

    private void Hc() {
        if (this.bTW != null) {
            this.bec.setUrl(this.bTW.portrait);
            m.a(this.bec, this.bTW.portrait, false, !StringUtils.isNull(this.bTW.appId));
        }
    }

    private void Hd() {
        if (this.bTW != null && this.bTW.aZH != null) {
            this.bee.setVisibility(0);
            this.bee.startLoad(this.bTW.aZH.getThumbnail_url(), 10, false);
        }
    }

    private void fZ(String str) {
        this.aVp.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aVp.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bef.setVisibility(8);
            this.bei.setVisibility(8);
            this.beb.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.bWy.setGravity(3);
        } else if (j <= 65) {
            this.bef.setVisibility(8);
            this.bei.setVisibility(8);
            this.beb.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.bWy.setGravity(19);
        } else if (j <= 187) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("yuyin-66-1.json");
            this.bei.setVisibility(8);
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("yuyin-188-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("yuyin-188-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("yuyin-520-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("yuyin-520-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("yuyin-1314-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("yuyin-1314-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bef.setVisibility(0);
            this.bef.setAnimation("yuyin-9999-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("yuyin-9999-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.bWy.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.bWy.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bWy.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bei.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bWy.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.bWy.setLayoutParams(layoutParams);
            this.bWy.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bWy.getLayoutParams();
            layoutParams2.width = -2;
            this.bWy.setLayoutParams(layoutParams2);
            this.bWy.setGravity(19);
        }
        this.bdZ.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bea.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bdY.setDuration(840L);
        this.bdY.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bdY.getChildAnimations();
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
                if (this.bek > 0) {
                    this.beb.setBackgroundResource(this.bek);
                } else {
                    this.beb.setBackgroundResource(a.e.gray_circle);
                }
                this.bWy.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.beb.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bWy.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bdZ.setFloatValues(3.0f, 1.0f);
                this.bea.setFloatValues(3.0f, 1.0f);
                this.bdY.setDuration(240L);
                this.bdY.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bdZ.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bea.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bdY.setDuration(480L);
                this.bdY.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bdY.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bWy.setVisibility(8);
        } else {
            this.bWy.setVisibility(0);
        }
        this.bWy.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.bTW;
    }

    private void He() {
        this.bWy.setVisibility(0);
        this.bdY.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bTW.userId), this.bTW.userName, this.bTW.portrait, this.bTW.sex, this.bTW.aZJ, this.bTW.location, this.bTW.description, 0L, this.bTW.fansCount, this.bTW.followCount, this.bTW.userStatus, this.bTW.groupId, this.bTW.liveId, this.bTW.aZP, this.bTW.aZQ, this.bTW.appId, this.bTW.userName, "")));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bTW != null && this.bTW.aZN < this.bTW.aZM) {
            if (this.bTW.aZN <= 0) {
                this.bTW.aZN = 1L;
            }
            this.bWy.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.bTW.aZN)));
            He();
            setDisplayStyle(this.bTW.aZN);
            GV();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bWz = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bef != null && this.bef.getVisibility() == 0) {
            int width = this.beb.getWidth();
            int height = this.beb.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bef.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bef.setLayoutParams(layoutParams);
        }
    }
}
