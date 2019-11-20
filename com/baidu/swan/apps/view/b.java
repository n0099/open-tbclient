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
    public SwanAppRoundedImageView aJS;
    public BdBaseImageView aJT;
    public TextView aJU;
    private SwanAppActivity buA;
    private View buB;
    public View bur;
    public TextView bus;
    public ImageView but;
    public ImageView buu;
    private ImageView buv;
    private ImageView buw;
    public RelativeLayout bux;
    private View buy;
    private com.baidu.swan.apps.e.a buz;

    public b(SwanAppActivity swanAppActivity) {
        this.buA = swanAppActivity;
    }

    public void l(boolean z, boolean z2) {
        int i;
        if (this.buz == null) {
            this.buz = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.ai_games_loading_fragment_landscape : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.bur = LayoutInflater.from(this.buA).inflate(i, (ViewGroup) null);
        this.buA.AE().am(this.bur);
        if (!z) {
            this.bur.setPadding(0, com.baidu.swan.apps.res.widget.a.bgQ ? z.getStatusBarHeight() : 0, 0, 0);
        }
        this.bus = (TextView) this.bur.findViewById(a.f.aiapps_title);
        this.aJS = (SwanAppRoundedImageView) this.bur.findViewById(a.f.aiapps_icon);
        this.aJT = (BdBaseImageView) this.bur.findViewById(a.f.aiapps_label_bg);
        this.aJU = (TextView) this.bur.findViewById(a.f.aiapps_label_tv);
        this.bux = (RelativeLayout) this.bur.findViewById(a.f.aiapps_icon_rl);
        this.bus.setText(this.buA.AK().Hu());
        this.aJS.setImageBitmap(ac.a(this.buA.AK().getIconUrl(), "SwanAppLoadingView", true, new m.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.m.a
            public void e(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.Ra() != null && (com.baidu.swan.apps.ae.b.Ra().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.Ra().getActivity();
                    b AF = swanAppActivity.AF();
                    com.baidu.swan.apps.v.b.b AK = swanAppActivity.AK();
                    if (AF != null && AK != null && TextUtils.equals(str, AK.getIconUrl())) {
                        AF.l(bitmap);
                    }
                }
            }
        }));
        fE(this.buA.AK().getType());
        this.but = (ImageView) this.bur.findViewById(a.f.light_print);
        this.buu = (ImageView) this.bur.findViewById(a.f.dark_print);
        this.buv = (ImageView) this.bur.findViewById(a.f.titlebar_right_menu_img);
        this.buw = (ImageView) this.bur.findViewById(a.f.titlebar_right_menu_exit);
        this.buy = this.bur.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.buv.setClickable(true);
            this.buv.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.buw.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.buy.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.buB = this.bur.findViewById(a.f.titlebar_right_menu_line);
            this.buB.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.buv.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.buw.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.buy.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.buu.setAlpha(0.0f);
        this.buz.c(this.buA);
        UW();
    }

    private void UW() {
        this.buw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.buA != null && !b.this.buA.isFinishing()) {
                    b.this.buA.moveTaskToBack(true);
                    b.this.UX();
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UX() {
        Bundle KJ;
        com.baidu.swan.apps.v.b.b AK = this.buA.AK();
        if (AK != null && (KJ = AK.KJ()) != null) {
            long j = KJ.getLong("page_display_flag_for_statistic");
            KJ.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - KJ.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.bpj = valueOf;
                fVar.h(TiebaInitialize.LogFields.REASON, "close");
                if (AK.KP() == 1) {
                    fVar.h("errorList", com.baidu.swan.games.r.b.XY().XZ());
                }
                this.buA.a(fVar);
            }
        }
    }

    private void fE(int i) {
        z.a(this.aJT, this.aJU, String.valueOf(i));
    }

    public void fF(int i) {
        com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.Mx().gj("first_anim_end");
        this.buz.a(this.buA, i);
    }

    public void CD() {
        this.buz.CD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (bitmap != null && this.aJS != null) {
            this.aJS.setImageBitmap(bitmap);
        }
    }
}
