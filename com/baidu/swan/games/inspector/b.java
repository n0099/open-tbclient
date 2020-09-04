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
    private FullScreenFloatView dtI;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.dtI == null) {
            if (a.a((bVar == null || bVar.dui == null) ? null : bVar.dui.dwa).isEnabled()) {
                V(activity);
            }
        }
    }

    private void V(final Activity activity) {
        this.dtI = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.dtI.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.dtI.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.dtI.setAutoAttachEnable(false);
        this.dtI.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.W(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void arN() {
            }
        });
        this.dtI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        e azI = e.azI();
        if (azI != null && azI.XZ() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).qf(SwanInspectorEndpoint.aOm().a(resources)).a(new com.baidu.swan.apps.view.c.a()).fB(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).azp();
        }
    }
}
