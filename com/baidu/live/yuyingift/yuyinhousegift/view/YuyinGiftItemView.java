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
    private final int ccm;
    private RelativeLayout ccn;
    private TbImageView cco;
    private LottieAnimationView ccp;
    private TextView ccq;
    private TextView ccr;
    private com.baidu.live.yuyingift.yuyinhousegift.a.a cct;
    private c ccu;
    private a ccv;
    private AlaWheatInfoData ccw;
    private float ccx;
    private final int ccy;
    private final int ccz;

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
        return this.ccw;
    }

    public void setWheatInfoData(AlaWheatInfoData alaWheatInfoData) {
        this.ccw = alaWheatInfoData;
    }

    public YuyinGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccm = 4;
        this.ccy = Color.parseColor("#FFEAAA");
        this.ccz = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.ccn = (RelativeLayout) findViewById(a.f.yuyin_ala_rl_gift_count);
        this.cco = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.ccp = (LottieAnimationView) findViewById(a.f.yuyin_ala_wheat_gift_lottie);
        this.ccq = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.ccr = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.ccx = BdUtilHelper.dip2px(getContext(), 64.0f);
        this.ccp.setAnimation("yuyin_ala_wheat_gift_dbclick.json");
        this.ccp.setImageAssetsFolder("wheatgift");
        this.ccp.loop(false);
    }

    public void setAnimalCallback(a aVar) {
        this.ccv = aVar;
    }

    public void G(c cVar) {
        if (cVar != null) {
            this.cco.startLoad(cVar.bcO == null ? com.baidu.pass.biometrics.face.liveness.c.a.p : cVar.bcO.getThumbnail_url(), 12, false);
            this.ccq.setText(String.valueOf(cVar.bZe + cVar.bcT));
            this.ccu = cVar;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ccy), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ccz), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.ccr.setText(spannableStringBuilder);
            setVisibility(4);
        }
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a n(final float f, final float f2) {
        this.cct = new com.baidu.live.yuyingift.yuyinhousegift.a.c(this);
        ((com.baidu.live.yuyingift.yuyinhousegift.a.c) this.cct).a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.c.a
            public void Zx() {
                YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                YuyinGiftItemView.this.setY(f2);
                YuyinGiftItemView.this.setVisibility(0);
            }
        });
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.y(YuyinGiftItemView.this.ccu);
                }
            }
        });
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a ZE() {
        if (this.ccw == null || this.ccw.locationCenterX == 0.0f) {
            return null;
        }
        this.cct = new e(this, getX(), getY(), this.ccw.locationCenterX - (getWidth() / 2), this.ccw.locationCenterY - this.ccx);
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.z(YuyinGiftItemView.this.ccu);
                }
            }
        });
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a ZF() {
        this.cct = new d(this);
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.A(YuyinGiftItemView.this.ccu);
                }
            }
        });
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a H(final com.baidu.live.yuyingift.a.c cVar) {
        this.cct = new com.baidu.live.yuyingift.yuyinhousegift.a.b(this);
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.C(cVar);
                }
            }
        });
        this.ccu = cVar;
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public String I(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aYl > 0) {
                return String.valueOf(cVar.bZe + cVar.bcT);
            }
            long j = 1;
            try {
                j = cVar.bcT + Integer.parseInt(this.ccq.getText().toString());
            } catch (Exception e) {
            }
            return String.valueOf(j);
        }
        return "1";
    }

    public int getNowShowCount() {
        try {
            return Integer.parseInt(this.ccq.getText().toString());
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
            if (this.ccw != null && this.ccw.locationCenterY != 0.0f) {
                setY(f2 - this.ccx);
            } else {
                setY(f2);
            }
            if (this.ccn != null) {
                this.cct = new i(this.ccn);
                ((i) this.cct).a(new i.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.8
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.i.a
                    public void Zx() {
                        YuyinGiftItemView.this.ccp.playAnimation();
                        YuyinGiftItemView.this.ccq.setText(YuyinGiftItemView.this.I(cVar));
                    }
                });
                this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                            YuyinGiftItemView.this.ccv.B(cVar);
                        }
                    }
                });
                this.ccu = cVar;
                this.cct.bZu = cVar;
                this.cct.cbU.start();
                return this.cct;
            }
            return null;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a b(final com.baidu.live.yuyingift.a.c cVar, final float f, final float f2) {
        if (cVar != null) {
            if ((f == 0.0f && f2 == 0.0f) || this.ccq == null) {
                return null;
            }
            this.cct = new g(this);
            ((g) this.cct).a(new g.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.10
                @Override // com.baidu.live.yuyingift.yuyinhousegift.a.g.a
                public void Zx() {
                    YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                    if (YuyinGiftItemView.this.ccw != null && YuyinGiftItemView.this.ccw.locationCenterY != 0.0f) {
                        YuyinGiftItemView.this.setY(f2 - YuyinGiftItemView.this.ccx);
                    } else {
                        YuyinGiftItemView.this.setY(f2);
                    }
                    YuyinGiftItemView.this.setVisibility(0);
                    YuyinGiftItemView.this.ccp.playAnimation();
                    YuyinGiftItemView.this.ccq.setText(YuyinGiftItemView.this.I(cVar));
                }
            });
            this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                        YuyinGiftItemView.this.ccv.D(cVar);
                    }
                }
            });
            this.ccu = cVar;
            this.cct.bZu = this.ccu;
            this.cct.cbU.start();
            return this.cct;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a J(final com.baidu.live.yuyingift.a.c cVar) {
        this.cct = new h(this);
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.E(cVar);
                }
            }
        });
        this.ccu = cVar;
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a K(final com.baidu.live.yuyingift.a.c cVar) {
        this.cct = new f(this);
        this.cct.cbU.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MD && YuyinGiftItemView.this.ccv != null) {
                    YuyinGiftItemView.this.ccv.F(cVar);
                }
            }
        });
        this.ccu = cVar;
        this.cct.bZu = this.ccu;
        this.cct.cbU.start();
        return this.cct;
    }

    public void cancel() {
        if (this.cct != null) {
            this.cct.cancel();
        }
    }

    /* loaded from: classes11.dex */
    private class b extends AnimatorListenerAdapter {
        protected boolean MD;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.MD = true;
        }
    }
}
