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
    private TextView aVp;
    private c aVr;
    private TextView aWL;
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
    private TextView bed;
    private TbImageView bee;
    private LottieAnimationView bef;
    private AlaGiftStrokeTextView beh;
    private LottieAnimationView bei;
    private a bej;
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
        LayoutInflater.from(getContext()).inflate(a.g.popup_gift_layout, this);
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
        this.bed = (TextView) findViewById(a.f.giftNameTip);
        this.bee = (TbImageView) findViewById(a.f.gift_icon);
        this.bee.setAutoChangeStyle(false);
        this.bee.setDefaultBgResource(a.c.sdk_transparent);
        this.bee.setDefaultErrorResource(a.c.sdk_transparent);
        this.bee.setGifIconSupport(false);
        this.beh = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bef = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bef.loop(true);
        this.bef.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bei = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bei.loop(true);
        this.beh.getPaint().setFakeBoldText(true);
        GS();
    }

    public void setMode(boolean z) {
        this.bek = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void GS() {
        this.bdS = ObjectAnimator.ofFloat(this.bec, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bdS.setDuration(350L);
        this.bdS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
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
        this.bdU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bej != null) {
                    AlaSmallGiftView.this.bej.FG();
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
        this.bdX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Ha();
                AlaSmallGiftView.this.Hb();
                if (AlaSmallGiftView.this.bej != null) {
                    AlaSmallGiftView.this.bej.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdZ = ObjectAnimator.ofFloat(this.beh, "ScaleX", 3.0f, 1.0f);
        this.bea = ObjectAnimator.ofFloat(this.beh, "ScaleY", 3.0f, 1.0f);
        this.bdY = new AnimatorSet();
        this.bdY.playTogether(this.bdZ, this.bea);
        this.bdY.setDuration(240L);
        this.bdY.setInterpolator(new OvershootInterpolator());
        this.bdY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bej != null) {
                    AlaSmallGiftView.this.bej.FH();
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

    private void GT() {
        this.bec.setVisibility(0);
        this.bdS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        this.bee.setVisibility(0);
        this.bdU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
        if (this.bef != null && this.bef.getVisibility() == 0) {
            this.bef.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bef.cancelAnimation();
                    AlaSmallGiftView.this.bef.playAnimation();
                }
            });
        }
        if (this.bei != null && this.bei.getVisibility() == 0) {
            this.bei.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bei.cancelAnimation();
                    AlaSmallGiftView.this.bei.playAnimation();
                }
            });
        }
    }

    private void GW() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdT = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bdT.setInterpolator(new OvershootInterpolator());
            this.bdT.setDuration(300L);
            this.bdT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
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
        }
    }

    private void GX() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdR = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bdR.setInterpolator(new OvershootInterpolator());
            this.bdR.setDuration(300L);
        }
    }

    public void GY() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Hb();
            if (this.bdS != null) {
                this.bdS.cancel();
            }
            this.bec.setVisibility(0);
            if (this.bdT == null) {
                GW();
            }
            this.bdT.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Hb();
            if (this.bdR == null) {
                GX();
            }
            this.bdR.start();
            GT();
        }
    }

    public void GZ() {
        this.bdX.start();
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
            this.aVr = cVar;
            setGiftCnt(cVar.aZN);
            fZ(cVar.userName);
            this.aWL.setText(cVar.aZH.CD());
            if (!TextUtils.isEmpty(cVar.aZX)) {
                this.bed.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.bed.setText(cVar.aZX);
            } else {
                this.bed.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha90));
                this.bed.setText(this.mContext.getString(a.h.gift_name_prefix));
            }
            Hc();
            Hd();
            if (z) {
                setDisplayStyle(cVar.aZN);
            }
        }
    }

    private void Hc() {
        if (this.aVr != null) {
            this.bec.setUrl(this.aVr.portrait);
            m.a(this.bec, this.aVr.portrait, false, !StringUtils.isNull(this.aVr.appId));
        }
    }

    private void Hd() {
        if (this.aVr != null && this.aVr.aZH != null) {
            this.bee.setVisibility(0);
            this.bee.startLoad(this.aVr.aZH.getThumbnail_url(), 10, false);
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
            this.beh.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.beh.setGravity(3);
        } else if (j <= 65) {
            this.bef.setVisibility(8);
            this.bei.setVisibility(8);
            this.beb.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.beh.setGravity(19);
        } else if (j <= 187) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("66-1.json");
            this.bei.setVisibility(8);
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("188-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("188-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("520-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("520-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bef.setVisibility(0);
            this.bef.setAnimation("1314-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("1314-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bef.setVisibility(0);
            this.bef.setAnimation("9999-1.json");
            this.bei.setVisibility(0);
            this.bei.setAnimation("9999-2.json");
            this.beb.setBackgroundResource(a.c.sdk_transparent);
            this.beh.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.beh.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.beh.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bei.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.beh.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.beh.setLayoutParams(layoutParams);
            this.beh.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.beh.getLayoutParams();
            layoutParams2.width = -2;
            this.beh.setLayoutParams(layoutParams2);
            this.beh.setGravity(19);
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
                this.beh.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.beb.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.beh.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
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
            this.beh.setVisibility(8);
        } else {
            this.beh.setVisibility(0);
        }
        this.beh.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aVr;
    }

    public void i(long j, long j2) {
        Hc();
        Hd();
        if (j < 1) {
            this.beh.setVisibility(8);
        } else if (this.aVr != null) {
            this.aVr.aZN = j2;
            this.aVr.aZM = j;
            this.beh.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            He();
            GV();
        }
    }

    private void He() {
        this.beh.setVisibility(0);
        this.bdY.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVr.userId), this.aVr.userName, this.aVr.portrait, this.aVr.sex, this.aVr.aZJ, this.aVr.location, this.aVr.description, 0L, this.aVr.fansCount, this.aVr.followCount, this.aVr.userStatus, this.aVr.liveId, this.aVr.groupId, this.aVr.aZP, this.aVr.aZQ, this.aVr.appId, this.aVr.userName)));
        }
    }

    public void onDestroy() {
        Hb();
        if (this.beb != null) {
            this.beb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aVr != null && this.aVr.aZN < this.aVr.aZM) {
            if (this.aVr.aZN <= 0) {
                this.aVr.aZN = 1L;
            }
            this.beh.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aVr.aZN)));
            He();
            setDisplayStyle(this.aVr.aZN);
            GV();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bej = aVar;
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
