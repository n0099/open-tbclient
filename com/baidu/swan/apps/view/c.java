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
    public View bZY;
    public TextView bZZ;
    public SwanAppRoundedImageView bnh;
    public BdBaseImageView bni;
    public TextView bnj;
    public ImageView caa;
    public ImageView cab;
    private ImageView cac;
    public RelativeLayout cad;
    private com.baidu.swan.apps.d.a cae;
    private SwanAppActivity caf;
    private View cag;
    private SwanLoadingTipsView cah;
    private com.baidu.swan.games.loading.a cai;
    private TextView caj;
    private ValueAnimator cak;
    private boolean cal = false;
    private float cam = 0.0f;
    private float can = 0.0f;
    private float cao = 0.0f;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.caf = swanAppActivity;
    }

    public void ej(boolean z) {
        if (this.cae == null) {
            this.cae = new com.baidu.swan.apps.d.a();
        }
        this.bZY = LayoutInflater.from(this.caf).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.bZY.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            ahz();
        }
        this.caf.Gx().ap(this.bZY);
        this.cal = true;
        this.bZZ = (TextView) this.bZY.findViewById(a.f.aiapps_title);
        this.bnh = (SwanAppRoundedImageView) this.bZY.findViewById(a.f.aiapps_icon);
        this.bni = (BdBaseImageView) this.bZY.findViewById(a.f.aiapps_label_bg);
        this.bnj = (TextView) this.bZY.findViewById(a.f.aiapps_label_tv);
        this.cad = (RelativeLayout) this.bZY.findViewById(a.f.aiapps_icon_rl);
        b.a acI = d.acC().acz().acI();
        nb(acI.Rb());
        na(acI.getIconUrl());
        hj(acI.getType());
        this.caa = (ImageView) this.bZY.findViewById(a.f.light_print);
        this.cab = (ImageView) this.bZY.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.bZY.findViewById(a.f.titlebar_right_menu_img);
        this.cac = (ImageView) this.bZY.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.bZY.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.cac.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.cag = this.bZY.findViewById(a.f.titlebar_right_menu_line);
            this.cag.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.cac.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo VZ = acI.VZ();
        int i = VZ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : VZ.payProtected;
        if (!z && ai.ahi() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.bZY.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.cab.setAlpha(0.0f);
        this.cae.g(this.caf);
        ahB();
    }

    private void ahz() {
        this.caj = (TextView) this.bZY.findViewById(a.f.aiapps_loading_progress);
        this.cah = (SwanLoadingTipsView) this.bZY.findViewById(a.f.aigames_loading_game_tips);
        this.cah.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: ahG */
            public l invoke() {
                c.this.ahA();
                return null;
            }
        });
        this.cai = new com.baidu.swan.games.loading.a();
        this.bZY.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
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
        if (this.cah != null && this.cai != null) {
            this.cah.pp(this.cai.aoN());
        }
    }

    private void ahB() {
        this.cac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.caf != null && !c.this.caf.isFinishing()) {
                    c.this.caf.moveTaskToBack(true);
                    c.this.ahC();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        Bundle VO;
        b.a GE = this.caf.GE();
        if (GE != null && (VO = GE.VO()) != null) {
            long j = VO.getLong("page_display_flag_for_statistic");
            VO.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - GE.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bVt = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (GE.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.apD().apE());
                }
                this.caf.a(fVar);
                com.baidu.swan.apps.statistic.c.a(GE);
            }
        }
    }

    private void hj(int i) {
        af.a(this.bni, this.bnj, String.valueOf(i));
    }

    public void hk(int i) {
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.aeH().lC("first_anim_end");
        this.cae.a(this.caf, i);
        this.cal = false;
    }

    public void JB() {
        this.cae.JB();
        if (this.cah != null) {
            this.cah.doDestroy();
            this.cah = null;
        }
        if (this.caj != null) {
            this.caj.setVisibility(8);
            this.caj = null;
        }
        if (this.cak != null) {
            this.cak.removeAllUpdateListeners();
            this.cak.cancel();
            this.cak = null;
        }
        this.cal = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.bnh != null) {
            this.bnh.setImageBitmap(bitmap);
        }
    }

    public void W(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.caj != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cam = f2 <= 1.0f ? f2 : 1.0f;
            ahE();
        }
    }

    public void ahD() {
        if (this.caj != null) {
            if (this.cak != null) {
                this.cak.cancel();
                this.cak.removeAllUpdateListeners();
            }
            this.can = 0.0f;
            this.cam = 0.0f;
            this.cao = 0.0f;
            ahE();
            this.cak = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.cak.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.can > 0.05d) {
                        c.this.can = floatValue;
                        c.this.ahE();
                    }
                }
            });
            this.cak.setDuration(4000L);
            this.cak.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahE() {
        if (this.caj != null) {
            float r = r(this.can, this.cam);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            X(r);
        }
    }

    private void X(float f) {
        if (this.caj != null && this.cao <= f) {
            this.cao = f;
            this.caj.setText(NumberFormat.getPercentInstance().format(f));
            this.caj.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void ahF() {
        if (this.caj != null) {
            if (this.cak != null) {
                this.cak.removeAllUpdateListeners();
                this.cak.cancel();
                this.cak = null;
            }
            X(1.0f);
        }
    }

    public void na(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.acC().getAppId();
        if (this.cal) {
            this.bnh.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
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
        if (this.cal && !TextUtils.isEmpty(str)) {
            this.bZZ.setText(str);
        }
    }
}
