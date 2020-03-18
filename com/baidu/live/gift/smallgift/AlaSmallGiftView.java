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
    private TextView ahY;
    private c aia;
    private TextView aji;
    private ObjectAnimator aoU;
    private ObjectAnimator aoV;
    private ObjectAnimator aoW;
    private AnimatorSet aoX;
    private ObjectAnimator aoY;
    private ObjectAnimator aoZ;
    private ObjectAnimator apa;
    private AnimatorSet apb;
    private ObjectAnimator apc;
    private ObjectAnimator apd;
    private RelativeLayout ape;
    private HeadImageView apf;
    private TbImageView apg;
    private LottieAnimationView aph;
    private AlaGiftStrokeTextView api;
    private LottieAnimationView apj;
    private a apk;
    private int apl;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void N(View view);

        void uk();

        void ul();
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
        this.ape = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.ape.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.apf = (HeadImageView) findViewById(a.g.sender_avatar);
        this.apf.setIsRound(true);
        this.apf.setAutoChangeStyle(false);
        this.apf.setDefaultBgResource(a.f.sdk_default_avatar);
        this.apf.setOnClickListener(this);
        this.ahY = (TextView) findViewById(a.g.sender_name);
        this.ahY.setOnClickListener(this);
        this.aji = (TextView) findViewById(a.g.gift_name);
        this.apg = (TbImageView) findViewById(a.g.gift_icon);
        this.apg.setAutoChangeStyle(false);
        this.apg.setDefaultBgResource(a.d.sdk_transparent);
        this.apg.setDefaultErrorResource(a.d.sdk_transparent);
        this.apg.setGifIconSupport(false);
        this.api = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aph = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aph.loop(true);
        this.aph.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.apj = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.apj.loop(true);
        this.api.getPaint().setFakeBoldText(true);
        vm();
    }

    public void setMode(boolean z) {
        this.apl = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void vm() {
        this.aoV = ObjectAnimator.ofFloat(this.apf, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aoV.setDuration(350L);
        this.aoV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.vo();
                AlaSmallGiftView.this.vp();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aoY = ObjectAnimator.ofFloat(this.apg, "ScaleX", 0.1f, 1.0f);
        this.aoZ = ObjectAnimator.ofFloat(this.apg, "ScaleY", 0.1f, 1.0f);
        this.aoX = new AnimatorSet();
        this.aoX.playTogether(this.aoY, this.aoZ);
        this.aoX.setInterpolator(new OvershootInterpolator(4.0f));
        this.aoX.setDuration(400L);
        this.aoX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.apk != null) {
                    AlaSmallGiftView.this.apk.uk();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.apa = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.apa.setDuration(300L);
        this.apa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.vu();
                AlaSmallGiftView.this.vv();
                if (AlaSmallGiftView.this.apk != null) {
                    AlaSmallGiftView.this.apk.N(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.apc = ObjectAnimator.ofFloat(this.api, "ScaleX", 3.0f, 1.0f);
        this.apd = ObjectAnimator.ofFloat(this.api, "ScaleY", 3.0f, 1.0f);
        this.apb = new AnimatorSet();
        this.apb.playTogether(this.apc, this.apd);
        this.apb.setDuration(240L);
        this.apb.setInterpolator(new OvershootInterpolator());
        this.apb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.apk != null) {
                    AlaSmallGiftView.this.apk.ul();
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

    private void vn() {
        this.apf.setVisibility(0);
        this.aoV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo() {
        this.apg.setVisibility(0);
        this.aoX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp() {
        if (this.aph != null && this.aph.getVisibility() == 0) {
            this.aph.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aph.cancelAnimation();
                    AlaSmallGiftView.this.aph.playAnimation();
                }
            });
        }
        if (this.apj != null && this.apj.getVisibility() == 0) {
            this.apj.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.apj.cancelAnimation();
                    AlaSmallGiftView.this.apj.playAnimation();
                }
            });
        }
    }

    private void vq() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aoW = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aoW.setInterpolator(new OvershootInterpolator());
            this.aoW.setDuration(300L);
            this.aoW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.vo();
                    AlaSmallGiftView.this.vp();
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

    private void vr() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aoU = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aoU.setInterpolator(new OvershootInterpolator());
            this.aoU.setDuration(300L);
        }
    }

    public void vs() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            vv();
            if (this.aoV != null) {
                this.aoV.cancel();
            }
            this.apf.setVisibility(0);
            if (this.aoW == null) {
                vq();
            }
            this.aoW.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            vv();
            if (this.aoU == null) {
                vr();
            }
            this.aoU.start();
            vn();
        }
    }

    public void vt() {
        this.apa.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu() {
        this.apg.setVisibility(8);
    }

    public void vv() {
        setTranslationY(0.0f);
        if (this.aoV != null) {
            this.aoV.cancel();
        }
        if (this.aoX != null) {
            this.aoX.cancel();
        }
        if (this.apb != null) {
            this.apb.cancel();
        }
        if (this.aoU != null) {
            this.aoU.cancel();
        }
        if (this.aoW != null) {
            this.aoW.cancel();
        }
        if (this.apa != null) {
            this.apa.cancel();
        }
        if (this.apj != null) {
            this.apj.cancelAnimation();
        }
        if (this.aph != null) {
            this.aph.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.alH != null) {
            this.aia = cVar;
            setGiftCnt(cVar.alM);
            dt(cVar.userName);
            this.aji.setText(cVar.alH.rD());
            vw();
            vx();
            if (z) {
                setDisplayStyle(cVar.alM);
            }
        }
    }

    private void vw() {
        if (this.aia != null) {
            this.apf.setUrl(this.aia.portrait);
            k.a(this.apf, this.aia.portrait, false, !StringUtils.isNull(this.aia.appId));
        }
    }

    private void vx() {
        if (this.aia != null && this.aia.alH != null) {
            this.apg.setVisibility(0);
            this.apg.startLoad(this.aia.alH.rF(), 10, false);
        }
    }

    private void dt(String str) {
        this.ahY.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.ahY.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aph.setVisibility(8);
            this.apj.setVisibility(8);
            this.ape.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.api.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.api.setGravity(3);
        } else if (j <= 65) {
            this.aph.setVisibility(8);
            this.apj.setVisibility(8);
            this.ape.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.api.setGravity(19);
        } else if (j <= 187) {
            this.aph.setVisibility(0);
            this.aph.setAnimation("66-1.json");
            this.apj.setVisibility(8);
            this.ape.setBackgroundResource(a.d.sdk_transparent);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aph.setVisibility(0);
            this.aph.setAnimation("188-1.json");
            this.apj.setVisibility(0);
            this.apj.setAnimation("188-2.json");
            this.ape.setBackgroundResource(a.d.sdk_transparent);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aph.setVisibility(0);
            this.aph.setAnimation("520-1.json");
            this.apj.setVisibility(0);
            this.apj.setAnimation("520-2.json");
            this.ape.setBackgroundResource(a.d.sdk_transparent);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aph.setVisibility(0);
            this.aph.setAnimation("1314-1.json");
            this.apj.setVisibility(0);
            this.apj.setAnimation("1314-2.json");
            this.ape.setBackgroundResource(a.d.sdk_transparent);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aph.setVisibility(0);
            this.aph.setAnimation("9999-1.json");
            this.apj.setVisibility(0);
            this.apj.setAnimation("9999-2.json");
            this.ape.setBackgroundResource(a.d.sdk_transparent);
            this.api.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.api.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.api.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.apj.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.api.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
            this.api.setLayoutParams(layoutParams);
            this.api.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.api.getLayoutParams();
            layoutParams2.width = -2;
            this.api.setLayoutParams(layoutParams2);
            this.api.setGravity(19);
        }
        this.apc.setFloatValues(1.0f, 1.5f, 1.0f);
        this.apd.setFloatValues(1.0f, 1.5f, 1.0f);
        this.apb.setDuration(840L);
        this.apb.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.apb.getChildAnimations();
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
                if (this.apl > 0) {
                    this.ape.setBackgroundResource(this.apl);
                } else {
                    this.ape.setBackgroundResource(a.f.gray_circle);
                }
                this.api.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.ape.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.api.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.apc.setFloatValues(3.0f, 1.0f);
                this.apd.setFloatValues(3.0f, 1.0f);
                this.apb.setDuration(240L);
                this.apb.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.apc.setFloatValues(1.0f, 1.5f, 1.0f);
                this.apd.setFloatValues(1.0f, 1.5f, 1.0f);
                this.apb.setDuration(480L);
                this.apb.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.apb.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.api.setVisibility(8);
        } else {
            this.api.setVisibility(0);
        }
        this.api.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aia;
    }

    public void e(long j, long j2) {
        vw();
        vx();
        if (j < 1) {
            this.api.setVisibility(8);
        } else if (this.aia != null) {
            this.aia.alM = j2;
            this.aia.alL = j;
            this.api.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            vy();
            vp();
        }
    }

    private void vy() {
        this.api.setVisibility(0);
        this.apb.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aia != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aia.userId), this.aia.userName, this.aia.portrait, this.aia.sex, this.aia.alJ, this.aia.location, this.aia.description, 0L, this.aia.fansCount, this.aia.alK, this.aia.userStatus, this.aia.liveId, this.aia.groupId, this.aia.alN, this.aia.alO, this.aia.appId, this.aia.userName, "")));
        }
    }

    public void onDestroy() {
        vv();
        if (this.ape != null) {
            this.ape.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aia != null && this.aia.alM < this.aia.alL) {
            if (this.aia.alM <= 0) {
                this.aia.alM = 1L;
            }
            this.api.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aia.alM)));
            vy();
            setDisplayStyle(this.aia.alM);
            vp();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.apk = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aph != null && this.aph.getVisibility() == 0) {
            int width = this.ape.getWidth();
            int height = this.ape.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aph.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aph.setLayoutParams(layoutParams);
        }
    }
}
