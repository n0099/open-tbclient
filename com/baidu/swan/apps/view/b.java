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
    public SwanAppRoundedImageView aqU;
    public BdBaseImageView aqV;
    public TextView aqW;
    public View bci;
    public TextView bcj;
    public ImageView bck;
    public ImageView bcl;
    private ImageView bcm;
    private ImageView bcn;
    public RelativeLayout bco;
    private View bcp;
    private com.baidu.swan.apps.e.a bcq;
    private SwanAppActivity bcr;
    private View bcs;

    public b(SwanAppActivity swanAppActivity) {
        this.bcr = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.bcq == null) {
            this.bcq = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.ai_games_loading_fragment_landscape : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.bci = LayoutInflater.from(this.bcr).inflate(i, (ViewGroup) null);
        this.bcr.vJ().ag(this.bci);
        if (!z) {
            this.bci.setPadding(0, com.baidu.swan.apps.res.widget.a.aOa ? z.getStatusBarHeight() : 0, 0, 0);
        }
        this.bcj = (TextView) this.bci.findViewById(a.f.aiapps_title);
        this.aqU = (SwanAppRoundedImageView) this.bci.findViewById(a.f.aiapps_icon);
        this.aqV = (BdBaseImageView) this.bci.findViewById(a.f.aiapps_label_bg);
        this.aqW = (TextView) this.bci.findViewById(a.f.aiapps_label_tv);
        this.bco = (RelativeLayout) this.bci.findViewById(a.f.aiapps_icon_rl);
        this.bcj.setText(this.bcr.vP().Cz());
        this.aqU.setImageBitmap(ac.a(this.bcr.vP().getIconUrl(), "SwanAppLoadingView", true, new m.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.Mh() != null && (com.baidu.swan.apps.ae.b.Mh().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.Mh().getActivity();
                    b vK = swanAppActivity.vK();
                    com.baidu.swan.apps.v.b.b vP = swanAppActivity.vP();
                    if (vK != null && vP != null && TextUtils.equals(str, vP.getIconUrl())) {
                        vK.j(bitmap);
                    }
                }
            }
        }));
        eK(this.bcr.vP().getType());
        this.bck = (ImageView) this.bci.findViewById(a.f.light_print);
        this.bcl = (ImageView) this.bci.findViewById(a.f.dark_print);
        this.bcm = (ImageView) this.bci.findViewById(a.f.titlebar_right_menu_img);
        this.bcn = (ImageView) this.bci.findViewById(a.f.titlebar_right_menu_exit);
        this.bcp = this.bci.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.bcm.setClickable(true);
            this.bcm.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bcn.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.bcp.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bcs = this.bci.findViewById(a.f.titlebar_right_menu_line);
            this.bcs.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.bcm.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bcn.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.bcp.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.bcl.setAlpha(0.0f);
        this.bcq.c(this.bcr);
        Qi();
    }

    private void Qi() {
        this.bcn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bcr != null && !b.this.bcr.isFinishing()) {
                    b.this.bcr.moveTaskToBack(true);
                    b.this.Qj();
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        Bundle FO;
        com.baidu.swan.apps.v.b.b vP = this.bcr.vP();
        if (vP != null && (FO = vP.FO()) != null) {
            long j = FO.getLong("page_display_flag_for_statistic");
            FO.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - FO.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.aWx = valueOf;
                fVar.k("reason", "close");
                if (vP.FU() == 1) {
                    fVar.k("errorList", com.baidu.swan.games.r.b.Tj().Tk());
                }
                this.bcr.a(fVar);
            }
        }
    }

    private void eK(int i) {
        z.a(this.aqV, this.aqW, String.valueOf(i));
    }

    public void eL(int i) {
        com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.HC().fF("first_anim_end");
        this.bcq.a(this.bcr, i);
    }

    public void xI() {
        this.bcq.xI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.aqU != null) {
            this.aqU.setImageBitmap(bitmap);
        }
    }
}
