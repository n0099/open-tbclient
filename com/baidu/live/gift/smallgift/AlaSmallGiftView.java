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
    private ObjectAnimator aoK;
    private ObjectAnimator aoL;
    private ObjectAnimator aoM;
    private AnimatorSet aoN;
    private ObjectAnimator aoO;
    private ObjectAnimator aoP;
    private ObjectAnimator aoQ;
    private AnimatorSet aoR;
    private ObjectAnimator aoS;
    private ObjectAnimator aoT;
    private RelativeLayout aoU;
    private HeadImageView aoV;
    private TbImageView aoW;
    private LottieAnimationView aoX;
    private AlaGiftStrokeTextView aoY;
    private LottieAnimationView aoZ;
    private a apa;
    private int apb;
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
        this.aoU = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aoU.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aoV = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aoV.setIsRound(true);
        this.aoV.setAutoChangeStyle(false);
        this.aoV.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aoV.setOnClickListener(this);
        this.ahO = (TextView) findViewById(a.g.sender_name);
        this.ahO.setOnClickListener(this);
        this.aiY = (TextView) findViewById(a.g.gift_name);
        this.aoW = (TbImageView) findViewById(a.g.gift_icon);
        this.aoW.setAutoChangeStyle(false);
        this.aoW.setDefaultBgResource(a.d.sdk_transparent);
        this.aoW.setDefaultErrorResource(a.d.sdk_transparent);
        this.aoW.setGifIconSupport(false);
        this.aoY = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aoX = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aoX.loop(true);
        this.aoX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aoZ = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aoZ.loop(true);
        this.aoY.getPaint().setFakeBoldText(true);
        vh();
    }

    public void setMode(boolean z) {
        this.apb = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void vh() {
        this.aoL = ObjectAnimator.ofFloat(this.aoV, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aoL.setDuration(350L);
        this.aoL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
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
        this.aoO = ObjectAnimator.ofFloat(this.aoW, "ScaleX", 0.1f, 1.0f);
        this.aoP = ObjectAnimator.ofFloat(this.aoW, "ScaleY", 0.1f, 1.0f);
        this.aoN = new AnimatorSet();
        this.aoN.playTogether(this.aoO, this.aoP);
        this.aoN.setInterpolator(new OvershootInterpolator(4.0f));
        this.aoN.setDuration(400L);
        this.aoN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.apa != null) {
                    AlaSmallGiftView.this.apa.uf();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoQ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aoQ.setDuration(300L);
        this.aoQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.vp();
                AlaSmallGiftView.this.vq();
                if (AlaSmallGiftView.this.apa != null) {
                    AlaSmallGiftView.this.apa.N(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoS = ObjectAnimator.ofFloat(this.aoY, "ScaleX", 3.0f, 1.0f);
        this.aoT = ObjectAnimator.ofFloat(this.aoY, "ScaleY", 3.0f, 1.0f);
        this.aoR = new AnimatorSet();
        this.aoR.playTogether(this.aoS, this.aoT);
        this.aoR.setDuration(240L);
        this.aoR.setInterpolator(new OvershootInterpolator());
        this.aoR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.apa != null) {
                    AlaSmallGiftView.this.apa.ug();
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
        this.aoV.setVisibility(0);
        this.aoL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        this.aoW.setVisibility(0);
        this.aoN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        if (this.aoX != null && this.aoX.getVisibility() == 0) {
            this.aoX.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aoX.cancelAnimation();
                    AlaSmallGiftView.this.aoX.playAnimation();
                }
            });
        }
        if (this.aoZ != null && this.aoZ.getVisibility() == 0) {
            this.aoZ.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aoZ.cancelAnimation();
                    AlaSmallGiftView.this.aoZ.playAnimation();
                }
            });
        }
    }

    private void vl() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aoM = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aoM.setInterpolator(new OvershootInterpolator());
            this.aoM.setDuration(300L);
            this.aoM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
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
            this.aoK = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aoK.setInterpolator(new OvershootInterpolator());
            this.aoK.setDuration(300L);
        }
    }

    public void vn() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            vq();
            if (this.aoL != null) {
                this.aoL.cancel();
            }
            this.aoV.setVisibility(0);
            if (this.aoM == null) {
                vl();
            }
            this.aoM.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            vq();
            if (this.aoK == null) {
                vm();
            }
            this.aoK.start();
            vi();
        }
    }

    public void vo() {
        this.aoQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp() {
        this.aoW.setVisibility(8);
    }

    public void vq() {
        setTranslationY(0.0f);
        if (this.aoL != null) {
            this.aoL.cancel();
        }
        if (this.aoN != null) {
            this.aoN.cancel();
        }
        if (this.aoR != null) {
            this.aoR.cancel();
        }
        if (this.aoK != null) {
            this.aoK.cancel();
        }
        if (this.aoM != null) {
            this.aoM.cancel();
        }
        if (this.aoQ != null) {
            this.aoQ.cancel();
        }
        if (this.aoZ != null) {
            this.aoZ.cancelAnimation();
        }
        if (this.aoX != null) {
            this.aoX.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.alx != null) {
            this.ahQ = cVar;
            setGiftCnt(cVar.alC);
            du(cVar.userName);
            this.aiY.setText(cVar.alx.ry());
            vr();
            vs();
            if (z) {
                setDisplayStyle(cVar.alC);
            }
        }
    }

    private void vr() {
        if (this.ahQ != null) {
            this.aoV.setUrl(this.ahQ.portrait);
            k.a(this.aoV, this.ahQ.portrait, false, !StringUtils.isNull(this.ahQ.appId));
        }
    }

    private void vs() {
        if (this.ahQ != null && this.ahQ.alx != null) {
            this.aoW.setVisibility(0);
            this.aoW.startLoad(this.ahQ.alx.rA(), 10, false);
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
            this.aoX.setVisibility(8);
            this.aoZ.setVisibility(8);
            this.aoU.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aoY.setGravity(3);
        } else if (j <= 65) {
            this.aoX.setVisibility(8);
            this.aoZ.setVisibility(8);
            this.aoU.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aoY.setGravity(19);
        } else if (j <= 187) {
            this.aoX.setVisibility(0);
            this.aoX.setAnimation("66-1.json");
            this.aoZ.setVisibility(8);
            this.aoU.setBackgroundResource(a.d.sdk_transparent);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aoX.setVisibility(0);
            this.aoX.setAnimation("188-1.json");
            this.aoZ.setVisibility(0);
            this.aoZ.setAnimation("188-2.json");
            this.aoU.setBackgroundResource(a.d.sdk_transparent);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aoX.setVisibility(0);
            this.aoX.setAnimation("520-1.json");
            this.aoZ.setVisibility(0);
            this.aoZ.setAnimation("520-2.json");
            this.aoU.setBackgroundResource(a.d.sdk_transparent);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aoX.setVisibility(0);
            this.aoX.setAnimation("1314-1.json");
            this.aoZ.setVisibility(0);
            this.aoZ.setAnimation("1314-2.json");
            this.aoU.setBackgroundResource(a.d.sdk_transparent);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aoX.setVisibility(0);
            this.aoX.setAnimation("9999-1.json");
            this.aoZ.setVisibility(0);
            this.aoZ.setAnimation("9999-2.json");
            this.aoU.setBackgroundResource(a.d.sdk_transparent);
            this.aoY.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aoY.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aoY.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aoZ.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoY.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
            this.aoY.setLayoutParams(layoutParams);
            this.aoY.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aoY.getLayoutParams();
            layoutParams2.width = -2;
            this.aoY.setLayoutParams(layoutParams2);
            this.aoY.setGravity(19);
        }
        this.aoS.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aoT.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aoR.setDuration(840L);
        this.aoR.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aoR.getChildAnimations();
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
                if (this.apb > 0) {
                    this.aoU.setBackgroundResource(this.apb);
                } else {
                    this.aoU.setBackgroundResource(a.f.gray_circle);
                }
                this.aoY.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aoU.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aoY.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aoS.setFloatValues(3.0f, 1.0f);
                this.aoT.setFloatValues(3.0f, 1.0f);
                this.aoR.setDuration(240L);
                this.aoR.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aoS.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aoT.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aoR.setDuration(480L);
                this.aoR.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aoR.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aoY.setVisibility(8);
        } else {
            this.aoY.setVisibility(0);
        }
        this.aoY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.ahQ;
    }

    public void e(long j, long j2) {
        vr();
        vs();
        if (j < 1) {
            this.aoY.setVisibility(8);
        } else if (this.ahQ != null) {
            this.ahQ.alC = j2;
            this.ahQ.alB = j;
            this.aoY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            vt();
            vk();
        }
    }

    private void vt() {
        this.aoY.setVisibility(0);
        this.aoR.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.ahQ.userId), this.ahQ.userName, this.ahQ.portrait, this.ahQ.sex, this.ahQ.alz, this.ahQ.location, this.ahQ.description, 0L, this.ahQ.fansCount, this.ahQ.alA, this.ahQ.userStatus, this.ahQ.liveId, this.ahQ.groupId, this.ahQ.alD, this.ahQ.alE, this.ahQ.appId, this.ahQ.userName, "")));
        }
    }

    public void onDestroy() {
        vq();
        if (this.aoU != null) {
            this.aoU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ahQ != null && this.ahQ.alC < this.ahQ.alB) {
            if (this.ahQ.alC <= 0) {
                this.ahQ.alC = 1L;
            }
            this.aoY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.ahQ.alC)));
            vt();
            setDisplayStyle(this.ahQ.alC);
            vk();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.apa = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aoX != null && this.aoX.getVisibility() == 0) {
            int width = this.aoU.getWidth();
            int height = this.aoU.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aoX.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aoX.setLayoutParams(layoutParams);
        }
    }
}
