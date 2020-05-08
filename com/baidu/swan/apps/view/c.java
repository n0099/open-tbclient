package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.p;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.l;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public SwanAppRoundedImageView bLG;
    public BdBaseImageView bLH;
    public TextView bLI;
    private com.baidu.swan.games.loading.a czA;
    private TextView czB;
    private ValueAnimator czC;
    private boolean czD = false;
    private float czE = 0.0f;
    private float czF = 0.0f;
    private float czG = 0.0f;
    public View czq;
    public TextView czr;
    public ImageView czs;
    public ImageView czt;
    private ImageView czu;
    public RelativeLayout czv;
    private com.baidu.swan.apps.d.a czw;
    private SwanAppActivity czx;
    private View czy;
    private SwanLoadingTipsView czz;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.czx = swanAppActivity;
    }

    public void fh(boolean z) {
        if (this.czw == null) {
            this.czw = new com.baidu.swan.apps.d.a();
        }
        this.czq = LayoutInflater.from(this.czx).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.czq.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            apJ();
        }
        this.czx.Oo().aq(this.czq);
        this.czD = true;
        this.czr = (TextView) this.czq.findViewById(a.f.aiapps_title);
        this.bLG = (SwanAppRoundedImageView) this.czq.findViewById(a.f.aiapps_icon);
        this.bLH = (BdBaseImageView) this.czq.findViewById(a.f.aiapps_label_bg);
        this.bLI = (TextView) this.czq.findViewById(a.f.aiapps_label_tv);
        this.czv = (RelativeLayout) this.czq.findViewById(a.f.aiapps_icon_rl);
        b.a akP = d.akJ().akG().akP();
        op(akP.YS());
        oo(akP.getIconUrl());
        hq(akP.getType());
        this.czs = (ImageView) this.czq.findViewById(a.f.light_print);
        this.czt = (ImageView) this.czq.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.czq.findViewById(a.f.titlebar_right_menu_img);
        this.czu = (ImageView) this.czq.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.czq.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.czu.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.czy = this.czq.findViewById(a.f.titlebar_right_menu_line);
            this.czy.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.czu.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo adQ = akP.adQ();
        int i = adQ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : adQ.payProtected;
        if (!z && ai.aps() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.czq.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.czt.setAlpha(0.0f);
        this.czw.g(this.czx);
        apL();
    }

    private void apJ() {
        this.czB = (TextView) this.czq.findViewById(a.f.aiapps_loading_progress);
        this.czz = (SwanLoadingTipsView) this.czq.findViewById(a.f.aigames_loading_game_tips);
        this.czz.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: apQ */
            public l invoke() {
                c.this.apK();
                return null;
            }
        });
        this.czA = new com.baidu.swan.games.loading.a();
        this.czq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.apK();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        apN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apK() {
        if (this.czz != null && this.czA != null) {
            this.czz.qB(this.czA.axd());
        }
    }

    private void apL() {
        this.czu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.czx != null && !c.this.czx.isFinishing()) {
                    c.this.czx.moveTaskToBack(true);
                    c.this.apM();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apM() {
        Bundle adF;
        b.a Ov = this.czx.Ov();
        if (Ov != null && (adF = Ov.adF()) != null) {
            long j = adF.getLong("page_display_flag_for_statistic");
            adF.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Ov.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cuC = valueOf;
                fVar.s(TiebaInitialize.LogFields.REASON, "close");
                if (Ov.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.u.b.axS().axT());
                }
                this.czx.a(fVar);
                com.baidu.swan.apps.statistic.c.a(Ov);
            }
        }
    }

    private void hq(int i) {
        af.a(this.bLH, this.bLI, String.valueOf(i));
    }

    public void hr(int i) {
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.amO().mO("first_anim_end");
        this.czw.a(this.czx, i);
        this.czD = false;
    }

    public void Rp() {
        this.czw.Rp();
        if (this.czz != null) {
            this.czz.doDestroy();
            this.czz = null;
        }
        if (this.czB != null) {
            this.czB.setVisibility(8);
            this.czB = null;
        }
        if (this.czC != null) {
            this.czC.removeAllUpdateListeners();
            this.czC.cancel();
            this.czC = null;
        }
        this.czD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap) {
        if (bitmap != null && this.bLG != null) {
            this.bLG.setImageBitmap(bitmap);
        }
    }

    public void G(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.czB != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.czE = f2 <= 1.0f ? f2 : 1.0f;
            apO();
        }
    }

    public void apN() {
        if (this.czB != null) {
            if (this.czC != null) {
                this.czC.cancel();
                this.czC.removeAllUpdateListeners();
            }
            this.czF = 0.0f;
            this.czE = 0.0f;
            this.czG = 0.0f;
            apO();
            this.czC = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.czC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.czF > 0.05d) {
                        c.this.czF = floatValue;
                        c.this.apO();
                    }
                }
            });
            this.czC.setDuration(4000L);
            this.czC.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apO() {
        if (this.czB != null) {
            float q = q(this.czF, this.czE);
            if (q >= 1.0f) {
                q = 0.99f;
            }
            H(q);
        }
    }

    private void H(float f) {
        if (this.czB != null && this.czG <= f) {
            this.czG = f;
            this.czB.setText(NumberFormat.getPercentInstance().format(f));
            this.czB.setVisibility(0);
        }
    }

    private float q(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void apP() {
        if (this.czB != null) {
            if (this.czC != null) {
                this.czC.removeAllUpdateListeners();
                this.czC.cancel();
                this.czC = null;
            }
            H(1.0f);
        }
    }

    public void oo(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.akJ().getAppId();
        if (this.czD) {
            this.bLG.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity akI;
                    c Op;
                    if (bitmap != null && (akI = d.akJ().akI()) != null && !akI.isDestroyed() && (Op = akI.Op()) != null && TextUtils.equals(appId, d.akJ().getAppId())) {
                        Op.n(bitmap);
                    }
                }
            }));
        }
    }

    public void op(String str) {
        if (this.czD && !TextUtils.isEmpty(str)) {
            this.czr.setText(str);
        }
    }
}
