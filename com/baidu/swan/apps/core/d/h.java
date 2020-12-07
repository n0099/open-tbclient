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
/* loaded from: classes25.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout cQq;
    private RelativeLayout cQr;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        at(inflate);
        an(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void an(View view) {
        this.cQq = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cQq.setOnClickListener(this);
        this.cQr = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cQr.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
        av(view);
        iq(-1);
        ir(ViewCompat.MEASURED_STATE_MASK);
        nv(getString(a.h.swan_app_menu_setting));
        fe(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.aAd().akl();
        } else if (view.getId() == a.f.authority_item) {
            arN();
        }
    }

    private void arN() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f aim = aim();
        if (aim == null) {
            com.baidu.swan.apps.res.widget.b.d.t(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        aim.nC("navigateTo").an(f.cQb, f.cQd).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.qO("permission");
    }

    public static h arO() {
        return new h();
    }
}
