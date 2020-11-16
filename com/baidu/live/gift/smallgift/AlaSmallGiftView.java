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
    private TextView aVl;
    private c aVn;
    private TextView aWC;
    private ObjectAnimator bdb;
    private ObjectAnimator bdc;
    private ObjectAnimator bdd;
    private AnimatorSet bde;
    private ObjectAnimator bdf;
    private ObjectAnimator bdg;
    private ObjectAnimator bdh;
    private AnimatorSet bdi;
    private ObjectAnimator bdj;
    private ObjectAnimator bdk;
    private RelativeLayout bdl;
    private HeadImageView bdm;
    private TbImageView bdn;
    private LottieAnimationView bdo;
    private AlaGiftStrokeTextView bdp;
    private LottieAnimationView bdq;
    private a bdr;
    private int bds;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Ii();

        void Ij();

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
        this.bdl = (RelativeLayout) findViewById(a.f.sender_user_info);
        this.bdl.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.bdm = (HeadImageView) findViewById(a.f.sender_avatar);
        this.bdm.setIsRound(true);
        this.bdm.setAutoChangeStyle(false);
        this.bdm.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bdm.setOnClickListener(this);
        this.aVl = (TextView) findViewById(a.f.sender_name);
        this.aVl.setOnClickListener(this);
        this.aWC = (TextView) findViewById(a.f.gift_name);
        this.bdn = (TbImageView) findViewById(a.f.gift_icon);
        this.bdn.setAutoChangeStyle(false);
        this.bdn.setDefaultBgResource(a.c.sdk_transparent);
        this.bdn.setDefaultErrorResource(a.c.sdk_transparent);
        this.bdn.setGifIconSupport(false);
        this.bdp = (AlaGiftStrokeTextView) findViewById(a.f.gift_count);
        this.bdo = (LottieAnimationView) findViewById(a.f.small_gift_bg);
        this.bdo.loop(true);
        this.bdo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bdq = (LottieAnimationView) findViewById(a.f.gift_count_bg);
        this.bdq.loop(true);
        this.bdp.getPaint().setFakeBoldText(true);
        Jn();
    }

    public void setMode(boolean z) {
        this.bds = z ? a.e.ala_small_gift_bg : a.e.ala_small_gift_bg_alpha_shape;
    }

    private void Jn() {
        this.bdc = ObjectAnimator.ofFloat(this.bdm, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.bdc.setDuration(350L);
        this.bdc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Jp();
                AlaSmallGiftView.this.Jq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdf = ObjectAnimator.ofFloat(this.bdn, "ScaleX", 0.1f, 1.0f);
        this.bdg = ObjectAnimator.ofFloat(this.bdn, "ScaleY", 0.1f, 1.0f);
        this.bde = new AnimatorSet();
        this.bde.playTogether(this.bdf, this.bdg);
        this.bde.setInterpolator(new OvershootInterpolator(4.0f));
        this.bde.setDuration(400L);
        this.bde.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bdr != null) {
                    AlaSmallGiftView.this.bdr.Ii();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdh = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.bdh.setDuration(300L);
        this.bdh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.Jv();
                AlaSmallGiftView.this.Jw();
                if (AlaSmallGiftView.this.bdr != null) {
                    AlaSmallGiftView.this.bdr.T(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bdj = ObjectAnimator.ofFloat(this.bdp, "ScaleX", 3.0f, 1.0f);
        this.bdk = ObjectAnimator.ofFloat(this.bdp, "ScaleY", 3.0f, 1.0f);
        this.bdi = new AnimatorSet();
        this.bdi.playTogether(this.bdj, this.bdk);
        this.bdi.setDuration(240L);
        this.bdi.setInterpolator(new OvershootInterpolator());
        this.bdi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.bdr != null) {
                    AlaSmallGiftView.this.bdr.Ij();
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

    private void Jo() {
        this.bdm.setVisibility(0);
        this.bdc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        this.bdn.setVisibility(0);
        this.bde.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        if (this.bdo != null && this.bdo.getVisibility() == 0) {
            this.bdo.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bdo.cancelAnimation();
                    AlaSmallGiftView.this.bdo.playAnimation();
                }
            });
        }
        if (this.bdq != null && this.bdq.getVisibility() == 0) {
            this.bdq.post(new Runnable() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.6
                @Override // java.lang.Runnable
                public void run() {
                    AlaSmallGiftView.this.bdq.cancelAnimation();
                    AlaSmallGiftView.this.bdq.playAnimation();
                }
            });
        }
    }

    private void Jr() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdd = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.bdd.setInterpolator(new OvershootInterpolator());
            this.bdd.setDuration(300L);
            this.bdd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.Jp();
                    AlaSmallGiftView.this.Jq();
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

    private void Js() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.bdb = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.bdb.setInterpolator(new OvershootInterpolator());
            this.bdb.setDuration(300L);
        }
    }

    public void Jt() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            Jw();
            if (this.bdc != null) {
                this.bdc.cancel();
            }
            this.bdm.setVisibility(0);
            if (this.bdd == null) {
                Jr();
            }
            this.bdd.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Jw();
            if (this.bdb == null) {
                Js();
            }
            this.bdb.start();
            Jo();
        }
    }

    public void Ju() {
        this.bdh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        this.bdn.setVisibility(8);
    }

    public void Jw() {
        setTranslationY(0.0f);
        if (this.bdc != null) {
            this.bdc.cancel();
        }
        if (this.bde != null) {
            this.bde.cancel();
        }
        if (this.bdi != null) {
            this.bdi.cancel();
        }
        if (this.bdb != null) {
            this.bdb.cancel();
        }
        if (this.bdd != null) {
            this.bdd.cancel();
        }
        if (this.bdh != null) {
            this.bdh.cancel();
        }
        if (this.bdq != null) {
            this.bdq.cancelAnimation();
        }
        if (this.bdo != null) {
            this.bdo.cancelAnimation();
        }
    }

    public void setData(c cVar) {
        setData(cVar, true);
    }

    public void setData(c cVar, boolean z) {
        if (cVar != null && cVar.aZq != null) {
            this.aVn = cVar;
            setGiftCnt(cVar.aZx);
            hf(cVar.userName);
            this.aWC.setText(cVar.aZq.Fl());
            Jx();
            Jy();
            if (z) {
                setDisplayStyle(cVar.aZx);
            }
        }
    }

    private void Jx() {
        if (this.aVn != null) {
            this.bdm.setUrl(this.aVn.portrait);
            l.a(this.bdm, this.aVn.portrait, false, !StringUtils.isNull(this.aVn.appId));
        }
    }

    private void Jy() {
        if (this.aVn != null && this.aVn.aZq != null) {
            this.bdn.setVisibility(0);
            this.bdn.startLoad(this.aVn.aZq.getThumbnail_url(), 10, false);
        }
    }

    private void hf(String str) {
        this.aVl.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.aVl.setText(str);
        }
    }

    private void setDisplayStyle(long j) {
        if (j > 0 && j <= 10) {
            this.bdo.setVisibility(8);
            this.bdq.setVisibility(8);
            this.bdl.setBackgroundResource(a.e.ala_small_gift_bg_less10);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_cp_bg_line_d));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_f));
            this.bdp.setGravity(3);
        } else if (j <= 65) {
            this.bdo.setVisibility(8);
            this.bdq.setVisibility(8);
            this.bdl.setBackgroundResource(a.e.ala_small_gift_bg_less65);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10275));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
            this.bdp.setGravity(19);
        } else if (j <= 187) {
            this.bdo.setVisibility(0);
            this.bdo.setAnimation("66-1.json");
            this.bdq.setVisibility(8);
            this.bdl.setBackgroundResource(a.c.sdk_transparent);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10276));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 519) {
            this.bdo.setVisibility(0);
            this.bdo.setAnimation("188-1.json");
            this.bdq.setVisibility(0);
            this.bdq.setAnimation("188-2.json");
            this.bdl.setBackgroundResource(a.c.sdk_transparent);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10277));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 1313) {
            this.bdo.setVisibility(0);
            this.bdo.setAnimation("520-1.json");
            this.bdq.setVisibility(0);
            this.bdq.setAnimation("520-2.json");
            this.bdl.setBackgroundResource(a.c.sdk_transparent);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10278));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (j <= 9998) {
            this.bdo.setVisibility(0);
            this.bdo.setAnimation("1314-1.json");
            this.bdq.setVisibility(0);
            this.bdq.setAnimation("1314-2.json");
            this.bdl.setBackgroundResource(a.c.sdk_transparent);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10279));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        } else {
            this.bdo.setVisibility(0);
            this.bdo.setAnimation("9999-1.json");
            this.bdq.setVisibility(0);
            this.bdq.setAnimation("9999-2.json");
            this.bdl.setBackgroundResource(a.c.sdk_transparent);
            this.bdp.setTextColor(getResources().getColor(a.c.sdk_common_color_10280));
            this.bdp.setShadowLayer(2.0f, 0.0f, 0.0f, getResources().getColor(a.c.sdk_black_alpha50));
            this.bdp.setStrokeColor(getResources().getColor(a.c.sdk_cp_cont_i));
        }
        if (this.bdq.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdp.getLayoutParams();
            layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds136);
            this.bdp.setLayoutParams(layoutParams);
            this.bdp.setGravity(17);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bdp.getLayoutParams();
            layoutParams2.width = -2;
            this.bdp.setLayoutParams(layoutParams2);
            this.bdp.setGravity(19);
        }
        this.bdj.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bdk.setFloatValues(1.0f, 1.5f, 1.0f);
        this.bdi.setDuration(840L);
        this.bdi.setInterpolator(new AccelerateInterpolator());
        ArrayList<Animator> childAnimations = this.bdi.getChildAnimations();
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
                if (this.bds > 0) {
                    this.bdl.setBackgroundResource(this.bds);
                } else {
                    this.bdl.setBackgroundResource(a.e.gray_circle);
                }
                this.bdp.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
                return;
            case 1:
                this.bdl.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.bdp.setTextColor(getResources().getColor(a.c.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.bdj.setFloatValues(3.0f, 1.0f);
                this.bdk.setFloatValues(3.0f, 1.0f);
                this.bdi.setDuration(240L);
                this.bdi.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.bdj.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bdk.setFloatValues(1.0f, 1.5f, 1.0f);
                this.bdi.setDuration(480L);
                this.bdi.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.bdi.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.bdp.setVisibility(8);
        } else {
            this.bdp.setVisibility(0);
        }
        this.bdp.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public c getCurGiftData() {
        return this.aVn;
    }

    public void f(long j, long j2) {
        Jx();
        Jy();
        if (j < 1) {
            this.bdp.setVisibility(8);
        } else if (this.aVn != null) {
            this.aVn.aZx = j2;
            this.aVn.aZw = j;
            this.bdp.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            setDisplayStyle(j2);
            Jz();
            Jq();
        }
    }

    private void Jz() {
        this.bdp.setVisibility(0);
        this.bdi.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVn != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVn.userId), this.aVn.userName, this.aVn.portrait, this.aVn.sex, this.aVn.aZs, this.aVn.location, this.aVn.description, 0L, this.aVn.fansCount, this.aVn.aZt, this.aVn.userStatus, this.aVn.liveId, this.aVn.groupId, this.aVn.aZy, this.aVn.aZz, this.aVn.appId, this.aVn.userName, "")));
        }
    }

    public void onDestroy() {
        Jw();
        if (this.bdl != null) {
            this.bdl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aVn != null && this.aVn.aZx < this.aVn.aZw) {
            if (this.aVn.aZx <= 0) {
                this.aVn.aZx = 1L;
            }
            this.bdp.setText(getResources().getString(a.h.ala_gift_stroke_num_tip, Long.valueOf(this.aVn.aZx)));
            Jz();
            setDisplayStyle(this.aVn.aZx);
            Jq();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.bdr = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.bdo != null && this.bdo.getVisibility() == 0) {
            int width = this.bdl.getWidth();
            int height = this.bdl.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdo.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            this.bdo.setLayoutParams(layoutParams);
        }
    }
}
