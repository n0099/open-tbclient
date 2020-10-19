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
    private TextView aUj;
    private c aUl;
    private TextView aVA;
    private ObjectAnimator bcf;
    private ObjectAnimator bcg;
    private ObjectAnimator bch;
    private AnimatorSet bci;
    private ObjectAnimator bcj;
    private ObjectAnimator bck;
    private ObjectAnimator bcl;
    private AnimatorSet bcm;
    private ObjectAnimator bcn;
    private ObjectAnimator bco;
    private RelativeLayout bcp;
    private HeadImageView bcq;
    private TbImageView bcr;
    private LottieAnimationView bcs;
    private AlaGiftStrokeTextView bct;
    private LottieAnimationView bcu;
    private a bcv;
    private int bcw;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void HV();

        void HW();

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
        this.bcp = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.bcp.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bcq = (HeadImageView) findViewById(a.g.sender_avatar);
        this.bcq.setIsRound(true);
        this.bcq.setAutoChangeStyle(false);
        this.bcq.setDefaultBgResource(a.f.sdk_default_avatar);
        this.bcq.setOnClickListener(this);
        this.aUj = (TextView) findViewById(a.g.sender_name);
        this.aUj.setOnClickListener(this);
        this.aVA = (TextView) findViewById(a.g.gift_name);
        this.bcr = (TbImageView) findViewById(a.g.gift_icon);
        this.bcr.setAutoChangeStyle(false);
        this.bcr.setDefaultBgResource(a.d.sdk_transparent);
        this.bcr.setDefaultErrorResource(a.d.sdk_transparent);
        this.bcr.setGifIconSupport(false);
        this.bct = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.bcs = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.bcs.loop(true);
        this.bcs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcu = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.bcu.loop(true);
        this.bct.getPaint().setFakeBoldText(true);
        Jd();
    }

    public void setMode(boolean z) {
        this.bcw = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void Jd() {
        this.bcg = ObjectAnimator.ofFloat(this.bcq, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bcg.setDuration(350L);
        this.bcg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Jf();
                AlaSmallGiftView.this.Jg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bcj = ObjectAnimator.ofFloat(this.bcr, "ScaleX", 0.1f, 1.0f);
        this.bck = ObjectAnimator.ofFloat(this.bcr, "ScaleY", 0.1f, 1.0f);
        this.bci = new AnimatorSet();
        this.bci.playTogether(this.bcj, this.bck);
        this.bci.setInterpolator(new OvershootInterpolator(4.0f));
        this.bci.setDuration(400L);
        this.bci.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bcv != null) {
                    AlaSmallGiftView.this.bcv.HV();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bcl = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bcl.setDuration(300L);
        this.bcl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Jl();
                AlaSmallGiftView.this.Jm();
                if (AlaSmallGiftView.this.bcv != null) {
                    AlaSmallGiftView.this.bcv.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bcn = ObjectAnimator.ofFloat(this.bct, "ScaleX", 3.0f, 1.0f);
        this.bco = ObjectAnimator.ofFloat(this.bct, "ScaleY", 3.0f, 1.0f);
        this.bcm = new AnimatorSet();
        this.bcm.playTogether(this.bcn, this.bco);
        this.bcm.setDuration(240L);
        this.bcm.setInterpolator(new OvershootInterpolator());
        this.bcm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bcv != null) {
                    AlaSmallGiftView.this.bcv.HW();
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

    private void Je() {
        this.bcq.setVisibility(0);
        this.bcg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jf() {
        this.bcr.setVisibility(0);
        this.bci.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg() {
        if (this.bcs != null && this.bcs.getVisibility() == 0) {
            this.bcs.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bcs.cancelAnimation();
                    AlaSmallGiftView.this.bcs.playAnimation();
                }
            });
        }
        if (this.bcu != null && this.bcu.getVisibility() == 0) {
            this.bcu.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bcu.cancelAnimation();
                    AlaSmallGiftView.this.bcu.playAnimation();
                }
            });
        }
    }

    private void Jh() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bch = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bch.setInterpolator(new OvershootInterpolator());
            this.bch.setDuration(300L);
            this.bch.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Jf();
                    AlaSmallGiftView.this.Jg();
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

    private void Ji() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bcf = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bcf.setInterpolator(new OvershootInterpolator());
            this.bcf.setDuration(300L);
        }
    }

    public void Jj() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Jm();
            if (this.bcg != null) {
                this.bcg.cancel();
            }
            this.bcq.setVisibility(0);
            if (this.bch == null) {
                Jh();
            }
            this.bch.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Jm();
            if (this.bcf == null) {
                Ji();
            }
            this.bcf.start();
            Je();
        }
    }

    public void Jk() {
        this.bcl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jl() {
        this.bcr.setVisibility(8);
    }

    public void Jm() {
        setTranslationY(0.0f);
        if (this.bcg != null) {
            this.bcg.cancel();
        }
        if (this.bci != null) {
            this.bci.cancel();
        }
        if (this.bcm != null) {
            this.bcm.cancel();
        }
        if (this.bcf != null) {
            this.bcf.cancel();
        }
        if (this.bch != null) {
            this.bch.cancel();
        }
        if (this.bcl != null) {
            this.bcl.cancel();
        }
        if (this.bcu != null) {
            this.bcu.cancelAnimation();
        }
        if (this.bcs != null) {
            this.bcs.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aYo != null) {
            this.aUl = cVar;
            setGiftCnt(cVar.aYu);
            gT(cVar.userName);
            this.aVA.setText(cVar.aYo.Fe());
            Jn();
            Jo();
            if (z) {
                setDisplayStyle(cVar.aYu);
            }
        }
    }

    private void Jn() {
        if (this.aUl != null) {
            this.bcq.setUrl(this.aUl.portrait);
            l.a(this.bcq, this.aUl.portrait, false, !StringUtils.isNull(this.aUl.appId));
        }
    }

    private void Jo() {
        if (this.aUl != null && this.aUl.aYo != null) {
            this.bcr.setVisibility(0);
            this.bcr.startLoad(this.aUl.aYo.getThumbnail_url(), 10, false);
        }
    }

    private void gT(String str) {
        this.aUj.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aUj.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bcs.setVisibility(8);
            this.bcu.setVisibility(8);
            this.bcp.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.bct.setGravity(3);
        } else if (j <= 65) {
            this.bcs.setVisibility(8);
            this.bcu.setVisibility(8);
            this.bcp.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.bct.setGravity(19);
        } else if (j <= 187) {
            this.bcs.setVisibility(0);
            this.bcs.setAnimation("66-1.json");
            this.bcu.setVisibility(8);
            this.bcp.setBackgroundResource(a.d.sdk_transparent);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bcs.setVisibility(0);
            this.bcs.setAnimation("188-1.json");
            this.bcu.setVisibility(0);
            this.bcu.setAnimation("188-2.json");
            this.bcp.setBackgroundResource(a.d.sdk_transparent);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bcs.setVisibility(0);
            this.bcs.setAnimation("520-1.json");
            this.bcu.setVisibility(0);
            this.bcu.setAnimation("520-2.json");
            this.bcp.setBackgroundResource(a.d.sdk_transparent);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bcs.setVisibility(0);
            this.bcs.setAnimation("1314-1.json");
            this.bcu.setVisibility(0);
            this.bcu.setAnimation("1314-2.json");
            this.bcp.setBackgroundResource(a.d.sdk_transparent);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.bcs.setVisibility(0);
            this.bcs.setAnimation("9999-1.json");
            this.bcu.setVisibility(0);
            this.bcu.setAnimation("9999-2.json");
            this.bcp.setBackgroundResource(a.d.sdk_transparent);
            this.bct.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.bct.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.bct.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.bcu.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bct.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.bct.setLayoutParams(layoutParams);
            this.bct.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bct.getLayoutParams();
            layoutParams2.width = -2;
            this.bct.setLayoutParams(layoutParams2);
            this.bct.setGravity(19);
        }
        this.bcn.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bco.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bcm.setDuration(840L);
        this.bcm.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bcm.getChildAnimations();
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
                if (this.bcw > 0) {
                    this.bcp.setBackgroundResource(this.bcw);
                } else {
                    this.bcp.setBackgroundResource(a.f.gray_circle);
                }
                this.bct.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.bcp.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bct.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bcn.setFloatValues(3.0f, 1.0f);
                this.bco.setFloatValues(3.0f, 1.0f);
                this.bcm.setDuration(240L);
                this.bcm.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bcn.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bco.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bcm.setDuration(480L);
                this.bcm.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bcm.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bct.setVisibility(8);
        } else {
            this.bct.setVisibility(0);
        }
        this.bct.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aUl;
    }

    public void f(long j, long j2) {
        Jn();
        Jo();
        if (j < 1) {
            this.bct.setVisibility(8);
        } else if (this.aUl != null) {
            this.aUl.aYu = j2;
            this.aUl.aYt = j;
            this.bct.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Jp();
            Jg();
        }
    }

    private void Jp() {
        this.bct.setVisibility(0);
        this.bcm.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aUl != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aUl.userId), this.aUl.userName, this.aUl.portrait, this.aUl.sex, this.aUl.aYq, this.aUl.location, this.aUl.description, 0L, this.aUl.fansCount, this.aUl.aYr, this.aUl.userStatus, this.aUl.liveId, this.aUl.groupId, this.aUl.aYv, this.aUl.aYw, this.aUl.appId, this.aUl.userName, "")));
        }
    }

    public void onDestroy() {
        Jm();
        if (this.bcp != null) {
            this.bcp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aUl != null && this.aUl.aYu < this.aUl.aYt) {
            if (this.aUl.aYu <= 0) {
                this.aUl.aYu = 1L;
            }
            this.bct.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aUl.aYu)));
            Jp();
            setDisplayStyle(this.aUl.aYu);
            Jg();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bcv = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bcs != null && this.bcs.getVisibility() == 0) {
            int width = this.bcp.getWidth();
            int height = this.bcp.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcs.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bcs.setLayoutParams(layoutParams);
        }
    }
}
