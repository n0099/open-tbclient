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
    public View bZW;
    public TextView bZX;
    public ImageView bZY;
    public ImageView bZZ;
    public SwanAppRoundedImageView bnf;
    public BdBaseImageView bng;
    public TextView bnh;
    private ImageView caa;
    public RelativeLayout cab;
    private com.baidu.swan.apps.d.a cac;
    private SwanAppActivity cad;
    private View cae;
    private SwanLoadingTipsView caf;
    private com.baidu.swan.games.loading.a cag;
    private TextView cah;
    private ValueAnimator cai;
    private boolean caj = false;
    private float cak = 0.0f;
    private float cal = 0.0f;
    private float cam = 0.0f;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.cad = swanAppActivity;
    }

    public void ej(boolean z) {
        if (this.cac == null) {
            this.cac = new com.baidu.swan.apps.d.a();
        }
        this.bZW = LayoutInflater.from(this.cad).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.bZW.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            ahx();
        }
        this.cad.Gv().ap(this.bZW);
        this.caj = true;
        this.bZX = (TextView) this.bZW.findViewById(a.f.aiapps_title);
        this.bnf = (SwanAppRoundedImageView) this.bZW.findViewById(a.f.aiapps_icon);
        this.bng = (BdBaseImageView) this.bZW.findViewById(a.f.aiapps_label_bg);
        this.bnh = (TextView) this.bZW.findViewById(a.f.aiapps_label_tv);
        this.cab = (RelativeLayout) this.bZW.findViewById(a.f.aiapps_icon_rl);
        b.a acG = d.acA().acx().acG();
        nb(acG.QZ());
        na(acG.getIconUrl());
        hj(acG.getType());
        this.bZY = (ImageView) this.bZW.findViewById(a.f.light_print);
        this.bZZ = (ImageView) this.bZW.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.bZW.findViewById(a.f.titlebar_right_menu_img);
        this.caa = (ImageView) this.bZW.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.bZW.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.caa.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.cae = this.bZW.findViewById(a.f.titlebar_right_menu_line);
            this.cae.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.caa.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo VX = acG.VX();
        int i = VX == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : VX.payProtected;
        if (!z && ai.ahg() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.bZW.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.bZZ.setAlpha(0.0f);
        this.cac.g(this.cad);
        ahz();
    }

    private void ahx() {
        this.cah = (TextView) this.bZW.findViewById(a.f.aiapps_loading_progress);
        this.caf = (SwanLoadingTipsView) this.bZW.findViewById(a.f.aigames_loading_game_tips);
        this.caf.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: ahE */
            public l invoke() {
                c.this.ahy();
                return null;
            }
        });
        this.cag = new com.baidu.swan.games.loading.a();
        this.bZW.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.ahy();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        ahB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahy() {
        if (this.caf != null && this.cag != null) {
            this.caf.pp(this.cag.aoL());
        }
    }

    private void ahz() {
        this.caa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cad != null && !c.this.cad.isFinishing()) {
                    c.this.cad.moveTaskToBack(true);
                    c.this.ahA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahA() {
        Bundle VM;
        b.a GC = this.cad.GC();
        if (GC != null && (VM = GC.VM()) != null) {
            long j = VM.getLong("page_display_flag_for_statistic");
            VM.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - GC.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bVr = valueOf;
                fVar.n(TiebaInitialize.LogFields.REASON, "close");
                if (GC.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.apB().apC());
                }
                this.cad.a(fVar);
                com.baidu.swan.apps.statistic.c.a(GC);
            }
        }
    }

    private void hj(int i) {
        af.a(this.bng, this.bnh, String.valueOf(i));
    }

    public void hk(int i) {
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.aeF().lC("first_anim_end");
        this.cac.a(this.cad, i);
        this.caj = false;
    }

    public void Jz() {
        this.cac.Jz();
        if (this.caf != null) {
            this.caf.doDestroy();
            this.caf = null;
        }
        if (this.cah != null) {
            this.cah.setVisibility(8);
            this.cah = null;
        }
        if (this.cai != null) {
            this.cai.removeAllUpdateListeners();
            this.cai.cancel();
            this.cai = null;
        }
        this.caj = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.bnf != null) {
            this.bnf.setImageBitmap(bitmap);
        }
    }

    public void W(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.cah != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cak = f2 <= 1.0f ? f2 : 1.0f;
            ahC();
        }
    }

    public void ahB() {
        if (this.cah != null) {
            if (this.cai != null) {
                this.cai.cancel();
                this.cai.removeAllUpdateListeners();
            }
            this.cal = 0.0f;
            this.cak = 0.0f;
            this.cam = 0.0f;
            ahC();
            this.cai = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.cai.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.cal > 0.05d) {
                        c.this.cal = floatValue;
                        c.this.ahC();
                    }
                }
            });
            this.cai.setDuration(4000L);
            this.cai.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        if (this.cah != null) {
            float r = r(this.cal, this.cak);
            if (r >= 1.0f) {
                r = 0.99f;
            }
            X(r);
        }
    }

    private void X(float f) {
        if (this.cah != null && this.cam <= f) {
            this.cam = f;
            this.cah.setText(NumberFormat.getPercentInstance().format(f));
            this.cah.setVisibility(0);
        }
    }

    private float r(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void ahD() {
        if (this.cah != null) {
            if (this.cai != null) {
                this.cai.removeAllUpdateListeners();
                this.cai.cancel();
                this.cai = null;
            }
            X(1.0f);
        }
    }

    public void na(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.acA().getAppId();
        if (this.caj) {
            this.bnf.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity acz;
                    c Gw;
                    if (bitmap != null && (acz = d.acA().acz()) != null && !acz.isDestroyed() && (Gw = acz.Gw()) != null && TextUtils.equals(appId, d.acA().getAppId())) {
                        Gw.l(bitmap);
                    }
                }
            }));
        }
    }

    public void nb(String str) {
        if (this.caj && !TextUtils.isEmpty(str)) {
            this.bZX.setText(str);
        }
    }
}
