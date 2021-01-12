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
    private FullScreenFloatView efz;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.efz == null) {
            if (a.a((bVar == null || bVar.efZ == null) ? null : bVar.efZ.ehT).isEnabled()) {
                Z(activity);
            }
        }
    }

    private void Z(final Activity activity) {
        this.efz = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.efz.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.efz.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.efz.setAutoAttachEnable(false);
        this.efz.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.aa(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void azC() {
            }
        });
        this.efz.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        e aIr = e.aIr();
        if (aIr != null && aIr.afB() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).re(SwanInspectorEndpoint.aWY().g(resources)).a(new com.baidu.swan.apps.view.c.a()).gR(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aHE();
        }
    }
}
