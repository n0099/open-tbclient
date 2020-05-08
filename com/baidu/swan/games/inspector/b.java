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
    private FullScreenFloatView cOg;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.cOg == null) {
            if (a.a((bVar == null || bVar.cOG == null) ? null : bVar.cOG.cQz).isEnabled()) {
                X(activity);
            }
        }
    }

    private void X(final Activity activity) {
        this.cOg = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.cOg.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.cOg.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.cOg.setAutoAttachEnable(false);
        this.cOg.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Y(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aez() {
            }
        });
        this.cOg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        e akM = e.akM();
        if (akM != null && akM.Ov() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).lV(SwanInspectorEndpoint.awV().a(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).akw();
        }
    }
}
