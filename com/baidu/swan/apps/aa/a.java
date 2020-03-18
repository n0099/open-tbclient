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
    private com.baidu.swan.apps.core.d.b bFl;
    private String bFm;
    private h bnL;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0198a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bnL = hVar;
        this.bFl = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        Ym();
    }

    private void Ym() {
        com.baidu.swan.apps.w.a.UJ().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void Yn() {
        e acJ;
        if (this.bnL != null && this.bFl != null && this.mContext != null && (acJ = e.acJ()) != null) {
            this.bnL.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bnL.eW(acJ.acZ());
            if (!acJ.acZ()) {
                this.bnL.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
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
        if (this.bFl == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, Yo() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gh(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.bFl == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                Yp();
                return true;
            case 5:
                Yr();
                return true;
            case 35:
                Ys();
                return true;
            case 36:
                Yu();
                return true;
            case 37:
                Yv();
                return true;
            case 38:
                Yq();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                Yw();
                return true;
            case 42:
                Yt();
                return true;
            default:
                return com.baidu.swan.apps.w.a.Ud().d(iVar);
        }
    }

    private boolean Yo() {
        aj.cP(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.ahn()));
        return true;
    }

    private void Yp() {
        this.bFl.NU();
        ju(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void Yq() {
        String appId = com.baidu.swan.apps.runtime.d.acF().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.hB(appId)) {
                js(appId);
            } else {
                jt(appId);
            }
        }
    }

    private void js(String str) {
        SwanFavorDataManager.Si().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void Sr() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gh(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void Ss() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gh(2).showToast();
            }
        });
        ju("deletemyswan");
    }

    private void jt(String str) {
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bdp = null;
        final String page = ai.ahn().getPage();
        SwanFavorDataManager.Si().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void Sp() {
                com.baidu.swan.apps.database.favorite.a.Rn();
                if (a.Q(a.this.bFl.auD())) {
                    a.aV("addmyswan", page);
                } else {
                    d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gh(2).gd(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void Sq() {
                d.q(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gh(2).showToast();
            }
        });
        aV("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0198a interfaceC0198a) {
        String appId = com.baidu.swan.apps.runtime.d.acF().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0198a != null) {
            interfaceC0198a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.hB(appId)) {
            SwanFavorDataManager.Si().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void Sp() {
                    com.baidu.swan.apps.database.favorite.a.Rn();
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
                public void Sq() {
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
        if (ai.ahl()) {
            if (com.baidu.swan.apps.database.favorite.a.Ro() > 3 || com.baidu.swan.apps.storage.c.h.afu().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdp, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.afu().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdp, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bdp, "", "show");
            e acJ = e.acJ();
            if (acJ != null) {
                acJ.acY().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void Yr() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.Uv().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.bFl.auD() != null && (this.bFl.auD() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bFl.auD()).j(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gi(a.e.aiapps_day_mode_toast_icon).gh(2).showHighlightToast();
        } else {
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gi(a.e.aiapps_night_mode_toast_icon).gh(2).showHighlightToast();
        }
        ju("daynightmode");
    }

    private void Ys() {
        b.a GJ;
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.q(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.acJ() != null) {
            GJ = e.acJ().acL();
        } else {
            GJ = ((SwanAppActivity) this.bFl.auD()).GJ();
        }
        com.baidu.swan.apps.al.a.a(this.bFl.getContext(), GJ);
        ju("addshortcut");
    }

    private void Yt() {
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
        if (this.bFl instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bFl;
            com.baidu.swan.apps.adaptation.b.c Og = dVar.Og();
            if (Og == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.WV().WF());
            hashMap.put("pagePath", dVar.Of().getPage());
            hashMap.put("slaveId", Og.IU());
            com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            ju(Headers.REFRESH);
        }
    }

    private void Yu() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        GH.ha("navigateTo").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).a("about", null).commit();
        ju("about");
    }

    private void Yv() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e GH = this.bFl.GH();
        if (GH == null) {
            d.q(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        GH.ha("navigateTo").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).a("setting", null).commit();
        ju("permission");
    }

    private void Yw() {
        if (TextUtils.isEmpty(this.bFm)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.bFm = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.bFm);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.TZ(), this.bFm);
        ju("miniapp_center");
    }

    public static void ju(String str) {
        aV(str, null);
    }

    public static void aV(String str, String str2) {
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
            SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
            if (WG != null) {
                WG.a(fVar);
            }
        }
    }
}
