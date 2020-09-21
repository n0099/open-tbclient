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
/* loaded from: classes3.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout ckA;
    private RelativeLayout ckB;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        ak(inflate);
        am(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void am(View view) {
        this.ckA = (RelativeLayout) view.findViewById(a.f.message_item);
        this.ckA.setOnClickListener(this);
        this.ckB = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.ckB.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
        an(view);
        he(-1);
        hf(ViewCompat.MEASURED_STATE_MASK);
        lA(getString(a.h.swan_app_menu_setting));
        dU(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.aqx().aaF();
        } else if (view.getId() == a.f.authority_item) {
            aii();
        }
    }

    private void aii() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f YG = YG();
        if (YG == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        YG.lH("navigateTo").al(f.ckl, f.ckn).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.oU("permission");
    }

    public static h aij() {
        return new h();
    }
}
