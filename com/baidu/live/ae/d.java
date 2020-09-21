package com.baidu.live.ae;

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
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private RoundRectRelativeLayout bjN;
    private CommonWebLayout bjO;
    private View bjP;
    private float bjQ;
    private b byV;
    private int byW;
    private c byX;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout RG() {
        return this.bjO;
    }

    public void b(c cVar) {
        int RK;
        int RL;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.byX = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.byV = cVar.byV;
                if (cVar.byV != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ae.d.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.byV != null) {
                                d.this.byV.onDismiss();
                            }
                        }
                    });
                }
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.byW = 5;
                        RK = RK();
                        RL = RL();
                        this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                        break;
                    default:
                        this.byW = 80;
                        int RI = RI();
                        if (cVar.isFullScreen) {
                            RL = RJ();
                            ac(this.bjN);
                        } else {
                            float f = 0.7f;
                            if (cVar != null) {
                                f = cVar.byU;
                            }
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            RL = (int) (f * RJ());
                        }
                        this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                        RK = RI;
                        break;
                }
                setWidth(RK);
                setHeight(RL);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ac(this.bjN);
                }
                KS();
                this.bjO.loadUrl(cVar.url);
                if (this.byV != null) {
                    this.byV.MZ();
                }
            }
        }
    }

    public void dD(int i) {
        int RK;
        int RL;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.byW = 5;
                    RK = RK();
                    RL = RL();
                    this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                    break;
                default:
                    this.byW = 80;
                    int RI = RI();
                    if (this.byX.isFullScreen) {
                        RL = RJ();
                        ac(this.bjN);
                    } else {
                        float f = 0.7f;
                        if (this.byX != null) {
                            f = this.byX.byU;
                        }
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        if (f <= 0.1f) {
                            f = 0.1f;
                        }
                        RL = (int) (f * RJ());
                    }
                    this.bjN.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
                    RK = RI;
                    break;
            }
            update(RK, RL);
            if (i == 2) {
                ac(this.bjN);
            }
        }
    }

    public void RH() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!RM()) {
            RH();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ae.d.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.bjO != null) {
                    d.this.bjO.release();
                }
            }
        });
    }

    private void initView() {
        this.bjQ = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bjN = new RoundRectRelativeLayout(this.mContext);
        q(this.bjN);
        r(this.bjN);
        setContentView(this.bjN);
    }

    private void q(ViewGroup viewGroup) {
        this.bjO = new CommonWebLayout(this.mContext);
        this.bjO.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjO.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.ae.d.3
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ho(String str) {
                super.ho(str);
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eO(int i) {
                super.eO(i);
                if (i == 100 && d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hp(String str) {
                super.hp(str);
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bjP = LayoutInflater.from(this.mContext).inflate(a.h.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjP, layoutParams);
        this.bjP.setVisibility(8);
    }

    private int RI() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int RJ() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int RK() {
        return RL();
    }

    private int RL() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void KS() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.byW) {
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

    private boolean RM() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.byW) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.ae.d.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.RH();
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
    public void eL(int i) {
        dismiss();
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
