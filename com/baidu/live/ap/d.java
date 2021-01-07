package com.baidu.live.ap;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes11.dex */
public class d extends e implements f {
    private b bXg;
    private int bXh;
    private c bXi;
    private boolean bXj;
    private RoundRectRelativeLayout byQ;
    private CommonWebLayout byR;
    private View byS;
    private float byT;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bXj = false;
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.byR;
    }

    public void c(c cVar) {
        int aak;
        int aal;
        int i;
        int aaj;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bXi = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bXg = cVar.bXg;
                if (cVar.bXg != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ap.d.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bXg != null) {
                                d.this.bXg.onDismiss();
                            }
                        }
                    });
                }
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bXh = 5;
                        if (cVar.isFullScreen) {
                            aak = aai();
                        } else {
                            aak = aak();
                        }
                        aal = aal();
                        this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
                        i = aak;
                        break;
                    default:
                        this.bXh = 80;
                        i = aai();
                        if (cVar.isFullScreen) {
                            ah(this.byQ);
                            setClippingEnabled(false);
                            this.byQ.setSystemUiVisibility(4870);
                            aal = -1;
                            break;
                        } else {
                            float f = 0.7f;
                            if (cVar != null) {
                                f = cVar.bXf;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            if (f > 1.0f) {
                                aaj = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                            } else {
                                aaj = (int) (f * aaj());
                            }
                            setClippingEnabled(true);
                            this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                            aal = aaj;
                            break;
                        }
                }
                setWidth(i);
                setHeight(aal);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.byQ);
                }
                Oj();
                this.byR.loadUrl(cVar.url);
                if (this.bXg != null) {
                    this.bXg.onShow();
                }
            }
        }
    }

    public void d(c cVar) {
        int aaj;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bXi = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bXg = cVar.bXg;
                if (cVar.bXg != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ap.d.2
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bXg != null) {
                                d.this.bXg.onDismiss();
                            }
                        }
                    });
                }
                this.bXh = 80;
                int aai = aai();
                if (cVar.isFullScreen) {
                    aaj = -1;
                    ah(this.byQ);
                    setClippingEnabled(false);
                    this.byQ.setSystemUiVisibility(4870);
                } else {
                    float f = 0.7f;
                    if (cVar != null) {
                        f = cVar.bXf;
                    }
                    if (f <= 0.1f) {
                        f = 0.1f;
                    }
                    if (f > 1.0f) {
                        aaj = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                    } else {
                        aaj = (int) (f * aaj());
                    }
                    setClippingEnabled(true);
                    this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                }
                setWidth(aai);
                setHeight(aaj);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.byQ);
                }
                Oj();
                this.byR.loadUrl(cVar.url);
                if (this.bXg != null) {
                    this.bXg.onShow();
                }
            }
        }
    }

    public void dU(int i) {
        int aak;
        int aal;
        int i2;
        int aaj;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bXh = 5;
                    if (this.bXi.isFullScreen) {
                        aak = aai();
                    } else {
                        aak = aak();
                    }
                    aal = aal();
                    this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
                    i2 = aak;
                    break;
                default:
                    this.bXh = 80;
                    i2 = aai();
                    if (this.bXi.isFullScreen) {
                        int aaj2 = aaj();
                        ah(this.byQ);
                        setClippingEnabled(false);
                        this.byQ.setSystemUiVisibility(4870);
                        aal = aaj2;
                        break;
                    } else {
                        float f = 0.7f;
                        if (this.bXi != null) {
                            f = this.bXi.bXf;
                        }
                        if (f <= 0.1f) {
                            f = 0.1f;
                        }
                        if (f > 1.0f) {
                            aaj = (int) f;
                        } else {
                            aaj = (int) (f * aaj());
                        }
                        setClippingEnabled(true);
                        this.byQ.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
                        aal = aaj;
                        break;
                    }
            }
            update(i2, aal);
            if (i == 2) {
                ah(this.byQ);
            }
        }
    }

    public void aah() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!aam() || this.bXi.url.contains("disableDisAnimation=1")) {
            aah();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ap.d.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.byR != null) {
                    d.this.byR.release();
                }
            }
        });
    }

    private void initView() {
        this.byT = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.byQ = new RoundRectRelativeLayout(this.mContext);
        q(this.byQ);
        r(this.byQ);
        setContentView(this.byQ);
    }

    private void q(ViewGroup viewGroup) {
        this.byR = new CommonWebLayout(this.mContext);
        this.byR.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.byR.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.ap.d.4
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if  reason: not valid java name */
            public void mo20if(String str) {
                super.mo20if(str);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.byS = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.byS, layoutParams);
        this.byS.setVisibility(8);
    }

    private int aai() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int aaj() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int aak() {
        return aal();
    }

    private int aal() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void Oj() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXh) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean aam() {
        if (getContentView() == null) {
            return false;
        }
        if (this.bXj) {
            return true;
        }
        this.bXj = true;
        TranslateAnimation translateAnimation = null;
        switch (this.bXh) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.ap.d.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.bXj = false;
                    d.this.aah();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
