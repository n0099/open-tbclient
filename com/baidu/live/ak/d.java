package com.baidu.live.ak;

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
/* loaded from: classes4.dex */
public class d extends e implements f {
    private b bMt;
    private int bMu;
    private c bMv;
    private RoundRectRelativeLayout boV;
    private CommonWebLayout boW;
    private View boX;
    private float boY;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout Wq() {
        return this.boW;
    }

    public void b(c cVar) {
        int Wu;
        int Wv;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bMv = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bMt = cVar.bMt;
                if (cVar.bMt != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ak.d.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bMt != null) {
                                d.this.bMt.onDismiss();
                            }
                        }
                    });
                }
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bMu = 5;
                        Wu = Wu();
                        Wv = Wv();
                        this.boV.setCornerRadius(this.boY, 0.0f, 0.0f, this.boY);
                        break;
                    default:
                        this.bMu = 80;
                        int Ws = Ws();
                        if (cVar.isFullScreen) {
                            Wv = -1;
                            ah(this.boV);
                            setClippingEnabled(false);
                            Wu = Ws;
                            break;
                        } else {
                            float f = 0.7f;
                            if (cVar != null) {
                                f = cVar.bMs;
                            }
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            Wv = (int) (f * Wt());
                            this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
                            Wu = Ws;
                            break;
                        }
                }
                setWidth(Wu);
                setHeight(Wv);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.boV);
                }
                Mi();
                this.boW.loadUrl(cVar.url);
                if (this.bMt != null) {
                    this.bMt.Ot();
                }
            }
        }
    }

    public void dE(int i) {
        int Wu;
        int Wv;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bMu = 5;
                    Wu = Wu();
                    Wv = Wv();
                    this.boV.setCornerRadius(this.boY, 0.0f, 0.0f, this.boY);
                    break;
                default:
                    this.bMu = 80;
                    int Ws = Ws();
                    if (this.bMv.isFullScreen) {
                        Wv = Wt();
                        ah(this.boV);
                        setClippingEnabled(false);
                        Wu = Ws;
                        break;
                    } else {
                        float f = 0.7f;
                        if (this.bMv != null) {
                            f = this.bMv.bMs;
                        }
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        if (f <= 0.1f) {
                            f = 0.1f;
                        }
                        Wv = (int) (f * Wt());
                        this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
                        Wu = Ws;
                        break;
                    }
            }
            update(Wu, Wv);
            if (i == 2) {
                ah(this.boV);
            }
        }
    }

    public void Wr() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Ww()) {
            Wr();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ak.d.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.boW != null) {
                    d.this.boW.release();
                }
            }
        });
    }

    private void initView() {
        this.boY = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.boV = new RoundRectRelativeLayout(this.mContext);
        n(this.boV);
        o(this.boV);
        setContentView(this.boV);
    }

    private void n(ViewGroup viewGroup) {
        this.boW = new CommonWebLayout(this.mContext);
        this.boW.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.boW.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.ak.d.3
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.boX = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.boX, layoutParams);
        this.boX.setVisibility(8);
    }

    private int Ws() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Wt() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int Wu() {
        return Wv();
    }

    private int Wv() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void Mi() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bMu) {
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

    private boolean Ww() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bMu) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.ak.d.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.Wr();
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
    public void eT(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
