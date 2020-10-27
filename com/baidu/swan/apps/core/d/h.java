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
    private RelativeLayout cFo;
    private RelativeLayout cFp;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        an(inflate);
        ah(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void ah(View view) {
        this.cFo = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cFo.setOnClickListener(this);
        this.cFp = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cFp.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
        ap(view);
        hM(-1);
        hN(ViewCompat.MEASURED_STATE_MASK);
        mF(getString(a.h.swan_app_menu_setting));
        eD(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.avd().afl();
        } else if (view.getId() == a.f.authority_item) {
            amN();
        }
    }

    private void amN() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f adm = adm();
        if (adm == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        adm.mM("navigateTo").al(f.cEZ, f.cFb).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.pZ("permission");
    }

    public static h amO() {
        return new h();
    }
}
