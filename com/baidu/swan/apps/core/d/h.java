package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout ccy;
    private RelativeLayout ccz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        ah(inflate);
        aj(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void aj(View view) {
        this.ccy = (RelativeLayout) view.findViewById(a.f.message_item);
        this.ccy.setOnClickListener(this);
        this.ccz = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.ccz.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        ak(view);
        eZ(-1);
        fa(ViewCompat.MEASURED_STATE_MASK);
        jH(getString(a.h.swan_app_menu_setting));
        dL(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.aik().TT();
        } else if (view.getId() == a.f.authority_item) {
            abm();
        }
    }

    private void abm() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f Sc = Sc();
        if (Sc == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        Sc.jO("navigateTo").ag(f.cci, f.cck).a("authority", null).commit();
        com.baidu.swan.apps.x.a.mB("permission");
    }

    public static h abn() {
        return new h();
    }
}
