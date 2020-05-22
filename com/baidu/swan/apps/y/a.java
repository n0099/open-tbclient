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
    private h bVb;
    private com.baidu.swan.apps.core.d.b coF;
    private String coG;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0403a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bVb = hVar;
        this.coF = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        ajF();
    }

    private void ajF() {
        com.baidu.swan.apps.u.a.afA().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void ajG() {
        e aoG;
        if (this.bVb != null && this.coF != null && this.mContext != null && (aoG = e.aoG()) != null) {
            this.bVb.a(new f() { // from class: com.baidu.swan.apps.y.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.c(iVar);
                }
            });
            this.bVb.ge(aoG.aoY());
            if (!aoG.aoY()) {
                this.bVb.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.y.a.2
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
        if (this.coF == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, ajH() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gG(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (this.coF == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                ajI();
                return true;
            case 5:
                ajK();
                return true;
            case 35:
                ajL();
                return true;
            case 36:
                ajN();
                return true;
            case 37:
                ajO();
                return true;
            case 38:
                ajJ();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                ajP();
                return true;
            case 42:
                ajM();
                return true;
            default:
                return com.baidu.swan.apps.u.a.aeV().a(iVar);
        }
    }

    private boolean ajH() {
        ak.cD(this.mContext).setText(com.baidu.swan.apps.model.b.d(aj.atU()));
        return true;
    }

    private void ajI() {
        this.coF.Ys();
        lV(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void ajJ() {
        String appId = com.baidu.swan.apps.runtime.d.aoB().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.jW(appId)) {
                lT(appId);
            } else {
                lU(appId);
            }
        }
    }

    private void lT(String str) {
        SwanFavorDataManager.acW().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.y.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void adf() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gG(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void adg() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gG(2).showToast();
            }
        });
        lV("deletemyswan");
    }

    private void lU(String str) {
        if (com.baidu.swan.apps.af.a.a.amr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bJZ = null;
        final String page = aj.atU().getPage();
        SwanFavorDataManager.acW().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.y.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void add() {
                com.baidu.swan.apps.database.favorite.a.acc();
                if (a.K(a.this.coF.aHv())) {
                    a.bw("addmyswan", page);
                } else {
                    d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gG(2).gC(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void ade() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gG(2).showToast();
            }
        });
        bw("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0403a interfaceC0403a) {
        String appId = com.baidu.swan.apps.runtime.d.aoB().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0403a != null) {
            interfaceC0403a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.jW(appId)) {
            SwanFavorDataManager.acW().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.y.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void add() {
                    com.baidu.swan.apps.database.favorite.a.acc();
                    if (a.K(activity)) {
                        if (interfaceC0403a != null) {
                            interfaceC0403a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).gG(2).gC(2).showToast();
                    if (interfaceC0403a != null) {
                        interfaceC0403a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void ade() {
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).gG(2).showToast();
                    if (interfaceC0403a != null) {
                        interfaceC0403a.onFail();
                    }
                }
            });
        } else if (interfaceC0403a != null) {
            interfaceC0403a.onSuccess();
        }
    }

    public static boolean K(Activity activity) {
        if (aj.atS()) {
            if (com.baidu.swan.apps.database.favorite.a.acd() > 3 || com.baidu.swan.apps.storage.c.h.arO().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bJZ, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.arO().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bJZ, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bJZ, "", "show");
            e aoG = e.aoG();
            if (aoG != null) {
                aoG.aoX().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void ajK() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
        com.baidu.swan.apps.u.a.afm().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.coF.aHv() != null && (this.coF.aHv() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.coF.aHv()).j(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gH(a.e.aiapps_day_mode_toast_icon).gG(2).showHighlightToast();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gH(a.e.aiapps_night_mode_toast_icon).gG(2).showHighlightToast();
        }
        lV("daynightmode");
    }

    private void ajL() {
        b.a QJ;
        if (com.baidu.swan.apps.af.a.a.amr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aoG() != null) {
            QJ = e.aoG().aoJ();
        } else {
            QJ = ((SwanAppActivity) this.coF.aHv()).QJ();
        }
        com.baidu.swan.apps.aj.a.a(this.coF.getContext(), QJ);
        lV("addshortcut");
    }

    private void ajM() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.m((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        lV(Headers.REFRESH);
        com.baidu.swan.games.utils.a.m(com.baidu.swan.apps.w.f.ahV().ahF());
    }

    private void ajN() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        QH.jp("navigateTo").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).a("about", null).commit();
        lV("about");
    }

    private void ajO() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e QH = this.coF.QH();
        if (QH == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        QH.jp("navigateTo").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).a("setting", null).commit();
        lV("permission");
    }

    private void ajP() {
        if (TextUtils.isEmpty(this.coG)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.coG = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.coG);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.u.a.aeR(), this.coG);
        lV("miniapp_center");
    }

    public static void lV(String str) {
        bw(str, null);
    }

    public static void bw(String str, String str2) {
        F(str, str2, null);
    }

    public static void F(String str, String str2, String str3) {
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
            SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
            if (ahF != null) {
                ahF.a(fVar);
            }
        }
    }
}
