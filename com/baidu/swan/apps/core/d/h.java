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
/* loaded from: classes8.dex */
public class h extends c implements View.OnClickListener {
    private RelativeLayout civ;
    private RelativeLayout ciw;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        ai(inflate);
        ak(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    private void ak(View view) {
        this.civ = (RelativeLayout) view.findViewById(a.f.message_item);
        this.civ.setOnClickListener(this);
        this.ciw = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.ciw.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        al(view);
        gV(-1);
        gW(ViewCompat.MEASURED_STATE_MASK);
        lg(getString(a.h.swan_app_menu_setting));
        dV(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.apN().ZW();
        } else if (view.getId() == a.f.authority_item) {
            ahy();
        }
    }

    private void ahy() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f XX = XX();
        if (XX == null) {
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        XX.ln("navigateTo").al(f.cig, f.cii).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.oA("permission");
    }

    public static h ahz() {
        return new h();
    }
}
