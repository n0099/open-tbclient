package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.games.i.a;
/* loaded from: classes2.dex */
public class b {
    private FullScreenFloatView bdi;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.bdi == null) {
            if (a.a((bVar == null || bVar.bdD == null) ? null : bVar.bdD.beW).isEnabled()) {
                Q(activity);
            }
        }
    }

    private void Q(final Activity activity) {
        this.bdi = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bdi.setFloatButtonText(activity.getString(b.h.aiapps_swan_inspector_info_button));
        this.bdi.setFloatImageBackground(b.e.aiapps_float_view_button_shape);
        this.bdi.setAutoAttachEnable(false);
        this.bdi.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.R(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void DS() {
            }
        });
        this.bdi.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Activity activity) {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.uB() != null) {
            Resources resources = activity.getResources();
            new e.a(activity).d(resources.getString(b.h.aiapps_swan_inspector_info_title)).gd(SwanInspectorEndpoint.Oz().b(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(b.h.aiapps_ok, null).Iu();
        }
    }
}
