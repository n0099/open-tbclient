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
    private FullScreenFloatView dHK;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.dHK == null) {
            if (a.a((bVar == null || bVar.dIk == null) ? null : bVar.dIk.dKc).isEnabled()) {
                Y(activity);
            }
        }
    }

    private void Y(final Activity activity) {
        this.dHK = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.dHK.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.dHK.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.dHK.setAutoAttachEnable(false);
        this.dHK.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Z(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void avj() {
            }
        });
        this.dHK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(Activity activity) {
        e aDa = e.aDa();
        if (aDa != null && aDa.abu() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).rk(SwanInspectorEndpoint.aRG().a(resources)).a(new com.baidu.swan.apps.view.c.a()).fV(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aCH();
        }
    }
}
