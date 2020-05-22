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
/* loaded from: classes11.dex */
public class b {
    private FullScreenFloatView cYY;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.cYY == null) {
            if (a.a((bVar == null || bVar.cZy == null) ? null : bVar.cZy.dbv).isEnabled()) {
                V(activity);
            }
        }
    }

    private void V(final Activity activity) {
        this.cYY = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.cYY.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.cYY.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.cYY.setAutoAttachEnable(false);
        this.cYY.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.W(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void ahK() {
            }
        });
        this.cYY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        e aoF = e.aoF();
        if (aoF != null && aoF.QJ() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).nq(SwanInspectorEndpoint.aAK().a(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).eT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aon();
        }
    }
}
