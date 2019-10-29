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
    private FullScreenFloatView bBv;

    public void a(a.c cVar, Activity activity) {
        if (activity != null && this.bBv == null) {
            if (a.a((cVar == null || cVar.bBX == null) ? null : cVar.bBX.bDr).isEnabled()) {
                U(activity);
            }
        }
    }

    private void U(final Activity activity) {
        this.bBv = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bBv.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bBv.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bBv.setAutoAttachEnable(false);
        this.bBv.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.V(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void Lt() {
            }
        });
        this.bBv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Activity activity) {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && QZ.AJ() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).hi(SwanInspectorEndpoint.Xn().a(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).cv(false).b(a.h.aiapps_ok, null).Qu();
        }
    }
}
