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
/* loaded from: classes10.dex */
public class d extends e implements f {
    private b bSu;
    private int bSv;
    private c bSw;
    private boolean bSx;
    private RoundRectRelativeLayout bud;
    private CommonWebLayout bue;
    private View bug;
    private float buh;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bSx = false;
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bue;
    }

    public void c(c cVar) {
        int Wr;
        int Ws;
        int i;
        int Wq;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bSw = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bSu = cVar.bSu;
                if (cVar.bSu != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ap.d.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bSu != null) {
                                d.this.bSu.onDismiss();
                            }
                        }
                    });
                }
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bSv = 5;
                        if (cVar.isFullScreen) {
                            Wr = Wp();
                        } else {
                            Wr = Wr();
                        }
                        Ws = Ws();
                        this.bud.setCornerRadius(this.buh, 0.0f, 0.0f, this.buh);
                        i = Wr;
                        break;
                    default:
                        this.bSv = 80;
                        i = Wp();
                        if (cVar.isFullScreen) {
                            ah(this.bud);
                            setClippingEnabled(false);
                            this.bud.setSystemUiVisibility(4870);
                            Ws = -1;
                            break;
                        } else {
                            float f = 0.7f;
                            if (cVar != null) {
                                f = cVar.bSt;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            if (f > 1.0f) {
                                Wq = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                            } else {
                                Wq = (int) (f * Wq());
                            }
                            setClippingEnabled(true);
                            this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
                            Ws = Wq;
                            break;
                        }
                }
                setWidth(i);
                setHeight(Ws);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.bud);
                }
                Ko();
                this.bue.loadUrl(cVar.url);
                if (this.bSu != null) {
                    this.bSu.onShow();
                }
            }
        }
    }

    public void d(c cVar) {
        int Wq;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bSw = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bSu = cVar.bSu;
                if (cVar.bSu != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ap.d.2
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bSu != null) {
                                d.this.bSu.onDismiss();
                            }
                        }
                    });
                }
                this.bSv = 80;
                int Wp = Wp();
                if (cVar.isFullScreen) {
                    Wq = -1;
                    ah(this.bud);
                    setClippingEnabled(false);
                    this.bud.setSystemUiVisibility(4870);
                } else {
                    float f = 0.7f;
                    if (cVar != null) {
                        f = cVar.bSt;
                    }
                    if (f <= 0.1f) {
                        f = 0.1f;
                    }
                    if (f > 1.0f) {
                        Wq = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                    } else {
                        Wq = (int) (f * Wq());
                    }
                    setClippingEnabled(true);
                    this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
                }
                setWidth(Wp);
                setHeight(Wq);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.bud);
                }
                Ko();
                this.bue.loadUrl(cVar.url);
                if (this.bSu != null) {
                    this.bSu.onShow();
                }
            }
        }
    }

    public void co(int i) {
        int Wr;
        int Ws;
        int i2;
        int Wq;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bSv = 5;
                    if (this.bSw.isFullScreen) {
                        Wr = Wp();
                    } else {
                        Wr = Wr();
                    }
                    Ws = Ws();
                    this.bud.setCornerRadius(this.buh, 0.0f, 0.0f, this.buh);
                    i2 = Wr;
                    break;
                default:
                    this.bSv = 80;
                    i2 = Wp();
                    if (this.bSw.isFullScreen) {
                        int Wq2 = Wq();
                        ah(this.bud);
                        setClippingEnabled(false);
                        this.bud.setSystemUiVisibility(4870);
                        Ws = Wq2;
                        break;
                    } else {
                        float f = 0.7f;
                        if (this.bSw != null) {
                            f = this.bSw.bSt;
                        }
                        if (f <= 0.1f) {
                            f = 0.1f;
                        }
                        if (f > 1.0f) {
                            Wq = (int) f;
                        } else {
                            Wq = (int) (f * Wq());
                        }
                        setClippingEnabled(true);
                        this.bud.setCornerRadius(this.buh, this.buh, 0.0f, 0.0f);
                        Ws = Wq;
                        break;
                    }
            }
            update(i2, Ws);
            if (i == 2) {
                ah(this.bud);
            }
        }
    }

    public void Wo() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Wt() || this.bSw.url.contains("disableDisAnimation=1")) {
            Wo();
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
                if (d.this.bue != null) {
                    d.this.bue.release();
                }
            }
        });
    }

    private void initView() {
        this.buh = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bud = new RoundRectRelativeLayout(this.mContext);
        q(this.bud);
        r(this.bud);
        setContentView(this.bud);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(this.mContext);
        this.bue.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bue.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.ap.d.4
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bug = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bug, layoutParams);
        this.bug.setVisibility(8);
    }

    private int Wp() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Wq() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int Wr() {
        return Ws();
    }

    private int Ws() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void Ko() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bSv) {
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

    private boolean Wt() {
        if (getContentView() == null) {
            return false;
        }
        if (this.bSx) {
            return true;
        }
        this.bSx = true;
        TranslateAnimation translateAnimation = null;
        switch (this.bSv) {
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
                    d.this.bSx = false;
                    d.this.Wo();
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
    public void dL(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
