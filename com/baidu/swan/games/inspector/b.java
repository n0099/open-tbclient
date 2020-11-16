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
/* loaded from: classes7.dex */
public class b {
    private FullScreenFloatView dUr;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.dUr == null) {
            if (a.a((bVar == null || bVar.dUR == null) ? null : bVar.dUR.dWJ).isEnabled()) {
                X(activity);
            }
        }
    }

    private void X(final Activity activity) {
        this.dUr = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.dUr.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.dUr.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.dUr.setAutoAttachEnable(false);
        this.dUr.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Y(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void ayV() {
            }
        });
        this.dUr.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        e aGM = e.aGM();
        if (aGM != null && aGM.afg() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).rL(SwanInspectorEndpoint.aVs().a(resources)).a(new com.baidu.swan.apps.view.c.a()).gu(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aGt();
        }
    }
}
