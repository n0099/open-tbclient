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
    private TextView aFR;
    private c aFT;
    private TextView aHe;
    private ObjectAnimator aNd;
    private ObjectAnimator aNe;
    private ObjectAnimator aNf;
    private AnimatorSet aNg;
    private ObjectAnimator aNh;
    private ObjectAnimator aNi;
    private ObjectAnimator aNj;
    private AnimatorSet aNk;
    private ObjectAnimator aNl;
    private ObjectAnimator aNm;
    private RelativeLayout aNn;
    private HeadImageView aNo;
    private TbImageView aNp;
    private LottieAnimationView aNq;
    private AlaGiftStrokeTextView aNr;
    private LottieAnimationView aNs;
    private a aNt;
    private int aNu;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void O(View view);

        void zT();

        void zU();
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
        this.aNn = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aNn.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.aNo = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aNo.setIsRound(true);
        this.aNo.setAutoChangeStyle(false);
        this.aNo.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aNo.setOnClickListener(this);
        this.aFR = (TextView) findViewById(a.g.sender_name);
        this.aFR.setOnClickListener(this);
        this.aHe = (TextView) findViewById(a.g.gift_name);
        this.aNp = (TbImageView) findViewById(a.g.gift_icon);
        this.aNp.setAutoChangeStyle(false);
        this.aNp.setDefaultBgResource(a.d.sdk_transparent);
        this.aNp.setDefaultErrorResource(a.d.sdk_transparent);
        this.aNp.setGifIconSupport(false);
        this.aNr = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aNq = (LottieAnimationView) findViewById(a.g.small_gift_bg);
        this.aNq.loop(true);
        this.aNq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aNs = (LottieAnimationView) findViewById(a.g.gift_count_bg);
        this.aNs.loop(true);
        this.aNr.getPaint().setFakeBoldText(true);
        AZ();
    }

    public void setMode(boolean z) {
        this.aNu = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void AZ() {
        this.aNe = ObjectAnimator.ofFloat(this.aNo, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aNe.setDuration(350L);
        this.aNe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Bb();
                AlaSmallGiftView.this.Bc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aNh = ObjectAnimator.ofFloat(this.aNp, "ScaleX", 0.1f, 1.0f);
        this.aNi = ObjectAnimator.ofFloat(this.aNp, "ScaleY", 0.1f, 1.0f);
        this.aNg = new AnimatorSet();
        this.aNg.playTogether(this.aNh, this.aNi);
        this.aNg.setInterpolator(new OvershootInterpolator(4.0f));
        this.aNg.setDuration(400L);
        this.aNg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aNt != null) {
                    AlaSmallGiftView.this.aNt.zT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aNj = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aNj.setDuration(300L);
        this.aNj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Bh();
                AlaSmallGiftView.this.Bi();
                if (AlaSmallGiftView.this.aNt != null) {
                    AlaSmallGiftView.this.aNt.O(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aNl = ObjectAnimator.ofFloat(this.aNr, "ScaleX", 3.0f, 1.0f);
        this.aNm = ObjectAnimator.ofFloat(this.aNr, "ScaleY", 3.0f, 1.0f);
        this.aNk = new AnimatorSet();
        this.aNk.playTogether(this.aNl, this.aNm);
        this.aNk.setDuration(240L);
        this.aNk.setInterpolator(new OvershootInterpolator());
        this.aNk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aNt != null) {
                    AlaSmallGiftView.this.aNt.zU();
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

    private void Ba() {
        this.aNo.setVisibility(0);
        this.aNe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        this.aNp.setVisibility(0);
        this.aNg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        if (this.aNq != null && this.aNq.getVisibility() == 0) {
            this.aNq.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aNq.cancelAnimation();
                    AlaSmallGiftView.this.aNq.playAnimation();
                }
            });
        }
        if (this.aNs != null && this.aNs.getVisibility() == 0) {
            this.aNs.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.aNs.cancelAnimation();
                    AlaSmallGiftView.this.aNs.playAnimation();
                }
            });
        }
    }

    private void Bd() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aNf = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aNf.setInterpolator(new OvershootInterpolator());
            this.aNf.setDuration(300L);
            this.aNf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Bb();
                    AlaSmallGiftView.this.Bc();
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

    private void Be() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aNd = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aNd.setInterpolator(new OvershootInterpolator());
            this.aNd.setDuration(300L);
        }
    }

    public void Bf() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Bi();
            if (this.aNe != null) {
                this.aNe.cancel();
            }
            this.aNo.setVisibility(0);
            if (this.aNf == null) {
                Bd();
            }
            this.aNf.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Bi();
            if (this.aNd == null) {
                Be();
            }
            this.aNd.start();
            Ba();
        }
    }

    public void Bg() {
        this.aNj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        this.aNp.setVisibility(8);
    }

    public void Bi() {
        setTranslationY(0.0f);
        if (this.aNe != null) {
            this.aNe.cancel();
        }
        if (this.aNg != null) {
            this.aNg.cancel();
        }
        if (this.aNk != null) {
            this.aNk.cancel();
        }
        if (this.aNd != null) {
            this.aNd.cancel();
        }
        if (this.aNf != null) {
            this.aNf.cancel();
        }
        if (this.aNj != null) {
            this.aNj.cancel();
        }
        if (this.aNs != null) {
            this.aNs.cancelAnimation();
        }
        if (this.aNq != null) {
            this.aNq.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aJC != null) {
            this.aFT = cVar;
            setGiftCnt(cVar.aJH);
            eU(cVar.userName);
            this.aHe.setText(cVar.aJC.xm());
            Bj();
            Bk();
            if (z) {
                setDisplayStyle(cVar.aJH);
            }
        }
    }

    private void Bj() {
        if (this.aFT != null) {
            this.aNo.setUrl(this.aFT.portrait);
            k.a(this.aNo, this.aFT.portrait, false, !StringUtils.isNull(this.aFT.appId));
        }
    }

    private void Bk() {
        if (this.aFT != null && this.aFT.aJC != null) {
            this.aNp.setVisibility(0);
            this.aNp.startLoad(this.aFT.aJC.xo(), 10, false);
        }
    }

    private void eU(String str) {
        this.aFR.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aFR.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.aNq.setVisibility(8);
            this.aNs.setVisibility(8);
            this.aNn.setBackgroundResource(a.f.ala_small_gift_bg_less10);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_cp_bg_line_d));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_f));
            this.aNr.setGravity(3);
        } else if (j <= 65) {
            this.aNq.setVisibility(8);
            this.aNs.setVisibility(8);
            this.aNn.setBackgroundResource(a.f.ala_small_gift_bg_less65);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10275));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
            this.aNr.setGravity(19);
        } else if (j <= 187) {
            this.aNq.setVisibility(0);
            this.aNq.setAnimation("66-1.json");
            this.aNs.setVisibility(8);
            this.aNn.setBackgroundResource(a.d.sdk_transparent);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10276));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.aNq.setVisibility(0);
            this.aNq.setAnimation("188-1.json");
            this.aNs.setVisibility(0);
            this.aNs.setAnimation("188-2.json");
            this.aNn.setBackgroundResource(a.d.sdk_transparent);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10277));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.aNq.setVisibility(0);
            this.aNq.setAnimation("520-1.json");
            this.aNs.setVisibility(0);
            this.aNs.setAnimation("520-2.json");
            this.aNn.setBackgroundResource(a.d.sdk_transparent);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10278));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.aNq.setVisibility(0);
            this.aNq.setAnimation("1314-1.json");
            this.aNs.setVisibility(0);
            this.aNs.setAnimation("1314-2.json");
            this.aNn.setBackgroundResource(a.d.sdk_transparent);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10279));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            this.aNq.setVisibility(0);
            this.aNq.setAnimation("9999-1.json");
            this.aNs.setVisibility(0);
            this.aNs.setAnimation("9999-2.json");
            this.aNn.setBackgroundResource(a.d.sdk_transparent);
            this.aNr.setTextColor(getResources().getColor(a.d.sdk_common_color_10280));
            this.aNr.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.d.sdk_black_alpha50));
            this.aNr.setStrokeColor(getResources().getColor(a.d.sdk_cp_cont_i));
        }
        if (this.aNs.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aNr.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds136);
            this.aNr.setLayoutParams(layoutParams);
            this.aNr.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aNr.getLayoutParams();
            layoutParams2.width = -2;
            this.aNr.setLayoutParams(layoutParams2);
            this.aNr.setGravity(19);
        }
        this.aNl.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aNm.setFloatValues(1.0f, 1.5f, 1.0f);
        this.aNk.setDuration(840L);
        this.aNk.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.aNk.getChildAnimations();
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
                if (this.aNu > 0) {
                    this.aNn.setBackgroundResource(this.aNu);
                } else {
                    this.aNn.setBackgroundResource(a.f.gray_circle);
                }
                this.aNr.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aNn.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aNr.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.aNl.setFloatValues(3.0f, 1.0f);
                this.aNm.setFloatValues(3.0f, 1.0f);
                this.aNk.setDuration(240L);
                this.aNk.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.aNl.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aNm.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aNk.setDuration(480L);
                this.aNk.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aNk.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aNr.setVisibility(8);
        } else {
            this.aNr.setVisibility(0);
        }
        this.aNr.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aFT;
    }

    public void f(long j, long j2) {
        Bj();
        Bk();
        if (j < 1) {
            this.aNr.setVisibility(8);
        } else if (this.aFT != null) {
            this.aFT.aJH = j2;
            this.aFT.aJG = j;
            this.aNr.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Bl();
            Bc();
        }
    }

    private void Bl() {
        this.aNr.setVisibility(0);
        this.aNk.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aFT.userId), this.aFT.userName, this.aFT.portrait, this.aFT.sex, this.aFT.aJE, this.aFT.location, this.aFT.description, 0L, this.aFT.fansCount, this.aFT.aJF, this.aFT.userStatus, this.aFT.liveId, this.aFT.groupId, this.aFT.aJI, this.aFT.aJJ, this.aFT.appId, this.aFT.userName, "")));
        }
    }

    public void onDestroy() {
        Bi();
        if (this.aNn != null) {
            this.aNn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aFT != null && this.aFT.aJH < this.aFT.aJG) {
            if (this.aFT.aJH <= 0) {
                this.aFT.aJH = 1L;
            }
            this.aNr.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.aFT.aJH)));
            Bl();
            setDisplayStyle(this.aFT.aJH);
            Bc();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aNt = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.aNq != null && this.aNq.getVisibility() == 0) {
            int width = this.aNn.getWidth();
            int height = this.aNn.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aNq.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.aNq.setLayoutParams(layoutParams);
        }
    }
}
