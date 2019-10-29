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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    public SwanAppRoundedImageView aKk;
    public BdBaseImageView aKl;
    public TextView aKm;
    public View bvi;
    public TextView bvj;
    public ImageView bvk;
    public ImageView bvl;
    private ImageView bvm;
    private ImageView bvn;
    public RelativeLayout bvo;
    private View bvp;
    private com.baidu.swan.apps.e.a bvq;
    private SwanAppActivity bvr;
    private View bvs;

    public b(SwanAppActivity swanAppActivity) {
        this.bvr = swanAppActivity;
    }

    public void l(boolean z, boolean z2) {
        int i;
        if (this.bvq == null) {
            this.bvq = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.ai_games_loading_fragment_landscape : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.bvi = LayoutInflater.from(this.bvr).inflate(i, (ViewGroup) null);
        this.bvr.AD().am(this.bvi);
        if (!z) {
            this.bvi.setPadding(0, com.baidu.swan.apps.res.widget.a.bhi ? z.getStatusBarHeight() : 0, 0, 0);
        }
        this.bvj = (TextView) this.bvi.findViewById(a.f.aiapps_title);
        this.aKk = (SwanAppRoundedImageView) this.bvi.findViewById(a.f.aiapps_icon);
        this.aKl = (BdBaseImageView) this.bvi.findViewById(a.f.aiapps_label_bg);
        this.aKm = (TextView) this.bvi.findViewById(a.f.aiapps_label_tv);
        this.bvo = (RelativeLayout) this.bvi.findViewById(a.f.aiapps_icon_rl);
        this.bvj.setText(this.bvr.AJ().Ht());
        this.aKk.setImageBitmap(ac.a(this.bvr.AJ().getIconUrl(), "SwanAppLoadingView", true, new m.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.m.a
            public void e(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.QZ() != null && (com.baidu.swan.apps.ae.b.QZ().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.QZ().getActivity();
                    b AE = swanAppActivity.AE();
                    com.baidu.swan.apps.v.b.b AJ = swanAppActivity.AJ();
                    if (AE != null && AJ != null && TextUtils.equals(str, AJ.getIconUrl())) {
                        AE.l(bitmap);
                    }
                }
            }
        }));
        fF(this.bvr.AJ().getType());
        this.bvk = (ImageView) this.bvi.findViewById(a.f.light_print);
        this.bvl = (ImageView) this.bvi.findViewById(a.f.dark_print);
        this.bvm = (ImageView) this.bvi.findViewById(a.f.titlebar_right_menu_img);
        this.bvn = (ImageView) this.bvi.findViewById(a.f.titlebar_right_menu_exit);
        this.bvp = this.bvi.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.bvm.setClickable(true);
            this.bvm.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bvn.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.bvp.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bvs = this.bvi.findViewById(a.f.titlebar_right_menu_line);
            this.bvs.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.bvm.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bvn.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.bvp.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.bvl.setAlpha(0.0f);
        this.bvq.c(this.bvr);
        UY();
    }

    private void UY() {
        this.bvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bvr != null && !b.this.bvr.isFinishing()) {
                    b.this.bvr.moveTaskToBack(true);
                    b.this.UZ();
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UZ() {
        Bundle KI;
        com.baidu.swan.apps.v.b.b AJ = this.bvr.AJ();
        if (AJ != null && (KI = AJ.KI()) != null) {
            long j = KI.getLong("page_display_flag_for_statistic");
            KI.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - KI.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bpB = valueOf;
                fVar.h(TiebaInitialize.LogFields.REASON, "close");
                if (AJ.KO() == 1) {
                    fVar.h("errorList", com.baidu.swan.games.r.b.Ya().Yb());
                }
                this.bvr.a(fVar);
            }
        }
    }

    private void fF(int i) {
        z.a(this.aKl, this.aKm, String.valueOf(i));
    }

    public void fG(int i) {
        com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.Mw().gj("first_anim_end");
        this.bvq.a(this.bvr, i);
    }

    public void CC() {
        this.bvq.CC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.aKk != null) {
            this.aKk.setImageBitmap(bitmap);
        }
    }
}
