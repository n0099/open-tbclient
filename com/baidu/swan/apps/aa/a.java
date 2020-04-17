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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h bLS;
    private com.baidu.swan.apps.core.d.b cdU;
    private String cdV;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0228a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bLS = hVar;
        this.cdU = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        ags();
    }

    private void ags() {
        com.baidu.swan.apps.w.a.acy().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void agt() {
        e akO;
        if (this.bLS != null && this.cdU != null && this.mContext != null && (akO = e.akO()) != null) {
            this.bLS.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bLS.fT(akO.ale());
            if (!akO.ale()) {
                this.bLS.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
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
        if (this.cdU == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, agu() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gp(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cdU == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                agv();
                return true;
            case 5:
                agx();
                return true;
            case 35:
                agy();
                return true;
            case 36:
                agA();
                return true;
            case 37:
                agB();
                return true;
            case 38:
                agw();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                agC();
                return true;
            case 42:
                agz();
                return true;
            default:
                return com.baidu.swan.apps.w.a.abS().d(iVar);
        }
    }

    private boolean agu() {
        aj.cD(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.apv()));
        return true;
    }

    private void agv() {
        this.cdU.VI();
        kH(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void agw() {
        String appId = com.baidu.swan.apps.runtime.d.akK().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.iP(appId)) {
                kF(appId);
            } else {
                kG(appId);
            }
        }
    }

    private void kF(String str) {
        SwanFavorDataManager.ZX().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aag() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gp(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aah() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gp(2).showToast();
            }
        });
        kH("deletemyswan");
    }

    private void kG(String str) {
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bBD = null;
        final String page = ai.apv().getPage();
        SwanFavorDataManager.ZX().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aae() {
                com.baidu.swan.apps.database.favorite.a.Zc();
                if (a.M(a.this.cdU.aCO())) {
                    a.bf("addmyswan", page);
                } else {
                    d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gp(2).gk(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aaf() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gp(2).showToast();
            }
        });
        bf("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0228a interfaceC0228a) {
        String appId = com.baidu.swan.apps.runtime.d.akK().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0228a != null) {
            interfaceC0228a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.iP(appId)) {
            SwanFavorDataManager.ZX().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aae() {
                    com.baidu.swan.apps.database.favorite.a.Zc();
                    if (a.M(activity)) {
                        if (interfaceC0228a != null) {
                            interfaceC0228a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).gp(2).gk(2).showToast();
                    if (interfaceC0228a != null) {
                        interfaceC0228a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aaf() {
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).gp(2).showToast();
                    if (interfaceC0228a != null) {
                        interfaceC0228a.onFail();
                    }
                }
            });
        } else if (interfaceC0228a != null) {
            interfaceC0228a.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean M(Activity activity) {
        if (ai.apt()) {
            if (com.baidu.swan.apps.database.favorite.a.Zd() > 3 || com.baidu.swan.apps.storage.c.h.anz().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBD, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.anz().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBD, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBD, "", "show");
            e akO = e.akO();
            if (akO != null) {
                akO.ald().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void agx() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.ack().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cdU.aCO() != null && (this.cdU.aCO() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cdU.aCO()).i(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gq(a.e.aiapps_day_mode_toast_icon).gp(2).showHighlightToast();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gq(a.e.aiapps_night_mode_toast_icon).gp(2).showHighlightToast();
        }
        kH("daynightmode");
    }

    private void agy() {
        b.a Ow;
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.akO() != null) {
            Ow = e.akO().akQ();
        } else {
            Ow = ((SwanAppActivity) this.cdU.aCO()).Ow();
        }
        com.baidu.swan.apps.al.a.a(this.cdU.getContext(), Ow);
        kH("addshortcut");
    }

    private void agz() {
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
        if (this.cdU instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.cdU;
            com.baidu.swan.apps.adaptation.b.c VU = dVar.VU();
            if (VU == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.aeK().aeu());
            hashMap.put("pagePath", dVar.VT().getPage());
            hashMap.put("slaveId", VU.QG());
            com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            kH(Headers.REFRESH);
        }
    }

    private void agA() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Ou.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).a("about", null).commit();
        kH("about");
    }

    private void agB() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e Ou = this.cdU.Ou();
        if (Ou == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Ou.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).a("setting", null).commit();
        kH("permission");
    }

    private void agC() {
        if (TextUtils.isEmpty(this.cdV)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.cdV = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.cdV);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.abO(), this.cdV);
        kH("miniapp_center");
    }

    public static void kH(String str) {
        bf(str, null);
    }

    public static void bf(String str, String str2) {
        C(str, str2, null);
    }

    public static void C(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.s("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
            if (aev != null) {
                aev.a(fVar);
            }
        }
    }
}
