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
    public View bZX;
    public TextView bZY;
    public ImageView bZZ;
    public SwanAppRoundedImageView bng;
    public BdBaseImageView bnh;
    public TextView bni;
    public ImageView caa;
    private ImageView cab;
    public RelativeLayout cac;
    private com.baidu.swan.apps.d.a cad;
    private SwanAppActivity cae;
    private View caf;
    private SwanLoadingTipsView cag;
    private com.baidu.swan.games.loading.a cah;
    private TextView cai;
    private ValueAnimator caj;
    private boolean cak = false;
    private float cal = 0.0f;
    private float cam = 0.0f;
    private float can = 0.0f;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.cae = swanAppActivity;
    }

    public void ej(boolean z) {
        if (this.cad == null) {
            this.cad = new com.baidu.swan.apps.d.a();
        }
        this.bZX = LayoutInflater.from(this.cae).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.bZX.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            ahz();
        }
        this.cae.Gx().ap(this.bZX);
        this.cak = true;
        this.bZY = (TextView) this.bZX.findViewById(a.f.aiapps_title);
        this.bng = (SwanAppRoundedImageView) this.bZX.findViewById(a.f.aiapps_icon);
        this.bnh = (BdBaseImageView) this.bZX.findViewById(a.f.aiapps_label_bg);
        this.bni = (TextView) this.bZX.findViewById(a.f.aiapps_label_tv);
        this.cac = (RelativeLayout) this.bZX.findViewById(a.f.aiapps_icon_rl);
        b.a acI = d.acC().acz().acI();
        nb(acI.Rb());
        na(acI.getIconUrl());
        hj(acI.getType());
        this.bZZ = (ImageView) this.bZX.findViewById(a.f.light_print);
        this.caa = (ImageView) this.bZX.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.bZX.findViewById(a.f.titlebar_right_menu_img);
        this.cab = (ImageView) this.bZX.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.bZX.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.cab.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.caf = this.bZX.findViewById(a.f.titlebar_right_menu_line);
            this.caf.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.cab.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo VZ = acI.VZ();
        int i = VZ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : VZ.payProtected;
        if (!z && ai.ahi() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.bZX.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.caa.setAlpha(0.0f);
        this.cad.g(this.cae);
        ahB();
    }

    private void ahz() {
        this.cai = (TextView) this.bZX.findViewById(a.f.aiapps_loading_progress);
        this.cag = (SwanLoadingTipsView) this.bZX.findViewById(a.f.aigames_loading_game_tips);
        this.cag.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: ahG */
            public l invoke() {
                c.this.ahA();
                return null;
            }
        });
        this.cah = new com.baidu.swan.games.loading.a();
        this.bZX.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.ahA();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        ahD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahA() {
        if (this.cag != null && this.cah != null) {
            this.cag.pp(this.cah.aoN());
        }
    }

    private void ahB() {
        this.cab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cae != null && !c.this.cae.isFinishing()) {
                    c.this.cae.moveTaskToBack(true);
                    c.this.ahC();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        Bundle VO;
        b.a GE = this.cae.GE();
        if (GE != null && (VO = GE.VO()) != null) {
            long j = VO.getLong("page_display_flag_for_statistic");
            VO.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - GE.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bVs = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (GE.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.apD().apE());
                }
                this.cae.a(fVar);
                com.baidu.swan.apps.statistic.c.a(GE);
            }
        }
    }

    private void hj(int i) {
        af.a(this.bnh, this.bni, String.valueOf(i));
    }

    public void hk(int i) {
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.aeH().lC("first_anim_end");
        this.cad.a(this.cae, i);
        this.cak = false;
    }

    public void JB() {
        this.cad.JB();
        if (this.cag != null) {
            this.cag.doDestroy();
            this.cag = null;
        }
        if (this.cai != null) {
            this.cai.setVisibility(8);
            this.cai = null;
        }
        if (this.caj != null) {
            this.caj.removeAllUpdateListeners();
            this.caj.cancel();
            this.caj = null;
        }
        this.cak = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.bng != null) {
            this.bng.setImageBitmap(bitmap);
        }
    }

    public void W(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.cai != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cal = f2 <= 1.0f ? f2 : 1.0f;
            ahE();
        }
    }

    public void ahD() {
        if (this.cai != null) {
            if (this.caj != null) {
                this.caj.cancel();
                this.caj.removeAllUpdateListeners();
            }
            this.cam = 0.0f;
            this.cal = 0.0f;
            this.can = 0.0f;
            ahE();
            this.caj = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.caj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.cam > 0.05d) {
                        c.this.cam = floatValue;
                        c.this.ahE();
                    }
                }
            });
            this.caj.setDuration(4000L);
            this.caj.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahE() {
        if (this.cai != null) {
            float r = r(this.cam, this.cal);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            X(r);
        }
    }

    private void X(float f) {
        if (this.cai != null && this.can <= f) {
            this.can = f;
            this.cai.setText(NumberFormat.getPercentInstance().format(f));
            this.cai.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void ahF() {
        if (this.cai != null) {
            if (this.caj != null) {
                this.caj.removeAllUpdateListeners();
                this.caj.cancel();
                this.caj = null;
            }
            X(1.0f);
        }
    }

    public void na(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.acC().getAppId();
        if (this.cak) {
            this.bng.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity acB;
                    c Gy;
                    if (bitmap != null && (acB = d.acC().acB()) != null && !acB.isDestroyed() && (Gy = acB.Gy()) != null && TextUtils.equals(appId, d.acC().getAppId())) {
                        Gy.l(bitmap);
                    }
                }
            }));
        }
    }

    public void nb(String str) {
        if (this.cak && !TextUtils.isEmpty(str)) {
            this.bZY.setText(str);
        }
    }
}
