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
    private View aXn;
    private ImageView aXo;
    private ImageView aXq;
    private View aYA;
    public View aYu;
    public ImageView aYv;
    public ImageView aYw;
    public RelativeLayout aYx;
    private com.baidu.swan.apps.e.a aYy;
    private SwanAppActivity aYz;
    public SwanAppRoundedImageView apI;
    public TextView apJ;
    public BdBaseImageView apN;
    public TextView apO;

    public b(SwanAppActivity swanAppActivity) {
        this.aYz = swanAppActivity;
    }

    public void h(boolean z, boolean z2) {
        int i;
        if (this.aYy == null) {
            this.aYy = new com.baidu.swan.apps.e.a();
        }
        if (z) {
            i = z2 ? a.g.aiapps_loading_fragment : a.g.ai_games_loading_fragment;
        } else {
            i = a.g.aiapps_loading_fragment;
        }
        this.aYu = LayoutInflater.from(this.aYz).inflate(i, (ViewGroup) null);
        this.aYz.uu().ae(this.aYu);
        if (!z) {
            this.aYu.setPadding(0, com.baidu.swan.apps.res.widget.a.aLa ? x.getStatusBarHeight() : 0, 0, 0);
        }
        this.apJ = (TextView) this.aYu.findViewById(a.f.aiapps_title);
        this.apI = (SwanAppRoundedImageView) this.aYu.findViewById(a.f.aiapps_icon);
        this.apN = (BdBaseImageView) this.aYu.findViewById(a.f.aiapps_label_bg);
        this.apO = (TextView) this.aYu.findViewById(a.f.aiapps_label_tv);
        this.aYx = (RelativeLayout) this.aYu.findViewById(a.f.aiapps_icon_rl);
        this.apJ.setText(this.aYz.uA().axH);
        this.apI.setImageBitmap(aa.a(this.aYz.uA().axI, "SwanAppLoadingView", true, new l.a() { // from class: com.baidu.swan.apps.view.b.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str, Bitmap bitmap) {
                if (bitmap != null && com.baidu.swan.apps.ae.b.IV() != null && (com.baidu.swan.apps.ae.b.IV().getActivity() instanceof SwanAppActivity)) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) com.baidu.swan.apps.ae.b.IV().getActivity();
                    b uv = swanAppActivity.uv();
                    com.baidu.swan.apps.v.b.b uA = swanAppActivity.uA();
                    if (uv != null && uA != null && TextUtils.equals(str, uA.axI)) {
                        uv.j(bitmap);
                    }
                }
            }
        }));
        eu(this.aYz.uA().mType);
        this.aYv = (ImageView) this.aYu.findViewById(a.f.light_print);
        this.aYw = (ImageView) this.aYu.findViewById(a.f.dark_print);
        this.aXo = (ImageView) this.aYu.findViewById(a.f.titlebar_right_menu_img);
        this.aXq = (ImageView) this.aYu.findViewById(a.f.titlebar_right_menu_exit);
        this.aXn = this.aYu.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.aXo.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.aXq.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.aXn.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.aYA = this.aYu.findViewById(a.f.titlebar_right_menu_line);
            this.aYA.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.aXo.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.aXq.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.aXn.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        this.aYw.setAlpha(0.0f);
        this.aYy.c(this.aYz);
        MF();
    }

    private void MF() {
        this.aXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle;
                if (b.this.aYz != null && !b.this.aYz.isFinishing()) {
                    b.this.aYz.moveTaskToBack(true);
                    String str = "";
                    if (b.this.aYz.uA() != null && (bundle = b.this.aYz.uA().axU) != null) {
                        str = String.valueOf(System.currentTimeMillis() - bundle.getLong("ext_launch_time", 0L));
                    }
                    f fVar = new f();
                    fVar.mType = "launch";
                    fVar.mValue = "realcancel";
                    fVar.aSA = str;
                    b.this.aYz.a(fVar);
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
                }
            }
        });
    }

    private void eu(int i) {
        x.a(this.apN, this.apO, String.valueOf(i));
    }

    public void ev(int i) {
        com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.y.f.EP().fm("first_anim_end");
        this.aYy.a(this.aYz, i);
    }

    public void wl() {
        this.aYy.wl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        if (bitmap != null && this.apI != null) {
            this.apI.setImageBitmap(bitmap);
        }
    }
}
