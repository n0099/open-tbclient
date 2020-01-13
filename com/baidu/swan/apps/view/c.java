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
import kotlin.k;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public View bVS;
    public TextView bVT;
    public ImageView bVU;
    public ImageView bVV;
    private ImageView bVW;
    public RelativeLayout bVX;
    private com.baidu.swan.apps.d.a bVY;
    private SwanAppActivity bVZ;
    private View bWa;
    private SwanLoadingTipsView bWb;
    private com.baidu.swan.games.loading.a bWc;
    private TextView bWd;
    private ValueAnimator bWe;
    private boolean bWf = false;
    private float bWg = 0.0f;
    private float bWh = 0.0f;
    private float bWi = 0.0f;
    public SwanAppRoundedImageView biV;
    public BdBaseImageView biW;
    public TextView biX;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.bVZ = swanAppActivity;
    }

    public void ec(boolean z) {
        if (this.bVY == null) {
            this.bVY = new com.baidu.swan.apps.d.a();
        }
        this.bVS = LayoutInflater.from(this.bVZ).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.bVS.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            afj();
        }
        this.bVZ.Eg().ap(this.bVS);
        this.bWf = true;
        this.bVT = (TextView) this.bVS.findViewById(a.f.aiapps_title);
        this.biV = (SwanAppRoundedImageView) this.bVS.findViewById(a.f.aiapps_icon);
        this.biW = (BdBaseImageView) this.bVS.findViewById(a.f.aiapps_label_bg);
        this.biX = (TextView) this.bVS.findViewById(a.f.aiapps_label_tv);
        this.bVX = (RelativeLayout) this.bVS.findViewById(a.f.aiapps_icon_rl);
        b.a aas = d.aam().aaj().aas();
        mM(aas.OL());
        mL(aas.getIconUrl());
        gS(aas.getType());
        this.bVU = (ImageView) this.bVS.findViewById(a.f.light_print);
        this.bVV = (ImageView) this.bVS.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.bVS.findViewById(a.f.titlebar_right_menu_img);
        this.bVW = (ImageView) this.bVS.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.bVS.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bVW.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bWa = this.bVS.findViewById(a.f.titlebar_right_menu_line);
            this.bWa.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bVW.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo TJ = aas.TJ();
        int i = TJ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : TJ.payProtected;
        if (!z && ai.aeS() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.bVS.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.bVV.setAlpha(0.0f);
        this.bVY.g(this.bVZ);
        afl();
    }

    private void afj() {
        this.bWd = (TextView) this.bVS.findViewById(a.f.aiapps_loading_progress);
        this.bWb = (SwanLoadingTipsView) this.bVS.findViewById(a.f.aigames_loading_game_tips);
        this.bWb.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<k>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: afq */
            public k invoke() {
                c.this.afk();
                return null;
            }
        });
        this.bWc = new com.baidu.swan.games.loading.a();
        this.bVS.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.afk();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        afn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.bWb != null && this.bWc != null) {
            this.bWb.pa(this.bWc.amy());
        }
    }

    private void afl() {
        this.bVW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bVZ != null && !c.this.bVZ.isFinishing()) {
                    c.this.bVZ.moveTaskToBack(true);
                    c.this.afm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        Bundle Ty;
        b.a En = this.bVZ.En();
        if (En != null && (Ty = En.Ty()) != null) {
            long j = Ty.getLong("page_display_flag_for_statistic");
            Ty.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - En.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bRm = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (En.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.ann().ano());
                }
                this.bVZ.a(fVar);
                com.baidu.swan.apps.statistic.c.a(En);
            }
        }
    }

    private void gS(int i) {
        af.a(this.biW, this.biX, String.valueOf(i));
    }

    public void gT(int i) {
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.acr().ln("first_anim_end");
        this.bVY.a(this.bVZ, i);
        this.bWf = false;
    }

    public void Hk() {
        this.bVY.Hk();
        if (this.bWb != null) {
            this.bWb.doDestroy();
            this.bWb = null;
        }
        if (this.bWd != null) {
            this.bWd.setVisibility(8);
            this.bWd = null;
        }
        if (this.bWe != null) {
            this.bWe.removeAllUpdateListeners();
            this.bWe.cancel();
            this.bWe = null;
        }
        this.bWf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.biV != null) {
            this.biV.setImageBitmap(bitmap);
        }
    }

    public void W(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.bWd != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.bWg = f2 <= 1.0f ? f2 : 1.0f;
            afo();
        }
    }

    public void afn() {
        if (this.bWd != null) {
            if (this.bWe != null) {
                this.bWe.cancel();
                this.bWe.removeAllUpdateListeners();
            }
            this.bWh = 0.0f;
            this.bWg = 0.0f;
            this.bWi = 0.0f;
            afo();
            this.bWe = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bWe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.bWh > 0.05d) {
                        c.this.bWh = floatValue;
                        c.this.afo();
                    }
                }
            });
            this.bWe.setDuration(4000L);
            this.bWe.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (this.bWd != null) {
            float r = r(this.bWh, this.bWg);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            X(r);
        }
    }

    private void X(float f) {
        if (this.bWd != null && this.bWi <= f) {
            this.bWi = f;
            this.bWd.setText(NumberFormat.getPercentInstance().format(f));
            this.bWd.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void afp() {
        if (this.bWd != null) {
            if (this.bWe != null) {
                this.bWe.removeAllUpdateListeners();
                this.bWe.cancel();
                this.bWe = null;
            }
            X(1.0f);
        }
    }

    public void mL(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.aam().getAppId();
        if (this.bWf) {
            this.biV.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity aal;
                    c Eh;
                    if (bitmap != null && (aal = d.aam().aal()) != null && !aal.isDestroyed() && (Eh = aal.Eh()) != null && TextUtils.equals(appId, d.aam().getAppId())) {
                        Eh.l(bitmap);
                    }
                }
            }));
        }
    }

    public void mM(String str) {
        if (this.bWf && !TextUtils.isEmpty(str)) {
            this.bVT.setText(str);
        }
    }
}
