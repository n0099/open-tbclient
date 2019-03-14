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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.statistic.a.f;
/* loaded from: classes2.dex */
public class b {
    private View aXj;
    private ImageView aXk;
    private ImageView aXm;
    public View aYq;
    public ImageView aYr;
    public ImageView aYs;
    public RelativeLayout aYt;
    private com.baidu.swan.apps.e.a aYu;
    private SwanAppActivity aYv;
    private View aYw;
    public SwanAppRoundedImageView apD;
    public TextView apE;
    public BdBaseImageView apI;
    public TextView apJ;

    public b(SwanAppActivity swanAppActivity) {
        this.aYv = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.aYu == null) {
            this.aYu = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.aiapps_loading_fragment : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.aYq = LayoutInflater.from(this.aYv).inflate(i, (ViewGroup) null);
        this.aYv.uv().ae(this.aYq);
        if (!z) {
            this.aYq.setPadding(0, com.baidu.swan.apps.res.widget.a.aKW ? x.getStatusBarHeight() : 0, 0, 0);
        }
        this.apE = (TextView) this.aYq.findViewById(a.f.aiapps_title);
        this.apD = (SwanAppRoundedImageView) this.aYq.findViewById(a.f.aiapps_icon);
        this.apI = (BdBaseImageView) this.aYq.findViewById(a.f.aiapps_label_bg);
        this.apJ = (TextView) this.aYq.findViewById(a.f.aiapps_label_tv);
        this.aYt = (RelativeLayout) this.aYq.findViewById(a.f.aiapps_icon_rl);
        this.apE.setText(this.aYv.uB().axD);
        this.apD.setImageBitmap(aa.a(this.aYv.uB().axE, "SwanAppLoadingView", true, new l.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.IX() != null && (com.baidu.swan.apps.ae.b.IX().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.IX().getActivity();
                    b uw = swanAppActivity.uw();
                    com.baidu.swan.apps.v.b.b uB = swanAppActivity.uB();
                    if (uw != null && uB != null && TextUtils.equals(str, uB.axE)) {
                        uw.j(bitmap);
                    }
                }
            }
        }));
        ev(this.aYv.uB().mType);
        this.aYr = (ImageView) this.aYq.findViewById(a.f.light_print);
        this.aYs = (ImageView) this.aYq.findViewById(a.f.dark_print);
        this.aXk = (ImageView) this.aYq.findViewById(a.f.titlebar_right_menu_img);
        this.aXm = (ImageView) this.aYq.findViewById(a.f.titlebar_right_menu_exit);
        this.aXj = this.aYq.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.aXk.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.aXm.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.aXj.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.aYw = this.aYq.findViewById(a.f.titlebar_right_menu_line);
            this.aYw.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.aXk.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.aXm.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.aXj.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.aYs.setAlpha(0.0f);
        this.aYu.c(this.aYv);
        MH();
    }

    private void MH() {
        this.aXm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle;
                if (b.this.aYv != null && !b.this.aYv.isFinishing()) {
                    b.this.aYv.moveTaskToBack(true);
                    String str = "";
                    if (b.this.aYv.uB() != null && (bundle = b.this.aYv.uB().axQ) != null) {
                        str = String.valueOf(System.currentTimeMillis() - bundle.getLong("ext_launch_time", 0L));
                    }
                    f fVar = new f();
                    fVar.mType = "launch";
                    fVar.mValue = "realcancel";
                    fVar.aSw = str;
                    b.this.aYv.a(fVar);
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    private void ev(int i) {
        x.a(this.apI, this.apJ, String.valueOf(i));
    }

    public void ew(int i) {
        com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.ER().fl("first_anim_end");
        this.aYu.a(this.aYv, i);
    }

    public void wm() {
        this.aYu.wm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.apD != null) {
            this.apD.setImageBitmap(bitmap);
        }
    }
}
