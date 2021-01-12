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
    private RelativeLayout cQB;
    private RelativeLayout cQC;

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_settings_layout, viewGroup, false);
        av(inflate);
        ap(inflate);
        if (aok()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    private void ap(View view) {
        this.cQB = (RelativeLayout) view.findViewById(a.f.message_item);
        this.cQB.setOnClickListener(this);
        this.cQC = (RelativeLayout) view.findViewById(a.f.authority_item);
        this.cQC.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        ay(view);
        gE(-1);
        gF(ViewCompat.MEASURED_STATE_MASK);
        md(getString(a.h.swan_app_menu_setting));
        fj(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.message_item) {
            com.baidu.swan.apps.t.a.axB().ahA();
        } else if (view.getId() == a.f.authority_item) {
            apl();
        }
    }

    private void apl() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "startSettingFragment");
        }
        f afz = afz();
        if (afz == null) {
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_open_fragment_failed_toast).aHZ();
            return;
        }
        afz.mk("navigateTo").ai(f.cQm, f.cQo).a("authority", null).commit();
        com.baidu.swan.apps.menu.a.px("permission");
    }

    public static h apm() {
        return new h();
    }
}
