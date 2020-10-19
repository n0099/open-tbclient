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
/* loaded from: classes10.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout cwS;
    private RelativeLayout cwT;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        al(inflate);
        an(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void an(View view) {
        this.cwS = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cwS.setOnClickListener(this);
        this.cwT = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cwT.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
        ao(view);
        hB(-1);
        hC(ViewCompat.MEASURED_STATE_MASK);
        mm(getString(a.h.swan_app_menu_setting));
        eq(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.atj().adr();
        } else if (view.getId() == a.f.authority_item) {
            akT();
        }
    }

    private void akT() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f abs = abs();
        if (abs == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        abs.mt("navigateTo").ak(f.cwD, f.cwF).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.pG("permission");
    }

    public static h akU() {
        return new h();
    }
}
