package com.baidu.live.ao;

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
    private int bRA;
    private c bRB;
    private b bRz;
    private RoundRectRelativeLayout bue;
    private CommonWebLayout bug;
    private View buh;
    private float bui;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        setClippingEnabled(false);
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bug;
    }

    public void b(c cVar) {
        int YT;
        int YU;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && cVar != null) {
            this.bRB = cVar;
            View findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bRz = cVar.bRz;
                if (cVar.bRz != null) {
                    setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ao.d.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            if (d.this.bRz != null) {
                                d.this.bRz.onDismiss();
                            }
                        }
                    });
                }
                switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                    case 2:
                        this.bRA = 5;
                        YT = YT();
                        YU = YU();
                        this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                        break;
                    default:
                        this.bRA = 80;
                        YT = YR();
                        if (cVar.isFullScreen) {
                            YU = -1;
                            ah(this.bue);
                            setClippingEnabled(false);
                            break;
                        } else {
                            float f = 0.7f;
                            if (cVar != null) {
                                f = cVar.bRy;
                            }
                            if (f <= 0.1f) {
                                f = 0.1f;
                            }
                            if (f > 1.0f) {
                                YU = (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
                            } else {
                                YU = (int) (f * YS());
                            }
                            this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                            break;
                        }
                }
                setWidth(YT);
                setHeight(YU);
                showAtLocation(findViewById, 85, 0, 0);
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    ah(this.bue);
                }
                OD();
                this.bug.loadUrl(cVar.url);
                if (this.bRz != null) {
                    this.bRz.QM();
                }
            }
        }
    }

    public void dX(int i) {
        int YT;
        int YU;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 2:
                    this.bRA = 5;
                    YT = YT();
                    YU = YU();
                    this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                    break;
                default:
                    this.bRA = 80;
                    YT = YR();
                    if (this.bRB.isFullScreen) {
                        YU = YS();
                        ah(this.bue);
                        setClippingEnabled(false);
                        break;
                    } else {
                        float f = 0.7f;
                        if (this.bRB != null) {
                            f = this.bRB.bRy;
                        }
                        if (f <= 0.1f) {
                            f = 0.1f;
                        }
                        if (f > 1.0f) {
                            YU = (int) f;
                        } else {
                            YU = (int) (f * YS());
                        }
                        this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                        break;
                    }
            }
            update(YT, YU);
            if (i == 2) {
                ah(this.bue);
            }
        }
    }

    public void YQ() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!YV() || this.bRB.url.contains("disableDisAnimation=1")) {
            YQ();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.ao.d.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.bug != null) {
                    d.this.bug.release();
                }
            }
        });
    }

    private void initView() {
        this.bui = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bue = new RoundRectRelativeLayout(this.mContext);
        n(this.bue);
        o(this.bue);
        setContentView(this.bue);
    }

    private void n(ViewGroup viewGroup) {
        this.bug = new CommonWebLayout(this.mContext);
        this.bug.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bug.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.live.ao.d.3
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.buh = LayoutInflater.from(this.mContext).inflate(a.g.layout_standard_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buh, layoutParams);
        this.buh.setVisibility(8);
    }

    private int YR() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int YS() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private int YT() {
        return YU();
    }

    private int YU() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void OD() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bRA) {
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

    private boolean YV() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bRA) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.ao.d.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.YQ();
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
