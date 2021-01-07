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
    private RelativeLayout cVn;
    private RelativeLayout cVo;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        av(inflate);
        ap(inflate);
        if (asf()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    private void ap(View view) {
        this.cVn = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cVn.setOnClickListener(this);
        this.cVo = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cVo.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        ay(view);
        ik(-1);
        il(ViewCompat.MEASURED_STATE_MASK);
        no(getString(a.h.swan_app_menu_setting));
        fn(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arC() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amN() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean arD() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean amm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amT() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.aBv().alu();
        } else if (view.getId() == a.f.authority_item) {
            atg();
        }
    }

    private void atg() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f ajt = ajt();
        if (ajt == null) {
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_open_fragment_failed_toast).aLT();
            return;
        }
        ajt.nv("navigateTo").ai(f.cUY, f.cVa).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.qI("permission");
    }

    public static h ath() {
        return new h();
    }
}
