package com.baidu.swan.apps.aa;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.as.ae;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.aj;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.h;
import com.baidu.swan.menu.i;
import com.baidu.tbadk.TbConfig;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.d.b bAf;
    private String bAg;
    private h bix;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0186a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bix = hVar;
        this.bAf = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        Vw();
    }

    private void Vw() {
        com.baidu.swan.apps.w.a.RU().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void Vx() {
        e ZT;
        if (this.bix != null && this.bAf != null && this.mContext != null && (ZT = e.ZT()) != null) {
            this.bix.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bix.eJ(ZT.aaj());
            if (!ZT.aaj()) {
                this.bix.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
                    @Override // com.baidu.swan.menu.viewpager.b
                    public boolean c(i iVar) {
                        return a.this.a(iVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(i iVar) {
        if (this.bAf == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, Vy() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).fQ(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.bAf == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                Vz();
                return true;
            case 5:
                VB();
                return true;
            case 35:
                VC();
                return true;
            case 36:
                VE();
                return true;
            case 37:
                VF();
                return true;
            case 38:
                VA();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                VG();
                return true;
            case 42:
                VD();
                return true;
            default:
                return com.baidu.swan.apps.w.a.Ro().d(iVar);
        }
    }

    private boolean Vy() {
        aj.cM(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.aeB()));
        return true;
    }

    private void Vz() {
        this.bAf.Lf();
        jd(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void VA() {
        String appId = com.baidu.swan.apps.runtime.d.ZP().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.hk(appId)) {
                jb(appId);
            } else {
                jc(appId);
            }
        }
    }

    private void jb(String str) {
        SwanFavorDataManager.Pt().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void PC() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).fQ(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void PD() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).fQ(2).showToast();
            }
        });
        jd("deletemyswan");
    }

    private void jc(String str) {
        if (com.baidu.swan.apps.ah.a.a.XQ()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.aXY = null;
        final String page = ai.aeB().getPage();
        SwanFavorDataManager.Pt().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void PA() {
                com.baidu.swan.apps.database.favorite.a.Oy();
                if (a.O(a.this.bAf.arR())) {
                    a.aM("addmyswan", page);
                } else {
                    d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).fQ(2).fM(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void PB() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).fQ(2).showToast();
            }
        });
        aM("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0186a interfaceC0186a) {
        String appId = com.baidu.swan.apps.runtime.d.ZP().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0186a != null) {
            interfaceC0186a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.hk(appId)) {
            SwanFavorDataManager.Pt().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void PA() {
                    com.baidu.swan.apps.database.favorite.a.Oy();
                    if (a.O(activity)) {
                        if (interfaceC0186a != null) {
                            interfaceC0186a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_success).fQ(2).fM(2).showToast();
                    if (interfaceC0186a != null) {
                        interfaceC0186a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void PB() {
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_fail).fQ(2).showToast();
                    if (interfaceC0186a != null) {
                        interfaceC0186a.onFail();
                    }
                }
            });
        } else if (interfaceC0186a != null) {
            interfaceC0186a.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(Activity activity) {
        if (ai.aez()) {
            if (com.baidu.swan.apps.database.favorite.a.Oz() > 3 || com.baidu.swan.apps.storage.c.h.acE().getBoolean("favorite_guide_checkbox_value", false)) {
                return false;
            }
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
            com.baidu.swan.apps.as.c.b(activity, cVar);
            cVar.setContentView(a.g.aiapps_entry_guide_layout);
            cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
            final CheckBox checkBox = (CheckBox) cVar.findViewById(a.f.aiapps_entry_guide_reminder_tip);
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.apps.aa.a.6
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aXY, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState()) {
                cVar.findViewById(a.f.nightmode_mask).setVisibility(0);
            } else {
                cVar.findViewById(a.f.nightmode_mask).setVisibility(8);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) cVar.findViewById(a.f.aiapps_guide_anim_view);
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setImageAssetsFolder("lottieImage/images");
            lottieAnimationView.setAnimation("lottieImage/favorGuide.json");
            lottieAnimationView.playAnimation();
            cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
            TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
            textView.setOnTouchListener(new ae());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.aa.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (checkBox.isChecked()) {
                        com.baidu.swan.apps.storage.c.h.acE().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aXY, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aXY, "", "show");
            e ZT = e.ZT();
            if (ZT != null) {
                ZT.aai().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void VB() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.RG().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.bAf.arR() != null && (this.bAf.arR() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bAf.arR()).h(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).fR(a.e.aiapps_day_mode_toast_icon).fQ(2).showHighlightToast();
        } else {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).fR(a.e.aiapps_night_mode_toast_icon).fQ(2).showHighlightToast();
        }
        jd("daynightmode");
    }

    private void VC() {
        b.a DR;
        if (com.baidu.swan.apps.ah.a.a.XQ()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.ZT() != null) {
            DR = e.ZT().ZV();
        } else {
            DR = ((SwanAppActivity) this.bAf.arR()).DR();
        }
        com.baidu.swan.apps.al.a.a(this.bAf.getContext(), DR);
        jd("addshortcut");
    }

    private void VD() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.m((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bAf instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bAf;
            com.baidu.swan.apps.adaptation.b.c Lr = dVar.Lr();
            if (Lr == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.Uf().TP());
            hashMap.put("pagePath", dVar.Lq().getPage());
            hashMap.put("slaveId", Lr.Ge());
            com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            jd(Headers.REFRESH);
        }
    }

    private void VE() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        DP.gJ("navigateTo").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("about", null).commit();
        jd("about");
    }

    private void VF() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e DP = this.bAf.DP();
        if (DP == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        DP.gJ("navigateTo").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("setting", null).commit();
        jd("permission");
    }

    private void VG() {
        if (TextUtils.isEmpty(this.bAg)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.bAg = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.bAg);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.Rk(), this.bAg);
        jd("miniapp_center");
    }

    public static void jd(String str) {
        aM(str, null);
    }

    public static void aM(String str, String str2) {
        B(str, str2, null);
    }

    public static void B(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.n("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
            if (TQ != null) {
                TQ.a(fVar);
            }
        }
    }
}
