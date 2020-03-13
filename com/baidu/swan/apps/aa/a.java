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
    private com.baidu.swan.apps.core.d.b bFa;
    private String bFb;
    private h bny;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0198a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bny = hVar;
        this.bFa = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        Yj();
    }

    private void Yj() {
        com.baidu.swan.apps.w.a.UG().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void Yk() {
        e acG;
        if (this.bny != null && this.bFa != null && this.mContext != null && (acG = e.acG()) != null) {
            this.bny.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bny.eV(acG.acW());
            if (!acG.acW()) {
                this.bny.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
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
        if (this.bFa == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, Yl() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gh(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.bFa == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                Ym();
                return true;
            case 5:
                Yo();
                return true;
            case 35:
                Yp();
                return true;
            case 36:
                Yr();
                return true;
            case 37:
                Ys();
                return true;
            case 38:
                Yn();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                Yt();
                return true;
            case 42:
                Yq();
                return true;
            default:
                return com.baidu.swan.apps.w.a.Ua().d(iVar);
        }
    }

    private boolean Yl() {
        aj.cQ(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.ahk()));
        return true;
    }

    private void Ym() {
        this.bFa.NR();
        jv(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void Yn() {
        String appId = com.baidu.swan.apps.runtime.d.acC().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.hC(appId)) {
                jt(appId);
            } else {
                ju(appId);
            }
        }
    }

    private void jt(String str) {
        SwanFavorDataManager.Sf().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void So() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gh(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void Sp() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gh(2).showToast();
            }
        });
        jv("deletemyswan");
    }

    private void ju(String str) {
        if (com.baidu.swan.apps.ah.a.a.aaD()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bdc = null;
        final String page = ai.ahk().getPage();
        SwanFavorDataManager.Sf().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void Sm() {
                com.baidu.swan.apps.database.favorite.a.Rk();
                if (a.Q(a.this.bFa.auA())) {
                    a.aW("addmyswan", page);
                } else {
                    d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gh(2).gd(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void Sn() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gh(2).showToast();
            }
        });
        aW("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0198a interfaceC0198a) {
        String appId = com.baidu.swan.apps.runtime.d.acC().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0198a != null) {
            interfaceC0198a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.hC(appId)) {
            SwanFavorDataManager.Sf().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void Sm() {
                    com.baidu.swan.apps.database.favorite.a.Rk();
                    if (a.Q(activity)) {
                        if (interfaceC0198a != null) {
                            interfaceC0198a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_success).gh(2).gd(2).showToast();
                    if (interfaceC0198a != null) {
                        interfaceC0198a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void Sn() {
                    d.q(activity.getApplicationContext(), a.h.aiapps_fav_fail).gh(2).showToast();
                    if (interfaceC0198a != null) {
                        interfaceC0198a.onFail();
                    }
                }
            });
        } else if (interfaceC0198a != null) {
            interfaceC0198a.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Q(Activity activity) {
        if (ai.ahi()) {
            if (com.baidu.swan.apps.database.favorite.a.Rl() > 3 || com.baidu.swan.apps.storage.c.h.afr().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdc, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.afr().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdc, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdc, "", "show");
            e acG = e.acG();
            if (acG != null) {
                acG.acV().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void Yo() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.Us().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.bFa.auA() != null && (this.bFa.auA() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bFa.auA()).j(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gi(a.e.aiapps_day_mode_toast_icon).gh(2).showHighlightToast();
        } else {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gi(a.e.aiapps_night_mode_toast_icon).gh(2).showHighlightToast();
        }
        jv("daynightmode");
    }

    private void Yp() {
        b.a GE;
        if (com.baidu.swan.apps.ah.a.a.aaD()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.acG() != null) {
            GE = e.acG().acI();
        } else {
            GE = ((SwanAppActivity) this.bFa.auA()).GE();
        }
        com.baidu.swan.apps.al.a.a(this.bFa.getContext(), GE);
        jv("addshortcut");
    }

    private void Yq() {
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
        if (this.bFa instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bFa;
            com.baidu.swan.apps.adaptation.b.c Od = dVar.Od();
            if (Od == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.WS().WC());
            hashMap.put("pagePath", dVar.Oc().getPage());
            hashMap.put("slaveId", Od.IR());
            com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            jv(Headers.REFRESH);
        }
    }

    private void Yr() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        GC.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).a("about", null).commit();
        jv("about");
    }

    private void Ys() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e GC = this.bFa.GC();
        if (GC == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        GC.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).a("setting", null).commit();
        jv("permission");
    }

    private void Yt() {
        if (TextUtils.isEmpty(this.bFb)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.bFb = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.bFb);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.TW(), this.bFb);
        jv("miniapp_center");
    }

    public static void jv(String str) {
        aW(str, null);
    }

    public static void aW(String str, String str2) {
        C(str, str2, null);
    }

    public static void C(String str, String str2, String str3) {
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
            SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
            if (WD != null) {
                WD.a(fVar);
            }
        }
    }
}
