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
    private TextView aYw;
    private c aYy;
    private TextView aZS;
    private ObjectAnimator bhc;
    private ObjectAnimator bhd;
    private ObjectAnimator bhe;
    private AnimatorSet bhf;
    private ObjectAnimator bhg;
    private ObjectAnimator bhh;
    private ObjectAnimator bhi;
    private AnimatorSet bhj;
    private ObjectAnimator bhk;
    private ObjectAnimator bhl;
    private RelativeLayout bhm;
    private HeadImageView bhn;
    private TextView bho;
    private TbImageView bhp;
    private LottieAnimationView bhq;
    private AlaGiftStrokeTextView bhr;
    private LottieAnimationView bhs;
    private a bht;
    private int bhu;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void JZ();

        void Ka();

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
        this.bhm = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.bhm.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bhn = (HeadImageView) findViewById(a.f.sender_avatar);
        this.bhn.setIsRound(true);
        this.bhn.setAutoChangeStyle(false);
        this.bhn.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bhn.setOnClickListener(this);
        this.aYw = (TextView) findViewById(a.f.sender_name);
        this.aYw.setOnClickListener(this);
        this.aZS = (TextView) findViewById(a.f.gift_name);
        this.bho = (TextView) findViewById(a.f.giftNameTip);
        this.bhp = (TbImageView) findViewById(a.f.gift_icon);
        this.bhp.setAutoChangeStyle(false);
        this.bhp.setDefaultBgResource(a.c.sdk_transparent);
        this.bhp.setDefaultErrorResource(a.c.sdk_transparent);
        this.bhp.setGifIconSupport(false);
        this.bhr = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bhq = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bhq.loop(true);
        this.bhq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bhs = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bhs.loop(true);
        this.bhr.getPaint().setFakeBoldText(true);
        Lo();
    }

    public void setMode(boolean z) {
        this.bhu = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void Lo() {
        this.bhd = ObjectAnimator.ofFloat(this.bhn, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bhd.setDuration(350L);
        this.bhd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Lq();
                AlaSmallGiftView.this.Lr();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhg = ObjectAnimator.ofFloat(this.bhp, "ScaleX", 0.1f, 1.0f);
        this.bhh = ObjectAnimator.ofFloat(this.bhp, "ScaleY", 0.1f, 1.0f);
        this.bhf = new AnimatorSet();
        this.bhf.playTogether(this.bhg, this.bhh);
        this.bhf.setInterpolator(new OvershootInterpolator(4.0f));
        this.bhf.setDuration(400L);
        this.bhf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bht != null) {
                    AlaSmallGiftView.this.bht.JZ();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhi = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bhi.setDuration(300L);
        this.bhi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Lw();
                AlaSmallGiftView.this.Lx();
                if (AlaSmallGiftView.this.bht != null) {
                    AlaSmallGiftView.this.bht.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bhk = ObjectAnimator.ofFloat(this.bhr, "ScaleX", 3.0f, 1.0f);
        this.bhl = ObjectAnimator.ofFloat(this.bhr, "ScaleY", 3.0f, 1.0f);
        this.bhj = new AnimatorSet();
        this.bhj.playTogether(this.bhk, this.bhl);
        this.bhj.setDuration(240L);
        this.bhj.setInterpolator(new OvershootInterpolator());
        this.bhj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bht != null) {
                    AlaSmallGiftView.this.bht.Ka();
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

    private void Lp() {
        this.bhn.setVisibility(0);
        this.bhd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        this.bhp.setVisibility(0);
        this.bhf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lr() {
        if (this.bhq != null && this.bhq.getVisibility() == 0) {
            this.bhq.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhq.cancelAnimation();
                    AlaSmallGiftView.this.bhq.playAnimation();
                }
            });
        }
        if (this.bhs != null && this.bhs.getVisibility() == 0) {
            this.bhs.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bhs.cancelAnimation();
                    AlaSmallGiftView.this.bhs.playAnimation();
                }
            });
        }
    }

    private void Ls() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bhe = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bhe.setInterpolator(new OvershootInterpolator());
            this.bhe.setDuration(300L);
            this.bhe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Lq();
                    AlaSmallGiftView.this.Lr();
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

    private void Lt() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bhc = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bhc.setInterpolator(new OvershootInterpolator());
            this.bhc.setDuration(300L);
        }
    }

    public void Lu() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Lx();
            if (this.bhd != null) {
                this.bhd.cancel();
            }
            this.bhn.setVisibility(0);
            if (this.bhe == null) {
                Ls();
            }
            this.bhe.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Lx();
            if (this.bhc == null) {
                Lt();
            }
            this.bhc.start();
            Lp();
        }
    }

    public void Lv() {
        this.bhi.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        this.bhp.setVisibility(8);
    }

    public void Lx() {
        setTranslationY(0.0f);
        if (this.bhd != null) {
            this.bhd.cancel();
        }
        if (this.bhf != null) {
            this.bhf.cancel();
        }
        if (this.bhj != null) {
            this.bhj.cancel();
        }
        if (this.bhc != null) {
            this.bhc.cancel();
        }
        if (this.bhe != null) {
            this.bhe.cancel();
        }
        if (this.bhi != null) {
            this.bhi.cancel();
        }
        if (this.bhs != null) {
            this.bhs.cancelAnimation();
        }
        if (this.bhq != null) {
            this.bhq.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.bcN != null) {
            this.aYy = cVar;
            setGiftCnt(cVar.bcV);
            hA(cVar.userName);
            this.aZS.setText(cVar.bcN.GY());
            if (!TextUtils.isEmpty(cVar.bdf)) {
                this.bho.setTextColor(getContext().getResources().getColor(a.c.sdk_color_ffe918));
                this.bho.setText(cVar.bdf);
            } else {
                this.bho.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha90));
                this.bho.setText(this.mContext.getString(a.h.gift_name_prefix));
            }
            Ly();
            Lz();
            if (z) {
                setDisplayStyle(cVar.bcV);
            }
        }
    }

    private void Ly() {
        if (this.aYy != null) {
            this.bhn.setUrl(this.aYy.portrait);
            l.a(this.bhn, this.aYy.portrait, false, !StringUtils.isNull(this.aYy.appId));
        }
    }

    private void Lz() {
        if (this.aYy != null && this.aYy.bcN != null) {
            this.bhp.setVisibility(0);
            this.bhp.startLoad(this.aYy.bcN.getThumbnail_url(), 10, false);
        }
    }

    private void hA(String str) {
        this.aYw.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aYw.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bhq.setVisibility(8);
            this.bhs.setVisibility(8);
            this.bhm.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.bhr.setGravity(3);
        } else if (j <= 65) {
            this.bhq.setVisibility(8);
            this.bhs.setVisibility(8);
            this.bhm.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.bhr.setGravity(19);
        } else if (j <= 187) {
            this.bhq.setVisibility(0);
            this.bhq.setAnimation("66-1.json");
            this.bhs.setVisibility(8);
            this.bhm.setBackgroundResource(a.c.sdk_transparent);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bhq.setVisibility(0);
            this.bhq.setAnimation("188-1.json");
            this.bhs.setVisibility(0);
            this.bhs.setAnimation("188-2.json");
            this.bhm.setBackgroundResource(a.c.sdk_transparent);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bhq.setVisibility(0);
            this.bhq.setAnimation("520-1.json");
            this.bhs.setVisibility(0);
            this.bhs.setAnimation("520-2.json");
            this.bhm.setBackgroundResource(a.c.sdk_transparent);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bhq.setVisibility(0);
            this.bhq.setAnimation("1314-1.json");
            this.bhs.setVisibility(0);
            this.bhs.setAnimation("1314-2.json");
            this.bhm.setBackgroundResource(a.c.sdk_transparent);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bhq.setVisibility(0);
            this.bhq.setAnimation("9999-1.json");
            this.bhs.setVisibility(0);
            this.bhs.setAnimation("9999-2.json");
            this.bhm.setBackgroundResource(a.c.sdk_transparent);
            this.bhr.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.bhr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bhr.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bhs.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhr.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.bhr.setLayoutParams(layoutParams);
            this.bhr.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bhr.getLayoutParams();
            layoutParams2.width = -2;
            this.bhr.setLayoutParams(layoutParams2);
            this.bhr.setGravity(19);
        }
        this.bhk.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bhl.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bhj.setDuration(840L);
        this.bhj.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bhj.getChildAnimations();
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
                if (this.bhu > 0) {
                    this.bhm.setBackgroundResource(this.bhu);
                } else {
                    this.bhm.setBackgroundResource(a.e.gray_circle);
                }
                this.bhr.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.bhm.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bhr.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bhk.setFloatValues(3.0f, 1.0f);
                this.bhl.setFloatValues(3.0f, 1.0f);
                this.bhj.setDuration(240L);
                this.bhj.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bhk.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bhl.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bhj.setDuration(480L);
                this.bhj.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bhj.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bhr.setVisibility(8);
        } else {
            this.bhr.setVisibility(0);
        }
        this.bhr.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aYy;
    }

    public void f(long j, long j2) {
        Ly();
        Lz();
        if (j < 1) {
            this.bhr.setVisibility(8);
        } else if (this.aYy != null) {
            this.aYy.bcV = j2;
            this.aYy.bcU = j;
            this.bhr.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            LA();
            Lr();
        }
    }

    private void LA() {
        this.bhr.setVisibility(0);
        this.bhj.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aYy != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYy.userId), this.aYy.userName, this.aYy.portrait, this.aYy.sex, this.aYy.bcP, this.aYy.location, this.aYy.description, 0L, this.aYy.bcR, this.aYy.bcQ, this.aYy.userStatus, this.aYy.liveId, this.aYy.groupId, this.aYy.bcX, this.aYy.bcY, this.aYy.appId, this.aYy.userName, "")));
        }
    }

    public void onDestroy() {
        Lx();
        if (this.bhm != null) {
            this.bhm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aYy != null && this.aYy.bcV < this.aYy.bcU) {
            if (this.aYy.bcV <= 0) {
                this.aYy.bcV = 1L;
            }
            this.bhr.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aYy.bcV)));
            LA();
            setDisplayStyle(this.aYy.bcV);
            Lr();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bht = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bhq != null && this.bhq.getVisibility() == 0) {
            int width = this.bhm.getWidth();
            int height = this.bhm.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhq.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bhq.setLayoutParams(layoutParams);
        }
    }
}
