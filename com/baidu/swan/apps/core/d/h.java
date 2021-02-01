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
/* loaded from: classes9.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout cSO;
    private RelativeLayout cSP;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        aq(inflate);
        am(inflate);
        if (aoI()) {
            inflate = av(inflate);
        }
        return a(inflate, this);
    }

    private void am(View view) {
        this.cSO = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cSO.setOnClickListener(this);
        this.cSP = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cSP.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        au(view);
        gH(-1);
        gI(ViewCompat.MEASURED_STATE_MASK);
        mv(getString(a.h.swan_app_menu_setting));
        fl(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aog() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajx() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.axZ().ahY();
        } else if (view.getId() == a.f.authority_item) {
            apJ();
        }
    }

    private void apJ() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f afX = afX();
        if (afX == null) {
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_open_fragment_failed_toast).aIs();
            return;
        }
        afX.mC("navigateTo").af(f.cSz, f.cSB).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.pP("permission");
    }

    public static h apK() {
        return new h();
    }
}
