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
/* loaded from: classes3.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView aIn;
    private c aIp;
    private TextView aJC;
    private ObjectAnimator aPJ;
    private ObjectAnimator aPK;
    private ObjectAnimator aPL;
    private AnimatorSet aPM;
    private ObjectAnimator aPN;
    private ObjectAnimator aPO;
    private ObjectAnimator aPP;
    private AnimatorSet aPQ;
    private ObjectAnimator aPR;
    private ObjectAnimator aPS;
    private RelativeLayout aPT;
    private HeadImageView aPU;
    private TbImageView aPV;
    private LottieAnimationView aPW;
    private AlaGiftStrokeTextView aPX;
    private LottieAnimationView aPY;
    private a aPZ;
    private int aQa;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void At();

        void Au();

        void O(View view);
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
        this.aPT = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aPT.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aPU = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aPU.setIsRound(true);
        this.aPU.setAutoChangeStyle(false);
        this.aPU.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aPU.setOnClickListener(this);
        this.aIn = (TextView) findViewById(a.g.sender_name);
        this.aIn.setOnClickListener(this);
        this.aJC = (TextView) findViewById(a.g.gift_name);
        this.aPV = (TbImageView) findViewById(a.g.gift_icon);
        this.aPV.setAutoChangeStyle(false);
        this.aPV.setDefaultBgResource(a.d.sdk_transparent);
        this.aPV.setDefaultErrorResource(a.d.sdk_transparent);
        this.aPV.setGifIconSupport(false);
        this.aPX = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aPW = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aPW.loop(true);
        this.aPW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aPY = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aPY.loop(true);
        this.aPX.getPaint().setFakeBoldText(true);
        Bz();
    }

    public void setMode(boolean z) {
        this.aQa = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void Bz() {
        this.aPK = ObjectAnimator.ofFloat(this.aPU, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aPK.setDuration(350L);
        this.aPK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.BB();
                AlaSmallGiftView.this.BC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aPN = ObjectAnimator.ofFloat(this.aPV, "ScaleX", 0.1f, 1.0f);
        this.aPO = ObjectAnimator.ofFloat(this.aPV, "ScaleY", 0.1f, 1.0f);
        this.aPM = new AnimatorSet();
        this.aPM.playTogether(this.aPN, this.aPO);
        this.aPM.setInterpolator(new OvershootInterpolator(4.0f));
        this.aPM.setDuration(400L);
        this.aPM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aPZ != null) {
                    AlaSmallGiftView.this.aPZ.At();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aPP = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aPP.setDuration(300L);
        this.aPP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.BH();
                AlaSmallGiftView.this.BI();
                if (AlaSmallGiftView.this.aPZ != null) {
                    AlaSmallGiftView.this.aPZ.O(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aPR = ObjectAnimator.ofFloat(this.aPX, "ScaleX", 3.0f, 1.0f);
        this.aPS = ObjectAnimator.ofFloat(this.aPX, "ScaleY", 3.0f, 1.0f);
        this.aPQ = new AnimatorSet();
        this.aPQ.playTogether(this.aPR, this.aPS);
        this.aPQ.setDuration(240L);
        this.aPQ.setInterpolator(new OvershootInterpolator());
        this.aPQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aPZ != null) {
                    AlaSmallGiftView.this.aPZ.Au();
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

    private void BA() {
        this.aPU.setVisibility(0);
        this.aPK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BB() {
        this.aPV.setVisibility(0);
        this.aPM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        if (this.aPW != null && this.aPW.getVisibility() == 0) {
            this.aPW.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aPW.cancelAnimation();
                    AlaSmallGiftView.this.aPW.playAnimation();
                }
            });
        }
        if (this.aPY != null && this.aPY.getVisibility() == 0) {
            this.aPY.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aPY.cancelAnimation();
                    AlaSmallGiftView.this.aPY.playAnimation();
                }
            });
        }
    }

    private void BD() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aPL = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aPL.setInterpolator(new OvershootInterpolator());
            this.aPL.setDuration(300L);
            this.aPL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.BB();
                    AlaSmallGiftView.this.BC();
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

    private void BE() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aPJ = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aPJ.setInterpolator(new OvershootInterpolator());
            this.aPJ.setDuration(300L);
        }
    }

    public void BF() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            BI();
            if (this.aPK != null) {
                this.aPK.cancel();
            }
            this.aPU.setVisibility(0);
            if (this.aPL == null) {
                BD();
            }
            this.aPL.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            BI();
            if (this.aPJ == null) {
                BE();
            }
            this.aPJ.start();
            BA();
        }
    }

    public void BG() {
        this.aPP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        this.aPV.setVisibility(8);
    }

    public void BI() {
        setTranslationY(0.0f);
        if (this.aPK != null) {
            this.aPK.cancel();
        }
        if (this.aPM != null) {
            this.aPM.cancel();
        }
        if (this.aPQ != null) {
            this.aPQ.cancel();
        }
        if (this.aPJ != null) {
            this.aPJ.cancel();
        }
        if (this.aPL != null) {
            this.aPL.cancel();
        }
        if (this.aPP != null) {
            this.aPP.cancel();
        }
        if (this.aPY != null) {
            this.aPY.cancelAnimation();
        }
        if (this.aPW != null) {
            this.aPW.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aMi != null) {
            this.aIp = cVar;
            setGiftCnt(cVar.aMn);
            fa(cVar.userName);
            this.aJC.setText(cVar.aMi.xN());
            BJ();
            BK();
            if (z) {
                setDisplayStyle(cVar.aMn);
            }
        }
    }

    private void BJ() {
        if (this.aIp != null) {
            this.aPU.setUrl(this.aIp.portrait);
            k.a(this.aPU, this.aIp.portrait, false, !StringUtils.isNull(this.aIp.appId));
        }
    }

    private void BK() {
        if (this.aIp != null && this.aIp.aMi != null) {
            this.aPV.setVisibility(0);
            this.aPV.startLoad(this.aIp.aMi.getThumbnail_url(), 10, false);
        }
    }

    private void fa(String str) {
        this.aIn.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aIn.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aPW.setVisibility(8);
            this.aPY.setVisibility(8);
            this.aPT.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aPX.setGravity(3);
        } else if (j <= 65) {
            this.aPW.setVisibility(8);
            this.aPY.setVisibility(8);
            this.aPT.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aPX.setGravity(19);
        } else if (j <= 187) {
            this.aPW.setVisibility(0);
            this.aPW.setAnimation("66-1.json");
            this.aPY.setVisibility(8);
            this.aPT.setBackgroundResource(a.d.sdk_transparent);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aPW.setVisibility(0);
            this.aPW.setAnimation("188-1.json");
            this.aPY.setVisibility(0);
            this.aPY.setAnimation("188-2.json");
            this.aPT.setBackgroundResource(a.d.sdk_transparent);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aPW.setVisibility(0);
            this.aPW.setAnimation("520-1.json");
            this.aPY.setVisibility(0);
            this.aPY.setAnimation("520-2.json");
            this.aPT.setBackgroundResource(a.d.sdk_transparent);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aPW.setVisibility(0);
            this.aPW.setAnimation("1314-1.json");
            this.aPY.setVisibility(0);
            this.aPY.setAnimation("1314-2.json");
            this.aPT.setBackgroundResource(a.d.sdk_transparent);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aPW.setVisibility(0);
            this.aPW.setAnimation("9999-1.json");
            this.aPY.setVisibility(0);
            this.aPY.setAnimation("9999-2.json");
            this.aPT.setBackgroundResource(a.d.sdk_transparent);
            this.aPX.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aPX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aPX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aPY.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aPX.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aPX.setLayoutParams(layoutParams);
            this.aPX.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aPX.getLayoutParams();
            layoutParams2.width = -2;
            this.aPX.setLayoutParams(layoutParams2);
            this.aPX.setGravity(19);
        }
        this.aPR.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aPS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aPQ.setDuration(840L);
        this.aPQ.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aPQ.getChildAnimations();
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
                if (this.aQa > 0) {
                    this.aPT.setBackgroundResource(this.aQa);
                } else {
                    this.aPT.setBackgroundResource(a.f.gray_circle);
                }
                this.aPX.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aPT.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aPX.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aPR.setFloatValues(3.0f, 1.0f);
                this.aPS.setFloatValues(3.0f, 1.0f);
                this.aPQ.setDuration(240L);
                this.aPQ.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aPR.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aPS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aPQ.setDuration(480L);
                this.aPQ.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aPQ.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aPX.setVisibility(8);
        } else {
            this.aPX.setVisibility(0);
        }
        this.aPX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aIp;
    }

    public void f(long j, long j2) {
        BJ();
        BK();
        if (j < 1) {
            this.aPX.setVisibility(8);
        } else if (this.aIp != null) {
            this.aIp.aMn = j2;
            this.aIp.aMm = j;
            this.aPX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            BL();
            BC();
        }
    }

    private void BL() {
        this.aPX.setVisibility(0);
        this.aPQ.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aIp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aIp.userId), this.aIp.userName, this.aIp.portrait, this.aIp.sex, this.aIp.aMk, this.aIp.location, this.aIp.description, 0L, this.aIp.fansCount, this.aIp.aMl, this.aIp.userStatus, this.aIp.liveId, this.aIp.groupId, this.aIp.aMo, this.aIp.aMp, this.aIp.appId, this.aIp.userName, "")));
        }
    }

    public void onDestroy() {
        BI();
        if (this.aPT != null) {
            this.aPT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aIp != null && this.aIp.aMn < this.aIp.aMm) {
            if (this.aIp.aMn <= 0) {
                this.aIp.aMn = 1L;
            }
            this.aPX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aIp.aMn)));
            BL();
            setDisplayStyle(this.aIp.aMn);
            BC();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aPZ = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aPW != null && this.aPW.getVisibility() == 0) {
            int width = this.aPT.getWidth();
            int height = this.aPT.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aPW.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aPW.setLayoutParams(layoutParams);
        }
    }
}
