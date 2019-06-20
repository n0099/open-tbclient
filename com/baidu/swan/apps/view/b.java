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
    public SwanAppRoundedImageView apT;
    public BdBaseImageView apU;
    public TextView apV;
    public View baZ;
    public TextView bba;
    public ImageView bbb;
    public ImageView bbc;
    private ImageView bbd;
    private ImageView bbe;
    public RelativeLayout bbf;
    private View bbg;
    private com.baidu.swan.apps.e.a bbh;
    private SwanAppActivity bbi;
    private View bbj;

    public b(SwanAppActivity swanAppActivity) {
        this.bbi = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.bbh == null) {
            this.bbh = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.ai_games_loading_fragment_landscape : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.baZ = LayoutInflater.from(this.bbi).inflate(i, (ViewGroup) null);
        this.bbi.ve().ae(this.baZ);
        if (!z) {
            this.baZ.setPadding(0, com.baidu.swan.apps.res.widget.a.aMT ? z.getStatusBarHeight() : 0, 0, 0);
        }
        this.bba = (TextView) this.baZ.findViewById(a.f.aiapps_title);
        this.apT = (SwanAppRoundedImageView) this.baZ.findViewById(a.f.aiapps_icon);
        this.apU = (BdBaseImageView) this.baZ.findViewById(a.f.aiapps_label_bg);
        this.apV = (TextView) this.baZ.findViewById(a.f.aiapps_label_tv);
        this.bbf = (RelativeLayout) this.baZ.findViewById(a.f.aiapps_icon_rl);
        this.bba.setText(this.bbi.vk().BM());
        this.apT.setImageBitmap(ac.a(this.bbi.vk().getIconUrl(), "SwanAppLoadingView", true, new m.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.Lq() != null && (com.baidu.swan.apps.ae.b.Lq().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.Lq().getActivity();
                    b vf = swanAppActivity.vf();
                    com.baidu.swan.apps.v.b.b vk = swanAppActivity.vk();
                    if (vf != null && vk != null && TextUtils.equals(str, vk.getIconUrl())) {
                        vf.j(bitmap);
                    }
                }
            }
        }));
        eG(this.bbi.vk().getType());
        this.bbb = (ImageView) this.baZ.findViewById(a.f.light_print);
        this.bbc = (ImageView) this.baZ.findViewById(a.f.dark_print);
        this.bbd = (ImageView) this.baZ.findViewById(a.f.titlebar_right_menu_img);
        this.bbe = (ImageView) this.baZ.findViewById(a.f.titlebar_right_menu_exit);
        this.bbg = this.baZ.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.bbd.setClickable(true);
            this.bbd.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.bbe.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.bbg.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.bbj = this.baZ.findViewById(a.f.titlebar_right_menu_line);
            this.bbj.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.bbd.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.bbe.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.bbg.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.bbc.setAlpha(0.0f);
        this.bbh.c(this.bbi);
        Pn();
    }

    private void Pn() {
        this.bbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.bbi != null && !b.this.bbi.isFinishing()) {
                    b.this.bbi.moveTaskToBack(true);
                    b.this.Po();
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        Bundle Fa;
        com.baidu.swan.apps.v.b.b vk = this.bbi.vk();
        if (vk != null && (Fa = vk.Fa()) != null) {
            long j = Fa.getLong("page_display_flag_for_statistic");
            Fa.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Fa.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mType = "launch";
                fVar.mValue = "realcancel";
                fVar.aVp = valueOf;
                fVar.k("reason", "close");
                if (vk.Fg() == 1) {
                    fVar.k("errorList", com.baidu.swan.games.r.b.Sm().Sn());
                }
                this.bbi.a(fVar);
            }
        }
    }

    private void eG(int i) {
        z.a(this.apU, this.apV, String.valueOf(i));
    }

    public void eH(int i) {
        com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.GN().fy("first_anim_end");
        this.bbh.a(this.bbi, i);
    }

    public void xd() {
        this.bbh.xd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.apT != null) {
            this.apT.setImageBitmap(bitmap);
        }
    }
}
