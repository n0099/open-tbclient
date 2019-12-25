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
import kotlin.g;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public View bVG;
    public TextView bVH;
    public ImageView bVI;
    public ImageView bVJ;
    private ImageView bVK;
    public RelativeLayout bVL;
    private com.baidu.swan.apps.d.a bVM;
    private SwanAppActivity bVN;
    private View bVO;
    private SwanLoadingTipsView bVP;
    private com.baidu.swan.games.loading.a bVQ;
    private TextView bVR;
    private ValueAnimator bVS;
    private boolean bVT = false;
    private float bVU = 0.0f;
    private float bVV = 0.0f;
    private float bVW = 0.0f;
    public SwanAppRoundedImageView bie;
    public BdBaseImageView bif;
    public TextView bih;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.bVN = swanAppActivity;
    }

    public void dX(boolean z) {
        if (this.bVM == null) {
            this.bVM = new com.baidu.swan.apps.d.a();
        }
        this.bVG = LayoutInflater.from(this.bVN).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.bVG.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            aeQ();
        }
        this.bVN.DK().al(this.bVG);
        this.bVT = true;
        this.bVH = (TextView) this.bVG.findViewById(a.f.aiapps_title);
        this.bie = (SwanAppRoundedImageView) this.bVG.findViewById(a.f.aiapps_icon);
        this.bif = (BdBaseImageView) this.bVG.findViewById(a.f.aiapps_label_bg);
        this.bih = (TextView) this.bVG.findViewById(a.f.aiapps_label_tv);
        this.bVL = (RelativeLayout) this.bVG.findViewById(a.f.aiapps_icon_rl);
        b.a ZV = d.ZP().ZM().ZV();
        mJ(ZV.Op());
        mI(ZV.getIconUrl());
        gS(ZV.getType());
        this.bVI = (ImageView) this.bVG.findViewById(a.f.light_print);
        this.bVJ = (ImageView) this.bVG.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.bVG.findViewById(a.f.titlebar_right_menu_img);
        this.bVK = (ImageView) this.bVG.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.bVG.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bVK.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bVO = this.bVG.findViewById(a.f.titlebar_right_menu_line);
            this.bVO.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bVK.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo Tm = ZV.Tm();
        int i = Tm == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : Tm.payProtected;
        if (!z && ai.aez() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.bVG.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.bVJ.setAlpha(0.0f);
        this.bVM.g(this.bVN);
        aeS();
    }

    private void aeQ() {
        this.bVR = (TextView) this.bVG.findViewById(a.f.aiapps_loading_progress);
        this.bVP = (SwanLoadingTipsView) this.bVG.findViewById(a.f.aigames_loading_game_tips);
        this.bVP.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<g>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aeX */
            public g invoke() {
                c.this.aeR();
                return null;
            }
        });
        this.bVQ = new com.baidu.swan.games.loading.a();
        this.bVG.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aeR();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        aeU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeR() {
        if (this.bVP != null && this.bVQ != null) {
            this.bVP.oX(this.bVQ.amf());
        }
    }

    private void aeS() {
        this.bVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bVN != null && !c.this.bVN.isFinishing()) {
                    c.this.bVN.moveTaskToBack(true);
                    c.this.aeT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeT() {
        Bundle Tb;
        b.a DR = this.bVN.DR();
        if (DR != null && (Tb = DR.Tb()) != null) {
            long j = Tb.getLong("page_display_flag_for_statistic");
            Tb.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - DR.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bQC = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (DR.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.amU().amV());
                }
                this.bVN.a(fVar);
                com.baidu.swan.apps.statistic.c.a(DR);
            }
        }
    }

    private void gS(int i) {
        af.a(this.bif, this.bih, String.valueOf(i));
    }

    public void gT(int i) {
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.abU().lk("first_anim_end");
        this.bVM.a(this.bVN, i);
        this.bVT = false;
    }

    public void GO() {
        this.bVM.GO();
        if (this.bVP != null) {
            this.bVP.doDestroy();
            this.bVP = null;
        }
        if (this.bVR != null) {
            this.bVR.setVisibility(8);
            this.bVR = null;
        }
        if (this.bVS != null) {
            this.bVS.removeAllUpdateListeners();
            this.bVS.cancel();
            this.bVS = null;
        }
        this.bVT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.bie != null) {
            this.bie.setImageBitmap(bitmap);
        }
    }

    public void X(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.bVR != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.bVU = f2 <= 1.0f ? f2 : 1.0f;
            aeV();
        }
    }

    public void aeU() {
        if (this.bVR != null) {
            if (this.bVS != null) {
                this.bVS.cancel();
                this.bVS.removeAllUpdateListeners();
            }
            this.bVV = 0.0f;
            this.bVU = 0.0f;
            this.bVW = 0.0f;
            aeV();
            this.bVS = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bVS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.bVV > 0.05d) {
                        c.this.bVV = floatValue;
                        c.this.aeV();
                    }
                }
            });
            this.bVS.setDuration(4000L);
            this.bVS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeV() {
        if (this.bVR != null) {
            float r = r(this.bVV, this.bVU);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            Y(r);
        }
    }

    private void Y(float f) {
        if (this.bVR != null && this.bVW <= f) {
            this.bVW = f;
            this.bVR.setText(NumberFormat.getPercentInstance().format(f));
            this.bVR.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void aeW() {
        if (this.bVR != null) {
            if (this.bVS != null) {
                this.bVS.removeAllUpdateListeners();
                this.bVS.cancel();
                this.bVS = null;
            }
            Y(1.0f);
        }
    }

    public void mI(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.ZP().getAppId();
        if (this.bVT) {
            this.bie.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity ZO;
                    c DL;
                    if (bitmap != null && (ZO = d.ZP().ZO()) != null && !ZO.isDestroyed() && (DL = ZO.DL()) != null && TextUtils.equals(appId, d.ZP().getAppId())) {
                        DL.l(bitmap);
                    }
                }
            }));
        }
    }

    public void mJ(String str) {
        if (this.bVT && !TextUtils.isEmpty(str)) {
            this.bVH.setText(str);
        }
    }
}
