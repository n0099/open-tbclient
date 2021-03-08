package com.baidu.live.an;

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
import com.baidu.live.utils.p;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes10.dex */
public class d extends e implements f {
    private float bBH;
    private RoundRectRelativeLayout bXV;
    private int bXW;
    private c bXX;
    public boolean bXY;
    private boolean bXZ;
    private CommonWebLayout bXc;
    private View bXd;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bXY = false;
        this.bXZ = false;
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bXc;
    }

    public void b(c cVar, b bVar) {
        int Yj;
        int Yk;
        int i;
        int Yi;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bXX = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bXW = 5;
                        if (cVar.isFullScreen) {
                            Yj = Yh();
                        } else {
                            Yj = Yj();
                        }
                        Yk = Yk();
                        setClippingEnabled(true);
                        this.bXV.setCornerRadius(this.bBH, 0.0f, 0.0f, this.bBH);
                        i = Yj;
                        break;
                    default:
                        this.bXW = 80;
                        i = Yh();
                        if (cVar.isFullScreen) {
                            ah(this.bXV);
                            setClippingEnabled(false);
                            this.bXV.setSystemUiVisibility(4870);
                            Yk = -1;
                            break;
                        } else {
                            if (cVar.bXT == 1) {
                                Yi = Ye();
                            } else {
                                float f = 0.7f;
                                if (cVar != null) {
                                    f = cVar.bXS;
                                }
                                if (f <= 0.1f) {
                                    f = 0.1f;
                                }
                                if (f > 1.0f) {
                                    Yi = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                                } else {
                                    Yi = (int) (f * Yi());
                                }
                            }
                            setClippingEnabled(true);
                            this.bXV.setCornerRadius(this.bBH, this.bBH, 0.0f, 0.0f);
                            Yk = Yi;
                            break;
                        }
                }
                setWidth(i);
                setHeight(Yk);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.bXV);
                }
                LQ();
                this.bXc.loadUrl(cVar.url);
                if (bVar != null) {
                    bVar.onShow();
                }
            }
        }
    }

    public void cs(int i) {
        int Yj;
        int Yk;
        int i2;
        int Yi;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bXW = 5;
                    if (this.bXX.isFullScreen) {
                        Yj = Yh();
                    } else {
                        Yj = Yj();
                    }
                    Yk = Yk();
                    setClippingEnabled(true);
                    this.bXV.setCornerRadius(this.bBH, 0.0f, 0.0f, this.bBH);
                    i2 = Yj;
                    break;
                default:
                    this.bXW = 80;
                    i2 = Yh();
                    if (this.bXX.isFullScreen) {
                        int Yi2 = Yi();
                        ah(this.bXV);
                        setClippingEnabled(false);
                        this.bXV.setSystemUiVisibility(4870);
                        Yk = Yi2;
                        break;
                    } else {
                        if (this.bXX.bXT == 1) {
                            Yi = Ye();
                        } else {
                            float f = 0.7f;
                            if (this.bXX != null) {
                                f = this.bXX.bXS;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            if (f > 1.0f) {
                                Yi = (int) f;
                            } else {
                                Yi = (int) (f * Yi());
                            }
                        }
                        setClippingEnabled(true);
                        this.bXV.setCornerRadius(this.bBH, this.bBH, 0.0f, 0.0f);
                        Yk = Yi;
                        break;
                    }
            }
            update(i2, Yk);
            if (i == 2) {
                ah(this.bXV);
            }
        }
    }

    private int Ye() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mContext) - p.bt(this.mContext);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    public void Yf() {
        super.dismiss();
    }

    public c Yg() {
        return this.bXX;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yl() || this.bXX.url.contains("disableDisAnimation=1")) {
            Yf();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.an.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.bXc != null) {
                    d.this.bXc.release();
                }
            }
        });
    }

    private void initView() {
        this.bBH = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bXV = new RoundRectRelativeLayout(this.mContext);
        x(this.bXV);
        y(this.bXV);
        setContentView(this.bXV);
    }

    private void x(ViewGroup viewGroup) {
        this.bXc = new CommonWebLayout(this.mContext);
        this.bXc.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bXc.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.an.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iz(String str) {
                super.iz(str);
                if (d.this.bXd != null && !d.this.bXY) {
                    d.this.bXd.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fo(int i) {
                super.fo(i);
                if (i == 100 && d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iA(String str) {
                super.iA(str);
                if (d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void f(String str, int i, String str2) {
                super.f(str, i, str2);
                if (d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bXc, new ViewGroup.LayoutParams(-1, -1));
    }

    private void y(ViewGroup viewGroup) {
        this.bXd = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bXd, layoutParams);
        this.bXd.setVisibility(8);
    }

    private int Yh() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Yi() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int Yj() {
        return Yk();
    }

    private int Yk() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void LQ() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXW) {
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

    private boolean Yl() {
        if (getContentView() == null) {
            return false;
        }
        if (this.bXZ) {
            return true;
        }
        this.bXZ = true;
        TranslateAnimation translateAnimation = null;
        switch (this.bXW) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.an.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.bXZ = false;
                    d.this.Yf();
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
    public void fq(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
