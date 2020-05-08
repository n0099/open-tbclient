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
    private h bLX;
    private com.baidu.swan.apps.core.d.b cea;
    private String ceb;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aa.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0249a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, com.baidu.swan.apps.core.d.b bVar) {
        this.bLX = hVar;
        this.cea = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
        agr();
    }

    private void agr() {
        com.baidu.swan.apps.w.a.acx().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void ags() {
        e akN;
        if (this.bLX != null && this.cea != null && this.mContext != null && (akN = e.akN()) != null) {
            this.bLX.a(new f() { // from class: com.baidu.swan.apps.aa.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            this.bLX.fT(akN.ald());
            if (!akN.ald()) {
                this.bLX.a(new com.baidu.swan.menu.viewpager.b() { // from class: com.baidu.swan.apps.aa.a.2
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
        if (this.cea == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 36:
                d.a(this.mContext, agt() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).gp(2).showToast();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cea == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                agu();
                return true;
            case 5:
                agw();
                return true;
            case 35:
                agx();
                return true;
            case 36:
                agz();
                return true;
            case 37:
                agA();
                return true;
            case 38:
                agv();
                return true;
            case 39:
                restart();
                return true;
            case 40:
                agB();
                return true;
            case 42:
                agy();
                return true;
            default:
                return com.baidu.swan.apps.w.a.abR().d(iVar);
        }
    }

    private boolean agt() {
        aj.cr(this.mContext).setText(com.baidu.swan.apps.model.b.d(ai.apu()));
        return true;
    }

    private void agu() {
        this.cea.VH();
        kH(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void agv() {
        String appId = com.baidu.swan.apps.runtime.d.akJ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.iP(appId)) {
                kF(appId);
            } else {
                kG(appId);
            }
        }
    }

    private void kF(String str) {
        SwanFavorDataManager.ZW().a(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.aa.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aaf() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).gp(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aag() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).gp(2).showToast();
            }
        });
        kH("deletemyswan");
    }

    private void kG(String str) {
        if (com.baidu.swan.apps.ah.a.a.aiK()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bBI = null;
        final String page = ai.apu().getPage();
        SwanFavorDataManager.ZW().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aad() {
                com.baidu.swan.apps.database.favorite.a.Zb();
                if (a.M(a.this.cea.aCO())) {
                    a.bf("addmyswan", page);
                } else {
                    d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).gp(2).gk(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aae() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).gp(2).showToast();
            }
        });
        bf("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0249a interfaceC0249a) {
        String appId = com.baidu.swan.apps.runtime.d.akJ().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0249a != null) {
            interfaceC0249a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.iP(appId)) {
            SwanFavorDataManager.ZW().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.aa.a.5
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aad() {
                    com.baidu.swan.apps.database.favorite.a.Zb();
                    if (a.M(activity)) {
                        if (interfaceC0249a != null) {
                            interfaceC0249a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).gp(2).gk(2).showToast();
                    if (interfaceC0249a != null) {
                        interfaceC0249a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aae() {
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).gp(2).showToast();
                    if (interfaceC0249a != null) {
                        interfaceC0249a.onFail();
                    }
                }
            });
        } else if (interfaceC0249a != null) {
            interfaceC0249a.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean M(Activity activity) {
        if (ai.aps()) {
            if (com.baidu.swan.apps.database.favorite.a.Zc() > 3 || com.baidu.swan.apps.storage.c.h.any().getBoolean("favorite_guide_checkbox_value", false)) {
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
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBI, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
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
                        com.baidu.swan.apps.storage.c.h.any().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBI, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bBI, "", "show");
            e akN = e.akN();
            if (akN != null) {
                akN.alc().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void agw() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
        com.baidu.swan.apps.w.a.acj().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cea.aCO() != null && (this.cea.aCO() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cea.aCO()).i(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).gq(a.e.aiapps_day_mode_toast_icon).gp(2).showHighlightToast();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).gq(a.e.aiapps_night_mode_toast_icon).gp(2).showHighlightToast();
        }
        kH("daynightmode");
    }

    private void agx() {
        b.a Ov;
        if (com.baidu.swan.apps.ah.a.a.aiK()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.akN() != null) {
            Ov = e.akN().akP();
        } else {
            Ov = ((SwanAppActivity) this.cea.aCO()).Ov();
        }
        com.baidu.swan.apps.al.a.a(this.cea.getContext(), Ov);
        kH("addshortcut");
    }

    private void agy() {
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
        if (this.cea instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.cea;
            com.baidu.swan.apps.adaptation.b.c VT = dVar.VT();
            if (VT == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.y.f.aeJ().aet());
            hashMap.put("pagePath", dVar.VS().getPage());
            hashMap.put("slaveId", VT.QF());
            com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.b("onForceReLaunch", hashMap));
            kH(Headers.REFRESH);
        }
    }

    private void agz() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Ot.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).a("about", null).commit();
        kH("about");
    }

    private void agA() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e Ot = this.cea.Ot();
        if (Ot == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Ot.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).a("setting", null).commit();
        kH("permission");
    }

    private void agB() {
        if (TextUtils.isEmpty(this.ceb)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SchemeConfig.getSchemeHead()).append("://").append("swanAPI").append("/").append("launch?params=");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
                sb.append(URLEncoder.encode(jSONObject.toString()));
                sb.append("&from=").append("1201000900000000");
                this.ceb = sb.toString();
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", this.ceb);
        }
        SchemeRouter.invoke(com.baidu.swan.apps.w.a.abN(), this.ceb);
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
            SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
            if (aeu != null) {
                aeu.a(fVar);
            }
        }
    }
}
