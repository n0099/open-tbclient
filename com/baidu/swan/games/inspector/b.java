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
/* loaded from: classes9.dex */
public class b {
    private FullScreenFloatView ehH;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.ehH == null) {
            if (a.a((bVar == null || bVar.eih == null) ? null : bVar.eih.eka).isEnabled()) {
                T(activity);
            }
        }
    }

    private void T(final Activity activity) {
        this.ehH = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.ehH.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.ehH.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.ehH.setAutoAttachEnable(false);
        this.ehH.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.U(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aAa() {
            }
        });
        this.ehH.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Activity activity) {
        e aIK = e.aIK();
        if (aIK != null && aIK.afZ() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).rx(SwanInspectorEndpoint.aXk().g(resources)).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aHX();
        }
    }
}
