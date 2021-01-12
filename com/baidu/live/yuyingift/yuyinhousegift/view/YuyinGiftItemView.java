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
    private final int bYj;
    private RelativeLayout bYk;
    private TbImageView bYl;
    private LottieAnimationView bYm;
    private TextView bYn;
    private TextView bYo;
    private com.baidu.live.yuyingift.yuyinhousegift.a.a bYp;
    private c bYq;
    private a bYr;
    private AlaWheatInfoData bYs;
    private float bYt;
    private final int bYu;
    private final int bYv;

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
        return this.bYs;
    }

    public void setWheatInfoData(AlaWheatInfoData alaWheatInfoData) {
        this.bYs = alaWheatInfoData;
    }

    public YuyinGiftItemView(Context context) {
        this(context, null);
    }

    public YuyinGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYj = 4;
        this.bYu = Color.parseColor("#FFEAAA");
        this.bYv = Color.parseColor("#FFFFFF");
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_item_room_gift_view, this);
        this.bYk = (RelativeLayout) findViewById(a.f.yuyin_ala_rl_gift_count);
        this.bYl = (TbImageView) findViewById(a.f.yuyin_ala_iv_gift_animal_icon);
        this.bYm = (LottieAnimationView) findViewById(a.f.yuyin_ala_wheat_gift_lottie);
        this.bYn = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_count);
        this.bYo = (TextView) findViewById(a.f.yuyin_ala_tv_gift_animal_userhint);
        this.bYt = BdUtilHelper.dip2px(getContext(), 64.0f);
        this.bYm.setAnimation("yuyin_ala_wheat_gift_dbclick.json");
        this.bYm.setImageAssetsFolder("wheatgift");
        this.bYm.loop(false);
    }

    public void setAnimalCallback(a aVar) {
        this.bYr = aVar;
    }

    public void G(c cVar) {
        if (cVar != null) {
            this.bYl.startLoad(cVar.aZH == null ? com.baidu.pass.biometrics.face.liveness.c.a.p : cVar.aZH.getThumbnail_url(), 12, false);
            this.bYn.setText(String.valueOf(cVar.bVc + cVar.aZM));
            this.bYq = cVar;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cVar.userName);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                spannableStringBuilder.append((CharSequence) "某人");
            }
            if (spannableStringBuilder.length() > 4) {
                spannableStringBuilder.replace(4, spannableStringBuilder.length(), (CharSequence) "");
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            }
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bYu), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "送");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.bYv), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.bYo.setText(spannableStringBuilder);
            setVisibility(4);
        }
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a n(final float f, final float f2) {
        this.bYp = new com.baidu.live.yuyingift.yuyinhousegift.a.c(this);
        ((com.baidu.live.yuyingift.yuyinhousegift.a.c) this.bYp).a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.c.a
            public void XH() {
                YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                YuyinGiftItemView.this.setY(f2);
                YuyinGiftItemView.this.setVisibility(0);
            }
        });
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.y(YuyinGiftItemView.this.bYq);
                }
            }
        });
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a XO() {
        if (this.bYs == null || this.bYs.locationCenterX == 0.0f) {
            return null;
        }
        this.bYp = new e(this, getX(), getY(), this.bYs.locationCenterX - (getWidth() / 2), this.bYs.locationCenterY - this.bYt);
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.z(YuyinGiftItemView.this.bYq);
                }
            }
        });
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a XP() {
        this.bYp = new d(this);
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.A(YuyinGiftItemView.this.bYq);
                }
            }
        });
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a H(final com.baidu.live.yuyingift.a.c cVar) {
        this.bYp = new com.baidu.live.yuyingift.yuyinhousegift.a.b(this);
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.C(cVar);
                }
            }
        });
        this.bYq = cVar;
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public String I(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aVd > 0) {
                return String.valueOf(cVar.bVc + cVar.aZM);
            }
            long j = 1;
            try {
                j = cVar.aZM + Integer.parseInt(this.bYn.getText().toString());
            } catch (Exception e) {
            }
            return String.valueOf(j);
        }
        return "1";
    }

    public int getNowShowCount() {
        try {
            return Integer.parseInt(this.bYn.getText().toString());
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
            if (this.bYs != null && this.bYs.locationCenterY != 0.0f) {
                setY(f2 - this.bYt);
            } else {
                setY(f2);
            }
            if (this.bYk != null) {
                this.bYp = new i(this.bYk);
                ((i) this.bYp).a(new i.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.8
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.i.a
                    public void XH() {
                        YuyinGiftItemView.this.bYm.playAnimation();
                        YuyinGiftItemView.this.bYn.setText(YuyinGiftItemView.this.I(cVar));
                    }
                });
                this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                            YuyinGiftItemView.this.bYr.B(cVar);
                        }
                    }
                });
                this.bYq = cVar;
                this.bYp.bVs = cVar;
                this.bYp.bXR.start();
                return this.bYp;
            }
            return null;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a b(final com.baidu.live.yuyingift.a.c cVar, final float f, final float f2) {
        if (cVar != null) {
            if ((f == 0.0f && f2 == 0.0f) || this.bYn == null) {
                return null;
            }
            this.bYp = new g(this);
            ((g) this.bYp).a(new g.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.10
                @Override // com.baidu.live.yuyingift.yuyinhousegift.a.g.a
                public void XH() {
                    YuyinGiftItemView.this.setX(f - (YuyinGiftItemView.this.getWidth() / 2));
                    if (YuyinGiftItemView.this.bYs != null && YuyinGiftItemView.this.bYs.locationCenterY != 0.0f) {
                        YuyinGiftItemView.this.setY(f2 - YuyinGiftItemView.this.bYt);
                    } else {
                        YuyinGiftItemView.this.setY(f2);
                    }
                    YuyinGiftItemView.this.setVisibility(0);
                    YuyinGiftItemView.this.bYm.playAnimation();
                    YuyinGiftItemView.this.bYn.setText(YuyinGiftItemView.this.I(cVar));
                }
            });
            this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                        YuyinGiftItemView.this.bYr.D(cVar);
                    }
                }
            });
            this.bYq = cVar;
            this.bYp.bVs = this.bYq;
            this.bYp.bXR.start();
            return this.bYp;
        }
        return null;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a J(final com.baidu.live.yuyingift.a.c cVar) {
        this.bYp = new h(this);
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.E(cVar);
                }
            }
        });
        this.bYq = cVar;
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public com.baidu.live.yuyingift.yuyinhousegift.a.a K(final com.baidu.live.yuyingift.a.c cVar) {
        this.bYp = new f(this);
        this.bYp.bXR.addListener(new b() { // from class: com.baidu.live.yuyingift.yuyinhousegift.view.YuyinGiftItemView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.MF && YuyinGiftItemView.this.bYr != null) {
                    YuyinGiftItemView.this.bYr.F(cVar);
                }
            }
        });
        this.bYq = cVar;
        this.bYp.bVs = this.bYq;
        this.bYp.bXR.start();
        return this.bYp;
    }

    public void cancel() {
        if (this.bYp != null) {
            this.bYp.cancel();
        }
    }

    /* loaded from: classes10.dex */
    private class b extends AnimatorListenerAdapter {
        protected boolean MF;

        private b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.MF = true;
        }
    }
}
