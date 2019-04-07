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
    private View aXm;
    private ImageView aXn;
    private ImageView aXp;
    public View aYt;
    public ImageView aYu;
    public ImageView aYv;
    public RelativeLayout aYw;
    private com.baidu.swan.apps.e.a aYx;
    private SwanAppActivity aYy;
    private View aYz;
    public SwanAppRoundedImageView apH;
    public TextView apI;
    public BdBaseImageView apM;
    public TextView apN;

    public b(SwanAppActivity swanAppActivity) {
        this.aYy = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.aYx == null) {
            this.aYx = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.aiapps_loading_fragment : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.aYt = LayoutInflater.from(this.aYy).inflate(i, (ViewGroup) null);
        this.aYy.uu().ae(this.aYt);
        if (!z) {
            this.aYt.setPadding(0, com.baidu.swan.apps.res.widget.a.aKZ ? x.getStatusBarHeight() : 0, 0, 0);
        }
        this.apI = (TextView) this.aYt.findViewById(a.f.aiapps_title);
        this.apH = (SwanAppRoundedImageView) this.aYt.findViewById(a.f.aiapps_icon);
        this.apM = (BdBaseImageView) this.aYt.findViewById(a.f.aiapps_label_bg);
        this.apN = (TextView) this.aYt.findViewById(a.f.aiapps_label_tv);
        this.aYw = (RelativeLayout) this.aYt.findViewById(a.f.aiapps_icon_rl);
        this.apI.setText(this.aYy.uA().axG);
        this.apH.setImageBitmap(aa.a(this.aYy.uA().axH, "SwanAppLoadingView", true, new l.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.IV() != null && (com.baidu.swan.apps.ae.b.IV().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.IV().getActivity();
                    b uv = swanAppActivity.uv();
                    com.baidu.swan.apps.v.b.b uA = swanAppActivity.uA();
                    if (uv != null && uA != null && TextUtils.equals(str, uA.axH)) {
                        uv.j(bitmap);
                    }
                }
            }
        }));
        eu(this.aYy.uA().mType);
        this.aYu = (ImageView) this.aYt.findViewById(a.f.light_print);
        this.aYv = (ImageView) this.aYt.findViewById(a.f.dark_print);
        this.aXn = (ImageView) this.aYt.findViewById(a.f.titlebar_right_menu_img);
        this.aXp = (ImageView) this.aYt.findViewById(a.f.titlebar_right_menu_exit);
        this.aXm = this.aYt.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.aXn.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.aXp.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.aXm.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.aYz = this.aYt.findViewById(a.f.titlebar_right_menu_line);
            this.aYz.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.aXn.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.aXp.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.aXm.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.aYv.setAlpha(0.0f);
        this.aYx.c(this.aYy);
        MF();
    }

    private void MF() {
        this.aXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle;
                if (b.this.aYy != null && !b.this.aYy.isFinishing()) {
                    b.this.aYy.moveTaskToBack(true);
                    String str = "";
                    if (b.this.aYy.uA() != null && (bundle = b.this.aYy.uA().axT) != null) {
                        str = String.valueOf(System.currentTimeMillis() - bundle.getLong("ext_launch_time", 0L));
                    }
                    f fVar = new f();
                    fVar.mType = "launch";
                    fVar.mValue = "realcancel";
                    fVar.aSz = str;
                    b.this.aYy.a(fVar);
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    private void eu(int i) {
        x.a(this.apM, this.apN, String.valueOf(i));
    }

    public void ev(int i) {
        com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.EP().fm("first_anim_end");
        this.aYx.a(this.aYy, i);
    }

    public void wl() {
        this.aYx.wl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.apH != null) {
            this.apH.setImageBitmap(bitmap);
        }
    }
}
