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
    public SwanAppRoundedImageView bnu;
    public BdBaseImageView bnv;
    public TextView bnw;
    public View caj;
    public TextView cak;
    public ImageView cal;
    public ImageView cam;
    private ImageView can;
    public RelativeLayout cao;
    private com.baidu.swan.apps.d.a cap;
    private SwanAppActivity caq;
    private View car;
    private SwanLoadingTipsView cas;
    private com.baidu.swan.games.loading.a cat;
    private TextView cau;
    private ValueAnimator cav;
    private boolean caw = false;
    private float cax = 0.0f;
    private float cay = 0.0f;
    private float caz = 0.0f;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.caq = swanAppActivity;
    }

    public void ek(boolean z) {
        if (this.cap == null) {
            this.cap = new com.baidu.swan.apps.d.a();
        }
        this.caj = LayoutInflater.from(this.caq).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.caj.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            ahC();
        }
        this.caq.GC().ap(this.caj);
        this.caw = true;
        this.cak = (TextView) this.caj.findViewById(a.f.aiapps_title);
        this.bnu = (SwanAppRoundedImageView) this.caj.findViewById(a.f.aiapps_icon);
        this.bnv = (BdBaseImageView) this.caj.findViewById(a.f.aiapps_label_bg);
        this.bnw = (TextView) this.caj.findViewById(a.f.aiapps_label_tv);
        this.cao = (RelativeLayout) this.caj.findViewById(a.f.aiapps_icon_rl);
        b.a acL = d.acF().acC().acL();
        na(acL.Re());
        mZ(acL.getIconUrl());
        hj(acL.getType());
        this.cal = (ImageView) this.caj.findViewById(a.f.light_print);
        this.cam = (ImageView) this.caj.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.caj.findViewById(a.f.titlebar_right_menu_img);
        this.can = (ImageView) this.caj.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.caj.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.can.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.car = this.caj.findViewById(a.f.titlebar_right_menu_line);
            this.car.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.can.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo Wc = acL.Wc();
        int i = Wc == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : Wc.payProtected;
        if (!z && ai.ahl() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.caj.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.cam.setAlpha(0.0f);
        this.cap.g(this.caq);
        ahE();
    }

    private void ahC() {
        this.cau = (TextView) this.caj.findViewById(a.f.aiapps_loading_progress);
        this.cas = (SwanLoadingTipsView) this.caj.findViewById(a.f.aigames_loading_game_tips);
        this.cas.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: ahJ */
            public l invoke() {
                c.this.ahD();
                return null;
            }
        });
        this.cat = new com.baidu.swan.games.loading.a();
        this.caj.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.ahD();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        ahG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahD() {
        if (this.cas != null && this.cat != null) {
            this.cas.po(this.cat.aoQ());
        }
    }

    private void ahE() {
        this.can.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.caq != null && !c.this.caq.isFinishing()) {
                    c.this.caq.moveTaskToBack(true);
                    c.this.ahF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahF() {
        Bundle VR;
        b.a GJ = this.caq.GJ();
        if (GJ != null && (VR = GJ.VR()) != null) {
            long j = VR.getLong("page_display_flag_for_statistic");
            VR.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - GJ.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bVE = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (GJ.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.apG().apH());
                }
                this.caq.a(fVar);
                com.baidu.swan.apps.statistic.c.a(GJ);
            }
        }
    }

    private void hj(int i) {
        af.a(this.bnv, this.bnw, String.valueOf(i));
    }

    public void hk(int i) {
        com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.aeK().lB("first_anim_end");
        this.cap.a(this.caq, i);
        this.caw = false;
    }

    public void JE() {
        this.cap.JE();
        if (this.cas != null) {
            this.cas.doDestroy();
            this.cas = null;
        }
        if (this.cau != null) {
            this.cau.setVisibility(8);
            this.cau = null;
        }
        if (this.cav != null) {
            this.cav.removeAllUpdateListeners();
            this.cav.cancel();
            this.cav = null;
        }
        this.caw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.bnu != null) {
            this.bnu.setImageBitmap(bitmap);
        }
    }

    public void W(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.cau != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cax = f2 <= 1.0f ? f2 : 1.0f;
            ahH();
        }
    }

    public void ahG() {
        if (this.cau != null) {
            if (this.cav != null) {
                this.cav.cancel();
                this.cav.removeAllUpdateListeners();
            }
            this.cay = 0.0f;
            this.cax = 0.0f;
            this.caz = 0.0f;
            ahH();
            this.cav = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.cav.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.cay > 0.05d) {
                        c.this.cay = floatValue;
                        c.this.ahH();
                    }
                }
            });
            this.cav.setDuration(4000L);
            this.cav.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahH() {
        if (this.cau != null) {
            float r = r(this.cay, this.cax);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            X(r);
        }
    }

    private void X(float f) {
        if (this.cau != null && this.caz <= f) {
            this.caz = f;
            this.cau.setText(NumberFormat.getPercentInstance().format(f));
            this.cau.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void ahI() {
        if (this.cau != null) {
            if (this.cav != null) {
                this.cav.removeAllUpdateListeners();
                this.cav.cancel();
                this.cav = null;
            }
            X(1.0f);
        }
    }

    public void mZ(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.acF().getAppId();
        if (this.caw) {
            this.bnu.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity acE;
                    c GD;
                    if (bitmap != null && (acE = d.acF().acE()) != null && !acE.isDestroyed() && (GD = acE.GD()) != null && TextUtils.equals(appId, d.acF().getAppId())) {
                        GD.l(bitmap);
                    }
                }
            }));
        }
    }

    public void na(String str) {
        if (this.caw && !TextUtils.isEmpty(str)) {
            this.cak.setText(str);
        }
    }
}
