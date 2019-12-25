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
import com.baidu.live.q.a;
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
    private TextView aeX;
    private com.baidu.live.gift.a.b aeZ;
    private TextView agg;
    private ObjectAnimator alJ;
    private ObjectAnimator alK;
    private ObjectAnimator alL;
    private AnimatorSet alM;
    private ObjectAnimator alN;
    private ObjectAnimator alO;
    private ObjectAnimator alP;
    private AnimatorSet alQ;
    private ObjectAnimator alR;
    private ObjectAnimator alS;
    private RelativeLayout alT;
    private HeadImageView alU;
    private TbImageView alV;
    private LottieAnimationView alW;
    private AlaGiftStrokeTextView alX;
    private LottieAnimationView alY;
    private a alZ;
    private int ama;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void L(View view);

        void sD();

        void sE();
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
        this.alT = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.alT.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.alU = (HeadImageView) findViewById(a.g.sender_avatar);
        this.alU.setIsRound(true);
        this.alU.setAutoChangeStyle(false);
        this.alU.setDefaultBgResource(a.f.sdk_default_avatar);
        this.alU.setOnClickListener(this);
        this.aeX = (TextView) findViewById(a.g.sender_name);
        this.aeX.setOnClickListener(this);
        this.agg = (TextView) findViewById(a.g.gift_name);
        this.alV = (TbImageView) findViewById(a.g.gift_icon);
        this.alV.setAutoChangeStyle(false);
        this.alV.setDefaultBgResource(a.d.sdk_transparent);
        this.alV.setDefaultErrorResource(a.d.sdk_transparent);
        this.alV.setGifIconSupport(false);
        this.alX = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.alW = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.alW.loop(true);
        this.alW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.alY = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.alY.loop(true);
        this.alX.getPaint().setFakeBoldText(true);
        tz();
    }

    public void setMode(boolean z) {
        this.ama = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void tz() {
        this.alK = ObjectAnimator.ofFloat(this.alU, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.alK.setDuration(350L);
        this.alK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.tB();
                AlaSmallGiftView.this.tC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.alN = ObjectAnimator.ofFloat(this.alV, "ScaleX", 0.1f, 1.0f);
        this.alO = ObjectAnimator.ofFloat(this.alV, "ScaleY", 0.1f, 1.0f);
        this.alM = new AnimatorSet();
        this.alM.playTogether(this.alN, this.alO);
        this.alM.setInterpolator(new OvershootInterpolator(4.0f));
        this.alM.setDuration(400L);
        this.alM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.alZ != null) {
                    AlaSmallGiftView.this.alZ.sD();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.alP = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.alP.setDuration(300L);
        this.alP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.tH();
                AlaSmallGiftView.this.tI();
                if (AlaSmallGiftView.this.alZ != null) {
                    AlaSmallGiftView.this.alZ.L(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.alR = ObjectAnimator.ofFloat(this.alX, "ScaleX", 3.0f, 1.0f);
        this.alS = ObjectAnimator.ofFloat(this.alX, "ScaleY", 3.0f, 1.0f);
        this.alQ = new AnimatorSet();
        this.alQ.playTogether(this.alR, this.alS);
        this.alQ.setDuration(240L);
        this.alQ.setInterpolator(new OvershootInterpolator());
        this.alQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.alZ != null) {
                    AlaSmallGiftView.this.alZ.sE();
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

    private void tA() {
        this.alU.setVisibility(0);
        this.alK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB() {
        this.alV.setVisibility(0);
        this.alM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC() {
        if (this.alW != null && this.alW.getVisibility() == 0) {
            this.alW.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.alW.cancelAnimation();
                    AlaSmallGiftView.this.alW.playAnimation();
                }
            });
        }
        if (this.alY != null && this.alY.getVisibility() == 0) {
            this.alY.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.alY.cancelAnimation();
                    AlaSmallGiftView.this.alY.playAnimation();
                }
            });
        }
    }

    private void tD() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.alL = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.alL.setInterpolator(new OvershootInterpolator());
            this.alL.setDuration(300L);
            this.alL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.tB();
                    AlaSmallGiftView.this.tC();
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

    private void tE() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.alJ = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.alJ.setInterpolator(new OvershootInterpolator());
            this.alJ.setDuration(300L);
        }
    }

    public void tF() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            tI();
            if (this.alK != null) {
                this.alK.cancel();
            }
            this.alU.setVisibility(0);
            if (this.alL == null) {
                tD();
            }
            this.alL.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            tI();
            if (this.alJ == null) {
                tE();
            }
            this.alJ.start();
            tA();
        }
    }

    public void tG() {
        this.alP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        this.alV.setVisibility(8);
    }

    public void tI() {
        setTranslationY(0.0f);
        if (this.alK != null) {
            this.alK.cancel();
        }
        if (this.alM != null) {
            this.alM.cancel();
        }
        if (this.alQ != null) {
            this.alQ.cancel();
        }
        if (this.alJ != null) {
            this.alJ.cancel();
        }
        if (this.alL != null) {
            this.alL.cancel();
        }
        if (this.alP != null) {
            this.alP.cancel();
        }
        if (this.alY != null) {
            this.alY.cancelAnimation();
        }
        if (this.alW != null) {
            this.alW.cancelAnimation();
        }
    }

    public void setData(com.baidu.live.gift.a.b bVar) {
        setData(bVar, true);
    }

    public void setData(com.baidu.live.gift.a.b bVar, boolean z) {
        if (bVar != null && bVar.aiC != null) {
            this.aeZ = bVar;
            setGiftCnt(bVar.aiI);
            dh(bVar.userName);
            this.agg.setText(bVar.aiC.qy());
            tJ();
            tK();
            if (z) {
                setDisplayStyle(bVar.aiI);
            }
        }
    }

    private void tJ() {
        if (this.aeZ != null) {
            this.alU.setUrl(this.aeZ.portrait);
            k.a(this.alU, this.aeZ.portrait, false, !StringUtils.isNull(this.aeZ.appId));
        }
    }

    private void tK() {
        if (this.aeZ != null && this.aeZ.aiC != null) {
            this.alV.setVisibility(0);
            this.alV.startLoad(this.aeZ.aiC.qA(), 10, false);
        }
    }

    private void dh(String str) {
        this.aeX.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aeX.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.alW.setVisibility(8);
            this.alY.setVisibility(8);
            this.alT.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.alX.setGravity(3);
        } else if (j <= 65) {
            this.alW.setVisibility(8);
            this.alY.setVisibility(8);
            this.alT.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.alX.setGravity(19);
        } else if (j <= 187) {
            this.alW.setVisibility(0);
            this.alW.setAnimation("66-1.json");
            this.alY.setVisibility(8);
            this.alT.setBackgroundResource(a.d.sdk_transparent);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.alX.setGravity(19);
        } else if (j <= 519) {
            this.alW.setVisibility(0);
            this.alW.setAnimation("188-1.json");
            this.alY.setVisibility(0);
            this.alY.setAnimation("188-2.json");
            this.alT.setBackgroundResource(a.d.sdk_transparent);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.alX.setGravity(19);
        } else if (j <= 1313) {
            this.alW.setVisibility(0);
            this.alW.setAnimation("520-1.json");
            this.alY.setVisibility(0);
            this.alY.setAnimation("520-2.json");
            this.alT.setBackgroundResource(a.d.sdk_transparent);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.alW.setVisibility(0);
            this.alW.setAnimation("1314-1.json");
            this.alY.setVisibility(0);
            this.alY.setAnimation("1314-2.json");
            this.alT.setBackgroundResource(a.d.sdk_transparent);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.alW.setVisibility(0);
            this.alW.setAnimation("9999-1.json");
            this.alY.setVisibility(0);
            this.alY.setAnimation("9999-2.json");
            this.alT.setBackgroundResource(a.d.sdk_transparent);
            this.alX.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.alX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.alX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        this.alR.setFloatValues(1.0f, 1.5f, 1.0f);
        this.alS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.alQ.setDuration(840L);
        this.alQ.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.alQ.getChildAnimations();
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
                if (this.ama > 0) {
                    this.alT.setBackgroundResource(this.ama);
                } else {
                    this.alT.setBackgroundResource(a.f.gray_circle);
                }
                this.alX.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.alT.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.alX.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.alR.setFloatValues(3.0f, 1.0f);
                this.alS.setFloatValues(3.0f, 1.0f);
                this.alQ.setDuration(240L);
                this.alQ.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.alR.setFloatValues(1.0f, 1.5f, 1.0f);
                this.alS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.alQ.setDuration(480L);
                this.alQ.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.alQ.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.alX.setVisibility(8);
        } else {
            this.alX.setVisibility(0);
        }
        this.alX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public com.baidu.live.gift.a.b getCurGiftData() {
        return this.aeZ;
    }

    public void e(long j, long j2) {
        tJ();
        tK();
        if (j < 1) {
            this.alX.setVisibility(8);
        } else if (this.aeZ != null) {
            this.aeZ.aiI = j2;
            this.aeZ.aiH = j;
            this.alX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            tL();
            tC();
        }
    }

    private void tL() {
        this.alX.setVisibility(0);
        this.alQ.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aeZ.userId), this.aeZ.userName, this.aeZ.portrait, this.aeZ.sex, this.aeZ.aiE, this.aeZ.location, this.aeZ.description, 0L, this.aeZ.aiG, this.aeZ.aiF, this.aeZ.userStatus, this.aeZ.liveId, this.aeZ.groupId, this.aeZ.aiJ, this.aeZ.aiK, this.aeZ.appId, this.aeZ.userName, "")));
        }
    }

    public void onDestroy() {
        tI();
        if (this.alT != null) {
            this.alT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aeZ != null && this.aeZ.aiI < this.aeZ.aiH) {
            if (this.aeZ.aiI <= 0) {
                this.aeZ.aiI = 1L;
            }
            this.alX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aeZ.aiI)));
            tL();
            setDisplayStyle(this.aeZ.aiI);
            tC();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.alZ = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.alW != null && this.alW.getVisibility() == 0) {
            int width = this.alT.getWidth();
            int height = this.alT.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alW.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.alW.setLayoutParams(layoutParams);
        }
    }
}
