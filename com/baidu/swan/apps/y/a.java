package com.baidu.swan.apps.y;

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
import com.baidu.swan.apps.aq.af;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.ak;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.h;
import com.baidu.swan.menu.i;
import com.baidu.tbadk.TbConfig;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h bZP;
    private com.baidu.swan.apps.core.d.b cts;
    private String ctt;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0409a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bZP = hVar;
        this.cts = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        akL();
    }

    private void akL() {
        com.baidu.swan.apps.u.a.agG().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void akM() {
        e apN;
        if (this.bZP != null && this.cts != null && this.mContext != null && (apN = e.apN()) != null) {
            this.bZP.a(new f() { // from class: com.baidu.swan.apps.y.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.c(iVar);
                }
            });
            this.bZP.gj(apN.aqf());
            if (!apN.aqf()) {
                this.bZP.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.y.a.2
                    @Override // com.baidu.swan.menu.viewpager.b
                    public boolean d(i iVar) {
                        return a.this.b(iVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cts == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, akN() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gT(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (this.cts == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                akO();
                return true;
            case 5:
                akQ();
                return true;
            case 35:
                akR();
                return true;
            case 36:
                akT();
                return true;
            case 37:
                akU();
                return true;
            case 38:
                akP();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                akV();
                return true;
            case 42:
                akS();
                return true;
            default:
                return com.baidu.swan.apps.u.a.agb().a(iVar);
        }
    }

    private boolean akN() {
        ak.cE(this.mContext).setText(com.baidu.swan.apps.model.b.d(aj.ava()));
        return true;
    }

    private void akO() {
        this.cts.Zy();
        md(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void akP() {
        String appId = com.baidu.swan.apps.runtime.d.apI().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.ke(appId)) {
                mb(appId);
            } else {
                mc(appId);
            }
        }
    }

    private void mb(String str) {
        SwanFavorDataManager.aec().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.y.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void ael() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gT(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aem() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gT(2).showToast();
            }
        });
        md("deletemyswan");
    }

    private void mc(String str) {
        if (com.baidu.swan.apps.af.a.a.anx()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bON = null;
        final String page = aj.ava().getPage();
        SwanFavorDataManager.aec().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.y.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aej() {
                com.baidu.swan.apps.database.favorite.a.adi();
                if (a.K(a.this.cts.aIB())) {
                    a.by("addmyswan", page);
                } else {
                    d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gT(2).gP(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aek() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gT(2).showToast();
            }
        });
        by("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0409a interfaceC0409a) {
        String appId = com.baidu.swan.apps.runtime.d.apI().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0409a != null) {
            interfaceC0409a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.ke(appId)) {
            SwanFavorDataManager.aec().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.y.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aej() {
                    com.baidu.swan.apps.database.favorite.a.adi();
                    if (a.K(activity)) {
                        if (interfaceC0409a != null) {
                            interfaceC0409a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).gT(2).gP(2).showToast();
                    if (interfaceC0409a != null) {
                        interfaceC0409a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aek() {
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).gT(2).showToast();
                    if (interfaceC0409a != null) {
                        interfaceC0409a.onFail();
                    }
                }
            });
        } else if (interfaceC0409a != null) {
            interfaceC0409a.onSuccess();
        }
    }

    public static boolean K(Activity activity) {
        if (aj.auY()) {
            if (com.baidu.swan.apps.database.favorite.a.adj() > 3 || com.baidu.swan.apps.storage.c.h.asV().getBoolean("favorite_guide_checkbox_value", false)) {
                return false;
            }
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
            com.baidu.swan.apps.aq.d.b(activity, cVar);
            cVar.setContentView(a.g.aiapps_entry_guide_layout);
            cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
            final CheckBox checkBox = (CheckBox) cVar.findViewById(a.f.aiapps_entry_guide_reminder_tip);
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.apps.y.a.6
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bON, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState()) {
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
            textView.setOnTouchListener(new af());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.y.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (checkBox.isChecked()) {
                        com.baidu.swan.apps.storage.c.h.asV().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bON, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bON, "", "show");
            e apN = e.apN();
            if (apN != null) {
                apN.aqe().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void akQ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
        com.baidu.swan.apps.u.a.ags().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cts.aIB() != null && (this.cts.aIB() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cts.aIB()).j(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gU(a.e.aiapps_day_mode_toast_icon).gT(2).showHighlightToast();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gU(a.e.aiapps_night_mode_toast_icon).gT(2).showHighlightToast();
        }
        md("daynightmode");
    }

    private void akR() {
        b.a RP;
        if (com.baidu.swan.apps.af.a.a.anx()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.apN() != null) {
            RP = e.apN().apQ();
        } else {
            RP = ((SwanAppActivity) this.cts.aIB()).RP();
        }
        com.baidu.swan.apps.aj.a.a(this.cts.getContext(), RP);
        md("addshortcut");
    }

    private void akS() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.m((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        md(Headers.REFRESH);
        com.baidu.swan.games.utils.a.m(com.baidu.swan.apps.w.f.ajb().aiL());
    }

    private void akT() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        RN.jx("navigateTo").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).a("about", null).commit();
        md("about");
    }

    private void akU() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e RN = this.cts.RN();
        if (RN == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        RN.jx("navigateTo").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).a("setting", null).commit();
        md("permission");
    }

    private void akV() {
        if (TextUtils.isEmpty(this.ctt)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.ctt = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.ctt);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.u.a.afX(), this.ctt);
        md("miniapp_center");
    }

    public static void md(String str) {
        by(str, null);
    }

    public static void by(String str, String str2) {
        G(str, str2, null);
    }

    public static void G(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.v("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
            if (aiL != null) {
                aiL.a(fVar);
            }
        }
    }
}
