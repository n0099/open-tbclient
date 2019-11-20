package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.games.i.a;
/* loaded from: classes2.dex */
public class b {
    private FullScreenFloatView bAE;

    public void a(a.c cVar, Activity activity) {
        if (activity != null && this.bAE == null) {
            if (a.a((cVar == null || cVar.bBg == null) ? null : cVar.bBg.bCA).isEnabled()) {
                U(activity);
            }
        }
    }

    private void U(final Activity activity) {
        this.bAE = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bAE.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bAE.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bAE.setAutoAttachEnable(false);
        this.bAE.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.V(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void Lu() {
            }
        });
        this.bAE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Activity activity) {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.AK() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).hi(SwanInspectorEndpoint.Xl().a(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).cv(false).b(a.h.aiapps_ok, null).Qv();
        }
    }
}
