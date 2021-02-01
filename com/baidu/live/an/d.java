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
/* loaded from: classes11.dex */
public class d extends e implements f {
    private float bAh;
    private CommonWebLayout bVC;
    private View bVD;
    private RoundRectRelativeLayout bWv;
    private int bWw;
    private c bWx;
    public boolean bWy;
    private boolean bWz;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bWy = false;
        this.bWz = false;
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bVC;
    }

    public void b(c cVar, b bVar) {
        int Yg;
        int Yh;
        int i;
        int Yf;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bWx = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bWw = 5;
                        if (cVar.isFullScreen) {
                            Yg = Ye();
                        } else {
                            Yg = Yg();
                        }
                        Yh = Yh();
                        setClippingEnabled(true);
                        this.bWv.setCornerRadius(this.bAh, 0.0f, 0.0f, this.bAh);
                        i = Yg;
                        break;
                    default:
                        this.bWw = 80;
                        i = Ye();
                        if (cVar.isFullScreen) {
                            ah(this.bWv);
                            setClippingEnabled(false);
                            this.bWv.setSystemUiVisibility(4870);
                            Yh = -1;
                            break;
                        } else {
                            if (cVar.bWt == 1) {
                                Yf = Yb();
                            } else {
                                float f = 0.7f;
                                if (cVar != null) {
                                    f = cVar.bWs;
                                }
                                if (f <= 0.1f) {
                                    f = 0.1f;
                                }
                                if (f > 1.0f) {
                                    Yf = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                                } else {
                                    Yf = (int) (f * Yf());
                                }
                            }
                            setClippingEnabled(true);
                            this.bWv.setCornerRadius(this.bAh, this.bAh, 0.0f, 0.0f);
                            Yh = Yf;
                            break;
                        }
                }
                setWidth(i);
                setHeight(Yh);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.bWv);
                }
                LN();
                this.bVC.loadUrl(cVar.url);
                if (bVar != null) {
                    bVar.onShow();
                }
            }
        }
    }

    public void cr(int i) {
        int Yg;
        int Yh;
        int i2;
        int Yf;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bWw = 5;
                    if (this.bWx.isFullScreen) {
                        Yg = Ye();
                    } else {
                        Yg = Yg();
                    }
                    Yh = Yh();
                    setClippingEnabled(true);
                    this.bWv.setCornerRadius(this.bAh, 0.0f, 0.0f, this.bAh);
                    i2 = Yg;
                    break;
                default:
                    this.bWw = 80;
                    i2 = Ye();
                    if (this.bWx.isFullScreen) {
                        int Yf2 = Yf();
                        ah(this.bWv);
                        setClippingEnabled(false);
                        this.bWv.setSystemUiVisibility(4870);
                        Yh = Yf2;
                        break;
                    } else {
                        if (this.bWx.bWt == 1) {
                            Yf = Yb();
                        } else {
                            float f = 0.7f;
                            if (this.bWx != null) {
                                f = this.bWx.bWs;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            if (f > 1.0f) {
                                Yf = (int) f;
                            } else {
                                Yf = (int) (f * Yf());
                            }
                        }
                        setClippingEnabled(true);
                        this.bWv.setCornerRadius(this.bAh, this.bAh, 0.0f, 0.0f);
                        Yh = Yf;
                        break;
                    }
            }
            update(i2, Yh);
            if (i == 2) {
                ah(this.bWv);
            }
        }
    }

    private int Yb() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mContext) - p.bu(this.mContext);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    public void Yc() {
        super.dismiss();
    }

    public c Yd() {
        return this.bWx;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yi() || this.bWx.url.contains("disableDisAnimation=1")) {
            Yc();
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
                if (d.this.bVC != null) {
                    d.this.bVC.release();
                }
            }
        });
    }

    private void initView() {
        this.bAh = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bWv = new RoundRectRelativeLayout(this.mContext);
        x(this.bWv);
        y(this.bWv);
        setContentView(this.bWv);
    }

    private void x(ViewGroup viewGroup) {
        this.bVC = new CommonWebLayout(this.mContext);
        this.bVC.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bVC.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.an.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (d.this.bVD != null && !d.this.bWy) {
                    d.this.bVD.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fn(int i) {
                super.fn(i);
                if (i == 100 && d.this.bVD != null) {
                    d.this.bVD.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iu(String str) {
                super.iu(str);
                if (d.this.bVD != null) {
                    d.this.bVD.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void f(String str, int i, String str2) {
                super.f(str, i, str2);
                if (d.this.bVD != null) {
                    d.this.bVD.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bVC, new ViewGroup.LayoutParams(-1, -1));
    }

    private void y(ViewGroup viewGroup) {
        this.bVD = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bVD, layoutParams);
        this.bVD.setVisibility(8);
    }

    private int Ye() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Yf() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int Yg() {
        return Yh();
    }

    private int Yh() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void LN() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bWw) {
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

    private boolean Yi() {
        if (getContentView() == null) {
            return false;
        }
        if (this.bWz) {
            return true;
        }
        this.bWz = true;
        TranslateAnimation translateAnimation = null;
        switch (this.bWw) {
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
                    d.this.bWz = false;
                    d.this.Yc();
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
    public void fp(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
