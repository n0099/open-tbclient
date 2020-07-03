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
    private FullScreenFloatView ddM;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.ddM == null) {
            if (a.a((bVar == null || bVar.dem == null) ? null : bVar.dem.dgi).isEnabled()) {
                V(activity);
            }
        }
    }

    private void V(final Activity activity) {
        this.ddM = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.ddM.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.ddM.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.ddM.setAutoAttachEnable(false);
        this.ddM.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.W(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aiQ() {
            }
        });
        this.ddM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        e apM = e.apM();
        if (apM != null && apM.RP() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).ny(SwanInspectorEndpoint.aBQ().a(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).eY(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).apu();
        }
    }
}
