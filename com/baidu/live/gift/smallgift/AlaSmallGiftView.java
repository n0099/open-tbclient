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
    private TextView XE;
    private d XG;
    private TextView Yz;
    private ObjectAnimator aed;
    private ObjectAnimator aee;
    private ObjectAnimator aef;
    private AnimatorSet aeg;
    private ObjectAnimator aeh;
    private ObjectAnimator aei;
    private ObjectAnimator aej;
    private AnimatorSet aek;
    private ObjectAnimator ael;
    private ObjectAnimator aem;
    private RelativeLayout aen;
    private HeadImageView aeo;
    private TbImageView aep;
    private AlaGiftStrokeTextView aeq;
    private a aer;
    private int aes;
    private int aet;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void K(View view);

        void qT();

        void qU();
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
        this.aen = (RelativeLayout) findViewById(a.g.sender_user_info);
        this.aeo = (HeadImageView) findViewById(a.g.sender_avatar);
        this.aeo.setIsRound(true);
        this.aeo.setAutoChangeStyle(false);
        this.aeo.setDefaultBgResource(a.f.sdk_default_avatar);
        this.aeo.setOnClickListener(this);
        this.XE = (TextView) findViewById(a.g.sender_name);
        this.XE.setOnClickListener(this);
        this.Yz = (TextView) findViewById(a.g.gift_name);
        this.aep = (TbImageView) findViewById(a.g.gift_icon);
        this.aep.setAutoChangeStyle(false);
        this.aep.setDefaultBgResource(a.d.sdk_transparent);
        this.aep.setDefaultErrorResource(a.d.sdk_transparent);
        this.aep.setGifIconSupport(false);
        this.aeq = (AlaGiftStrokeTextView) findViewById(a.g.gift_count);
        this.aeq.getPaint().setFakeBoldText(true);
        rJ();
    }

    public void setMode(boolean z) {
        this.aet = z ? a.f.ala_small_gift_bg : a.f.ala_small_gift_bg_alpha_shape;
    }

    private void rJ() {
        this.aee = ObjectAnimator.ofFloat(this.aeo, "TranslationX", -BdUtilHelper.getScreenDimensions(this.mContext)[0], 0.0f);
        this.aee.setDuration(350L);
        this.aee.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.rL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aeh = ObjectAnimator.ofFloat(this.aep, "ScaleX", 0.1f, 1.0f);
        this.aei = ObjectAnimator.ofFloat(this.aep, "ScaleY", 0.1f, 1.0f);
        this.aeg = new AnimatorSet();
        this.aeg.playTogether(this.aeh, this.aei);
        this.aeg.setInterpolator(new OvershootInterpolator(4.0f));
        this.aeg.setDuration(400L);
        this.aeg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aer != null) {
                    AlaSmallGiftView.this.aer.qT();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aej = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, -100.0f);
        this.aej.setDuration(300L);
        this.aej.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSmallGiftView.this.rQ();
                AlaSmallGiftView.this.rR();
                if (AlaSmallGiftView.this.aer != null) {
                    AlaSmallGiftView.this.aer.K(AlaSmallGiftView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ael = ObjectAnimator.ofFloat(this.aeq, "ScaleX", 3.0f, 1.0f);
        this.aem = ObjectAnimator.ofFloat(this.aeq, "ScaleY", 3.0f, 1.0f);
        this.aek = new AnimatorSet();
        this.aek.playTogether(this.ael, this.aem);
        this.aek.setDuration(240L);
        this.aek.setInterpolator(new OvershootInterpolator());
        this.aek.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaSmallGiftView.this.aer != null) {
                    AlaSmallGiftView.this.aer.qU();
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

    private void rK() {
        this.aeo.setVisibility(0);
        this.aee.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL() {
        this.aep.setVisibility(0);
        this.aeg.start();
    }

    private void rM() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aef = ObjectAnimator.ofFloat(this, "TranslationX", screenDimensions[0], 0.0f);
            this.aef.setInterpolator(new OvershootInterpolator());
            this.aef.setDuration(300L);
            this.aef.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.smallgift.AlaSmallGiftView.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaSmallGiftView.this.rL();
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

    private void rN() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        if (screenDimensions[0] > 0 && screenDimensions[1] > 0) {
            this.aed = ObjectAnimator.ofFloat(this, "TranslationX", -screenDimensions[0], 0.0f);
            this.aed.setInterpolator(new OvershootInterpolator());
            this.aed.setDuration(300L);
        }
    }

    public void rO() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            rR();
            if (this.aee != null) {
                this.aee.cancel();
            }
            this.aeo.setVisibility(0);
            if (this.aef == null) {
                rM();
            }
            this.aef.start();
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            rR();
            if (this.aed == null) {
                rN();
            }
            this.aed.start();
            rK();
        }
    }

    public void rP() {
        this.aej.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ() {
        this.aep.setVisibility(8);
    }

    public void rR() {
        setTranslationY(0.0f);
        if (this.aee != null) {
            this.aee.cancel();
        }
        if (this.aeg != null) {
            this.aeg.cancel();
        }
        if (this.aek != null) {
            this.aek.cancel();
        }
        if (this.aed != null) {
            this.aed.cancel();
        }
        if (this.aef != null) {
            this.aef.cancel();
        }
        if (this.aej != null) {
            this.aej.cancel();
        }
    }

    public void setData(d dVar) {
        if (dVar != null && dVar.aaR != null) {
            this.XG = dVar;
            setGiftCnt(dVar.aaX);
            cp(dVar.userName);
            this.Yz.setText(dVar.aaR.pd());
            rS();
            rT();
            rU();
        }
    }

    private void rS() {
        if (this.XG != null) {
            this.aeo.setUrl(this.XG.portrait);
            j.a(this.aeo, this.XG.portrait, false, !StringUtils.isNull(this.XG.appId));
        }
    }

    private void rT() {
        if (this.XG != null && this.XG.aaR != null) {
            this.aep.setVisibility(0);
            this.aep.startLoad(this.XG.aaR.pf(), 10, false);
        }
    }

    private void cp(String str) {
        this.XE.setTag(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(str)) {
            if (TextHelper.getTextLengthWithEmoji(str) > 14) {
                str = TextHelper.subStringWithEmoji(str, 14) + StringHelper.STRING_MORE;
            }
            this.XE.setText(str);
        }
    }

    private void rU() {
        this.aes = this.XG.aaW > 10 ? 1 : 0;
        setSendUserBg(this.aes);
        setGiftNumAnimProperty(this.aes);
    }

    private void setSendUserBg(int i) {
        switch (i) {
            case 0:
                if (this.aet > 0) {
                    this.aen.setBackgroundResource(this.aet);
                } else {
                    this.aen.setBackgroundResource(a.f.gray_circle);
                }
                this.aeq.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
                return;
            case 1:
                this.aen.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape_spec_cnt);
                this.aeq.setTextColor(getResources().getColor(a.d.sdk_cp_other_h));
                return;
            default:
                return;
        }
    }

    private void setGiftNumAnimProperty(int i) {
        int i2;
        switch (i) {
            case 0:
                this.ael.setFloatValues(3.0f, 1.0f);
                this.aem.setFloatValues(3.0f, 1.0f);
                this.aek.setDuration(240L);
                this.aek.setInterpolator(new OvershootInterpolator(4.0f));
                i2 = 0;
                break;
            case 1:
                this.ael.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aem.setFloatValues(1.0f, 1.5f, 1.0f);
                this.aek.setDuration(480L);
                this.aek.setInterpolator(new LinearInterpolator());
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        for (Animator animator : this.aek.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(i2);
            }
        }
    }

    private void setGiftCnt(long j) {
        if (j <= 1) {
            this.aeq.setVisibility(8);
        } else {
            this.aeq.setVisibility(0);
        }
        this.aeq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j)));
    }

    public d getCurGiftData() {
        return this.XG;
    }

    public void e(long j, long j2) {
        rS();
        rT();
        if (j < 1) {
            this.aeq.setVisibility(8);
        } else if (this.XG != null) {
            this.XG.aaX = j2;
            this.XG.aaW = j;
            this.aeq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(j2)));
            rV();
        }
    }

    private void rV() {
        this.aeq.setVisibility(0);
        this.aek.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.XG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.XG.userId), this.XG.userName, this.XG.portrait, this.XG.sex, this.XG.aaT, this.XG.location, this.XG.description, 0L, this.XG.aaV, this.XG.aaU, this.XG.userStatus, this.XG.liveId, this.XG.groupId, this.XG.aaY, this.XG.aaZ, this.XG.appId, this.XG.userName, "")));
        }
    }

    public void onDestroy() {
        rR();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.XG != null && this.XG.aaX < this.XG.aaW) {
            if (this.XG.aaX <= 0) {
                this.XG.aaX = 1L;
            }
            this.aeq.setText(getResources().getString(a.i.ala_gift_stroke_num_tip, Long.valueOf(this.XG.aaX)));
            rV();
        }
    }

    public void setSmallAnimCallBack(a aVar) {
        this.aer = aVar;
    }
}
