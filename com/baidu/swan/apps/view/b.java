package com.baidu.swan.apps.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.statistic.a.f;
/* loaded from: classes2.dex */
public class b {
    public SwanAppRoundedImageView aqw;
    public BdBaseImageView aqx;
    public TextView aqy;
    public View bbK;
    public TextView bbL;
    public ImageView bbM;
    public ImageView bbN;
    private ImageView bbO;
    private ImageView bbP;
    public RelativeLayout bbQ;
    private View bbR;
    private com.baidu.swan.apps.e.a bbS;
    private SwanAppActivity bbT;
    private View bbU;

    public b(SwanAppActivity swanAppActivity) {
        this.bbT = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.bbS == null) {
            this.bbS = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.ai_games_loading_fragment_landscape : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.bbK = LayoutInflater.from(this.bbT).inflate(i, (ViewGroup) null);
        this.bbT.vF().ag(this.bbK);
        if (!z) {
            this.bbK.setPadding(0, com.baidu.swan.apps.res.widget.a.aNC ? z.getStatusBarHeight() : 0, 0, 0);
        }
        this.bbL = (TextView) this.bbK.findViewById(a.f.aiapps_title);
        this.aqw = (SwanAppRoundedImageView) this.bbK.findViewById(a.f.aiapps_icon);
        this.aqx = (BdBaseImageView) this.bbK.findViewById(a.f.aiapps_label_bg);
        this.aqy = (TextView) this.bbK.findViewById(a.f.aiapps_label_tv);
        this.bbQ = (RelativeLayout) this.bbK.findViewById(a.f.aiapps_icon_rl);
        this.bbL.setText(this.bbT.vL().Cv());
        this.aqw.setImageBitmap(ac.a(this.bbT.vL().getIconUrl(), "SwanAppLoadingView", true, new m.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.Md() != null && (com.baidu.swan.apps.ae.b.Md().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.Md().getActivity();
                    b vG = swanAppActivity.vG();
                    com.baidu.swan.apps.v.b.b vL = swanAppActivity.vL();
                    if (vG != null && vL != null && TextUtils.equals(str, vL.getIconUrl())) {
                        vG.j(bitmap);
                    }
                }
            }
        }));
        eJ(this.bbT.vL().getType());
        this.bbM = (ImageView) this.bbK.findViewById(a.f.light_print);
        this.bbN = (ImageView) this.bbK.findViewById(a.f.dark_print);
        this.bbO = (ImageView) this.bbK.findViewById(a.f.titlebar_right_menu_img);
        this.bbP = (ImageView) this.bbK.findViewById(a.f.titlebar_right_menu_exit);
        this.bbR = this.bbK.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.bbO.setClickable(true);
            this.bbO.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bbP.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.bbR.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bbU = this.bbK.findViewById(a.f.titlebar_right_menu_line);
            this.bbU.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.bbO.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bbP.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.bbR.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.bbN.setAlpha(0.0f);
        this.bbS.c(this.bbT);
        Qe();
    }

    private void Qe() {
        this.bbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bbT != null && !b.this.bbT.isFinishing()) {
                    b.this.bbT.moveTaskToBack(true);
                    b.this.Qf();
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qf() {
        Bundle FK;
        com.baidu.swan.apps.v.b.b vL = this.bbT.vL();
        if (vL != null && (FK = vL.FK()) != null) {
            long j = FK.getLong("page_display_flag_for_statistic");
            FK.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - FK.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.aVZ = valueOf;
                fVar.k("reason", "close");
                if (vL.FQ() == 1) {
                    fVar.k("errorList", com.baidu.swan.games.r.b.Tf().Tg());
                }
                this.bbT.a(fVar);
            }
        }
    }

    private void eJ(int i) {
        z.a(this.aqx, this.aqy, String.valueOf(i));
    }

    public void eK(int i) {
        com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.Hy().fD("first_anim_end");
        this.bbS.a(this.bbT, i);
    }

    public void xE() {
        this.bbS.xE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.aqw != null) {
            this.aqw.setImageBitmap(bitmap);
        }
    }
}
