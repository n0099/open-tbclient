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
    private TextView aQY;
    private c aRa;
    private TextView aSp;
    private ObjectAnimator aYL;
    private ObjectAnimator aYM;
    private ObjectAnimator aYN;
    private AnimatorSet aYO;
    private ObjectAnimator aYP;
    private ObjectAnimator aYQ;
    private ObjectAnimator aYR;
    private AnimatorSet aYS;
    private ObjectAnimator aYT;
    private ObjectAnimator aYU;
    private RelativeLayout aYV;
    private HeadImageView aYW;
    private TbImageView aYX;
    private LottieAnimationView aYY;
    private AlaGiftStrokeTextView aYZ;
    private LottieAnimationView aZa;
    private a aZb;
    private int aZc;
    private Context mContext;

    /* loaded from: classes4.dex */
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
        LayoutInflater.from(getContext()).inflate(a.h.popup_gift_layout, this);
        this.aYV = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aYV.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aYW = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aYW.setIsRound(true);
        this.aYW.setAutoChangeStyle(false);
        this.aYW.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aYW.setOnClickListener(this);
        this.aQY = (TextView) findViewById(a.g.sender_name);
        this.aQY.setOnClickListener(this);
        this.aSp = (TextView) findViewById(a.g.gift_name);
        this.aYX = (TbImageView) findViewById(a.g.gift_icon);
        this.aYX.setAutoChangeStyle(false);
        this.aYX.setDefaultBgResource(a.d.sdk_transparent);
        this.aYX.setDefaultErrorResource(a.d.sdk_transparent);
        this.aYX.setGifIconSupport(false);
        this.aYZ = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aYY = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aYY.loop(true);
        this.aYY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aZa = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aZa.loop(true);
        this.aYZ.getPaint().setFakeBoldText(true);
        Ig();
    }

    public void setMode(boolean z) {
        this.aZc = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void Ig() {
        this.aYM = ObjectAnimator.ofFloat(this.aYW, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aYM.setDuration(350L);
        this.aYM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Ii();
                AlaSmallGiftView.this.Ij();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aYP = ObjectAnimator.ofFloat(this.aYX, "ScaleX", 0.1f, 1.0f);
        this.aYQ = ObjectAnimator.ofFloat(this.aYX, "ScaleY", 0.1f, 1.0f);
        this.aYO = new AnimatorSet();
        this.aYO.playTogether(this.aYP, this.aYQ);
        this.aYO.setInterpolator(new OvershootInterpolator(4.0f));
        this.aYO.setDuration(400L);
        this.aYO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aZb != null) {
                    AlaSmallGiftView.this.aZb.GZ();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aYR = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aYR.setDuration(300L);
        this.aYR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Io();
                AlaSmallGiftView.this.Ip();
                if (AlaSmallGiftView.this.aZb != null) {
                    AlaSmallGiftView.this.aZb.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aYT = ObjectAnimator.ofFloat(this.aYZ, "ScaleX", 3.0f, 1.0f);
        this.aYU = ObjectAnimator.ofFloat(this.aYZ, "ScaleY", 3.0f, 1.0f);
        this.aYS = new AnimatorSet();
        this.aYS.playTogether(this.aYT, this.aYU);
        this.aYS.setDuration(240L);
        this.aYS.setInterpolator(new OvershootInterpolator());
        this.aYS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aZb != null) {
                    AlaSmallGiftView.this.aZb.Ha();
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

    private void Ih() {
        this.aYW.setVisibility(0);
        this.aYM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        this.aYX.setVisibility(0);
        this.aYO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij() {
        if (this.aYY != null && this.aYY.getVisibility() == 0) {
            this.aYY.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aYY.cancelAnimation();
                    AlaSmallGiftView.this.aYY.playAnimation();
                }
            });
        }
        if (this.aZa != null && this.aZa.getVisibility() == 0) {
            this.aZa.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aZa.cancelAnimation();
                    AlaSmallGiftView.this.aZa.playAnimation();
                }
            });
        }
    }

    private void Ik() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aYN = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aYN.setInterpolator(new OvershootInterpolator());
            this.aYN.setDuration(300L);
            this.aYN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Ii();
                    AlaSmallGiftView.this.Ij();
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

    private void Il() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aYL = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aYL.setInterpolator(new OvershootInterpolator());
            this.aYL.setDuration(300L);
        }
    }

    public void Im() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Ip();
            if (this.aYM != null) {
                this.aYM.cancel();
            }
            this.aYW.setVisibility(0);
            if (this.aYN == null) {
                Ik();
            }
            this.aYN.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Ip();
            if (this.aYL == null) {
                Il();
            }
            this.aYL.start();
            Ih();
        }
    }

    public void In() {
        this.aYR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        this.aYX.setVisibility(8);
    }

    public void Ip() {
        setTranslationY(0.0f);
        if (this.aYM != null) {
            this.aYM.cancel();
        }
        if (this.aYO != null) {
            this.aYO.cancel();
        }
        if (this.aYS != null) {
            this.aYS.cancel();
        }
        if (this.aYL != null) {
            this.aYL.cancel();
        }
        if (this.aYN != null) {
            this.aYN.cancel();
        }
        if (this.aYR != null) {
            this.aYR.cancel();
        }
        if (this.aZa != null) {
            this.aZa.cancelAnimation();
        }
        if (this.aYY != null) {
            this.aYY.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aVd != null) {
            this.aRa = cVar;
            setGiftCnt(cVar.aVj);
            gF(cVar.userName);
            this.aSp.setText(cVar.aVd.Ei());
            Iq();
            Ir();
            if (z) {
                setDisplayStyle(cVar.aVj);
            }
        }
    }

    private void Iq() {
        if (this.aRa != null) {
            this.aYW.setUrl(this.aRa.portrait);
            l.a(this.aYW, this.aRa.portrait, false, !StringUtils.isNull(this.aRa.appId));
        }
    }

    private void Ir() {
        if (this.aRa != null && this.aRa.aVd != null) {
            this.aYX.setVisibility(0);
            this.aYX.startLoad(this.aRa.aVd.getThumbnail_url(), 10, false);
        }
    }

    private void gF(String str) {
        this.aQY.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aQY.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aYY.setVisibility(8);
            this.aZa.setVisibility(8);
            this.aYV.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aYZ.setGravity(3);
        } else if (j <= 65) {
            this.aYY.setVisibility(8);
            this.aZa.setVisibility(8);
            this.aYV.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aYZ.setGravity(19);
        } else if (j <= 187) {
            this.aYY.setVisibility(0);
            this.aYY.setAnimation("66-1.json");
            this.aZa.setVisibility(8);
            this.aYV.setBackgroundResource(a.d.sdk_transparent);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aYY.setVisibility(0);
            this.aYY.setAnimation("188-1.json");
            this.aZa.setVisibility(0);
            this.aZa.setAnimation("188-2.json");
            this.aYV.setBackgroundResource(a.d.sdk_transparent);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aYY.setVisibility(0);
            this.aYY.setAnimation("520-1.json");
            this.aZa.setVisibility(0);
            this.aZa.setAnimation("520-2.json");
            this.aYV.setBackgroundResource(a.d.sdk_transparent);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aYY.setVisibility(0);
            this.aYY.setAnimation("1314-1.json");
            this.aZa.setVisibility(0);
            this.aZa.setAnimation("1314-2.json");
            this.aYV.setBackgroundResource(a.d.sdk_transparent);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aYY.setVisibility(0);
            this.aYY.setAnimation("9999-1.json");
            this.aZa.setVisibility(0);
            this.aZa.setAnimation("9999-2.json");
            this.aYV.setBackgroundResource(a.d.sdk_transparent);
            this.aYZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aYZ.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aYZ.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aZa.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYZ.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aYZ.setLayoutParams(layoutParams);
            this.aYZ.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aYZ.getLayoutParams();
            layoutParams2.width = -2;
            this.aYZ.setLayoutParams(layoutParams2);
            this.aYZ.setGravity(19);
        }
        this.aYT.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aYU.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aYS.setDuration(840L);
        this.aYS.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aYS.getChildAnimations();
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
                if (this.aZc > 0) {
                    this.aYV.setBackgroundResource(this.aZc);
                } else {
                    this.aYV.setBackgroundResource(a.f.gray_circle);
                }
                this.aYZ.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aYV.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aYZ.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aYT.setFloatValues(3.0f, 1.0f);
                this.aYU.setFloatValues(3.0f, 1.0f);
                this.aYS.setDuration(240L);
                this.aYS.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aYT.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aYU.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aYS.setDuration(480L);
                this.aYS.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aYS.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aYZ.setVisibility(8);
        } else {
            this.aYZ.setVisibility(0);
        }
        this.aYZ.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aRa;
    }

    public void f(long j, long j2) {
        Iq();
        Ir();
        if (j < 1) {
            this.aYZ.setVisibility(8);
        } else if (this.aRa != null) {
            this.aRa.aVj = j2;
            this.aRa.aVi = j;
            this.aYZ.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Is();
            Ij();
        }
    }

    private void Is() {
        this.aYZ.setVisibility(0);
        this.aYS.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aRa.userId), this.aRa.userName, this.aRa.portrait, this.aRa.sex, this.aRa.aVf, this.aRa.location, this.aRa.description, 0L, this.aRa.fansCount, this.aRa.aVg, this.aRa.userStatus, this.aRa.liveId, this.aRa.groupId, this.aRa.aVk, this.aRa.aVl, this.aRa.appId, this.aRa.userName, "")));
        }
    }

    public void onDestroy() {
        Ip();
        if (this.aYV != null) {
            this.aYV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aRa != null && this.aRa.aVj < this.aRa.aVi) {
            if (this.aRa.aVj <= 0) {
                this.aRa.aVj = 1L;
            }
            this.aYZ.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aRa.aVj)));
            Is();
            setDisplayStyle(this.aRa.aVj);
            Ij();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aZb = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aYY != null && this.aYY.getVisibility() == 0) {
            int width = this.aYV.getWidth();
            int height = this.aYV.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYY.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aYY.setLayoutParams(layoutParams);
        }
    }
}
