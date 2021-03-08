package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout cUo;
    private RelativeLayout cUp;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        aq(inflate);
        am(inflate);
        if (aoL()) {
            inflate = av(inflate);
        }
        return a(inflate, this);
    }

    private void am(View view) {
        this.cUo = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cUo.setOnClickListener(this);
        this.cUp = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cUp.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        au(view);
        gI(-1);
        gJ(ViewCompat.MEASURED_STATE_MASK);
        mC(getString(a.h.swan_app_menu_setting));
        fl(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.ayc().aib();
        } else if (view.getId() == a.f.authority_item) {
            apM();
        }
    }

    private void apM() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f aga = aga();
        if (aga == null) {
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_open_fragment_failed_toast).aIv();
            return;
        }
        aga.mJ("navigateTo").af(f.cTZ, f.cUb).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.pW("permission");
    }

    public static h apN() {
        return new h();
    }
}
