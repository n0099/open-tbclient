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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView ahO;
    private c ahQ;
    private TextView aiY;
    private ObjectAnimator aoJ;
    private ObjectAnimator aoK;
    private ObjectAnimator aoL;
    private AnimatorSet aoM;
    private ObjectAnimator aoN;
    private ObjectAnimator aoO;
    private ObjectAnimator aoP;
    private AnimatorSet aoQ;
    private ObjectAnimator aoR;
    private ObjectAnimator aoS;
    private RelativeLayout aoT;
    private HeadImageView aoU;
    private TbImageView aoV;
    private LottieAnimationView aoW;
    private AlaGiftStrokeTextView aoX;
    private LottieAnimationView aoY;
    private a aoZ;
    private int apa;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void N(View view);

        void uf();

        void ug();
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
        this.aoT = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aoT.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aoU = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aoU.setIsRound(true);
        this.aoU.setAutoChangeStyle(false);
        this.aoU.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aoU.setOnClickListener(this);
        this.ahO = (TextView) findViewById(a.g.sender_name);
        this.ahO.setOnClickListener(this);
        this.aiY = (TextView) findViewById(a.g.gift_name);
        this.aoV = (TbImageView) findViewById(a.g.gift_icon);
        this.aoV.setAutoChangeStyle(false);
        this.aoV.setDefaultBgResource(a.d.sdk_transparent);
        this.aoV.setDefaultErrorResource(a.d.sdk_transparent);
        this.aoV.setGifIconSupport(false);
        this.aoX = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aoW = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aoW.loop(true);
        this.aoW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aoY = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aoY.loop(true);
        this.aoX.getPaint().setFakeBoldText(true);
        vh();
    }

    public void setMode(boolean z) {
        this.apa = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void vh() {
        this.aoK = ObjectAnimator.ofFloat(this.aoU, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aoK.setDuration(350L);
        this.aoK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.vj();
                AlaSmallGiftView.this.vk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoN = ObjectAnimator.ofFloat(this.aoV, "ScaleX", 0.1f, 1.0f);
        this.aoO = ObjectAnimator.ofFloat(this.aoV, "ScaleY", 0.1f, 1.0f);
        this.aoM = new AnimatorSet();
        this.aoM.playTogether(this.aoN, this.aoO);
        this.aoM.setInterpolator(new OvershootInterpolator(4.0f));
        this.aoM.setDuration(400L);
        this.aoM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aoZ != null) {
                    AlaSmallGiftView.this.aoZ.uf();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoP = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aoP.setDuration(300L);
        this.aoP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.vp();
                AlaSmallGiftView.this.vq();
                if (AlaSmallGiftView.this.aoZ != null) {
                    AlaSmallGiftView.this.aoZ.N(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoR = ObjectAnimator.ofFloat(this.aoX, "ScaleX", 3.0f, 1.0f);
        this.aoS = ObjectAnimator.ofFloat(this.aoX, "ScaleY", 3.0f, 1.0f);
        this.aoQ = new AnimatorSet();
        this.aoQ.playTogether(this.aoR, this.aoS);
        this.aoQ.setDuration(240L);
        this.aoQ.setInterpolator(new OvershootInterpolator());
        this.aoQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aoZ != null) {
                    AlaSmallGiftView.this.aoZ.ug();
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

    private void vi() {
        this.aoU.setVisibility(0);
        this.aoK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        this.aoV.setVisibility(0);
        this.aoM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        if (this.aoW != null && this.aoW.getVisibility() == 0) {
            this.aoW.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aoW.cancelAnimation();
                    AlaSmallGiftView.this.aoW.playAnimation();
                }
            });
        }
        if (this.aoY != null && this.aoY.getVisibility() == 0) {
            this.aoY.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aoY.cancelAnimation();
                    AlaSmallGiftView.this.aoY.playAnimation();
                }
            });
        }
    }

    private void vl() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aoL = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aoL.setInterpolator(new OvershootInterpolator());
            this.aoL.setDuration(300L);
            this.aoL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.vj();
                    AlaSmallGiftView.this.vk();
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

    private void vm() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aoJ = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aoJ.setInterpolator(new OvershootInterpolator());
            this.aoJ.setDuration(300L);
        }
    }

    public void vn() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            vq();
            if (this.aoK != null) {
                this.aoK.cancel();
            }
            this.aoU.setVisibility(0);
            if (this.aoL == null) {
                vl();
            }
            this.aoL.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            vq();
            if (this.aoJ == null) {
                vm();
            }
            this.aoJ.start();
            vi();
        }
    }

    public void vo() {
        this.aoP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp() {
        this.aoV.setVisibility(8);
    }

    public void vq() {
        setTranslationY(0.0f);
        if (this.aoK != null) {
            this.aoK.cancel();
        }
        if (this.aoM != null) {
            this.aoM.cancel();
        }
        if (this.aoQ != null) {
            this.aoQ.cancel();
        }
        if (this.aoJ != null) {
            this.aoJ.cancel();
        }
        if (this.aoL != null) {
            this.aoL.cancel();
        }
        if (this.aoP != null) {
            this.aoP.cancel();
        }
        if (this.aoY != null) {
            this.aoY.cancelAnimation();
        }
        if (this.aoW != null) {
            this.aoW.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.alw != null) {
            this.ahQ = cVar;
            setGiftCnt(cVar.alB);
            du(cVar.userName);
            this.aiY.setText(cVar.alw.ry());
            vr();
            vs();
            if (z) {
                setDisplayStyle(cVar.alB);
            }
        }
    }

    private void vr() {
        if (this.ahQ != null) {
            this.aoU.setUrl(this.ahQ.portrait);
            k.a(this.aoU, this.ahQ.portrait, false, !StringUtils.isNull(this.ahQ.appId));
        }
    }

    private void vs() {
        if (this.ahQ != null && this.ahQ.alw != null) {
            this.aoV.setVisibility(0);
            this.aoV.startLoad(this.ahQ.alw.rA(), 10, false);
        }
    }

    private void du(String str) {
        this.ahO.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.ahO.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aoW.setVisibility(8);
            this.aoY.setVisibility(8);
            this.aoT.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aoX.setGravity(3);
        } else if (j <= 65) {
            this.aoW.setVisibility(8);
            this.aoY.setVisibility(8);
            this.aoT.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aoX.setGravity(19);
        } else if (j <= 187) {
            this.aoW.setVisibility(0);
            this.aoW.setAnimation("66-1.json");
            this.aoY.setVisibility(8);
            this.aoT.setBackgroundResource(a.d.sdk_transparent);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aoW.setVisibility(0);
            this.aoW.setAnimation("188-1.json");
            this.aoY.setVisibility(0);
            this.aoY.setAnimation("188-2.json");
            this.aoT.setBackgroundResource(a.d.sdk_transparent);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aoW.setVisibility(0);
            this.aoW.setAnimation("520-1.json");
            this.aoY.setVisibility(0);
            this.aoY.setAnimation("520-2.json");
            this.aoT.setBackgroundResource(a.d.sdk_transparent);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aoW.setVisibility(0);
            this.aoW.setAnimation("1314-1.json");
            this.aoY.setVisibility(0);
            this.aoY.setAnimation("1314-2.json");
            this.aoT.setBackgroundResource(a.d.sdk_transparent);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aoW.setVisibility(0);
            this.aoW.setAnimation("9999-1.json");
            this.aoY.setVisibility(0);
            this.aoY.setAnimation("9999-2.json");
            this.aoT.setBackgroundResource(a.d.sdk_transparent);
            this.aoX.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aoX.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoX.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aoY.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoX.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
            this.aoX.setLayoutParams(layoutParams);
            this.aoX.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aoX.getLayoutParams();
            layoutParams2.width = -2;
            this.aoX.setLayoutParams(layoutParams2);
            this.aoX.setGravity(19);
        }
        this.aoR.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aoS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aoQ.setDuration(840L);
        this.aoQ.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aoQ.getChildAnimations();
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
                if (this.apa > 0) {
                    this.aoT.setBackgroundResource(this.apa);
                } else {
                    this.aoT.setBackgroundResource(a.f.gray_circle);
                }
                this.aoX.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aoT.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aoX.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aoR.setFloatValues(3.0f, 1.0f);
                this.aoS.setFloatValues(3.0f, 1.0f);
                this.aoQ.setDuration(240L);
                this.aoQ.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aoR.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aoS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aoQ.setDuration(480L);
                this.aoQ.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aoQ.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aoX.setVisibility(8);
        } else {
            this.aoX.setVisibility(0);
        }
        this.aoX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.ahQ;
    }

    public void e(long j, long j2) {
        vr();
        vs();
        if (j < 1) {
            this.aoX.setVisibility(8);
        } else if (this.ahQ != null) {
            this.ahQ.alB = j2;
            this.ahQ.alA = j;
            this.aoX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            vt();
            vk();
        }
    }

    private void vt() {
        this.aoX.setVisibility(0);
        this.aoQ.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.ahQ.userId), this.ahQ.userName, this.ahQ.portrait, this.ahQ.sex, this.ahQ.aly, this.ahQ.location, this.ahQ.description, 0L, this.ahQ.fansCount, this.ahQ.alz, this.ahQ.userStatus, this.ahQ.liveId, this.ahQ.groupId, this.ahQ.alC, this.ahQ.alD, this.ahQ.appId, this.ahQ.userName, "")));
        }
    }

    public void onDestroy() {
        vq();
        if (this.aoT != null) {
            this.aoT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ahQ != null && this.ahQ.alB < this.ahQ.alA) {
            if (this.ahQ.alB <= 0) {
                this.ahQ.alB = 1L;
            }
            this.aoX.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.ahQ.alB)));
            vt();
            setDisplayStyle(this.ahQ.alB);
            vk();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aoZ = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aoW != null && this.aoW.getVisibility() == 0) {
            int width = this.aoT.getWidth();
            int height = this.aoT.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoW.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aoW.setLayoutParams(layoutParams);
        }
    }
}
