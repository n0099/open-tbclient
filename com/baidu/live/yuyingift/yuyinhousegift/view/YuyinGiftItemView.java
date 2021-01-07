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
/* loaded from: classes11.dex */
public class YuyinGiftItemView extends RelativeLayout {
    private final int ccX;
    private RelativeLayout ccY;
    private TbImageView ccZ;
    private LottieAnimationView cda;
    private TextView cdb;
    private TextView cdc;
    private com.baidu.live.yuyingift.yuyinhousegift.a.a cdd;
    private c cde;
    private a cdf;
    private AlaWheatInfoData cdg;
    private float cdh;
    private final int cdi;
    private final int cdj;

    /* loaded from: classes11.dex */
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
        return this.cdg;
    }

    public void setWheatInfoData(AlaWheatInfoData alaWheatInfoData) {
        this.cdg = alaWheatInfoData;
    }

    public YuyinGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccX = 4;
        this.cdi = Color.parseColor("#FFEAAA");
        this.cdj = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.ccY = (RelativeLayout) findViewById(a.f.yuyin_ala_rl_gift_count);
        this.ccZ = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.cda = (LottieAnimationView) findViewById(a.f.yuyin_ala_wheat_gift_lottie);
        this.cdb = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.cdc = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.cdh = BdUtilHelper.dip2px(getContext(), 64.0f);
        this.cda.setAnimation("yuyin_ala_wheat_gift_dbclick.json");
        this.cda.setImageAssetsFolder("wheatgift");
        this.cda.loop(false);
    }

    public void setAnimalCallback(a aVar) {
        this.cdf = aVar;
    }

    public void G(c cVar) {
        if (cVar != null) {
            this.ccZ.startLoad(cVar.bex == null ? com.baidu.pass.biometrics.face.liveness.c.a.p : cVar.bex.getThumbnail_url(), 12, false);
            this.cdb.setText(String.valueOf(cVar.bZO + cVar.beC));
            this.cde = cVar;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.cdi), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.cdj), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.cdc.setText(spannableStringBuilder);
            setVisibility(4);
        }
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a m(final float f, final float f2) {
        this.cdd = new com.baidu.live.yuyingift.yuyinhousegift.a.c(this);
        ((com.baidu.live.yuyingift.yuyinhousegift.a.c) this.cdd).a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.c.a
            public void abA() {
                YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                YuyinGiftItemView.this.setY(f2);
                YuyinGiftItemView.this.setVisibility(0);
            }
        });
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.y(YuyinGiftItemView.this.cde);
                }
            }
        });
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a abH() {
        if (this.cdg == null || this.cdg.locationCenterX == 0.0f) {
            return null;
        }
        this.cdd = new e(this, getX(), getY(), this.cdg.locationCenterX - (getWidth() / 2), this.cdg.locationCenterY - this.cdh);
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.z(YuyinGiftItemView.this.cde);
                }
            }
        });
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a abI() {
        this.cdd = new d(this);
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.A(YuyinGiftItemView.this.cde);
                }
            }
        });
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a H(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdd = new com.baidu.live.yuyingift.yuyinhousegift.a.b(this);
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.C(cVar);
                }
            }
        });
        this.cde = cVar;
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public String I(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aZQ > 0) {
                return String.valueOf(cVar.bZO + cVar.beC);
            }
            long j = 1;
            try {
                j = cVar.beC + Integer.parseInt(this.cdb.getText().toString());
            } catch (Exception e) {
            }
            return String.valueOf(j);
        }
        return "1";
    }

    public int getNowShowCount() {
        try {
            return Integer.parseInt(this.cdb.getText().toString());
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
            if (this.cdg != null && this.cdg.locationCenterY != 0.0f) {
                setY(f2 - this.cdh);
            } else {
                setY(f2);
            }
            if (this.ccY != null) {
                this.cdd = new i(this.ccY);
                ((i) this.cdd).a(new i.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.8
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.i.a
                    public void abA() {
                        YuyinGiftItemView.this.cda.playAnimation();
                        YuyinGiftItemView.this.cdb.setText(YuyinGiftItemView.this.I(cVar));
                    }
                });
                this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                            YuyinGiftItemView.this.cdf.B(cVar);
                        }
                    }
                });
                this.cde = cVar;
                this.cdd.cae = cVar;
                this.cdd.ccF.start();
                return this.cdd;
            }
            return null;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a b(final com.baidu.live.yuyingift.a.c cVar, final float f, final float f2) {
        if (cVar != null) {
            if ((f == 0.0f && f2 == 0.0f) || this.cdb == null) {
                return null;
            }
            this.cdd = new g(this);
            ((g) this.cdd).a(new g.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.10
                @Override // com.baidu.live.yuyingift.yuyinhousegift.a.g.a
                public void abA() {
                    YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                    if (YuyinGiftItemView.this.cdg != null && YuyinGiftItemView.this.cdg.locationCenterY != 0.0f) {
                        YuyinGiftItemView.this.setY(f2 - YuyinGiftItemView.this.cdh);
                    } else {
                        YuyinGiftItemView.this.setY(f2);
                    }
                    YuyinGiftItemView.this.setVisibility(0);
                    YuyinGiftItemView.this.cda.playAnimation();
                    YuyinGiftItemView.this.cdb.setText(YuyinGiftItemView.this.I(cVar));
                }
            });
            this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                        YuyinGiftItemView.this.cdf.D(cVar);
                    }
                }
            });
            this.cde = cVar;
            this.cdd.cae = this.cde;
            this.cdd.ccF.start();
            return this.cdd;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a J(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdd = new h(this);
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.E(cVar);
                }
            }
        });
        this.cde = cVar;
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a K(final com.baidu.live.yuyingift.a.c cVar) {
        this.cdd = new f(this);
        this.cdd.ccF.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MH && YuyinGiftItemView.this.cdf != null) {
                    YuyinGiftItemView.this.cdf.F(cVar);
                }
            }
        });
        this.cde = cVar;
        this.cdd.cae = this.cde;
        this.cdd.ccF.start();
        return this.cdd;
    }

    public void cancel() {
        if (this.cdd != null) {
            this.cdd.cancel();
        }
    }

    /* loaded from: classes11.dex */
    private class b extends AnimatorListenerAdapter {
        protected boolean MH;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.MH = true;
        }
    }
}
