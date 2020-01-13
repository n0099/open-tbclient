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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.d.b bAS;
    private String bAT;
    private h bjm;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0188a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bjm = hVar;
        this.bAS = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        VT();
    }

    private void VT() {
        com.baidu.swan.apps.w.a.Sq().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void VU() {
        e aaq;
        if (this.bjm != null && this.bAS != null && this.mContext != null && (aaq = e.aaq()) != null) {
            this.bjm.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bjm.eO(aaq.aaG());
            if (!aaq.aaG()) {
                this.bjm.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
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
        if (this.bAS == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, VV() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).fR(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.bAS == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                VW();
                return true;
            case 5:
                VY();
                return true;
            case 35:
                VZ();
                return true;
            case 36:
                Wb();
                return true;
            case 37:
                Wc();
                return true;
            case 38:
                VX();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                Wd();
                return true;
            case 42:
                Wa();
                return true;
            default:
                return com.baidu.swan.apps.w.a.RK().d(iVar);
        }
    }

    private boolean VV() {
        aj.cM(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.aeU()));
        return true;
    }

    private void VW() {
        this.bAS.LB();
        jg(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void VX() {
        String appId = com.baidu.swan.apps.runtime.d.aam().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.hn(appId)) {
                je(appId);
            } else {
                jf(appId);
            }
        }
    }

    private void je(String str) {
        SwanFavorDataManager.PP().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void PY() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).fR(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void PZ() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).fR(2).showToast();
            }
        });
        jg("deletemyswan");
    }

    private void jf(String str) {
        if (com.baidu.swan.apps.ah.a.a.Yn()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.aYQ = null;
        final String page = ai.aeU().getPage();
        SwanFavorDataManager.PP().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void PW() {
                com.baidu.swan.apps.database.favorite.a.OU();
                if (a.P(a.this.bAS.ask())) {
                    a.aN("addmyswan", page);
                } else {
                    d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).fR(2).fN(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void PX() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).fR(2).showToast();
            }
        });
        aN("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0188a interfaceC0188a) {
        String appId = com.baidu.swan.apps.runtime.d.aam().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0188a != null) {
            interfaceC0188a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.hn(appId)) {
            SwanFavorDataManager.PP().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void PW() {
                    com.baidu.swan.apps.database.favorite.a.OU();
                    if (a.P(activity)) {
                        if (interfaceC0188a != null) {
                            interfaceC0188a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_success).fR(2).fN(2).showToast();
                    if (interfaceC0188a != null) {
                        interfaceC0188a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void PX() {
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_fail).fR(2).showToast();
                    if (interfaceC0188a != null) {
                        interfaceC0188a.onFail();
                    }
                }
            });
        } else if (interfaceC0188a != null) {
            interfaceC0188a.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(Activity activity) {
        if (ai.aeS()) {
            if (com.baidu.swan.apps.database.favorite.a.OV() > 3 || com.baidu.swan.apps.storage.c.h.adb().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aYQ, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.adb().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aYQ, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.aYQ, "", "show");
            e aaq = e.aaq();
            if (aaq != null) {
                aaq.aaF().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void VY() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.Sc().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.bAS.ask() != null && (this.bAS.ask() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bAS.ask()).g(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).fS(a.e.aiapps_day_mode_toast_icon).fR(2).showHighlightToast();
        } else {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).fS(a.e.aiapps_night_mode_toast_icon).fR(2).showHighlightToast();
        }
        jg("daynightmode");
    }

    private void VZ() {
        b.a En;
        if (com.baidu.swan.apps.ah.a.a.Yn()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aaq() != null) {
            En = e.aaq().aas();
        } else {
            En = ((SwanAppActivity) this.bAS.ask()).En();
        }
        com.baidu.swan.apps.al.a.a(this.bAS.getContext(), En);
        jg("addshortcut");
    }

    private void Wa() {
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
        if (this.bAS instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bAS;
            com.baidu.swan.apps.adaptation.b.c LN = dVar.LN();
            if (LN == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.UC().Um());
            hashMap.put("pagePath", dVar.LM().getPage());
            hashMap.put("slaveId", LN.GA());
            com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            jg(Headers.REFRESH);
        }
    }

    private void Wb() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        El.gM("navigateTo").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).a("about", null).commit();
        jg("about");
    }

    private void Wc() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e El = this.bAS.El();
        if (El == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        El.gM("navigateTo").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).a("setting", null).commit();
        jg("permission");
    }

    private void Wd() {
        if (TextUtils.isEmpty(this.bAT)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.bAT = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.bAT);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.RG(), this.bAT);
        jg("miniapp_center");
    }

    public static void jg(String str) {
        aN(str, null);
    }

    public static void aN(String str, String str2) {
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
            SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
            if (Un != null) {
                Un.a(fVar);
            }
        }
    }
}
