package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.games.i.a;
/* loaded from: classes2.dex */
public class b {
    private FullScreenFloatView bdn;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.bdn == null) {
            if (a.a((bVar == null || bVar.bdI == null) ? null : bVar.bdI.bfc).isEnabled()) {
                Q(activity);
            }
        }
    }

    private void Q(final Activity activity) {
        this.bdn = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bdn.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bdn.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bdn.setAutoAttachEnable(false);
        this.bdn.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.R(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void DQ() {
            }
        });
        this.bdn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Activity activity) {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.uA() != null) {
            Resources resources = activity.getResources();
            new e.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).ge(SwanInspectorEndpoint.Ox().b(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(a.h.aiapps_ok, null).Is();
        }
    }
}
