package com.baidu.swan.apps.x;

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
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.am;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.h;
import com.baidu.swan.menu.i;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h cbu;
    private SwanAppMenuHeaderView cbv;
    private c cvw;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0414a {
        void onFail();

        void onSuccess();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cbu = hVar;
        this.cbv = swanAppMenuHeaderView;
        this.cvw = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        amb();
    }

    private void amb() {
        com.baidu.swan.apps.t.a.ahT().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void amc() {
        e arw;
        if (this.cbu != null && this.cvw != null && this.mContext != null && (arw = e.arw()) != null) {
            this.cbu.a(new f() { // from class: com.baidu.swan.apps.x.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cbv != null) {
                this.cbv.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.x.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cbu.dismiss();
                        a.this.aml();
                    }
                });
                if (!arw.arO()) {
                    this.cbv.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.x.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cbu.dismiss();
                            return a.this.amd();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amd() {
        if (this.cvw == null || this.mContext == null) {
            return false;
        }
        d.a(this.mContext, amf() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).hc(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cvw == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                amg();
                return true;
            case 5:
                ami();
                return true;
            case 35:
                amj();
                return true;
            case 37:
                amm();
                return true;
            case 38:
                amh();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                amk();
                return true;
            case 49:
                ame();
                return true;
            default:
                return com.baidu.swan.apps.t.a.ahn().a(iVar);
        }
    }

    private void ame() {
        com.baidu.swan.apps.core.d.f Sc = this.cvw.Sc();
        if (Sc == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Sc.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("settings", null).commit();
        mB("set");
    }

    private boolean amf() {
        am.cJ(this.mContext).setText(com.baidu.swan.apps.model.b.d(al.axg()));
        return true;
    }

    private void amg() {
        this.cvw.ZU();
        mB(TbConfig.TMP_SHARE_DIR_NAME);
    }

    private void amh() {
        String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.ky(appId)) {
                jE(appId);
            } else {
                jF(appId);
            }
        }
    }

    private void jE(String str) {
        SwanFavorDataManager.aft().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.x.a.4
            @Override // com.baidu.swan.apps.favordata.a.b
            public void ZY() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).hc(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void ZZ() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).hc(2).showToast();
            }
        }, com.baidu.swan.apps.env.b.c.aeQ().fy(3).aeR());
        mB("deletemyswan");
    }

    private void jF(String str) {
        if (com.baidu.swan.apps.ae.a.a.apg()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bPE = null;
        final String page = al.axg().getPage();
        SwanFavorDataManager.aft().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.x.a.5
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aaa() {
                com.baidu.swan.apps.database.favorite.a.aen();
                if (a.J(a.this.cvw.aMt())) {
                    a.bA("addmyswan", page);
                } else {
                    d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).hc(2).gY(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aab() {
                d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).hc(2).showToast();
            }
        });
        bA("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0414a interfaceC0414a) {
        String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0414a != null) {
            interfaceC0414a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.ky(appId)) {
            SwanFavorDataManager.aft().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.x.a.6
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aaa() {
                    com.baidu.swan.apps.database.favorite.a.aen();
                    if (a.J(activity)) {
                        if (interfaceC0414a != null) {
                            interfaceC0414a.onSuccess();
                            return;
                        }
                        return;
                    }
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).hc(2).gY(2).showToast();
                    if (interfaceC0414a != null) {
                        interfaceC0414a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aab() {
                    d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).hc(2).showToast();
                    if (interfaceC0414a != null) {
                        interfaceC0414a.onFail();
                    }
                }
            });
        } else if (interfaceC0414a != null) {
            interfaceC0414a.onSuccess();
        }
    }

    public static boolean J(Activity activity) {
        if (al.axe()) {
            if (com.baidu.swan.apps.database.favorite.a.aeo() > 3 || com.baidu.swan.apps.storage.c.h.auW().getBoolean("favorite_guide_checkbox_value", false)) {
                return false;
            }
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            final com.baidu.swan.apps.res.widget.dialog.c cVar = new com.baidu.swan.apps.res.widget.dialog.c(activity, a.i.SwanFavoriteGuideDialog);
            com.baidu.swan.apps.aq.e.b(activity, cVar);
            cVar.setContentView(a.g.aiapps_entry_guide_layout);
            cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
            final CheckBox checkBox = (CheckBox) cVar.findViewById(a.f.aiapps_entry_guide_reminder_tip);
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.apps.x.a.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bPE, "window_never", "click");
                }
            });
            if (com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState()) {
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
            textView.setOnTouchListener(new ah());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.x.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (checkBox.isChecked()) {
                        com.baidu.swan.apps.storage.c.h.auW().putBoolean("favorite_guide_checkbox_value", true);
                    }
                    cVar.dismiss();
                    ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bPE, "window_know", "click");
                }
            });
            cVar.show();
            ShowFavoriteGuideApi.a(com.baidu.swan.apps.api.module.favorite.a.bPE, "", "show");
            e arw = e.arw();
            if (arw != null) {
                arw.arN().a("boolean_var_key_fav_guide_show", (Boolean) true);
            }
            return true;
        }
        return false;
    }

    private void ami() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.ahF().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cvw.aMt() != null && (this.cvw.aMt() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cvw.aMt()).j(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).hd(a.e.aiapps_day_mode_toast_icon).hc(2).showHighlightToast();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).hd(a.e.aiapps_night_mode_toast_icon).hc(2).showHighlightToast();
        }
        mB("daynightmode");
    }

    private void amj() {
        b.a Se;
        if (com.baidu.swan.apps.ae.a.a.apg()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.arw() != null) {
            Se = e.arw().arz();
        } else {
            Se = ((SwanAppActivity) this.cvw.aMt()).Se();
        }
        com.baidu.swan.apps.aj.a.a(this.cvw.getContext(), Se);
        mB("addshortcut");
    }

    private void amk() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        mB(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.akr().akb());
        com.baidu.swan.apps.console.c.aW("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aml() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Sc.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("about", null).commit();
        mB("about");
    }

    private void amm() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f Sc = this.cvw.Sc();
        if (Sc == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Sc.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("authority", null).commit();
        mB("permission");
    }

    public static void mB(String str) {
        bA(str, null);
    }

    public static void bA(String str, String str2) {
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
            SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
            if (akb != null) {
                akb.a(fVar);
            }
        }
    }
}
