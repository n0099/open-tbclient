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
    private FullScreenFloatView coS;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.coS == null) {
            if (a.a((bVar == null || bVar.cps == null) ? null : bVar.cps.crn).isEnabled()) {
                ab(activity);
            }
        }
    }

    private void ab(final Activity activity) {
        this.coS = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.coS.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.coS.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.coS.setAutoAttachEnable(false);
        this.coS.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.ac(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void WI() {
            }
        });
        this.coS.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(Activity activity) {
        e acF = e.acF();
        if (acF != null && acF.GE() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).kJ(SwanInspectorEndpoint.aoF().c(resources).toString()).a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).acp();
        }
    }
}
