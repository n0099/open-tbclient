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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.statistic.a.f;
/* loaded from: classes2.dex */
public class b {
    private View aXi;
    private ImageView aXj;
    private ImageView aXl;
    public View aYp;
    public ImageView aYq;
    public ImageView aYr;
    public RelativeLayout aYs;
    private com.baidu.swan.apps.e.a aYt;
    private SwanAppActivity aYu;
    private View aYv;
    public SwanAppRoundedImageView apC;
    public TextView apD;
    public BdBaseImageView apH;
    public TextView apI;

    public b(SwanAppActivity swanAppActivity) {
        this.aYu = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.aYt == null) {
            this.aYt = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? b.g.aiapps_loading_fragment : b.g.ai_games_loading_fragment;
        } else {
            i = b.g.aiapps_loading_fragment;
        }
        this.aYp = LayoutInflater.from(this.aYu).inflate(i, (ViewGroup) null);
        this.aYu.uv().ae(this.aYp);
        if (!z) {
            this.aYp.setPadding(0, com.baidu.swan.apps.res.widget.a.aKV ? x.getStatusBarHeight() : 0, 0, 0);
        }
        this.apD = (TextView) this.aYp.findViewById(b.f.aiapps_title);
        this.apC = (SwanAppRoundedImageView) this.aYp.findViewById(b.f.aiapps_icon);
        this.apH = (BdBaseImageView) this.aYp.findViewById(b.f.aiapps_label_bg);
        this.apI = (TextView) this.aYp.findViewById(b.f.aiapps_label_tv);
        this.aYs = (RelativeLayout) this.aYp.findViewById(b.f.aiapps_icon_rl);
        this.apD.setText(this.aYu.uB().axC);
        this.apC.setImageBitmap(aa.a(this.aYu.uB().axD, "SwanAppLoadingView", true, new l.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.IX() != null && (com.baidu.swan.apps.ae.b.IX().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.IX().getActivity();
                    b uw = swanAppActivity.uw();
                    com.baidu.swan.apps.v.b.b uB = swanAppActivity.uB();
                    if (uw != null && uB != null && TextUtils.equals(str, uB.axD)) {
                        uw.j(bitmap);
                    }
                }
            }
        }));
        ev(this.aYu.uB().mType);
        this.aYq = (ImageView) this.aYp.findViewById(b.f.light_print);
        this.aYr = (ImageView) this.aYp.findViewById(b.f.dark_print);
        this.aXj = (ImageView) this.aYp.findViewById(b.f.titlebar_right_menu_img);
        this.aXl = (ImageView) this.aYp.findViewById(b.f.titlebar_right_menu_exit);
        this.aXi = this.aYp.findViewById(b.f.titlebar_right_menu);
        if (z) {
            this.aXj.setImageResource(b.e.aiapps_action_bar_single_menu_white_selector);
            this.aXl.setImageResource(b.e.aiapps_action_bar_exit_white_selector);
            this.aXi.setBackgroundResource(b.e.aiapps_action_bar_right_menu_bg_solid);
            this.aYv = this.aYp.findViewById(b.f.titlebar_right_menu_line);
            this.aYv.setBackgroundResource(b.c.aiapps_action_bar_menu_line_white);
        } else {
            this.aXj.setImageResource(b.e.aiapps_action_bar_menu_black_selector);
            this.aXl.setImageResource(b.e.aiapps_action_bar_exit_black_selector);
            this.aXi.setBackgroundResource(b.e.aiapps_action_bar_right_menu_bg);
        }
        this.aYr.setAlpha(0.0f);
        this.aYt.c(this.aYu);
        MH();
    }

    private void MH() {
        this.aXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle;
                if (b.this.aYu != null && !b.this.aYu.isFinishing()) {
                    b.this.aYu.moveTaskToBack(true);
                    String str = "";
                    if (b.this.aYu.uB() != null && (bundle = b.this.aYu.uB().axP) != null) {
                        str = String.valueOf(System.currentTimeMillis() - bundle.getLong("ext_launch_time", 0L));
                    }
                    f fVar = new f();
                    fVar.mType = "launch";
                    fVar.mValue = "realcancel";
                    fVar.aSv = str;
                    b.this.aYu.a(fVar);
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    private void ev(int i) {
        x.a(this.apH, this.apI, String.valueOf(i));
    }

    public void ew(int i) {
        com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.ER().fl("first_anim_end");
        this.aYt.a(this.aYu, i);
    }

    public void wm() {
        this.aYt.wm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.apC != null) {
            this.apC.setImageBitmap(bitmap);
        }
    }
}
