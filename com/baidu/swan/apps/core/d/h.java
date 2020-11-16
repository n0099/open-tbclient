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
    private RelativeLayout cJx;
    private RelativeLayout cJy;

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
        this.cJx = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cJx.setOnClickListener(this);
        this.cJy = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cJy.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        at(view);
        hS(-1);
        hT(ViewCompat.MEASURED_STATE_MASK);
        mO(getString(a.h.swan_app_menu_setting));
        eP(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.awV().ahd();
        } else if (view.getId() == a.f.authority_item) {
            aoF();
        }
    }

    private void aoF() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f afe = afe();
        if (afe == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afe.mV("navigateTo").al(f.cJi, f.cJk).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.qh("permission");
    }

    public static h aoG() {
        return new h();
    }
}
