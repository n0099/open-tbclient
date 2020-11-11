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
/* loaded from: classes10.dex */
public class b {
    private FullScreenFloatView dVZ;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.dVZ == null) {
            if (a.a((bVar == null || bVar.dWz == null) ? null : bVar.dWz.dYr).isEnabled()) {
                Y(activity);
            }
        }
    }

    private void Y(final Activity activity) {
        this.dVZ = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.dVZ.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.dVZ.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.dVZ.setAutoAttachEnable(false);
        this.dVZ.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Z(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void azD() {
            }
        });
        this.dVZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Activity activity) {
        e aHu = e.aHu();
        if (aHu != null && aHu.afO() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).rR(SwanInspectorEndpoint.aWa().a(resources)).a(new com.baidu.swan.apps.view.c.a()).gr(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aHb();
        }
    }
}
