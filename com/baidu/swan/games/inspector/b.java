package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.l.a;
/* loaded from: classes8.dex */
public class b {
    private FullScreenFloatView eji;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.eji == null) {
            if (a.a((bVar == null || bVar.ejI == null) ? null : bVar.ejI.elB).isEnabled()) {
                T(activity);
            }
        }
    }

    private void T(final Activity activity) {
        this.eji = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.eji.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.eji.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.eji.setAutoAttachEnable(false);
        this.eji.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.U(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aAd() {
            }
        });
        this.eji.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Activity activity) {
        e aIN = e.aIN();
        if (aIN != null && aIN.agc() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).rE(SwanInspectorEndpoint.aXn().g(resources)).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aIa();
        }
    }
}
