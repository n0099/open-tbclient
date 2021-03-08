package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.a.d;
import com.baidu.live.yuyingift.yuyinhousegift.a.e;
import com.baidu.live.yuyingift.yuyinhousegift.a.f;
import com.baidu.live.yuyingift.yuyinhousegift.a.g;
import com.baidu.live.yuyingift.yuyinhousegift.a.h;
import com.baidu.live.yuyingift.yuyinhousegift.a.i;
/* loaded from: classes10.dex */
public class YuyinGiftItemView extends RelativeLayout {
    private final int cdP;
    private RelativeLayout cdQ;
    private TbImageView cdR;
    private LottieAnimationView cdS;
    private TextView cdT;
    private TextView cdU;
    private com.baidu.live.yuyingift.yuyinhousegift.a.a cdV;
    private c cdW;
    private a cdX;
    private AlaWheatInfoData cdY;
    private float cdZ;
    private final int cea;
    private final int ceb;

    /* loaded from: classes10.dex */
    public interface a {
        void A(c cVar);

        void B(c cVar);

        void C(c cVar);

        void D(c cVar);

        void E(c cVar);

        void F(c cVar);

        void y(c cVar);

        void z(c cVar);
    }

    public AlaWheatInfoData getWheatInfoData() {
        return this.cdY;
    }

    public void setWheatInfoData(AlaWheatInfoData alaWheatInfoData) {
        this.cdY = alaWheatInfoData;
    }

    public YuyinGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdP = 4;
        this.cea = Color.parseColor("#FFEAAA");
        this.ceb = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.cdQ = (RelativeLayout) findViewById(a.f.yuyin_ala_rl_gift_count);
        this.cdR = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.cdS = (LottieAnimationView) findViewById(a.f.yuyin_ala_wheat_gift_lottie);
        this.cdT = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.cdU = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.cdZ = BdUtilHelper.dip2px(getContext(), 64.0f);
        this.cdS.setAnimation("yuyin_ala_wheat_gift_dbclick.json");
        this.cdS.setImageAssetsFolder("wheatgift");
        this.cdS.loop(false);
    }

    public void setAnimalCallback(a aVar) {
        this.cdX = aVar;
    }

    public void G(c cVar) {
        if (cVar != null) {
            this.cdR.startLoad(cVar.bep == null ? com.baidu.pass.biometrics.face.liveness.c.a.p : cVar.bep.getThumbnail_url(), 12, false);
            this.cdT.setText(String.valueOf(cVar.caE + cVar.bev));
            this.cdW = cVar;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.cea), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ceb), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.cdU.setText(spannableStringBuilder);
            setVisibility(4);
        }
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a n(final float f, final float f2) {
        this.cdV = new com.baidu.live.yuyingift.yuyinhousegift.a.c(this);
        ((com.baidu.live.yuyingift.yuyinhousegift.a.c) this.cdV).a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.c.a
            public void ZA() {
                YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                YuyinGiftItemView.this.setY(f2);
                YuyinGiftItemView.this.setVisibility(0);
            }
        });
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.y(YuyinGiftItemView.this.cdW);
                }
            }
        });
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a ZH() {
        if (this.cdY == null || this.cdY.locationCenterX == 0.0f) {
            return null;
        }
        this.cdV = new e(this, getX(), getY(), this.cdY.locationCenterX - (getWidth() / 2), this.cdY.locationCenterY - this.cdZ);
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.z(YuyinGiftItemView.this.cdW);
                }
            }
        });
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a ZI() {
        this.cdV = new d(this);
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.A(YuyinGiftItemView.this.cdW);
                }
            }
        });
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a H(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdV = new com.baidu.live.yuyingift.yuyinhousegift.a.b(this);
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.C(cVar);
                }
            }
        });
        this.cdW = cVar;
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public String I(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aZL > 0) {
                return String.valueOf(cVar.caE + cVar.bev);
            }
            long j = 1;
            try {
                j = cVar.bev + Integer.parseInt(this.cdT.getText().toString());
            } catch (Exception e) {
            }
            return String.valueOf(j);
        }
        return "1";
    }

    public int getNowShowCount() {
        try {
            return Integer.parseInt(this.cdT.getText().toString());
        } catch (Exception e) {
            return 1;
        }
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a a(final com.baidu.live.yuyingift.a.c cVar, float f, float f2) {
        if (cVar != null) {
            if (f == 0.0f && f2 == 0.0f) {
                return null;
            }
            setX(f - (getWidth() / 2));
            if (this.cdY != null && this.cdY.locationCenterY != 0.0f) {
                setY(f2 - this.cdZ);
            } else {
                setY(f2);
            }
            if (this.cdQ != null) {
                this.cdV = new i(this.cdQ);
                ((i) this.cdV).a(new i.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.8
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.i.a
                    public void ZA() {
                        YuyinGiftItemView.this.cdS.playAnimation();
                        YuyinGiftItemView.this.cdT.setText(YuyinGiftItemView.this.I(cVar));
                    }
                });
                this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                            YuyinGiftItemView.this.cdX.B(cVar);
                        }
                    }
                });
                this.cdW = cVar;
                this.cdV.caU = cVar;
                this.cdV.cdx.start();
                return this.cdV;
            }
            return null;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a b(final com.baidu.live.yuyingift.a.c cVar, final float f, final float f2) {
        if (cVar != null) {
            if ((f == 0.0f && f2 == 0.0f) || this.cdT == null) {
                return null;
            }
            this.cdV = new g(this);
            ((g) this.cdV).a(new g.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.10
                @Override // com.baidu.live.yuyingift.yuyinhousegift.a.g.a
                public void ZA() {
                    YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                    if (YuyinGiftItemView.this.cdY != null && YuyinGiftItemView.this.cdY.locationCenterY != 0.0f) {
                        YuyinGiftItemView.this.setY(f2 - YuyinGiftItemView.this.cdZ);
                    } else {
                        YuyinGiftItemView.this.setY(f2);
                    }
                    YuyinGiftItemView.this.setVisibility(0);
                    YuyinGiftItemView.this.cdS.playAnimation();
                    YuyinGiftItemView.this.cdT.setText(YuyinGiftItemView.this.I(cVar));
                }
            });
            this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                        YuyinGiftItemView.this.cdX.D(cVar);
                    }
                }
            });
            this.cdW = cVar;
            this.cdV.caU = this.cdW;
            this.cdV.cdx.start();
            return this.cdV;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a J(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdV = new h(this);
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.E(cVar);
                }
            }
        });
        this.cdW = cVar;
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a K(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdV = new f(this);
        this.cdV.cdx.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.Od && YuyinGiftItemView.this.cdX != null) {
                    YuyinGiftItemView.this.cdX.F(cVar);
                }
            }
        });
        this.cdW = cVar;
        this.cdV.caU = this.cdW;
        this.cdV.cdx.start();
        return this.cdV;
    }

    public void cancel() {
        if (this.cdV != null) {
            this.cdV.cancel();
        }
    }

    /* loaded from: classes10.dex */
    private class b extends AnimatorListenerAdapter {
        protected boolean Od;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.Od = true;
        }
    }
}
