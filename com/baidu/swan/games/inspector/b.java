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
/* loaded from: classes11.dex */
public class b {
    private FullScreenFloatView cOb;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.cOb == null) {
            if (a.a((bVar == null || bVar.cOB == null) ? null : bVar.cOB.cQu).isEnabled()) {
                X(activity);
            }
        }
    }

    private void X(final Activity activity) {
        this.cOb = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.cOb.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.cOb.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.cOb.setAutoAttachEnable(false);
        this.cOb.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Y(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aeA() {
            }
        });
        this.cOb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        e akN = e.akN();
        if (akN != null && akN.Ow() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).lV(SwanInspectorEndpoint.awV().a(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).akx();
        }
    }
}
