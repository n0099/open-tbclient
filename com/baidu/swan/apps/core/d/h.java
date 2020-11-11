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
    private RelativeLayout cLh;
    private RelativeLayout cLi;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        ar(inflate);
        al(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void al(View view) {
        this.cLh = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cLh.setOnClickListener(this);
        this.cLi = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cLi.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        at(view);
        hW(-1);
        hX(ViewCompat.MEASURED_STATE_MASK);
        mU(getString(a.h.swan_app_menu_setting));
        eM(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.axD().ahL();
        } else if (view.getId() == a.f.authority_item) {
            apo();
        }
    }

    private void apo() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f afM = afM();
        if (afM == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afM.nb("navigateTo").al(f.cKS, f.cKU).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.qn("permission");
    }

    public static h app() {
        return new h();
    }
}
