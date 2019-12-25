package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.k.a;
/* loaded from: classes9.dex */
public class b {
    private FullScreenFloatView ckA;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.ckA == null) {
            if (a.a((bVar == null || bVar.clb == null) ? null : bVar.clb.cmW).isEnabled()) {
                Z(activity);
            }
        }
    }

    private void Z(final Activity activity) {
        this.ckA = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.ckA.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.ckA.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.ckA.setAutoAttachEnable(false);
        this.ckA.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.aa(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void TV() {
            }
        });
        this.ckA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Activity activity) {
        e ZS = e.ZS();
        if (ZS != null && ZS.DR() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).kr(SwanInspectorEndpoint.alX().c(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).dr(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).ZC();
        }
    }
}
