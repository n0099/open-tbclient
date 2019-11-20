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
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class AlaSmallGiftView extends RelativeLayout implements View.OnClickListener {
    private TextView Xm;
    private d Xo;
    private TextView Yh;
    private ObjectAnimator adL;
    private ObjectAnimator adM;
    private ObjectAnimator adN;
    private AnimatorSet adO;
    private ObjectAnimator adP;
    private ObjectAnimator adQ;
    private ObjectAnimator adR;
    private AnimatorSet adS;
    private ObjectAnimator adT;
    private ObjectAnimator adU;
    private RelativeLayout adV;
    private HeadImageView adW;
    private TbImageView adX;
    private AlaGiftStrokeTextView adY;
    private a adZ;
    private int aea;
    private int aeb;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void K(View view);

        void qU();

        void qV();
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
        this.adV = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.adW = (HeadImageView) findViewById(a.g.sender_avatar);
        this.adW.setIsRound(true);
        this.adW.setAutoChangeStyle(false);
        this.adW.setDefaultBgResource(a.f.sdk_default_avatar);
        this.adW.setOnClickListener(this);
        this.Xm = (TextView) findViewById(a.g.sender_name);
        this.Xm.setOnClickListener(this);
        this.Yh = (TextView) findViewById(a.g.gift_name);
        this.adX = (TbImageView) findViewById(a.g.gift_icon);
        this.adX.setAutoChangeStyle(false);
        this.adX.setDefaultBgResource(a.d.sdk_transparent);
        this.adX.setDefaultErrorResource(a.d.sdk_transparent);
        this.adX.setGifIconSupport(false);
        this.adY = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.adY.getPaint().setFakeBoldText(true);
        rK();
    }

    public void setMode(boolean z) {
        this.aeb = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void rK() {
        this.adM = ObjectAnimator.ofFloat(this.adW, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.adM.setDuration(350L);
        this.adM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.rM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.adP = ObjectAnimator.ofFloat(this.adX, "ScaleX", 0.1f, 1.0f);
        this.adQ = ObjectAnimator.ofFloat(this.adX, "ScaleY", 0.1f, 1.0f);
        this.adO = new AnimatorSet();
        this.adO.playTogether(this.adP, this.adQ);
        this.adO.setInterpolator(new OvershootInterpolator(4.0f));
        this.adO.setDuration(400L);
        this.adO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.adZ != null) {
                    AlaSmallGiftView.this.adZ.qU();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.adR = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.adR.setDuration(300L);
        this.adR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.rR();
                AlaSmallGiftView.this.rS();
                if (AlaSmallGiftView.this.adZ != null) {
                    AlaSmallGiftView.this.adZ.K(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.adT = ObjectAnimator.ofFloat(this.adY, "ScaleX", 3.0f, 1.0f);
        this.adU = ObjectAnimator.ofFloat(this.adY, "ScaleY", 3.0f, 1.0f);
        this.adS = new AnimatorSet();
        this.adS.playTogether(this.adT, this.adU);
        this.adS.setDuration(240L);
        this.adS.setInterpolator(new OvershootInterpolator());
        this.adS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.adZ != null) {
                    AlaSmallGiftView.this.adZ.qV();
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

    private void rL() {
        this.adW.setVisibility(0);
        this.adM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM() {
        this.adX.setVisibility(0);
        this.adO.start();
    }

    private void rN() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.adN = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.adN.setInterpolator(new OvershootInterpolator());
            this.adN.setDuration(300L);
            this.adN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.rM();
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

    private void rO() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.adL = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.adL.setInterpolator(new OvershootInterpolator());
            this.adL.setDuration(300L);
        }
    }

    public void rP() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            rS();
            if (this.adM != null) {
                this.adM.cancel();
            }
            this.adW.setVisibility(0);
            if (this.adN == null) {
                rN();
            }
            this.adN.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            rS();
            if (this.adL == null) {
                rO();
            }
            this.adL.start();
            rL();
        }
    }

    public void rQ() {
        this.adR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        this.adX.setVisibility(8);
    }

    public void rS() {
        setTranslationY(0.0f);
        if (this.adM != null) {
            this.adM.cancel();
        }
        if (this.adO != null) {
            this.adO.cancel();
        }
        if (this.adS != null) {
            this.adS.cancel();
        }
        if (this.adL != null) {
            this.adL.cancel();
        }
        if (this.adN != null) {
            this.adN.cancel();
        }
        if (this.adR != null) {
            this.adR.cancel();
        }
    }

    public void setData(d dVar) {
        if (dVar != null && dVar.aaz != null) {
            this.Xo = dVar;
            setGiftCnt(dVar.aaF);
            cp(dVar.userName);
            this.Yh.setText(dVar.aaz.pd());
            rT();
            rU();
            rV();
        }
    }

    private void rT() {
        if (this.Xo != null) {
            this.adW.setUrl(this.Xo.portrait);
            j.a(this.adW, this.Xo.portrait, false, !StringUtils.isNull(this.Xo.appId));
        }
    }

    private void rU() {
        if (this.Xo != null && this.Xo.aaz != null) {
            this.adX.setVisibility(0);
            this.adX.startLoad(this.Xo.aaz.pf(), 10, false);
        }
    }

    private void cp(String str) {
        this.Xm.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.Xm.setText(str);
        }
    }

    private void rV() {
        this.aea = this.Xo.aaE > 10 ? 1 : 0;
        setSendUserBg(this.aea);
        setGiftNumAnimProperty(this.aea);
    }

    private void setSendUserBg(int i) {
        switch (i) {
            case 0:
                if (this.aeb > 0) {
                    this.adV.setBackgroundResource(this.aeb);
                } else {
                    this.adV.setBackgroundResource(a.f.gray_circle);
                }
                this.adY.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.adV.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.adY.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.adT.setFloatValues(3.0f, 1.0f);
                this.adU.setFloatValues(3.0f, 1.0f);
                this.adS.setDuration(240L);
                this.adS.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.adT.setFloatValues(1.0f, 1.5f, 1.0f);
                this.adU.setFloatValues(1.0f, 1.5f, 1.0f);
                this.adS.setDuration(480L);
                this.adS.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.adS.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.adY.setVisibility(8);
        } else {
            this.adY.setVisibility(0);
        }
        this.adY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public d getCurGiftData() {
        return this.Xo;
    }

    public void e(long j, long j2) {
        rT();
        rU();
        if (j < 1) {
            this.adY.setVisibility(8);
        } else if (this.Xo != null) {
            this.Xo.aaF = j2;
            this.Xo.aaE = j;
            this.adY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            rW();
        }
    }

    private void rW() {
        this.adY.setVisibility(0);
        this.adS.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Xo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.Xo.userId), this.Xo.userName, this.Xo.portrait, this.Xo.sex, this.Xo.aaB, this.Xo.location, this.Xo.description, 0L, this.Xo.aaD, this.Xo.aaC, this.Xo.userStatus, this.Xo.liveId, this.Xo.groupId, this.Xo.aaG, this.Xo.aaH, this.Xo.appId, this.Xo.userName, "")));
        }
    }

    public void onDestroy() {
        rS();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Xo != null && this.Xo.aaF < this.Xo.aaE) {
            if (this.Xo.aaF <= 0) {
                this.Xo.aaF = 1L;
            }
            this.adY.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.Xo.aaF)));
            rW();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.adZ = aVar;
    }
}
